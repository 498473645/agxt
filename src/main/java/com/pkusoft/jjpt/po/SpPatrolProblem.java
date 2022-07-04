package com.pkusoft.jjpt.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SpPatrolProblem
 */
@ApiModel("巡查问题信息表")
@Table(name = "SP_PATROL_PROBLEM")
public class SpPatrolProblem {

 	/**
     * 主键id
     */
    @Id
    @Column(name = "OBJID")
    @ApiModelProperty(value = "主键id")
    private String objid;

 	/**
     * 巡查问题标题
     */
    @Column(name = "TITLE")
    @ApiModelProperty(value = "巡查问题标题")
    private String title;

 	/**
     * 记录员编码
     */
    @Column(name = "RP_CODE")
    @ApiModelProperty(value = "记录员编码")
    private String rpCode;

 	/**
     * 记录员姓名
     */
    @Column(name = "RP_NAME")
    @ApiModelProperty(value = "记录员姓名")
    private String rpName;

 	/**
     * 记录员单位编码
     */
    @Column(name = "RP_ORG_CODE")
    @ApiModelProperty(value = "记录员单位编码")
    private String rpOrgCode;

 	/**
     * 记录员单位名称
     */
    @Column(name = "RP_ORG_NAME")
    @ApiModelProperty(value = "记录员单位名称")
    private String rpOrgName;

 	/**
     * 是否同步至问题中心
     */
    @Column(name = "IS_SYNC")
    @ApiModelProperty(value = "是否同步至问题中心")
    private String isSync;

 	/**
     * 同步时间
     */
    @Column(name = "SYNC_TIME")
    @ApiModelProperty(value = "同步时间")
    private java.util.Date syncTime;

 	/**
     * 附件
     */
    @Column(name = "SAVE_PATH")
    @ApiModelProperty(value = "附件")
    private String savePath;

 	/**
     * 归属单位编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "归属单位编码")
    private String orgCode;

 	/**
     * 归属单位名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "归属单位名称")
    private String orgName;

 	/**
     * 巡查问题描述
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "巡查问题描述")
    private String memo;

 	/**
     * 数据行状态
     */
    @Column(name = "ROW_STATUS")
    @ApiModelProperty(value = "数据行状态")
    private String rowStatus;

 	/**
     * 状态
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态")
    private String status;

 	/**
     * 创建人
     */
    @Column(name = "CREATE_ID")
    @ApiModelProperty(value = "创建人")
    private String createId;

 	/**
     * 创建人名称
     */
    @Column(name = "CREATE_NAME")
    @ApiModelProperty(value = "创建人名称")
    private String createName;

 	/**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;

 	/**
     * 修改人
     */
    @Column(name = "MODER_ID")
    @ApiModelProperty(value = "修改人")
    private String moderId;

 	/**
     * 修改人姓名
     */
    @Column(name = "MODER_NAME")
    @ApiModelProperty(value = "修改人姓名")
    private String moderName;

