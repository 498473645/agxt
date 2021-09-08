package com.pkusoft.lespke2.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: KeAjWsnr
 */
@ApiModel("案件的文书内容")
@Table(name = "KE_AJ_WSNR")
public class KeAjWsnr {

 	/**
     * 文书编号
     */
    @Id
    @Column(name = "FLWSBH")
    @ApiModelProperty(value = "文书编号")
    private String flwsbh;

 	/**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh;

 	/**
     * 关联编号
     */
    @Column(name = "GLBH")
    @ApiModelProperty(value = "关联编号")
    private String glbh;

 	/**
     * 文书类型
     */
    @Column(name = "WSBT")
    @ApiModelProperty(value = "文书类型")
    private String wsbt;

 	/**
     *
     */
    @Column(name = "WSZ")
    @ApiModelProperty(value = "")
    private String wsz;

 	/**
     * 文书内容
     */
    @Column(name = "WSNR")
    @ApiModelProperty(value = "文书内容")
    private byte[] wsnr;

 	/**
     * 填发单位
     */
    @Column(name = "TFDW")
    @ApiModelProperty(value = "填发单位")
    private String tfdw;

 	/**
     * 填发单位名称
     */
    @Column(name = "TFDW_MC")
    @ApiModelProperty(value = "填发单位名称")
    private String tfdwMc;

 	/**
     * 填发日期
     */
    @Column(name = "TFRQ")
    @ApiModelProperty(value = "填发日期")
    private java.util.Date tfrq;

 	/**
     * 填发人
     */
    @Column(name = "TFR")
    @ApiModelProperty(value = "填发人")
    private String tfr;

 	/**
     * 操作单位
     */
    @Column(name = "CZDW")
    @ApiModelProperty(value = "操作单位")
    private String czdw;

 	/**
     * 操作单位名称
     */
    @Column(name = "CZDW_MC")
    @ApiModelProperty(value = "操作单位名称")
    private String czdwMc;

 	/**
     * 操作人姓名
     */
    @Column(name = "CZR")
    @ApiModelProperty(value = "操作人姓名")
    private String czr;

 	/**
     * 操作时间
     */
    @Column(name = "CZSJ")
    @ApiModelProperty(value = "操作时间")
    private java.util.Date czsj;

 	/**
     * 操作标识
     */
    @Column(name = "CZBS")
    @ApiModelProperty(value = "操作标识")
    private String czbs;

 	/**
     *
     */
    @Column(name = "FLWSQZBS")
    @ApiModelProperty(value = "")
    private String flwsqzbs;

 	/**
     * 法律文书名称
     */
    @Column(name = "FLWSMC")
    @ApiModelProperty(value = "法律文书名称")
    private String flwsmc;

 	/**
     * 文书编号
     */
    @Column(name = "WH")
    @ApiModelProperty(value = "文书编号")
    private String wh;

 	/**
     * 对象名称
     */
    @Column(name = "DXMC")
    @ApiModelProperty(value = "对象名称")
    private String dxmc;

 	/**
     * 修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date xgsj;


    /**
    * 获得文书编号
    * @return FLWSBH
    */
    public String getFlwsbh() {
        return this.flwsbh;
    }

