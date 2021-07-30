package com.pkusoft.jjpt.service;

public interface WebsocketService {
    /**
     * 转警链接失败后，信息传送给前端，修改按钮状态为断开状态
     */
    void noticeWebWhenConnectOut();

    /**
     * 转警链接链接成功后，信息传送给前端，修改按钮状态为连接状态
     */
    void noticeWebWhenConnectOn();
}
