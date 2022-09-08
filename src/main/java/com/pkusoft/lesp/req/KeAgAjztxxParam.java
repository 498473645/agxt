package com.pkusoft.lesp.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.Page;


import javax.persistence.*;

/**
 * @author
 * @title: KeAgAjztxx
 */
@ApiModel("案管-案件状态信息表")
@Table(name = "KE_AG_AJZTXX")
public class KeAgAjztxxParam extends Page {

 	/**
     * 案件编号。ETL(Insert)
     */
    @Id
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号。ETL(Insert)")
    private String ajbh;

 	/**
     * 案件名称。ETL(Insert/Update)
     */
    @Column(name = "AJMC")
    @ApiModelProperty(value = "案件名称。ETL(Insert/Update)")
    private String ajmc;

 	/**
     * 案件名称拼音简码。ETL(Insert/Update)
     */
    @Column(name = "AJMC_PYM")
    @ApiModelProperty(value = "案件名称拼音简码。ETL(Insert/Update)")
    private String ajmcPym;

 	/**
     * 案件类别。ETL(Insert/Update)。刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
     */
    @Column(name = "AJLB")
    @ApiModelProperty(value = "案件类别。ETL(Insert/Update)。刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）")
    private String ajlb;

 	/**
     * 受理时间。ETL(Insert/Update)
     */
    @Column(name = "SLSJ")
    @ApiModelProperty(value = "受理时间。ETL(Insert/Update)")
    private java.util.Date slsj;

 	/**
     * 办案单位编码。ETL(Insert)
     */
    @Column(name = "BADW_BM")
    @ApiModelProperty(value = "办案单位编码。ETL(Insert)")
    private String badwBm;

 	/**
     * 办案单位名称。ETL(Insert)
     */
    @Column(name = "BADW_MC")
    @ApiModelProperty(value = "办案单位名称。ETL(Insert)")
    private String badwMc;

 	/**
     * 主办人身份证号。ETL(Insert)
     */
    @Column(name = "ZBR_SFZHM")
    @ApiModelProperty(value = "主办人身份证号。ETL(Insert)")
    private String zbrSfzhm;

 	/**
     * 主办人警号。ETL(Insert)
     */
    @Column(name = "ZBR_JH")
    @ApiModelProperty(value = "主办人警号。ETL(Insert)")
    private String zbrJh;

 	/**
     * 主办人姓名。ETL(Insert)
     */
    @Column(name = "ZBR_XM")
    @ApiModelProperty(value = "主办人姓名。ETL(Insert)")
    private String zbrXm;

 	/**
     * 主办人姓名拼音简码。ETL(Insert)
     */
    @Column(name = "ZBR_XM_PYM")
    @ApiModelProperty(value = "主办人姓名拼音简码。ETL(Insert)")
    private String zbrXmPym;

 	/**
     * 罪名编号。ETL(Insert/Update)
     */
    @Column(name = "ZM_BH")
    @ApiModelProperty(value = "罪名编号。ETL(Insert/Update)")
    private String zmBh;

 	/**
     * 罪名名称。ETL(Insert/Update)
     */
    @Column(name = "ZM_MC")
    @ApiModelProperty(value = "罪名名称。ETL(Insert/Update)")
    private String zmMc;

 	/**
     * 案件数据状态（0：正常，1：案件已删除）。ETL(Insert/Update)
     */
    @Column(name = "AJ_SJZT")
    @ApiModelProperty(value = "案件数据状态（0：正常，1：案件已删除）。ETL(Insert/Update)")
    private String ajSjzt;

 	/**
     * 案卷的当前状态(同AGXT.FILE_INFO表的STATUS字段)
     */
    @Column(name = "AG_SJZT")
    @ApiModelProperty(value = "案卷的当前状态(同AGXT.FILE_INFO表的STATUS字段)")
    private String agSjzt;

 	/**
     * 数据归属市局编号。ETL(Insert)
     */
    @Column(name = "CSTATIONID")
    @ApiModelProperty(value = "数据归属市局编号。ETL(Insert)")
    private String cstationid;

 	/**
     * 数据归属分局编号。ETL(Insert)
     */
    @Column(name = "SSTATIONID")
    @ApiModelProperty(value = "数据归属分局编号。ETL(Insert)")
    private String sstationid;

 	/**
     * 数据归属派出所编号。ETL(Insert)
     */
    @Column(name = "TSTATIONID")
    @ApiModelProperty(value = "数据归属派出所编号。ETL(Insert)")
    private String tstationid;

