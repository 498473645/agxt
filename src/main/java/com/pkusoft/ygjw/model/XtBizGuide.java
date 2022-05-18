package com.pkusoft.ygjw.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 
 * @title: XtBizGuide 
 */
@ApiModel("户政业务-办理服务指南")
@Table(name = "XT_BIZ_GUIDE")
public class XtBizGuide {

 	/**
     * 业务主键
     */
    @Id
    @Column(name = "PID")
    @ApiModelProperty(value = "业务主键")
    private String pid; 

 	/**
     * 业务类型编号
     */
    @Column(name = "YWLXDM")
    @ApiModelProperty(value = "业务类型编号")
    private String ywlxdm; 

 	/**
     * 业务类型名称
     */
    @Column(name = "YWLXMC")
    @ApiModelProperty(value = "业务类型名称")
    private String ywlxmc; 

 	/**
     * 所属省市县区
     */
    @Column(name = "SSXQ")
    @ApiModelProperty(value = "所属省市县区")
    private String ssxq; 

 	/**
     * 事项编号（业务具体小类）
     */
    @Column(name = "SXBH")
    @ApiModelProperty(value = "事项编号（业务具体小类）")
    private String sxbh; 

 	/**
     * 事项名称（业务具体小类）
     */
    @Column(name = "SXMC")
    @ApiModelProperty(value = "事项名称（业务具体小类）")
    private String sxmc; 

 	/**
     * 事项性质（公共服务）
     */
    @Column(name = "SXXZ")
    @ApiModelProperty(value = "事项性质（公共服务）")
    private String sxxz; 

 	/**
     * 申请条件
     */
    @Column(name = "SQTJ")
    @ApiModelProperty(value = "申请条件")
    private String sqtj; 

 	/**
     * 申报材料
     */
    @Column(name = "SBCL")
    @ApiModelProperty(value = "申报材料")
    private String sbcl; 

 	/**
     * 办理流程
     */
    @Column(name = "BLLC")
    @ApiModelProperty(value = "办理流程")
    private String bllc; 

 	/**
     * 审批依据
     */
    @Column(name = "SPYJ")
    @ApiModelProperty(value = "审批依据")
    private String spyj; 

 	/**
     * 审批机关
     */
    @Column(name = "SPJG")
    @ApiModelProperty(value = "审批机关")
    private String spjg; 

 	/**
     * 承诺周期
     */
    @Column(name = "FDZQ")
    @ApiModelProperty(value = "承诺周期")
    private String fdzq; 

 	/**
     * 法定时限
     */
    @Column(name = "CNSX")
    @ApiModelProperty(value = "法定时限")
    private String cnsx; 

 	/**
     * 收费标准及依据
     */
    @Column(name = "SFBZ")
    @ApiModelProperty(value = "收费标准及依据")
    private String sfbz; 

 	/**
     * 备注
     */
    @Column(name = "BZ")
    @ApiModelProperty(value = "备注")
    private String bz; 

 	/**
     * 发布时间
     */
    @Column(name = "FBSJ")
    @ApiModelProperty(value = "发布时间")
    private String fbsj; 

 	/**
     * 发布单位名称
     */
    @Column(name = "FBDWMC")
    @ApiModelProperty(value = "发布单位名称")
    private String fbdwmc; 

 	/**
     * 发布人姓名
     */
    @Column(name = "FBRXM")
    @ApiModelProperty(value = "发布人姓名")
    private String fbrxm; 

 	/**
     * 更新单位名称
     */
    @Column(name = "GXDWMC")
    @ApiModelProperty(value = "更新单位名称")
    private String gxdwmc; 

 	/**
     * 更新人姓名
     */
    @Column(name = "GXRXM")
    @ApiModelProperty(value = "更新人姓名")
    private String gxrxm; 

 	/**
     * 更新时间
     */
    @Column(name = "GXSJ")
    @ApiModelProperty(value = "更新时间")
    private String gxsj; 

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
    * 获得业务主键
    * @return PID
    */
    public String getPid() {
        return this.pid;
    }

    /**
    * 设置业务主键
    * @param pid
    */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
    * 获得业务类型编号
    * @return YWLXDM
    */
    public String getYwlxdm() {
        return this.ywlxdm;
    }

    /**
    * 设置业务类型编号
    * @param ywlxdm
    */
    public void setYwlxdm(String ywlxdm) {
        this.ywlxdm = ywlxdm;
    }

    /**
    * 获得业务类型名称
    * @return YWLXMC
    */
    public String getYwlxmc() {
        return this.ywlxmc;
    }

    /**
    * 设置业务类型名称
    * @param ywlxmc
    */
    public void setYwlxmc(String ywlxmc) {
        this.ywlxmc = ywlxmc;
    }

    /**
    * 获得所属省市县区
    * @return SSXQ
    */
    public String getSsxq() {
        return this.ssxq;
    }

    /**
    * 设置所属省市县区
    * @param ssxq
    */
    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    /**
    * 获得事项编号（业务具体小类）
    * @return SXBH
    */
    public String getSxbh() {
        return this.sxbh;
    }

