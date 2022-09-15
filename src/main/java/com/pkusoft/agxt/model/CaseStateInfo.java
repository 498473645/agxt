package com.pkusoft.agxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: CaseStateInfo
 */
@ApiModel("案件状态信息表")
@Table(name = "CASE_STATE_INFO")
public class CaseStateInfo {

 	/**
     * 主键ID
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value = "主键ID")
    private String id;

 	/**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh;

 	/**
     * 案件名称
     */
    @Column(name = "AJMC")
    @ApiModelProperty(value = "案件名称")
    private String ajmc;

 	/**
     * 案件类别
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "案件类别")
    private String type;

 	/**
     * 案件类别名称
     */
    @Column(name = "TYPE_NAME")
    @ApiModelProperty(value = "案件类别名称")
    private String typeName;

 	/**
     * 办案单位编码
     */
    @Column(name = "BADW_BM")
    @ApiModelProperty(value = "办案单位编码")
    private String badwBm;

 	/**
     * 办案单位名称
     */
    @Column(name = "BADW_MC")
    @ApiModelProperty(value = "办案单位名称")
    private String badwMc;

 	/**
     * 主办人身份证号
     */
    @Column(name = "ZBR_SFZHM")
    @ApiModelProperty(value = "主办人身份证号")
    private String zbrSfzhm;

 	/**
     * 主办人警号
     */
    @Column(name = "ZBR_JH")
    @ApiModelProperty(value = "主办人警号")
    private String zbrJh;

 	/**
     * 主办人姓名
     */
    @Column(name = "ZBR_XM")
    @ApiModelProperty(value = "主办人姓名")
    private String zbrXm;

 	/**
     * 所属派出所编号
     */
    @Column(name = "TSTATIONID")
    @ApiModelProperty(value = "所属派出所编号")
    private String tstationid;

 	/**
     * 所属分局编号
     */
    @Column(name = "SSTATIONID")
    @ApiModelProperty(value = "所属分局编号")
    private String sstationid;

 	/**
     * 所属市局编号
     */
    @Column(name = "CSTATIONID")
    @ApiModelProperty(value = "所属市局编号")
    private String cstationid;

 	/**
     * 受理时间
     */
    @Column(name = "SLSJ")
    @ApiModelProperty(value = "受理时间")
    private java.util.Date slsj;

 	/**
     * 状态类别代码(1111-已建卷，2222-已数字化，3333-已入柜)
     */
    @Column(name = "STATE_BM")
    @ApiModelProperty(value = "状态类别代码(1111-已建卷，2222-已数字化，3333-已入柜)")
    private String stateBm;

 	/**
     * 状态类别名称
     */
    @Column(name = "STATE_MC")
    @ApiModelProperty(value = "状态类别名称")
    private String stateMc;

 	/**
     * 状态变更时间
     */
    @Column(name = "STATE_TIME")
    @ApiModelProperty(value = "状态变更时间")
    private java.util.Date stateTime;

 	/**
     * 创建单位编码
     */
    @Column(name = "CREATER_DEPT_ID")
    @ApiModelProperty(value = "创建单位编码")
    private String createrDeptId;

 	/**
     * 创建单位名称
     */
    @Column(name = "CREATER_DEPT_NAME")
    @ApiModelProperty(value = "创建单位名称")
    private String createrDeptName;

 	/**
     * 创建人id
     */
    @Column(name = "CREATER_ID")
    @ApiModelProperty(value = "创建人id")
    private String createrId;

 	/**
     * 创建人姓名
     */
    @Column(name = "CREATER_NAME")
    @ApiModelProperty(value = "创建人姓名")
    private String createrName;

 	/**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;


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
    * 获得案件编号
    * @return AJBH
    */
    public String getAjbh() {
        return this.ajbh;
    }

    /**
    * 设置案件编号
    * @param ajbh
    */
    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    /**
    * 获得案件名称
    * @return AJMC
    */
    public String getAjmc() {
        return this.ajmc;
    }

    /**
    * 设置案件名称
    * @param ajmc
    */
    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    /**
    * 获得案件类别
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置案件类别
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得案件类别名称
    * @return TYPE_NAME
    */
    public String getTypeName() {
        return this.typeName;
    }

    /**
    * 设置案件类别名称
    * @param typeName
    */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
    * 获得办案单位编码
    * @return BADW_BM
    */
    public String getBadwBm() {
        return this.badwBm;
    }

    /**
    * 设置办案单位编码
    * @param badwBm
    */
    public void setBadwBm(String badwBm) {
        this.badwBm = badwBm;
    }

