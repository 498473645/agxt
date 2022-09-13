package com.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author 
 * @title: SysUser 
 */
@ApiModel("用户表")
@Table(name = "SYS_USER")
public class SysUser {

 	/**
     * 用户标识号
     */
    @Id
    @Column(name = "USER_ID")
    @ApiModelProperty(value = "用户标识号")
    private String userId; 

 	/**
     * 登录名
     */
    @Column(name = "LOGIN_NAME")
    @ApiModelProperty(value = "登录名")
    private String loginName; 

 	/**
     * 真实姓名
     */
    @Column(name = "USER_NAME")
    @ApiModelProperty(value = "真实姓名")
    private String userName; 

 	/**
     * 警号
     */
    @Column(name = "POLICE_CODE")
    @ApiModelProperty(value = "警号")
    private String policeCode; 

 	/**
     * 密码
     */
    @Column(name = "PASSWORD")
    @ApiModelProperty(value = "密码")
    private String password; 

 	/**
     * 密码盐值
     */
    @Column(name = "SALT")
    @ApiModelProperty(value = "密码盐值")
    private String salt; 

 	/**
     * 所属单位标识号
     */
    @Column(name = "DEPT_ID")
    @ApiModelProperty(value = "所属单位标识号")
    private String deptId; 

 	/**
     * 用户级别
     */
    @Column(name = "USER_LEVEL")
    @ApiModelProperty(value = "用户级别")
    private String userLevel; 

 	/**
     * 状态
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态")
    private String status; 

 	/**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    @ApiModelProperty(value = "用户类型")
    private String userType; 

 	/**
     * 邮箱
     */
    @Column(name = "EMAIL")
    @ApiModelProperty(value = "邮箱")
    private String email; 

 	/**
     * 电话号码
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "电话号码")
    private String tel; 

 	/**
     * 手机号码
     */
    @Column(name = "MOBILE")
    @ApiModelProperty(value = "手机号码")
    private String mobile; 

 	/**
     * 身份证号
     */
    @Column(name = "IDCARD")
    @ApiModelProperty(value = "身份证号")
    private String idcard; 

 	/**
     * 数字证书编码
     */
    @Column(name = "CERTIFICATE")
    @ApiModelProperty(value = "数字证书编码")
    private String certificate; 

 	/**
     * 数据归属市局
     */
    @Column(name = "CUNITID")
    @ApiModelProperty(value = "数据归属市局")
    private String cunitid; 

 	/**
     * 数据归属分局
     */
    @Column(name = "SUNITID")
    @ApiModelProperty(value = "数据归属分局")
    private String sunitid; 

 	/**
     * 数据归属派出所
     */
    @Column(name = "TUNITID")
    @ApiModelProperty(value = "数据归属派出所")
    private String tunitid; 

 	/**
     * 保留字段1(当前用户所属单位的上级管辖单位代码)
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "保留字段1(当前用户所属单位的上级管辖单位代码)")
    private String reserve1; 

 	/**
     * 保留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "保留字段2")
    private String reserve2; 

 	/**
     * 10 市局大屏，11 问题列表，12 个人问题列表；20 分局大屏，21 问题列表，22 个人问题列表；30 所有问题列表，31 个人问题列表
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "10 市局大屏，11 问题列表，12 个人问题列表；20 分局大屏，21 问题列表，22 个人问题列表；30 所有问题列表，31 个人问题列表")
    private String reserve3; 

 	/**
     * 微信号
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "微信号")
    private String reserve4; 

 	/**
     * 钉钉号(userId)
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "钉钉号(userId)")
    private String reserve5; 

 	/**
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo; 

 	/**
     * 录入用户编号
     */
    @Column(name = "ADD_USER_ID")
    @ApiModelProperty(value = "录入用户编号")
    private String addUserId; 

 	/**
     * 录入用户姓名
     */
    @Column(name = "ADD_USER_NAME")
    @ApiModelProperty(value = "录入用户姓名")
    private String addUserName; 

 	/**
     * 录入时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "录入时间")
    private java.util.Date addTime; 

 	/**
     * 修改用户编号
     */
    @Column(name = "MODIFY_USER_ID")
    @ApiModelProperty(value = "修改用户编号")
    private String modifyUserId; 

 	/**
     * 修改用户姓名
     */
    @Column(name = "MODIFY_USER_NAME")
    @ApiModelProperty(value = "修改用户姓名")
    private String modifyUserName; 

 	/**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime; 

 	/**
     * 用户登录是否绑定ip地址（默认不绑定登录，绑定登录时需要输入绑定的ip地址）
     */
    @Column(name = "BOUND_LOGIN")
    @ApiModelProperty(value = "用户登录是否绑定ip地址（默认不绑定登录，绑定登录时需要输入绑定的ip地址）")
    private String boundLogin; 