    /**
    * 设置文书编号
    * @param flwsbh
    */
    public void setFlwsbh(String flwsbh) {
        this.flwsbh = flwsbh;
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
    * 获得关联编号
    * @return GLBH
    */
    public String getGlbh() {
        return this.glbh;
    }

    /**
    * 设置关联编号
    * @param glbh
    */
    public void setGlbh(String glbh) {
        this.glbh = glbh;
    }

    /**
    * 获得文书类型
    * @return WSBT
    */
    public String getWsbt() {
        return this.wsbt;
    }

    /**
    * 设置文书类型
    * @param wsbt
    */
    public void setWsbt(String wsbt) {
        this.wsbt = wsbt;
    }

    /**
    * 获得
    * @return WSZ
    */
    public String getWsz() {
        return this.wsz;
    }

    /**
    * 设置
    * @param wsz
    */
    public void setWsz(String wsz) {
        this.wsz = wsz;
    }

    public byte[] getWsnr() {
        return wsnr;
    }

    public void setWsnr(byte[] wsnr) {
        this.wsnr = wsnr;
    }

    /**
    * 获得填发单位
    * @return TFDW
    */
    public String getTfdw() {
        return this.tfdw;
    }

    /**
    * 设置填发单位
    * @param tfdw
    */
    public void setTfdw(String tfdw) {
        this.tfdw = tfdw;
    }

    /**
    * 获得填发单位名称
    * @return TFDW_MC
    */
    public String getTfdwMc() {
        return this.tfdwMc;
    }

    /**
    * 设置填发单位名称
    * @param tfdwMc
    */
    public void setTfdwMc(String tfdwMc) {
        this.tfdwMc = tfdwMc;
    }

    /**
    * 获得填发日期
    * @return TFRQ
    */
    public java.util.Date getTfrq() {
        return this.tfrq;
    }

    /**
    * 设置填发日期
    * @param tfrq
    */
    public void setTfrq(java.util.Date tfrq) {
        this.tfrq = tfrq;
    }

    /**
    * 获得填发人
    * @return TFR
    */
    public String getTfr() {
        return this.tfr;
    }

    /**
    * 设置填发人
    * @param tfr
    */
    public void setTfr(String tfr) {
        this.tfr = tfr;
    }

    /**
    * 获得操作单位
    * @return CZDW
    */
    public String getCzdw() {
        return this.czdw;
    }

    /**
    * 设置操作单位
    * @param czdw
    */
    public void setCzdw(String czdw) {
        this.czdw = czdw;
    }

    /**
    * 获得操作单位名称
    * @return CZDW_MC
    */
    public String getCzdwMc() {
        return this.czdwMc;
    }

    /**
    * 设置操作单位名称
    * @param czdwMc
    */
    public void setCzdwMc(String czdwMc) {
        this.czdwMc = czdwMc;
    }

    /**
    * 获得操作人姓名
    * @return CZR
    */
    public String getCzr() {
        return this.czr;
    }

    /**
    * 设置操作人姓名
    * @param czr
    */
    public void setCzr(String czr) {
        this.czr = czr;
    }

    /**
    * 获得操作时间
    * @return CZSJ
    */
    public java.util.Date getCzsj() {
        return this.czsj;
    }

    /**
    * 设置操作时间
    * @param czsj
    */
    public void setCzsj(java.util.Date czsj) {
        this.czsj = czsj;
    }

    /**
    * 获得操作标识
    * @return CZBS
    */
    public String getCzbs() {
        return this.czbs;
    }

    /**
    * 设置操作标识
    * @param czbs
    */
    public void setCzbs(String czbs) {
        this.czbs = czbs;
    }

    /**
    * 获得
    * @return FLWSQZBS
    */
    public String getFlwsqzbs() {
        return this.flwsqzbs;
    }

    /**
    * 设置
    * @param flwsqzbs
    */
    public void setFlwsqzbs(String flwsqzbs) {
        this.flwsqzbs = flwsqzbs;
    }

    /**
    * 获得法律文书名称
    * @return FLWSMC
    */
    public String getFlwsmc() {
        return this.flwsmc;
    }

    /**
    * 设置法律文书名称
    * @param flwsmc
    */
    public void setFlwsmc(String flwsmc) {
        this.flwsmc = flwsmc;
    }

    /**
    * 获得文书编号
    * @return WH
    */
    public String getWh() {
        return this.wh;
    }

    /**
    * 设置文书编号
    * @param wh
    */
    public void setWh(String wh) {
        this.wh = wh;
    }

    /**
    * 获得对象名称
    * @return DXMC
    */
    public String getDxmc() {
        return this.dxmc;
    }

    /**
    * 设置对象名称
    * @param dxmc
    */
    public void setDxmc(String dxmc) {
        this.dxmc = dxmc;
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
