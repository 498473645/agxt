package com.pkusoft.lesp.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RS_JBJ_FKXX")
public class RsJbjFkxx {

    @Id
    @Column(name = "CJDBH")
    private String cjdbh;     //处警编号

    @Column(name = "JJDBH")
    private String jjdbh;     //接警编号

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "CJDWDM")
    private String cjdwdm;     //处警单位编码

    @Column(name = "CJDWMC")
    private String cjdwmc;     //处警单位名称

    @Column(name = "STATUS")
    private String status;     //状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS

    @Column(name = "FKRGH")
    private String fkrgh;     //反馈人工号

    @Column(name = "FKRXM")
    private String fkrxm;     //反馈人姓名

    @Column(name = "CJSJ")
    private Date cjsj;     //处警时间

    @Column(name = "DCSJ")
    private Date dcsj;     //到场时间

    @Column(name = "FKSJ")
    private Date fksj;     //反馈时间

    @Column(name = "SFSJ")
    private Date sfsj;     //事发时间

    @Column(name = "CJRDM")
    private String cjrdm;     //处警人代码

    @Column(name = "CJRXM")
    private String cjrxm;     //处警人姓名

    @Column(name = "XQDM")
    private String xqdm;     //辖区名称

    @Column(name = "XQMC")
    private String xqmc;     //辖区代码

    @Column(name = "CJJGMC")
    private String cjjgmc;     //处警结果

    @Column(name = "FKJGMC")
    private String fkjgmc;     //反馈结果

    @Column(name = "FKJGBM")
    private String fkjgbm;     //反馈结果编码

    @Column(name = "CJJGBM")
    private String cjjgbm;     //处警结果编码

    @Column(name = "CJCZSJ")
    private Date cjczsj;     //处警操作时间

    @Column(name = "REPORTER_SOURCE")
    private String reporterSource;     //报警形式1001-现场接警，1002-110接警，1003-电话接警，9999-其他

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
    * 获得处警编号
    * @return CJDBH
    */
    public String getCjdbh() {
        return this.cjdbh;
    }

    /**
    * 设置处警编号
    * @param cjdbh
    */
    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
    }

    /**
    * 获得接警编号
    * @return JJDBH
    */
    public String getJjdbh() {
        return this.jjdbh;
    }

    /**
    * 设置接警编号
    * @param jjdbh
    */
    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    /**
    * 获得备注
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置备注
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
    * 获得处警单位编码
    * @return CJDWDM
    */
    public String getCjdwdm() {
        return this.cjdwdm;
    }

    /**
    * 设置处警单位编码
    * @param cjdwdm
    */
    public void setCjdwdm(String cjdwdm) {
        this.cjdwdm = cjdwdm;
    }

    /**
    * 获得处警单位名称
    * @return CJDWMC
    */
    public String getCjdwmc() {
        return this.cjdwmc;
    }

    /**
    * 设置处警单位名称
    * @param cjdwmc
    */
    public void setCjdwmc(String cjdwmc) {
        this.cjdwmc = cjdwmc;
    }

    /**
    * 获得状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得反馈人工号
    * @return FKRGH
    */
    public String getFkrgh() {
        return this.fkrgh;
    }

    /**
    * 设置反馈人工号
    * @param fkrgh
    */
    public void setFkrgh(String fkrgh) {
        this.fkrgh = fkrgh;
    }

    /**
    * 获得反馈人姓名
    * @return FKRXM
    */
    public String getFkrxm() {
        return this.fkrxm;
    }

    /**
    * 设置反馈人姓名
    * @param fkrxm
    */
    public void setFkrxm(String fkrxm) {
        this.fkrxm = fkrxm;
    }

    /**
    * 获得处警时间
    * @return CJSJ
    */
    public Date getCjsj() {
        return this.cjsj;
    }

    /**
    * 设置处警时间
    * @param cjsj
    */
    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    /**
    * 获得到场时间
    * @return DCSJ
    */
    public Date getDcsj() {
        return this.dcsj;
    }

    /**
    * 设置到场时间
    * @param dcsj
    */
    public void setDcsj(Date dcsj) {
        this.dcsj = dcsj;
    }

    /**
    * 获得反馈时间
    * @return FKSJ
    */
    public Date getFksj() {
        return this.fksj;
    }

    /**
    * 设置反馈时间
    * @param fksj
    */
    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    /**
    * 获得事发时间
    * @return SFSJ
    */
    public Date getSfsj() {
        return this.sfsj;
    }

    /**
    * 设置事发时间
    * @param sfsj
    */
    public void setSfsj(Date sfsj) {
        this.sfsj = sfsj;
    }

    /**
    * 获得处警人代码
    * @return CJRDM
    */
    public String getCjrdm() {
        return this.cjrdm;
    }

    /**
    * 设置处警人代码
    * @param cjrdm
    */
    public void setCjrdm(String cjrdm) {
        this.cjrdm = cjrdm;
    }

    /**
    * 获得处警人姓名
    * @return CJRXM
    */
    public String getCjrxm() {
        return this.cjrxm;
    }

    /**
    * 设置处警人姓名
    * @param cjrxm
    */
    public void setCjrxm(String cjrxm) {
        this.cjrxm = cjrxm;
    }

    /**
    * 获得辖区名称
    * @return XQDM
    */
    public String getXqdm() {
        return this.xqdm;
    }

    /**
    * 设置辖区名称
    * @param xqdm
    */
    public void setXqdm(String xqdm) {
        this.xqdm = xqdm;
    }

    /**
    * 获得辖区代码
    * @return XQMC
    */
    public String getXqmc() {
        return this.xqmc;
    }

    /**
    * 设置辖区代码
    * @param xqmc
    */
    public void setXqmc(String xqmc) {
        this.xqmc = xqmc;
    }

    /**
    * 获得处警结果
    * @return CJJGMC
    */
    public String getCjjgmc() {
        return this.cjjgmc;
    }

    /**
    * 设置处警结果
    * @param cjjgmc
    */
    public void setCjjgmc(String cjjgmc) {
        this.cjjgmc = cjjgmc;
    }

    /**
    * 获得反馈结果
    * @return FKJGMC
    */
    public String getFkjgmc() {
        return this.fkjgmc;
    }

    /**
    * 设置反馈结果
    * @param fkjgmc
    */
    public void setFkjgmc(String fkjgmc) {
        this.fkjgmc = fkjgmc;
    }

    /**
    * 获得反馈结果编码
    * @return FKJGBM
    */
    public String getFkjgbm() {
        return this.fkjgbm;
    }

    /**
    * 设置反馈结果编码
    * @param fkjgbm
    */
    public void setFkjgbm(String fkjgbm) {
        this.fkjgbm = fkjgbm;
    }

    /**
    * 获得处警结果编码
    * @return CJJGBM
    */
    public String getCjjgbm() {
        return this.cjjgbm;
    }

    /**
    * 设置处警结果编码
    * @param cjjgbm
    */
    public void setCjjgbm(String cjjgbm) {
        this.cjjgbm = cjjgbm;
    }

    /**
    * 获得处警操作时间
    * @return CJCZSJ
    */
    public Date getCjczsj() {
        return this.cjczsj;
    }

    /**
    * 设置处警操作时间
    * @param cjczsj
    */
    public void setCjczsj(Date cjczsj) {
        this.cjczsj = cjczsj;
    }

    /**
    * 获得报警形式1001-现场接警，1002-110接警，1003-电话接警，9999-其他
    * @return REPORTER_SOURCE
    */
    public String getReporterSource() {
        return this.reporterSource;
    }

    /**
    * 设置报警形式1001-现场接警，1002-110接警，1003-电话接警，9999-其他
    * @param reporterSource
    */
    public void setReporterSource(String reporterSource) {
        this.reporterSource = reporterSource;
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