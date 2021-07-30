package com.pkusoft.jjpt.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "SP_RECORD")
public class SpRecord {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键id

    @Column(name = "JJD_OBJID")
    private String jjdObjid;     //接警单id

    @Column(name = "BJSJ")
    private Date bjsj;     //报警时间

    @Column(name = "BADW")
    private String badw;     //办案单位

    @Column(name = "XWR1_NAME")
    private String xwr1Name;     //询问人1名称

    @Column(name = "XWR1_CODE")
    private String xwr1Code;     //询问人1编号

    @Column(name = "XWR2_NAME")
    private String xwr2Name;     //询问人2名称

    @Column(name = "XWR2_CODE")
    private String xwr2Code;     //询问人2编号

    @Column(name = "JQBH")
    private String jqbh;     //警情编号

    @Column(name = "JLR_NAME")
    private String jlrName;     //记录人名称

    @Column(name = "JLR_CODE")
    private String jlrCode;     //记录人编号

    @Column(name = "WHDD")
    private String whdd;     //问话地点

    @Column(name = "WHDD_CODE")
    private String whddCode;     //问话地点编号

    @Column(name = "KSSJ")
    private Date kssj;     //开始时间

    @Column(name = "JSSJ")
    private Date jssj;     //结束时间

    @Column(name = "AJLX")
    private String ajlx;     //案件类型

    @Column(name = "XWDX")
    private String xwdx;     //询问对象

    @Column(name = "DAFS")
    private String dafs;     //到案方式

    @Column(name = "XM")
    private String xm;     //姓名

    @Column(name = "SFZH")
    private String sfzh;     //身份证号

    @Column(name = "XB")
    private String xb;     //性别

    @Column(name = "CSRQ")
    private String csrq;     //出生日期

    @Column(name = "NL")
    private String nl;     //年龄

    @Column(name = "MZ")
    private String mz;     //民族

    @Column(name = "WHCD")
    private String whcd;     //文化程度

    @Column(name = "ZZMM")
    private String zzmm;     //政治面貌

    @Column(name = "ZY")
    private String zy;     //职业

    @Column(name = "LXDH")
    private String lxdh;     //联系电话

    @Column(name = "GZDW")
    private String gzdw;     //工作单位

    @Column(name = "HJSZD")
    private String hjszd;     //户籍所在地

    @Column(name = "XZZ")
    private String xzz;     //现住址

    @Column(name = "IS_RDDB")
    private String isRddb;     //是否人大

    @Column(name = "RECORD_TYPE")
    private String recordType;     //笔录类型：0001-正常笔录，0002-关联笔录

    @Column(name = "BADW_NAME")
    private String badwName;     //办案单位地点

    @Column(name = "RECORDS")
    private String records;     //笔录信息

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

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态

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
    * 获得办案单位
    * @return BADW
    */
    public String getBadw() {
        return this.badw;
    }

    /**
    * 设置办案单位
    * @param badw
    */
    public void setBadw(String badw) {
        this.badw = badw;
    }

    /**
    * 获得询问人1名称
    * @return XWR1_NAME
    */
    public String getXwr1Name() {
        return this.xwr1Name;
    }

    /**
    * 设置询问人1名称
    * @param xwr1Name
    */
    public void setXwr1Name(String xwr1Name) {
        this.xwr1Name = xwr1Name;
    }

    /**
    * 获得询问人1编号
    * @return XWR1_CODE
    */
    public String getXwr1Code() {
        return this.xwr1Code;
    }

    /**
    * 设置询问人1编号
    * @param xwr1Code
    */
    public void setXwr1Code(String xwr1Code) {
        this.xwr1Code = xwr1Code;
    }

    /**
    * 获得询问人2名称
    * @return XWR2_NAME
    */
    public String getXwr2Name() {
        return this.xwr2Name;
    }

    /**
    * 设置询问人2名称
    * @param xwr2Name
    */
    public void setXwr2Name(String xwr2Name) {
        this.xwr2Name = xwr2Name;
    }

    /**
    * 获得询问人2编号
    * @return XWR2_CODE
    */
    public String getXwr2Code() {
        return this.xwr2Code;
    }

    /**
    * 设置询问人2编号
    * @param xwr2Code
    */
    public void setXwr2Code(String xwr2Code) {
        this.xwr2Code = xwr2Code;
    }

    /**
    * 获得警情编号
    * @return JQBH
    */
    public String getJqbh() {
        return this.jqbh;
    }

    /**
    * 设置警情编号
    * @param jqbh
    */
    public void setJqbh(String jqbh) {
        this.jqbh = jqbh;
    }

    /**
    * 获得记录人名称
    * @return JLR_NAME
    */
    public String getJlrName() {
        return this.jlrName;
    }

    /**
    * 设置记录人名称
    * @param jlrName
    */
    public void setJlrName(String jlrName) {
        this.jlrName = jlrName;
    }

    /**
    * 获得记录人编号
    * @return JLR_CODE
    */
    public String getJlrCode() {
        return this.jlrCode;
    }

    /**
    * 设置记录人编号
    * @param jlrCode
    */
    public void setJlrCode(String jlrCode) {
        this.jlrCode = jlrCode;
    }

    /**
    * 获得问话地点
    * @return WHDD
    */
    public String getWhdd() {
        return this.whdd;
    }

    /**
    * 设置问话地点
    * @param whdd
    */
    public void setWhdd(String whdd) {
        this.whdd = whdd;
    }

