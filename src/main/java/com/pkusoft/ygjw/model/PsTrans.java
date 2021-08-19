package com.pkusoft.ygjw.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

/**
 * @author
 * @title: PsTrans
 */
@ApiModel("事务数据")
@Table(name = "PS_TRANS")
public class PsTrans {

 	/**
     * 主键ID
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "主键ID")
    private String id;

 	/**
     * 报案/办事编号
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "报案/办事编号")
    private String code;

 	/**
     * 报案/办事名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "报案/办事名称")
    private String name;

 	/**
     * 报案/办事类型(1010 被殴打, 1020 被盗 , 1030 被骗, 1040 被抢劫, 1050 邻里纠纷, 1060 家庭暴力, 1099 其他；2010 出生登记入户，2020 户口簿补领，2030 户籍证明，2040 跨市迁入， 2050 市县内移居， 2060 准迁证办理)
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "报案/办事类型(1010 被殴打, 1020 被盗 , 1030 被骗, 1040 被抢劫, 1050 邻里纠纷, 1060 家庭暴力, 1099 其他；2010 出生登记入户，2020 户口簿补领，2030 户籍证明，2040 跨市迁入， 2050 市县内移居， 2060 准迁证办理)")
    private String type;

    /**
     *  领域
     */
    @Column(name = "LY")
    @ApiModelProperty(value = "领域")
    private String ly;

    /**
     * 报案/办事人姓名
     */
    @Column(name = "REP_NAME")
    @ApiModelProperty(value = "报案/办事人姓名")
    private String repName;

 	/**
     * 报案/办事人证件类型
     */
    @Column(name = "REP_CARD_TYPE")
    @ApiModelProperty(value = "报案/办事人证件类型")
    private String repCardType;

 	/**
     * 报案/办事人证件号码
     */
    @Column(name = "REP_IDCARD")
    @ApiModelProperty(value = "报案/办事人证件号码")
    private String repIdcard;

 	/**
     * 报案/办事人照片（照片数据存入SP_PIC表）
     */
    @Column(name = "REP_PHOTO")
    @ApiModelProperty(value = "报案/办事人照片（照片数据存入SP_PIC表）")
    private String repPhoto;

 	/**
     * 报案/办事人性别
     */
    @Column(name = "REP_SEX")
    @ApiModelProperty(value = "报案/办事人性别")
    private String repSex;

 	/**
     * 报案/办事人出生日期
     */
    @Column(name = "REP_BRITHDAY")
    @ApiModelProperty(value = "报案/办事人出生日期")
    private String repBrithday;

 	/**
     * 报案/办事人联系方式
     */
    @Column(name = "REP_TEL")
    @ApiModelProperty(value = "报案/办事人联系方式")
    private String repTel;

 	/**
     * 报案/办事人民族
     */
    @Column(name = "REP_NATION")
    @ApiModelProperty(value = "报案/办事人民族")
    private String repNation;

 	/**
     * 报案/办事人工作单位
     */
    @Column(name = "REP_WORKUNIT")
    @ApiModelProperty(value = "报案/办事人工作单位")
    private String repWorkunit;

 	/**
     * 报案/办事人户籍地行政区划编码. 关联字典DIC_NATIONAL_REGION
     */
    @Column(name = "REP_REG_CODE")
    @ApiModelProperty(value = "报案/办事人户籍地行政区划编码. 关联字典DIC_NATIONAL_REGION")
    private String repRegCode;

 	/**
     * 报案/办事人户籍地详情
     */
    @Column(name = "REP_REG_ADDR")
    @ApiModelProperty(value = "报案/办事人户籍地详情")
    private String repRegAddr;

 	/**
     * 报案/办事人现住址行政区划编码. 关联字典DIC_NATIONAL_REGION
     */
    @Column(name = "REP_ADDR_CODE")
    @ApiModelProperty(value = "报案/办事人现住址行政区划编码. 关联字典DIC_NATIONAL_REGION")
    private String repAddrCode;

 	/**
     * 报案/办事人现住址详情
     */
    @Column(name = "REP_ADDR")
    @ApiModelProperty(value = "报案/办事人现住址详情")
    private String repAddr;

