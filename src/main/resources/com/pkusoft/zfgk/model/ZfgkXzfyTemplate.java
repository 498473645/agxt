package com.pkusoft.zfgk.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: ZfgkXzfyTemplate
 */
@ApiModel("")
@Table(name = "ZFGK_XZFY_TEMPLATE")
public class ZfgkXzfyTemplate {

 	/**
     * 行政复议编号
     */
    @Id
    @Column(name = "XZFY_TID")
    @ApiModelProperty(value = "行政复议编号")
    private String xzfyTid;

 	/**
     * 申请人姓名
     */
    @Column(name = "SQRXM")
    @ApiModelProperty(value = "申请人姓名")
    private String sqrxm;

 	/**
     * 申请人住所
     */
    @Column(name = "SQRZS")
    @ApiModelProperty(value = "申请人住所")
    private String sqrzs;

 	/**
     * 申请人联系电话
     */
    @Column(name = "SQRLXDH")
    @ApiModelProperty(value = "申请人联系电话")
    private String sqrlxdh;

 	/**
     * 第三人姓名
     */
    @Column(name = "DSRXM")
    @ApiModelProperty(value = "第三人姓名")
    private String dsrxm;

 	/**
     * 第三人住所
     */
    @Column(name = "DSRZS")
    @ApiModelProperty(value = "第三人住所")
    private String dsrzs;

 	/**
     * 第三人联系电话
     */
    @Column(name = "DSRLXDH")
    @ApiModelProperty(value = "第三人联系电话")
    private String dsrlxdh;

 	/**
     * 被申请人姓名
     */
    @Column(name = "BSQRXM")
    @ApiModelProperty(value = "被申请人姓名")
    private String bsqrxm;

 	/**
     * 被申请人住所
     */
    @Column(name = "BSQRZS")
    @ApiModelProperty(value = "被申请人住所")
    private String bsqrzs;

 	/**
     * 被申请人法人代表
     */
    @Column(name = "BSQRFRDB")
    @ApiModelProperty(value = "被申请人法人代表")
    private String bsqrfrdb;

 	/**
     * 法人代表职位
     */
    @Column(name = "FRDBZW")
    @ApiModelProperty(value = "法人代表职位")
    private String frdbzw;

 	/**
     * 委托代理姓名
     */
    @Column(name = "WTRXM")
    @ApiModelProperty(value = "委托代理姓名")
    private String wtrxm;

 	/**
     * 委托代理联系电话
     */
    @Column(name = "WTRLXDH")
    @ApiModelProperty(value = "委托代理联系电话")
    private String wtrlxdh;

 	/**
     * 处罚日期
     */
    @Column(name = "CFRQ")
    @ApiModelProperty(value = "处罚日期")
    private String cfrq;

 	/**
     * 处罚决定书编号
     */
    @Column(name = "CFJDSBH")
    @ApiModelProperty(value = "处罚决定书编号")
    private String cfjdsbh;

 	/**
     * 处罚决定书名称
     */
    @Column(name = "CFJDSMC")
    @ApiModelProperty(value = "处罚决定书名称")
    private String cfjdsmc;

 	/**
     * 申请复议日期
     */
    @Column(name = "SQFYRQ")
    @ApiModelProperty(value = "申请复议日期")
    private String sqfyrq;

 	/**
     * 申请人申请内容
     */
    @Column(name = "SQRSQNR")
    @ApiModelProperty(value = "申请人申请内容")
    private String sqrsqnr;

 	/**
     * 被申请人
     */
    @Column(name = "BSQRCS")
    @ApiModelProperty(value = "被申请人")
    private String bsqrcs;

 	/**
     * 第三人称
     */
    @Column(name = "DSRCCS")
    @ApiModelProperty(value = "第三人称")
    private String dsrccs;

 	/**
     * 调查情况
     */
    @Column(name = "DCQK")
    @ApiModelProperty(value = "调查情况")
    private String dcqk;

 	/**
     * 事实依据
     */
    @Column(name = "SSYJ")
    @ApiModelProperty(value = "事实依据")
    private String ssyj;

 	/**
     * 法律依据
     */
    @Column(name = "FLYJ")
    @ApiModelProperty(value = "法律依据")
    private String flyj;

 	/**
     * 决定内容
     */
    @Column(name = "JDNR")
    @ApiModelProperty(value = "决定内容")
    private String jdnr;

 	/**
     * 决定单位
     */
    @Column(name = "JDDW")
    @ApiModelProperty(value = "决定单位")
    private String jddw;

 	/**
     * 决定日期
     */
    @Column(name = "JDRQ")
    @ApiModelProperty(value = "决定日期")
    private String jdrq;

 	/**
     * 接收时间
     */
    @Column(name = "JSRQ")
    @ApiModelProperty(value = "接收时间")
    private String jsrq;

 	/**
     * 行政复议信息
     */
    @Column(name = "XZFYXX")
    @ApiModelProperty(value = "行政复议信息")
    private String xzfyxx;

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
     * 复议法律文书号
     */
    @Column(name = "FYFLWSH")
    @ApiModelProperty(value = "复议法律文书号")
    private String fyflwsh;