    /**
    * 获得问话地点编号
    * @return WHDD_CODE
    */
    public String getWhddCode() {
        return this.whddCode;
    }

    /**
    * 设置问话地点编号
    * @param whddCode
    */
    public void setWhddCode(String whddCode) {
        this.whddCode = whddCode;
    }

    /**
    * 获得开始时间
    * @return KSSJ
    */
    public Date getKssj() {
        return this.kssj;
    }

    /**
    * 设置开始时间
    * @param kssj
    */
    public void setKssj(Date kssj) {
        this.kssj = kssj;
    }

    /**
    * 获得结束时间
    * @return JSSJ
    */
    public Date getJssj() {
        return this.jssj;
    }

    /**
    * 设置结束时间
    * @param jssj
    */
    public void setJssj(Date jssj) {
        this.jssj = jssj;
    }

    /**
    * 获得案件类型
    * @return AJLX
    */
    public String getAjlx() {
        return this.ajlx;
    }

    /**
    * 设置案件类型
    * @param ajlx
    */
    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    /**
    * 获得询问对象
    * @return XWDX
    */
    public String getXwdx() {
        return this.xwdx;
    }

    /**
    * 设置询问对象
    * @param xwdx
    */
    public void setXwdx(String xwdx) {
        this.xwdx = xwdx;
    }

    /**
    * 获得到案方式
    * @return DAFS
    */
    public String getDafs() {
        return this.dafs;
    }

    /**
    * 设置到案方式
    * @param dafs
    */
    public void setDafs(String dafs) {
        this.dafs = dafs;
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
    * 获得身份证号
    * @return SFZH
    */
    public String getSfzh() {
        return this.sfzh;
    }

    /**
    * 设置身份证号
    * @param sfzh
    */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    /**
    * 获得性别
    * @return XB
    */
    public String getXb() {
        return this.xb;
    }

    /**
    * 设置性别
    * @param xb
    */
    public void setXb(String xb) {
        this.xb = xb;
    }

    /**
    * 获得出生日期
    * @return CSRQ
    */
    public String getCsrq() {
        return this.csrq;
    }

    /**
    * 设置出生日期
    * @param csrq
    */
    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    /**
    * 获得年龄
    * @return NL
    */
    public String getNl() {
        return this.nl;
    }

    /**
    * 设置年龄
    * @param nl
    */
    public void setNl(String nl) {
        this.nl = nl;
    }

    /**
    * 获得民族
    * @return MZ
    */
    public String getMz() {
        return this.mz;
    }

    /**
    * 设置民族
    * @param mz
    */
    public void setMz(String mz) {
        this.mz = mz;
    }

    /**
    * 获得文化程度
    * @return WHCD
    */
    public String getWhcd() {
        return this.whcd;
    }

    /**
    * 设置文化程度
    * @param whcd
    */
    public void setWhcd(String whcd) {
        this.whcd = whcd;
    }

    /**
    * 获得政治面貌
    * @return ZZMM
    */
    public String getZzmm() {
        return this.zzmm;
    }

    /**
    * 设置政治面貌
    * @param zzmm
    */
    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    /**
    * 获得职业
    * @return ZY
    */
    public String getZy() {
        return this.zy;
    }

    /**
    * 设置职业
    * @param zy
    */
    public void setZy(String zy) {
        this.zy = zy;
    }

    /**
    * 获得联系电话
    * @return LXDH
    */
    public String getLxdh() {
        return this.lxdh;
    }

    /**
    * 设置联系电话
    * @param lxdh
    */
    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    /**
    * 获得工作单位
    * @return GZDW
    */
    public String getGzdw() {
        return this.gzdw;
    }

    /**
    * 设置工作单位
    * @param gzdw
    */
    public void setGzdw(String gzdw) {
        this.gzdw = gzdw;
    }

    /**
    * 获得户籍所在地
    * @return HJSZD
    */
    public String getHjszd() {
        return this.hjszd;
    }

    /**
    * 设置户籍所在地
    * @param hjszd
    */
    public void setHjszd(String hjszd) {
        this.hjszd = hjszd;
    }

    /**
    * 获得现住址
    * @return XZZ
    */
    public String getXzz() {
        return this.xzz;
    }

    /**
    * 设置现住址
    * @param xzz
    */
    public void setXzz(String xzz) {
        this.xzz = xzz;
    }

    /**
    * 获得是否人大
    * @return IS_RDDB
    */
    public String getIsRddb() {
        return this.isRddb;
    }

    /**
    * 设置是否人大
    * @param isRddb
    */
    public void setIsRddb(String isRddb) {
        this.isRddb = isRddb;
    }

    /**
    * 获得笔录类型：0001-正常笔录，0002-关联笔录
    * @return RECORD_TYPE
    */
    public String getRecordType() {
        return this.recordType;
    }

    /**
    * 设置笔录类型：0001-正常笔录，0002-关联笔录
    * @param recordType
    */
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    /**
    * 获得办案单位地点
    * @return BADW_NAME
    */
    public String getBadwName() {
        return this.badwName;
    }

    /**
    * 设置办案单位地点
    * @param badwName
    */
    public void setBadwName(String badwName) {
        this.badwName = badwName;
    }

    /**
    * 获得笔录信息
    * @return RECORDS
    */
    public String getRecords() {
        return this.records;
    }

    /**
    * 设置笔录信息
    * @param records
    */
    public void setRecords(String records) {
        this.records = records;
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