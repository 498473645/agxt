package com.pkusoft.lesp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RS_JBJ_JJXX")
public class RsJbjJjxx {

    @Id
    @Column(name = "JJDBH")
    private String jjdbh;     //接警编号

    @Column(name = "PJDBH")
    private String pjdbh;     //派警单号

    @Column(name = "CJDBH")
    private String cjdbh;     //处警单号

    @Column(name = "BJRXM")
    private String bjrxm;     //报警人姓名

    @Column(name = "BJDH")
    private String bjdh;     //报警电话

    @Column(name = "REPORTER_SOURCE")
    private String reporterSource;     //报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110接警，1003-电话接警，9999-其他

    @Column(name = "CALL_NUMBER")
    private String callNumber;     //被叫号码

    @Column(name = "ALARM_SEAT")
    private String alarmSeat;     //接警坐席

    @Column(name = "BJRXB")
    private String bjrxb;     //报警人性别 0:未知，1:男，2女，DIC_GENDER

    @Column(name = "JQTYPEID1")
    private String jqtypeid1;     //报警类别 警情类型第一大类，DIC_JJPT_BJLB

    @Column(name = "JQTYPEID2")
    private String jqtypeid2;     //报警类型 警情类型第二大类，DIC_JJPT_BJLX

    @Column(name = "JQTYPEID3")
    private String jqtypeid3;     //报警细类 警情类型第三大类，DIC_JJPT_BJXL

    @Column(name = "JQTYPE_NAME1")
    private String jqtypeName1;     //报警类别名称

    @Column(name = "JQTYPE_NAME2")
    private String jqtypeName2;     //报警类型名称

    @Column(name = "JQTYPE_NAME3")
    private String jqtypeName3;     //报警细类名称

    @Column(name = "AFDD")
    private String afdd;     //案发地点

    @Column(name = "BJNR")
    private String bjnr;     //报警内容

    @Column(name = "BJSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "PRC")
    private Date bjsj;     //报警时间

    @Column(name = "JJSJ")
    private Date jjsj;     //接警时间

    @Column(name = "JJYGH")
    private String jjygh;     //接警员工号

    @Column(name = "JJYMC")
    private String jjymc;     //接警员名称

    @Column(name = "JJDW")
    private String jjdw;     //接警单位

    @Column(name = "JJDWMC")
    private String jjdwmc;     //接警单位名称

    @Column(name = "SLDW")
    private String sldw;     //受理单位编码

    @Column(name = "GXDW")
    private String gxdw;     //管辖单位编码

    @Column(name = "XQDM")
    private String xqdm;     //辖区编号

    @Column(name = "XQMC")
    private String xqmc;     //辖区名称

    @Column(name = "DDR_CODE")
    private String ddrCode;     //调度人编号

    @Column(name = "DDR_NAME")
    private String ddrName;     //调度人名称

    @Column(name = "LLDH")
    private String lldh;     //联系电话

    @Column(name = "SLDW_NAME")
    private String sldwName;     //受理单位名称

    @Column(name = "GXDW_NAME")
    private String gxdwName;     //管辖单位名称

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "JQJC")
    private String jqjc;     //警情简称

    @Column(name = "LYBH")
    private String lybh;     //录音编号

    @Column(name = "BJR_ZJHM")
    private String bjrZjhm;     //报警人证件号码

    @Column(name = "BJR_ZJZL")
    private String bjrZjzl;     //报警人证件种类

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS

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

    @Column(name = "XGSJ")
    private Date xgsj;     //修改时间

    @Column(name = "BJID")
    private String bjid;     //预报警报警码

    public String getBjid() {
        return bjid;
    }

