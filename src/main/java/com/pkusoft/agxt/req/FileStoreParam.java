package com.pkusoft.agxt.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: FileStore
 */
@ApiModel("案卷存储表")
@Table(name = "FILE_STORE")
public class FileStoreParam {

 	/**
     * ID
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "ID")
    private String id;

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
     * 材料页ID
     */
    @Column(name = "PAGE_ID")
    @ApiModelProperty(value = "材料页ID")
    private String pageId;

 	/**
     * 案卷页名称
     */
    @Column(name = "PAGE_NAME")
    @ApiModelProperty(value = "案卷页名称")
    private String pageName;

 	/**
     * 场所ID
     */
    @Column(name = "PLACE_ID")
    @ApiModelProperty(value = "场所ID")
    private String placeId;

 	/**
     * 场所名称
     */
    @Column(name = "PLACE_NAME")
    @ApiModelProperty(value = "场所名称")
    private String placeName;

 	/**
     * 区域ID
     */
    @Column(name = "AREA_ID")
    @ApiModelProperty(value = "区域ID")
    private String areaId;

 	/**
     * 区域名称
     */
    @Column(name = "AREA_NAME")
    @ApiModelProperty(value = "区域名称")
    private String areaName;

 	/**
     * 空间ID
     */
    @Column(name = "SPACE_ID")
    @ApiModelProperty(value = "空间ID")
    private String spaceId;

 	/**
     * 案卷柜空间
     */
    @Column(name = "SPACE_NAME")
    @ApiModelProperty(value = "案卷柜空间")
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
     * 放入时间
     */
    @Column(name = "ENTRY_TIME")
    @ApiModelProperty(value = "放入时间")
    private java.util.Date entryTime;

 	/**
     * 所有人ID
     */
    @Column(name = "OWNER_ID")
    @ApiModelProperty(value = "所有人ID")
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
     * 当前所在单位编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "当前所在单位编码")
    private String orgCode;

 	/**
     * 当前所在单位名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "当前所在单位名称")
    private String orgName;

 	/**
     * 状态(未分配，已分配，已存放，已锁定...)
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态(未分配，已分配，已存放，已锁定...)")
    private String status;

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
     *
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "")
    private String reserve1;


    /**
    * 获得ID
    * @return ID
    */
    public String getId() {
        return this.id;
    }

    /**
    * 设置ID
    * @param id
    */
    public void setId(String id) {
        this.id = id;
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
    * 获得材料页ID
    * @return PAGE_ID
    */
    public String getPageId() {
        return this.pageId;
    }

    /**
    * 设置材料页ID
    * @param pageId
    */
    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    /**
    * 获得案卷页名称
    * @return PAGE_NAME
    */
    public String getPageName() {
        return this.pageName;
    }

    /**
    * 设置案卷页名称
    * @param pageName
    */
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    /**
    * 获得场所ID
    * @return PLACE_ID
    */
    public String getPlaceId() {
        return this.placeId;
    }

    /**
    * 设置场所ID
    * @param placeId
    */
    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    /**
    * 获得场所名称
    * @return PLACE_NAME
    */
    public String getPlaceName() {
        return this.placeName;
    }

    /**
    * 设置场所名称
    * @param placeName
    */
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    /**
    * 获得区域ID
    * @return AREA_ID
    */
    public String getAreaId() {
        return this.areaId;
    }

    /**
    * 设置区域ID
    * @param areaId
    */
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    /**
    * 获得区域名称
    * @return AREA_NAME
    */
    public String getAreaName() {
        return this.areaName;
    }

    /**
    * 设置区域名称
    * @param areaName
    */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
    * 获得空间ID
    * @return SPACE_ID
    */
    public String getSpaceId() {
        return this.spaceId;
    }

    /**
    * 设置空间ID
    * @param spaceId
    */
    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    /**
    * 获得案卷柜空间
    * @return SPACE_NAME
    */
    public String getSpaceName() {
        return this.spaceName;
    }

    /**
    * 设置案卷柜空间
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
    * 获得放入时间
    * @return ENTRY_TIME
    */
    public java.util.Date getEntryTime() {
        return this.entryTime;
    }

    /**
    * 设置放入时间
    * @param entryTime
    */
    public void setEntryTime(java.util.Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
    * 获得所有人ID
    * @return OWNER_ID
    */
    public String getOwnerId() {
        return this.ownerId;
    }

    /**
    * 设置所有人ID
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
    * 获得当前所在单位编码
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置当前所在单位编码
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得当前所在单位名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置当前所在单位名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
    * 获得状态(未分配，已分配，已存放，已锁定...)
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态(未分配，已分配，已存放，已锁定...)
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
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
    * 获得
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置
    * @param reserve1
    */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }


}
