package com.pkusoft.jjpt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pkusoft.jjpt.controller.WebSocketSpringUser;
import com.pkusoft.jjpt.service.WebsocketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkubatis.common.constants.JjptConstantCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class WebsocketServiceImpl implements WebsocketService {

    public void noticeWebWhenConnectOut() {
        Map<String,String> messageMap = new HashMap<String,String>();
        messageMap.put("webSocketType", JjptConstantCode.WEBSOCKET_DATATYPE_0303);
        JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
        String message = transAlarmObj.toJSONString();
        for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
            try {
                //判断接收用户是否是当前发消息的用户
                WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void noticeWebWhenConnectOn() {
        Map<String,String> messageMap = new HashMap<String,String>();
        messageMap.put("webSocketType", JjptConstantCode.WEBSOCKET_DATATYPE_0304);
        JSONObject transAlarmObj =  (JSONObject) JSONObject.toJSON(messageMap);
        String message = transAlarmObj.toJSONString();
        for (String key : WebSocketSpringUser.webSocketSet.keySet()) {
            try {
                //判断接收用户是否是当前发消息的用户
                WebSocketSpringUser.webSocketSet.get(key).sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