 	/**
     * 数据归属责任区编号
     */
    @Column(name = "RSTATIONID")
    @ApiModelProperty(value = "数据归属责任区编号")
    private String rstationid;

 	/**
     * 状态1。是否建卷（0：未建卷，1：已建卷）
     */
    @Column(name = "ZT1")
    @ApiModelProperty(value = "状态1。是否建卷（0：未建卷，1：已建卷）")
    private String zt1;

 	/**
     * 状态1的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT1_CZY_BH")
    @ApiModelProperty(value = "状态1的操作员编号，使用用户的身份证号/警号/ID")
    private String zt1CzyBh;

 	/**
     * 状态1的操作员姓名
     */
    @Column(name = "ZT1_CZY_XM")
    @ApiModelProperty(value = "状态1的操作员姓名")
    private String zt1CzyXm;

 	/**
     * 状态1的操作时间
     */
    @Column(name = "ZT1_CZSJ")
    @ApiModelProperty(value = "状态1的操作时间")
    private java.util.Date zt1Czsj;

 	/**
     * 状态2。是否扫描采集（0：未采集，1：已采集）
     */
    @Column(name = "ZT2")
    @ApiModelProperty(value = "状态2。是否扫描采集（0：未采集，1：已采集）")
    private String zt2;

 	/**
     * 状态2的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT2_CZY_BH")
    @ApiModelProperty(value = "状态2的操作员编号，使用用户的身份证号/警号/ID")
    private String zt2CzyBh;

 	/**
     * 状态2的操作员姓名
     */
    @Column(name = "ZT2_CZY_XM")
    @ApiModelProperty(value = "状态2的操作员姓名")
    private String zt2CzyXm;

 	/**
     * 状态2的操作时间
     */
    @Column(name = "ZT2_CZSJ")
    @ApiModelProperty(value = "状态2的操作时间")
    private java.util.Date zt2Czsj;

 	/**
     * 状态3。是否入柜（0：未入柜，1：已入柜）
     */
    @Column(name = "ZT3")
    @ApiModelProperty(value = "状态3。是否入柜（0：未入柜，1：已入柜）")
    private String zt3;

 	/**
     * 状态3的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT3_CZY_BH")
    @ApiModelProperty(value = "状态3的操作员编号，使用用户的身份证号/警号/ID")
    private String zt3CzyBh;

 	/**
     * 状态3的操作员姓名
     */
    @Column(name = "ZT3_CZY_XM")
    @ApiModelProperty(value = "状态3的操作员姓名")
    private String zt3CzyXm;

 	/**
     * 状态3的操作时间
     */
    @Column(name = "ZT3_CZSJ")
    @ApiModelProperty(value = "状态3的操作时间")
    private java.util.Date zt3Czsj;

 	/**
     * 状态4。是否发起鉴定（0：未发起，1：已发起）
     */
    @Column(name = "ZT4")
    @ApiModelProperty(value = "状态4。是否发起鉴定（0：未发起，1：已发起）")
    private String zt4;

 	/**
     * 状态4的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT4_CZY_BH")
    @ApiModelProperty(value = "状态4的操作员编号，使用用户的身份证号/警号/ID")
    private String zt4CzyBh;

 	/**
     * 状态4的操作员姓名
     */
    @Column(name = "ZT4_CZY_XM")
    @ApiModelProperty(value = "状态4的操作员姓名")
    private String zt4CzyXm;

 	/**
     * 状态4的操作时间
     */
    @Column(name = "ZT4_CZSJ")
    @ApiModelProperty(value = "状态4的操作时间")
    private java.util.Date zt4Czsj;

 	/**
     * 状态5。是否作废（0：未作废，1：已作废）
     */
    @Column(name = "ZT5")
    @ApiModelProperty(value = "状态5。是否作废（0：未作废，1：已作废）")
    private String zt5;

 	/**
     * 状态5的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT5_CZY_BH")
    @ApiModelProperty(value = "状态5的操作员编号，使用用户的身份证号/警号/ID")
    private String zt5CzyBh;

 	/**
     * 状态5的操作员姓名
     */
    @Column(name = "ZT5_CZY_XM")
    @ApiModelProperty(value = "状态5的操作员姓名")
    private String zt5CzyXm;

 	/**
     * 状态5的操作时间
     */
    @Column(name = "ZT5_CZSJ")
    @ApiModelProperty(value = "状态5的操作时间")
    private java.util.Date zt5Czsj;

 	/**
     * 嫌疑人姓名
     */
    @Column(name = "SARYXM")
    @ApiModelProperty(value = "嫌疑人姓名")
    private String saryxm;

