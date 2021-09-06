package com.pkusoft.lespke2.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author 
 * @title: KeAjxx 
 */
@ApiModel("案件信息（201912版）")
@Table(name = "KE_AJXX")
public class KeAjxx {

 	/**
     * 案件编号（案件信息的外键）
     */
    @Id
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号（案件信息的外键）")
    private String ajbh; 

 	/**
     * 接警编号（110接警信息和接警信息的外键）
     */
    @Column(name = "JJBH")
    @ApiModelProperty(value = "接警编号（110接警信息和接警信息的外键）")
    private String jjbh; 

 	/**
     * 案件名称
     */
    @Column(name = "AJMC")
    @ApiModelProperty(value = "案件名称")
    private String ajmc; 

 	/**
     * 案件名称拼音码
     */
    @Column(name = "AJMC_PYM")
    @ApiModelProperty(value = "案件名称拼音码")
    private String ajmcPym; 

 	/**
     * 办案单位编号
     */
    @Column(name = "BADW_BH")
    @ApiModelProperty(value = "办案单位编号")
    private String badwBh; 

 	/**
     * 办案单位名称
     */
    @Column(name = "BADW_MC")
    @ApiModelProperty(value = "办案单位名称")
    private String badwMc; 

 	/**
     * 公安一级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安一级归属单位")
    private String gaOwnerDept1; 

 	/**
     * 公安二级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安二级归属单位")
    private String gaOwnerDept2; 

 	/**
     * 公安三级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安三级归属单位")
    private String gaOwnerDept3; 

 	/**
     * 公安四级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安四级归属单位")
    private String gaOwnerDept4; 

 	/**
     * 公安五级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安五级归属单位")
    private String gaOwnerDept5; 

 	/**
     * 业务单位的一级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_1")
    @ApiModelProperty(value = "业务单位的一级归属单位")
    private String bzOwnerDept1; 

 	/**
     * 业务单位的二级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_2")
    @ApiModelProperty(value = "业务单位的二级归属单位")
    private String bzOwnerDept2; 

 	/**
     * 业务单位的三级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_3")
    @ApiModelProperty(value = "业务单位的三级归属单位")
    private String bzOwnerDept3; 

 	/**
     * 业务单位的四级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_4")
    @ApiModelProperty(value = "业务单位的四级归属单位")
    private String bzOwnerDept4; 

 	/**
     * 业务单位的五级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_5")
    @ApiModelProperty(value = "业务单位的五级归属单位")
    private String bzOwnerDept5; 

 	/**
     * 主办人身份证号码
     */
    @Column(name = "ZBR_SFZHM")
    @ApiModelProperty(value = "主办人身份证号码")
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
     * 主办人姓名拼音码
     */
    @Column(name = "ZBR_XM_PYM")
    @ApiModelProperty(value = "主办人姓名拼音码")
    private String zbrXmPym; 

 	/**
     * 案件类别编号（01、刑事案件；02、行政案件）
     */
    @Column(name = "AJLB")
    @ApiModelProperty(value = "案件类别编号（01、刑事案件；02、行政案件）")
    private String ajlb; 

 	/**
     * 二级案件类别编号
     */
    @Column(name = "AJLB2_BH")
    @ApiModelProperty(value = "二级案件类别编号")
    private String ajlb2Bh; 

 	/**
     * 二级案件类别名称
     */
    @Column(name = "AJLB2_MC")
    @ApiModelProperty(value = "二级案件类别名称")
    private String ajlb2Mc; 

 	/**
     * 案件属性编号
     */
    @Column(name = "AJSX_BH")
    @ApiModelProperty(value = "案件属性编号")
    private String ajsxBh; 

 	/**
     * 案件属性名称
     */
    @Column(name = "AJSX_MC")
    @ApiModelProperty(value = "案件属性名称")
    private String ajsxMc; 

 	/**
     * 受案时间
     */
    @Column(name = "SASJ")
    @ApiModelProperty(value = "受案时间")
    private java.util.Date sasj; 

 	/**
     * 立案时间
     */
    @Column(name = "LASJ")
    @ApiModelProperty(value = "立案时间")
    private java.util.Date lasj; 

 	/**
     * 结案时间
     */
    @Column(name = "JASJ")
    @ApiModelProperty(value = "结案时间")
    private java.util.Date jasj; 

 	/**
     * 案件状态
     */
    @Column(name = "AJZT")
    @ApiModelProperty(value = "案件状态")
    private String ajzt; 

