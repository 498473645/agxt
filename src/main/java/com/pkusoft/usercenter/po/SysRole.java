package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysRole
 */
@ApiModel("角色表")
@Table(name = "SYS_ROLE")
public class SysRole {

    /**
     * 角色标识号
     */
    @Id
    @Column(name = "ROLE_ID")
    @ApiModelProperty(value = "角色标识号")
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 系统标识
     */
    @Column(name = "SYS_ID")
    @ApiModelProperty(value = "系统标识")
    private String sysId;

    /**
     * 系统名称
     */
    @Column(name = "SYS_NAME")
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    /**
     * （过期）角色级别
     */
    @Column(name = "ROLE_LEVEL")
    @ApiModelProperty(value = "（过期）角色级别")
    private String roleLevel;

    /**
     * 角色描述
     */
    @Column(name = "ROLE_DERC")
    @ApiModelProperty(value = "角色描述")
    private String roleDerc;

    /**
     * （过期）角色排序
     */
    @Column(name = "ORDER_FLAG")
    @ApiModelProperty(value = "（过期）角色排序")
    private Integer orderFlag;

    /**
     * 保留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "保留字段1")
    private String reserve1;

    /**
     * 保留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "保留字段2")
    private String reserve2;

    /**
     * 保留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "保留字段3")
    private String reserve3;

    /**
     * 保留字段4
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "保留字段4")
    private String reserve4;

    /**
     * 保留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "保留字段5")
    private String reserve5;

    /**
     * （过期）录入用户编号
     */
    @Column(name = "ADD_USER_ID")
    @ApiModelProperty(value = "（过期）录入用户编号")
    private String addUserId;

    /**
     * （过期）录入用户姓名
     */
    @Column(name = "ADD_USER_NAME")
    @ApiModelProperty(value = "（过期）录入用户姓名")
    private String addUserName;

    /**
     * （过期）录入时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "（过期）录入时间")
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
     * 角色状态（0.停用，1.正常）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "角色状态（0.停用，1.正常）")
    private String status;


    /**
     * 获得角色标识号
     * @return ROLE_ID
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 设置角色标识号
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获得角色名称
     * @return ROLE_NAME
     */
    public String getRoleName() {
        return this.roleName;
    }

    /**
     * 设置角色名称
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获得系统标识
     * @return SYS_ID
     */
    public String getSysId() {
        return this.sysId;
    }

    /**
     * 设置系统标识
     * @param sysId
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     * 获得系统名称
     * @return SYS_NAME
     */
    public String getSysName() {
        return this.sysName;
    }

    /**
     * 设置系统名称
     * @param sysName
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 获得（过期）角色级别
     * @return ROLE_LEVEL
     */
    public String getRoleLevel() {
        return this.roleLevel;
    }

    /**
     * 设置（过期）角色级别
     * @param roleLevel
     */
    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    /**
     * 获得角色描述
     * @return ROLE_DERC
     */
    public String getRoleDerc() {
        return this.roleDerc;
    }

    /**
     * 设置角色描述
     * @param roleDerc
     */
    public void setRoleDerc(String roleDerc) {
        this.roleDerc = roleDerc;
    }

    /**
     * 获得（过期）角色排序
     * @return ORDER_FLAG
     */
    public Integer getOrderFlag() {
        return this.orderFlag;
    }

    /**
     * 设置（过期）角色排序
     * @param orderFlag
     */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    /**
     * 获得保留字段1
     * @return RESERVE1
     */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
     * 设置保留字段1
     * @param reserve1
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
     * 获得保留字段2
     * @return RESERVE2
     */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
     * 设置保留字段2
     * @param reserve2
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
     * 获得保留字段3
     * @return RESERVE3
     */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
     * 设置保留字段3
     * @param reserve3
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
     * 获得保留字段4
     * @return RESERVE4
     */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
     * 设置保留字段4
     * @param reserve4
     */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
     * 获得保留字段5
     * @return RESERVE5
     */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
     * 设置保留字段5
     * @param reserve5
     */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    /**
     * 获得（过期）录入用户编号
     * @return ADD_USER_ID
     */
    public String getAddUserId() {
        return this.addUserId;
    }

    /**
     * 设置（过期）录入用户编号
     * @param addUserId
     */
    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    /**
     * 获得（过期）录入用户姓名
     * @return ADD_USER_NAME
     */
    public String getAddUserName() {
        return this.addUserName;
    }

    /**
     * 设置（过期）录入用户姓名
     * @param addUserName
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
     * 获得（过期）录入时间
     * @return ADD_TIME
     */
    public java.util.Date getAddTime() {
        return this.addTime;
    }

    /**
     * 设置（过期）录入时间
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

    /**
     * 获得角色状态（0.停用，1.正常）
     * @return STATUS
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置角色状态（0.停用，1.正常）
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }


}