 	/**
     * 修改时间
     */
    @Column(name = "MODER_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date moderTime;

 	/**
     * 公安一级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安一级归属单位 ")
    private String gaOwnerDept1;

 	/**
     * 公安二级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安二级归属单位 ")
    private String gaOwnerDept2;

 	/**
     * 公安三级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安三级归属单位 ")
    private String gaOwnerDept3;

 	/**
     * 公安四级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安四级归属单位 ")
    private String gaOwnerDept4;

 	/**
     * 公安五级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安五级归属单位 ")
    private String gaOwnerDept5;

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
    * 获得主键id
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键id
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得巡查问题标题
    * @return TITLE
    */
    public String getTitle() {
        return this.title;
    }

    /**
    * 设置巡查问题标题
    * @param title
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * 获得记录员编码
    * @return RP_CODE
    */
    public String getRpCode() {
        return this.rpCode;
    }

    /**
    * 设置记录员编码
    * @param rpCode
    */
    public void setRpCode(String rpCode) {
        this.rpCode = rpCode;
    }

    /**
    * 获得记录员姓名
    * @return RP_NAME
    */
    public String getRpName() {
        return this.rpName;
    }

    /**
    * 设置记录员姓名
    * @param rpName
    */
    public void setRpName(String rpName) {
        this.rpName = rpName;
    }

    /**
    * 获得记录员单位编码
    * @return RP_ORG_CODE
    */
    public String getRpOrgCode() {
        return this.rpOrgCode;
    }

    /**
    * 设置记录员单位编码
    * @param rpOrgCode
    */
    public void setRpOrgCode(String rpOrgCode) {
        this.rpOrgCode = rpOrgCode;
    }

    /**
    * 获得记录员单位名称
    * @return RP_ORG_NAME
    */
    public String getRpOrgName() {
        return this.rpOrgName;
    }

    /**
    * 设置记录员单位名称
    * @param rpOrgName
    */
    public void setRpOrgName(String rpOrgName) {
        this.rpOrgName = rpOrgName;
    }

    /**
    * 获得是否同步至问题中心
    * @return IS_SYNC
    */
    public String getIsSync() {
        return this.isSync;
    }

    /**
    * 设置是否同步至问题中心
    * @param isSync
    */
    public void setIsSync(String isSync) {
        this.isSync = isSync;
    }

    /**
    * 获得同步时间
    * @return SYNC_TIME
    */
    public java.util.Date getSyncTime() {
        return this.syncTime;
    }

    /**
    * 设置同步时间
    * @param syncTime
    */
    public void setSyncTime(java.util.Date syncTime) {
        this.syncTime = syncTime;
    }

    /**
    * 获得附件
    * @return SAVE_PATH
    */
    public String getSavePath() {
        return this.savePath;
    }

    /**
    * 设置附件
    * @param savePath
    */
    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    /**
    * 获得归属单位编码
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置归属单位编码
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得归属单位名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置归属单位名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
    * 获得巡查问题描述
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置巡查问题描述
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
    * 获得数据行状态
    * @return ROW_STATUS
    */
    public String getRowStatus() {
        return this.rowStatus;
    }

    /**
    * 设置数据行状态
    * @param rowStatus
    */
    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    /**
    * 获得状态
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得创建人
    * @return CREATE_ID
    */
    public String getCreateId() {
        return this.createId;
    }

    /**
    * 设置创建人
    * @param createId
    */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
    * 获得创建人名称
    * @return CREATE_NAME
    */
    public String getCreateName() {
        return this.createName;
    }

    /**
    * 设置创建人名称
    * @param createName
    */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
    * 获得创建时间
    * @return CREATE_TIME
    */
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
    * 设置创建时间
    * @param createTime
    */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
    * 获得修改人
    * @return MODER_ID
    */
    public String getModerId() {
        return this.moderId;
    }

    /**
    * 设置修改人
    * @param moderId
    */
    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    /**
    * 获得修改人姓名
    * @return MODER_NAME
    */
    public String getModerName() {
        return this.moderName;
    }

    /**
    * 设置修改人姓名
    * @param moderName
    */
    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    /**
    * 获得修改时间
    * @return MODER_TIME
    */
    public java.util.Date getModerTime() {
        return this.moderTime;
    }

    /**
    * 设置修改时间
    * @param moderTime
    */
    public void setModerTime(java.util.Date moderTime) {
        this.moderTime = moderTime;
    }

    /**
    * 获得公安一级归属单位
    * @return GA_OWNER_DEPT_1
    */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
    * 设置公安一级归属单位
    * @param gaOwnerDept1
    */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
    * 获得公安二级归属单位
    * @return GA_OWNER_DEPT_2
    */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
    * 设置公安二级归属单位
    * @param gaOwnerDept2
    */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
    * 获得公安三级归属单位
    * @return GA_OWNER_DEPT_3
    */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
    * 设置公安三级归属单位
    * @param gaOwnerDept3
    */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
    * 获得公安四级归属单位
    * @return GA_OWNER_DEPT_4
    */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
    * 设置公安四级归属单位
    * @param gaOwnerDept4
    */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
    * 获得公安五级归属单位
    * @return GA_OWNER_DEPT_5
    */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
    * 设置公安五级归属单位
    * @param gaOwnerDept5
    */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
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
