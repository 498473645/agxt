package com.pkusoft.lesp.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author 
 * @title: RsJbjPyjd 
 */
@ApiModel("业务数据_评议监督表")
@Table(name = "RS_JBJ_PYJD")
public class RsJbjPyjd {

 	/**
     * 评议监督主键ID
     */
    @Id
    @Column(name = "PYJD_ID")
    @ApiModelProperty(value = "评议监督主键ID")
    private String pyjdId; 

 	/**
     * 类型
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型")
    private String type; 

 	/**
     * 名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "名称")
    private String name; 

 	/**
     * 事务表主键id，ps_trans.id
     */
    @Column(name = "TRANS_ID")
    @ApiModelProperty(value = "事务表主键id，ps_trans.id")
    private String transId; 

 	/**
     * 评价时间
     */
    @Column(name = "AP_TIME")
    @ApiModelProperty(value = "评价时间")
    private java.util.Date apTime; 

 	/**
     * 评分
     */
    @Column(name = "SCORE")
    @ApiModelProperty(value = "评分")
    private String score; 

 	/**
     * 评价详情
     */
    @Column(name = "DESCR")
    @ApiModelProperty(value = "评价详情")
    private String descr; 

 	/**
     * 数据类型（0：自助机，1：微信）
     */
    @Column(name = "DATA_TYPE")
    @ApiModelProperty(value = "数据类型（0：自助机，1：微信）")
    private String dataType; 

 	/**
     * 所属机构编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属机构编码")
    private String orgCode; 

 	/**
     * 所属机构名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "所属机构名称")
    private String orgName; 

 	/**
     * 状态(1001:待处理/1002:已处理)
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态(1001:待处理/1002:已处理)")
    private String status; 

 	/**
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo; 

 	/**
     * 创建者ID
     */
    @Column(name = "CREATE_ID")
    @ApiModelProperty(value = "创建者ID")
    private String createId; 

 	/**
     * 创建者名称
     */
    @Column(name = "CREATE_NAME")
    @ApiModelProperty(value = "创建者名称")
    private String createName; 

 	/**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime; 

 	/**
     * 最后修改者ID
     */
    @Column(name = "MODER_ID")
    @ApiModelProperty(value = "最后修改者ID")
    private String moderId; 

 	/**
     * 最后修改者名称
     */
    @Column(name = "MODER_NAME")
    @ApiModelProperty(value = "最后修改者名称")
    private String moderName; 

 	/**
     * 最后修改时间
     */
    @Column(name = "MODER_TIME")
    @ApiModelProperty(value = "最后修改时间")
    private java.util.Date moderTime; 

 	/**
     * 公安一级归属单位
     */
    @Column(name = "OWN_ORG_1")
    @ApiModelProperty(value = "公安一级归属单位")
    private String ownOrg1; 

 	/**
     * 公安二级归属单位
     */
    @Column(name = "OWN_ORG_2")
    @ApiModelProperty(value = "公安二级归属单位")
    private String ownOrg2; 

 	/**
     * 公安三级归属单位
     */
    @Column(name = "OWN_ORG_3")
    @ApiModelProperty(value = "公安三级归属单位")
    private String ownOrg3; 

 	/**
     * 公安四级归属单位
     */
    @Column(name = "OWN_ORG_4")
    @ApiModelProperty(value = "公安四级归属单位")
    private String ownOrg4; 

 	/**
     * 公安五级归属单位
     */
    @Column(name = "OWN_ORG_5")
    @ApiModelProperty(value = "公安五级归属单位")
    private String ownOrg5; 

 	/**
     * 处理者id
     */
    @Column(name = "HANDLER_ID")
    @ApiModelProperty(value = "处理者id")
    private String handlerId; 

 	/**
     * 处理者姓名
     */
    @Column(name = "HANDLER_NAME")
    @ApiModelProperty(value = "处理者姓名")
    private String handlerName; 

 	/**
     * 处理结果
     */
    @Column(name = "RESULT")
    @ApiModelProperty(value = "处理结果")
    private String result; 

 	/**
     * 事务表code
     */
    @Column(name = "TRANS_CODE")
    @ApiModelProperty(value = "事务表code")
    private String transCode; 

 	/**
     * 处理时间
     */
    @Column(name = "HANDLE_TIME")
    @ApiModelProperty(value = "处理时间")
    private java.util.Date handleTime; 

 	/**
     * 抽取时间
     */
    @Column(name = "CQSJ")
    @ApiModelProperty(value = "抽取时间")
    private java.util.Date cqsj; 

 	/**
     * 修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date xgsj; 


    /**
    * 获得评议监督主键ID
    * @return PYJD_ID
    */
    public String getPyjdId() {
        return this.pyjdId;
    }

    /**
    * 设置评议监督主键ID
    * @param pyjdId
    */
    public void setPyjdId(String pyjdId) {
        this.pyjdId = pyjdId;
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
    * 获得评价时间
    * @return AP_TIME
    */
    public java.util.Date getApTime() {
        return this.apTime;
    }

    /**
    * 设置评价时间
    * @param apTime
    */
    public void setApTime(java.util.Date apTime) {
        this.apTime = apTime;
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
    * 获得状态(1001:待处理/1002:已处理)
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态(1001:待处理/1002:已处理)
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
    * 获得处理者id
    * @return HANDLER_ID
    */
    public String getHandlerId() {
        return this.handlerId;
    }

    /**
    * 设置处理者id
    * @param handlerId
    */
    public void setHandlerId(String handlerId) {
        this.handlerId = handlerId;
    }

    /**
    * 获得处理者姓名
    * @return HANDLER_NAME
    */
    public String getHandlerName() {
        return this.handlerName;
    }

    /**
    * 设置处理者姓名
    * @param handlerName
    */
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }

    /**
    * 获得处理结果
    * @return RESULT
    */
    public String getResult() {
        return this.result;
    }

    /**
    * 设置处理结果
    * @param result
    */
    public void setResult(String result) {
        this.result = result;
    }

    /**
    * 获得事务表code
    * @return TRANS_CODE
    */
    public String getTransCode() {
        return this.transCode;
    }

    /**
    * 设置事务表code
    * @param transCode
    */
    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    /**
    * 获得处理时间
    * @return HANDLE_TIME
    */
    public java.util.Date getHandleTime() {
        return this.handleTime;
    }

    /**
    * 设置处理时间
    * @param handleTime
    */
    public void setHandleTime(java.util.Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
    * 获得抽取时间
    * @return CQSJ
    */
    public java.util.Date getCqsj() {
        return this.cqsj;
    }

    /**
    * 设置抽取时间
    * @param cqsj
    */
    public void setCqsj(java.util.Date cqsj) {
        this.cqsj = cqsj;
    }

    /**
    * 获得修改时间
    * @return XGSJ
    */
    public java.util.Date getXgsj() {
        return this.xgsj;
    }

    /**
    * 设置修改时间
    * @param xgsj
    */
    public void setXgsj(java.util.Date xgsj) {
        this.xgsj = xgsj;
    }


}