 	/**
     * 简要案情
     */
    @Column(name = "JYAQ")
    @ApiModelProperty(value = "简要案情")
    private String jyaq; 

 	/**
     * 办案程序编号（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
     */
    @Column(name = "BACX_BH")
    @ApiModelProperty(value = "办案程序编号（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）")
    private String bacxBh; 

 	/**
     * 办案程序名称（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
     */
    @Column(name = "BACX_MC")
    @ApiModelProperty(value = "办案程序名称（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）")
    private String bacxMc; 

 	/**
     * 数据状态（0、正常；1、已删除） 
     */
    @Column(name = "SJZT")
    @ApiModelProperty(value = "数据状态（0、正常；1、已删除） ")
    private String sjzt; 

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
    * 获得接警编号（110接警信息和接警信息的外键）
    * @return JJBH
    */
    public String getJjbh() {
        return this.jjbh;
    }

    /**
    * 设置接警编号（110接警信息和接警信息的外键）
    * @param jjbh
    */
    public void setJjbh(String jjbh) {
        this.jjbh = jjbh;
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
    * 获得案件名称拼音码
    * @return AJMC_PYM
    */
    public String getAjmcPym() {
        return this.ajmcPym;
    }

    /**
    * 设置案件名称拼音码
    * @param ajmcPym
    */
    public void setAjmcPym(String ajmcPym) {
        this.ajmcPym = ajmcPym;
    }

    /**
    * 获得办案单位编号
    * @return BADW_BH
    */
    public String getBadwBh() {
        return this.badwBh;
    }

    /**
    * 设置办案单位编号
    * @param badwBh
    */
    public void setBadwBh(String badwBh) {
        this.badwBh = badwBh;
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
    * 获得公安一级归属单位
    * @return GA_OWNER_DEPT_1
    */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
    * 设置公安一级归属单位
    * @param gaOwnerDept1
    */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
    * 获得公安二级归属单位
    * @return GA_OWNER_DEPT_2
    */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
    * 设置公安二级归属单位
    * @param gaOwnerDept2
    */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
    * 获得公安三级归属单位
    * @return GA_OWNER_DEPT_3
    */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
    * 设置公安三级归属单位
    * @param gaOwnerDept3
    */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
    * 获得公安四级归属单位
    * @return GA_OWNER_DEPT_4
    */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
    * 设置公安四级归属单位
    * @param gaOwnerDept4
    */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
    * 获得公安五级归属单位
    * @return GA_OWNER_DEPT_5
    */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
    * 设置公安五级归属单位
    * @param gaOwnerDept5
    */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }

    /**
    * 获得业务单位的一级归属单位
    * @return BZ_OWNER_DEPT_1
    */
    public String getBzOwnerDept1() {
        return this.bzOwnerDept1;
    }

    /**
    * 设置业务单位的一级归属单位
    * @param bzOwnerDept1
    */
    public void setBzOwnerDept1(String bzOwnerDept1) {
        this.bzOwnerDept1 = bzOwnerDept1;
    }

    /**
    * 获得业务单位的二级归属单位
    * @return BZ_OWNER_DEPT_2
    */
    public String getBzOwnerDept2() {
        return this.bzOwnerDept2;
    }

    /**
    * 设置业务单位的二级归属单位
    * @param bzOwnerDept2
    */
    public void setBzOwnerDept2(String bzOwnerDept2) {
        this.bzOwnerDept2 = bzOwnerDept2;
    }

    /**
    * 获得业务单位的三级归属单位
    * @return BZ_OWNER_DEPT_3
    */
    public String getBzOwnerDept3() {
        return this.bzOwnerDept3;
    }

    /**
    * 设置业务单位的三级归属单位
    * @param bzOwnerDept3
    */
    public void setBzOwnerDept3(String bzOwnerDept3) {
        this.bzOwnerDept3 = bzOwnerDept3;
    }

    /**
    * 获得业务单位的四级归属单位
    * @return BZ_OWNER_DEPT_4
    */
    public String getBzOwnerDept4() {
        return this.bzOwnerDept4;
    }

    /**
    * 设置业务单位的四级归属单位
    * @param bzOwnerDept4
    */
    public void setBzOwnerDept4(String bzOwnerDept4) {
        this.bzOwnerDept4 = bzOwnerDept4;
    }

    /**
    * 获得业务单位的五级归属单位
    * @return BZ_OWNER_DEPT_5
    */
    public String getBzOwnerDept5() {
        return this.bzOwnerDept5;
    }

    /**
    * 设置业务单位的五级归属单位
    * @param bzOwnerDept5
    */
    public void setBzOwnerDept5(String bzOwnerDept5) {
        this.bzOwnerDept5 = bzOwnerDept5;
    }

    /**
    * 获得主办人身份证号码
    * @return ZBR_SFZHM
    */
    public String getZbrSfzhm() {
        return this.zbrSfzhm;
    }

    /**
    * 设置主办人身份证号码
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
    * 获得主办人姓名拼音码
    * @return ZBR_XM_PYM
    */
    public String getZbrXmPym() {
        return this.zbrXmPym;
    }

    /**
    * 设置主办人姓名拼音码
    * @param zbrXmPym
    */
    public void setZbrXmPym(String zbrXmPym) {
        this.zbrXmPym = zbrXmPym;
    }

    /**
    * 获得案件类别编号（01、刑事案件；02、行政案件）
    * @return AJLB
    */
    public String getAjlb() {
        return this.ajlb;
    }

    /**
    * 设置案件类别编号（01、刑事案件；02、行政案件）
    * @param ajlb
    */
    public void setAjlb(String ajlb) {
        this.ajlb = ajlb;
    }

    /**
    * 获得二级案件类别编号
    * @return AJLB2_BH
    */
    public String getAjlb2Bh() {
        return this.ajlb2Bh;
    }

    /**
    * 设置二级案件类别编号
    * @param ajlb2Bh
    */
    public void setAjlb2Bh(String ajlb2Bh) {
        this.ajlb2Bh = ajlb2Bh;
    }

    /**
    * 获得二级案件类别名称
    * @return AJLB2_MC
    */
    public String getAjlb2Mc() {
        return this.ajlb2Mc;
    }

    /**
    * 设置二级案件类别名称
    * @param ajlb2Mc
    */
    public void setAjlb2Mc(String ajlb2Mc) {
        this.ajlb2Mc = ajlb2Mc;
    }

    /**
    * 获得案件属性编号
    * @return AJSX_BH
    */
    public String getAjsxBh() {
        return this.ajsxBh;
    }

    /**
    * 设置案件属性编号
    * @param ajsxBh
    */
    public void setAjsxBh(String ajsxBh) {
        this.ajsxBh = ajsxBh;
    }

    /**
    * 获得案件属性名称
    * @return AJSX_MC
    */
    public String getAjsxMc() {
        return this.ajsxMc;
    }

    /**
    * 设置案件属性名称
    * @param ajsxMc
    */
    public void setAjsxMc(String ajsxMc) {
        this.ajsxMc = ajsxMc;
    }

    /**
    * 获得受案时间
    * @return SASJ
    */
    public java.util.Date getSasj() {
        return this.sasj;
    }

    /**
    * 设置受案时间
    * @param sasj
    */
    public void setSasj(java.util.Date sasj) {
        this.sasj = sasj;
    }

    /**
    * 获得立案时间
    * @return LASJ
    */
    public java.util.Date getLasj() {
        return this.lasj;
    }

    /**
    * 设置立案时间
    * @param lasj
    */
    public void setLasj(java.util.Date lasj) {
        this.lasj = lasj;
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
    * 获得简要案情
    * @return JYAQ
    */
    public String getJyaq() {
        return this.jyaq;
    }

    /**
    * 设置简要案情
    * @param jyaq
    */
    public void setJyaq(String jyaq) {
        this.jyaq = jyaq;
    }

    /**
    * 获得办案程序编号（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
    * @return BACX_BH
    */
    public String getBacxBh() {
        return this.bacxBh;
    }

    /**
    * 设置办案程序编号（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
    * @param bacxBh
    */
    public void setBacxBh(String bacxBh) {
        this.bacxBh = bacxBh;
    }

    /**
    * 获得办案程序名称（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
    * @return BACX_MC
    */
    public String getBacxMc() {
        return this.bacxMc;
    }

    /**
    * 设置办案程序名称（1、刑事案件；2、一般程序；3、简易调解；4、当场处罚；5、快速办理）
    * @param bacxMc
    */
    public void setBacxMc(String bacxMc) {
        this.bacxMc = bacxMc;
    }

    /**
    * 获得数据状态（0、正常；1、已删除） 
    * @return SJZT
    */
    public String getSjzt() {
        return this.sjzt;
    }

    /**
    * 设置数据状态（0、正常；1、已删除） 
    * @param sjzt
    */
    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
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