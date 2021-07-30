package com.pkusoft.jjpt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pkusoft.jjpt.service.HadoopService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import pkubatis.common.utils.FieldNotNull;
import pkubatis.toolkit.Base64Helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class HadoopServiceImpl implements HadoopService {


    @Autowired
    private RestTemplate restTemplate;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Value(value = "${dfs.hadoopUrl}")
    private String hadoopUrl;

    public String hadoopUpload(String base64Str){
        try {
            MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<>();
            String reqUrl = "";
            if (StringUtils.hasText(hadoopUrl)){
                reqUrl = hadoopUrl;
            }else {
                reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
            }
            if (!StringUtils.hasText(reqUrl)){
                return "reqUrl";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            Date date = new Date();
            String time = sdf.format(date);
            String recUUID = UUID.randomUUID().toString();
            String hadoopPrefix = userCenterProxyHelper.getPara("Hadoop_Prefix");
            String srcString= hadoopPrefix+"/jjpt/"+time+"/"+recUUID+".jpg";
            requestData.add("filePath", srcString);
            requestData.add("base64", base64Str);
            //JsonResult response = restTemplate.postForObject(sysPara.getParaValue()+"/createDatumReturnFilenameFlase", request, JsonResult.class);
            String response = restTemplate.postForObject(reqUrl+"/createDatum", requestData, String.class);
            JSONObject jsonObject = JSONArray.parseObject(response);
            String statusCode = FieldNotNull.stringisNull(jsonObject.get("statusCode"));
            if ("00".equals(statusCode)) {
                return srcString;
            }else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String hadoopFileUpload(String base64Str){
        try {
            MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<>();
            byte[] contents = Base64Helper.hex2byte(base64Str);
            ByteArrayResource byteArray = new ByteArrayResource(contents){
                public String getFilename() {
                    return "";
                }
            };
            String reqUrl = "";
            if (StringUtils.hasText(hadoopUrl)){
                reqUrl = hadoopUrl;
            }else {
                reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
            }
            if (!StringUtils.hasText(reqUrl)){
                return "reqUrl";
            }
            requestData.add("file", byteArray);
            String response = restTemplate.postForObject(reqUrl+"/upload", requestData, String.class);
            JSONObject jsonObject = JSONArray.parseObject(response);
            String statusCode = FieldNotNull.stringisNull(jsonObject.get("statusCode"));
            if ("00".equals(statusCode)) {
                return FieldNotNull.stringisNull(jsonObject.get("data"));
            }else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