 	/**
     * 嫌疑人姓名拼音码
     */
    @Column(name = "SARYXMPYM")
    @ApiModelProperty(value = "嫌疑人姓名拼音码")
    private String saryxmpym;

 	/**
     * 接警编号
     */
    @Column(name = "JJBH")
    @ApiModelProperty(value = "接警编号")
    private String jjbh;

 	/**
     * 状态6。是否归档（0：未归档，1：已归档）
     */
    @Column(name = "ZT6")
    @ApiModelProperty(value = "状态6。是否归档（0：未归档，1：已归档）")
    private String zt6;

 	/**
     * 状态6的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT6_CZY_BH")
    @ApiModelProperty(value = "状态6的操作员编号，使用用户的身份证号/警号/ID")
    private String zt6CzyBh;

 	/**
     * 状态6的操作员姓名
     */
    @Column(name = "ZT6_CZY_XM")
    @ApiModelProperty(value = "状态6的操作员姓名")
    private String zt6CzyXm;

 	/**
     * 状态6的操作时间
     */
    @Column(name = "ZT6_CZSJ")
    @ApiModelProperty(value = "状态6的操作时间")
    private java.util.Date zt6Czsj;

 	/**
     * 状态7。是否撤销归档（0：未撤销，1：已撤销）
     */
    @Column(name = "ZT7")
    @ApiModelProperty(value = "状态7。是否撤销归档（0：未撤销，1：已撤销）")
    private String zt7;

 	/**
     * 状态7的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT7_CZY_BH")
    @ApiModelProperty(value = "状态7的操作员编号，使用用户的身份证号/警号/ID")
    private String zt7CzyBh;

 	/**
     * 状态7的操作员姓名
     */
    @Column(name = "ZT7_CZY_XM")
    @ApiModelProperty(value = "状态7的操作员姓名")
    private String zt7CzyXm;

 	/**
     * 状态7的操作时间
     */
    @Column(name = "ZT7_CZSJ")
    @ApiModelProperty(value = "状态7的操作时间")
    private java.util.Date zt7Czsj;

 	/**
     * 状态8
     */
    @Column(name = "ZT8")
    @ApiModelProperty(value = "状态8")
    private String zt8;

 	/**
     * 状态8的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT8_CZY_BH")
    @ApiModelProperty(value = "状态8的操作员编号，使用用户的身份证号/警号/ID")
    private String zt8CzyBh;

 	/**
     * 状态8的操作员姓名
     */
    @Column(name = "ZT8_CZY_XM")
    @ApiModelProperty(value = "状态8的操作员姓名")
    private String zt8CzyXm;

 	/**
     * 状态8的操作时间
     */
    @Column(name = "ZT8_CZSJ")
    @ApiModelProperty(value = "状态8的操作时间")
    private java.util.Date zt8Czsj;

 	/**
     * 状态9
     */
    @Column(name = "ZT9")
    @ApiModelProperty(value = "状态9")
    private String zt9;

 	/**
     * 状态9的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT9_CZY_BH")
    @ApiModelProperty(value = "状态9的操作员编号，使用用户的身份证号/警号/ID")
    private String zt9CzyBh;

 	/**
     * 状态9的操作员姓名
     */
    @Column(name = "ZT9_CZY_XM")
    @ApiModelProperty(value = "状态9的操作员姓名")
    private String zt9CzyXm;

 	/**
     * 状态9的操作时间
     */
    @Column(name = "ZT9_CZSJ")
    @ApiModelProperty(value = "状态9的操作时间")
    private java.util.Date zt9Czsj;

 	/**
     * 状态10
     */
    @Column(name = "ZT10")
    @ApiModelProperty(value = "状态10")
    private String zt10;

 	/**
     * 状态10的操作员编号，使用用户的身份证号/警号/ID
     */
    @Column(name = "ZT10_CZY_BH")
    @ApiModelProperty(value = "状态10的操作员编号，使用用户的身份证号/警号/ID")
    private String zt10CzyBh;

 	/**
     * 状态10的操作员姓名
     */
    @Column(name = "ZT10_CZY_XM")
    @ApiModelProperty(value = "状态10的操作员姓名")
    private String zt10CzyXm;

 	/**
     * 状态10的操作时间
     */
    @Column(name = "ZT10_CZSJ")
    @ApiModelProperty(value = "状态10的操作时间")
    private java.util.Date zt10Czsj;


    /**
    * 获得案件编号。ETL(Insert)
    * @return AJBH
    */
    public String getAjbh() {
        return this.ajbh;
    }

