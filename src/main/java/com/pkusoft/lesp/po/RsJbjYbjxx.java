package com.pkusoft.lesp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RS_JBJ_YBJXX")
public class RsJbjYbjxx {

    @Id
    @Column(name = "BJID")
    private String bjid;     //报警ID主键

    @Column(name = "BJDBH")
    private String bjdbh;     //预报警单编号

    @Column(name = "JQLY")
    private String jqly;     //警情来源（10-微信小程序，21-电话报警(呼入)，22-电话报警(呼出)，）

    @Column(name = "BJLB")
    private String bjlb;     //报警类别（伤害类、诈骗类、抢夺类、侵犯类等）

    @Column(name = "SFJT")
    private String sfjt;     //电话报警是否接通（0：未接通。1：接通）

    @Column(name = "BJDWDM")
    private String bjdwdm;     //报警单位代码

    @Column(name = "BJDWMC")
    private String bjdwmc;     //报警单位名称

    @Column(name = "BJSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "PRC")
    private Date bjsj;     //报警时间

    @Column(name = "BJDZT")
    private String bjdzt;     //报警单状态

    @Column(name = "BJRLXDH")
    private String bjrlxdh;     //报警人联系电话

    @Column(name = "WECHAT")
    private String wechat;     //报警人微信号

    @Column(name = "BJRGMSFHM")
    private String bjrgmsfhm;     //报警人身份证号码

    @Column(name = "STATUS")
    private String status;     //状态

    @Column(name = "GXSJ")
    private Date gxsj;     //更新时间

    @Column(name = "CQSJ")
    private Date cqsj;     //抽取时间

    @Column(name = "GA_OWNER_DEPT_1")
    private String gaOwnerDept1;     //公安一级归属单位

    @Column(name = "GA_OWNER_DEPT_2")
    private String gaOwnerDept2;     //公安二级归属单位

    @Column(name = "GA_OWNER_DEPT_3")
    private String gaOwnerDept3;     //公安三级归属单位

    @Column(name = "GA_OWNER_DEPT_4")
    private String gaOwnerDept4;     //公安四级归属单位

    @Column(name = "GA_OWNER_DEPT_5")
    private String gaOwnerDept5;     //公安五级归属单位


    /**
    * 获得报警ID主键
    * @return BJID
    */
    public String getBjid() {
        return this.bjid;
    }

    /**
    * 设置报警ID主键
    * @param bjid
    */
    public void setBjid(String bjid) {
        this.bjid = bjid;
    }

    /**
    * 获得预报警单编号
    * @return BJDBH
    */
    public String getBjdbh() {
        return this.bjdbh;
    }

    /**
    * 设置预报警单编号
    * @param bjdbh
    */
    public void setBjdbh(String bjdbh) {
        this.bjdbh = bjdbh;
    }

    /**
    * 获得警情来源（10-微信小程序，21-电话报警(呼入)，22-电话报警(呼出)，）
    * @return JQLY
    */
    public String getJqly() {
        return this.jqly;
    }

    /**
    * 设置警情来源（10-微信小程序，21-电话报警(呼入)，22-电话报警(呼出)，）
    * @param jqly
    */
    public void setJqly(String jqly) {
        this.jqly = jqly;
    }

    /**
    * 获得报警类别（伤害类、诈骗类、抢夺类、侵犯类等）
    * @return BJLB
    */
    public String getBjlb() {
        return this.bjlb;
    }

    /**
    * 设置报警类别（伤害类、诈骗类、抢夺类、侵犯类等）
    * @param bjlb
    */
    public void setBjlb(String bjlb) {
        this.bjlb = bjlb;
    }

    /**
    * 获得电话报警是否接通（0：未接通。1：接通）
    * @return SFJT
    */
    public String getSfjt() {
        return this.sfjt;
    }

    /**
    * 设置电话报警是否接通（0：未接通。1：接通）
    * @param sfjt
    */
    public void setSfjt(String sfjt) {
        this.sfjt = sfjt;
    }

    /**
    * 获得报警单位代码
    * @return BJDWDM
    */
    public String getBjdwdm() {
        return this.bjdwdm;
    }

    /**
    * 设置报警单位代码
    * @param bjdwdm
    */
    public void setBjdwdm(String bjdwdm) {
        this.bjdwdm = bjdwdm;
    }

    /**
    * 获得报警单位名称
    * @return BJDWMC
    */
    public String getBjdwmc() {
        return this.bjdwmc;
    }

    /**
    * 设置报警单位名称
    * @param bjdwmc
    */
    public void setBjdwmc(String bjdwmc) {
        this.bjdwmc = bjdwmc;
    }

    /**
    * 获得报警时间
    * @return BJSJ
    */
    public Date getBjsj() {
        return this.bjsj;
    }

    /**
    * 设置报警时间
    * @param bjsj
    */
    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    /**
    * 获得报警单状态
    * @return BJDZT
    */
    public String getBjdzt() {
        return this.bjdzt;
    }

    /**
    * 设置报警单状态
    * @param bjdzt
    */
    public void setBjdzt(String bjdzt) {
        this.bjdzt = bjdzt;
    }

    /**
    * 获得报警人联系电话
    * @return BJRLXDH
    */
    public String getBjrlxdh() {
        return this.bjrlxdh;
    }

    /**
    * 设置报警人联系电话
    * @param bjrlxdh
    */
    public void setBjrlxdh(String bjrlxdh) {
        this.bjrlxdh = bjrlxdh;
    }

    /**
    * 获得报警人微信号
    * @return WECHAT
    */
    public String getWechat() {
        return this.wechat;
    }

    /**
    * 设置报警人微信号
    * @param wechat
    */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
    * 获得报警人身份证号码
    * @return BJRGMSFHM
    */
    public String getBjrgmsfhm() {
        return this.bjrgmsfhm;
    }

    /**
    * 设置报警人身份证号码
    * @param bjrgmsfhm
    */
    public void setBjrgmsfhm(String bjrgmsfhm) {
        this.bjrgmsfhm = bjrgmsfhm;
    }

    /**
    * 获得状态
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得更新时间
    * @return GXSJ
    */
    public Date getGxsj() {
        return this.gxsj;
    }

    /**
    * 设置更新时间
    * @param gxsj
    */
    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    /**
    * 获得抽取时间
    * @return CQSJ
    */
    public Date getCqsj() {
        return this.cqsj;
    }

    /**
    * 设置抽取时间
    * @param cqsj
    */
    public void setCqsj(Date cqsj) {
        this.cqsj = cqsj;
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


}
