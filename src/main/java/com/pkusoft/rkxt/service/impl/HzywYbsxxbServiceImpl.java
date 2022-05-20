package com.pkusoft.rkxt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pkusoft.rkxt.model.HzywYbsxxb;
import com.pkusoft.rkxt.service.HzywYbsxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pkubatis.common.utils.FieldNotNull;
import org.support.commons.springmvc.ResponseData;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class HzywYbsxxbServiceImpl implements HzywYbsxxbService {

    @Value(value = "${HzywIp}")
    private String hzywIp;
    @Autowired
    private RestTemplate restTemplate;

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
    public ResponseData<HzywYbsxxb> getHzywYbsxxbList(String IdCard,String name) {
        try {
            Map<String, String> params = new HashMap<>();
            params.put("gmsfhm", IdCard);
            params.put("name", name);
            ResponseData response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getHzywYbsxxbList",params, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }
}
