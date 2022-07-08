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
import java.text.SimpleDateFormat;
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
            Map<String, String> userInfo =  userCenterProxyHelper.getUser(request);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Map<String, String> params = new HashMap<>();
            params.put("gmsfhm", hzywYbsxxb.getRepIdcard());
            params.put("name", hzywYbsxxb.getName());
            params.put("sjgsdwdm",hzywYbsxxb.getOrgCode());
            if (userInfo != null && hzywYbsxxb.getOrgCode() !=null) {
                if (hzywYbsxxb.getOrgCode().equals(userInfo.get("deptId"))) {
                    params.put("deptLevel", userInfo.get("userLevel"));
                }
            }
            params.put("orgCode",hzywYbsxxb.getOrgCode());
            params.put("dataType", hzywYbsxxb.getDataType());
            params.put("ywblzt", hzywYbsxxb.getYwblzt());
            if (hzywYbsxxb.getSlsjStart() != null && hzywYbsxxb.getSlsjEnd() !=null) {
                params.put("startDate", sdf.format(hzywYbsxxb.getSlsjStart()));
                params.put("endDate", sdf.format(hzywYbsxxb.getSlsjEnd()));
            }
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getHzywYbsxxbList",params, ResponseData.class);

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
