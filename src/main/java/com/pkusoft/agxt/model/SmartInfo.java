package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SmartInfo
 */
@ApiModel("案管智能终端信息表")
@Table(name = "SMART_INFO")
public class SmartInfo {

 	/**
     *
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "")
    private String id;

 	/**
     * 代码
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "代码")
    private String code;

 	/**
     * 名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "名称")
    private String name;

 	/**
     * 类型
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型")
    private String type;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Double sn;

 	/**
     * 应用程序的英文名/代码(Pku.SmartMachine.CFM或Pku.SmartMachine.CFMLite),<Application Code=>
     */
    @Column(name = "APP_CODE")
    @ApiModelProperty(value = "应用程序的英文名/代码(Pku.SmartMachine.CFM或Pku.SmartMachine.CFMLite),<Application Code=>")
    private String appCode;

 	/**
     * 应用程序的名称, <Application Name=>
     */
    @Column(name = "APP_NAME")
    @ApiModelProperty(value = "应用程序的名称, <Application Name=>")
    private String appName;

 	/**
     * 版本代号, <Application VersionCode=>
     */
    @Column(name = "VERSION_CODE")
    @ApiModelProperty(value = "版本代号, <Application VersionCode=>")
    private String versionCode;

 	/**
     * 文件版本号, <Application FileVersion=>
     */
    @Column(name = "FILE_VERSION")
    @ApiModelProperty(value = "文件版本号, <Application FileVersion=>")
    private String fileVersion;

 	/**
     * 所属组织机构编码, <Organization Code=>
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属组织机构编码, <Organization Code=>")
    private String orgCode;

 	/**
     * 所属组织机构名称, <Organization Name=>
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "所属组织机构名称, <Organization Name=>")
    private String orgName;

 	/**
     * 服务开始日期(YYYY-MM-DD), <Service Start=>
     */
    @Column(name = "SVC_START")
    @ApiModelProperty(value = "服务开始日期(YYYY-MM-DD), <Service Start=>")
    private java.util.Date svcStart;

 	/**
     * 期限（天）, <Service Limit=>
     */
    @Column(name = "SVC_LIMIT")
    @ApiModelProperty(value = "期限（天）, <Service Limit=>")
    private Integer svcLimit;

 	/**
     * 最大用户数, <Service MaxUsers=>
     */
    @Column(name = "SVC_USERS")
    @ApiModelProperty(value = "最大用户数, <Service MaxUsers=>")
    private Integer svcUsers;

 	/**
     * 唯一ID, <Smart UID=>
     */
    @Column(name = "SMART_UID")
    @ApiModelProperty(value = "唯一ID, <Smart UID=>")
    private String smartUid;

 	/**
     * Mac地址, <Smart Mac=>
     */
    @Column(name = "MAC")
    @ApiModelProperty(value = "Mac地址, <Smart Mac=>")
    private String mac;

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
     * IP地址, <Smart IP=>
     */
    @Column(name = "IP")
    @ApiModelProperty(value = "IP地址, <Smart IP=>")
    private String ip;


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
    * 获得代码
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置代码
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
    * 获得排序序号
    * @return SN
    */
    public Double getSn() {
        return this.sn;
    }

    /**
    * 设置排序序号
    * @param sn
    */
    public void setSn(Double sn) {
        this.sn = sn;
    }

    /**
    * 获得应用程序的英文名/代码(Pku.SmartMachine.CFM或Pku.SmartMachine.CFMLite),<Application Code=>
    * @return APP_CODE
    */
    public String getAppCode() {
        return this.appCode;
    }

    /**
    * 设置应用程序的英文名/代码(Pku.SmartMachine.CFM或Pku.SmartMachine.CFMLite),<Application Code=>
    * @param appCode
    */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
    * 获得应用程序的名称, <Application Name=>
    * @return APP_NAME
    */
    public String getAppName() {
        return this.appName;
    }

    /**
    * 设置应用程序的名称, <Application Name=>
    * @param appName
    */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
    * 获得版本代号, <Application VersionCode=>
    * @return VERSION_CODE
    */
    public String getVersionCode() {
        return this.versionCode;
    }

    /**
    * 设置版本代号, <Application VersionCode=>
    * @param versionCode
    */
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    /**
    * 获得文件版本号, <Application FileVersion=>
    * @return FILE_VERSION
    */
    public String getFileVersion() {
        return this.fileVersion;
    }

    /**
    * 设置文件版本号, <Application FileVersion=>
    * @param fileVersion
    */
    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    /**
    * 获得所属组织机构编码, <Organization Code=>
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置所属组织机构编码, <Organization Code=>
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得所属组织机构名称, <Organization Name=>
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置所属组织机构名称, <Organization Name=>
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
    * 获得服务开始日期(YYYY-MM-DD), <Service Start=>
    * @return SVC_START
    */
    public java.util.Date getSvcStart() {
        return this.svcStart;
    }

    /**
    * 设置服务开始日期(YYYY-MM-DD), <Service Start=>
    * @param svcStart
    */
    public void setSvcStart(java.util.Date svcStart) {
        this.svcStart = svcStart;
    }

    /**
    * 获得期限（天）, <Service Limit=>
    * @return SVC_LIMIT
    */
    public Integer getSvcLimit() {
        return this.svcLimit;
    }

    /**
    * 设置期限（天）, <Service Limit=>
    * @param svcLimit
    */
    public void setSvcLimit(Integer svcLimit) {
        this.svcLimit = svcLimit;
    }

    /**
    * 获得最大用户数, <Service MaxUsers=>
    * @return SVC_USERS
    */
    public Integer getSvcUsers() {
        return this.svcUsers;
    }

    /**
    * 设置最大用户数, <Service MaxUsers=>
    * @param svcUsers
    */
    public void setSvcUsers(Integer svcUsers) {
        this.svcUsers = svcUsers;
    }

    /**
    * 获得唯一ID, <Smart UID=>
    * @return SMART_UID
    */
    public String getSmartUid() {
        return this.smartUid;
    }

    /**
    * 设置唯一ID, <Smart UID=>
    * @param smartUid
    */
    public void setSmartUid(String smartUid) {
        this.smartUid = smartUid;
    }

    /**
    * 获得Mac地址, <Smart Mac=>
    * @return MAC
    */
    public String getMac() {
        return this.mac;
    }

    /**
    * 设置Mac地址, <Smart Mac=>
    * @param mac
    */
    public void setMac(String mac) {
        this.mac = mac;
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

    /**
    * 获得IP地址, <Smart IP=>
    * @return IP
    */
    public String getIp() {
        return this.ip;
    }

    /**
    * 设置IP地址, <Smart IP=>
    * @param ip
    */
    public void setIp(String ip) {
        this.ip = ip;
    }


}
