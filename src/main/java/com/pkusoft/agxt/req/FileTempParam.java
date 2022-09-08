package com.pkusoft.agxt.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: FileTemp
 */
@ApiModel("案卷模板信息表")
@Table(name = "FILE_TEMP")
public class FileTempParam extends Page {

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
     * 父节点ID
     */
    @Column(name = "PARENT_ID")
    @ApiModelProperty(value = "父节点ID")
    private String parentId;

 	/**
     * 子目录类型(案件类型)
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "子目录类型(案件类型)")
    private String type;

 	/**
     * 材料类型
     */
    @Column(name = "METAL_TYPE")
    @ApiModelProperty(value = "材料类型")
    private String metalType;

 	/**
     * 是否公用
     */
    @Column(name = "IS_PUBLIC")
    @ApiModelProperty(value = "是否公用")
    private Integer isPublic;

 	/**
     * 单位编号
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "单位编号")
    private String orgCode;

 	/**
     * 单位名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "单位名称")
    private String orgName;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Integer sn;

 	/**
     * 级别
     */
    @Column(name = "LEV")
    @ApiModelProperty(value = "级别")
    private Integer lev;

 	/**
     * 是否必选
     */
    @Column(name = "IS_REQUIRED")
    @ApiModelProperty(value = "是否必选")
    private Integer isRequired;

 	/**
     * 描述
     */
    @Column(name = "DESCRIP")
    @ApiModelProperty(value = "描述")
    private String descrip;

 	/**
     * 树路径
     */
    @Column(name = "TREE_PATH")
    @ApiModelProperty(value = "树路径")
    private String treePath;

 	/**
     * 磁盘存放路径(相对)
     */
    @Column(name = "DISK_PATH")
    @ApiModelProperty(value = "磁盘存放路径(相对)")
    private String diskPath;

 	/**
     * 图标
     */
    @Column(name = "ICON")
    @ApiModelProperty(value = "图标")
    private String icon;

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
    * 获得父节点ID
    * @return PARENT_ID
    */
    public String getParentId() {
        return this.parentId;
    }

    /**
    * 设置父节点ID
    * @param parentId
    */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
    * 获得子目录类型(案件类型)
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置子目录类型(案件类型)
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得材料类型
    * @return METAL_TYPE
    */
    public String getMetalType() {
        return this.metalType;
    }

    /**
    * 设置材料类型
    * @param metalType
    */
    public void setMetalType(String metalType) {
        this.metalType = metalType;
    }

    /**
    * 获得是否公用
    * @return IS_PUBLIC
    */
    public Integer getIsPublic() {
        return this.isPublic;
    }

    /**
    * 设置是否公用
    * @param isPublic
    */
    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    /**
    * 获得单位编号
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置单位编号
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得单位名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置单位名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
    * 获得级别
    * @return LEV
    */
    public Integer getLev() {
        return this.lev;
    }

    /**
    * 设置级别
    * @param lev
    */
    public void setLev(Integer lev) {
        this.lev = lev;
    }

    /**
    * 获得是否必选
    * @return IS_REQUIRED
    */
    public Integer getIsRequired() {
        return this.isRequired;
    }

    /**
    * 设置是否必选
    * @param isRequired
    */
    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    /**
    * 获得描述
    * @return DESCRIP
    */
    public String getDescrip() {
        return this.descrip;
    }

    /**
    * 设置描述
    * @param descrip
    */
    public void setDescrip(String descrip) {
        this.descrip = descrip;
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
    * 获得磁盘存放路径(相对)
    * @return DISK_PATH
    */
    public String getDiskPath() {
        return this.diskPath;
    }

    /**
    * 设置磁盘存放路径(相对)
    * @param diskPath
    */
    public void setDiskPath(String diskPath) {
        this.diskPath = diskPath;
    }

    /**
    * 获得图标
    * @return ICON
    */
    public String getIcon() {
        return this.icon;
    }

    /**
    * 设置图标
    * @param icon
    */
    public void setIcon(String icon) {
        this.icon = icon;
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
