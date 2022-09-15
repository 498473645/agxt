package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: UserInfo
 */
@ApiModel("用户信息表")
@Table(name = "USER_INFO")
public class UserInfo {

 	/**
     *
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "")
    private String id;

 	/**
     * 登录名
     */
    @Column(name = "CODE")
    @ApiModelProperty(value = "登录名")
    private String code;

 	/**
     * 姓名
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "姓名")
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
     * 警号
     */
    @Column(name = "POLICE_CODE")
    @ApiModelProperty(value = "警号")
    private String policeCode;

 	/**
     * 登录密码
     */
    @Column(name = "PASSWORD")
    @ApiModelProperty(value = "登录密码")
    private String password;

 	/**
     * 密码盐值
     */
    @Column(name = "PASS_SALT")
    @ApiModelProperty(value = "密码盐值")
    private String passSalt;

 	/**
     * 级别
     */
    @Column(name = "LEV")
    @ApiModelProperty(value = "级别")
    private Integer lev;

 	/**
     * 数据级别
     */
    @Column(name = "DATA_LEV")
    @ApiModelProperty(value = "数据级别")
    private Integer dataLev;

 	/**
     * 身份证号
     */
    @Column(name = "ID_CARD")
    @ApiModelProperty(value = "身份证号")
    private String idCard;

 	/**
     * 电话
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "电话")
    private String tel;

 	/**
     * 手机号码
     */
    @Column(name = "MOBILE")
    @ApiModelProperty(value = "手机号码")
    private String mobile;

 	/**
     * 邮箱地址
     */
    @Column(name = "E_MAIL")
    @ApiModelProperty(value = "邮箱地址")
    private String eMail;

 	/**
     * 数字证书编码
     */
    @Column(name = "CERT_CODE")
    @ApiModelProperty(value = "数字证书编码")
    private String certCode;

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
     * 登录方式（0100-用户名/密码，0200-二代证，0300-指纹，0400-人像，9999-其他）
     */
    @Column(name = "LOGIN_TYPE")
    @ApiModelProperty(value = "登录方式（0100-用户名/密码，0200-二代证，0300-指纹，0400-人像，9999-其他）")
    private String loginType;

 	/**
     * 是否在线（1-是，0-否）
     */
    @Column(name = "IS_ONLINE")
    @ApiModelProperty(value = "是否在线（1-是，0-否）")
    private Integer isOnline;

 	/**
     * 最后登录IP
     */
    @Column(name = "LAST_IP")
    @ApiModelProperty(value = "最后登录IP")
    private String lastIp;

 	/**
     * 最后登录时间
     */
    @Column(name = "LAST_TIME")
    @ApiModelProperty(value = "最后登录时间")
    private java.util.Date lastTime;

 	/**
     * 当前单位编码
     */
    @Column(name = "DEPT_CODE")
    @ApiModelProperty(value = "当前单位编码")
    private String deptCode;

 	/**
     * 当前单位名称
     */
    @Column(name = "DEPT_NAME")
    @ApiModelProperty(value = "当前单位名称")
    private String deptName;

 	/**
     * 是否采集指纹
     */
    @Column(name = "HAS_FINGER")
    @ApiModelProperty(value = "是否采集指纹")
    private Integer hasFinger;


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
    * 获得登录名
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置登录名
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
    * 获得警号
    * @return POLICE_CODE
    */
    public String getPoliceCode() {
        return this.policeCode;
    }

    /**
    * 设置警号
    * @param policeCode
    */
    public void setPoliceCode(String policeCode) {
        this.policeCode = policeCode;
    }

    /**
    * 获得登录密码
    * @return PASSWORD
    */
    public String getPassword() {
        return this.password;
    }

    /**
    * 设置登录密码
    * @param password
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * 获得密码盐值
    * @return PASS_SALT
    */
    public String getPassSalt() {
        return this.passSalt;
    }

    /**
    * 设置密码盐值
    * @param passSalt
    */
    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt;
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
    * 获得数据级别
    * @return DATA_LEV
    */
    public Integer getDataLev() {
        return this.dataLev;
    }

    /**
    * 设置数据级别
    * @param dataLev
    */
    public void setDataLev(Integer dataLev) {
        this.dataLev = dataLev;
    }

    /**
    * 获得身份证号
    * @return ID_CARD
    */
    public String getIdCard() {
        return this.idCard;
    }

    /**
    * 设置身份证号
    * @param idCard
    */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
    * 获得电话
    * @return TEL
    */
    public String getTel() {
        return this.tel;
    }

    /**
    * 设置电话
    * @param tel
    */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
    * 获得手机号码
    * @return MOBILE
    */
    public String getMobile() {
        return this.mobile;
    }

    /**
    * 设置手机号码
    * @param mobile
    */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
    * 获得邮箱地址
    * @return E_MAIL
    */
    public String getEMail() {
        return this.eMail;
    }

    /**
    * 设置邮箱地址
    * @param eMail
    */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
    * 获得数字证书编码
    * @return CERT_CODE
    */
    public String getCertCode() {
        return this.certCode;
    }

    /**
    * 设置数字证书编码
    * @param certCode
    */
    public void setCertCode(String certCode) {
        this.certCode = certCode;
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
    * 获得登录方式（0100-用户名/密码，0200-二代证，0300-指纹，0400-人像，9999-其他）
    * @return LOGIN_TYPE
    */
    public String getLoginType() {
        return this.loginType;
    }

    /**
    * 设置登录方式（0100-用户名/密码，0200-二代证，0300-指纹，0400-人像，9999-其他）
    * @param loginType
    */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
    * 获得是否在线（1-是，0-否）
    * @return IS_ONLINE
    */
    public Integer getIsOnline() {
        return this.isOnline;
    }

    /**
    * 设置是否在线（1-是，0-否）
    * @param isOnline
    */
    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    /**
    * 获得最后登录IP
    * @return LAST_IP
    */
    public String getLastIp() {
        return this.lastIp;
    }

    /**
    * 设置最后登录IP
    * @param lastIp
    */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
    * 获得最后登录时间
    * @return LAST_TIME
    */
    public java.util.Date getLastTime() {
        return this.lastTime;
    }

    /**
    * 设置最后登录时间
    * @param lastTime
    */
    public void setLastTime(java.util.Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
    * 获得当前单位编码
    * @return DEPT_CODE
    */
    public String getDeptCode() {
        return this.deptCode;
    }

    /**
    * 设置当前单位编码
    * @param deptCode
    */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
    * 获得当前单位名称
    * @return DEPT_NAME
    */
    public String getDeptName() {
        return this.deptName;
    }

    /**
    * 设置当前单位名称
    * @param deptName
    */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
    * 获得是否采集指纹
    * @return HAS_FINGER
    */
    public Integer getHasFinger() {
        return this.hasFinger;
    }

    /**
    * 设置是否采集指纹
    * @param hasFinger
    */
    public void setHasFinger(Integer hasFinger) {
        this.hasFinger = hasFinger;
    }


}
