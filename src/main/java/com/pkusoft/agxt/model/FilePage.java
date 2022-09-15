package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: FilePage
 */
@ApiModel("案卷页信息表")
@Table(name = "FILE_PAGE")
public class FilePage {

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
     * 案卷ID
     */
    @Column(name = "FILE_ID")
    @ApiModelProperty(value = "案卷ID")
    private String fileId;

 	/**
     * 案卷编号
     */
    @Column(name = "FILE_CODE")
    @ApiModelProperty(value = "案卷编号")
    private String fileCode;

 	/**
     * 案卷名称
     */
    @Column(name = "FILE_NAME")
    @ApiModelProperty(value = "案卷名称")
    private String fileName;

 	/**
     * 材料ID
     */
    @Column(name = "METAL_ID")
    @ApiModelProperty(value = "材料ID")
    private String metalId;

 	/**
     * 材料名称
     */
    @Column(name = "METAL_NAME")
    @ApiModelProperty(value = "材料名称")
    private String metalName;

 	/**
     * 材料类型
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "材料类型")
    private String type;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Double sn;

 	/**
     * 电子案卷存放路径(相对)
     */
    @Column(name = "DISK_PATH")
    @ApiModelProperty(value = "电子案卷存放路径(相对)")
    private String diskPath;

 	/**
     * 电子案卷存放的文件名称
     */
    @Column(name = "DISK_FILENAME")
    @ApiModelProperty(value = "电子案卷存放的文件名称")
    private String diskFilename;

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
     * 刻录次数
     */
    @Column(name = "BURN_COUNT")
    @ApiModelProperty(value = "刻录次数")
    private Integer burnCount;

 	/**
     * 关键词
     */
    @Column(name = "KEYWORDS")
    @ApiModelProperty(value = "关键词")
    private String keywords;

 	/**
     * 当前所有人ID
     */
    @Column(name = "OWNER_ID")
    @ApiModelProperty(value = "当前所有人ID")
    private String ownerId;

 	/**
     * 所有人警号
     */
    @Column(name = "OWNER_CODE")
    @ApiModelProperty(value = "所有人警号")
    private String ownerCode;

 	/**
     * 所有人名称
     */
    @Column(name = "OWNER_NAME")
    @ApiModelProperty(value = "所有人名称")
    private String ownerName;

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
     * 加密图片文件大小
     */
    @Column(name = "ENCRYFILE_SIZE")
    @ApiModelProperty(value = "加密图片文件大小")
    private Integer encryfileSize;

 	/**
     * 原始图片文件大小
     */
    @Column(name = "DIGITFILE_SIZE")
    @ApiModelProperty(value = "原始图片文件大小")
    private Integer digitfileSize;

 	/**
     * 树路径
     */
    @Column(name = "TREE_PATH")
    @ApiModelProperty(value = "树路径")
    private String treePath;

 	/**
     *
     */
    @Column(name = "IS_UPD_PS")
    @ApiModelProperty(value = "")
    private String isUpdPs;

 	/**
     *
     */
    @Column(name = "UPD_PS_TIME")
    @ApiModelProperty(value = "")
    private java.util.Date updPsTime;


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
    * 获得案卷ID
    * @return FILE_ID
    */
    public String getFileId() {
        return this.fileId;
    }

    /**
    * 设置案卷ID
    * @param fileId
    */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
    * 获得案卷编号
    * @return FILE_CODE
    */
    public String getFileCode() {
        return this.fileCode;
    }

    /**
    * 设置案卷编号
    * @param fileCode
    */
    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    /**
    * 获得案卷名称
    * @return FILE_NAME
    */
    public String getFileName() {
        return this.fileName;
    }

    /**
    * 设置案卷名称
    * @param fileName
    */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
    * 获得材料ID
    * @return METAL_ID
    */
    public String getMetalId() {
        return this.metalId;
    }

    /**
    * 设置材料ID
    * @param metalId
    */
    public void setMetalId(String metalId) {
        this.metalId = metalId;
    }

    /**
    * 获得材料名称
    * @return METAL_NAME
    */
    public String getMetalName() {
        return this.metalName;
    }

    /**
    * 设置材料名称
    * @param metalName
    */
    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    /**
    * 获得材料类型
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置材料类型
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
    * 获得电子案卷存放路径(相对)
    * @return DISK_PATH
    */
    public String getDiskPath() {
        return this.diskPath;
    }

    /**
    * 设置电子案卷存放路径(相对)
    * @param diskPath
    */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    /**
    * 获得电子案卷存放的文件名称
    * @return DISK_FILENAME
    */
    public String getDiskFilename() {
        return this.diskFilename;
    }

    /**
    * 设置电子案卷存放的文件名称
    * @param diskFilename
    */
    public void setDiskFilename(String diskFilename) {
        this.diskFilename = diskFilename;
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
    * 获得关键词
    * @return KEYWORDS
    */
    public String getKeywords() {
        return this.keywords;
    }

    /**
    * 设置关键词
    * @param keywords
    */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
    * 获得当前所有人ID
    * @return OWNER_ID
    */
    public String getOwnerId() {
        return this.ownerId;
    }

    /**
    * 设置当前所有人ID
    * @param ownerId
    */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
    * 获得所有人警号
    * @return OWNER_CODE
    */
    public String getOwnerCode() {
        return this.ownerCode;
    }

    /**
    * 设置所有人警号
    * @param ownerCode
    */
    public void setOwnerCode(String ownerCode) {
        this.ownerCode = ownerCode;
    }

    /**
    * 获得所有人名称
    * @return OWNER_NAME
    */
    public String getOwnerName() {
        return this.ownerName;
    }

    /**
    * 设置所有人名称
    * @param ownerName
    */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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
    * 获得加密图片文件大小
    * @return ENCRYFILE_SIZE
    */
    public Integer getEncryfileSize() {
        return this.encryfileSize;
    }

    /**
    * 设置加密图片文件大小
    * @param encryfileSize
    */
    public void setEncryfileSize(Integer encryfileSize) {
        this.encryfileSize = encryfileSize;
    }

    /**
    * 获得原始图片文件大小
    * @return DIGITFILE_SIZE
    */
    public Integer getDigitfileSize() {
        return this.digitfileSize;
    }

    /**
    * 设置原始图片文件大小
    * @param digitfileSize
    */
    public void setDigitfileSize(Integer digitfileSize) {
        this.digitfileSize = digitfileSize;
    }

    /**
    * 获得树路径
    * @return TREE_PATH
    */
    public String getTreePath() {
        return this.treePath;
    }

    /**
    * 设置树路径
    * @param treePath
    */
    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    /**
    * 获得
    * @return IS_UPD_PS
    */
    public String getIsUpdPs() {
        return this.isUpdPs;
    }

    /**
    * 设置
    * @param isUpdPs
    */
    public void setIsUpdPs(String isUpdPs) {
        this.isUpdPs = isUpdPs;
    }

    /**
    * 获得
    * @return UPD_PS_TIME
    */
    public java.util.Date getUpdPsTime() {
        return this.updPsTime;
    }

    /**
    * 设置
    * @param updPsTime
    */
    public void setUpdPsTime(java.util.Date updPsTime) {
        this.updPsTime = updPsTime;
    }


}
