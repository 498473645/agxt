package com.pkusoft.agxt.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: CabSpace
 */
@ApiModel("案卷柜空间信息表")
@Table(name = "CAB_SPACE")
public class CabSpaceParam extends Page {

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
     * 类型
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型")
    private String type;

 	/**
     * 组号
     */
    @Column(name = "GROUP_CODE")
    @ApiModelProperty(value = "组号")
    private String groupCode;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Double sn;

 	/**
     * 所有人ID
     */
    @Column(name = "OWNER_ID")
    @ApiModelProperty(value = "所有人ID")
    private String ownerId;

 	/**
     * 所有人姓名
     */
    @Column(name = "OWNER_NAME")
    @ApiModelProperty(value = "所有人姓名")
    private String ownerName;

 	/**
     * 空间格总数
     */
    @Column(name = "CELL_COUNT")
    @ApiModelProperty(value = "空间格总数")
    private Integer cellCount;

 	/**
     * 容量
     */
    @Column(name = "CAPACITY")
    @ApiModelProperty(value = "容量")
    private Integer capacity;

 	/**
     * 已使用容量
     */
    @Column(name = "USED_CAP")
    @ApiModelProperty(value = "已使用容量")
    private Integer usedCap;

 	/**
     * 是否已满
     */
    @Column(name = "IS_FULL")
    @ApiModelProperty(value = "是否已满")
    private Integer isFull;

 	/**
     * 所属机构编码(使用者)
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属机构编码(使用者)")
    private String orgCode;

 	/**
     * 所属机构名称(使用者)
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "所属机构名称(使用者)")
    private String orgName;

 	/**
     * 状态  0000 - 空，关 0010 - 空，开 0020 - 空，关，加密 0030 - 空，开，加密 0100 - 已存放，关 0110 - 已存放，开 0120 - 已存放，关，加密 0130 - 已存放，开，加密 0900 - 满，关 0910 - 满，开 0920 - 满，关，加密 0930 - 满，开，加密
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态  0000 - 空，关 0010 - 空，开 0020 - 空，关，加密 0030 - 空，开，加密 0100 - 已存放，关 0110 - 已存放，开 0120 - 已存放，关，加密 0130 - 已存放，开，加密 0900 - 满，关 0910 - 满，开 0920 - 满，关，加密 0930 - 满，开，加密")
    private String status;

 	/**
     * 人像案管柜组号(唯一)
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "人像案管柜组号(唯一)")
    private String reserve1;

 	/**
     * 预留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "预留字段2")
    private String reserve2;

 	/**
     * 是否存在(1:存在,0:不存在)
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "是否存在(1:存在,0:不存在)")
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
     * 是否公有, 1 - 公有, 0 - 私有
     */
    @Column(name = "IS_PUBLIC")
    @ApiModelProperty(value = "是否公有, 1 - 公有, 0 - 私有")
    private Integer isPublic;

 	/**
     * 当前归属单位(所属者)
     */
    @Column(name = "CUR_ORG")
    @ApiModelProperty(value = "当前归属单位(所属者)")
    private String curOrg;

 	/**
     * 当前数据归属单位
     */
    @Column(name = "CUR_ORG_DATA")
    @ApiModelProperty(value = "当前数据归属单位")
    private String curOrgData;

 	/**
     * 容纳案卷数
     */
    @Column(name = "FILE_COUNT")
    @ApiModelProperty(value = "容纳案卷数")
    private Integer fileCount;

 	/**
     * 已放入案卷数
     */
    @Column(name = "CUR_FILE_COUNT")
    @ApiModelProperty(value = "已放入案卷数")
    private Integer curFileCount;

    private String curOrgName;
    private String deptName;
    private String fileId;

    private String spaceNoPrefix;
    private Integer spaceNoStartValue;
    private Integer spaceNoCountValue;
    private String ip;
    private String port;

    public String getSpaceNoPrefix() {
        return spaceNoPrefix;
    }

    public void setSpaceNoPrefix(String spaceNoPrefix) {
        this.spaceNoPrefix = spaceNoPrefix;
    }

    public Integer getSpaceNoStartValue() {
        return spaceNoStartValue;
    }

