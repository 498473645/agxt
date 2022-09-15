package com.pkusoft.lesp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: KeAjjbxx
 */
@ApiModel("案件基本信息")
@Table(name = "KE_AJJBXX")
public class KeAjjbxx {

 	/**
     * 案件编号
     */
    @Id
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
     * 抽取时间
     */
    @Column(name = "CQSJ")
    @ApiModelProperty(value = "抽取时间")
    private java.util.Date cqsj;

 	/**
     * 案件简要案情
     */
    @Column(name = "JYAQ")
    @ApiModelProperty(value = "案件简要案情")
    private String jyaq;

 	/**
     * 数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；04、交管办案平台；
     */
    @Column(name = "SJLY")
    @ApiModelProperty(value = "数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；04、交管办案平台；")
    private String sjly;

 	/**
     * 罪名编号
     */
    @Column(name = "ZM_BH")
    @ApiModelProperty(value = "罪名编号")
    private String zmBh;

 	/**
     * 罪名名称
     */
    @Column(name = "ZM_MC")
    @ApiModelProperty(value = "罪名名称")
    private String zmMc;

 	/**
     * 原始办案单位编码
     */
    @Column(name = "YS_BADW_BM")
    @ApiModelProperty(value = "原始办案单位编码")
    private String ysBadwBm;

 	/**
     * 原始办案单位名称
     */
    @Column(name = "YS_BADW_MC")
    @ApiModelProperty(value = "原始办案单位名称")
    private String ysBadwMc;

 	/**
     * 案件类别：刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
     */
    @Column(name = "AJLB")
    @ApiModelProperty(value = "案件类别：刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）")
    private String ajlb;

 	/**
     * 原始主办人姓名
     */
    @Column(name = "YS_ZBR_XM")
    @ApiModelProperty(value = "原始主办人姓名")
    private String ysZbrXm;

 	/**
     * 原始主办人身份证号
     */
    @Column(name = "YS_ZBR_SFZHM")
    @ApiModelProperty(value = "原始主办人身份证号")
    private String ysZbrSfzhm;

 	/**
     * 原始主办人
     */
    @Column(name = "YS_ZBR")
    @ApiModelProperty(value = "原始主办人")
    private String ysZbr;

 	/**
     * 原始协办人
     */
    @Column(name = "YS_XBR")
    @ApiModelProperty(value = "原始协办人")
    private String ysXbr;

 	/**
     * 原始协办人姓名
     */
    @Column(name = "YS_XBR_XM")
    @ApiModelProperty(value = "原始协办人姓名")
    private String ysXbrXm;

 	/**
     * 受理时间
     */
    @Column(name = "SLSJ")
    @ApiModelProperty(value = "受理时间")
    private java.util.Date slsj;

 	/**
     * 是否电子化 案卷(0: 未电子化, 1: 已电子化)
     */
    @Column(name = "ISDZH")
    @ApiModelProperty(value = "是否电子化 案卷(0: 未电子化, 1: 已电子化)")
    private String isdzh;

 	/**
     * 电子化案卷时间
     */
    @Column(name = "DZHSJ")
    @ApiModelProperty(value = "电子化案卷时间")
    private java.util.Date dzhsj;

 	/**
     * 案件名称拼音简码
     */
    @Column(name = "AJMC_PYM")
    @ApiModelProperty(value = "案件名称拼音简码")
    private String ajmcPym;

 	/**
     * 主办人姓名拼音简码
     */
    @Column(name = "ZBR_XM_PYM")
    @ApiModelProperty(value = "主办人姓名拼音简码")
    private String zbrXmPym;

 	/**
     * 数据状态：0、正常；1、已删除；
     */
    @Column(name = "SJZT")
    @ApiModelProperty(value = "数据状态：0、正常；1、已删除；")
    private String sjzt;

 	/**
     * 接警编号
     */
    @Column(name = "JJBH")
    @ApiModelProperty(value = "接警编号")
    private String jjbh;

 	/**
     * 登记时间
     */
    @Column(name = "DJSJ")
    @ApiModelProperty(value = "登记时间")
    private java.util.Date djsj;

 	/**
     * 案件状态
     */
    @Column(name = "AJZT")
    @ApiModelProperty(value = "案件状态")
    private String ajzt;

 	/**
     * 报案人姓名
     */
    @Column(name = "BARXM")
    @ApiModelProperty(value = "报案人姓名")
    private String barxm;