    public void setBjid(String bjid) {
        this.bjid = bjid;
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
    * 获得派警单号
    * @return PJDBH
    */
    public String getPjdbh() {
        return this.pjdbh;
    }

    /**
    * 设置派警单号
    * @param pjdbh
    */
    public void setPjdbh(String pjdbh) {
        this.pjdbh = pjdbh;
    }

    /**
    * 获得处警单号
    * @return CJDBH
    */
    public String getCjdbh() {
        return this.cjdbh;
    }

    /**
    * 设置处警单号
    * @param cjdbh
    */
    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
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
    * 获得报警电话
    * @return BJDH
    */
    public String getBjdh() {
        return this.bjdh;
    }

    /**
    * 设置报警电话
    * @param bjdh
    */
    public void setBjdh(String bjdh) {
        this.bjdh = bjdh;
    }

    /**
    * 获得报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110接警，1003-电话接警，9999-其他
    * @return REPORTER_SOURCE
    */
    public String getReporterSource() {
        return this.reporterSource;
    }

    /**
    * 设置报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110接警，1003-电话接警，9999-其他
    * @param reporterSource
    */
    public void setReporterSource(String reporterSource) {
        this.reporterSource = reporterSource;
    }

    /**
    * 获得被叫号码
    * @return CALL_NUMBER
    */
    public String getCallNumber() {
        return this.callNumber;
    }

    /**
    * 设置被叫号码
    * @param callNumber
    */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /**
    * 获得接警坐席
    * @return ALARM_SEAT
    */
    public String getAlarmSeat() {
        return this.alarmSeat;
    }

    /**
    * 设置接警坐席
    * @param alarmSeat
    */
    public void setAlarmSeat(String alarmSeat) {
        this.alarmSeat = alarmSeat;
    }

    /**
    * 获得报警人性别 0:未知，1:男，2女，DIC_GENDER
    * @return BJRXB
    */
    public String getBjrxb() {
        return this.bjrxb;
    }

    /**
    * 设置报警人性别 0:未知，1:男，2女，DIC_GENDER
    * @param bjrxb
    */
    public void setBjrxb(String bjrxb) {
        this.bjrxb = bjrxb;
    }

    /**
    * 获得报警类别 警情类型第一大类，DIC_JJPT_BJLB
    * @return JQTYPEID1
    */
    public String getJqtypeid1() {
        return this.jqtypeid1;
    }

    /**
    * 设置报警类别 警情类型第一大类，DIC_JJPT_BJLB
    * @param jqtypeid1
    */
    public void setJqtypeid1(String jqtypeid1) {
        this.jqtypeid1 = jqtypeid1;
    }

    /**
    * 获得报警类型 警情类型第二大类，DIC_JJPT_BJLX
    * @return JQTYPEID2
    */
    public String getJqtypeid2() {
        return this.jqtypeid2;
    }

    /**
    * 设置报警类型 警情类型第二大类，DIC_JJPT_BJLX
    * @param jqtypeid2
    */
    public void setJqtypeid2(String jqtypeid2) {
        this.jqtypeid2 = jqtypeid2;
    }

    /**
    * 获得报警细类 警情类型第三大类，DIC_JJPT_BJXL
    * @return JQTYPEID3
    */
    public String getJqtypeid3() {
        return this.jqtypeid3;
    }

    /**
    * 设置报警细类 警情类型第三大类，DIC_JJPT_BJXL
    * @param jqtypeid3
    */
    public void setJqtypeid3(String jqtypeid3) {
        this.jqtypeid3 = jqtypeid3;
    }

    /**
    * 获得报警类别名称
    * @return JQTYPE_NAME1
    */
    public String getJqtypeName1() {
        return this.jqtypeName1;
    }

    /**
    * 设置报警类别名称
    * @param jqtypeName1
    */
    public void setJqtypeName1(String jqtypeName1) {
        this.jqtypeName1 = jqtypeName1;
    }

    /**
    * 获得报警类型名称
    * @return JQTYPE_NAME2
    */
    public String getJqtypeName2() {
        return this.jqtypeName2;
    }

    /**
    * 设置报警类型名称
    * @param jqtypeName2
    */
    public void setJqtypeName2(String jqtypeName2) {
        this.jqtypeName2 = jqtypeName2;
    }

    /**
    * 获得报警细类名称
    * @return JQTYPE_NAME3
    */
    public String getJqtypeName3() {
        return this.jqtypeName3;
    }

    /**
    * 设置报警细类名称
    * @param jqtypeName3
    */
    public void setJqtypeName3(String jqtypeName3) {
        this.jqtypeName3 = jqtypeName3;
    }

    /**
    * 获得案发地点
    * @return AFDD
    */
    public String getAfdd() {
        return this.afdd;
    }

    /**
    * 设置案发地点
    * @param afdd
    */
    public void setAfdd(String afdd) {
        this.afdd = afdd;
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
    * 获得接警时间
    * @return JJSJ
    */
    public Date getJjsj() {
        return this.jjsj;
    }

    /**
    * 设置接警时间
    * @param jjsj
    */
    public void setJjsj(Date jjsj) {
        this.jjsj = jjsj;
    }

    /**
    * 获得接警员工号
    * @return JJYGH
    */
    public String getJjygh() {
        return this.jjygh;
    }

    /**
    * 设置接警员工号
    * @param jjygh
    */
    public void setJjygh(String jjygh) {
        this.jjygh = jjygh;
    }

    /**
    * 获得接警员名称
    * @return JJYMC
    */
    public String getJjymc() {
        return this.jjymc;
    }

    /**
    * 设置接警员名称
    * @param jjymc
    */
    public void setJjymc(String jjymc) {
        this.jjymc = jjymc;
    }

    /**
    * 获得接警单位
    * @return JJDW
    */
    public String getJjdw() {
        return this.jjdw;
    }

    /**
    * 设置接警单位
    * @param jjdw
    */
    public void setJjdw(String jjdw) {
        this.jjdw = jjdw;
    }

    /**
    * 获得接警单位名称
    * @return JJDWMC
    */
    public String getJjdwmc() {
        return this.jjdwmc;
    }

    /**
    * 设置接警单位名称
    * @param jjdwmc
    */
    public void setJjdwmc(String jjdwmc) {
        this.jjdwmc = jjdwmc;
    }

    /**
    * 获得受理单位编码
    * @return SLDW
    */
    public String getSldw() {
        return this.sldw;
    }

    /**
    * 设置受理单位编码
    * @param sldw
    */
    public void setSldw(String sldw) {
        this.sldw = sldw;
    }

    /**
    * 获得管辖单位编码
    * @return GXDW
    */
    public String getGxdw() {
        return this.gxdw;
    }

    /**
    * 设置管辖单位编码
    * @param gxdw
    */
    public void setGxdw(String gxdw) {
        this.gxdw = gxdw;
    }

    /**
    * 获得辖区编号
    * @return XQDM
    */
    public String getXqdm() {
        return this.xqdm;
    }

    /**
    * 设置辖区编号
    * @param xqdm
    */
    public void setXqdm(String xqdm) {
        this.xqdm = xqdm;
    }

    /**
    * 获得辖区名称
    * @return XQMC
    */
    public String getXqmc() {
        return this.xqmc;
    }

    /**
    * 设置辖区名称
    * @param xqmc
    */
    public void setXqmc(String xqmc) {
        this.xqmc = xqmc;
    }

    /**
    * 获得调度人编号
    * @return DDR_CODE
    */
    public String getDdrCode() {
        return this.ddrCode;
    }

    /**
    * 设置调度人编号
    * @param ddrCode
    */
    public void setDdrCode(String ddrCode) {
        this.ddrCode = ddrCode;
    }

    /**
    * 获得调度人名称
    * @return DDR_NAME
    */
    public String getDdrName() {
        return this.ddrName;
    }

    /**
    * 设置调度人名称
    * @param ddrName
    */
    public void setDdrName(String ddrName) {
        this.ddrName = ddrName;
    }

    /**
    * 获得联系电话
    * @return LLDH
    */
    public String getLldh() {
        return this.lldh;
    }

    /**
    * 设置联系电话
    * @param lldh
    */
    public void setLldh(String lldh) {
        this.lldh = lldh;
    }

    /**
    * 获得受理单位名称
    * @return SLDW_NAME
    */
    public String getSldwName() {
        return this.sldwName;
    }

    /**
    * 设置受理单位名称
    * @param sldwName
    */
    public void setSldwName(String sldwName) {
        this.sldwName = sldwName;
    }

    /**
    * 获得管辖单位名称
    * @return GXDW_NAME
    */
    public String getGxdwName() {
        return this.gxdwName;
    }

    /**
    * 设置管辖单位名称
    * @param gxdwName
    */
    public void setGxdwName(String gxdwName) {
        this.gxdwName = gxdwName;
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
    * 获得警情简称
    * @return JQJC
    */
    public String getJqjc() {
        return this.jqjc;
    }

    /**
    * 设置警情简称
    * @param jqjc
    */
    public void setJqjc(String jqjc) {
        this.jqjc = jqjc;
    }

    /**
    * 获得录音编号
    * @return LYBH
    */
    public String getLybh() {
        return this.lybh;
    }

    /**
    * 设置录音编号
    * @param lybh
    */
    public void setLybh(String lybh) {
        this.lybh = lybh;
    }

    /**
    * 获得报警人证件号码
    * @return BJR_ZJHM
    */
    public String getBjrZjhm() {
        return this.bjrZjhm;
    }

    /**
    * 设置报警人证件号码
    * @param bjrZjhm
    */
    public void setBjrZjhm(String bjrZjhm) {
        this.bjrZjhm = bjrZjhm;
    }

    /**
    * 获得报警人证件种类
    * @return BJR_ZJZL
    */
    public String getBjrZjzl() {
        return this.bjrZjzl;
    }

    /**
    * 设置报警人证件种类
    * @param bjrZjzl
    */
    public void setBjrZjzl(String bjrZjzl) {
        this.bjrZjzl = bjrZjzl;
    }

    /**
    * 获得所属机构编码
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置所属机构编码
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得所属机构名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置所属机构名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    /**
    * 获得修改时间
    * @return XGSJ
    */
    public Date getXgsj() {
        return this.xgsj;
    }

    /**
    * 设置修改时间
    * @param xgsj
    */
    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }


}
