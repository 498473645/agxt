package com.pkusoft.ygjw.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author
 * @title: PsWindow
 */
@ApiModel("业务数据_窗口表")
public class PsWindowReqParam  extends YgjwPage {

 	/**
     * 主键ID
     */
    @Column(name = "ID")
    @ApiModelProperty(value = "主键ID")
    private String id;

 	/**
     * 编号
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "编号")
    private String code;

 	/**
     * 名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "名称")
    private String name;

 	/**
     * 主办业务(a;b;c)
     */
    @Column(name = "HOST_BUSINESS")
    @ApiModelProperty(value = "主办业务(a;b;c)")
    private String hostBusiness;

 	/**
     * 办事地址
     */
    @Column(name = "ADDRESS")
    @ApiModelProperty(value = "办事地址")
    private String address;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Integer sn;

 	/**
     * 状态（1010：登记中，1020：登记完）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态（1010：登记中，1020：登记完）")
    private String status;

    /**
     * 所属机构编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属机构编码")
    private String orgCode;

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
     * 报警场所id
     */
    @Column(name = "HANDLING_ID")
    @ApiModelProperty(value = "报警场所id")
    private String handlingId;

    /**
     * 业务类型
     */
    @Column(name = "BUSINESS_TYPE")
    @ApiModelProperty(value = "业务类型(1;报案;2;办事)")
    private String businessType;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取报警场所id
     * @return
     */
    public String getHandlingId() {
        return handlingId;
    }

    /**
     * 设置报警场所id
     * @param handlingId
     */
    public void setHandlingId(String handlingId) {
        this.handlingId = handlingId;
    }

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
    * 获得编号
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置编号
    * @param code
    */
    public void setCode(String code) {
        this.code = code;
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
    * 获得主办业务(a;b;c)
    * @return HOST_BUSINESS
    */
    public String getHostBusiness() {
        return this.hostBusiness;
    }

    /**
    * 设置主办业务(a;b;c)
    * @param hostBusiness
    */
    public void setHostBusiness(String hostBusiness) {
        this.hostBusiness = hostBusiness;
    }

    /**
    * 获得办事地址
    * @return ADDRESS
    */
    public String getAddress() {
        return this.address;
    }

    /**
    * 设置办事地址
    * @param address
    */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
    * 获得排序序号
    * @return SN
    */
    public Integer getSn() {
        return this.sn;
    }

    /**
    * 设置排序序号
    * @param sn
    */
    public void setSn(Integer sn) {
        this.sn = sn;
    }

    /**
    * 获得状态（1010：登记中，1020：登记完）
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态（1010：登记中，1020：登记完）
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
