package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SmartDev
 */
@ApiModel("案管智能终端设备信息表")
@Table(name = "SMART_DEV")
public class SmartDev {

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
     * 类型  0100 - Usb设备
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型  0100 - Usb设备")
    private String type;

 	/**
     * 排序序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "排序序号")
    private Double sn;

 	/**
     * 案管智能终端ID(Smart_Info.ID)
     */
    @Column(name = "SMART_ID")
    @ApiModelProperty(value = "案管智能终端ID(Smart_Info.ID)")
    private String smartId;

 	/**
     * 案管智能终端名称(Smart_Info.Name)
     */
    @Column(name = "SMART_NAME")
    @ApiModelProperty(value = "案管智能终端名称(Smart_Info.Name)")
    private String smartName;

 	/**
     * 是否检测(0/1)
     */
    @Column(name = "IS_DETECT")
    @ApiModelProperty(value = "是否检测(0/1)")
    private Integer isDetect;

 	/**
     * 检测类型  0：单一设备；1：同类型设备
     */
    @Column(name = "DETECT_TYPE")
    @ApiModelProperty(value = "检测类型  0：单一设备；1：同类型设备")
    private Integer detectType;

 	/**
     * 设备描述/标识字符串(Usb：[Name][PNPDeviceID][Description][Service][VendorID][ProductID][ClassGuid])
     */
    @Column(name = "FLAG_STR")
    @ApiModelProperty(value = "设备描述/标识字符串(Usb：[Name][PNPDeviceID][Description][Service][VendorID][ProductID][ClassGuid])")
    private String flagStr;

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
    * 获得类型  0100 - Usb设备
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型  0100 - Usb设备
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
    * 获得案管智能终端ID(Smart_Info.ID)
    * @return SMART_ID
    */
    public String getSmartId() {
        return this.smartId;
    }

    /**
    * 设置案管智能终端ID(Smart_Info.ID)
    * @param smartId
    */
    public void setSmartId(String smartId) {
        this.smartId = smartId;
    }

    /**
    * 获得案管智能终端名称(Smart_Info.Name)
    * @return SMART_NAME
    */
    public String getSmartName() {
        return this.smartName;
    }

    /**
    * 设置案管智能终端名称(Smart_Info.Name)
    * @param smartName
    */
    public void setSmartName(String smartName) {
        this.smartName = smartName;
    }

    /**
    * 获得是否检测(0/1)
    * @return IS_DETECT
    */
    public Integer getIsDetect() {
        return this.isDetect;
    }

    /**
    * 设置是否检测(0/1)
    * @param isDetect
    */
    public void setIsDetect(Integer isDetect) {
        this.isDetect = isDetect;
    }

    /**
    * 获得检测类型  0：单一设备；1：同类型设备
    * @return DETECT_TYPE
    */
    public Integer getDetectType() {
        return this.detectType;
    }

    /**
    * 设置检测类型  0：单一设备；1：同类型设备
    * @param detectType
    */
    public void setDetectType(Integer detectType) {
        this.detectType = detectType;
    }

    /**
    * 获得设备描述/标识字符串(Usb：[Name][PNPDeviceID][Description][Service][VendorID][ProductID][ClassGuid])
    * @return FLAG_STR
    */
    public String getFlagStr() {
        return this.flagStr;
    }

    /**
    * 设置设备描述/标识字符串(Usb：[Name][PNPDeviceID][Description][Service][VendorID][ProductID][ClassGuid])
    * @param flagStr
    */
    public void setFlagStr(String flagStr) {
        this.flagStr = flagStr;
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