 	/**
     * 报案人联系方式
     */
    @Column(name = "BARLXFS")
    @ApiModelProperty(value = "报案人联系方式")
    private String barlxfs;

 	/**
     * 报案人证件号码
     */
    @Column(name = "BARZJHM")
    @ApiModelProperty(value = "报案人证件号码")
    private String barzjhm;

 	/**
     * 结案时间
     */
    @Column(name = "JASJ")
    @ApiModelProperty(value = "结案时间")
    private java.util.Date jasj;

 	/**
     * 案件修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "案件修改时间")
    private java.util.Date xgsj;


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
    * 获得抽取时间
    * @return CQSJ
    */
    public java.util.Date getCqsj() {
        return this.cqsj;
    }

    /**
    * 设置抽取时间
    * @param cqsj
    */
    public void setCqsj(java.util.Date cqsj) {
        this.cqsj = cqsj;
    }

    /**
    * 获得案件简要案情
    * @return JYAQ
    */
    public String getJyaq() {
        return this.jyaq;
    }

    /**
    * 设置案件简要案情
    * @param jyaq
    */
    public void setJyaq(String jyaq) {
        this.jyaq = jyaq;
    }

    /**
    * 获得数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；04、交管办案平台；
    * @return SJLY
    */
    public String getSjly() {
        return this.sjly;
    }

    /**
    * 设置数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；04、交管办案平台；
    * @param sjly
    */
    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    /**
    * 获得罪名编号
    * @return ZM_BH
    */
    public String getZmBh() {
        return this.zmBh;
    }

    /**
    * 设置罪名编号
    * @param zmBh
    */
    public void setZmBh(String zmBh) {
        this.zmBh = zmBh;
    }

    /**
    * 获得罪名名称
    * @return ZM_MC
    */
    public String getZmMc() {
        return this.zmMc;
    }

    /**
    * 设置罪名名称
    * @param zmMc
    */
    public void setZmMc(String zmMc) {
        this.zmMc = zmMc;
    }

    /**
    * 获得原始办案单位编码
    * @return YS_BADW_BM
    */
    public String getYsBadwBm() {
        return this.ysBadwBm;
    }

    /**
    * 设置原始办案单位编码
    * @param ysBadwBm
    */
    public void setYsBadwBm(String ysBadwBm) {
        this.ysBadwBm = ysBadwBm;
    }

    /**
    * 获得原始办案单位名称
    * @return YS_BADW_MC
    */
    public String getYsBadwMc() {
        return this.ysBadwMc;
    }

    /**
    * 设置原始办案单位名称
    * @param ysBadwMc
    */
    public void setYsBadwMc(String ysBadwMc) {
        this.ysBadwMc = ysBadwMc;
    }

    /**
    * 获得案件类别：刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
    * @return AJLB
    */
    public String getAjlb() {
        return this.ajlb;
    }

    /**
    * 设置案件类别：刑事案件（01，来自刑侦一体化的数据）、行政案件（02，来自警综的数据）、行政复议（03、来自执法监督平台行政复议系统）、行政诉讼（04、来自执法监督平台行政诉讼系统）、国家赔偿（05、来自执法监督平台国家赔偿系统）、其他（06、数据来源不明）
    * @param ajlb
    */
    public void setAjlb(String ajlb) {
        this.ajlb = ajlb;
    }

    /**
    * 获得原始主办人姓名
    * @return YS_ZBR_XM
    */
    public String getYsZbrXm() {
        return this.ysZbrXm;
    }

    /**
    * 设置原始主办人姓名
    * @param ysZbrXm
    */
    public void setYsZbrXm(String ysZbrXm) {
        this.ysZbrXm = ysZbrXm;
    }

    /**
    * 获得原始主办人身份证号
    * @return YS_ZBR_SFZHM
    */
    public String getYsZbrSfzhm() {
        return this.ysZbrSfzhm;
    }

    /**
    * 设置原始主办人身份证号
    * @param ysZbrSfzhm
    */
    public void setYsZbrSfzhm(String ysZbrSfzhm) {
        this.ysZbrSfzhm = ysZbrSfzhm;
    }

    /**
    * 获得原始主办人
    * @return YS_ZBR
    */
    public String getYsZbr() {
        return this.ysZbr;
    }

    /**
    * 设置原始主办人
    * @param ysZbr
    */
    public void setYsZbr(String ysZbr) {
        this.ysZbr = ysZbr;
    }

