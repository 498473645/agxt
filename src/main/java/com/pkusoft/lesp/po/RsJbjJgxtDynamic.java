package com.pkusoft.lesp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;

/**
* @author
* @title: RsJbjJgxtDynamic
*/
@Table(name = "RS_JBJ_JGXT_DYNAMIC")
public class RsJbjJgxtDynamic {

    /**序列化版本号*/
    private static final long serialVersionUID = 1L;

    /**
    * 接警编号*
    */
        @Id
    @Column(name = "JJBH")
    private String jjbh;

    /**
    * 接警单编号
    */
    @Column(name = "JJDBH")
    private String jjdbh;

    /**
    * 案件编号
    */
    @Column(name = "AJBH")
    private String ajbh;

    /**
    * 报警人姓名*
    */
    @Column(name = "BJRXM")
    private String bjrxm;

    /**
     * 报警人姓名*
     */
    @Column(name = "BJRGMSFHM")
    private String bjrgmsfhm;

    /**
    * 接警单位*
    */
    @Column(name = "JJDW")
    private String jjdw;

    /**
    * 接警单位名称*
    */
    @Column(name = "JJDWMC")
    private String jjdwmc;

    /**
    * 接警时间*
    */
    @Column(name = "JJSJ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "PRC")
    private java.util.Date jjsj;

    /**
    * 事发地点*
    */
    @Column(name = "SFDD")
    private String sfdd;

    /**
    * 报警人性别*
    */
    @Column(name = "BJRXB")
    private String bjrxb;

    /**
    * 报警人联系电话*
    */
    @Column(name = "BJRLXDH")
    private String bjrlxdh;

    /**
    * 报警电话*
    */
    @Column(name = "BJDH")
    private String bjdh;

    /**
    * 警情类型*
    */
    @Column(name = "JQTYPEID")
    private String jqtypeid;

    /**
    * 警情类型名称*
    */
    @Column(name = "JQTYPE_NAME")
    private String jqtypeName;


    /**
     * 警情来源*
     */
    @Column(name = "JQLY")
    private String jqly;

    /**
    * 报警内容*
    */
    @Column(name = "BJNR")
    private String bjnr;

    /**
    * 处警类别代码
    */
    @Column(name = "CJLBDM")
    private String cjlbdm;

    /**
    * 处警类别
    */
    @Column(name = "CJLB")
    private String cjlb;

    /**
    * 处警人
    */
    @Column(name = "CJR")
    private String cjr;

    /**
    * 处警时间
    */
    @Column(name = "CJSJ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "PRC")
    private java.util.Date cjsj;

    /**
    * 处警结果内容
    */
    @Column(name = "CJJGNR")
    private String cjjgnr;

    /**
    * 处警结果
    */
    @Column(name = "CJJG")
    private String cjjg;

    /**
    * 处警结果代码
    */
    @Column(name = "CJJGDM")
    private String cjjgdm;

    /**
    * 处警单位
    */
    @Column(name = "CJDW")
    private String cjdw;

    /**
    * 处警单位名称
    */
    @Column(name = "CJDWMC")
    private String cjdwmc;

    /**
    * 审批日期
    */
    @Column(name = "SPRQ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "PRC")
    private java.util.Date sprq;

    /**
    * 审批意见
    */
    @Column(name = "SPYJ")
    private String spyj;

    /**
    * 公安归属单位1*
    */
    @Column(name = "GA_OWNER_DEPT_1")
    private String gaOwnerDept1;

    /**
    * 公安归属单位2*
    */
    @Column(name = "GA_OWNER_DEPT_2")
    private String gaOwnerDept2;

    /**
    * 公安归属单位3*
    */
    @Column(name = "GA_OWNER_DEPT_3")
    private String gaOwnerDept3;

    /**
    * 公安归属单位4*
    */
    @Column(name = "GA_OWNER_DEPT_4")
    private String gaOwnerDept4;

    /**
    * 公安归属单位5*
    */
    @Column(name = "GA_OWNER_DEPT_5")
    private String gaOwnerDept5;

    /**
    * 接警人姓名*
    */
    @Column(name = "JJRXM")
    private String jjrxm;


    public RsJbjJgxtDynamic(){

    }



    public String getJjbh() {
    return this.jjbh;
    }

    public void setJjbh(String jjbh) {
    this.jjbh = jjbh;
    }


    public String getJjdbh() {
    return this.jjdbh;
    }

    public void setJjdbh(String jjdbh) {
    this.jjdbh = jjdbh;
    }


    public String getAjbh() {
    return this.ajbh;
    }

    public void setAjbh(String ajbh) {
    this.ajbh = ajbh;
    }


    public String getBjrxm() {
    return this.bjrxm;
    }

    public void setBjrxm(String bjrxm) {
    this.bjrxm = bjrxm;
    }


    public String getJjdw() {
    return this.jjdw;
    }

    public void setJjdw(String jjdw) {
    this.jjdw = jjdw;
    }


    public String getJjdwmc() {
    return this.jjdwmc;
    }

    public void setJjdwmc(String jjdwmc) {
    this.jjdwmc = jjdwmc;
    }


    public java.util.Date getJjsj() {
    return this.jjsj;
    }

    public void setJjsj(java.util.Date jjsj) {
    this.jjsj = jjsj;
    }


    public String getSfdd() {
    return this.sfdd;
    }

    public void setSfdd(String sfdd) {
    this.sfdd = sfdd;
    }


    public String getBjrxb() {
    return this.bjrxb;
    }

    public void setBjrxb(String bjrxb) {
    this.bjrxb = bjrxb;
    }


    public String getBjrlxdh() {
    return this.bjrlxdh;
    }

    public void setBjrlxdh(String bjrlxdh) {
    this.bjrlxdh = bjrlxdh;
    }


    public String getBjdh() {
    return this.bjdh;
    }

    public void setBjdh(String bjdh) {
    this.bjdh = bjdh;
    }

    public String getJqtypeid() {
        return jqtypeid;
    }

    public void setJqtypeid(String jqtypeid) {
        this.jqtypeid = jqtypeid;
    }

    public String getJqtypeName() {
    return this.jqtypeName;
    }

    public void setJqtypeName(String jqtypeName) {
    this.jqtypeName = jqtypeName;
    }


    public String getBjnr() {
    return this.bjnr;
    }

    public void setBjnr(String bjnr) {
    this.bjnr = bjnr;
    }


    public String getCjlbdm() {
    return this.cjlbdm;
    }

    public void setCjlbdm(String cjlbdm) {
    this.cjlbdm = cjlbdm;
    }


    public String getCjlb() {
    return this.cjlb;
    }

    public void setCjlb(String cjlb) {
    this.cjlb = cjlb;
    }


    public String getCjr() {
    return this.cjr;
    }

    public void setCjr(String cjr) {
    this.cjr = cjr;
    }


    public java.util.Date getCjsj() {
    return this.cjsj;
    }

    public void setCjsj(java.util.Date cjsj) {
    this.cjsj = cjsj;
    }


    public String getCjjgnr() {
    return this.cjjgnr;
    }

    public void setCjjgnr(String cjjgnr) {
    this.cjjgnr = cjjgnr;
    }


    public String getCjjg() {
    return this.cjjg;
    }

    public void setCjjg(String cjjg) {
    this.cjjg = cjjg;
    }


    public String getCjjgdm() {
    return this.cjjgdm;
    }

    public void setCjjgdm(String cjjgdm) {
    this.cjjgdm = cjjgdm;
    }


    public String getCjdw() {
    return this.cjdw;
    }

    public void setCjdw(String cjdw) {
    this.cjdw = cjdw;
    }


    public String getCjdwmc() {
    return this.cjdwmc;
    }

    public void setCjdwmc(String cjdwmc) {
    this.cjdwmc = cjdwmc;
    }


    public java.util.Date getSprq() {
    return this.sprq;
    }

    public void setSprq(java.util.Date sprq) {
    this.sprq = sprq;
    }


    public String getSpyj() {
    return this.spyj;
    }

    public void setSpyj(String spyj) {
    this.spyj = spyj;
    }


    public String getGaOwnerDept1() {
    return this.gaOwnerDept1;
    }

    public void setGaOwnerDept1(String gaOwnerDept1) {
    this.gaOwnerDept1 = gaOwnerDept1;
    }


    public String getGaOwnerDept2() {
    return this.gaOwnerDept2;
    }

    public void setGaOwnerDept2(String gaOwnerDept2) {
    this.gaOwnerDept2 = gaOwnerDept2;
    }


    public String getGaOwnerDept3() {
    return this.gaOwnerDept3;
    }

    public void setGaOwnerDept3(String gaOwnerDept3) {
    this.gaOwnerDept3 = gaOwnerDept3;
    }


    public String getGaOwnerDept4() {
    return this.gaOwnerDept4;
    }

    public void setGaOwnerDept4(String gaOwnerDept4) {
    this.gaOwnerDept4 = gaOwnerDept4;
    }


    public String getGaOwnerDept5() {
    return this.gaOwnerDept5;
    }

    public void setGaOwnerDept5(String gaOwnerDept5) {
    this.gaOwnerDept5 = gaOwnerDept5;
    }


    public String getJjrxm() {
    return this.jjrxm;
    }

    public void setJjrxm(String jjrxm) {
    this.jjrxm = jjrxm;
    }

    public String getBjrgmsfhm() {
        return bjrgmsfhm;
    }

    public void setBjrgmsfhm(String bjrgmsfhm) {
        this.bjrgmsfhm = bjrgmsfhm;
    }

    public String getJqly() {
        return jqly;
    }

    public void setJqly(String jqly) {
        this.jqly = jqly;
    }
}
