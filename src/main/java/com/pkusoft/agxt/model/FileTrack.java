package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: FileTrack
 */
@ApiModel("案卷操作轨迹表(主表)")
@Table(name = "FILE_TRACK")
public class FileTrack {

 	/**
     * 主键ID
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "主键ID")
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
     * 操作时间
     */
    @Column(name = "OPER_TIME")
    @ApiModelProperty(value = "操作时间")
    private java.util.Date operTime;

 	/**
     * 操作人ID
     */
    @Column(name = "OPER_ID")
    @ApiModelProperty(value = "操作人ID")
    private String operId;

 	/**
     * 操作员编号
     */
    @Column(name = "OPER_CODE")
    @ApiModelProperty(value = "操作员编号")
    private String operCode;

 	/**
     * 操作人姓名
     */
    @Column(name = "OPER_NAME")
    @ApiModelProperty(value = "操作人姓名")
    private String operName;

 	/**
     * 操作类型
     */
    @Column(name = "OPER_TYPE")
    @ApiModelProperty(value = "操作类型")
    private String operType;

 	/**
     * 操作描述
     */
    @Column(name = "OPER_DETAIL")
    @ApiModelProperty(value = "操作描述")
    private String operDetail;

 	/**
     * 接收单位编码
     */
    @Column(name = "TAG_ORG_CODE")
    @ApiModelProperty(value = "接收单位编码")
    private String tagOrgCode;

 	/**
     * 接收单位名称
     */
    @Column(name = "TAG_ORG_NAME")
    @ApiModelProperty(value = "接收单位名称")
    private String tagOrgName;

 	/**
     * 接收人编码
     */
    @Column(name = "TAG_USER_CODE")
    @ApiModelProperty(value = "接收人编码")
    private String tagUserCode;

 	/**
     * 接收单位名称
     */
    @Column(name = "TAG_USER_NAME")
    @ApiModelProperty(value = "接收单位名称")
    private String tagUserName;

