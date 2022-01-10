package com.pkusoft.zfgk.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

/**
 * @author 
 * @title: ZfgkCaseDocument 
 */
@ApiModel("录取公开文书")
public class ZfgkCaseDocumentReqParam extends YgjwPage {

 	/**
     * 记录文书主键
     */
    @ApiModelProperty(value = "记录文书主键")
    private String docId; 

 	/**
     * 文档信息
     */
    @ApiModelProperty(value = "文档信息")
    private String docxx; 

 	/**
     * 法律文书编号
     */
    @ApiModelProperty(value = "法律文书编号")
    private String wsbh; 

 	/**
     * 案件编号
     */
    @ApiModelProperty(value = "案件编号")
    private String ajbh; 

 	/**
     * 制作机关名称
     */
    @ApiModelProperty(value = "制作机关名称")
    private String zzjgmc; 

 	/**
     * 法律文书名称
     */
    @ApiModelProperty(value = "法律文书名称")
    private String wsmc; 

 	/**
     * 法律文书号
     */
    @ApiModelProperty(value = "法律文书号")
    private String flwsh; 

 	/**
     * 法律文书呈请理由
     */
    @ApiModelProperty(value = "法律文书呈请理由")
    private String cqly; 

 	/**
     * 法律文书事实依据
     */
    @ApiModelProperty(value = "法律文书事实依据")
    private String ssyj; 

 	/**
     * 法律文书法律依据
     */
    @ApiModelProperty(value = "法律文书法律依据")
    private String flyj; 

 	/**
     * 填发时间（字符串格式’YYYYMMDDHH24MISS’）
     */
    @ApiModelProperty(value = "填发时间（字符串格式’YYYYMMDDHH24MISS’）")
    private String tfsj; 

 	/**
     * 登记时间（字符串格式’YYYYMMDDHH24MISS’）
     */
    @ApiModelProperty(value = "登记时间（字符串格式’YYYYMMDDHH24MISS’）")
    private String djsj; 

 	/**
     * 修改时间（字符串格式’YYYYMMDDHH24MISS’）
     */
    @ApiModelProperty(value = "修改时间（字符串格式’YYYYMMDDHH24MISS’）")
    private String xgsj; 

 	/**
     * 呈请报告编号
     */
    @ApiModelProperty(value = "呈请报告编号")
    private String csbh; 

 	/**
     * 决定单位（字典名称：公安机构代码）
     */
    @ApiModelProperty(value = "决定单位（字典名称：公安机构代码）")
    private String jddw; 

 	/**
     * 预留字段1
     */
    @ApiModelProperty(value = "预留字段1")
    private String reserve1; 

 	/**
     * 预留字段2
     */
    @ApiModelProperty(value = "预留字段2")
    private String reserve2; 

 	/**
     * 预留字段3
     */
    @ApiModelProperty(value = "预留字段3")
    private String reserve3; 

 	/**
     * 预留字段4
     */
    @ApiModelProperty(value = "预留字段4")
    private String reserve4; 

 	/**
     * 预留字段5
     */
    @ApiModelProperty(value = "预留字段5")
    private String reserve5; 

 	/**
     * 文书pdf
     */
    @ApiModelProperty(value = "文书pdf")
    private String docpdf; 

 	/**
     * 数据状态（0/公开  1/撤销）
     */
    @ApiModelProperty(value = "数据状态（0/公开  1/撤销）")
    private String state; 

 	/**
     * 接收时间（字符串格式’YYYYMMDDHH24MISS’）
     */
    @ApiModelProperty(value = "接收时间（字符串格式’YYYYMMDDHH24MISS’）")
    private String jssj; 

 	/**
     * （0/1 ）回告整体数据（不完全/完全）
     */
    @ApiModelProperty(value = "（0/1 ）回告整体数据（不完全/完全）")
    private String normal; 


    /**
    * 获得记录文书主键
    * @return DOC_ID
    */
    public String getDocId() {
        return this.docId;
    }

    /**
    * 设置记录文书主键
    * @param docId
    */
    public void setDocId(String docId) {
        this.docId = docId;
    }

    /**
    * 获得文档信息
    * @return DOCXX
    */
    public String getDocxx() {
        return this.docxx;
    }

    /**
    * 设置文档信息
    * @param docxx
    */
    public void setDocxx(String docxx) {
        this.docxx = docxx;
    }

    /**
    * 获得法律文书编号
    * @return WSBH
    */
    public String getWsbh() {
        return this.wsbh;
    }

