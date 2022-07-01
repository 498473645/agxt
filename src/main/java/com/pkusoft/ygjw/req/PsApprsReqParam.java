package com.pkusoft.ygjw.req;

import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

import javax.persistence.Column;
import java.util.Date;

public class PsApprsReqParam  extends YgjwPage {

 	/**
     * 主键ID
     */
    private String id;

 	/**
     * 类型
     */
    private String type;

 	/**
     * 名称
     */
    private String name;

 	/**
     * 事务表主键id，ps_trans.id
     */
    private String transId;

 	/**
     * 查询评价开始时间
     */
    private String startApTime;

    /**
     * 查询评价截止时间
     */
    private String endApTime;

    /**
     * 处理开始时间
     */
    private String startHandleTime;

    /**
     * 处理截止时间
     */
    private String endHandleTime;

    /**
     * 评分
     */
    private String score;

 	/**
     * 评价详情
     */
    private String descr;

 	/**
     * 数据类型（0：自助机，1：微信）
     */
    private String dataType;

 	/**
     * 所属机构编码
     */
    private String orgCode;

 	/**
     * 所属机构名称
     */
    private String orgName;

 	/**
     * 状态
     */
    private String status;

 	/**
     * 备注
     */
    private String memo;

 	/**
     * 创建者ID
     */
    private String createId;

 	/**
     * 创建者名称
     */
    private String createName;

 	/**
     * 创建时间
     */
    private java.util.Date createTime;

 	/**
     * 最后修改者ID
     */
    private String moderId;

 	/**
     * 最后修改者名称
     */
    private String moderName;

 	/**
     * 最后修改时间
     */
    private java.util.Date moderTime;

    @Column(name = "GA_OWNER_DEPT_1")
    private String gaOwnerDept1;     //公安一级归属单位

    @Column(name = "GA_OWNER_DEPT_2")
    private String gaOwnerDept2;     //公安二级归属单位

    @Column(name = "GA_OWNER_DEPT_3")
    private String gaOwnerDept3;     //公安三级归属单位

    @Column(name = "GA_OWNER_DEPT_4")
    private String gaOwnerDept4;     //公安四级归属单位

    @Column(name = "GA_OWNER_DEPT_5")
    private String gaOwnerDept5;     //公安五级归属单位

 	/**
     * 预留字段1
     */
    private String reserve1;

 	/**
     * 预留字段2
     */
    private String reserve2;


    /**
    * 获得主键ID
    * @return ID
    */
    public String getId() {
        return this.id;
    }

    /**
    * 设置主键ID
    * @param id
    */
    public void setId(String id) {
        this.id = id;
    }

    /**
    * 获得类型
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得名称
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置名称
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 获得事务表主键id，ps_trans.id
    * @return TRANS_ID
    */
    public String getTransId() {
        return this.transId;
    }

    /**
    * 设置事务表主键id，ps_trans.id
    * @param transId
    */
    public void setTransId(String transId) {
        this.transId = transId;
    }

    /**
    * 获得评分
    * @return SCORE
    */
    public String getScore() {
        return this.score;
    }

    /**
    * 设置评分
    * @param score
    */
    public void setScore(String score) {
        this.score = score;
    }

    /**
    * 获得评价详情
    * @return DESCR
    */
    public String getDescr() {
        return this.descr;
    }

    /**
    * 设置评价详情
    * @param descr
    */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
    * 获得数据类型（0：自助机，1：微信）
    * @return DATA_TYPE
    */
    public String getDataType() {
        return this.dataType;
    }

    /**
    * 设置数据类型（0：自助机，1：微信）
    * @param dataType
    */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
    * 获得所属机构编码
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置所属机构编码
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得所属机构名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置所属机构名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
    * 获得备注
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置备注
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
    * 获得创建者ID
    * @return CREATE_ID
    */
    public String getCreateId() {
        return this.createId;
    }

    /**
    * 设置创建者ID
    * @param createId
    */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
    * 获得创建者名称
    * @return CREATE_NAME
    */
    public String getCreateName() {
        return this.createName;
    }

    /**
    * 设置创建者名称
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
    * 获得最后修改者ID
    * @return MODER_ID
    */
    public String getModerId() {
        return this.moderId;
    }

    /**
    * 设置最后修改者ID
    * @param moderId
    */
    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    /**
    * 获得最后修改者名称
    * @return MODER_NAME
    */
    public String getModerName() {
        return this.moderName;
    }

    /**
    * 设置最后修改者名称
    * @param moderName
    */
    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    /**
    * 获得最后修改时间
    * @return MODER_TIME
    */
    public java.util.Date getModerTime() {
        return this.moderTime;
    }

    /**
    * 设置最后修改时间
    * @param moderTime
    */
    public void setModerTime(java.util.Date moderTime) {
        this.moderTime = moderTime;
    }

    public String getGaOwnerDept1() {
        return gaOwnerDept1;
    }

    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    public String getGaOwnerDept2() {
        return gaOwnerDept2;
    }

    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    public String getGaOwnerDept3() {
        return gaOwnerDept3;
    }

    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    public String getGaOwnerDept4() {
        return gaOwnerDept4;
    }

    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    public String getGaOwnerDept5() {
        return gaOwnerDept5;
    }

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

    public String getStartApTime() {
        return startApTime;
    }

    public void setStartApTime(String startApTime) {
        this.startApTime = startApTime;
    }

    public String getEndApTime() {
        return endApTime;
    }

    public void setEndApTime(String endApTime) {
        this.endApTime = endApTime;
    }

    public String getStartHandleTime() {
        return startHandleTime;
    }

    public void setStartHandleTime(String startHandleTime) {
        this.startHandleTime = startHandleTime;
    }

    public String getEndHandleTime() {
        return endHandleTime;
    }

    public void setEndHandleTime(String endHandleTime) {
        this.endHandleTime = endHandleTime;
    }
}
