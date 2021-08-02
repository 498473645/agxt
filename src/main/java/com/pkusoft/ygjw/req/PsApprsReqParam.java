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
    private Date startHandleTime;

    /**
     * 处理截止时间
     */
    private Date endHandleTime;

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

 	/**
     * 公安一级归属单位
     */
    private String ownOrg1; 

 	/**
     * 公安二级归属单位
     */
    private String ownOrg2; 

 	/**
     * 公安三级归属单位
     */
    private String ownOrg3; 

 	/**
     * 公安四级归属单位
     */
    private String ownOrg4; 

 	/**
     * 公安五级归属单位
     */
    private String ownOrg5; 

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

    /**
    * 获得公安一级归属单位
    * @return OWN_ORG_1
    */
    public String getOwnOrg1() {
        return this.ownOrg1;
    }

    /**
    * 设置公安一级归属单位
    * @param ownOrg1
    */
    public void setOwnOrg1(String ownOrg1) {
        this.ownOrg1 = ownOrg1;
    }

    /**
    * 获得公安二级归属单位
    * @return OWN_ORG_2
    */
    public String getOwnOrg2() {
        return this.ownOrg2;
    }

    /**
    * 设置公安二级归属单位
    * @param ownOrg2
    */
    public void setOwnOrg2(String ownOrg2) {
        this.ownOrg2 = ownOrg2;
    }

    /**
    * 获得公安三级归属单位
    * @return OWN_ORG_3
    */
    public String getOwnOrg3() {
        return this.ownOrg3;
    }

    /**
    * 设置公安三级归属单位
    * @param ownOrg3
    */
    public void setOwnOrg3(String ownOrg3) {
        this.ownOrg3 = ownOrg3;
    }

    /**
    * 获得公安四级归属单位
    * @return OWN_ORG_4
    */
    public String getOwnOrg4() {
        return this.ownOrg4;
    }

    /**
    * 设置公安四级归属单位
    * @param ownOrg4
    */
    public void setOwnOrg4(String ownOrg4) {
        this.ownOrg4 = ownOrg4;
    }

    /**
    * 获得公安五级归属单位
    * @return OWN_ORG_5
    */
    public String getOwnOrg5() {
        return this.ownOrg5;
    }

    /**
    * 设置公安五级归属单位
    * @param ownOrg5
    */
    public void setOwnOrg5(String ownOrg5) {
        this.ownOrg5 = ownOrg5;
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

    public Date getStartHandleTime() {
        return startHandleTime;
    }

    public void setStartHandleTime(Date startHandleTime) {
        this.startHandleTime = startHandleTime;
    }

    public Date getEndHandleTime() {
        return endHandleTime;
    }

    public void setEndHandleTime(Date endHandleTime) {
        this.endHandleTime = endHandleTime;
    }
}