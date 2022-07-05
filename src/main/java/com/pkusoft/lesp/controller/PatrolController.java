package com.pkusoft.lesp.controller;

import com.pkusoft.bazx.po.BdCamera;
import com.pkusoft.bazx.po.BdPara;
import com.pkusoft.lesp.po.RsJbjSxtxx;
import com.pkusoft.lesp.service.RsJbjSxtxxService;
import com.pkusoft.lesp.service.impl.InspectionService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.PkuCamerasPreviewURLs;
import pkubatis.toolkit.StatusCode;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 动态
 */
@Controller
public class PatrolController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    @Autowired
    private RsJbjSxtxxService rsJbjSxtxxService ;

    /**
     * 巡查----获取单位列表
     * @return
     */
    @ApiOperation(value = "巡查----获取单位列表", notes = "巡查----获取单位列表", httpMethod = "POST")
    @RequestMapping("/patrol/getDeptList")
    @ResponseBody
    public ResponseData<List<RsJbjSxtxx>> getDeptList(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<Map<String,Object>> dto = new ResponseDto<Map<String,Object>>();
        try{
            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
//            String deptId = map.get("depts");
//            if (!StringUtils.hasText(deptId)){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
//            }

            List<RsJbjSxtxx> data = rsJbjSxtxxService.getDeptList(map);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 巡查----获取摄像头信息列表
     * @return
     */
    @ApiOperation(value = "巡查----获取摄像头信息列表", notes = "巡查----获取摄像头信息列表", httpMethod = "POST")
    @RequestMapping("/patrol/getCameraList")
    @ResponseBody
    public ResponseData<List<Map<String,Object>>> getCameraList(@RequestBody Map<String,String> map, HttpServletRequest request){
//        ResponseDto<Map<String,Object>> dto = new ResponseDto<Map<String,Object>>();
        try{
            String deptId = map.get("depts");
            String isBabs = map.get("isBabs");
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }

            List<Map<String,Object>> data = rsJbjSxtxxService.getCameraList(deptId, isBabs);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 调用流媒体服务,通过设备id获取视屏播放参数
     * @param
     * @param requestMap
     * @param
     * @return
     */
    @ApiOperation(value = "调用流媒体服务,通过设备id获取视屏播放参数", notes = "调用流媒体服务,通过设备id获取视屏播放参数", httpMethod = "POST")
    @RequestMapping("/patrol/getRtmpUrl")
    @ResponseBody
    public ResponseData<Map<String,String>> getRtmpUrl(@RequestBody Map<String,String> requestMap) {
        try {
            // 判断是否新国标
            String rtsp =  requestMap.get("isRtsp");
            String deviceId = requestMap.get("deviceId");
            String lmtApi =requestMap.get("lmtApi");  //v1
            String secret = requestMap.get("secret");  //v2
            String serviceIp = requestMap.get("serviceIp");  //v3
            if ("1".equals(rtsp)){
                //String deviceIds ="1|1|rtsp://admin:abc123456@127.0.0.1";
                //String lmtApi ="http://26.152.1.110:8085";
                //String secret = "pf4y18do-dv20-ti4x-x94j-2zehkuk2sttl";
                //String lmtIp = "http://26.152.1.110";*/
                String[] deviceIds = deviceId.split("[|]");
                String app = deviceIds[0];
                String stream = deviceIds[1];
                String rtmpUrl = deviceIds[2];
                String key = InspectionService.addStreamProxy(lmtApi,secret,serviceIp,app,stream,rtmpUrl);
                // videoPath
                String videoPath= lmtApi+"/"+ app + "/" +stream + ".flv";
                Map<String, String> map = new HashMap<String, String>();
                String str= "/rtp_" + stream;
                //String str= ""+new Date().getTime();
                String dst_url = lmtApi.replace("http", "rtmp")+"/stp_"+app + str;
                String keys = InspectionService.addFFmpegSource(lmtApi, secret, videoPath, dst_url);
                String ply_url= lmtApi+"/stp_" + app + str+".flv";
                map.put("ssrc", key);
                map.put("videoPath",ply_url);
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"通过设备id获取视屏播放参数成功",map);
            }else{
                //String deviceIds ="34020000001320000001/34020000001320000002";
                String[] deviceIds = deviceId.split("[/]");
                String deviceCode = deviceIds[0];  //设备编号
                String channelId = deviceIds[1];   // 通道号
                String 	ssrc = InspectionService.getSsrc(lmtApi, secret, deviceCode,channelId);
                String ssrcs="";
                if (null!=ssrc){
                    ssrcs = InspectionService.intToHex(Integer.parseInt(ssrc));
                    if (ssrcs.length()==7) {
                        ssrcs= "0"+ssrcs;
                    }
                }

                String videoPa =serviceIp.replace("http", "rtmp")+"/rtp/"+ssrcs;
                String dst_url = serviceIp.replace("http", "rtmp")+"/tp/"+ssrc;
                String resultPath = serviceIp+"/tp/"+ssrc+".flv" ;


                String key = InspectionService.addFFmpegSource(serviceIp, secret, videoPa, dst_url);
                Map<String, String> map = new HashMap<String, String>();
                map.put("ssrc", ssrc);
                map.put("key", key);
                map.put("videoPath",resultPath);
//                jessibuca播放器
//                String play_url = serviceIp  +"/rtp/"+ssrcs + ",flv";
//                map.put("videoPath",play_url);
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"通过设备id获取视屏播放参数成功",map);
            }
        } catch (Exception e) {
            logger.error("调用流媒体服务,通过设备id获取视屏播放参数出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"通过设备id获取视屏播放参数出错");
        }
    }

    /**
     * 调用流媒体服务,通过设备id获取视屏回放参数
     * @param
     * @return
     */
    @RequestMapping("/patrol/getPlayback")
    @ResponseBody
    public ResponseData<Map<String,String>> getPlayback(@RequestBody Map<String,String> requestMap) {
        try {
            String deviceId = requestMap.get("deviceId");
            String lmtApi =requestMap.get("lmtApi");  //v1
            String secret = requestMap.get("secret");  //v2
            String serviceIp = requestMap.get("serviceIp");  //v3
            String startTime = requestMap.get("startTime");
            String endTime = requestMap.get("endTime");

            String deviceIds = deviceId.split("/")[0];
            String channelId = "";   // 通道号
            Map<String, String> map = null;
            if (deviceId.split("/").length > 1) {
                channelId = deviceId.split("/")[1];
                startTime = startTime.replace("/", "-");
                endTime = endTime.replace("/", "-");
//                // 视频时间与业务时间有误差时
//                if (bdPara1.getMemo().split("/").length>1) {
//                    String time = bdPara1.getMemo().split("/")[1];
//                    int timeInt = Integer.parseInt(time);
//
//                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date dateStart = simpleDateFormat.parse(startTime);
//                    Date dateEnd = simpleDateFormat.parse(endTime);
//
//                    Calendar calendarStart = Calendar.getInstance();
//                    calendarStart.setTime(dateStart);
//                    calendarStart.add(Calendar.SECOND, timeInt);
//                    startTime = simpleDateFormat.format(calendarStart.getTime());
//
//                    Calendar calendarEnd = Calendar.getInstance();
//                    calendarEnd.setTime(dateEnd);
//                    calendarEnd.add(Calendar.SECOND, timeInt);
//                    endTime= simpleDateFormat.format(calendarEnd.getTime());
//
//                }
                String ssrc = PkuCamerasPreviewURLs.getPlayback(lmtApi, secret, deviceIds, channelId, startTime, endTime);

                String ssrcs = "";
                if (null != ssrc) {
                    ssrcs = PkuCamerasPreviewURLs.intToHex(Integer.parseInt(ssrc));
                }
                String videoPa = serviceIp.replace("http", "rtmp") + "/rtp/" + ssrcs;
                String dst_url = serviceIp.replace("http", "rtmp") + "/tp/" + ssrc;
                String resultPath = serviceIp + "/tp/" + ssrc + ".flv";
                String key = InspectionService.addFFmpegSource(serviceIp, secret, videoPa, dst_url);
                map = new HashMap<String, String>();
                map.put("ssrc", ssrc);
                map.put("key", key);
                map.put("videoPath", resultPath);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"通过设备id获取视屏播放参数成功",map);
        } catch (Exception e) {
            logger.error("调用流媒体服务,通过设备id获取视屏播放参数出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"通过设备id获取视屏播放参数出错");
        }
    }
}
