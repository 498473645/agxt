package com.pkusoft.jjpt.controller;

import com.alibaba.fastjson.JSONObject;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.constants.JjptConstantCode;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
* WebSocket 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class WebSocketController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(WebSocketController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 保存成功后通过websocket刷新所有人的接警列表
     * @return
     */
    @ApiOperation(value = "保存成功后通过websocket刷新所有人的接警列表", notes = "保存成功后通过websocket刷新所有人的接警列表接口", httpMethod = "POST")
    @RequestMapping("/websocket/refreshAllUserAlarmList")
    @ResponseBody
    public ResponseData<String> refreshAllUserAlarmList(HttpServletRequest request) {
        try{
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String userDept = user.get("deptId");
            Map<String,String> messageMap = new HashMap<String,String>();
            messageMap.put("webSocketType",JjptConstantCode.WEBSOCKET_DATATYPE_0102);
            JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
            String message = transAlarmObj.toJSONString();
            for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
                try {
                    //判断接收用户是否是当前发消息的用户，如果是本单位的，才可以刷新，用endsWith判断是否本单位，因为websocket用户格式是“ip@userDeptId”
                    if (key.endsWith(userDept)){
                        WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
        }catch (Exception e){
            logger.error("保存成功后通过websocket刷新所有人的接警列表错误",e);
            e.printStackTrace();
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }
    }

    /**
     * 转警按钮点击后，修改当前单位所有人的页面上的转警按钮状态
     * @return
     */
    @ApiOperation(value = "转警接受后修改所有转警按钮状态", notes = "转警接受后修改所有转警按钮状态接口", httpMethod = "POST")
    @RequestMapping("/websocket/changeTransAlarmStatusAfterBeAccept")
    @ResponseBody
    public ResponseData<String> changeTransAlarmStatusAfterBeAccept(HttpServletRequest request) {
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String userDept = user.get("deptId");
            Map<String,String> messageMap = new HashMap<String,String>();
            messageMap.put("webSocketType",JjptConstantCode.WEBSOCKET_DATATYPE_0302);
            JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
            String message = transAlarmObj.toJSONString();
            for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
                try {
                    //判断接收用户是否是当前发消息的用户
//                    WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
                    if (key.endsWith(userDept)){
                        WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
        }catch (Exception e){
            logger.error("转警接受后修改所有转警按钮状态错误",e);
            e.printStackTrace();
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }
    }

    /**
     * 电话保存成功后通过websocket刷新所有人的电话
     * @return
     */
    @ApiOperation(value = "电话保存成功后通过websocket刷新所有人的电话", notes = "电话保存成功后通过websocket刷新所有人的电话列表接口", httpMethod = "POST")
    @RequestMapping("/websocket/refreshAllUserCallList")
    @ResponseBody
    public ResponseData<String> refreshAllUserCallList(HttpServletRequest request) {
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String userDept = user.get("deptId");
            Map<String,String> messageMap = new HashMap<String,String>();
            messageMap.put("webSocketType", JjptConstantCode.WEBSOCKET_DATATYPE_0401);
            JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
            String message = transAlarmObj.toJSONString();
            for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
                try {
                    //判断接收用户是否是当前发消息的用户
                    if (key.endsWith(userDept)){
                        WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
        }catch (Exception e){
            logger.error("电话保存成功后通过websocket刷新所有人的电话列表错误",e);
            e.printStackTrace();
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }
    }

}
