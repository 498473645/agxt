package com.pkusoft.jjpt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SP_JJXX")
public class SpJjxx {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "JJDBH")
    private String jjdbh;     //接警编号

    @Column(name = "BJRXM")
    private String bjrxm;     //报警人姓名

    @Column(name = "BJDH")
    private String bjdh;     //报警电话

    @Column(name = "REPORTER_SOURCE")
    private String reporterSource;     //报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110转警，1003-电话接警, 1004-微信报警, 1005-终端报警

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
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private java.util.Date bjsj;     //报警时间

    @Column(name = "JJSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private java.util.Date jjsj;     //接警时间

    @Column(name = "CJSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private java.util.Date cjsj;     //处警时间

    @Column(name = "FKSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private java.util.Date fksj;     //反馈时间

    @Column(name = "JJY")
    private String jjy;     //接警员

    @Column(name = "JJDW")
    private String jjdw;     //接警单位

    @Column(name = "JJDWMC")
    private String jjdwmc;     //接警单位名称

    @Column(name = "SLDW")
    private String sldw;     //受理单位编码

    @Column(name = "GXDW")
    private String gxdw;     //管辖单位编码

    @Column(name = "DDSJ")
    private java.util.Date ddsj;     //调度时间

    @Column(name = "CJR_NAME")
    private String cjrName;     //处警人姓名

    @Column(name = "COMMUNITY_CODE")
    private String communityCode;     //社区编号

    @Column(name = "COMMUNITY_NAME")
    private String communityName;     //社区名称

    @Column(name = "DDR_CODE")
    private String ddrCode;     //调度人编号

    @Column(name = "DDR_NAME")
    private String ddrName;     //调度人名称

    @Column(name = "LXDH")
    private String lxdh;     //联系电话

    @Column(name = "SLDW_NAME")
    private String sldwName;     //受理单位名称

    @Column(name = "GXDW_NAME")
    private String gxdwName;     //管辖单位名称

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "LLDZ")
    private String lldz;     //电话录音地址

    @Column(name = "CJDBH")
    private String cjdbh;     //处警单编号：接警编号加2位流水号，如01，02

    @Column(name = "CJD_OBJID")
    private String cjdObjid;  //处警单id

    @Column(name = "FKDBH")
    private String fkdbh;     //反馈单编号

    @Column(name = "CA_ID")
    private String caId;     //关联的电话表主键SP_CALL_RECORD.objid，仅限电话接警

    @Column(name = "JQ_NAME")
    private String jqName;     //警情名称（用于打印回执单）

    @Column(name = "BJRZP")
    private String bjrzp;     //报警人照片地址

    @Column(name = "BJID")
    private String bjid;     //预报警表主键，ZZJBJ_BJXX.BJID

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS

    @Column(name = "CJR_CODE")
    private String cjrCode;     //处警人编号

    @Column(name = "CREATE_ID")
    private String createId;     //创建者ID

    @Column(name = "CREATE_NAME")
    private String createName;     //创建者名称

    @Column(name = "CREATE_TIME")
    private java.util.Date createTime;     //创建时间

    @Column(name = "MODER_ID")
    private String moderId;     //最后修改者ID

    @Column(name = "MODER_NAME")
    private String moderName;     //最后修改者名称

    @Column(name = "MODER_TIME")
    private java.util.Date moderTime;     //最后修改时间

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

    @Column(name = "OWNER_TYPE")
    private String ownerType;     //归属单位类型（1-公安单位；2-业务单位）

    @Column(name = "BZ_OWNER_DEPT_1")
    private String bzOwnerDept1;     //业务单位的一级归属单位

    @Column(name = "BZ_OWNER_DEPT_2")
    private String bzOwnerDept2;     //业务单位的二级归属单位

    @Column(name = "BZ_OWNER_DEPT_3")
    private String bzOwnerDept3;     //业务单位的三级归属单位

    @Column(name = "BZ_OWNER_DEPT_4")
    private String bzOwnerDept4;     //业务单位的四级归属单位

    @Column(name = "BZ_OWNER_DEPT_5")
    private String bzOwnerDept5;     //业务单位的五级归属单位

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

    @Column(name = "JJY_CODE")
    private String jjyCode;     //接警员编号

    @Column(name = "BJRSFZH")
    private String bjrsfzh;     //报警人身份证号码

    @Column(name = "AFSJ")
    private String afsj;     //案发时间

    @Column(name = "IS_PY")
    private String isPy;     //是否评议

    public String getAfsj() {
        return afsj;
    }

    public void setAfsj(String afsj) {
        this.afsj = afsj;
    }

    public String getIsPy() {
        return isPy;
    }

    public void setIsPy(String isPy) {
        this.isPy = isPy;
    }

    public String getJjyCode() {
        return jjyCode;
    }

    public void setJjyCode(String jjyCode) {
        this.jjyCode = jjyCode;
    }

    /**
    * 获得主键ID
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键ID
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
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

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getFksj() {
        return fksj;
    }

    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    /**
    * 获得报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110转警，1003-电话接警
    * @return REPORTER_SOURCE
    */
    public String getReporterSource() {
        return this.reporterSource;
    }

    /**
    * 设置报警形式，DIC_JJPT_BJXS，1001-现场接警，1002-110转警，1003-电话接警
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
    public java.util.Date getBjsj() {
        return this.bjsj;
    }

    /**
    * 设置报警时间
    * @param bjsj
    */
    public void setBjsj(java.util.Date bjsj) {
        this.bjsj = bjsj;
    }

    /**
    * 获得接警时间
    * @return JJSJ
    */
    public java.util.Date getJjsj() {
        return this.jjsj;
    }

    /**
    * 设置接警时间
    * @param jjsj
    */
    public void setJjsj(java.util.Date jjsj) {
        this.jjsj = jjsj;
    }

    /**
    * 获得接警员
    * @return JJY
    */
    public String getJjy() {
        return this.jjy;
    }

    /**
    * 设置接警员
    * @param jjy
    */
    public void setJjy(String jjy) {
        this.jjy = jjy;
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
    * 获得调度时间
    * @return DDSJ
    */
    public java.util.Date getDdsj() {
        return this.ddsj;
    }

    /**
    * 设置调度时间
    * @param ddsj
    */
    public void setDdsj(java.util.Date ddsj) {
        this.ddsj = ddsj;
    }

    /**
    * 获得处警人姓名
    * @return CJR_NAME
    */
    public String getCjrName() {
        return this.cjrName;
    }

    /**
    * 设置处警人姓名
    * @param cjrName
    */
    public void setCjrName(String cjrName) {
        this.cjrName = cjrName;
    }

    /**
    * 获得社区编号
    * @return COMMUNITY_CODE
    */
    public String getCommunityCode() {
        return this.communityCode;
    }

    /**
    * 设置社区编号
    * @param communityCode
    */
    public void setCommunityCode(String communityCode) {
        this.communityCode = communityCode;
    }

    /**
    * 获得社区名称
    * @return COMMUNITY_NAME
    */
    public String getCommunityName() {
        return this.communityName;
    }

    /**
    * 设置社区名称
    * @param communityName
    */
    public void setCommunityName(String communityName) {
        this.communityName = communityName;
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

    public String getLxdh() {
        return lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
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
    * 获得电话录音地址
    * @return LLDZ
    */
    public String getLldz() {
        return this.lldz;
    }

    /**
    * 设置电话录音地址
    * @param lldz
    */
    public void setLldz(String lldz) {
        this.lldz = lldz;
    }

    /**
    * 获得处警单编号：接警编号加2位流水号，如01，02
    * @return CJDBH
    */
    public String getCjdbh() {
        return this.cjdbh;
    }

    /**
    * 设置处警单编号：接警编号加2位流水号，如01，02
    * @param cjdbh
    */
    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
    }

    /**
    * 获得反馈单编号
    * @return FKDBH
    */
    public String getFkdbh() {
        return this.fkdbh;
    }

    /**
    * 设置反馈单编号
    * @param fkdbh
    */
    public void setFkdbh(String fkdbh) {
        this.fkdbh = fkdbh;
    }

    /**
    * 获得关联的电话表主键SP_CALL_RECORD.objid，仅限电话接警
    * @return CA_ID
    */
    public String getCaId() {
        return this.caId;
    }

    /**
    * 设置关联的电话表主键SP_CALL_RECORD.objid，仅限电话接警
    * @param caId
    */
    public void setCaId(String caId) {
        this.caId = caId;
    }

    /**
    * 获得警情名称（用于打印回执单）
    * @return JQ_NAME
    */
    public String getJqName() {
        return this.jqName;
    }

    /**
    * 设置警情名称（用于打印回执单）
    * @param jqName
    */
    public void setJqName(String jqName) {
        this.jqName = jqName;
    }

    /**
    * 获得报警人照片地址
    * @return BJRZP
    */
    public String getBjrzp() {
        return this.bjrzp;
    }

    /**
    * 设置报警人照片地址
    * @param bjrzp
    */
    public void setBjrzp(String bjrzp) {
        this.bjrzp = bjrzp;
    }

    /**
    * 获得预报警表主键，ZZJBJ_BJXX.BJID
    * @return BJID
    */
    public String getBjid() {
        return this.bjid;
    }

    /**
    * 设置预报警表主键，ZZJBJ_BJXX.BJID
    * @param bjid
    */
    public void setBjid(String bjid) {
        this.bjid = bjid;
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
    * 获得处警人编号
    * @return CJR_CODE
    */
    public String getCjrCode() {
        return this.cjrCode;
    }

    /**
    * 设置处警人编号
    * @param cjrCode
    */
    public void setCjrCode(String cjrCode) {
        this.cjrCode = cjrCode;
    }

    /**
    * 获得创建者ID
    * @return CREATE_ID
    */
    public String getCreateId() {
        return this.createId;
    }

    /**
    * 设置创建者ID
    * @param createId
    */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
    * 获得创建者名称
    * @return CREATE_NAME
    */
    public String getCreateName() {
        return this.createName;
    }

    /**
    * 设置创建者名称
    * @param createName
    */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
    * 获得创建时间
    * @return CREATE_TIME
    */
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
    * 设置创建时间
    * @param createTime
    */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
    * 获得最后修改者ID
    * @return MODER_ID
    */
    public String getModerId() {
        return this.moderId;
    }

    /**
    * 设置最后修改者ID
    * @param moderId
    */
    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    /**
    * 获得最后修改者名称
    * @return MODER_NAME
    */
    public String getModerName() {
        return this.moderName;
    }

    /**
    * 设置最后修改者名称
    * @param moderName
    */
    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    /**
    * 获得最后修改时间
    * @return MODER_TIME
    */
    public java.util.Date getModerTime() {
        return this.moderTime;
    }

    /**
    * 设置最后修改时间
    * @param moderTime
    */
    public void setModerTime(java.util.Date moderTime) {
        this.moderTime = moderTime;
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
    * 获得归属单位类型（1-公安单位；2-业务单位）
    * @return OWNER_TYPE
    */
    public String getOwnerType() {
        return this.ownerType;
    }

    /**
    * 设置归属单位类型（1-公安单位；2-业务单位）
    * @param ownerType
    */
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
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

    public String getCjdObjid() {
        return cjdObjid;
    }

    public void setCjdObjid(String cjdObjid) {
        this.cjdObjid = cjdObjid;
    }

    public String getBjrsfzh() {
        return bjrsfzh;
    }

    public void setBjrsfzh(String bjrsfzh) {
        this.bjrsfzh = bjrsfzh;
    }
}
