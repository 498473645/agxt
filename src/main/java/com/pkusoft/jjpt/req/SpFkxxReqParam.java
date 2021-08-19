package com.pkusoft.jjpt.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "SP_FKXX")
public class SpFkxxReqParam extends Page {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键id

    @Column(name = "CJDBH")
    private String cjdbh;     //处警单编号

    @Column(name = "JJDBH")
    private String jjdbh;     //接警单编号

    @Column(name = "JJD_OBJID")
    private String jjdObjid;     //接警单id

    @Column(name = "STATUS")
    private String status;     //状态(1000 已撤销, 1001 接警 , 1002 出警 , 1003到场反馈,1004处警反馈,1005补充反馈)，DIC_JJPT_CASESTATUS

    @Column(name = "FKRGH")
    private String fkrgh;     //反馈人工号

    @Column(name = "FKRXM")
    private String fkrxm;     //反馈人姓名

    @Column(name = "CJSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private Date cjsj;     //处警时间

    @Column(name = "CJCZSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private Date cjczsj;     //处警操作时间

    @Column(name = "DCSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private Date dcsj;     //到场时间

    @Column(name = "FKSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private Date fksj;     //反馈时间

    @Column(name = "SFSJ")
    @DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm", timezone = "PRC")
    private Date sfsj;     //事发时间

    @Column(name = "CJRBM")
    private String cjrbm;     //处警人编码

    @Column(name = "CJRXM")
    private String cjrxm;     //处警人姓名

    @Column(name = "XQDM")
    private String xqdm;     //辖区代码

    @Column(name = "XQMC")
    private String xqmc;     //辖区名称

    @Column(name = "CJJGMC")
    private String cjjgmc;     //处警结果名称

    @Column(name = "CJJGBM")
    private String cjjgbm;     //处警结果编码

    @Column(name = "CJJG")
    private String cjjg;     //处警结果(详细处警结果)

    @Column(name = "FKJGMC")
    private String fkjgmc;     //反馈结果名称

    @Column(name = "FKJGBM")
    private String fkjgbm;     //反馈结果编码

    @Column(name = "FKJG")
    private String fkjg;     //反馈结果(详细反馈结果)

    @Column(name = "REPORTER_SOURCE")
    private String reporterSource;     //报警形式1001-现场接警，1002-110接警，1003-电话接警，9999-其他

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "CREATE_ID")
    private String createId;     //创建者ID

    @Column(name = "CREATE_NAME")
    private String createName;     //创建者名称

    @Column(name = "CREATE_TIME")
    private Date createTime;     //创建时间

    @Column(name = "MODER_ID")
    private String moderId;     //最后修改者ID

    @Column(name = "MODER_NAME")
    private String moderName;     //最后修改者名称

    @Column(name = "MODER_TIME")
    private Date moderTime;     //最后修改时间

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


    /**
    * 获得主键id
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键id
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得处警单编号
    * @return CJDBH
    */
    public String getCjdbh() {
        return this.cjdbh;
    }

    /**
    * 设置处警单编号
    * @param cjdbh
    */
    public void setCjdbh(String cjdbh) {
        this.cjdbh = cjdbh;
    }

    /**
    * 获得接警单编号
    * @return JJDBH
    */
    public String getJjdbh() {
        return this.jjdbh;
    }

    /**
    * 设置接警单编号
    * @param jjdbh
    */
    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    /**
    * 获得接警单id
    * @return JJD_OBJID
    */
    public String getJjdObjid() {
        return this.jjdObjid;
    }

    /**
    * 设置接警单id
    * @param jjdObjid
    */
    public void setJjdObjid(String jjdObjid) {
        this.jjdObjid = jjdObjid;
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
    * 获得处警人编码
    * @return CJRBM
    */
    public String getCjrbm() {
        return this.cjrbm;
    }

    /**
    * 设置处警人编码
    * @param cjrbm
    */
    public void setCjrbm(String cjrbm) {
        this.cjrbm = cjrbm;
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
    * 获得辖区代码
    * @return XQDM
    */
    public String getXqdm() {
        return this.xqdm;
    }

    /**
    * 设置辖区代码
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
    * 获得处警结果名称
    * @return CJJGMC
    */
    public String getCjjgmc() {
        return this.cjjgmc;
    }

    /**
    * 设置处警结果名称
    * @param cjjgmc
    */
    public void setCjjgmc(String cjjgmc) {
        this.cjjgmc = cjjgmc;
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
    * 获得处警结果(详细处警结果)
    * @return CJJG
    */
    public String getCjjg() {
        return this.cjjg;
    }

    /**
    * 设置处警结果(详细处警结果)
    * @param cjjg
    */
    public void setCjjg(String cjjg) {
        this.cjjg = cjjg;
    }

    /**
    * 获得反馈结果名称
    * @return FKJGMC
    */
    public String getFkjgmc() {
        return this.fkjgmc;
    }

    /**
    * 设置反馈结果名称
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
    * 获得反馈结果(详细反馈结果)
    * @return FKJG
    */
    public String getFkjg() {
        return this.fkjg;
    }

    /**
    * 设置反馈结果(详细反馈结果)
    * @param fkjg
    */
    public void setFkjg(String fkjg) {
        this.fkjg = fkjg;
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
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
    * 设置创建时间
    * @param createTime
    */
    public void setCreateTime(Date createTime) {
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
    public Date getModerTime() {
        return this.moderTime;
    }

    /**
    * 设置最后修改时间
    * @param moderTime
    */
    public void setModerTime(Date moderTime) {
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


}