    /**
    * 获得原始协办人
    * @return YS_XBR
    */
    public String getYsXbr() {
        return this.ysXbr;
    }

    /**
    * 设置原始协办人
    * @param ysXbr
    */
    public void setYsXbr(String ysXbr) {
        this.ysXbr = ysXbr;
    }

    /**
    * 获得原始协办人姓名
    * @return YS_XBR_XM
    */
    public String getYsXbrXm() {
        return this.ysXbrXm;
    }

    /**
    * 设置原始协办人姓名
    * @param ysXbrXm
    */
    public void setYsXbrXm(String ysXbrXm) {
        this.ysXbrXm = ysXbrXm;
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
    * 获得是否电子化 案卷(0: 未电子化, 1: 已电子化)
    * @return ISDZH
    */
    public String getIsdzh() {
        return this.isdzh;
    }

    /**
    * 设置是否电子化 案卷(0: 未电子化, 1: 已电子化)
    * @param isdzh
    */
    public void setIsdzh(String isdzh) {
        this.isdzh = isdzh;
    }

    /**
    * 获得电子化案卷时间
    * @return DZHSJ
    */
    public java.util.Date getDzhsj() {
        return this.dzhsj;
    }

    /**
    * 设置电子化案卷时间
    * @param dzhsj
    */
    public void setDzhsj(java.util.Date dzhsj) {
        this.dzhsj = dzhsj;
    }

    /**
    * 获得案件名称拼音简码
    * @return AJMC_PYM
    */
    public String getAjmcPym() {
        return this.ajmcPym;
    }

    /**
    * 设置案件名称拼音简码
    * @param ajmcPym
    */
    public void setAjmcPym(String ajmcPym) {
        this.ajmcPym = ajmcPym;
    }

    /**
    * 获得主办人姓名拼音简码
    * @return ZBR_XM_PYM
    */
    public String getZbrXmPym() {
        return this.zbrXmPym;
    }

    /**
    * 设置主办人姓名拼音简码
    * @param zbrXmPym
    */
    public void setZbrXmPym(String zbrXmPym) {
        this.zbrXmPym = zbrXmPym;
    }

    /**
    * 获得数据状态：0、正常；1、已删除；
    * @return SJZT
    */
    public String getSjzt() {
        return this.sjzt;
    }

    /**
    * 设置数据状态：0、正常；1、已删除；
    * @param sjzt
    */
    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
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
    * 获得登记时间
    * @return DJSJ
    */
    public java.util.Date getDjsj() {
        return this.djsj;
    }

    /**
    * 设置登记时间
    * @param djsj
    */
    public void setDjsj(java.util.Date djsj) {
        this.djsj = djsj;
    }

    /**
    * 获得案件状态
    * @return AJZT
    */
    public String getAjzt() {
        return this.ajzt;
    }

    /**
    * 设置案件状态
    * @param ajzt
    */
    public void setAjzt(String ajzt) {
        this.ajzt = ajzt;
    }

    /**
    * 获得报案人姓名
    * @return BARXM
    */
    public String getBarxm() {
        return this.barxm;
    }

    /**
    * 设置报案人姓名
    * @param barxm
    */
    public void setBarxm(String barxm) {
        this.barxm = barxm;
    }

    /**
    * 获得报案人联系方式
    * @return BARLXFS
    */
    public String getBarlxfs() {
        return this.barlxfs;
    }

    /**
    * 设置报案人联系方式
    * @param barlxfs
    */
    public void setBarlxfs(String barlxfs) {
        this.barlxfs = barlxfs;
    }

    /**
    * 获得报案人证件号码
    * @return BARZJHM
    */
    public String getBarzjhm() {
        return this.barzjhm;
    }

    /**
    * 设置报案人证件号码
    * @param barzjhm
    */
    public void setBarzjhm(String barzjhm) {
        this.barzjhm = barzjhm;
    }

    /**
    * 获得结案时间
    * @return JASJ
    */
    public java.util.Date getJasj() {
        return this.jasj;
    }

    /**
    * 设置结案时间
    * @param jasj
    */
    public void setJasj(java.util.Date jasj) {
        this.jasj = jasj;
    }

    /**
    * 获得案件修改时间
    * @return XGSJ
    */
    public java.util.Date getXgsj() {
        return this.xgsj;
    }

    /**
    * 设置案件修改时间
    * @param xgsj
    */
    public void setXgsj(java.util.Date xgsj) {
        this.xgsj = xgsj;
    }


}
