package com.pkusoft.jjpt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pkusoft.jjpt.po.SpCallRecord;
import com.pkusoft.jjpt.req.SpCallRecordReqParam;
import com.pkusoft.jjpt.service.SpCallRecordService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.FieldNotNull;
import pkubatis.toolkit.Base64Helper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
* 业务数据_通话记录表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpCallRecordController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpCallRecordController.class);

    @Autowired
    private SpCallRecordService spCallRecordService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Value(value = "${dfs.hadoopUrl}")
    private String hadoopUrl;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询接警平台通话记录表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台通话记录表", notes = "查询接警平台通话记录表", httpMethod = "POST")
    @RequestMapping("/spCallRecord/spCallRecordList")
    @ResponseBody
    public ResponseData<List<SpCallRecord>> spCallRecordList(HttpServletRequest request, @RequestBody SpCallRecordReqParam spCallRecord){
        ResponseDto<List<SpCallRecord>> dto = new ResponseDto<List<SpCallRecord>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpCallRecord> list = spCallRecordService.getSpCallRecordList(spCallRecord,user);
            int count = spCallRecordService.getSpCallRecordCount(spCallRecord,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            String distUrl = "";
            if (StringUtils.hasText(hadoopUrl)){
                distUrl = hadoopUrl;
            }else {
                distUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
            }
            dto.setStatusMsg(distUrl+"/download?path=");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台通话记录表错误"+e.getMessage());
        }
    }

    /**
     * 接警大屏-查询来电列表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "接警大屏-查询来电列表", notes = "接警大屏-查询来电列表", httpMethod = "POST")
    @RequestMapping("/spCallRecord/getActiveCallRecordList")
    @ResponseBody
    public ResponseData<List<SpCallRecord>> getActiveCallRecordList(HttpServletRequest request, @RequestBody SpCallRecordReqParam spCallRecord){
        ResponseDto<List<SpCallRecord>> dto = new ResponseDto<List<SpCallRecord>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpCallRecord> list = spCallRecordService.getActiveCallRecordList(spCallRecord,user);
//            int ycl = spCallRecordService.getActiveCallRecordCount(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010,user);
//            int wcl = spCallRecordService.getActiveCallRecordCount(JjptConstantCode.IF_CALL_CLOSE_STATUS_1010,user);
            dto.setData(list);
//            dto.setCount(wcl);
//            dto.setStatusMsg(""+ycl);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台通话记录表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台通话记录表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台通话记录表", notes = "新增或修改接警平台通话记录表", httpMethod = "POST")
    @RequestMapping("/spCallRecord/spCallRecordSaveOrUpdate")
    @ResponseBody
    public ResponseData<SpCallRecord> spCallRecordSaveOrUpdate(@RequestBody SpCallRecord spCallRecord, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spCallRecord.getObjid())) {
                //添加接警平台通话记录表
                num = spCallRecordService.spCallRecordSave(spCallRecord, user);
            }else{
                //修改接警平台通话记录表
                num = spCallRecordService.spCallRecordUpdate(spCallRecord, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spCallRecord);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台通话记录表错误"+e.getMessage());
        }
    }

    /**
     * 稍后录入：在闭环警情的同时，生成一条无报警数据的接警数据
     * @return
     */
    @ApiOperation(value = "稍后录入", notes = "稍后录入", httpMethod = "POST")
    @RequestMapping("/spCallRecord/laterHandlePolice")
    @ResponseBody
    public ResponseData<String> laterHandlePolice(@RequestBody SpCallRecord spCallRecord, HttpServletRequest request){
        try {
            if (!StringUtils.hasText(spCallRecord.getObjid())){
                return new ResponseData<String>(ResponseData.STATUS_CODE_PARAM,"电话主键id不能为空");
            }
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            num = spCallRecordService.laterHandlePolice(spCallRecord, user);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台通话记录表错误"+e.getMessage());
        }
    }

    /**
     * 无效报警：在闭环电话的同时，生成一条接警数据和处警数据
     * @return
     */
    @ApiOperation(value = "无效报警", notes = "无效报警", httpMethod = "POST")
    @RequestMapping("/spCallRecord/noUseCallRecord")
    @ResponseBody
    public ResponseData<String> noUseCallRecord(@RequestBody SpCallRecordReqParam spCallRecord, HttpServletRequest request){
        try {
            if (!StringUtils.hasText(spCallRecord.getObjid())){
                return new ResponseData<String>(ResponseData.STATUS_CODE_PARAM,"电话主键id不能为空");
            }
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            num = spCallRecordService.noUseCallRecord(spCallRecord, user);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台通话记录表错误"+e.getMessage());
        }
    }

    /**
     * 查看固定时间内是否已来电过
     * @return
     */
    @ApiOperation(value = "查看固定时间内是否已来电过", notes = "查看固定时间内是否已来电过", httpMethod = "POST")
    @RequestMapping("/spCallRecord/ifAlreadyCalledWithinTime")
    @ResponseBody
    public ResponseData<SpCallRecord> ifAlreadyCalledWithinTime(@RequestBody Map map) {
        String ldhm = (String) map.get("ldhm");
        String time = (String) map.get("withinTime");
        if (!StringUtils.hasText(ldhm)||!StringUtils.hasText(time)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spCallRecordService.ifAlreadyCalledWithinTime(ldhm,time);
            if (num>0) {
                return new ResponseData<SpCallRecord>(ResponseData.STATUS_CODE_SUCCESS,"有来电");
            }
            return new ResponseData<SpCallRecord>(ResponseData.STATUS_CODE_OTHER,"无来电");
        }catch (Exception e){
            logger.error("查看接警平台通话记录表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台通话记录表详情错误:"+e.getMessage());
        }
    }

    /**
     * 查看接警平台通话记录表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台通话记录表详情", notes = "查看接警平台通话记录表详情", httpMethod = "POST")
    @RequestMapping("/spCallRecord/spCallRecordModel")
    @ResponseBody
    public ResponseData<SpCallRecord> spCallRecordModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpCallRecord spCallRecord = spCallRecordService.getSpCallRecord(objid);
            return new ResponseData<SpCallRecord>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spCallRecord);
        }catch (Exception e){
            logger.error("查看接警平台通话记录表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台通话记录表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台通话记录表
     * @return
     */
    @ApiOperation(value = "删除接警平台通话记录表", notes = "删除接警平台通话记录表", httpMethod = "POST")
    @RequestMapping("/spCallRecord/spCallRecordDelete")
    @ResponseBody
    public ResponseData<String> spCallRecordDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spCallRecordService.spCallRecordDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台通话记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台通话记录表错误:"+e.getMessage());
        }
    }

    /**
     * 录音上传
     * @param spCallRecord
     * @param objid
     * @param request
     * @return
     */
    @ApiOperation(value = "录音上传", notes = "录音上传接口", httpMethod = "POST")
    @RequestMapping("/spCallRecord/getTelRecordingAndUpload")
    @ResponseBody
    public ResponseData<String> getTelRecordingAndUpload(@RequestBody SpCallRecord spCallRecord, String objid, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            final String userDept = user.get("deptId");
            if(StringUtils.hasText(spCallRecord.getObjid())){

                MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<>();
                byte[] contents = Base64Helper.hex2byte(spCallRecord.getRecordFilepath());
                //int digitFilesize=contents.length;
                ByteArrayResource byteArray = new ByteArrayResource(contents){
                    public String getFilename() {
                        return "";
                    }
                };
                String reqUrl = "";
                if (StringUtils.hasText(hadoopUrl)){
                    reqUrl = hadoopUrl;
                }else {
                    String hadoopUrlNew= userCenterProxyHelper.getPara("HadoopUrlNew");
                    if (StringUtils.hasText(hadoopUrlNew)){
                        reqUrl = hadoopUrlNew;
                    }
                }
                requestData.add("file", byteArray);
                //上传线程控制
                final String hadoopUrl = reqUrl;
                final SpCallRecord spCallRecordData = spCallRecord;
                final MultiValueMap<String, Object> dataContent = requestData;
                final Map<String, String> userData = user;
                Thread t1 = new Thread(){
                    public void run(){
                        try {
                            String response = restTemplate.postForObject(hadoopUrl+"/upload", dataContent, String.class);
                            JSONObject jsonObject = JSONArray.parseObject(response);
                            String statusCode = FieldNotNull.stringisNull(jsonObject.get("statusCode"));
                            if ("00".equals(statusCode)) {
                                String strFilePath = FieldNotNull.stringisNull(jsonObject.get("data"));
                                spCallRecordData.setRecordFilepath(strFilePath);
                                spCallRecordService.spCallRecordUpdate(spCallRecordData,userData);
//                                // 刷新接警列表
//                                Map<String,String> messageMap = new HashMap<String,String>();
//                                messageMap.put("webSocketType",FieldNotNull.WEBSOCKET_DATATYPE_0401);
//                                JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
//                                String message = transAlarmObj.toJSONString();
//                                for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
//                                    try {
//                                        //判断接收用户是否是当前发消息的用户
//                                        if (key.endsWith(userDept)){
//                                            WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
//                                        }
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error("录音上传错误",e);
                        }
                    }
                };
                t1.start();
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }else{
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"主键id不能为空");
            }
        }catch (Exception e) {
            logger.error("录音上传错误",e);
            e.printStackTrace();
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"保存失败");
        }
    }
}
