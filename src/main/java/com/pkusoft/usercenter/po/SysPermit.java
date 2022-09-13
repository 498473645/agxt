package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysPermit
 */
@ApiModel("数据权限表")
@Table(name = "SYS_PERMIT")
public class SysPermit {

    /**
     * 数据权限标识号
     */
    @Id
    @Column(name = "PERMIT_ID")
    @ApiModelProperty(value = "数据权限标识号")
    private String permitId;

    /**
     * 数据权限名称
     */
    @Column(name = "PERMIT_NAME")
    @ApiModelProperty(value = "数据权限名称")
    private String permitName;

    /**
     * 数据权限值
     */
    @Column(name = "PERMIT_VALUE")
    @ApiModelProperty(value = "数据权限值")
    private String permitValue;

    /**
     * 数据权限类别编码
     */
    @Column(name = "PERMIT_CODE")
    @ApiModelProperty(value = "数据权限类别编码")
    private String permitCode;

    /**
     * 数据权限类别名称
     */
    @Column(name = "PERMIT_CODE_NAME")
    @ApiModelProperty(value = "数据权限类别名称")
    private String permitCodeName;

    /**
     * 描述
     */
    @Column(name = "PERMIT_DESC")
    @ApiModelProperty(value = "描述")
    private String permitDesc;

    /**
     * 排序
     */
    @Column(name = "ORDER_FLAG")
    @ApiModelProperty(value = "排序")
    private Integer orderFlag;

    /**
     * 所属系统ID
     */
    @Column(name = "SYS_ID")
    @ApiModelProperty(value = "所属系统ID")
    private String sysId;

    /**
     * 所属系统名称
     */
    @Column(name = "SYS_NAME")
    @ApiModelProperty(value = "所属系统名称")
    private String sysName;

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
     * 用户单位ID
     */
    @Column(name = "MODIFY_USER_DEPT_ID")
    @ApiModelProperty(value = "用户单位ID")
    private String modifyUserDeptId;

    /**
     * 用户单位名称
     */
    @Column(name = "MODIFY_USER_DEPT_NAME")
    @ApiModelProperty(value = "用户单位名称")
    private String modifyUserDeptName;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime;

    /**
     * 备用字段
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "备用字段")
    private String reserve1;

    /**
     * 备用字段
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "备用字段")
    private String reserve2;

    /**
     * 备用字段
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "备用字段")
    private String reserve3;

    /**
     * 备用字段
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "备用字段")
    private String reserve4;

    /**
     * 备用字段
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "备用字段")
    private String reserve5;

    /**
     * 是否选中=>后台使用，不需要存数据
     */
    @Column(name = "IS_CHECKED")
    @ApiModelProperty(value = "是否选中=>后台使用，不需要存数据")
    private String isChecked;


    /**
     * 获得数据权限标识号
     * @return PERMIT_ID
     */
    public String getPermitId() {
        return this.permitId;
    }

    /**
     * 设置数据权限标识号
     * @param permitId
     */
    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    /**
     * 获得数据权限名称
     * @return PERMIT_NAME
     */
    public String getPermitName() {
        return this.permitName;
    }

    /**
     * 设置数据权限名称
     * @param permitName
     */
    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    /**
     * 获得数据权限值
     * @return PERMIT_VALUE
     */
    public String getPermitValue() {
        return this.permitValue;
    }

    /**
     * 设置数据权限值
     * @param permitValue
     */
    public void setPermitValue(String permitValue) {
        this.permitValue = permitValue;
    }

    /**
     * 获得数据权限类别编码
     * @return PERMIT_CODE
     */
    public String getPermitCode() {
        return this.permitCode;
    }

    /**
     * 设置数据权限类别编码
     * @param permitCode
     */
    public void setPermitCode(String permitCode) {
        this.permitCode = permitCode;
    }

    /**
     * 获得数据权限类别名称
     * @return PERMIT_CODE_NAME
     */
    public String getPermitCodeName() {
        return this.permitCodeName;
    }

    /**
     * 设置数据权限类别名称
     * @param permitCodeName
     */
    public void setPermitCodeName(String permitCodeName) {
        this.permitCodeName = permitCodeName;
    }

    /**
     * 获得描述
     * @return PERMIT_DESC
     */
    public String getPermitDesc() {
        return this.permitDesc;
    }

    /**
     * 设置描述
     * @param permitDesc
     */
    public void setPermitDesc(String permitDesc) {
        this.permitDesc = permitDesc;
    }

    /**
     * 获得排序
     * @return ORDER_FLAG
     */
    public Integer getOrderFlag() {
        return this.orderFlag;
    }

    /**
     * 设置排序
     * @param orderFlag
     */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    /**
     * 获得所属系统ID
     * @return SYS_ID
     */
    public String getSysId() {
        return this.sysId;
    }

    /**
     * 设置所属系统ID
     * @param sysId
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     * 获得所属系统名称
     * @return SYS_NAME
     */
    public String getSysName() {
        return this.sysName;
    }

    /**
     * 设置所属系统名称
     * @param sysName
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
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
     * 获得用户单位ID
     * @return MODIFY_USER_DEPT_ID
     */
    public String getModifyUserDeptId() {
        return this.modifyUserDeptId;
    }

    /**
     * 设置用户单位ID
     * @param modifyUserDeptId
     */
    public void setModifyUserDeptId(String modifyUserDeptId) {
        this.modifyUserDeptId = modifyUserDeptId;
    }

    /**
     * 获得用户单位名称
     * @return MODIFY_USER_DEPT_NAME
     */
    public String getModifyUserDeptName() {
        return this.modifyUserDeptName;
    }

    /**
     * 设置用户单位名称
     * @param modifyUserDeptName
     */
    public void setModifyUserDeptName(String modifyUserDeptName) {
        this.modifyUserDeptName = modifyUserDeptName;
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
     * 获得备用字段
     * @return RESERVE1
     */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
     * 设置备用字段
     * @param reserve1
     */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
     * 获得备用字段
     * @return RESERVE2
     */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
     * 设置备用字段
     * @param reserve2
     */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
     * 获得备用字段
     * @return RESERVE3
     */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
     * 设置备用字段
     * @param reserve3
     */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
     * 获得备用字段
     * @return RESERVE4
     */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
     * 设置备用字段
     * @param reserve4
     */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
     * 获得备用字段
     * @return RESERVE5
     */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
     * 设置备用字段
     * @param reserve5
     */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    /**
     * 获得是否选中=>后台使用，不需要存数据
     * @return IS_CHECKED
     */
    public String getIsChecked() {
        return this.isChecked;
    }

    /**
     * 设置是否选中=>后台使用，不需要存数据
     * @param isChecked
     */
    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }


}
