package com.pkusoft.zfgk.req;

import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

import javax.persistence.Column;
import javax.persistence.Id;

public class ZfgkCasePublicReqParam extends YgjwPage {

    /**序列化版本号*/
    private static final long serialVersionUID = 1L;

    /**
     * 案件公开组键
     */
    @Id
    @Column(name = "PUBLIC_ID")
    @ApiModelProperty(value = "案例公开主键")
    private String publicId;

    /**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh;

    /**
     * 案件名
     */
    @Column(name = "AJM")
    @ApiModelProperty(value = "案件名")
    private String ajm;

    /**
     * 受理时间
     */
    @Column(name = "SLSJ")
    @ApiModelProperty(value = "受理时间")
    private String slsj;

    /**
     * 简要案情
     */
    @Column(name = "JYAQ")
    @ApiModelProperty(value = "简要案情")
    private String jyaq;

    /**
     * 案件类别字，典名称：案件类别
     */
    @Column(name = "AJLB")
    @ApiModelProperty(value = "案件类别字")
    private String ajlb;

    /**
     * 主办人姓名
     */
    @Column(name = "ZBRXX")
    @ApiModelProperty(value = "主办人姓名")
    private String zbrxx;

    /**
     * 主办单位,字典名称：公安机构代码
     */
    @Column(name = "ZBDW")
    @ApiModelProperty(value = "主办单位")
    private String zbdw;

    /**
     * 案件归属单位,字典名称：公安机构代码
     */
    @Column(name = "AJGSDW")
    @ApiModelProperty(value = "案件归属单位")
    private String ajgsdw;

    /**
     * 公开时间
     */
    @Column(name = "GKSJ")
    @ApiModelProperty(value = "公开时间")
    private String gksj;

    /**
     * 操作人姓名
     */
    @Column(name = "CZRXM")
    @ApiModelProperty(value = "操作人姓名")
    private String czrxm;

    /**
     * 更新时间
     */
    @Column(name = "GXSJ")
    @ApiModelProperty(value = "更新时间")
    private String gxsj;

    /**
     * 更新人姓名
     */
    @Column(name = "GXRXM")
    @ApiModelProperty(value = "更新人姓名")
    private String gxrxm;

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
     * 预留字段4
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "预留字段4")
    private String reserve4;

    /**
     * 预留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "预留字段5")
    private String reserve5;

    /**
     * 公开信息
     */
    @Column(name = "GKXX")
    @ApiModelProperty(value = "公开信息")
    private String gkxx;

    /**
     * 案件状态,对应字典
     */
    @Column(name = "AJZT")
    @ApiModelProperty(value = "案件状态")
    private String ajzt;

    /**
     * 回告编号
     */
    @Column(name = "HGBH")
    @ApiModelProperty(value = "回告编号")
    private String hgbh;


    public ZfgkCasePublicReqParam(){

    }

    public ZfgkCasePublicReqParam(String publicId, String ajbh, String ajm, String slsj, String jyaq, String ajlb, String zbrxx, String zbdw, String ajgsdw, String gksj, String czrxm, String gxsj, String gxrxm, String reserve1, String reserve2, String reserve3, String reserve4, String reserve5, String gkxx, String ajzt, String hgbh){
        this.publicId = publicId;
        this.ajbh = ajbh;
        this.ajm = ajm;
        this.slsj = slsj;
        this.jyaq = jyaq;
        this.ajlb = ajlb;
        this.zbrxx = zbrxx;
        this.zbdw = zbdw;
        this.ajgsdw = ajgsdw;
        this.gksj = gksj;
        this.czrxm = czrxm;
        this.gxsj = gxsj;
        this.gxrxm = gxrxm;
        this.reserve1 = reserve1;
        this.reserve2 = reserve2;
        this.reserve3 = reserve3;
        this.reserve4 = reserve4;
        this.reserve5 = reserve5;
        this.gkxx = gkxx;
        this.ajzt = ajzt;
        this.hgbh = hgbh;
    }


    public String getPublicId() {
        return this.publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }


    public String getAjbh() {
        return this.ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }


    public String getAjm() {
        return this.ajm;
    }

    public void setAjm(String ajm) {
        this.ajm = ajm;
    }


    public String getSlsj() {
        return this.slsj;
    }

    public void setSlsj(String slsj) {
        this.slsj = slsj;
    }


    public String getJyaq() {
        return this.jyaq;
    }

    public void setJyaq(String jyaq) {
        this.jyaq = jyaq;
    }


    public String getAjlb() {
        return this.ajlb;
    }

    public void setAjlb(String ajlb) {
        this.ajlb = ajlb;
    }


    public String getZbrxx() {
        return this.zbrxx;
    }

    public void setZbrxx(String zbrxx) {
        this.zbrxx = zbrxx;
    }


    public String getZbdw() {
        return this.zbdw;
    }

    public void setZbdw(String zbdw) {
        this.zbdw = zbdw;
    }


    public String getAjgsdw() {
        return this.ajgsdw;
    }

    public void setAjgsdw(String ajgsdw) {
        this.ajgsdw = ajgsdw;
    }


    public String getGksj() {
        return this.gksj;
    }

    public void setGksj(String gksj) {
        this.gksj = gksj;
    }


    public String getCzrxm() {
        return this.czrxm;
    }

    public void setCzrxm(String czrxm) {
        this.czrxm = czrxm;
    }


    public String getGxsj() {
        return this.gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }


    public String getGxrxm() {
        return this.gxrxm;
    }

    public void setGxrxm(String gxrxm) {
        this.gxrxm = gxrxm;
    }


    public String getReserve1() {
        return this.reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }


    public String getReserve2() {
        return this.reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }


    public String getReserve3() {
        return this.reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }


    public String getReserve4() {
        return this.reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }


    public String getReserve5() {
        return this.reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }


    public String getGkxx() {
        return this.gkxx;
    }

    public void setGkxx(String gkxx) {
        this.gkxx = gkxx;
    }


    public String getAjzt() {
        return this.ajzt;
    }

    public void setAjzt(String ajzt) {
        this.ajzt = ajzt;
    }


    public String getHgbh() {
        return this.hgbh;
    }

    public void setHgbh(String hgbh) {
        this.hgbh = hgbh;
    }

}