    /**
    * 设置案件编号。ETL(Insert)
    * @param ajbh
    */
    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    /**
    * 获得案件名称。ETL(Insert/Update)
    * @return AJMC
    */
    public String getAjmc() {
        return this.ajmc;
    }

    /**
    * 设置案件名称。ETL(Insert/Update)
    * @param ajmc
    */
    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    /**
    * 获得案件名称拼音简码。ETL(Insert/Update)
    * @return AJMC_PYM
    */
    public String getAjmcPym() {
        return this.ajmcPym;
    }

    /**
    * 设置案件名称拼音简码。ETL(Insert/Update)
    * @param ajmcPym
    */
    public void setAjmcPym(String ajmcPym) {
        this.ajmcPym = ajmcPym;
    }

    /**
    * 获得案件类别。ETL(Insert/Update)。刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
    * @return AJLB
    */
    public String getAjlb() {
        return this.ajlb;
    }

    /**
    * 设置案件类别。ETL(Insert/Update)。刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
    * @param ajlb
    */
    public void setAjlb(String ajlb) {
        this.ajlb = ajlb;
    }

    /**
    * 获得受理时间。ETL(Insert/Update)
    * @return SLSJ
    */
    public java.util.Date getSlsj() {
        return this.slsj;
    }

    /**
    * 设置受理时间。ETL(Insert/Update)
    * @param slsj
    */
    public void setSlsj(java.util.Date slsj) {
        this.slsj = slsj;
    }

    /**
    * 获得办案单位编码。ETL(Insert)
    * @return BADW_BM
    */
    public String getBadwBm() {
        return this.badwBm;
    }

    /**
    * 设置办案单位编码。ETL(Insert)
    * @param badwBm
    */
    public void setBadwBm(String badwBm) {
        this.badwBm = badwBm;
    }

    /**
    * 获得办案单位名称。ETL(Insert)
    * @return BADW_MC
    */
    public String getBadwMc() {
        return this.badwMc;
    }

    /**
    * 设置办案单位名称。ETL(Insert)
    * @param badwMc
    */
    public void setBadwMc(String badwMc) {
        this.badwMc = badwMc;
    }

    /**
    * 获得主办人身份证号。ETL(Insert)
    * @return ZBR_SFZHM
    */
    public String getZbrSfzhm() {
        return this.zbrSfzhm;
    }

    /**
    * 设置主办人身份证号。ETL(Insert)
    * @param zbrSfzhm
    */
    public void setZbrSfzhm(String zbrSfzhm) {
        this.zbrSfzhm = zbrSfzhm;
    }

    /**
    * 获得主办人警号。ETL(Insert)
    * @return ZBR_JH
    */
    public String getZbrJh() {
        return this.zbrJh;
    }

    /**
    * 设置主办人警号。ETL(Insert)
    * @param zbrJh
    */
    public void setZbrJh(String zbrJh) {
        this.zbrJh = zbrJh;
    }

    /**
    * 获得主办人姓名。ETL(Insert)
    * @return ZBR_XM
    */
    public String getZbrXm() {
        return this.zbrXm;
    }

    /**
    * 设置主办人姓名。ETL(Insert)
    * @param zbrXm
    */
    public void setZbrXm(String zbrXm) {
        this.zbrXm = zbrXm;
    }

    /**
    * 获得主办人姓名拼音简码。ETL(Insert)
    * @return ZBR_XM_PYM
    */
    public String getZbrXmPym() {
        return this.zbrXmPym;
    }

    /**
    * 设置主办人姓名拼音简码。ETL(Insert)
    * @param zbrXmPym
    */
    public void setZbrXmPym(String zbrXmPym) {
        this.zbrXmPym = zbrXmPym;
    }

    /**
    * 获得罪名编号。ETL(Insert/Update)
    * @return ZM_BH
    */
    public String getZmBh() {
        return this.zmBh;
    }

    /**
    * 设置罪名编号。ETL(Insert/Update)
    * @param zmBh
    */
    public void setZmBh(String zmBh) {
        this.zmBh = zmBh;
    }

    /**
    * 获得罪名名称。ETL(Insert/Update)
    * @return ZM_MC
    */
    public String getZmMc() {
        return this.zmMc;
    }

    /**
    * 设置罪名名称。ETL(Insert/Update)
    * @param zmMc
    */
    public void setZmMc(String zmMc) {
        this.zmMc = zmMc;
    }