    /**
    * 设置事项编号（业务具体小类）
    * @param sxbh
    */
    public void setSxbh(String sxbh) {
        this.sxbh = sxbh;
    }

    /**
    * 获得事项名称（业务具体小类）
    * @return SXMC
    */
    public String getSxmc() {
        return this.sxmc;
    }

    /**
    * 设置事项名称（业务具体小类）
    * @param sxmc
    */
    public void setSxmc(String sxmc) {
        this.sxmc = sxmc;
    }

    /**
    * 获得事项性质（公共服务）
    * @return SXXZ
    */
    public String getSxxz() {
        return this.sxxz;
    }

    /**
    * 设置事项性质（公共服务）
    * @param sxxz
    */
    public void setSxxz(String sxxz) {
        this.sxxz = sxxz;
    }

    /**
    * 获得申请条件
    * @return SQTJ
    */
    public String getSqtj() {
        return this.sqtj;
    }

    /**
    * 设置申请条件
    * @param sqtj
    */
    public void setSqtj(String sqtj) {
        this.sqtj = sqtj;
    }

    /**
    * 获得申报材料
    * @return SBCL
    */
    public String getSbcl() {
        return this.sbcl;
    }

    /**
    * 设置申报材料
    * @param sbcl
    */
    public void setSbcl(String sbcl) {
        this.sbcl = sbcl;
    }

    /**
    * 获得办理流程
    * @return BLLC
    */
    public String getBllc() {
        return this.bllc;
    }

    /**
    * 设置办理流程
    * @param bllc
    */
    public void setBllc(String bllc) {
        this.bllc = bllc;
    }

    /**
    * 获得审批依据
    * @return SPYJ
    */
    public String getSpyj() {
        return this.spyj;
    }

    /**
    * 设置审批依据
    * @param spyj
    */
    public void setSpyj(String spyj) {
        this.spyj = spyj;
    }

    /**
    * 获得审批机关
    * @return SPJG
    */
    public String getSpjg() {
        return this.spjg;
    }

    /**
    * 设置审批机关
    * @param spjg
    */
    public void setSpjg(String spjg) {
        this.spjg = spjg;
    }

    /**
    * 获得承诺周期
    * @return FDZQ
    */
    public String getFdzq() {
        return this.fdzq;
    }

    /**
    * 设置承诺周期
    * @param fdzq
    */
    public void setFdzq(String fdzq) {
        this.fdzq = fdzq;
    }

    /**
    * 获得法定时限
    * @return CNSX
    */
    public String getCnsx() {
        return this.cnsx;
    }

    /**
    * 设置法定时限
    * @param cnsx
    */
    public void setCnsx(String cnsx) {
        this.cnsx = cnsx;
    }

    /**
    * 获得收费标准及依据
    * @return SFBZ
    */
    public String getSfbz() {
        return this.sfbz;
    }

    /**
    * 设置收费标准及依据
    * @param sfbz
    */
    public void setSfbz(String sfbz) {
        this.sfbz = sfbz;
    }

    /**
    * 获得备注
    * @return BZ
    */
    public String getBz() {
        return this.bz;
    }

    /**
    * 设置备注
    * @param bz
    */
    public void setBz(String bz) {
        this.bz = bz;
    }

    /**
    * 获得发布时间
    * @return FBSJ
    */
    public String getFbsj() {
        return this.fbsj;
    }

    /**
    * 设置发布时间
    * @param fbsj
    */
    public void setFbsj(String fbsj) {
        this.fbsj = fbsj;
    }

    /**
    * 获得发布单位名称
    * @return FBDWMC
    */
    public String getFbdwmc() {
        return this.fbdwmc;
    }

    /**
    * 设置发布单位名称
    * @param fbdwmc
    */
    public void setFbdwmc(String fbdwmc) {
        this.fbdwmc = fbdwmc;
    }

    /**
    * 获得发布人姓名
    * @return FBRXM
    */
    public String getFbrxm() {
        return this.fbrxm;
    }

    /**
    * 设置发布人姓名
    * @param fbrxm
    */
    public void setFbrxm(String fbrxm) {
        this.fbrxm = fbrxm;
    }

    /**
    * 获得更新单位名称
    * @return GXDWMC
    */
    public String getGxdwmc() {
        return this.gxdwmc;
    }

    /**
    * 设置更新单位名称
    * @param gxdwmc
    */
    public void setGxdwmc(String gxdwmc) {
        this.gxdwmc = gxdwmc;
    }

    /**
    * 获得更新人姓名
    * @return GXRXM
    */
    public String getGxrxm() {
        return this.gxrxm;
    }

    /**
    * 设置更新人姓名
    * @param gxrxm
    */
    public void setGxrxm(String gxrxm) {
        this.gxrxm = gxrxm;
    }

    /**
    * 获得更新时间
    * @return GXSJ
    */
    public String getGxsj() {
        return this.gxsj;
    }

    /**
    * 设置更新时间
    * @param gxsj
    */
    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
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


}