package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysPara
 */
@ApiModel("系统参数表")
@Table(name = "SYS_PARA")
public class SysPara {

 	/**
     * 参数编码
     */
    @Id
    @Column(name = "PARA_CODE")
    @ApiModelProperty(value = "参数编码")
    private String paraCode;

 	/**
     * 参数名称
     */
    @Column(name = "PARA_NAME")
    @ApiModelProperty(value = "参数名称")
    private String paraName;

 	/**
     * 参数值
     */
    @Column(name = "PARA_VALUE")
    @ApiModelProperty(value = "参数值")
    private String paraValue;

 	/**
     * 参数说明
     */
    @Column(name = "PARA_DESC")
    @ApiModelProperty(value = "参数说明")
    private String paraDesc;

 	/**
     * 是否能编辑
     */
    @Column(name = "VISIABLE")
    @ApiModelProperty(value = "是否能编辑")
    private String visiable;

 	/**
     * 预留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "预留字段1")
    private String reserve1;

 	/**
     * 预留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "预留字段2")
    private String reserve2;

 	/**
     * 预留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "预留字段3")
    private String reserve3;

 	/**
     * 预留字段4
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "预留字段4")
    private String reserve4;

 	/**
     * 预留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "预留字段5")
    private String reserve5;

 	/**
     * 录入用户编号
     */
    @Column(name = "ADD_USER_ID")
    @ApiModelProperty(value = "录入用户编号")
    private String addUserId;

 	/**
     * 录入用户姓名
     */
    @Column(name = "ADD_USER_NAME")
    @ApiModelProperty(value = "录入用户姓名")
    private String addUserName;

 	/**
     * 录入时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "录入时间")
    private java.util.Date addTime;

 	/**
     * 修改用户编号
     */
    @Column(name = "MODIFY_USER_ID")
    @ApiModelProperty(value = "修改用户编号")
    private String modifyUserId;

 	/**
     * 修改用户姓名
     */
    @Column(name = "MODIFY_USER_NAME")
    @ApiModelProperty(value = "修改用户姓名")
    private String modifyUserName;

 	/**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime;


    /**
    * 获得参数编码
    * @return PARA_CODE
    */
    public String getParaCode() {
        return this.paraCode;
    }

    /**
    * 设置参数编码
    * @param paraCode
    */
    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    /**
    * 获得参数名称
    * @return PARA_NAME
    */
    public String getParaName() {
        return this.paraName;
    }

    /**
    * 设置参数名称
    * @param paraName
    */
    public void setParaName(String paraName) {
        this.paraName = paraName;
    }

    /**
    * 获得参数值
    * @return PARA_VALUE
    */
    public String getParaValue() {
        return this.paraValue;
    }

    /**
    * 设置参数值
    * @param paraValue
    */
    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }

    /**
    * 获得参数说明
    * @return PARA_DESC
    */
    public String getParaDesc() {
        return this.paraDesc;
    }

    /**
    * 设置参数说明
    * @param paraDesc
    */
    public void setParaDesc(String paraDesc) {
        this.paraDesc = paraDesc;
    }

    /**
    * 获得是否能编辑
    * @return VISIABLE
    */
    public String getVisiable() {
        return this.visiable;
    }

    /**
    * 设置是否能编辑
    * @param visiable
    */
    public void setVisiable(String visiable) {
        this.visiable = visiable;
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

    /**
    * 获得预留字段4
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置预留字段4
    * @param reserve4
    */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
    * 获得预留字段5
    * @return RESERVE5
    */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
    * 设置预留字段5
    * @param reserve5
    */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    /**
    * 获得录入用户编号
    * @return ADD_USER_ID
    */
    public String getAddUserId() {
        return this.addUserId;
    }

    /**
    * 设置录入用户编号
    * @param addUserId
    */
    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    /**
    * 获得录入用户姓名
    * @return ADD_USER_NAME
    */
    public String getAddUserName() {
        return this.addUserName;
    }

    /**
    * 设置录入用户姓名
    * @param addUserName
    */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
    * 获得录入时间
    * @return ADD_TIME
    */
    public java.util.Date getAddTime() {
        return this.addTime;
    }

    /**
    * 设置录入时间
    * @param addTime
    */
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }

    /**
    * 获得修改用户编号
    * @return MODIFY_USER_ID
    */
    public String getModifyUserId() {
        return this.modifyUserId;
    }

    /**
    * 设置修改用户编号
    * @param modifyUserId
    */
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
    * 获得修改用户姓名
    * @return MODIFY_USER_NAME
    */
    public String getModifyUserName() {
        return this.modifyUserName;
    }

    /**
    * 设置修改用户姓名
    * @param modifyUserName
    */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    /**
    * 获得修改时间
    * @return MODIFY_TIME
    */
    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    /**
    * 设置修改时间
    * @param modifyTime
    */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }


}