 	/**
     * 诉讼单位
     */
    @Column(name = "SSDW")
    @ApiModelProperty(value = "诉讼单位")
    private String ssdw;

 	/**
     * 案件名称
     */
    @Column(name = "AJMC")
    @ApiModelProperty(value = "案件名称")
    private String ajmc;

 	/**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh;

 	/**
     * 数据添加时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "数据添加时间")
    private java.util.Date addTime;


    /**
    * 获得行政复议编号
    * @return XZFY_TID
    */
    public String getXzfyTid() {
        return this.xzfyTid;
    }

    /**
    * 设置行政复议编号
    * @param xzfyTid
    */
    public void setXzfyTid(String xzfyTid) {
        this.xzfyTid = xzfyTid;
    }

    /**
    * 获得申请人姓名
    * @return SQRXM
    */
    public String getSqrxm() {
        return this.sqrxm;
    }

    /**
    * 设置申请人姓名
    * @param sqrxm
    */
    public void setSqrxm(String sqrxm) {
        this.sqrxm = sqrxm;
    }

    /**
    * 获得申请人住所
    * @return SQRZS
    */
    public String getSqrzs() {
        return this.sqrzs;
    }

    /**
    * 设置申请人住所
    * @param sqrzs
    */
    public void setSqrzs(String sqrzs) {
        this.sqrzs = sqrzs;
    }

    /**
    * 获得申请人联系电话
    * @return SQRLXDH
    */
    public String getSqrlxdh() {
        return this.sqrlxdh;
    }

    /**
    * 设置申请人联系电话
    * @param sqrlxdh
    */
    public void setSqrlxdh(String sqrlxdh) {
        this.sqrlxdh = sqrlxdh;
    }

    /**
    * 获得第三人姓名
    * @return DSRXM
    */
    public String getDsrxm() {
        return this.dsrxm;
    }

    /**
    * 设置第三人姓名
    * @param dsrxm
    */
    public void setDsrxm(String dsrxm) {
        this.dsrxm = dsrxm;
    }

    /**
    * 获得第三人住所
    * @return DSRZS
    */
    public String getDsrzs() {
        return this.dsrzs;
    }

    /**
    * 设置第三人住所
    * @param dsrzs
    */
    public void setDsrzs(String dsrzs) {
        this.dsrzs = dsrzs;
    }

    /**
    * 获得第三人联系电话
    * @return DSRLXDH
    */
    public String getDsrlxdh() {
        return this.dsrlxdh;
    }

    /**
    * 设置第三人联系电话
    * @param dsrlxdh
    */
    public void setDsrlxdh(String dsrlxdh) {
        this.dsrlxdh = dsrlxdh;
    }

    /**
    * 获得被申请人姓名
    * @return BSQRXM
    */
    public String getBsqrxm() {
        return this.bsqrxm;
    }

    /**
    * 设置被申请人姓名
    * @param bsqrxm
    */
    public void setBsqrxm(String bsqrxm) {
        this.bsqrxm = bsqrxm;
    }

    /**
    * 获得被申请人住所
    * @return BSQRZS
    */
    public String getBsqrzs() {
        return this.bsqrzs;
    }

    /**
    * 设置被申请人住所
    * @param bsqrzs
    */
    public void setBsqrzs(String bsqrzs) {
        this.bsqrzs = bsqrzs;
    }

    /**
    * 获得被申请人法人代表
    * @return BSQRFRDB
    */
    public String getBsqrfrdb() {
        return this.bsqrfrdb;
    }

    /**
    * 设置被申请人法人代表
    * @param bsqrfrdb
    */
    public void setBsqrfrdb(String bsqrfrdb) {
        this.bsqrfrdb = bsqrfrdb;
    }

    /**
    * 获得法人代表职位
    * @return FRDBZW
    */
    public String getFrdbzw() {
        return this.frdbzw;
    }

    /**
    * 设置法人代表职位
    * @param frdbzw
    */
    public void setFrdbzw(String frdbzw) {
        this.frdbzw = frdbzw;
    }

    /**
    * 获得委托代理姓名
    * @return WTRXM
    */
    public String getWtrxm() {
        return this.wtrxm;
    }

    /**
    * 设置委托代理姓名
    * @param wtrxm
    */
    public void setWtrxm(String wtrxm) {
        this.wtrxm = wtrxm;
    }

    /**
    * 获得委托代理联系电话
    * @return WTRLXDH
    */
    public String getWtrlxdh() {
        return this.wtrlxdh;
    }

    /**
    * 设置委托代理联系电话
    * @param wtrlxdh
    */
    public void setWtrlxdh(String wtrlxdh) {
        this.wtrlxdh = wtrlxdh;
    }

    /**
    * 获得处罚日期
    * @return CFRQ
    */
    public String getCfrq() {
        return this.cfrq;
    }

    /**
    * 设置处罚日期
    * @param cfrq
    */
    public void setCfrq(String cfrq) {
        this.cfrq = cfrq;
    }

