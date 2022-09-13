package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysRoleUser
 */
@ApiModel("角色用户表")
@Table(name = "SYS_ROLE_USER")
public class SysRoleUser {

    /**
     * （过期）角色用户标识号
     */
    @Id
    @Column(name = "ROLE_USER_ID")
    @ApiModelProperty(value = "（过期）角色用户标识号")
    private String roleUserId;

    /**
     * 用户编号
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value = "用户编号")
    private String userId;

    /**
     * 角色编号
     */
    @Column(name = "ROLE_ID")
    @ApiModelProperty(value = "角色编号")
    private String roleId;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    @ApiModelProperty(value = "角色名称")
    private String roleName;

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
     * 获得（过期）角色用户标识号
     * @return ROLE_USER_ID
     */
    public String getRoleUserId() {
        return this.roleUserId;
    }

    /**
     * 设置（过期）角色用户标识号
     * @param roleUserId
     */
    public void setRoleUserId(String roleUserId) {
        this.roleUserId = roleUserId;
    }

    /**
     * 获得用户编号
     * @return USER_ID
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置用户编号
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获得角色编号
     * @return ROLE_ID
     */
    public String getRoleId() {
        return this.roleId;
    }

    /**
     * 设置角色编号
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


}
