package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysDataOwnerDept
 */
@ApiModel("数据归属单位")
@Table(name = "SYS_DATA_OWNER_DEPT")
public class SysDataOwnerDept {

    /**
     * 主键ID
     */
    @Id
    @Column(name = "DATA_OWNER_DEPT_ID")
    @ApiModelProperty(value = "主键ID")
    private String dataOwnerDeptId;

    /**
     * 单位编号
     */
    @Column(name = "DEPT_ID")
    @ApiModelProperty(value = "单位编号")
    private String deptId;

    /**
     * 单位类别（ga-公安；jg-交管；xz-刑侦）
     */
    @Column(name = "DEPT_TYPE")
    @ApiModelProperty(value = "单位类别（ga-公安；jg-交管；xz-刑侦）")
    private String deptType;

    /**
     * 一级归属单位
     */
    @Column(name = "OWNER_DEPT_1")
    @ApiModelProperty(value = "一级归属单位")
    private String ownerDept1;

    /**
     * 二级归属单位
     */
    @Column(name = "OWNER_DEPT_2")
    @ApiModelProperty(value = "二级归属单位")
    private String ownerDept2;

    /**
     * 三级归属单位
     */
    @Column(name = "OWNER_DEPT_3")
    @ApiModelProperty(value = "三级归属单位")
    private String ownerDept3;

    /**
     * 四级归属单位
     */
    @Column(name = "OWNER_DEPT_4")
    @ApiModelProperty(value = "四级归属单位")
    private String ownerDept4;

    /**
     * 五级归属单位
     */
    @Column(name = "OWNER_DEPT_5")
    @ApiModelProperty(value = "五级归属单位")
    private String ownerDept5;

    /**
     * 修改用户编号
     */
    @Column(name = "MODIFY_USER_ID")
    @ApiModelProperty(value = "修改用户编号")
    private String modifyUserId;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime;


    /**
     * 获得主键ID
     * @return DATA_OWNER_DEPT_ID
     */
    public String getDataOwnerDeptId() {
        return this.dataOwnerDeptId;
    }

    /**
     * 设置主键ID
     * @param dataOwnerDeptId
     */
    public void setDataOwnerDeptId(String dataOwnerDeptId) {
        this.dataOwnerDeptId = dataOwnerDeptId;
    }

    /**
     * 获得单位编号
     * @return DEPT_ID
     */
    public String getDeptId() {
        return this.deptId;
    }

    /**
     * 设置单位编号
     * @param deptId
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获得单位类别（ga-公安；jg-交管；xz-刑侦）
     * @return DEPT_TYPE
     */
    public String getDeptType() {
        return this.deptType;
    }

    /**
     * 设置单位类别（ga-公安；jg-交管；xz-刑侦）
     * @param deptType
     */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    /**
     * 获得一级归属单位
     * @return OWNER_DEPT_1
     */
    public String getOwnerDept1() {
        return this.ownerDept1;
    }

    /**
     * 设置一级归属单位
     * @param ownerDept1
     */
    public void setOwnerDept1(String ownerDept1) {
        this.ownerDept1 = ownerDept1;
    }

    /**
     * 获得二级归属单位
     * @return OWNER_DEPT_2
     */
    public String getOwnerDept2() {
        return this.ownerDept2;
    }

    /**
     * 设置二级归属单位
     * @param ownerDept2
     */
    public void setOwnerDept2(String ownerDept2) {
        this.ownerDept2 = ownerDept2;
    }

    /**
     * 获得三级归属单位
     * @return OWNER_DEPT_3
     */
    public String getOwnerDept3() {
        return this.ownerDept3;
    }

    /**
     * 设置三级归属单位
     * @param ownerDept3
     */
    public void setOwnerDept3(String ownerDept3) {
        this.ownerDept3 = ownerDept3;
    }

    /**
     * 获得四级归属单位
     * @return OWNER_DEPT_4
     */
    public String getOwnerDept4() {
        return this.ownerDept4;
    }

    /**
     * 设置四级归属单位
     * @param ownerDept4
     */
    public void setOwnerDept4(String ownerDept4) {
        this.ownerDept4 = ownerDept4;
    }

    /**
     * 获得五级归属单位
     * @return OWNER_DEPT_5
     */
    public String getOwnerDept5() {
        return this.ownerDept5;
    }

    /**
     * 设置五级归属单位
     * @param ownerDept5
     */
    public void setOwnerDept5(String ownerDept5) {
        this.ownerDept5 = ownerDept5;
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