    /**
    * 获得处罚决定书编号
    * @return CFJDSBH
    */
    public String getCfjdsbh() {
        return this.cfjdsbh;
    }

    /**
    * 设置处罚决定书编号
    * @param cfjdsbh
    */
    public void setCfjdsbh(String cfjdsbh) {
        this.cfjdsbh = cfjdsbh;
    }

    /**
    * 获得处罚决定书名称
    * @return CFJDSMC
    */
    public String getCfjdsmc() {
        return this.cfjdsmc;
    }

    /**
    * 设置处罚决定书名称
    * @param cfjdsmc
    */
    public void setCfjdsmc(String cfjdsmc) {
        this.cfjdsmc = cfjdsmc;
    }

    /**
    * 获得申请复议日期
    * @return SQFYRQ
    */
    public String getSqfyrq() {
        return this.sqfyrq;
    }

    /**
    * 设置申请复议日期
    * @param sqfyrq
    */
    public void setSqfyrq(String sqfyrq) {
        this.sqfyrq = sqfyrq;
    }

    /**
    * 获得申请人申请内容
    * @return SQRSQNR
    */
    public String getSqrsqnr() {
        return this.sqrsqnr;
    }

    /**
    * 设置申请人申请内容
    * @param sqrsqnr
    */
    public void setSqrsqnr(String sqrsqnr) {
        this.sqrsqnr = sqrsqnr;
    }

    /**
    * 获得被申请人
    * @return BSQRCS
    */
    public String getBsqrcs() {
        return this.bsqrcs;
    }

    /**
    * 设置被申请人
    * @param bsqrcs
    */
    public void setBsqrcs(String bsqrcs) {
        this.bsqrcs = bsqrcs;
    }

    /**
    * 获得第三人称
    * @return DSRCCS
    */
    public String getDsrccs() {
        return this.dsrccs;
    }

    /**
    * 设置第三人称
    * @param dsrccs
    */
    public void setDsrccs(String dsrccs) {
        this.dsrccs = dsrccs;
    }

    /**
    * 获得调查情况
    * @return DCQK
    */
    public String getDcqk() {
        return this.dcqk;
    }

    /**
    * 设置调查情况
    * @param dcqk
    */
    public void setDcqk(String dcqk) {
        this.dcqk = dcqk;
    }

    /**
    * 获得事实依据
    * @return SSYJ
    */
    public String getSsyj() {
        return this.ssyj;
    }

    /**
    * 设置事实依据
    * @param ssyj
    */
    public void setSsyj(String ssyj) {
        this.ssyj = ssyj;
    }

    /**
    * 获得法律依据
    * @return FLYJ
    */
    public String getFlyj() {
        return this.flyj;
    }

    /**
    * 设置法律依据
    * @param flyj
    */
    public void setFlyj(String flyj) {
        this.flyj = flyj;
    }

    /**
    * 获得决定内容
    * @return JDNR
    */
    public String getJdnr() {
        return this.jdnr;
    }

    /**
    * 设置决定内容
    * @param jdnr
    */
    public void setJdnr(String jdnr) {
        this.jdnr = jdnr;
    }

    /**
    * 获得决定单位
    * @return JDDW
    */
    public String getJddw() {
        return this.jddw;
    }

    /**
    * 设置决定单位
    * @param jddw
    */
    public void setJddw(String jddw) {
        this.jddw = jddw;
    }

    /**
    * 获得决定日期
    * @return JDRQ
    */
    public String getJdrq() {
        return this.jdrq;
    }

    /**
    * 设置决定日期
    * @param jdrq
    */
    public void setJdrq(String jdrq) {
        this.jdrq = jdrq;
    }

    /**
    * 获得接收时间
    * @return JSRQ
    */
    public String getJsrq() {
        return this.jsrq;
    }

    /**
    * 设置接收时间
    * @param jsrq
    */
    public void setJsrq(String jsrq) {
        this.jsrq = jsrq;
    }

    /**
    * 获得行政复议信息
    * @return XZFYXX
    */
    public String getXzfyxx() {
        return this.xzfyxx;
    }

    /**
    * 设置行政复议信息
    * @param xzfyxx
    */
    public void setXzfyxx(String xzfyxx) {
        this.xzfyxx = xzfyxx;
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
    * 获得复议法律文书号
    * @return FYFLWSH
    */
    public String getFyflwsh() {
        return this.fyflwsh;
    }

    /**
    * 设置复议法律文书号
    * @param fyflwsh
    */
    public void setFyflwsh(String fyflwsh) {
        this.fyflwsh = fyflwsh;
    }

    /**
    * 获得诉讼单位
    * @return SSDW
    */
    public String getSsdw() {
        return this.ssdw;
    }

    /**
    * 设置诉讼单位
    * @param ssdw
    */
    public void setSsdw(String ssdw) {
        this.ssdw = ssdw;
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
    * 获得数据添加时间
    * @return ADD_TIME
    */
    public java.util.Date getAddTime() {
        return this.addTime;
    }

    /**
    * 设置数据添加时间
    * @param addTime
    */
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }


}