 	/**
     * 用户绑定ip地址，（可绑定多个ip，用逗号分隔）
     */
    @Column(name = "IP")
    @ApiModelProperty(value = "用户绑定ip地址，（可绑定多个ip，用逗号分隔）")
    private String ip; 

 	/**
     * 用户绑定MAC地址
     */
    @Column(name = "MAC_ADDRESS")
    @ApiModelProperty(value = "用户绑定MAC地址")
    private String macAddress; 

 	/**
     * 密码修改权限(1、允许修改密码，0、不允许修改密码)
     */
    @Column(name = "ISUPDATE")
    @ApiModelProperty(value = "密码修改权限(1、允许修改密码，0、不允许修改密码)")
    private String isupdate; 

 	/**
     * 是否采集指纹（1：是，0：否）
     */
    @Column(name = "HAS_FINGER")
    @ApiModelProperty(value = "是否采集指纹（1：是，0：否）")
    private Integer hasFinger; 

 	/**
     * 是否采集虹膜（1：是，0：否）
     */
    @Column(name = "HAS_LRIS")
    @ApiModelProperty(value = "是否采集虹膜（1：是，0：否）")
    private Integer hasLris; 

 	/**
     * 用户类型编码
     */
    @Column(name = "USER_LXBM")
    @ApiModelProperty(value = "用户类型编码")
    private Integer userLxbm; 

 	/**
     * 是否有获取公章的权限
     */
    @Column(name = "HAS_SEAL")
    @ApiModelProperty(value = "是否有获取公章的权限")
    private String hasSeal; 


    /**
    * 获得用户标识号
    * @return USER_ID
    */
    public String getUserId() {
        return this.userId;
    }

    /**
    * 设置用户标识号
    * @param userId
    */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
    * 获得登录名
    * @return LOGIN_NAME
    */
    public String getLoginName() {
        return this.loginName;
    }

    /**
    * 设置登录名
    * @param loginName
    */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
    * 获得真实姓名
    * @return USER_NAME
    */
    public String getUserName() {
        return this.userName;
    }

    /**
    * 设置真实姓名
    * @param userName
    */
    public void setUserName(String userName) {
        this.userName = userName;
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
    * 获得密码
    * @return PASSWORD
    */
    public String getPassword() {
        return this.password;
    }

    /**
    * 设置密码
    * @param password
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * 获得密码盐值
    * @return SALT
    */
    public String getSalt() {
        return this.salt;
    }

    /**
    * 设置密码盐值
    * @param salt
    */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
    * 获得所属单位标识号
    * @return DEPT_ID
    */
    public String getDeptId() {
        return this.deptId;
    }

    /**
    * 设置所属单位标识号
    * @param deptId
    */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
    * 获得用户级别
    * @return USER_LEVEL
    */
    public String getUserLevel() {
        return this.userLevel;
    }

    /**
    * 设置用户级别
    * @param userLevel
    */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
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
    * 获得用户类型
    * @return USER_TYPE
    */
    public String getUserType() {
        return this.userType;
    }

    /**
    * 设置用户类型
    * @param userType
    */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
    * 获得邮箱
    * @return EMAIL
    */
    public String getEmail() {
        return this.email;
    }

    /**
    * 设置邮箱
    * @param email
    */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
    * 获得电话号码
    * @return TEL
    */
    public String getTel() {
        return this.tel;
    }

    /**
    * 设置电话号码
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
    * 获得身份证号
    * @return IDCARD
    */
    public String getIdcard() {
        return this.idcard;
    }

    /**
    * 设置身份证号
    * @param idcard
    */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
    * 获得数字证书编码
    * @return CERTIFICATE
    */
    public String getCertificate() {
        return this.certificate;
    }

    /**
    * 设置数字证书编码
    * @param certificate
    */
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
    * 获得数据归属市局
    * @return CUNITID
    */
    public String getCunitid() {
        return this.cunitid;
    }

    /**
    * 设置数据归属市局
    * @param cunitid
    */
    public void setCunitid(String cunitid) {
        this.cunitid = cunitid;
    }

    /**
    * 获得数据归属分局
    * @return SUNITID
    */
    public String getSunitid() {
        return this.sunitid;
    }

    /**
    * 设置数据归属分局
    * @param sunitid
    */
    public void setSunitid(String sunitid) {
        this.sunitid = sunitid;
    }

    /**
    * 获得数据归属派出所
    * @return TUNITID
    */
    public String getTunitid() {
        return this.tunitid;
    }

    /**
    * 设置数据归属派出所
    * @param tunitid
    */
    public void setTunitid(String tunitid) {
        this.tunitid = tunitid;
    }

    /**
    * 获得保留字段1(当前用户所属单位的上级管辖单位代码)
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置保留字段1(当前用户所属单位的上级管辖单位代码)
    * @param reserve1
    */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
    * 获得保留字段2
    * @return RESERVE2
    */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
    * 设置保留字段2
    * @param reserve2
    */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
    * 获得10 市局大屏，11 问题列表，12 个人问题列表；20 分局大屏，21 问题列表，22 个人问题列表；30 所有问题列表，31 个人问题列表
    * @return RESERVE3
    */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
    * 设置10 市局大屏，11 问题列表，12 个人问题列表；20 分局大屏，21 问题列表，22 个人问题列表；30 所有问题列表，31 个人问题列表
    * @param reserve3
    */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
    * 获得微信号
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置微信号
    * @param reserve4
    */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
    * 获得钉钉号(userId)
    * @return RESERVE5
    */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
    * 设置钉钉号(userId)
    * @param reserve5
    */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
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
    * 获得录入用户编号
    * @return ADD_USER_ID
    */
    public String getAddUserId() {
        return this.addUserId;
    }

    /**
    * 设置录入用户编号
    * @param addUserId
    */
    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    /**
    * 获得录入用户姓名
    * @return ADD_USER_NAME
    */
    public String getAddUserName() {
        return this.addUserName;
    }

    /**
    * 设置录入用户姓名
    * @param addUserName
    */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
    * 获得录入时间
    * @return ADD_TIME
    */
    public java.util.Date getAddTime() {
        return this.addTime;
    }

    /**
    * 设置录入时间
    * @param addTime
    */
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }

