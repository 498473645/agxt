package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: CasePerson
 */
@ApiModel("涉案人员表")
@Table(name = "CASE_PERSON")
public class CasePerson {

 	/**
     *
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "")
    private String id;

 	/**
     * 编号
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "编号")
    private String code;

 	/**
     * 姓名
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "姓名")
    private String name;

 	/**
     * 案件ID
     */
    @Column(name = "CASE_ID")
    @ApiModelProperty(value = "案件ID")
    private String caseId;

 	/**
     * 案件编号
     */
    @Column(name = "CASE_CODE")
    @ApiModelProperty(value = "案件编号")
    private String caseCode;

 	/**
     * 案件名称
     */
    @Column(name = "CASE_NAME")
    @ApiModelProperty(value = "案件名称")
    private String caseName;

 	/**
     * 类型(10:嫌疑人;20:受害人;30:当事人;40证人;90:其他)
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型(10:嫌疑人;20:受害人;30:当事人;40证人;90:其他)")
    private String type;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Integer sn;

 	/**
     * 国籍
     */
    @Column(name = "COUNTRY")
    @ApiModelProperty(value = "国籍")
    private String country;

 	/**
     * 性别
     */
    @Column(name = "GENDER")
    @ApiModelProperty(value = "性别")
    private String gender;

 	/**
     * 出生日期
     */
    @Column(name = "BIRTHDAY")
    @ApiModelProperty(value = "出生日期")
    private java.util.Date birthday;

 	/**
     * 证件类型
     */
    @Column(name = "PAPER_TYPE")
    @ApiModelProperty(value = "证件类型")
    private String paperType;

 	/**
     * 证件名称
     */
    @Column(name = "PAPER_NAME")
    @ApiModelProperty(value = "证件名称")
    private String paperName;

 	/**
     * 证件编号
     */
    @Column(name = "PAPER_CODE")
    @ApiModelProperty(value = "证件编号")
    private String paperCode;

 	/**
     * 户籍地址
     */
    @Column(name = "NATIVE_ADD")
    @ApiModelProperty(value = "户籍地址")
    private String nativeAdd;

 	/**
     * 现住址
     */
    @Column(name = "CUR_ADD")
    @ApiModelProperty(value = "现住址")
    private String curAdd;

 	/**
     * 联系方式
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "联系方式")
    private String tel;

 	/**
     * 所在单位ID
     */
    @Column(name = "WORKORG_ID")
    @ApiModelProperty(value = "所在单位ID")
    private String workorgId;

 	/**
     * 所在单位名称
     */
    @Column(name = "WORKORG_NAME")
    @ApiModelProperty(value = "所在单位名称")
    private String workorgName;

 	/**
     * 所在单位地址
     */
    @Column(name = "WORKORG_ADD")
    @ApiModelProperty(value = "所在单位地址")
    private String workorgAdd;

 	/**
     * 所在单位联系方式
     */
    @Column(name = "WORKORG_TEL")
    @ApiModelProperty(value = "所在单位联系方式")
    private String workorgTel;

 	/**
     * 职务
     */
    @Column(name = "WORKORG_DUTY")
    @ApiModelProperty(value = "职务")
    private String workorgDuty;

 	/**
     * 0：表示从警综获取；1：表示系统手工录入
     */
    @Column(name = "DATA_SOURCE")
    @ApiModelProperty(value = "0：表示从警综获取；1：表示系统手工录入")
    private String dataSource;

 	/**
     * 状态
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态")
    private String status;

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
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo;

 	/**
     * 数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用
     */
    @Column(name = "ROW_STATUS")
    @ApiModelProperty(value = "数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用")
    private Integer rowStatus;

 	/**
     * 创建者ID
     */
    @Column(name = "CREATER_ID")
    @ApiModelProperty(value = "创建者ID")
    private String createrId;

 	/**
     * 创建者名称
     */
    @Column(name = "CREATER_NAME")
    @ApiModelProperty(value = "创建者名称")
    private String createrName;

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
    @Column(name = "MOD_TIME")
    @ApiModelProperty(value = "最后修改时间")
    private java.util.Date modTime;

 	/**
     * 所属市局
     */
    @Column(name = "ORG_C")
    @ApiModelProperty(value = "所属市局")
    private String orgC;

 	/**
     * 所属分局
     */
    @Column(name = "ORG_S")
    @ApiModelProperty(value = "所属分局")
    private String orgS;

 	/**
     * 所属派出所
     */
    @Column(name = "ORG_T")
    @ApiModelProperty(value = "所属派出所")
    private String orgT;

