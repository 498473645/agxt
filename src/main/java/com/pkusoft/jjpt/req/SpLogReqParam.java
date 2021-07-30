package com.pkusoft.jjpt.req;

import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SP_LOG")
public class SpLogReqParam extends Page {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "JJDBH")
    private String jjdbh;     //接警单编号

    @Column(name = "JJD_OBJID")
    private String jjdObjid;     //SpJjxx.OBJID

    @Column(name = "TYPE")
    private String type;     //接口类型(01 请求接口 ; 02 被请求接口)

    @Column(name = "URL")
    private String url;     //请求地址及接口信息

    @Column(name = "REQ")
    private String req;     //请求参数

    @Column(name = "RES")
    private String res;     //返回信息

    @Column(name = "LOG_TIME")
    private Date logTime;     //记录日志时间

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2

    @Column(name = "RESERVE3")
    private String reserve3;     //预留字段3


    /**
    * 获得主键ID
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键ID
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得接警单编号
    * @return JJDBH
    */
    public String getJjdbh() {
        return this.jjdbh;
    }

    /**
    * 设置接警单编号
    * @param jjdbh
    */
    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    /**
    * 获得SpJjxx.OBJID
    * @return JJD_OBJID
    */
    public String getJjdObjid() {
        return this.jjdObjid;
    }

    /**
    * 设置SpJjxx.OBJID
    * @param jjdObjid
    */
    public void setJjdObjid(String jjdObjid) {
        this.jjdObjid = jjdObjid;
    }

    /**
    * 获得接口类型(01 请求接口 ; 02 被请求接口)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置接口类型(01 请求接口 ; 02 被请求接口)
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得请求地址及接口信息
    * @return URL
    */
    public String getUrl() {
        return this.url;
    }

    /**
    * 设置请求地址及接口信息
    * @param url
    */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
    * 获得请求参数
    * @return REQ
    */
    public String getReq() {
        return this.req;
    }

    /**
    * 设置请求参数
    * @param req
    */
    public void setReq(String req) {
        this.req = req;
    }

    /**
    * 获得返回信息
    * @return RES
    */
    public String getRes() {
        return this.res;
    }

    /**
    * 设置返回信息
    * @param res
    */
    public void setRes(String res) {
        this.res = res;
    }

    /**
    * 获得记录日志时间
    * @return LOG_TIME
    */
    public Date getLogTime() {
        return this.logTime;
    }

    /**
    * 设置记录日志时间
    * @param logTime
    */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
    * 获得预留字段1
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置预留字段1
    * @param reserve1
    */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
    * 获得预留字段2
    * @return RESERVE2
    */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
    * 设置预留字段2
    * @param reserve2
    */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
    * 获得预留字段3
    * @return RESERVE3
    */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
    * 设置预留字段3
    * @param reserve3
    */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }


}