 	/**
     * 报案/办事时间
     */
    @Column(name = "REP_TIME")
    @ApiModelProperty(value = "报案/办事时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "PRC")
    private java.util.Date repTime;

 	/**
     * 案发时间
     */
    @Column(name = "OCC_TIME")
    @ApiModelProperty(value = "案发时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "PRC")
    private java.util.Date occTime;

 	/**
     * 案发地点
     */
    @Column(name = "OCC_ADDR")
    @ApiModelProperty(value = "案发地点")
    private String occAddr;

 	/**
     * 案发原因
     */
    @Column(name = "OCC_REASON")
    @ApiModelProperty(value = "案发原因")
    private String occReason;

 	/**
     * 简要案情
     */
    @Column(name = "OCC_DESCR")
    @ApiModelProperty(value = "简要案情")
    private String occDescr;

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
     * 状态（1010：登记中，1020：登记完成，2010：已受理）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态（1010：登记中，1020：登记完成，2010：已受理）")
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

    @Column(name = "JJD_OBJID")
    private String jjdObjid;     //接警单id

    @Column(name = "JJDBH")
    private String jjdbh;     //接警单编号

    /**
     * 接警时间
     */
    @Column(name = "JJSJ")
    @ApiModelProperty(value = "报案/办事时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "PRC")
    private java.util.Date jjsj;

    public Date getJjsj() {
        return jjsj;
    }

    public void setJjsj(Date jjsj) {
        this.jjsj = jjsj;
    }

    public String getJjdbh() {
        return jjdbh;
    }

    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    public String getJjdObjid() {
        return jjdObjid;
    }

    public void setJjdObjid(String jjdObjid) {
        this.jjdObjid = jjdObjid;
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
    * 获得报案/办事编号
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置报案/办事编号
    * @param code
    */
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * 获得报案/办事名称
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置报案/办事名称
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 获得报案/办事类型(1010 被殴打, 1020 被盗 , 1030 被骗, 1040 被抢劫, 1050 邻里纠纷, 1060 家庭暴力, 1099 其他；2010 出生登记入户，2020 户口簿补领，2030 户籍证明，2040 跨市迁入， 2050 市县内移居， 2060 准迁证办理)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置报案/办事类型(1010 被殴打, 1020 被盗 , 1030 被骗, 1040 被抢劫, 1050 邻里纠纷, 1060 家庭暴力, 1099 其他；2010 出生登记入户，2020 户口簿补领，2030 户籍证明，2040 跨市迁入， 2050 市县内移居， 2060 准迁证办理)
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得报案/办事人姓名
    * @return REP_NAME
    */
    public String getRepName() {
        return this.repName;
    }

    /**
    * 设置报案/办事人姓名
    * @param repName
    */
    public void setRepName(String repName) {
        this.repName = repName;
    }

    /**
    * 获得报案/办事人证件类型
    * @return REP_CARD_TYPE
    */
    public String getRepCardType() {
        return this.repCardType;
    }

    /**
    * 设置报案/办事人证件类型
    * @param repCardType
    */
    public void setRepCardType(String repCardType) {
        this.repCardType = repCardType;
    }

    /**
    * 获得报案/办事人证件号码
    * @return REP_IDCARD
    */
    public String getRepIdcard() {
        return this.repIdcard;
    }

    /**
    * 设置报案/办事人证件号码
    * @param repIdcard
    */
    public void setRepIdcard(String repIdcard) {
        this.repIdcard = repIdcard;
    }

    /**
    * 获得报案/办事人照片（照片数据存入SP_PIC表）
    * @return REP_PHOTO
    */
    public String getRepPhoto() {
        return this.repPhoto;
    }

    /**
    * 设置报案/办事人照片（照片数据存入SP_PIC表）
    * @param repPhoto
    */
    public void setRepPhoto(String repPhoto) {
        this.repPhoto = repPhoto;
    }

    /**
    * 获得报案/办事人性别
    * @return REP_SEX
    */
    public String getRepSex() {
        return this.repSex;
    }

    /**
    * 设置报案/办事人性别
    * @param repSex
    */
    public void setRepSex(String repSex) {
        this.repSex = repSex;
    }

    /**
    * 获得报案/办事人出生日期
    * @return REP_BRITHDAY
    */
    public String getRepBrithday() {
        return this.repBrithday;
    }

    /**
    * 设置报案/办事人出生日期
    * @param repBrithday
    */
    public void setRepBrithday(String repBrithday) {
        this.repBrithday = repBrithday;
    }

    /**
    * 获得报案/办事人联系方式
    * @return REP_TEL
    */
    public String getRepTel() {
        return this.repTel;
    }

    /**
    * 设置报案/办事人联系方式
    * @param repTel
    */
    public void setRepTel(String repTel) {
        this.repTel = repTel;
    }

    /**
    * 获得报案/办事人民族
    * @return REP_NATION
    */
    public String getRepNation() {
        return this.repNation;
    }

    /**
    * 设置报案/办事人民族
    * @param repNation
    */
    public void setRepNation(String repNation) {
        this.repNation = repNation;
    }

    /**
    * 获得报案/办事人工作单位
    * @return REP_WORKUNIT
    */
    public String getRepWorkunit() {
        return this.repWorkunit;
    }

    /**
    * 设置报案/办事人工作单位
    * @param repWorkunit
    */
    public void setRepWorkunit(String repWorkunit) {
        this.repWorkunit = repWorkunit;
    }

    /**
    * 获得报案/办事人户籍地行政区划编码. 关联字典DIC_NATIONAL_REGION
    * @return REP_REG_CODE
    */
    public String getRepRegCode() {
        return this.repRegCode;
    }

    /**
    * 设置报案/办事人户籍地行政区划编码. 关联字典DIC_NATIONAL_REGION
    * @param repRegCode
    */
    public void setRepRegCode(String repRegCode) {
        this.repRegCode = repRegCode;
    }

    /**
    * 获得报案/办事人户籍地详情
    * @return REP_REG_ADDR
    */
    public String getRepRegAddr() {
        return this.repRegAddr;
    }

    /**
    * 设置报案/办事人户籍地详情
    * @param repRegAddr
    */
    public void setRepRegAddr(String repRegAddr) {
        this.repRegAddr = repRegAddr;
    }

    /**
    * 获得报案/办事人现住址行政区划编码. 关联字典DIC_NATIONAL_REGION
    * @return REP_ADDR_CODE
    */
    public String getRepAddrCode() {
        return this.repAddrCode;
    }

    /**
    * 设置报案/办事人现住址行政区划编码. 关联字典DIC_NATIONAL_REGION
    * @param repAddrCode
    */
    public void setRepAddrCode(String repAddrCode) {
        this.repAddrCode = repAddrCode;
    }

    /**
    * 获得报案/办事人现住址详情
    * @return REP_ADDR
    */
    public String getRepAddr() {
        return this.repAddr;
    }

    /**
    * 设置报案/办事人现住址详情
    * @param repAddr
    */
    public void setRepAddr(String repAddr) {
        this.repAddr = repAddr;
    }

    /**
    * 获得报案/办事时间
    * @return REP_TIME
    */
    public java.util.Date getRepTime() {
        return this.repTime;
    }

    /**
    * 设置报案/办事时间
    * @param repTime
    */
    public void setRepTime(java.util.Date repTime) {
        this.repTime = repTime;
    }

    /**
    * 获得案发时间
    * @return OCC_TIME
    */
    public java.util.Date getOccTime() {
        return this.occTime;
    }

    /**
    * 设置案发时间
    * @param occTime
    */
    public void setOccTime(java.util.Date occTime) {
        this.occTime = occTime;
    }

    /**
    * 获得案发地点
    * @return OCC_ADDR
    */
    public String getOccAddr() {
        return this.occAddr;
    }

    /**
    * 设置案发地点
    * @param occAddr
    */
    public void setOccAddr(String occAddr) {
        this.occAddr = occAddr;
    }

    /**
    * 获得案发原因
    * @return OCC_REASON
    */
    public String getOccReason() {
        return this.occReason;
    }

    /**
    * 设置案发原因
    * @param occReason
    */
    public void setOccReason(String occReason) {
        this.occReason = occReason;
    }

    /**
    * 获得简要案情
    * @return OCC_DESCR
    */
    public String getOccDescr() {
        return this.occDescr;
    }

    /**
    * 设置简要案情
    * @param occDescr
    */
    public void setOccDescr(String occDescr) {
        this.occDescr = occDescr;
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
    * 获得状态（1010：登记中，1020：登记完成，2010：已受理）
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态（1010：登记中，1020：登记完成，2010：已受理）
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

    public String getLy() {
        return ly;
    }

    public void setLy(String ly) {
        this.ly = ly;
    }
}
