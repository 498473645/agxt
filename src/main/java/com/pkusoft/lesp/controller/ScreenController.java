package com.pkusoft.lesp.controller;

import com.pkusoft.bazx.po.BdCamera;
import com.pkusoft.bazx.po.BdPara;
import com.pkusoft.bazx.service.BdCameraService;
import com.pkusoft.bazx.service.BdParaService;
import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.service.BdHandlingAreaService;
import com.pkusoft.usercenter.service.SysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pkubatis.common.utils.PkuCamerasPreviewURLs;
import pkubatis.model.JsonResult;
import pkubatis.toolkit.StatusCode;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


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
    public SysDeptService sysDeptService;

    @Autowired
    private BdHandlingAreaService bdHandlingAreaService;

    @Autowired
    private BdParaService bdparaService;

    @Autowired
    private BdCameraService bdCameraService;


    /**
     * 调用流媒体服务,通过设备id获取视屏回放参数
     * @param
     * @return
     */
    @RequestMapping("/main/getPlayback")
    @ResponseBody
    public JsonResult getPlayback(@RequestBody Map<String,String> requestMap, String ssrcold, HttpServletRequest request) {
        try {
            String deviceId = requestMap.get("deviceId");
            String startTime = requestMap.get("startTime");
            String endTime = requestMap.get("endTime");
            String objId = requestMap.get("objId");
//
            BdPara secretPara = bdparaService.getParaModel("100041", objId);
            String deviceIds = deviceId.split("/")[0];
            String 	channelId = deviceIds;

            if (deviceId.split("/").length>1) {
                channelId = deviceId.split("/")[1];

                BdPara bdPara1 = bdparaService.getParaModel("100041", objId);
                startTime = startTime.replace("/", "-");
                endTime = endTime.replace("/", "-");
                // 视频时间与业务时间有误差时
                if (bdPara1.getMemo()!=null) {
                    if (bdPara1.getMemo().split("/").length>1) {
                        String time = bdPara1.getMemo().split("/")[1];
                        int timeInt = Integer.parseInt(time);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date dateStart = simpleDateFormat.parse(startTime);
                        Date dateEnd = simpleDateFormat.parse(endTime);

                        Calendar calendarStart = Calendar.getInstance();
                        calendarStart.setTime(dateStart);
                        calendarStart.add(Calendar.SECOND, timeInt);
                        startTime = simpleDateFormat.format(calendarStart.getTime());

                        Calendar calendarEnd = Calendar.getInstance();
                        calendarEnd.setTime(dateEnd);
                        calendarEnd.add(Calendar.SECOND, timeInt);
                        endTime= simpleDateFormat.format(calendarEnd.getTime());

                    }
                }
                String 	ssrc = PkuCamerasPreviewURLs.getPlayback(secretPara.getParaValue1(), secretPara.getParaValue2(), deviceIds,channelId,startTime,endTime);


                String ssrcs="";
                if (null!=ssrc){
                    ssrcs = PkuCamerasPreviewURLs.intToHex(Integer.parseInt(ssrc));
                }
                String videoPath =secretPara.getParaValue3()+"/rtp/"+ssrcs+".flv" ;
                String videoPa =secretPara.getParaValue3().replace("http", "rtmp")+"/rtp/"+ssrcs;
                String dst_url = secretPara.getParaValue3().replace("http", "rtmp")+"/tp/"+ssrc;
                String resultPath = secretPara.getParaValue3()+"/tfp/"+ssrc+".flv" ;
                String key = PkuCamerasPreviewURLs.addFFmpegSource(secretPara.getParaValue3(), secretPara.getParaValue2(), videoPa, dst_url);
                Map<String, String> map = new HashMap<String, String>();
                map.put("ssrc", ssrc);
                map.put("key", key);
                return new JsonResult(true,resultPath,map);
            }
            return new JsonResult(false, "通过设备id获取视屏播放参数出错");
        } catch (Exception e) {
            logger.error("调用流媒体服务,通过设备id获取视屏回放参数出错", e);
            return new JsonResult(false, "通过设备id获取视屏播放参数出错");
        }
    }

    /**
     * 关闭指定ssrc的录像回放视频
     * @param
     * @return
     */
    @RequestMapping("/main/stopPlayback")
    @ResponseBody
    public JsonResult stopPlayback(String deptId,String ssrcold,HttpServletRequest request) {
        try {
            BdHandlingArea bdHandlingArea = bdHandlingAreaService.getBdHandlingAreaByDeptId(deptId);
            if (bdHandlingArea != null ) {
                BdPara secretPara = bdparaService.getParaModel("100041", bdHandlingArea.getObjid());
                if (null!=secretPara&&StringUtils.hasText(secretPara.getParaValue1())&&StringUtils.hasText(secretPara.getParaValue2())) {
                    ssrcold = PkuCamerasPreviewURLs.stopPlayback(secretPara.getParaValue1(), secretPara.getParaValue2(), ssrcold);
                    return new JsonResult(true,ssrcold);
                }
            }
            return new JsonResult(false, null);
        } catch (Exception e) {
            logger.error("关闭指定ssrc的录像回放视频出错", e);
            return new JsonResult(false, null);
        }
    }

}