    /**
    * 获得案件数据状态（0：正常，1：案件已删除）。ETL(Insert/Update)
    * @return AJ_SJZT
    */
    public String getAjSjzt() {
        return this.ajSjzt;
    }

    /**
    * 设置案件数据状态（0：正常，1：案件已删除）。ETL(Insert/Update)
    * @param ajSjzt
    */
    public void setAjSjzt(String ajSjzt) {
        this.ajSjzt = ajSjzt;
    }

    /**
    * 获得案卷的当前状态(同AGXT.FILE_INFO表的STATUS字段)
    * @return AG_SJZT
    */
    public String getAgSjzt() {
        return this.agSjzt;
    }

    /**
    * 设置案卷的当前状态(同AGXT.FILE_INFO表的STATUS字段)
    * @param agSjzt
    */
    public void setAgSjzt(String agSjzt) {
        this.agSjzt = agSjzt;
    }

    /**
    * 获得数据归属市局编号。ETL(Insert)
    * @return CSTATIONID
    */
    public String getCstationid() {
        return this.cstationid;
    }

    /**
    * 设置数据归属市局编号。ETL(Insert)
    * @param cstationid
    */
    public void setCstationid(String cstationid) {
        this.cstationid = cstationid;
    }

    /**
    * 获得数据归属分局编号。ETL(Insert)
    * @return SSTATIONID
    */
    public String getSstationid() {
        return this.sstationid;
    }

    /**
    * 设置数据归属分局编号。ETL(Insert)
    * @param sstationid
    */
    public void setSstationid(String sstationid) {
        this.sstationid = sstationid;
    }

    /**
    * 获得数据归属派出所编号。ETL(Insert)
    * @return TSTATIONID
    */
    public String getTstationid() {
        return this.tstationid;
    }

    /**
    * 设置数据归属派出所编号。ETL(Insert)
    * @param tstationid
    */
    public void setTstationid(String tstationid) {
        this.tstationid = tstationid;
    }

    /**
    * 获得数据归属责任区编号
    * @return RSTATIONID
    */
    public String getRstationid() {
        return this.rstationid;
    }

    /**
    * 设置数据归属责任区编号
    * @param rstationid
    */
    public void setRstationid(String rstationid) {
        this.rstationid = rstationid;
    }

    /**
    * 获得状态1。是否建卷（0：未建卷，1：已建卷）
    * @return ZT1
    */
    public String getZt1() {
        return this.zt1;
    }

    /**
    * 设置状态1。是否建卷（0：未建卷，1：已建卷）
    * @param zt1
    */
    public void setZt1(String zt1) {
        this.zt1 = zt1;
    }

    /**
    * 获得状态1的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT1_CZY_BH
    */
    public String getZt1CzyBh() {
        return this.zt1CzyBh;
    }

    /**
    * 设置状态1的操作员编号，使用用户的身份证号/警号/ID
    * @param zt1CzyBh
    */
    public void setZt1CzyBh(String zt1CzyBh) {
        this.zt1CzyBh = zt1CzyBh;
    }

    /**
    * 获得状态1的操作员姓名
    * @return ZT1_CZY_XM
    */
    public String getZt1CzyXm() {
        return this.zt1CzyXm;
    }

    /**
    * 设置状态1的操作员姓名
    * @param zt1CzyXm
    */
    public void setZt1CzyXm(String zt1CzyXm) {
        this.zt1CzyXm = zt1CzyXm;
    }

    /**
    * 获得状态1的操作时间
    * @return ZT1_CZSJ
    */
    public java.util.Date getZt1Czsj() {
        return this.zt1Czsj;
    }

    /**
    * 设置状态1的操作时间
    * @param zt1Czsj
    */
    public void setZt1Czsj(java.util.Date zt1Czsj) {
        this.zt1Czsj = zt1Czsj;
    }

    /**
    * 获得状态2。是否扫描采集（0：未采集，1：已采集）
    * @return ZT2
    */
    public String getZt2() {
        return this.zt2;
    }

    /**
    * 设置状态2。是否扫描采集（0：未采集，1：已采集）
    * @param zt2
    */
    public void setZt2(String zt2) {
        this.zt2 = zt2;
    }

    /**
    * 获得状态2的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT2_CZY_BH
    */
    public String getZt2CzyBh() {
        return this.zt2CzyBh;
    }

    /**
    * 设置状态2的操作员编号，使用用户的身份证号/警号/ID
    * @param zt2CzyBh
    */
    public void setZt2CzyBh(String zt2CzyBh) {
        this.zt2CzyBh = zt2CzyBh;
    }

