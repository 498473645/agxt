package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: CaseInfo
 */
@ApiModel("案件信息表")
@Table(name = "CASE_INFO")
public class CaseInfo {

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
     * 案件类型（0010 - 刑事；0020 - 行政）
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "案件类型（0010 - 刑事；0020 - 行政）")
    private String type;

 	/**
     * 案件类型名称
     */
    @Column(name = "TYPE_NAME")
    @ApiModelProperty(value = "案件类型名称")
    private String typeName;

 	/**
     *
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "")
    private Integer sn;

 	/**
     * 案由/罪名
     */
    @Column(name = "CAUSE")
    @ApiModelProperty(value = "案由/罪名")
    private String cause;

 	/**
     * 来源
     */
    @Column(name = "SOURCE")
    @ApiModelProperty(value = "来源")
    private String source;

 	/**
     * 案情简述
     */
    @Column(name = "DETAIL")
    @ApiModelProperty(value = "案情简述")
    private String detail;

 	/**
     * 案发时间上限
     */
    @Column(name = "CASE_TIME_U")
    @ApiModelProperty(value = "案发时间上限")
    private java.util.Date caseTimeU;

 	/**
     * 案发时间下限
     */
    @Column(name = "CASE_TIME_D")
    @ApiModelProperty(value = "案发时间下限")
    private java.util.Date caseTimeD;

 	/**
     * 办案机构编码
     */
    @Column(name = "HANDLE_ORG_CODE")
    @ApiModelProperty(value = "办案机构编码")
    private String handleOrgCode;

 	/**
     * 办案机构名称
     */
    @Column(name = "HANDLE_ORG_NAME")
    @ApiModelProperty(value = "办案机构名称")
    private String handleOrgName;

 	/**
     * 主办人ID
     */
    @Column(name = "HOSTER_ID")
    @ApiModelProperty(value = "主办人ID")
    private String hosterId;

 	/**
     * 主办人警号
     */
    @Column(name = "HOSTER_PCODE")
    @ApiModelProperty(value = "主办人警号")
    private String hosterPcode;

 	/**
     * 主办人姓名
     */
    @Column(name = "HOSTER_NAME")
    @ApiModelProperty(value = "主办人姓名")
    private String hosterName;

 	/**
     * 案发地
     */
    @Column(name = "CASE_PLACE")
    @ApiModelProperty(value = "案发地")
    private String casePlace;

 	/**
     * 报案时间
     */
    @Column(name = "REPORT_TIME")
    @ApiModelProperty(value = "报案时间")
    private java.util.Date reportTime;

 	/**
     * 报案人
     */
    @Column(name = "REPORTER")
    @ApiModelProperty(value = "报案人")
    private String reporter;

 	/**
     * 报案人住址
     */
    @Column(name = "REPORTER_ADD")
    @ApiModelProperty(value = "报案人住址")
    private String reporterAdd;

 	/**
     * 报案人联系方式
     */
    @Column(name = "REPORTER_TEL")
    @ApiModelProperty(value = "报案人联系方式")
    private String reporterTel;

 	/**
     * 接警时间
     */
    @Column(name = "ALARM_TIME")
    @ApiModelProperty(value = "接警时间")
    private java.util.Date alarmTime;

 	/**
     * 接警人姓名
     */
    @Column(name = "ALARM_NAME")
    @ApiModelProperty(value = "接警人姓名")
    private String alarmName;

 	/**
     * 受理时间
     */
    @Column(name = "ACCEPT_TIME")
    @ApiModelProperty(value = "受理时间")
    private java.util.Date acceptTime;

 	/**
     * 受理人警号
     */
    @Column(name = "ACCEPT_PCODE")
    @ApiModelProperty(value = "受理人警号")
    private String acceptPcode;

 	/**
     * 受理人姓名
     */
    @Column(name = "ACCEPT_NAME")
    @ApiModelProperty(value = "受理人姓名")
    private String acceptName;

 	/**
     * 受理人单位编码
     */
    @Column(name = "ACCEPT_ORG_CODE")
    @ApiModelProperty(value = "受理人单位编码")
    private String acceptOrgCode;

 	/**
     * 受理人单位名称
     */
    @Column(name = "ACCEPT_ORG_NAME")
    @ApiModelProperty(value = "受理人单位名称")
    private String acceptOrgName;

 	/**
     * 受理地点
     */
    @Column(name = "ACCEPT_LOCALE")
    @ApiModelProperty(value = "受理地点")
    private String acceptLocale;

 	/**
     * 当前办理阶段ID
     */
    @Column(name = "CURSTEP_ID")
    @ApiModelProperty(value = "当前办理阶段ID")
    private String curstepId;

 	/**
     * 当前办理阶段名称
     */
    @Column(name = "CURSTEP_NAME")
    @ApiModelProperty(value = "当前办理阶段名称")
    private String curstepName;

 	/**
     * 立案时间
     */
    @Column(name = "REG_TIME")
    @ApiModelProperty(value = "立案时间")
    private java.util.Date regTime;

 	/**
     * 接收时间
     */
    @Column(name = "RECV_TIME")
    @ApiModelProperty(value = "接收时间")
    private java.util.Date recvTime;

 	/**
     * 0：表示从执法监督平台获取；1：表示系统手工录入
     */
    @Column(name = "DATA_SOURCE")
    @ApiModelProperty(value = "0：表示从执法监督平台获取；1：表示系统手工录入")
    private String dataSource;

 	/**
     * 建卷次数
     */
    @Column(name = "FILES_COUNT")
    @ApiModelProperty(value = "建卷次数")
    private Integer filesCount;

 	/**
     * 打印编号
     */
    @Column(name = "PRINT_CODE")
    @ApiModelProperty(value = "打印编号")
    private String printCode;

 	/**
     * 打印次数
     */
    @Column(name = "PRINT_COUNT")
    @ApiModelProperty(value = "打印次数")
    private Integer printCount;

 	/**
     *
     */
    @Column(name = "BURN_COUNT")
    @ApiModelProperty(value = "")
    private Integer burnCount;

 	/**
     * 嫌疑人姓名
     */
    @Column(name = "KEYWORDS")
    @ApiModelProperty(value = "嫌疑人姓名")
    private String keywords;

 	/**
     * 状态
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态")
    private String status;

 	/**
     * 嫌疑人姓名拼音码
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "嫌疑人姓名拼音码")
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
     * 关联案件编号
     */
    @Column(name = "RELATE_CASE")
    @ApiModelProperty(value = "关联案件编号")
    private String relateCase;

 	/**
     * 案件名称拼音简码
     */
    @Column(name = "NAME_SPELL")
    @ApiModelProperty(value = "案件名称拼音简码")
    private String nameSpell;

 	/**
     * 主办人姓名拼音简码
     */
    @Column(name = "HOSTER_SPELL")
    @ApiModelProperty(value = "主办人姓名拼音简码")
    private String hosterSpell;


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
    * 获得案件类型（0010 - 刑事；0020 - 行政）
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置案件类型（0010 - 刑事；0020 - 行政）
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得案件类型名称
    * @return TYPE_NAME
    */
    public String getTypeName() {
        return this.typeName;
    }

    /**
    * 设置案件类型名称
    * @param typeName
    */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
    * 获得
    * @return SN
    */
    public Integer getSn() {
        return this.sn;
    }

    /**
    * 设置
    * @param sn
    */
    public void setSn(Integer sn) {
        this.sn = sn;
    }

    /**
    * 获得案由/罪名
    * @return CAUSE
    */
    public String getCause() {
        return this.cause;
    }

    /**
    * 设置案由/罪名
    * @param cause
    */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
    * 获得来源
    * @return SOURCE
    */
    public String getSource() {
        return this.source;
    }

    /**
    * 设置来源
    * @param source
    */
    public void setSource(String source) {
        this.source = source;
    }

    /**
    * 获得案情简述
    * @return DETAIL
    */
    public String getDetail() {
        return this.detail;
    }

    /**
    * 设置案情简述
    * @param detail
    */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
    * 获得案发时间上限
    * @return CASE_TIME_U
    */
    public java.util.Date getCaseTimeU() {
        return this.caseTimeU;
    }

    /**
    * 设置案发时间上限
    * @param caseTimeU
    */
    public void setCaseTimeU(java.util.Date caseTimeU) {
        this.caseTimeU = caseTimeU;
    }

    /**
    * 获得案发时间下限
    * @return CASE_TIME_D
    */
    public java.util.Date getCaseTimeD() {
        return this.caseTimeD;
    }

    /**
    * 设置案发时间下限
    * @param caseTimeD
    */
    public void setCaseTimeD(java.util.Date caseTimeD) {
        this.caseTimeD = caseTimeD;
    }

    /**
    * 获得办案机构编码
    * @return HANDLE_ORG_CODE
    */
    public String getHandleOrgCode() {
        return this.handleOrgCode;
    }

    /**
    * 设置办案机构编码
    * @param handleOrgCode
    */
    public void setHandleOrgCode(String handleOrgCode) {
        this.handleOrgCode = handleOrgCode;
    }

    /**
    * 获得办案机构名称
    * @return HANDLE_ORG_NAME
    */
    public String getHandleOrgName() {
        return this.handleOrgName;
    }

    /**
    * 设置办案机构名称
    * @param handleOrgName
    */
    public void setHandleOrgName(String handleOrgName) {
        this.handleOrgName = handleOrgName;
    }

    /**
    * 获得主办人ID
    * @return HOSTER_ID
    */
    public String getHosterId() {
        return this.hosterId;
    }

    /**
    * 设置主办人ID
    * @param hosterId
    */
    public void setHosterId(String hosterId) {
        this.hosterId = hosterId;
    }

    /**
    * 获得主办人警号
    * @return HOSTER_PCODE
    */
    public String getHosterPcode() {
        return this.hosterPcode;
    }

    /**
    * 设置主办人警号
    * @param hosterPcode
    */
    public void setHosterPcode(String hosterPcode) {
        this.hosterPcode = hosterPcode;
    }

    /**
    * 获得主办人姓名
    * @return HOSTER_NAME
    */
    public String getHosterName() {
        return this.hosterName;
    }

    /**
    * 设置主办人姓名
    * @param hosterName
    */
    public void setHosterName(String hosterName) {
        this.hosterName = hosterName;
    }

    /**
    * 获得案发地
    * @return CASE_PLACE
    */
    public String getCasePlace() {
        return this.casePlace;
    }

    /**
    * 设置案发地
    * @param casePlace
    */
    public void setCasePlace(String casePlace) {
        this.casePlace = casePlace;
    }

    /**
    * 获得报案时间
    * @return REPORT_TIME
    */
    public java.util.Date getReportTime() {
        return this.reportTime;
    }

    /**
    * 设置报案时间
    * @param reportTime
    */
    public void setReportTime(java.util.Date reportTime) {
        this.reportTime = reportTime;
    }

    /**
    * 获得报案人
    * @return REPORTER
    */
    public String getReporter() {
        return this.reporter;
    }

    /**
    * 设置报案人
    * @param reporter
    */
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    /**
    * 获得报案人住址
    * @return REPORTER_ADD
    */
    public String getReporterAdd() {
        return this.reporterAdd;
    }

    /**
    * 设置报案人住址
    * @param reporterAdd
    */
    public void setReporterAdd(String reporterAdd) {
        this.reporterAdd = reporterAdd;
    }

    /**
    * 获得报案人联系方式
    * @return REPORTER_TEL
    */
    public String getReporterTel() {
        return this.reporterTel;
    }

    /**
    * 设置报案人联系方式
    * @param reporterTel
    */
    public void setReporterTel(String reporterTel) {
        this.reporterTel = reporterTel;
    }

    /**
    * 获得接警时间
    * @return ALARM_TIME
    */
    public java.util.Date getAlarmTime() {
        return this.alarmTime;
    }

    /**
    * 设置接警时间
    * @param alarmTime
    */
    public void setAlarmTime(java.util.Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    /**
    * 获得接警人姓名
    * @return ALARM_NAME
    */
    public String getAlarmName() {
        return this.alarmName;
    }

    /**
    * 设置接警人姓名
    * @param alarmName
    */
    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    /**
    * 获得受理时间
    * @return ACCEPT_TIME
    */
    public java.util.Date getAcceptTime() {
        return this.acceptTime;
    }

    /**
    * 设置受理时间
    * @param acceptTime
    */
    public void setAcceptTime(java.util.Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
    * 获得受理人警号
    * @return ACCEPT_PCODE
    */
    public String getAcceptPcode() {
        return this.acceptPcode;
    }

    /**
    * 设置受理人警号
    * @param acceptPcode
    */
    public void setAcceptPcode(String acceptPcode) {
        this.acceptPcode = acceptPcode;
    }

    /**
    * 获得受理人姓名
    * @return ACCEPT_NAME
    */
    public String getAcceptName() {
        return this.acceptName;
    }

    /**
    * 设置受理人姓名
    * @param acceptName
    */
    public void setAcceptName(String acceptName) {
        this.acceptName = acceptName;
    }

    /**
    * 获得受理人单位编码
    * @return ACCEPT_ORG_CODE
    */
    public String getAcceptOrgCode() {
        return this.acceptOrgCode;
    }

    /**
    * 设置受理人单位编码
    * @param acceptOrgCode
    */
    public void setAcceptOrgCode(String acceptOrgCode) {
        this.acceptOrgCode = acceptOrgCode;
    }

    /**
    * 获得受理人单位名称
    * @return ACCEPT_ORG_NAME
    */
    public String getAcceptOrgName() {
        return this.acceptOrgName;
    }

    /**
    * 设置受理人单位名称
    * @param acceptOrgName
    */
    public void setAcceptOrgName(String acceptOrgName) {
        this.acceptOrgName = acceptOrgName;
    }

    /**
    * 获得受理地点
    * @return ACCEPT_LOCALE
    */
    public String getAcceptLocale() {
        return this.acceptLocale;
    }

    /**
    * 设置受理地点
    * @param acceptLocale
    */
    public void setAcceptLocale(String acceptLocale) {
        this.acceptLocale = acceptLocale;
    }

    /**
    * 获得当前办理阶段ID
    * @return CURSTEP_ID
    */
    public String getCurstepId() {
        return this.curstepId;
    }

    /**
    * 设置当前办理阶段ID
    * @param curstepId
    */
    public void setCurstepId(String curstepId) {
        this.curstepId = curstepId;
    }

    /**
    * 获得当前办理阶段名称
    * @return CURSTEP_NAME
    */
    public String getCurstepName() {
        return this.curstepName;
    }

    /**
    * 设置当前办理阶段名称
    * @param curstepName
    */
    public void setCurstepName(String curstepName) {
        this.curstepName = curstepName;
    }

    /**
    * 获得立案时间
    * @return REG_TIME
    */
    public java.util.Date getRegTime() {
        return this.regTime;
    }

    /**
    * 设置立案时间
    * @param regTime
    */
    public void setRegTime(java.util.Date regTime) {
        this.regTime = regTime;
    }

    /**
    * 获得接收时间
    * @return RECV_TIME
    */
    public java.util.Date getRecvTime() {
        return this.recvTime;
    }

    /**
    * 设置接收时间
    * @param recvTime
    */
    public void setRecvTime(java.util.Date recvTime) {
        this.recvTime = recvTime;
    }

    /**
    * 获得0：表示从执法监督平台获取；1：表示系统手工录入
    * @return DATA_SOURCE
    */
    public String getDataSource() {
        return this.dataSource;
    }

    /**
    * 设置0：表示从执法监督平台获取；1：表示系统手工录入
    * @param dataSource
    */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
    * 获得建卷次数
    * @return FILES_COUNT
    */
    public Integer getFilesCount() {
        return this.filesCount;
    }

    /**
    * 设置建卷次数
    * @param filesCount
    */
    public void setFilesCount(Integer filesCount) {
        this.filesCount = filesCount;
    }

    /**
    * 获得打印编号
    * @return PRINT_CODE
    */
    public String getPrintCode() {
        return this.printCode;
    }

    /**
    * 设置打印编号
    * @param printCode
    */
    public void setPrintCode(String printCode) {
        this.printCode = printCode;
    }

    /**
    * 获得打印次数
    * @return PRINT_COUNT
    */
    public Integer getPrintCount() {
        return this.printCount;
    }

    /**
    * 设置打印次数
    * @param printCount
    */
    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    /**
    * 获得
    * @return BURN_COUNT
    */
    public Integer getBurnCount() {
        return this.burnCount;
    }

    /**
    * 设置
    * @param burnCount
    */
    public void setBurnCount(Integer burnCount) {
        this.burnCount = burnCount;
    }

    /**
    * 获得嫌疑人姓名
    * @return KEYWORDS
    */
    public String getKeywords() {
        return this.keywords;
    }

    /**
    * 设置嫌疑人姓名
    * @param keywords
    */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
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
    * 获得嫌疑人姓名拼音码
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置嫌疑人姓名拼音码
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
    * 获得关联案件编号
    * @return RELATE_CASE
    */
    public String getRelateCase() {
        return this.relateCase;
    }

    /**
    * 设置关联案件编号
    * @param relateCase
    */
    public void setRelateCase(String relateCase) {
        this.relateCase = relateCase;
    }

    /**
    * 获得案件名称拼音简码
    * @return NAME_SPELL
    */
    public String getNameSpell() {
        return this.nameSpell;
    }

    /**
    * 设置案件名称拼音简码
    * @param nameSpell
    */
    public void setNameSpell(String nameSpell) {
        this.nameSpell = nameSpell;
    }

    /**
    * 获得主办人姓名拼音简码
    * @return HOSTER_SPELL
    */
    public String getHosterSpell() {
        return this.hosterSpell;
    }

    /**
    * 设置主办人姓名拼音简码
    * @param hosterSpell
    */
    public void setHosterSpell(String hosterSpell) {
        this.hosterSpell = hosterSpell;
    }


}
