package com.pkusoft.lesp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RS_JBJ_JGXT_DYNAMIC")
public class RsJbjJgxtDynamic {


    @Column(name = "BJRXM")
    private String bjrxm;     //

    @Column(name = "LLDH")
    private String lldh;     //

    @Column(name = "REPORTER_SOURCE")
    private String reporterSource;     //

    @Column(name = "JJDWMC")
    private String jjdwmc;     //

    @Column(name = "JJSJ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date jjsj;     //

    @Column(name = "STATUS")
    private String status;     //

    @Column(name = "YBJ_STATUS")
    private String ybjStatus;     //

    @Id
    @Column(name = "JJDBH")
    private String jjdbh;     //

    @Column(name = "JQLY")
    private String jqly;     //

    @Column(name = "JQTYPEID1")
    private String jqtypeid1;     //

    @Column(name = "JQTYPE_NAME1")
    private String jqtypeName1;     //

    @Column(name = "BJLB")
    private String bjlb;     //

    @Column(name = "BJSJ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date bjsj;     //

    @Column(name = "BJRGMSFHM")
    private String bjrgmsfhm;     //

    @Column(name = "BJRLXDH")
    private String bjrlxdh;     //

    @Column(name = "BJID")
    private String bjid;     //

    @Column(name = "CJJGMC")
    private String cjjgmc;     //

    @Column(name = "CJSJ")
    @DateTimeFormat(pattern="MM-dd HH:mm")
    @JsonFormat(pattern = "MM-dd HH:mm", timezone = "GMT+8")
    private Date cjsj;     //

    @Column(name = "CJDBH")
    private String cjdbh;     //

    @Column(name = "GA_OWNER_DEPT_1")
    private String gaOwnerDept1;     //

    @Column(name = "GA_OWNER_DEPT_2")
    private String gaOwnerDept2;     //

    @Column(name = "GA_OWNER_DEPT_3")
    private String gaOwnerDept3;     //

    @Column(name = "GA_OWNER_DEPT_4")
    private String gaOwnerDept4;     //

    @Column(name = "GA_OWNER_DEPT_5")
    private String gaOwnerDept5;     //

    public String getYbjStatus() {
        return ybjStatus;
    }

    public void setYbjStatus(String ybjStatus) {
        this.ybjStatus = ybjStatus;
    }

    public String getJqtypeid1() {
        return jqtypeid1;
    }

    public void setJqtypeid1(String jqtypeid1) {
        this.jqtypeid1 = jqtypeid1;
    }

    public String getJqtypeName1() {
        return jqtypeName1;
    }

    public void setJqtypeName1(String jqtypeName1) {
        this.jqtypeName1 = jqtypeName1;
    }

    /**
    * 获得
    * @return BJRXM
    */
    public String getBjrxm() {
        return this.bjrxm;
    }

    /**
    * 设置
    * @param bjrxm
    */
    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    /**
    * 获得
    * @return LLDH
    */
    public String getLldh() {
        return this.lldh;
    }

    /**
    * 设置
    * @param lldh
    */
    public void setLldh(String lldh) {
        this.lldh = lldh;
    }

    /**
    * 获得
    * @return REPORTER_SOURCE
    */
    public String getReporterSource() {
        return this.reporterSource;
    }

    /**
    * 设置
    * @param reporterSource
    */
    public void setReporterSource(String reporterSource) {
        this.reporterSource = reporterSource;
    }

    /**
    * 获得
    * @return JJDWMC
    */
    public String getJjdwmc() {
        return this.jjdwmc;
    }

    /**
    * 设置
    * @param jjdwmc
    */
    public void setJjdwmc(String jjdwmc) {
        this.jjdwmc = jjdwmc;
    }

    /**
    * 获得
    * @return JJSJ
    */
    public Date getJjsj() {
        return this.jjsj;
    }

    /**
    * 设置
    * @param jjsj
    */
    public void setJjsj(Date jjsj) {
        this.jjsj = jjsj;
    }

    /**
    * 获得
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得
    * @return JJDBH
    */
    public String getJjdbh() {
        return this.jjdbh;
    }

    /**
    * 设置
    * @param jjdbh
    */
    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    /**
    * 获得
    * @return JQLY
    */
    public String getJqly() {
        return this.jqly;
    }

    /**
    * 设置
    * @param jqly
    */
    public void setJqly(String jqly) {
        this.jqly = jqly;
    }

    /**
    * 获得
    * @return BJLB
    */
    public String getBjlb() {
        return this.bjlb;
    }

    /**
    * 设置
    * @param bjlb
    */
    public void setBjlb(String bjlb) {
        this.bjlb = bjlb;
    }

    /**
    * 获得
    * @return BJSJ
    */
    public Date getBjsj() {
        return this.bjsj;
    }

    /**
    * 设置
    * @param bjsj
    */
    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    /**
    * 获得
    * @return BJRGMSFHM
    */
    public String getBjrgmsfhm() {
        return this.bjrgmsfhm;
    }

    /**
    * 设置
    * @param bjrgmsfhm
    */
    public void setBjrgmsfhm(String bjrgmsfhm) {
        this.bjrgmsfhm = bjrgmsfhm;
    }

    /**
    * 获得
    * @return BJRLXDH
    */
    public String getBjrlxdh() {
        return this.bjrlxdh;
    }

    /**
    * 设置
    * @param bjrlxdh
    */
    public void setBjrlxdh(String bjrlxdh) {
        this.bjrlxdh = bjrlxdh;
    }

    /**
    * 获得
    * @return BJID
    */
    public String getBjid() {
        return this.bjid;
    }

    /**
    * 设置
    * @param bjid
    */
    public void setBjid(String bjid) {
        this.bjid = bjid;
    }

    /**
    * 获得
    * @return CJJGMC
    */
    public String getCjjgmc() {
        return this.cjjgmc;
    }

    /**
    * 设置
    * @param cjjgmc
    */
    public void setCjjgmc(String cjjgmc) {
        this.cjjgmc = cjjgmc;
    }

    /**
    * 获得
    * @return CJSJ
    */
    public Date getCjsj() {
        return this.cjsj;
    }

    /**
    * 设置
    * @param cjsj
    */
    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    /**
    * 获得
    * @return CJDBH
    */
    public String getCjdbh() {
        return this.cjdbh;
    }

    /**
    * 设置
    * @param cjdbh
    */
    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
    }

    /**
    * 获得
    * @return GA_OWNER_DEPT_1
    */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
    * 设置
    * @param gaOwnerDept1
    */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
    * 获得
    * @return GA_OWNER_DEPT_2
    */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
    * 设置
    * @param gaOwnerDept2
    */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
    * 获得
    * @return GA_OWNER_DEPT_3
    */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
    * 设置
    * @param gaOwnerDept3
    */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
    * 获得
    * @return GA_OWNER_DEPT_4
    */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
    * 设置
    * @param gaOwnerDept4
    */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
    * 获得
    * @return GA_OWNER_DEPT_5
    */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
    * 设置
    * @param gaOwnerDept5
    */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }


}