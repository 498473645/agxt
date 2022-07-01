package com.pkusoft.ygjw.req;

import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

import javax.persistence.Column;

public class PsGuideReqParam  extends YgjwPage {

 	/**
     * 主键ID
     */
    @Column(name = "ID")
    @ApiModelProperty(value = "主键ID")
    private String id;

 	/**
     * 类型(对应ps_trans.type)
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型(对应ps_trans.type)")
    private String type;

 	/**
     * 办理条件
     */
    @Column(name = "COND")
    @ApiModelProperty(value = "办理条件")
    private String cond;

 	/**
     * 办理流程
     */
    @Column(name = "STEP")
    @ApiModelProperty(value = "办理流程")
    private String step;

 	/**
     * 办理材料
     */
    @Column(name = "MATEL")
    @ApiModelProperty(value = "办理材料")
    private String matel;

 	/**
     * 状态（1010：登记中，1020：登记完）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态（1010：登记中，1020：登记完）")
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
    * 获得类型(对应ps_trans.type)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型(对应ps_trans.type)
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得办理条件
    * @return COND
    */
    public String getCond() {
        return this.cond;
    }

    /**
    * 设置办理条件
    * @param cond
    */
    public void setCond(String cond) {
        this.cond = cond;
    }

    /**
    * 获得办理流程
    * @return STEP
    */
    public String getStep() {
        return this.step;
    }

    /**
    * 设置办理流程
    * @param step
    */
    public void setStep(String step) {
        this.step = step;
    }

    /**
    * 获得办理材料
    * @return MATEL
    */
    public String getMatel() {
        return this.matel;
    }

    /**
    * 设置办理材料
    * @param matel
    */
    public void setMatel(String matel) {
        this.matel = matel;
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


}