    /**
    * 设置法律文书编号
    * @param wsbh
    */
    public void setWsbh(String wsbh) {
        this.wsbh = wsbh;
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
    * 获得制作机关名称
    * @return ZZJGMC
    */
    public String getZzjgmc() {
        return this.zzjgmc;
    }

    /**
    * 设置制作机关名称
    * @param zzjgmc
    */
    public void setZzjgmc(String zzjgmc) {
        this.zzjgmc = zzjgmc;
    }

    /**
    * 获得法律文书名称
    * @return WSMC
    */
    public String getWsmc() {
        return this.wsmc;
    }

    /**
    * 设置法律文书名称
    * @param wsmc
    */
    public void setWsmc(String wsmc) {
        this.wsmc = wsmc;
    }

    /**
    * 获得法律文书号
    * @return FLWSH
    */
    public String getFlwsh() {
        return this.flwsh;
    }

    /**
    * 设置法律文书号
    * @param flwsh
    */
    public void setFlwsh(String flwsh) {
        this.flwsh = flwsh;
    }

    /**
    * 获得法律文书呈请理由
    * @return CQLY
    */
    public String getCqly() {
        return this.cqly;
    }

    /**
    * 设置法律文书呈请理由
    * @param cqly
    */
    public void setCqly(String cqly) {
        this.cqly = cqly;
    }

    /**
    * 获得法律文书事实依据
    * @return SSYJ
    */
    public String getSsyj() {
        return this.ssyj;
    }

    /**
    * 设置法律文书事实依据
    * @param ssyj
    */
    public void setSsyj(String ssyj) {
        this.ssyj = ssyj;
    }

    /**
    * 获得法律文书法律依据
    * @return FLYJ
    */
    public String getFlyj() {
        return this.flyj;
    }

    /**
    * 设置法律文书法律依据
    * @param flyj
    */
    public void setFlyj(String flyj) {
        this.flyj = flyj;
    }

    /**
    * 获得填发时间（字符串格式’YYYYMMDDHH24MISS’）
    * @return TFSJ
    */
    public String getTfsj() {
        return this.tfsj;
    }

    /**
    * 设置填发时间（字符串格式’YYYYMMDDHH24MISS’）
    * @param tfsj
    */
    public void setTfsj(String tfsj) {
        this.tfsj = tfsj;
    }

    /**
    * 获得登记时间（字符串格式’YYYYMMDDHH24MISS’）
    * @return DJSJ
    */
    public String getDjsj() {
        return this.djsj;
    }

    /**
    * 设置登记时间（字符串格式’YYYYMMDDHH24MISS’）
    * @param djsj
    */
    public void setDjsj(String djsj) {
        this.djsj = djsj;
    }

    /**
    * 获得修改时间（字符串格式’YYYYMMDDHH24MISS’）
    * @return XGSJ
    */
    public String getXgsj() {
        return this.xgsj;
    }

    /**
    * 设置修改时间（字符串格式’YYYYMMDDHH24MISS’）
    * @param xgsj
    */
    public void setXgsj(String xgsj) {
        this.xgsj = xgsj;
    }

    /**
    * 获得呈请报告编号
    * @return CSBH
    */
    public String getCsbh() {
        return this.csbh;
    }

    /**
    * 设置呈请报告编号
    * @param csbh
    */
    public void setCsbh(String csbh) {
        this.csbh = csbh;
    }

    /**
    * 获得决定单位（字典名称：公安机构代码）
    * @return JDDW
    */
    public String getJddw() {
        return this.jddw;
    }

    /**
    * 设置决定单位（字典名称：公安机构代码）
    * @param jddw
    */
    public void setJddw(String jddw) {
        this.jddw = jddw;
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
    * 获得预留字段4
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置预留字段4
    * @param reserve4
    */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
    * 获得预留字段5
    * @return RESERVE5
    */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
    * 设置预留字段5
    * @param reserve5
    */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    /**
    * 获得文书pdf
    * @return DOCPDF
    */
    public String getDocpdf() {
        return this.docpdf;
    }

    /**
    * 设置文书pdf
    * @param docpdf
    */
    public void setDocpdf(String docpdf) {
        this.docpdf = docpdf;
    }

    /**
    * 获得数据状态（0/公开  1/撤销）
    * @return STATE
    */
    public String getState() {
        return this.state;
    }

    /**
    * 设置数据状态（0/公开  1/撤销）
    * @param state
    */
    public void setState(String state) {
        this.state = state;
    }

    /**
    * 获得接收时间（字符串格式’YYYYMMDDHH24MISS’）
    * @return JSSJ
    */
    public String getJssj() {
        return this.jssj;
    }

    /**
    * 设置接收时间（字符串格式’YYYYMMDDHH24MISS’）
    * @param jssj
    */
    public void setJssj(String jssj) {
        this.jssj = jssj;
    }

    /**
    * 获得（0/1 ）回告整体数据（不完全/完全）
    * @return NORMAL
    */
    public String getNormal() {
        return this.normal;
    }

    /**
    * 设置（0/1 ）回告整体数据（不完全/完全）
    * @param normal
    */
    public void setNormal(String normal) {
        this.normal = normal;
    }


}