    /**
    * 获得修改用户编号
    * @return MODIFY_USER_ID
    */
    public String getModifyUserId() {
        return this.modifyUserId;
    }

    /**
    * 设置修改用户编号
    * @param modifyUserId
    */
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
    * 获得修改用户姓名
    * @return MODIFY_USER_NAME
    */
    public String getModifyUserName() {
        return this.modifyUserName;
    }

    /**
    * 设置修改用户姓名
    * @param modifyUserName
    */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    /**
    * 获得修改时间
    * @return MODIFY_TIME
    */
    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    /**
    * 设置修改时间
    * @param modifyTime
    */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
    * 获得用户登录是否绑定ip地址（默认不绑定登录，绑定登录时需要输入绑定的ip地址）
    * @return BOUND_LOGIN
    */
    public String getBoundLogin() {
        return this.boundLogin;
    }

    /**
    * 设置用户登录是否绑定ip地址（默认不绑定登录，绑定登录时需要输入绑定的ip地址）
    * @param boundLogin
    */
    public void setBoundLogin(String boundLogin) {
        this.boundLogin = boundLogin;
    }

    /**
    * 获得用户绑定ip地址，（可绑定多个ip，用逗号分隔）
    * @return IP
    */
    public String getIp() {
        return this.ip;
    }

    /**
    * 设置用户绑定ip地址，（可绑定多个ip，用逗号分隔）
    * @param ip
    */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
    * 获得用户绑定MAC地址
    * @return MAC_ADDRESS
    */
    public String getMacAddress() {
        return this.macAddress;
    }

    /**
    * 设置用户绑定MAC地址
    * @param macAddress
    */
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
    * 获得密码修改权限(1、允许修改密码，0、不允许修改密码)
    * @return ISUPDATE
    */
    public String getIsupdate() {
        return this.isupdate;
    }

    /**
    * 设置密码修改权限(1、允许修改密码，0、不允许修改密码)
    * @param isupdate
    */
    public void setIsupdate(String isupdate) {
        this.isupdate = isupdate;
    }

    /**
    * 获得是否采集指纹（1：是，0：否）
    * @return HAS_FINGER
    */
    public Integer getHasFinger() {
        return this.hasFinger;
    }

    /**
    * 设置是否采集指纹（1：是，0：否）
    * @param hasFinger
    */
    public void setHasFinger(Integer hasFinger) {
        this.hasFinger = hasFinger;
    }

    /**
    * 获得是否采集虹膜（1：是，0：否）
    * @return HAS_LRIS
    */
    public Integer getHasLris() {
        return this.hasLris;
    }

    /**
    * 设置是否采集虹膜（1：是，0：否）
    * @param hasLris
    */
    public void setHasLris(Integer hasLris) {
        this.hasLris = hasLris;
    }

    /**
    * 获得用户类型编码
    * @return USER_LXBM
    */
    public Integer getUserLxbm() {
        return this.userLxbm;
    }

    /**
    * 设置用户类型编码
    * @param userLxbm
    */
    public void setUserLxbm(Integer userLxbm) {
        this.userLxbm = userLxbm;
    }

    /**
    * 获得是否有获取公章的权限
    * @return HAS_SEAL
    */
    public String getHasSeal() {
        return this.hasSeal;
    }

    /**
    * 设置是否有获取公章的权限
    * @param hasSeal
    */
    public void setHasSeal(String hasSeal) {
        this.hasSeal = hasSeal;
    }


}