    public void setSpaceNoStartValue(Integer spaceNoStartValue) {
        this.spaceNoStartValue = spaceNoStartValue;
    }

    public Integer getSpaceNoCountValue() {
        return spaceNoCountValue;
    }

    public void setSpaceNoCountValue(Integer spaceNoCountValue) {
        this.spaceNoCountValue = spaceNoCountValue;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getCurOrgName() {
        return curOrgName;
    }

    public void setCurOrgName(String curOrgName) {
        this.curOrgName = curOrgName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

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
    * 获得组号
    * @return GROUP_CODE
    */
    public String getGroupCode() {
        return this.groupCode;
    }

    /**
    * 设置组号
    * @param groupCode
    */
    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
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
    * 获得所有人姓名
    * @return OWNER_NAME
    */
    public String getOwnerName() {
        return this.ownerName;
    }

    /**
    * 设置所有人姓名
    * @param ownerName
    */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
    * 获得空间格总数
    * @return CELL_COUNT
    */
    public Integer getCellCount() {
        return this.cellCount;
    }

    /**
    * 设置空间格总数
    * @param cellCount
    */
    public void setCellCount(Integer cellCount) {
        this.cellCount = cellCount;
    }

    /**
    * 获得容量
    * @return CAPACITY
    */
    public Integer getCapacity() {
        return this.capacity;
    }

    /**
    * 设置容量
    * @param capacity
    */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
    * 获得已使用容量
    * @return USED_CAP
    */
    public Integer getUsedCap() {
        return this.usedCap;
    }

    /**
    * 设置已使用容量
    * @param usedCap
    */
    public void setUsedCap(Integer usedCap) {
        this.usedCap = usedCap;
    }

    /**
    * 获得是否已满
    * @return IS_FULL
    */
    public Integer getIsFull() {
        return this.isFull;
    }

    /**
    * 设置是否已满
    * @param isFull
    */
    public void setIsFull(Integer isFull) {
        this.isFull = isFull;
    }

    /**
    * 获得所属机构编码(使用者)
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置所属机构编码(使用者)
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得所属机构名称(使用者)
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置所属机构名称(使用者)
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
    * 获得状态  0000 - 空，关 0010 - 空，开 0020 - 空，关，加密 0030 - 空，开，加密 0100 - 已存放，关 0110 - 已存放，开 0120 - 已存放，关，加密 0130 - 已存放，开，加密 0900 - 满，关 0910 - 满，开 0920 - 满，关，加密 0930 - 满，开，加密
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态  0000 - 空，关 0010 - 空，开 0020 - 空，关，加密 0030 - 空，开，加密 0100 - 已存放，关 0110 - 已存放，开 0120 - 已存放，关，加密 0130 - 已存放，开，加密 0900 - 满，关 0910 - 满，开 0920 - 满，关，加密 0930 - 满，开，加密
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得人像案管柜组号(唯一)
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置人像案管柜组号(唯一)
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
    * 获得是否存在(1:存在,0:不存在)
    * @return RESERVE3
    */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
    * 设置是否存在(1:存在,0:不存在)
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
    * 获得是否公有, 1 - 公有, 0 - 私有
    * @return IS_PUBLIC
    */
    public Integer getIsPublic() {
        return this.isPublic;
    }

    /**
    * 设置是否公有, 1 - 公有, 0 - 私有
    * @param isPublic
    */
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    /**
    * 获得当前归属单位(所属者)
    * @return CUR_ORG
    */
    public String getCurOrg() {
        return this.curOrg;
    }

    /**
    * 设置当前归属单位(所属者)
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
    * 获得容纳案卷数
    * @return FILE_COUNT
    */
    public Integer getFileCount() {
        return this.fileCount;
    }

    /**
    * 设置容纳案卷数
    * @param fileCount
    */
    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }

    /**
    * 获得已放入案卷数
    * @return CUR_FILE_COUNT
    */
    public Integer getCurFileCount() {
        return this.curFileCount;
    }

    /**
    * 设置已放入案卷数
    * @param curFileCount
    */
    public void setCurFileCount(Integer curFileCount) {
        this.curFileCount = curFileCount;
    }


}
