package pkubatis.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class TokenUtil {

    public static final String url = "http://26.3.14.217:7000/pangu/datacenter/api/commonapi";


    /**
     * 获取token
     * @return
     */
    public static String getToken() {
        RestTemplate restTemplate = new RestTemplate();
        String res = restTemplate.getForObject(url+"/getToken?appId=APPID20211125174003",String.class);
        Map<String, String> map = (Map<String, String>) JSON.parse(res);
        return map.get("content");
    }
    /**
     * 获取数据
     * @return
     */
    public static Map<String, Object> getData(String api,Map<String, Object> map) {
    	String token = TokenUtil.getToken();
    	RestTemplate restTemplate = new RestTemplate();
    	String s = JSON.toJSONString(map);
    	JSONObject jsonObject = JSONObject.parseObject(s);
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Authorization-Token", token);
    	headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    	HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
    	Map<String, Object> res = restTemplate.exchange(url+"/saveOrUpdateBatch"+api, HttpMethod.POST,entity,Map.class).getBody();
        return res;
    }



}