 	/**
     * 数据归属市局
     */
    @Column(name = "ORG_C_DATA")
    @ApiModelProperty(value = "数据归属市局")
    private String orgCData;

 	/**
     * 数据归属分局
     */
    @Column(name = "ORG_S_DATA")
    @ApiModelProperty(value = "数据归属分局")
    private String orgSData;

 	/**
     * 数据归属派出所
     */
    @Column(name = "ORG_T_DATA")
    @ApiModelProperty(value = "数据归属派出所")
    private String orgTData;

 	/**
     * 当前归属单位
     */
    @Column(name = "CUR_ORG")
    @ApiModelProperty(value = "当前归属单位")
    private String curOrg;

 	/**
     * 当前数据归属单位
     */
    @Column(name = "CUR_ORG_DATA")
    @ApiModelProperty(value = "当前数据归属单位")
    private String curOrgData;


    /**
    * 获得
    * @return ID
    */
    public String getId() {
        return this.id;
    }

    /**
    * 设置
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
    * 获得姓名
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置姓名
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 获得案件ID
    * @return CASE_ID
    */
    public String getCaseId() {
        return this.caseId;
    }

    /**
    * 设置案件ID
    * @param caseId
    */
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    /**
    * 获得案件编号
    * @return CASE_CODE
    */
    public String getCaseCode() {
        return this.caseCode;
    }

    /**
    * 设置案件编号
    * @param caseCode
    */
    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    /**
    * 获得案件名称
    * @return CASE_NAME
    */
    public String getCaseName() {
        return this.caseName;
    }

    /**
    * 设置案件名称
    * @param caseName
    */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
    * 获得类型(10:嫌疑人;20:受害人;30:当事人;40证人;90:其他)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型(10:嫌疑人;20:受害人;30:当事人;40证人;90:其他)
    * @param type
    */
    public void setType(String type) {
        this.type = type;
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
    * 获得国籍
    * @return COUNTRY
    */
    public String getCountry() {
        return this.country;
    }

    /**
    * 设置国籍
    * @param country
    */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
    * 获得性别
    * @return GENDER
    */
    public String getGender() {
        return this.gender;
    }

    /**
    * 设置性别
    * @param gender
    */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
    * 获得出生日期
    * @return BIRTHDAY
    */
    public java.util.Date getBirthday() {
        return this.birthday;
    }

    /**
    * 设置出生日期
    * @param birthday
    */
    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    /**
    * 获得证件类型
    * @return PAPER_TYPE
    */
    public String getPaperType() {
        return this.paperType;
    }

    /**
    * 设置证件类型
    * @param paperType
    */
    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    /**
    * 获得证件名称
    * @return PAPER_NAME
    */
    public String getPaperName() {
        return this.paperName;
    }

    /**
    * 设置证件名称
    * @param paperName
    */
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    /**
    * 获得证件编号
    * @return PAPER_CODE
    */
    public String getPaperCode() {
        return this.paperCode;
    }

    /**
    * 设置证件编号
    * @param paperCode
    */
    public void setPaperCode(String paperCode) {
        this.paperCode = paperCode;
    }

    /**
    * 获得户籍地址
    * @return NATIVE_ADD
    */
    public String getNativeAdd() {
        return this.nativeAdd;
    }

    /**
    * 设置户籍地址
    * @param nativeAdd
    */
    public void setNativeAdd(String nativeAdd) {
        this.nativeAdd = nativeAdd;
    }

    /**
    * 获得现住址
    * @return CUR_ADD
    */
    public String getCurAdd() {
        return this.curAdd;
    }

    /**
    * 设置现住址
    * @param curAdd
    */
    public void setCurAdd(String curAdd) {
        this.curAdd = curAdd;
    }

    /**
    * 获得联系方式
    * @return TEL
    */
    public String getTel() {
        return this.tel;
    }

    /**
    * 设置联系方式
    * @param tel
    */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
    * 获得所在单位ID
    * @return WORKORG_ID
    */
    public String getWorkorgId() {
        return this.workorgId;
    }

    /**
    * 设置所在单位ID
    * @param workorgId
    */
    public void setWorkorgId(String workorgId) {
        this.workorgId = workorgId;
    }

    /**
    * 获得所在单位名称
    * @return WORKORG_NAME
    */
    public String getWorkorgName() {
        return this.workorgName;
    }

    /**
    * 设置所在单位名称
    * @param workorgName
    */
    public void setWorkorgName(String workorgName) {
        this.workorgName = workorgName;
    }

    /**
    * 获得所在单位地址
    * @return WORKORG_ADD
    */
    public String getWorkorgAdd() {
        return this.workorgAdd;
    }

    /**
    * 设置所在单位地址
    * @param workorgAdd
    */
    public void setWorkorgAdd(String workorgAdd) {
        this.workorgAdd = workorgAdd;
    }

    /**
    * 获得所在单位联系方式
    * @return WORKORG_TEL
    */
    public String getWorkorgTel() {
        return this.workorgTel;
    }

    /**
    * 设置所在单位联系方式
    * @param workorgTel
    */
    public void setWorkorgTel(String workorgTel) {
        this.workorgTel = workorgTel;
    }

    /**
    * 获得职务
    * @return WORKORG_DUTY
    */
    public String getWorkorgDuty() {
        return this.workorgDuty;
    }

    /**
    * 设置职务
    * @param workorgDuty
    */
    public void setWorkorgDuty(String workorgDuty) {
        this.workorgDuty = workorgDuty;
    }

    /**
    * 获得0：表示从警综获取；1：表示系统手工录入
    * @return DATA_SOURCE
    */
    public String getDataSource() {
        return this.dataSource;
    }

    /**
    * 设置0：表示从警综获取；1：表示系统手工录入
    * @param dataSource
    */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
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
    * 获得数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用
    * @return ROW_STATUS
    */
    public Integer getRowStatus() {
        return this.rowStatus;
    }

    /**
    * 设置数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用
    * @param rowStatus
    */
    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
    }

