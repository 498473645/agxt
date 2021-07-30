package com.pkusoft.jjpt.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SP_RECORD_TIPS")
public class SpRecordTips {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "T_OBJID")
    private String tObjid;     //所属报警类型id

    @Column(name = "ASK")
    private String ask;     //问

    @Column(name = "ANSWER")
    private String answer;     //答

    @Column(name = "XH")
    private String xh;     //序号

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //数据状态

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "CREATE_ID")
    private String createId;     //创建者id

    @Column(name = "CREATE_NAME")
    private String createName;     //创建者名称

    @Column(name = "CREATE_TIME")
    private java.util.Date createTime;     //创建时间

    @Column(name = "MODER_ID")
    private String moderId;     //最后修改者ID

    @Column(name = "MODER_NAME")
    private String moderName;     //最后修改者名称

    @Column(name = "MODER_TIME")
    private java.util.Date moderTime;     //最后修改时间

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2

    @Column(name = "RESERVE3")
    private String reserve3;     //预留字段3


    /**
    * 获得主键ID
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键ID
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得所属报警类型id
    * @return T_OBJID
    */
    public String getTObjid() {
        return this.tObjid;
    }

    /**
    * 设置所属报警类型id
    * @param tObjid
    */
    public void setTObjid(String tObjid) {
        this.tObjid = tObjid;
    }

    /**
    * 获得问
    * @return ASK
    */
    public String getAsk() {
        return this.ask;
    }

    /**
    * 设置问
    * @param ask
    */
    public void setAsk(String ask) {
        this.ask = ask;
    }

    /**
    * 获得答
    * @return ANSWER
    */
    public String getAnswer() {
        return this.answer;
    }

    /**
    * 设置答
    * @param answer
    */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
    * 获得序号
    * @return XH
    */
    public String getXh() {
        return this.xh;
    }

    /**
    * 设置序号
    * @param xh
    */
    public void setXh(String xh) {
        this.xh = xh;
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
    * 获得数据状态
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置数据状态
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
    * 获得创建者id
    * @return CREATE_ID
    */
    public String getCreateId() {
        return this.createId;
    }

    /**
    * 设置创建者id
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