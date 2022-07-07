package com.pkusoft.lesp.controller;

import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.PkuCamerasPreviewURLs;
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 * ScreenController 通往一屏展示页面的入口程序
 * </p>
 *
 * @author
 * @Date
 */
@Controller
public class ScreenController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 调用流媒体服务,通过设备id获取视屏回放参数
     * @param
     * @return
     */
    @RequestMapping("/main/getPlayback")
    @ResponseBody
    public JsonResult getPlayback(@RequestBody Map<String,String> requestMap, HttpServletRequest request) {
        try {
            String url = requestMap.get("url");
            String secret = requestMap.get("secret");
            String deviceId = requestMap.get("deviceId");
            String startTime = requestMap.get("startTime");
            String endTime = requestMap.get("endTime");


            String deviceIds = deviceId.split("/")[0];
            String channelId;

            if (deviceId.split("/").length>1) {
                channelId = deviceId.split("/")[1];

                startTime = startTime.replace("/", "-");
                endTime = endTime.replace("/", "-");

                String 	ssrc = PkuCamerasPreviewURLs.getPlayback(url, secret, deviceIds,channelId,startTime,endTime);


                String ssrcs="";
                if (null!=ssrc){
                    ssrcs = PkuCamerasPreviewURLs.intToHex(Integer.parseInt(ssrc));
                }
                String serviceIp = url.split(":")[0] + ":" + url.split(":")[1];
                String videoPa =serviceIp.replace("http", "rtmp")+"/rtp/"+ssrcs;
                String dst_url = serviceIp.replace("http", "rtmp")+"/tp/"+ssrc;
                String resultPath = serviceIp + "/tp/"+ssrc+".flv" ;
                String key = PkuCamerasPreviewURLs.addFFmpegSource(serviceIp, secret, videoPa, dst_url);
                Map<String, String> map = new HashMap<String, String>();
                map.put("ssrc", ssrc);
                map.put("key", key);
                map.put("videoPath",resultPath);
                return new JsonResult(true,resultPath,map);
        }
            return new JsonResult(false, null);
        } catch (Exception e) {
            logger.error("调用流媒体服务,通过设备id获取视屏回放参数出错", e);
            return new JsonResult(false, null);
        }
    }

    /**
     * 调用流媒体服务,通过路径获取视屏回放参数
     * @param
     * @return
     */
    @RequestMapping("/main/getMeetingFile")
    @ResponseBody
    public ResponseData getMeetingFile(@RequestBody Map<String,String> requestMap, HttpServletRequest request) {
        try {
            String serviceUrl = userCenterProxyHelper.getPara("BABS_RTMP_SERVICE_URL");
            ResponseData response = restTemplate.postForObject(serviceUrl + "/getMeetingFile",requestMap, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }

}
