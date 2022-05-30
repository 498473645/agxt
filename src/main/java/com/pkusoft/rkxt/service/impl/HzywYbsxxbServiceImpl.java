package com.pkusoft.rkxt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pkusoft.rkxt.model.HzywYbsxxb;
import com.pkusoft.rkxt.model.XtBizType;
import com.pkusoft.rkxt.model.XtBizTypeVo;
import com.pkusoft.rkxt.service.HzywYbsxxbService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.service.PsTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pkubatis.common.utils.FieldNotNull;
import org.support.commons.springmvc.ResponseData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.*;

@Service
@Transactional
public class HzywYbsxxbServiceImpl implements HzywYbsxxbService {

    @Value(value = "${HzywIp}")
    private String hzywIp;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;
    @Autowired
    private PsTransService psTransService;

    @Override
    public ResponseData hzywYbsxxbSave(HzywYbsxxb hzywYbsxxb) {
        try {
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/hzywYbsxxbSave",hzywYbsxxb, ResponseData.class);
           return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "同步预办事数据至人口系统异常；" + e.getMessage());
        }
    }

    @Override
    public ResponseData<HzywYbsxxb> getHzywYbsxxb(String code) {
        try {
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getHzywYbsxxb",code, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }

    @Override
    public ResponseData<HzywYbsxxb> getHzywYbsxxbList(HzywYbsxxb hzywYbsxxb,HttpServletRequest request) {
        try {
//            Map<String, String> userInfo =  userCenterProxyHelper.getUser(request);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-type", MediaType.APPLICATION_JSON_UTF8_VALUE);
//            headers.add("appToken", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcHBWZXJzaW9uIjoiMSIsImFwcFR5cGUiOiIyIiwiaXNzIjoiaGVibXBwLm9yZyIsImFwcEtleSI6IlRMekFubnNhIiwiZXhwIjoxNjE0MjE5Mzc4LCJpYXQiOjE2MTE1NDA5NzgsImFwcFpvbmUiOiIxIiwianRpIjoiZDI3NzhhMDQtYzM1OS00NGE0LTlhYjItODBkZjIwMDg0M2Y3IiwidXNlcm5hbWUiOiJsaXVjaGFvIn0.72t15EMtBmElwh7yKfbWNxPUwTgXFFI2ItRXbW3kJTA");
            Map<String, String> params = new HashMap<>();
            params.put("gmsfhm", hzywYbsxxb.getRepIdcard());
            params.put("name", hzywYbsxxb.getName());
            params.put("sjgsdwdm",hzywYbsxxb.getOrgCode());
//            HttpEntity<Map<String, String>> httpEntity = new HttpEntity<Map<String, String>>(params,headers);
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getHzywYbsxxbList",params, ResponseData.class);
//            List<Map<String,String>> list = (List<Map<String, String>>) response.getData();
//            PsTrans psTrans = null;
//            for (Map<String,String> s : list) {
//                psTrans = psTransService.getPsTrans(s.get("code"));
//                if (psTrans!=null) {
//                    s.put("code",psTrans.getCode());
//                }
//            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }

    @Override
    public ResponseData getHomeBizTypeListByCity(XtBizType bizType, HttpServletRequest request) {
        try {
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getHomeBizTypeListByCity",bizType, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }

    @Override
    public ResponseData getBizList(XtBizTypeVo xtBizTypeVo, HttpServletRequest request) {
        try {
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getBizList",xtBizTypeVo, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }
}
