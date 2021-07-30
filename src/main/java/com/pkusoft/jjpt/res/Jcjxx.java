package com.pkusoft.jjpt.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import java.util.Date;

public class Jcjxx {

    private String jjdObjid;     //接警单id

    private String bjrxm;     //报警人姓名

    private String bjdh;     //报警电话

    private String lxdh;     //联系电话

    private String reporterSource; //报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110转警，1003-电话接警

    @JsonFormat(pattern = "YY/MM/dd HH:mm:SS",timezone = "GMT+8")
    private Date bjsj;     //报警时间

    private String bjrxb;     //报警人性别 0:未知，1:男，2女，DIC_GENDER

    private String jqtypeid1;     //报警类别 警情类型第一大类，DIC_JJPT_BJLB

    private String jqtypeid2;     //报警类型 警情类型第二大类，DIC_JJPT_BJLX

    private String jqtypeid3;     //报警细类 警情类型第三大类，DIC_JJPT_BJXL

    private String afdd;     //案发地点

    private String bjnr;     //报警内容

    private String communityName;     //社区名称

    private String communityCode;     //社区编号

    private String cjdObjid;     //处警单主键id

    @JsonFormat(pattern = "YY/MM/dd HH:mm:SS",timezone = "GMT+8")
    private Date dcsj;     //到场时间

    @JsonFormat(pattern = "YY/MM/dd HH:mm:SS",timezone = "GMT+8")
    private Date fksj;     //反馈时间

    private String cjjg;     //处警结果(详细处警结果)

    private String status;     //警情状态

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJjdObjid() {
        return jjdObjid;
    }

    public void setJjdObjid(String jjdObjid) {
        this.jjdObjid = jjdObjid;
    }

    public String getBjrxm() {
        return bjrxm;
    }

    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    public String getBjdh() {
        return bjdh;
    }

    public void setBjdh(String bjdh) {
        this.bjdh = bjdh;
    }

    public String getReporterSource() {
        return reporterSource;
    }

    public void setReporterSource(String reporterSource) {
        this.reporterSource = reporterSource;
    }

    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    public String getBjrxb() {
        return bjrxb;
    }

    public void setBjrxb(String bjrxb) {
        this.bjrxb = bjrxb;
    }

    public String getJqtypeid1() {
        return jqtypeid1;
    }

    public void setJqtypeid1(String jqtypeid1) {
        this.jqtypeid1 = jqtypeid1;
    }

    public String getJqtypeid2() {
        return jqtypeid2;
    }

    public void setJqtypeid2(String jqtypeid2) {
        this.jqtypeid2 = jqtypeid2;
    }

    public String getJqtypeid3() {
        return jqtypeid3;
    }

    public void setJqtypeid3(String jqtypeid3) {
        this.jqtypeid3 = jqtypeid3;
    }

    public String getAfdd() {
        return afdd;
    }

    public void setAfdd(String afdd) {
        this.afdd = afdd;
    }

    public String getBjnr() {
        return bjnr;
    }

    public void setBjnr(String bjnr) {
        this.bjnr = bjnr;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    public String getCjdObjid() {
        return cjdObjid;
    }

    public void setCjdObjid(String cjdObjid) {
        this.cjdObjid = cjdObjid;
    }

    public Date getDcsj() {
        return dcsj;
    }

    public void setDcsj(Date dcsj) {
        this.dcsj = dcsj;
    }

    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    public String getCjjg() {
        return cjjg;
    }

    public void setCjjg(String cjjg) {
        this.cjjg = cjjg;
    }

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }
}