    /**
    * 获得办案单位名称
    * @return BADW_MC
    */
    public String getBadwMc() {
        return this.badwMc;
    }

    /**
    * 设置办案单位名称
    * @param badwMc
    */
    public void setBadwMc(String badwMc) {
        this.badwMc = badwMc;
    }

    /**
    * 获得主办人身份证号
    * @return ZBR_SFZHM
    */
    public String getZbrSfzhm() {
        return this.zbrSfzhm;
    }

    /**
    * 设置主办人身份证号
    * @param zbrSfzhm
    */
    public void setZbrSfzhm(String zbrSfzhm) {
        this.zbrSfzhm = zbrSfzhm;
    }

    /**
    * 获得主办人警号
    * @return ZBR_JH
    */
    public String getZbrJh() {
        return this.zbrJh;
    }

    /**
    * 设置主办人警号
    * @param zbrJh
    */
    public void setZbrJh(String zbrJh) {
        this.zbrJh = zbrJh;
    }

    /**
    * 获得主办人姓名
    * @return ZBR_XM
    */
    public String getZbrXm() {
        return this.zbrXm;
    }

    /**
    * 设置主办人姓名
    * @param zbrXm
    */
    public void setZbrXm(String zbrXm) {
        this.zbrXm = zbrXm;
    }

    /**
    * 获得所属派出所编号
    * @return TSTATIONID
    */
    public String getTstationid() {
        return this.tstationid;
    }

    /**
    * 设置所属派出所编号
    * @param tstationid
    */
    public void setTstationid(String tstationid) {
        this.tstationid = tstationid;
    }

    /**
    * 获得所属分局编号
    * @return SSTATIONID
    */
    public String getSstationid() {
        return this.sstationid;
    }

    /**
    * 设置所属分局编号
    * @param sstationid
    */
    public void setSstationid(String sstationid) {
        this.sstationid = sstationid;
    }

    /**
    * 获得所属市局编号
    * @return CSTATIONID
    */
    public String getCstationid() {
        return this.cstationid;
    }

    /**
    * 设置所属市局编号
    * @param cstationid
    */
    public void setCstationid(String cstationid) {
        this.cstationid = cstationid;
    }

    /**
    * 获得受理时间
    * @return SLSJ
    */
    public java.util.Date getSlsj() {
        return this.slsj;
    }

    /**
    * 设置受理时间
    * @param slsj
    */
    public void setSlsj(java.util.Date slsj) {
        this.slsj = slsj;
    }

    /**
    * 获得状态类别代码(1111-已建卷，2222-已数字化，3333-已入柜)
    * @return STATE_BM
    */
    public String getStateBm() {
        return this.stateBm;
    }

    /**
    * 设置状态类别代码(1111-已建卷，2222-已数字化，3333-已入柜)
    * @param stateBm
    */
    public void setStateBm(String stateBm) {
        this.stateBm = stateBm;
    }

    /**
    * 获得状态类别名称
    * @return STATE_MC
    */
    public String getStateMc() {
        return this.stateMc;
    }

    /**
    * 设置状态类别名称
    * @param stateMc
    */
    public void setStateMc(String stateMc) {
        this.stateMc = stateMc;
    }

    /**
    * 获得状态变更时间
    * @return STATE_TIME
    */
    public java.util.Date getStateTime() {
        return this.stateTime;
    }

    /**
    * 设置状态变更时间
    * @param stateTime
    */
    public void setStateTime(java.util.Date stateTime) {
        this.stateTime = stateTime;
    }

    /**
    * 获得创建单位编码
    * @return CREATER_DEPT_ID
    */
    public String getCreaterDeptId() {
        return this.createrDeptId;
    }

    /**
    * 设置创建单位编码
    * @param createrDeptId
    */
    public void setCreaterDeptId(String createrDeptId) {
        this.createrDeptId = createrDeptId;
    }

    /**
    * 获得创建单位名称
    * @return CREATER_DEPT_NAME
    */
    public String getCreaterDeptName() {
        return this.createrDeptName;
    }

    /**
    * 设置创建单位名称
    * @param createrDeptName
    */
    public void setCreaterDeptName(String createrDeptName) {
        this.createrDeptName = createrDeptName;
    }

    /**
    * 获得创建人id
    * @return CREATER_ID
    */
    public String getCreaterId() {
        return this.createrId;
    }

    /**
    * 设置创建人id
    * @param createrId
    */
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    /**
    * 获得创建人姓名
    * @return CREATER_NAME
    */
    public String getCreaterName() {
        return this.createrName;
    }

    /**
    * 设置创建人姓名
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


}
