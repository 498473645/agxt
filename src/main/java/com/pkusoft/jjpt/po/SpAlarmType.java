package com.pkusoft.jjpt.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SP_ALARM_TYPE")
public class SpAlarmType {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键

    @Column(name = "OBJCODE")
    private String objcode;     //字典条目

    @Column(name = "OBJVALUE")
    private String objvalue;     //字典条目值

    @Column(name = "BJLBDM")
    private String bjlbdm;     //报警类别代码

    @Column(name = "BJLXDM")
    private String bjlxdm;     //报警类型代码

    @Column(name = "BJXLDM")
    private String bjxldm;     //报警细类代码

    @Column(name = "YWLXDM")
    private String ywlxdm;     //业务类型代码

    @Column(name = "DIC_LEVEL")
    private String dicLevel;     //字典级别:1-报警类别，2-报警类型，3-报警细类

    @Column(name = "DIC_VERSION")
    private String dicVersion;     //字典版本：1-老版本，2-省厅新版本，5-湖北达梦版本


    /**
    * 获得主键
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得字典条目
    * @return OBJCODE
    */
    public String getObjcode() {
        return this.objcode;
    }

    /**
    * 设置字典条目
    * @param objcode
    */
    public void setObjcode(String objcode) {
        this.objcode = objcode;
    }

    /**
    * 获得字典条目值
    * @return OBJVALUE
    */
    public String getObjvalue() {
        return this.objvalue;
    }

    /**
    * 设置字典条目值
    * @param objvalue
    */
    public void setObjvalue(String objvalue) {
        this.objvalue = objvalue;
    }

    /**
    * 获得报警类别代码
    * @return BJLBDM
    */
    public String getBjlbdm() {
        return this.bjlbdm;
    }

    /**
    * 设置报警类别代码
    * @param bjlbdm
    */
    public void setBjlbdm(String bjlbdm) {
        this.bjlbdm = bjlbdm;
    }

    /**
    * 获得报警类型代码
    * @return BJLXDM
    */
    public String getBjlxdm() {
        return this.bjlxdm;
    }

    /**
    * 设置报警类型代码
    * @param bjlxdm
    */
    public void setBjlxdm(String bjlxdm) {
        this.bjlxdm = bjlxdm;
    }

    /**
    * 获得报警细类代码
    * @return BJXLDM
    */
    public String getBjxldm() {
        return this.bjxldm;
    }

    /**
    * 设置报警细类代码
    * @param bjxldm
    */
    public void setBjxldm(String bjxldm) {
        this.bjxldm = bjxldm;
    }

    /**
    * 获得业务类型代码
    * @return YWLXDM
    */
    public String getYwlxdm() {
        return this.ywlxdm;
    }

    /**
    * 设置业务类型代码
    * @param ywlxdm
    */
    public void setYwlxdm(String ywlxdm) {
        this.ywlxdm = ywlxdm;
    }

    /**
    * 获得字典级别:1-报警类别，2-报警类型，3-报警细类
    * @return DIC_LEVEL
    */
    public String getDicLevel() {
        return this.dicLevel;
    }

    /**
    * 设置字典级别:1-报警类别，2-报警类型，3-报警细类
    * @param dicLevel
    */
    public void setDicLevel(String dicLevel) {
        this.dicLevel = dicLevel;
    }

    /**
    * 获得字典版本：1-老版本，2-省厅新版本，5-湖北达梦版本
    * @return DIC_VERSION
    */
    public String getDicVersion() {
        return this.dicVersion;
    }

    /**
    * 设置字典版本：1-老版本，2-省厅新版本，5-湖北达梦版本
    * @param dicVersion
    */
    public void setDicVersion(String dicVersion) {
        this.dicVersion = dicVersion;
    }


}