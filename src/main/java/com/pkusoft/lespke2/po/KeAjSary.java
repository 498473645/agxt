package com.pkusoft.lespke2.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author 
 * @title: KeAjSary 
 */
@ApiModel("案件涉案人员信息（201912版）")
@Table(name = "KE_AJ_SARY")
public class KeAjSary {

 	/**
     * 案件编号（案件信息的外键）
     */
    @Id
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号（案件信息的外键）")
    private String ajbh; 

 	/**
     * 涉案人员身份证号码（人员信息的外键）
     */
    @Column(name = "SARY_SFZHM")
    @ApiModelProperty(value = "涉案人员身份证号码（人员信息的外键）")
    private String sarySfzhm; 

 	/**
     * 涉案人员姓名
     */
    @Column(name = "SARY_XM")
    @ApiModelProperty(value = "涉案人员姓名")
    private String saryXm; 

 	/**
     * 类别编号
     */
    @Column(name = "LB_BH")
    @ApiModelProperty(value = "类别编号")
    private String lbBh; 

 	/**
     * 类别名称
     */
    @Column(name = "LB_MC")
    @ApiModelProperty(value = "类别名称")
    private String lbMc; 

 	/**
     * 抓获时间
     */
    @Column(name = "ZHSJ")
    @ApiModelProperty(value = "抓获时间")
    private java.util.Date zhsj; 

 	/**
     * 修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date xgsj; 


    /**
    * 获得案件编号（案件信息的外键）
    * @return AJBH
    */
    public String getAjbh() {
        return this.ajbh;
    }

    /**
    * 设置案件编号（案件信息的外键）
    * @param ajbh
    */
    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    /**
    * 获得涉案人员身份证号码（人员信息的外键）
    * @return SARY_SFZHM
    */
    public String getSarySfzhm() {
        return this.sarySfzhm;
    }

    /**
    * 设置涉案人员身份证号码（人员信息的外键）
    * @param sarySfzhm
    */
    public void setSarySfzhm(String sarySfzhm) {
        this.sarySfzhm = sarySfzhm;
    }

    /**
    * 获得涉案人员姓名
    * @return SARY_XM
    */
    public String getSaryXm() {
        return this.saryXm;
    }

    /**
    * 设置涉案人员姓名
    * @param saryXm
    */
    public void setSaryXm(String saryXm) {
        this.saryXm = saryXm;
    }

    /**
    * 获得类别编号
    * @return LB_BH
    */
    public String getLbBh() {
        return this.lbBh;
    }

    /**
    * 设置类别编号
    * @param lbBh
    */
    public void setLbBh(String lbBh) {
        this.lbBh = lbBh;
    }

    /**
    * 获得类别名称
    * @return LB_MC
    */
    public String getLbMc() {
        return this.lbMc;
    }

    /**
    * 设置类别名称
    * @param lbMc
    */
    public void setLbMc(String lbMc) {
        this.lbMc = lbMc;
    }

    /**
    * 获得抓获时间
    * @return ZHSJ
    */
    public java.util.Date getZhsj() {
        return this.zhsj;
    }

    /**
    * 设置抓获时间
    * @param zhsj
    */
    public void setZhsj(java.util.Date zhsj) {
        this.zhsj = zhsj;
    }

    /**
    * 获得修改时间
    * @return XGSJ
    */
    public java.util.Date getXgsj() {
        return this.xgsj;
    }

    /**
    * 设置修改时间
    * @param xgsj
    */
    public void setXgsj(java.util.Date xgsj) {
        this.xgsj = xgsj;
    }


}