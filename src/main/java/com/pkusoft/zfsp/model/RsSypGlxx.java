package com.pkusoft.zfsp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

/**
 * @author 
 * @title: RsSypGlxx 
 */
@ApiModel("")
@Table(name = "RS_SYP_GLXX")
public class RsSypGlxx {

 	/**
     * 主键
     */
    @Id
    @Column(name = "SYPBH")
    @ApiModelProperty(value = "主键")
    private String sypbh; 

 	/**
     * 播放地址
     */
    @Column(name = "URL")
    @ApiModelProperty(value = "播放地址")
    private String url; 

 	/**
     * 接警编号
     */
    @Column(name = "JJBH")
    @ApiModelProperty(value = "接警编号")
    private String jjbh; 

 	/**
     * 处警编号
     */
    @Column(name = "CJBH")
    @ApiModelProperty(value = "处警编号")
    private String cjbh; 

 	/**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh; 

 	/**
     * 单位编码
     */
    @Column(name = "DWBH")
    @ApiModelProperty(value = "单位编码")
    private String dwbh; 

 	/**
     * 单位名称
     */
    @Column(name = "DWMC")
    @ApiModelProperty(value = "单位名称")
    private String dwmc; 

 	/**
     * 公安机构代码
     */
    @Column(name = "GA_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安机构代码")
    private String gaOwnerDept1; 

 	/**
     * 公安机构代码
     */
    @Column(name = "GA_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安机构代码")
    private String gaOwnerDept2; 

 	/**
     * 公安机构代码
     */
    @Column(name = "GA_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安机构代码")
    private String gaOwnerDept3; 

 	/**
     * 公安机构代码
     */
    @Column(name = "GA_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安机构代码")
    private String gaOwnerDept4; 

 	/**
     * 公安机构代码
     */
    @Column(name = "GA_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安机构代码")
    private String gaOwnerDept5; 

 	/**
     * 公安机构代码
     */
    @Column(name = "BZ_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安机构代码")
    private String bzOwnerDept1; 

 	/**
     * 公安机构代码
     */
    @Column(name = "BZ_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安机构代码")
    private String bzOwnerDept2; 

 	/**
     * 公安机构代码
     */
    @Column(name = "BZ_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安机构代码")
    private String bzOwnerDept3; 

 	/**
     * 公安机构代码
     */
    @Column(name = "BZ_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安机构代码")
    private String bzOwnerDept4; 

 	/**
     * 公安机构代码
     */
    @Column(name = "BZ_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安机构代码")
    private String bzOwnerDept5; 

 	/**
     * 类别
     */
    @Column(name = "LB")
    @ApiModelProperty(value = "类别")
    private String lb; 

 	/**
     * 拍摄人身份证号码
     */
    @Column(name = "PSR_SFZHM")
    @ApiModelProperty(value = "拍摄人身份证号码")
    private String psrSfzhm; 

 	/**
     * 拍摄人姓名
     */
    @Column(name = "PSR_XM")
    @ApiModelProperty(value = "拍摄人姓名")
    private String psrXm; 

 	/**
     * 拍摄人警号
     */
    @Column(name = "PSR_JH")
    @ApiModelProperty(value = "拍摄人警号")
    private String psrJh; 