    /**
    * 获得状态2的操作员姓名
    * @return ZT2_CZY_XM
    */
    public String getZt2CzyXm() {
        return this.zt2CzyXm;
    }

    /**
    * 设置状态2的操作员姓名
    * @param zt2CzyXm
    */
    public void setZt2CzyXm(String zt2CzyXm) {
        this.zt2CzyXm = zt2CzyXm;
    }

    /**
    * 获得状态2的操作时间
    * @return ZT2_CZSJ
    */
    public java.util.Date getZt2Czsj() {
        return this.zt2Czsj;
    }

    /**
    * 设置状态2的操作时间
    * @param zt2Czsj
    */
    public void setZt2Czsj(java.util.Date zt2Czsj) {
        this.zt2Czsj = zt2Czsj;
    }

    /**
    * 获得状态3。是否入柜（0：未入柜，1：已入柜）
    * @return ZT3
    */
    public String getZt3() {
        return this.zt3;
    }

    /**
    * 设置状态3。是否入柜（0：未入柜，1：已入柜）
    * @param zt3
    */
    public void setZt3(String zt3) {
        this.zt3 = zt3;
    }

    /**
    * 获得状态3的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT3_CZY_BH
    */
    public String getZt3CzyBh() {
        return this.zt3CzyBh;
    }

    /**
    * 设置状态3的操作员编号，使用用户的身份证号/警号/ID
    * @param zt3CzyBh
    */
    public void setZt3CzyBh(String zt3CzyBh) {
        this.zt3CzyBh = zt3CzyBh;
    }

    /**
    * 获得状态3的操作员姓名
    * @return ZT3_CZY_XM
    */
    public String getZt3CzyXm() {
        return this.zt3CzyXm;
    }

    /**
    * 设置状态3的操作员姓名
    * @param zt3CzyXm
    */
    public void setZt3CzyXm(String zt3CzyXm) {
        this.zt3CzyXm = zt3CzyXm;
    }

    /**
    * 获得状态3的操作时间
    * @return ZT3_CZSJ
    */
    public java.util.Date getZt3Czsj() {
        return this.zt3Czsj;
    }

    /**
    * 设置状态3的操作时间
    * @param zt3Czsj
    */
    public void setZt3Czsj(java.util.Date zt3Czsj) {
        this.zt3Czsj = zt3Czsj;
    }

    /**
    * 获得状态4。是否发起鉴定（0：未发起，1：已发起）
    * @return ZT4
    */
    public String getZt4() {
        return this.zt4;
    }

    /**
    * 设置状态4。是否发起鉴定（0：未发起，1：已发起）
    * @param zt4
    */
    public void setZt4(String zt4) {
        this.zt4 = zt4;
    }

    /**
    * 获得状态4的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT4_CZY_BH
    */
    public String getZt4CzyBh() {
        return this.zt4CzyBh;
    }

    /**
    * 设置状态4的操作员编号，使用用户的身份证号/警号/ID
    * @param zt4CzyBh
    */
    public void setZt4CzyBh(String zt4CzyBh) {
        this.zt4CzyBh = zt4CzyBh;
    }

    /**
    * 获得状态4的操作员姓名
    * @return ZT4_CZY_XM
    */
    public String getZt4CzyXm() {
        return this.zt4CzyXm;
    }

    /**
    * 设置状态4的操作员姓名
    * @param zt4CzyXm
    */
    public void setZt4CzyXm(String zt4CzyXm) {
        this.zt4CzyXm = zt4CzyXm;
    }

    /**
    * 获得状态4的操作时间
    * @return ZT4_CZSJ
    */
    public java.util.Date getZt4Czsj() {
        return this.zt4Czsj;
    }

    /**
    * 设置状态4的操作时间
    * @param zt4Czsj
    */
    public void setZt4Czsj(java.util.Date zt4Czsj) {
        this.zt4Czsj = zt4Czsj;
    }

    /**
    * 获得状态5。是否作废（0：未作废，1：已作废）
    * @return ZT5
    */
    public String getZt5() {
        return this.zt5;
    }

    /**
    * 设置状态5。是否作废（0：未作废，1：已作废）
    * @param zt5
    */
    public void setZt5(String zt5) {
        this.zt5 = zt5;
    }

    /**
    * 获得状态5的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT5_CZY_BH
    */
    public String getZt5CzyBh() {
        return this.zt5CzyBh;
    }

    /**
    * 设置状态5的操作员编号，使用用户的身份证号/警号/ID
    * @param zt5CzyBh
    */
    public void setZt5CzyBh(String zt5CzyBh) {
        this.zt5CzyBh = zt5CzyBh;
    }

