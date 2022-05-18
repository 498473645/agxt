package com.pkusoft.lesp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class InspectionService {

    /**
     * 回放指定设备通道的音视频录像
     * @param secret api操作密钥(
     */
    public static String getPlayback(String url,String secret,String deviceId, String channelId,String startTime,String endTime){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/api/playback/"+deviceId+"/"+channelId+"?secret="+secret+"startTime="+startTime+"endTime="+endTime;
            String result = restTemplate.getForObject(url, String.class);
            JSONObject object = JSON.parseObject(result);
            String ssrc = object.get("ssrc").toString();
            ssrc = "0"+intToHex(Integer.parseInt(ssrc));
            return ssrc;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 关闭指定ssrc的录像回放视频
     * @return
     */
    public static String stopPlayback(String url,String secret,String ssrc){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/api/playback/"+ssrc+"/stop?secret="+secret;
            Map<String, String> mapValue = new HashMap<String, String>();
            HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(mapValue);
            String result = restTemplate.postForObject(url, request,String.class);
            JSONObject object = JSON.parseObject(result);
            ssrc = object.get("ssrc").toString();
            return ssrc;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 预览指定设备通道的音视频
     * @return
     */
    public static String getSsrc(String url,String secret,String deviceId, String channelId){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/api/play/"+deviceId+"/"+channelId+"?secret="+secret;
            String result = restTemplate.getForObject(url, String.class);
            JSONObject object = JSON.parseObject(result);
            String ssrc = object.get("ssrc").toString();
            return ssrc;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 通过fork FFmpeg进程的方式拉流代理，支持任意协议
     * @return
     */
    public static String addFFmpegSource(String url,String secret,String src_url, String dst_url){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/index/api/addFFmpegSource?src_url="+src_url+"&dst_url="+dst_url+"&secret="+secret+"&timeout_ms=10000";
            String result = restTemplate.getForObject(url, String.class);
            JSONObject object = JSON.parseObject(result);
            JSONObject data = JSON.parseObject(object.get("data").toString());
            String key = data.get("key").toString();
            return key;
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 关闭指定ssrc的视频
     * @return
     */
    public static String stopSsrc(String url,String secret,String ssrc){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/api/play/"+ssrc+"/stop?secret="+secret;
            Map<String, String> mapValue = new HashMap<String, String>();
            HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(mapValue);
            String result = restTemplate.postForObject(url, request,String.class);
            JSONObject object = JSON.parseObject(result);
            ssrc = object.get("ssrc").toString();
            return ssrc;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    /**
     * 关闭ffmpeg拉流代理
     * @return
     */
    public static String delFFmpegSource(String url,String secret,String key){
        try {
            RestTemplate restTemplate = new RestTemplate();
            url=url+"/index/api/delFFmpegSource?key="+key+"&secret="+secret;
            Map<String, String> mapValue = new HashMap<String, String>();
            HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(mapValue);
            String result = restTemplate.postForObject(url, request,String.class);
            JSONObject object = JSON.parseObject(result);
            String code = object.get("code").toString();
            return code;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }


    public static String intToHex(int n) {
        StringBuilder sb = new StringBuilder(8);
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        a = sb.reverse().toString();
        return a;
    }

    public static String addStreamProxy(String url,String secret,String host,String app,String stream ,String rtmpUrl) {
        RestTemplate restTemplate = new RestTemplate();
        url=url+"/index/api/addStreamProxy?secret="+secret+"&vhost="+host+"&app="+app+"&stream="+stream+"&url="+rtmpUrl+"&rtp_type=0";
        Map<String, String> mapValue = new HashMap<String, String>();
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(mapValue);
        String result = restTemplate.postForObject(url, request,String.class);
        JSONObject object = JSON.parseObject(result);
        String key = object.getJSONObject("data").getString("key");
        return key;
    }

    public static String delStreamProxy(String url,String secret,String key) {
        RestTemplate restTemplate = new RestTemplate();
        url=url+"/index/api/delStreamProxy?secret="+secret+"&key="+key;
        Map<String, String> mapValue = new HashMap<String, String>();
        HttpEntity<Map<String, String>> request = new HttpEntity<Map<String, String>>(mapValue);
        String result = restTemplate.postForObject(url, request,String.class);
        JSONObject object = JSON.parseObject(result);
        String flag = object.getJSONObject("data").getString("flag");
        return flag;
    }
}

