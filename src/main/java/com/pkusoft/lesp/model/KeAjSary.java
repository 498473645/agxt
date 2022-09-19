package com.pkusoft.lesp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: KeAjSary
 */
@ApiModel("案件-涉案人员")
@Table(name = "KE_AJ_SARY")
public class KeAjSary {

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
     * 人员编号
     */
    @Column(name = "RYBH")
    @ApiModelProperty(value = "人员编号")
    private String rybh;

 	/**
     * 公民身份证号
     */
    @Column(name = "GMSFHM")
    @ApiModelProperty(value = "公民身份证号")
    private String gmsfhm;

 	/**
     * 姓名
     */
    @Column(name = "XM")
    @ApiModelProperty(value = "姓名")
    private String xm;

 	/**
     * 涉案人员类别编号。1、嫌疑人；2、受害人；3、证人；4、违法行为人；5、纠纷当事人；9、其他涉案人员
     */
    @Column(name = "SARYLB_BH")
    @ApiModelProperty(value = "涉案人员类别编号。1、嫌疑人；2、受害人；3、证人；4、违法行为人；5、纠纷当事人；9、其他涉案人员")
    private String sarylbBh;

 	/**
     * 涉案人员类别名称
     */
    @Column(name = "SARYLB_MC")
    @ApiModelProperty(value = "涉案人员类别名称")
    private String sarylbMc;

 	/**
     * 数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；
     */
    @Column(name = "SJLY")
    @ApiModelProperty(value = "数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；")
    private String sjly;

 	/**
     * 抽取时间
     */
    @Column(name = "CQSJ")
    @ApiModelProperty(value = "抽取时间")
    private java.util.Date cqsj;

 	/**
     * 刑侦借口获取的人像照片
     */
    @Column(name = "RXZP")
    @ApiModelProperty(value = "刑侦借口获取的人像照片")
    private String rxzp;


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
    * 获得人员编号
    * @return RYBH
    */
    public String getRybh() {
        return this.rybh;
    }

    /**
    * 设置人员编号
    * @param rybh
    */
    public void setRybh(String rybh) {
        this.rybh = rybh;
    }

    /**
    * 获得公民身份证号
    * @return GMSFHM
    */
    public String getGmsfhm() {
        return this.gmsfhm;
    }

    /**
    * 设置公民身份证号
    * @param gmsfhm
    */
    public void setGmsfhm(String gmsfhm) {
        this.gmsfhm = gmsfhm;
    }

    /**
    * 获得姓名
    * @return XM
    */
    public String getXm() {
        return this.xm;
    }

    /**
    * 设置姓名
    * @param xm
    */
    public void setXm(String xm) {
        this.xm = xm;
    }

    /**
    * 获得涉案人员类别编号。1、嫌疑人；2、受害人；3、证人；4、违法行为人；5、纠纷当事人；9、其他涉案人员
    * @return SARYLB_BH
    */
    public String getSarylbBh() {
        return this.sarylbBh;
    }

    /**
    * 设置涉案人员类别编号。1、嫌疑人；2、受害人；3、证人；4、违法行为人；5、纠纷当事人；9、其他涉案人员
    * @param sarylbBh
    */
    public void setSarylbBh(String sarylbBh) {
        this.sarylbBh = sarylbBh;
    }

    /**
    * 获得涉案人员类别名称
    * @return SARYLB_MC
    */
    public String getSarylbMc() {
        return this.sarylbMc;
    }

    /**
    * 设置涉案人员类别名称
    * @param sarylbMc
    */
    public void setSarylbMc(String sarylbMc) {
        this.sarylbMc = sarylbMc;
    }

    /**
    * 获得数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；
    * @return SJLY
    */
    public String getSjly() {
        return this.sjly;
    }

    /**
    * 设置数据来源：01、刑专一体化平台；02、老警综平台；03、新警综平台；
    * @param sjly
    */
    public void setSjly(String sjly) {
        this.sjly = sjly;
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
    * 获得刑侦借口获取的人像照片
    * @return RXZP
    */
    public String getRxzp() {
        return this.rxzp;
    }

    /**
    * 设置刑侦借口获取的人像照片
    * @param rxzp
    */
    public void setRxzp(String rxzp) {
        this.rxzp = rxzp;
    }


}