    /**
    * 获得状态5的操作员姓名
    * @return ZT5_CZY_XM
    */
    public String getZt5CzyXm() {
        return this.zt5CzyXm;
    }

    /**
    * 设置状态5的操作员姓名
    * @param zt5CzyXm
    */
    public void setZt5CzyXm(String zt5CzyXm) {
        this.zt5CzyXm = zt5CzyXm;
    }

    /**
    * 获得状态5的操作时间
    * @return ZT5_CZSJ
    */
    public java.util.Date getZt5Czsj() {
        return this.zt5Czsj;
    }

    /**
    * 设置状态5的操作时间
    * @param zt5Czsj
    */
    public void setZt5Czsj(java.util.Date zt5Czsj) {
        this.zt5Czsj = zt5Czsj;
    }

    /**
    * 获得嫌疑人姓名
    * @return SARYXM
    */
    public String getSaryxm() {
        return this.saryxm;
    }

    /**
    * 设置嫌疑人姓名
    * @param saryxm
    */
    public void setSaryxm(String saryxm) {
        this.saryxm = saryxm;
    }

    /**
    * 获得嫌疑人姓名拼音码
    * @return SARYXMPYM
    */
    public String getSaryxmpym() {
        return this.saryxmpym;
    }

    /**
    * 设置嫌疑人姓名拼音码
    * @param saryxmpym
    */
    public void setSaryxmpym(String saryxmpym) {
        this.saryxmpym = saryxmpym;
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
    * 获得状态6。是否归档（0：未归档，1：已归档）
    * @return ZT6
    */
    public String getZt6() {
        return this.zt6;
    }

    /**
    * 设置状态6。是否归档（0：未归档，1：已归档）
    * @param zt6
    */
    public void setZt6(String zt6) {
        this.zt6 = zt6;
    }

    /**
    * 获得状态6的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT6_CZY_BH
    */
    public String getZt6CzyBh() {
        return this.zt6CzyBh;
    }

    /**
    * 设置状态6的操作员编号，使用用户的身份证号/警号/ID
    * @param zt6CzyBh
    */
    public void setZt6CzyBh(String zt6CzyBh) {
        this.zt6CzyBh = zt6CzyBh;
    }

    /**
    * 获得状态6的操作员姓名
    * @return ZT6_CZY_XM
    */
    public String getZt6CzyXm() {
        return this.zt6CzyXm;
    }

    /**
    * 设置状态6的操作员姓名
    * @param zt6CzyXm
    */
    public void setZt6CzyXm(String zt6CzyXm) {
        this.zt6CzyXm = zt6CzyXm;
    }

    /**
    * 获得状态6的操作时间
    * @return ZT6_CZSJ
    */
    public java.util.Date getZt6Czsj() {
        return this.zt6Czsj;
    }

    /**
    * 设置状态6的操作时间
    * @param zt6Czsj
    */
    public void setZt6Czsj(java.util.Date zt6Czsj) {
        this.zt6Czsj = zt6Czsj;
    }

    /**
    * 获得状态7。是否撤销归档（0：未撤销，1：已撤销）
    * @return ZT7
    */
    public String getZt7() {
        return this.zt7;
    }

    /**
    * 设置状态7。是否撤销归档（0：未撤销，1：已撤销）
    * @param zt7
    */
    public void setZt7(String zt7) {
        this.zt7 = zt7;
    }

    /**
    * 获得状态7的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT7_CZY_BH
    */
    public String getZt7CzyBh() {
        return this.zt7CzyBh;
    }

    /**
    * 设置状态7的操作员编号，使用用户的身份证号/警号/ID
    * @param zt7CzyBh
    */
    public void setZt7CzyBh(String zt7CzyBh) {
        this.zt7CzyBh = zt7CzyBh;
    }

    /**
    * 获得状态7的操作员姓名
    * @return ZT7_CZY_XM
    */
    public String getZt7CzyXm() {
        return this.zt7CzyXm;
    }

    /**
    * 设置状态7的操作员姓名
    * @param zt7CzyXm
    */
    public void setZt7CzyXm(String zt7CzyXm) {
        this.zt7CzyXm = zt7CzyXm;
    }

    /**
    * 获得状态7的操作时间
    * @return ZT7_CZSJ
    */
    public java.util.Date getZt7Czsj() {
        return this.zt7Czsj;
    }

    /**
    * 设置状态7的操作时间
    * @param zt7Czsj
    */
    public void setZt7Czsj(java.util.Date zt7Czsj) {
        this.zt7Czsj = zt7Czsj;
    }

    /**
    * 获得状态8
    * @return ZT8
    */
    public String getZt8() {
        return this.zt8;
    }

    /**
    * 设置状态8
    * @param zt8
    */
    public void setZt8(String zt8) {
        this.zt8 = zt8;
    }

    /**
    * 获得状态8的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT8_CZY_BH
    */
    public String getZt8CzyBh() {
        return this.zt8CzyBh;
    }

    /**
    * 设置状态8的操作员编号，使用用户的身份证号/警号/ID
    * @param zt8CzyBh
    */
    public void setZt8CzyBh(String zt8CzyBh) {
        this.zt8CzyBh = zt8CzyBh;
    }

    /**
    * 获得状态8的操作员姓名
    * @return ZT8_CZY_XM
    */
    public String getZt8CzyXm() {
        return this.zt8CzyXm;
    }

    /**
    * 设置状态8的操作员姓名
    * @param zt8CzyXm
    */
    public void setZt8CzyXm(String zt8CzyXm) {
        this.zt8CzyXm = zt8CzyXm;
    }

    /**
    * 获得状态8的操作时间
    * @return ZT8_CZSJ
    */
    public java.util.Date getZt8Czsj() {
        return this.zt8Czsj;
    }

    /**
    * 设置状态8的操作时间
    * @param zt8Czsj
    */
    public void setZt8Czsj(java.util.Date zt8Czsj) {
        this.zt8Czsj = zt8Czsj;
    }

    /**
    * 获得状态9
    * @return ZT9
    */
    public String getZt9() {
        return this.zt9;
    }

    /**
    * 设置状态9
    * @param zt9
    */
    public void setZt9(String zt9) {
        this.zt9 = zt9;
    }

    /**
    * 获得状态9的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT9_CZY_BH
    */
    public String getZt9CzyBh() {
        return this.zt9CzyBh;
    }

    /**
    * 设置状态9的操作员编号，使用用户的身份证号/警号/ID
    * @param zt9CzyBh
    */
    public void setZt9CzyBh(String zt9CzyBh) {
        this.zt9CzyBh = zt9CzyBh;
    }

    /**
    * 获得状态9的操作员姓名
    * @return ZT9_CZY_XM
    */
    public String getZt9CzyXm() {
        return this.zt9CzyXm;
    }

    /**
    * 设置状态9的操作员姓名
    * @param zt9CzyXm
    */
    public void setZt9CzyXm(String zt9CzyXm) {
        this.zt9CzyXm = zt9CzyXm;
    }

    /**
    * 获得状态9的操作时间
    * @return ZT9_CZSJ
    */
    public java.util.Date getZt9Czsj() {
        return this.zt9Czsj;
    }

    /**
    * 设置状态9的操作时间
    * @param zt9Czsj
    */
    public void setZt9Czsj(java.util.Date zt9Czsj) {
        this.zt9Czsj = zt9Czsj;
    }

    /**
    * 获得状态10
    * @return ZT10
    */
    public String getZt10() {
        return this.zt10;
    }

    /**
    * 设置状态10
    * @param zt10
    */
    public void setZt10(String zt10) {
        this.zt10 = zt10;
    }

    /**
    * 获得状态10的操作员编号，使用用户的身份证号/警号/ID
    * @return ZT10_CZY_BH
    */
    public String getZt10CzyBh() {
        return this.zt10CzyBh;
    }

    /**
    * 设置状态10的操作员编号，使用用户的身份证号/警号/ID
    * @param zt10CzyBh
    */
    public void setZt10CzyBh(String zt10CzyBh) {
        this.zt10CzyBh = zt10CzyBh;
    }

    /**
    * 获得状态10的操作员姓名
    * @return ZT10_CZY_XM
    */
    public String getZt10CzyXm() {
        return this.zt10CzyXm;
    }

    /**
    * 设置状态10的操作员姓名
    * @param zt10CzyXm
    */
    public void setZt10CzyXm(String zt10CzyXm) {
        this.zt10CzyXm = zt10CzyXm;
    }

    /**
    * 获得状态10的操作时间
    * @return ZT10_CZSJ
    */
    public java.util.Date getZt10Czsj() {
        return this.zt10Czsj;
    }

    /**
    * 设置状态10的操作时间
    * @param zt10Czsj
    */
    public void setZt10Czsj(java.util.Date zt10Czsj) {
        this.zt10Czsj = zt10Czsj;
    }


}
