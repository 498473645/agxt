package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: FileInfoA
 */
@ApiModel("案卷信息归档表")
@Table(name = "FILE_INFO_A")
public class FileInfoA {

 	/**
     *
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "")
    private String id;

 	/**
     * 代码(案件编号)
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "代码(案件编号)")
    private String code;

 	/**
     * 名称(案件名称)
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "名称(案件名称)")
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
     *
     */
    @Column(name = "CASE_NAME")
    @ApiModelProperty(value = "")
    private String caseName;

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
     * 案卷类型(案件的类型)
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "案卷类型(案件的类型)")
    private String type;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Integer sn;

 	/**
     * 存放场所ID
     */
    @Column(name = "PLACE_ID")
    @ApiModelProperty(value = "存放场所ID")
    private String placeId;

 	/**
     * 存放场所名称
     */
    @Column(name = "PLACE_NAME")
    @ApiModelProperty(value = "存放场所名称")
    private String placeName;

 	/**
     * 存放区域ID
     */
    @Column(name = "AREA_ID")
    @ApiModelProperty(value = "存放区域ID")
    private String areaId;

 	/**
     * 存放区域名称
     */
    @Column(name = "AREA_NAME")
    @ApiModelProperty(value = "存放区域名称")
    private String areaName;

 	/**
     * 存放空间ID
     */
    @Column(name = "SPACE_ID")
    @ApiModelProperty(value = "存放空间ID")
    private String spaceId;

 	/**
     * 存放空间名称
     */
    @Column(name = "SPACE_NAME")
    @ApiModelProperty(value = "存放空间名称")
    private String spaceName;

 	/**
     * 空间格ID
     */
    @Column(name = "CELL_ID")
    @ApiModelProperty(value = "空间格ID")
    private String cellId;

 	/**
     * 空间格名称
     */
    @Column(name = "CELL_NAME")
    @ApiModelProperty(value = "空间格名称")
    private String cellName;

 	/**
     * 磁盘路径(相对)
     */
    @Column(name = "DISK_PATH")
    @ApiModelProperty(value = "磁盘路径(相对)")
    private String diskPath;

 	/**
     * 是否采集
     */
    @Column(name = "IS_SCAN")
    @ApiModelProperty(value = "是否采集")
    private Integer isScan;

 	/**
     * 已采集材料的页总数
     */
    @Column(name = "PAGE_COUNT")
    @ApiModelProperty(value = "已采集材料的页总数")
    private Integer pageCount;

 	/**
     *
     */
    @Column(name = "PRINT_CODE")
    @ApiModelProperty(value = "")
    private String printCode;

 	/**
     * 打印次数
     */
    @Column(name = "PRINT_COUNT")
    @ApiModelProperty(value = "打印次数")
    private Integer printCount;

 	/**
     * 刻录次数
     */
    @Column(name = "BURN_COUNT")
    @ApiModelProperty(value = "刻录次数")
    private Integer burnCount;

 	/**
     * 嫌疑人姓名
     */
    @Column(name = "KEYWORDS")
    @ApiModelProperty(value = "嫌疑人姓名")
    private String keywords;

 	/**
     * 案卷名称拼音简码
     */
    @Column(name = "NAME_SPELL")
    @ApiModelProperty(value = "案卷名称拼音简码")
    private String nameSpell;

 	/**
     * 主办人姓名拼音简码
     */
    @Column(name = "HOSTER_SPELL")
    @ApiModelProperty(value = "主办人姓名拼音简码")
    private String hosterSpell;

 	/**
     * 补充侦查次数
     */
    @Column(name = "SUPPLEINV_COUNT")
    @ApiModelProperty(value = "补充侦查次数")
    private Integer suppleinvCount;

 	/**
     * 受理时间
     */
    @Column(name = "ACCEPT_TIME")
    @ApiModelProperty(value = "受理时间")
    private java.util.Date acceptTime;

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
    * 获得代码(案件编号)
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置代码(案件编号)
    * @param code
    */
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * 获得名称(案件名称)
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置名称(案件名称)
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
    * 获得
    * @return CASE_NAME
    */
    public String getCaseName() {
        return this.caseName;
    }

    /**
    * 设置
    * @param caseName
    */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
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
    * 获得案卷类型(案件的类型)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置案卷类型(案件的类型)
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
    * 获得存放场所ID
    * @return PLACE_ID
    */
    public String getPlaceId() {
        return this.placeId;
    }

    /**
    * 设置存放场所ID
    * @param placeId
    */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
    * 获得存放场所名称
    * @return PLACE_NAME
    */
    public String getPlaceName() {
        return this.placeName;
    }

    /**
    * 设置存放场所名称
    * @param placeName
    */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
    * 获得存放区域ID
    * @return AREA_ID
    */
    public String getAreaId() {
        return this.areaId;
    }

    /**
    * 设置存放区域ID
    * @param areaId
    */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
    * 获得存放区域名称
    * @return AREA_NAME
    */
    public String getAreaName() {
        return this.areaName;
    }

    /**
    * 设置存放区域名称
    * @param areaName
    */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
    * 获得存放空间ID
    * @return SPACE_ID
    */
    public String getSpaceId() {
        return this.spaceId;
    }

    /**
    * 设置存放空间ID
    * @param spaceId
    */
    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    /**
    * 获得存放空间名称
    * @return SPACE_NAME
    */
    public String getSpaceName() {
        return this.spaceName;
    }

    /**
    * 设置存放空间名称
    * @param spaceName
    */
    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    /**
    * 获得空间格ID
    * @return CELL_ID
    */
    public String getCellId() {
        return this.cellId;
    }

    /**
    * 设置空间格ID
    * @param cellId
    */
    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    /**
    * 获得空间格名称
    * @return CELL_NAME
    */
    public String getCellName() {
        return this.cellName;
    }

    /**
    * 设置空间格名称
    * @param cellName
    */
    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    /**
    * 获得磁盘路径(相对)
    * @return DISK_PATH
    */
    public String getDiskPath() {
        return this.diskPath;
    }

    /**
    * 设置磁盘路径(相对)
    * @param diskPath
    */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    /**
    * 获得是否采集
    * @return IS_SCAN
    */
    public Integer getIsScan() {
        return this.isScan;
    }

    /**
    * 设置是否采集
    * @param isScan
    */
    public void setIsScan(Integer isScan) {
        this.isScan = isScan;
    }

    /**
    * 获得已采集材料的页总数
    * @return PAGE_COUNT
    */
    public Integer getPageCount() {
        return this.pageCount;
    }

    /**
    * 设置已采集材料的页总数
    * @param pageCount
    */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
    * 获得
    * @return PRINT_CODE
    */
    public String getPrintCode() {
        return this.printCode;
    }

    /**
    * 设置
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
    * 获得刻录次数
    * @return BURN_COUNT
    */
    public Integer getBurnCount() {
        return this.burnCount;
    }

    /**
    * 设置刻录次数
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
    * 获得案卷名称拼音简码
    * @return NAME_SPELL
    */
    public String getNameSpell() {
        return this.nameSpell;
    }

    /**
    * 设置案卷名称拼音简码
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

    /**
    * 获得补充侦查次数
    * @return SUPPLEINV_COUNT
    */
    public Integer getSuppleinvCount() {
        return this.suppleinvCount;
    }

    /**
    * 设置补充侦查次数
    * @param suppleinvCount
    */
    public void setSuppleinvCount(Integer suppleinvCount) {
        this.suppleinvCount = suppleinvCount;
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


}