 	/**
     * 是否已开柜
     */
    @Column(name = "IS_OPENED")
    @ApiModelProperty(value = "是否已开柜")
    private Integer isOpened;

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
     * 设备说明
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "设备说明")
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
     * 登录方式(0100 - 密码登录，0200 - 二代证登录，0300 - 指纹登录，0400 - 人像登录，9999 - 其他)
     */
    @Column(name = "LOGIN_TYPE")
    @ApiModelProperty(value = "登录方式(0100 - 密码登录，0200 - 二代证登录，0300 - 指纹登录，0400 - 人像登录，9999 - 其他)")
    private String loginType;

 	/**
     * 操作人所在单位编码
     */
    @Column(name = "OPERDEPT_CODE")
    @ApiModelProperty(value = "操作人所在单位编码")
    private String operdeptCode;

 	/**
     * 操作人所在单位名称
     */
    @Column(name = "OPERDEPT_NAME")
    @ApiModelProperty(value = "操作人所在单位名称")
    private String operdeptName;

 	/**
     * 图片路径
     */
    @Column(name = "PIC_PATH")
    @ApiModelProperty(value = "图片路径")
    private String picPath;


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
    * 获得操作时间
    * @return OPER_TIME
    */
    public java.util.Date getOperTime() {
        return this.operTime;
    }

    /**
    * 设置操作时间
    * @param operTime
    */
    public void setOperTime(java.util.Date operTime) {
        this.operTime = operTime;
    }

    /**
    * 获得操作人ID
    * @return OPER_ID
    */
    public String getOperId() {
        return this.operId;
    }

    /**
    * 设置操作人ID
    * @param operId
    */
    public void setOperId(String operId) {
        this.operId = operId;
    }

    /**
    * 获得操作员编号
    * @return OPER_CODE
    */
    public String getOperCode() {
        return this.operCode;
    }

    /**
    * 设置操作员编号
    * @param operCode
    */
    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    /**
    * 获得操作人姓名
    * @return OPER_NAME
    */
    public String getOperName() {
        return this.operName;
    }

    /**
    * 设置操作人姓名
    * @param operName
    */
    public void setOperName(String operName) {
        this.operName = operName;
    }

    /**
    * 获得操作类型
    * @return OPER_TYPE
    */
    public String getOperType() {
        return this.operType;
    }

    /**
    * 设置操作类型
    * @param operType
    */
    public void setOperType(String operType) {
        this.operType = operType;
    }

    /**
    * 获得操作描述
    * @return OPER_DETAIL
    */
    public String getOperDetail() {
        return this.operDetail;
    }

    /**
    * 设置操作描述
    * @param operDetail
    */
    public void setOperDetail(String operDetail) {
        this.operDetail = operDetail;
    }

    /**
    * 获得接收单位编码
    * @return TAG_ORG_CODE
    */
    public String getTagOrgCode() {
        return this.tagOrgCode;
    }

    /**
    * 设置接收单位编码
    * @param tagOrgCode
    */
    public void setTagOrgCode(String tagOrgCode) {
        this.tagOrgCode = tagOrgCode;
    }

    /**
    * 获得接收单位名称
    * @return TAG_ORG_NAME
    */
    public String getTagOrgName() {
        return this.tagOrgName;
    }

    /**
    * 设置接收单位名称
    * @param tagOrgName
    */
    public void setTagOrgName(String tagOrgName) {
        this.tagOrgName = tagOrgName;
    }

    /**
    * 获得接收人编码
    * @return TAG_USER_CODE
    */
    public String getTagUserCode() {
        return this.tagUserCode;
    }

    /**
    * 设置接收人编码
    * @param tagUserCode
    */
    public void setTagUserCode(String tagUserCode) {
        this.tagUserCode = tagUserCode;
    }

    /**
    * 获得接收单位名称
    * @return TAG_USER_NAME
    */
    public String getTagUserName() {
        return this.tagUserName;
    }

    /**
    * 设置接收单位名称
    * @param tagUserName
    */
    public void setTagUserName(String tagUserName) {
        this.tagUserName = tagUserName;
    }

    /**
    * 获得是否已开柜
    * @return IS_OPENED
    */
    public Integer getIsOpened() {
        return this.isOpened;
    }

    /**
    * 设置是否已开柜
    * @param isOpened
    */
    public void setIsOpened(Integer isOpened) {
        this.isOpened = isOpened;
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
    * 获得设备说明
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置设备说明
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
    * 获得登录方式(0100 - 密码登录，0200 - 二代证登录，0300 - 指纹登录，0400 - 人像登录，9999 - 其他)
    * @return LOGIN_TYPE
    */
    public String getLoginType() {
        return this.loginType;
    }

    /**
    * 设置登录方式(0100 - 密码登录，0200 - 二代证登录，0300 - 指纹登录，0400 - 人像登录，9999 - 其他)
    * @param loginType
    */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
    * 获得操作人所在单位编码
    * @return OPERDEPT_CODE
    */
    public String getOperdeptCode() {
        return this.operdeptCode;
    }

    /**
    * 设置操作人所在单位编码
    * @param operdeptCode
    */
    public void setOperdeptCode(String operdeptCode) {
        this.operdeptCode = operdeptCode;
    }

    /**
    * 获得操作人所在单位名称
    * @return OPERDEPT_NAME
    */
    public String getOperdeptName() {
        return this.operdeptName;
    }

    /**
    * 设置操作人所在单位名称
    * @param operdeptName
    */
    public void setOperdeptName(String operdeptName) {
        this.operdeptName = operdeptName;
    }

    /**
    * 获得图片路径
    * @return PIC_PATH
    */
    public String getPicPath() {
        return this.picPath;
    }

    /**
    * 设置图片路径
    * @param picPath
    */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }


}