    /**
    * 获得创建者ID
    * @return CREATER_ID
    */
    public String getCreaterId() {
        return this.createrId;
    }

    /**
    * 设置创建者ID
    * @param createrId
    */
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    /**
    * 获得创建者名称
    * @return CREATER_NAME
    */
    public String getCreaterName() {
        return this.createrName;
    }

    /**
    * 设置创建者名称
    * @param createrName
    */
    public void setCreaterName(String createrName) {
        this.createrName = createrName;
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
    * @return MOD_TIME
    */
    public java.util.Date getModTime() {
        return this.modTime;
    }

    /**
    * 设置最后修改时间
    * @param modTime
    */
    public void setModTime(java.util.Date modTime) {
        this.modTime = modTime;
    }

    /**
    * 获得所属市局
    * @return ORG_C
    */
    public String getOrgC() {
        return this.orgC;
    }

    /**
    * 设置所属市局
    * @param orgC
    */
    public void setOrgC(String orgC) {
        this.orgC = orgC;
    }

    /**
    * 获得所属分局
    * @return ORG_S
    */
    public String getOrgS() {
        return this.orgS;
    }

    /**
    * 设置所属分局
    * @param orgS
    */
    public void setOrgS(String orgS) {
        this.orgS = orgS;
    }

    /**
    * 获得所属派出所
    * @return ORG_T
    */
    public String getOrgT() {
        return this.orgT;
    }

    /**
    * 设置所属派出所
    * @param orgT
    */
    public void setOrgT(String orgT) {
        this.orgT = orgT;
    }

    /**
    * 获得数据归属市局
    * @return ORG_C_DATA
    */
    public String getOrgCData() {
        return this.orgCData;
    }

    /**
    * 设置数据归属市局
    * @param orgCData
    */
    public void setOrgCData(String orgCData) {
        this.orgCData = orgCData;
    }

    /**
    * 获得数据归属分局
    * @return ORG_S_DATA
    */
    public String getOrgSData() {
        return this.orgSData;
    }

    /**
    * 设置数据归属分局
    * @param orgSData
    */
    public void setOrgSData(String orgSData) {
        this.orgSData = orgSData;
    }

    /**
    * 获得数据归属派出所
    * @return ORG_T_DATA
    */
    public String getOrgTData() {
        return this.orgTData;
    }

    /**
    * 设置数据归属派出所
    * @param orgTData
    */
    public void setOrgTData(String orgTData) {
        this.orgTData = orgTData;
    }

    /**
    * 获得当前归属单位
    * @return CUR_ORG
    */
    public String getCurOrg() {
        return this.curOrg;
    }

    /**
    * 设置当前归属单位
    * @param curOrg
    */
    public void setCurOrg(String curOrg) {
        this.curOrg = curOrg;
    }

    /**
    * 获得当前数据归属单位
    * @return CUR_ORG_DATA
    */
    public String getCurOrgData() {
        return this.curOrgData;
    }

    /**
    * 设置当前数据归属单位
    * @param curOrgData
    */
    public void setCurOrgData(String curOrgData) {
        this.curOrgData = curOrgData;
    }


}
