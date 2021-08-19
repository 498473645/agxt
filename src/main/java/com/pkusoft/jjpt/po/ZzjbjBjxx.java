package com.pkusoft.jjpt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ZZJBJ_BJXX")
public class ZzjbjBjxx {

    @Id
    @Column(name = "BJID")
    private String bjid;     //报警ID主键

    @Column(name = "BJDBH")
    private String bjdbh;     //报警单编号

    @Column(name = "JQLY")
    private String jqly;     //警情来源（10-微信小程序，20-自助终端，30-电话报警，）

    @Column(name = "BJFS")
    private String bjfs;     //报警方式（1-文字报警，2-语音报警）

    @Column(name = "BJLB")
    private String bjlb;     //报警类别（伤害类、诈骗类、抢夺类、侵犯类等）

    @Column(name = "XZQH")
    private String xzqh;     //行政区划代码

    @Column(name = "BJDWDM")
    private String bjdwdm;     //报警单位代码

    @Column(name = "BJDWMC")
    private String bjdwmc;     //报警单位名称

    @Column(name = "BJYY")
    private String bjyy;     //报警原因

    @Column(name = "BJSJ")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private Date bjsj;     //报警时间

    @Column(name = "AFSJ")
    private Date afsj;     //案发时间

    @Column(name = "CLSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private java.util.Date clsj;     //预报警处理时间，即接警表接警时间

    @Column(name = "AFSSXQ")
    private String afssxq;     //案发省市县区

    @Column(name = "AFDD")
    private String afdd;     //案发地点（址）

    @Column(name = "XGRY")
    private String xgry;     //案情相关人员

    @Column(name = "ZBXX")
    private String zbxx;     //案发地周边信息

    @Column(name = "BJNR")
    private String bjnr;     //报警内容

    @Column(name = "ZBSFAQ")
    private String zbsfaq;     //周边是否安全

    @Column(name = "SSQK")
    private String ssqk;     //受伤情况

    @Column(name = "BJDZT")
    private String bjdzt;     //报警单状态

    @Column(name = "FKJG")
    private String fkjg;     //反馈结果

    @Column(name = "BJRXM")
    private String bjrxm;     //报警人姓名

    @Column(name = "BJRXB")
    private String bjrxb;     //报警人性别

    @Column(name = "BJRLXDH")
    private String bjrlxdh;     //报警人联系电话

    @Column(name = "BJRGMSFHM")
    private String bjrgmsfhm;     //报警人公民身份号码

    @Column(name = "BJRZZ")
    private String bjrzz;     //报警人住址

    @Column(name = "WECHAT")
    private String wechat;     //报警人微信号

    @Column(name = "GXSJ")
    private Date gxsj;     //更新时间

    @Column(name = "IF_ACCEPT")
    private String ifAccept;     //是否已被接警平台登记，0-未登记，1-已推送至大屏，2-已登记（已闭环）

    @Column(name = "JJ_OBJID")
    private String jjObjid;     //接警表主键，SpJjxx.objig

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2

    @Column(name = "RESERVE3")
    private String reserve3;     //预留字段3

    @Column(name = "RESERVE4")
    private String reserve4;     //预留字段4

    @Column(name = "RESERVE5")
    private String reserve5;     //预留字段5

    @Column(name = "RESERVE6")
    private String reserve6;     //预留字段6

    @Column(name = "RESERVE7")
    private String reserve7;     //预留字段7

    @Column(name = "RESERVE8")
    private String reserve8;     //预留字段8

    @Column(name = "STATUS")
    private String status;     //电话状态：1010-未闭环，2010-已闭环

    @Column(name = "JJDBH")
    private String jjdbh;     //接警编号

    public String getJjdbh() {
        return jjdbh;
    }

    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIfAccept() {
        return ifAccept;
    }

    public void setIfAccept(String ifAccept) {
        this.ifAccept = ifAccept;
    }

    public String getJjObjid() {
        return jjObjid;
    }

    public void setJjObjid(String jjObjid) {
        this.jjObjid = jjObjid;
    }

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
    * 获得报警单编号
    * @return BJDBH
    */
    public String getBjdbh() {
        return this.bjdbh;
    }

    /**
    * 设置报警单编号
    * @param bjdbh
    */
    public void setBjdbh(String bjdbh) {
        this.bjdbh = bjdbh;
    }

    /**
    * 获得警情来源（10-微信小程序，20-自助终端，30-电话报警，）
    * @return JQLY
    */
    public String getJqly() {
        return this.jqly;
    }

    /**
    * 设置警情来源（10-微信小程序，20-自助终端，30-电话报警，）
    * @param jqly
    */
    public void setJqly(String jqly) {
        this.jqly = jqly;
    }

    /**
    * 获得报警方式（1-文字报警，2-语音报警）
    * @return BJFS
    */
    public String getBjfs() {
        return this.bjfs;
    }

    /**
    * 设置报警方式（1-文字报警，2-语音报警）
    * @param bjfs
    */
    public void setBjfs(String bjfs) {
        this.bjfs = bjfs;
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
    * 获得行政区划代码
    * @return XZQH
    */
    public String getXzqh() {
        return this.xzqh;
    }

    /**
    * 设置行政区划代码
    * @param xzqh
    */
    public void setXzqh(String xzqh) {
        this.xzqh = xzqh;
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
    * 获得报警原因
    * @return BJYY
    */
    public String getBjyy() {
        return this.bjyy;
    }

    /**
    * 设置报警原因
    * @param bjyy
    */
    public void setBjyy(String bjyy) {
        this.bjyy = bjyy;
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
    * 获得案发时间
    * @return AFSJ
    */
    public Date getAfsj() {
        return this.afsj;
    }

    /**
    * 设置案发时间
    * @param afsj
    */
    public void setAfsj(Date afsj) {
        this.afsj = afsj;
    }

    /**
    * 获得案发省市县区
    * @return AFSSXQ
    */
    public String getAfssxq() {
        return this.afssxq;
    }

    /**
    * 设置案发省市县区
    * @param afssxq
    */
    public void setAfssxq(String afssxq) {
        this.afssxq = afssxq;
    }

    /**
    * 获得案发地点（址）
    * @return AFDD
    */
    public String getAfdd() {
        return this.afdd;
    }

    /**
    * 设置案发地点（址）
    * @param afdd
    */
    public void setAfdd(String afdd) {
        this.afdd = afdd;
    }

    /**
    * 获得案情相关人员
    * @return XGRY
    */
    public String getXgry() {
        return this.xgry;
    }

    /**
    * 设置案情相关人员
    * @param xgry
    */
    public void setXgry(String xgry) {
        this.xgry = xgry;
    }

    /**
    * 获得案发地周边信息
    * @return ZBXX
    */
    public String getZbxx() {
        return this.zbxx;
    }

    /**
    * 设置案发地周边信息
    * @param zbxx
    */
    public void setZbxx(String zbxx) {
        this.zbxx = zbxx;
    }

    /**
    * 获得报警内容
    * @return BJNR
    */
    public String getBjnr() {
        return this.bjnr;
    }

    /**
    * 设置报警内容
    * @param bjnr
    */
    public void setBjnr(String bjnr) {
        this.bjnr = bjnr;
    }

    /**
    * 获得周边是否安全
    * @return ZBSFAQ
    */
    public String getZbsfaq() {
        return this.zbsfaq;
    }

    /**
    * 设置周边是否安全
    * @param zbsfaq
    */
    public void setZbsfaq(String zbsfaq) {
        this.zbsfaq = zbsfaq;
    }

    /**
    * 获得受伤情况
    * @return SSQK
    */
    public String getSsqk() {
        return this.ssqk;
    }

    /**
    * 设置受伤情况
    * @param ssqk
    */
    public void setSsqk(String ssqk) {
        this.ssqk = ssqk;
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
    * 获得反馈结果
    * @return FKJG
    */
    public String getFkjg() {
        return this.fkjg;
    }

    /**
    * 设置反馈结果
    * @param fkjg
    */
    public void setFkjg(String fkjg) {
        this.fkjg = fkjg;
    }

    /**
    * 获得报警人姓名
    * @return BJRXM
    */
    public String getBjrxm() {
        return this.bjrxm;
    }

    /**
    * 设置报警人姓名
    * @param bjrxm
    */
    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    /**
    * 获得报警人性别
    * @return BJRXB
    */
    public String getBjrxb() {
        return this.bjrxb;
    }

    /**
    * 设置报警人性别
    * @param bjrxb
    */
    public void setBjrxb(String bjrxb) {
        this.bjrxb = bjrxb;
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
    * 获得报警人公民身份号码
    * @return BJRGMSFHM
    */
    public String getBjrgmsfhm() {
        return this.bjrgmsfhm;
    }

    /**
    * 设置报警人公民身份号码
    * @param bjrgmsfhm
    */
    public void setBjrgmsfhm(String bjrgmsfhm) {
        this.bjrgmsfhm = bjrgmsfhm;
    }

    /**
    * 获得报警人住址
    * @return BJRZZ
    */
    public String getBjrzz() {
        return this.bjrzz;
    }

    /**
    * 设置报警人住址
    * @param bjrzz
    */
    public void setBjrzz(String bjrzz) {
        this.bjrzz = bjrzz;
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
    * 获得预留字段6
    * @return RESERVE6
    */
    public String getReserve6() {
        return this.reserve6;
    }

    /**
    * 设置预留字段6
    * @param reserve6
    */
    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6;
    }

    /**
    * 获得预留字段7
    * @return RESERVE7
    */
    public String getReserve7() {
        return this.reserve7;
    }

    /**
    * 设置预留字段7
    * @param reserve7
    */
    public void setReserve7(String reserve7) {
        this.reserve7 = reserve7;
    }

    /**
    * 获得预留字段8
    * @return RESERVE8
    */
    public String getReserve8() {
        return this.reserve8;
    }

    /**
    * 设置预留字段8
    * @param reserve8
    */
    public void setReserve8(String reserve8) {
        this.reserve8 = reserve8;
    }

    public Date getClsj() {
        return clsj;
    }

    public void setClsj(Date clsj) {
        this.clsj = clsj;
    }
}