 	/**
     * 拍摄时间
     */
    @Column(name = "PSSJ")
    @ApiModelProperty(value = "拍摄时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.util.Date pssj; 

 	/**
     * 上传时间
     */
    @Column(name = "SCSJ")
    @ApiModelProperty(value = "上传时间")
    private java.util.Date scsj; 

 	/**
     * 关联时间
     */
    @Column(name = "GLSJ")
    @ApiModelProperty(value = "关联时间")
    private java.util.Date glsj; 

 	/**
     * 修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date xgsj; 

 	/**
     * 视频时长
     */
    @Column(name = "SPSC")
    @ApiModelProperty(value = "视频时长")
    private String spsc; 


    /**
    * 获得主键
    * @return SYPBH
    */
    public String getSypbh() {
        return this.sypbh;
    }

    /**
    * 设置主键
    * @param sypbh
    */
    public void setSypbh(String sypbh) {
        this.sypbh = sypbh;
    }

    /**
    * 获得播放地址
    * @return URL
    */
    public String getUrl() {
        return this.url;
    }

    /**
    * 设置播放地址
    * @param url
    */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
    * 获得接警编号
    * @return JJBH
    */
    public String getJjbh() {
        return this.jjbh;
    }

    /**
    * 设置接警编号
    * @param jjbh
    */
    public void setJjbh(String jjbh) {
        this.jjbh = jjbh;
    }

    /**
    * 获得处警编号
    * @return CJBH
    */
    public String getCjbh() {
        return this.cjbh;
    }

    /**
    * 设置处警编号
    * @param cjbh
    */
    public void setCjbh(String cjbh) {
        this.cjbh = cjbh;
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
    * 获得单位编码
    * @return DWBH
    */
    public String getDwbh() {
        return this.dwbh;
    }

    /**
    * 设置单位编码
    * @param dwbh
    */
    public void setDwbh(String dwbh) {
        this.dwbh = dwbh;
    }

    /**
    * 获得单位名称
    * @return DWMC
    */
    public String getDwmc() {
        return this.dwmc;
    }

    /**
    * 设置单位名称
    * @param dwmc
    */
    public void setDwmc(String dwmc) {
        this.dwmc = dwmc;
    }

    /**
    * 获得公安机构代码
    * @return GA_OWNER_DEPT_1
    */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
    * 设置公安机构代码
    * @param gaOwnerDept1
    */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
    * 获得公安机构代码
    * @return GA_OWNER_DEPT_2
    */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
    * 设置公安机构代码
    * @param gaOwnerDept2
    */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
    * 获得公安机构代码
    * @return GA_OWNER_DEPT_3
    */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
    * 设置公安机构代码
    * @param gaOwnerDept3
    */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
    * 获得公安机构代码
    * @return GA_OWNER_DEPT_4
    */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
    * 设置公安机构代码
    * @param gaOwnerDept4
    */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
    * 获得公安机构代码
    * @return GA_OWNER_DEPT_5
    */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
    * 设置公安机构代码
    * @param gaOwnerDept5
    */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }

    /**
    * 获得公安机构代码
    * @return BZ_OWNER_DEPT_1
    */
    public String getBzOwnerDept1() {
        return this.bzOwnerDept1;
    }

    /**
    * 设置公安机构代码
    * @param bzOwnerDept1
    */
    public void setBzOwnerDept1(String bzOwnerDept1) {
        this.bzOwnerDept1 = bzOwnerDept1;
    }

    /**
    * 获得公安机构代码
    * @return BZ_OWNER_DEPT_2
    */
    public String getBzOwnerDept2() {
        return this.bzOwnerDept2;
    }

    /**
    * 设置公安机构代码
    * @param bzOwnerDept2
    */
    public void setBzOwnerDept2(String bzOwnerDept2) {
        this.bzOwnerDept2 = bzOwnerDept2;
    }

    /**
    * 获得公安机构代码
    * @return BZ_OWNER_DEPT_3
    */
    public String getBzOwnerDept3() {
        return this.bzOwnerDept3;
    }

    /**
    * 设置公安机构代码
    * @param bzOwnerDept3
    */
    public void setBzOwnerDept3(String bzOwnerDept3) {
        this.bzOwnerDept3 = bzOwnerDept3;
    }

    /**
    * 获得公安机构代码
    * @return BZ_OWNER_DEPT_4
    */
    public String getBzOwnerDept4() {
        return this.bzOwnerDept4;
    }

    /**
    * 设置公安机构代码
    * @param bzOwnerDept4
    */
    public void setBzOwnerDept4(String bzOwnerDept4) {
        this.bzOwnerDept4 = bzOwnerDept4;
    }

    /**
    * 获得公安机构代码
    * @return BZ_OWNER_DEPT_5
    */
    public String getBzOwnerDept5() {
        return this.bzOwnerDept5;
    }

    /**
    * 设置公安机构代码
    * @param bzOwnerDept5
    */
    public void setBzOwnerDept5(String bzOwnerDept5) {
        this.bzOwnerDept5 = bzOwnerDept5;
    }

    /**
    * 获得类别
    * @return LB
    */
    public String getLb() {
        return this.lb;
    }

    /**
    * 设置类别
    * @param lb
    */
    public void setLb(String lb) {
        this.lb = lb;
    }

    /**
    * 获得拍摄人身份证号码
    * @return PSR_SFZHM
    */
    public String getPsrSfzhm() {
        return this.psrSfzhm;
    }

    /**
    * 设置拍摄人身份证号码
    * @param psrSfzhm
    */
    public void setPsrSfzhm(String psrSfzhm) {
        this.psrSfzhm = psrSfzhm;
    }

    /**
    * 获得拍摄人姓名
    * @return PSR_XM
    */
    public String getPsrXm() {
        return this.psrXm;
    }

    /**
    * 设置拍摄人姓名
    * @param psrXm
    */
    public void setPsrXm(String psrXm) {
        this.psrXm = psrXm;
    }

    /**
    * 获得拍摄人警号
    * @return PSR_JH
    */
    public String getPsrJh() {
        return this.psrJh;
    }

    /**
    * 设置拍摄人警号
    * @param psrJh
    */
    public void setPsrJh(String psrJh) {
        this.psrJh = psrJh;
    }

    /**
    * 获得拍摄时间
    * @return PSSJ
    */
    public java.util.Date getPssj() {
        return this.pssj;
    }

    /**
    * 设置拍摄时间
    * @param pssj
    */
    public void setPssj(java.util.Date pssj) {
        this.pssj = pssj;
    }

    /**
    * 获得上传时间
    * @return SCSJ
    */
    public java.util.Date getScsj() {
        return this.scsj;
    }

    /**
    * 设置上传时间
    * @param scsj
    */
    public void setScsj(java.util.Date scsj) {
        this.scsj = scsj;
    }

    /**
    * 获得关联时间
    * @return GLSJ
    */
    public java.util.Date getGlsj() {
        return this.glsj;
    }

    /**
    * 设置关联时间
    * @param glsj
    */
    public void setGlsj(java.util.Date glsj) {
        this.glsj = glsj;
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

    /**
    * 获得视频时长
    * @return SPSC
    */
    public String getSpsc() {
        return this.spsc;
    }

    /**
    * 设置视频时长
    * @param spsc
    */
    public void setSpsc(String spsc) {
        this.spsc = spsc;
    }


}