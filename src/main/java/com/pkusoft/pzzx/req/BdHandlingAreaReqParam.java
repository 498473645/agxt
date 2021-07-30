package com.pkusoft.pzzx.req;

import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "BD_HANDLING_AREA")
public class BdHandlingAreaReqParam extends Page {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJCODE")
    private String objcode;     //场所编号

    @Column(name = "OBJNAME")
    private String objname;     //场所名称

    @Column(name = "OBJTYPE")
    private String objtype;     //场所类型

    @Column(name = "AREA")
    private Integer area;     //场所面积

    @Column(name = "ADDRSS")
    private String addrss;     //场所地址

    @Column(name = "ALARM_SCREEN_IP")
    private String alarmScreenIp;     //微信报警信息展示页面所用屏幕ip，多个ip之间用逗号隔开

    @Column(name = "ALARM_SCREEN_PLACE")
    private String alarmScreenPlace;     //微信报警信息展示页面所显示的报警地点，例：东门派出所

    @Column(name = "AREA_TEL")
    private String areaTel;     //改接处警场所的报警电话，例：0713-8695746

    @Column(name = "IF_WECHAT_ALARM")
    private String ifWechatAlarm;     //该接警场所是否有微信接警，0-没有，1-有

    @Column(name = "CHARGE_USER_ID")
    private String chargeUserId;     //负责人用户编号，sys_user.user_id

    @Column(name = "CHARGE_POLICE_CODE")
    private String chargePoliceCode;     //负责人用户警号

    @Column(name = "CHARGE_NAME")
    private String chargeName;     //负责人用户姓名

    @Column(name = "CHARGE_IDCARD")
    private String chargeIdcard;     //负责人用户身份证号码

    @Column(name = "CHARGE_TEL")
    private String chargeTel;     //负责人用户联系方式

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态

    @Column(name = "MEMO")
    private String memo;     //场所介绍

    @Column(name = "ROW_STATUS")
    private String rowStatus;     //数据行状态（0：无效，1：有效）

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

    @Column(name = "RESERVE6")
    private String reserve6;     //预留字段6

    @Column(name = "RESERVE7")
    private String reserve7;     //预留字段7

    @Column(name = "RESERVE8")
    private String reserve8;     //预留字段8

    @Column(name = "RESERVE9")
    private String reserve9;     //预留字段9

    @Column(name = "RESERVE10")
    private String reserve10;     //预留字段10


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
    * 获得场所编号
    * @return OBJCODE
    */
    public String getObjcode() {
        return this.objcode;
    }

    /**
    * 设置场所编号
    * @param objcode
    */
    public void setObjcode(String objcode) {
        this.objcode = objcode;
    }

    /**
    * 获得场所名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置场所名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得场所类型
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置场所类型
    * @param objtype
    */
    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    /**
    * 获得场所面积
    * @return AREA
    */
    public Integer getArea() {
        return this.area;
    }

    /**
    * 设置场所面积
    * @param area
    */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
    * 获得场所地址
    * @return ADDRSS
    */
    public String getAddrss() {
        return this.addrss;
    }

    /**
    * 设置场所地址
    * @param addrss
    */
    public void setAddrss(String addrss) {
        this.addrss = addrss;
    }

    /**
    * 获得微信报警信息展示页面所用屏幕ip，多个ip之间用逗号隔开
    * @return ALARM_SCREEN_IP
    */
    public String getAlarmScreenIp() {
        return this.alarmScreenIp;
    }

    /**
    * 设置微信报警信息展示页面所用屏幕ip，多个ip之间用逗号隔开
    * @param alarmScreenIp
    */
    public void setAlarmScreenIp(String alarmScreenIp) {
        this.alarmScreenIp = alarmScreenIp;
    }

    /**
    * 获得微信报警信息展示页面所显示的报警地点，例：东门派出所
    * @return ALARM_SCREEN_PLACE
    */
    public String getAlarmScreenPlace() {
        return this.alarmScreenPlace;
    }

    /**
    * 设置微信报警信息展示页面所显示的报警地点，例：东门派出所
    * @param alarmScreenPlace
    */
    public void setAlarmScreenPlace(String alarmScreenPlace) {
        this.alarmScreenPlace = alarmScreenPlace;
    }

    /**
    * 获得改接处警场所的报警电话，例：0713-8695746
    * @return AREA_TEL
    */
    public String getAreaTel() {
        return this.areaTel;
    }

    /**
    * 设置改接处警场所的报警电话，例：0713-8695746
    * @param areaTel
    */
    public void setAreaTel(String areaTel) {
        this.areaTel = areaTel;
    }

    /**
    * 获得该接警场所是否有微信接警，0-没有，1-有
    * @return IF_WECHAT_ALARM
    */
    public String getIfWechatAlarm() {
        return this.ifWechatAlarm;
    }

    /**
    * 设置该接警场所是否有微信接警，0-没有，1-有
    * @param ifWechatAlarm
    */
    public void setIfWechatAlarm(String ifWechatAlarm) {
        this.ifWechatAlarm = ifWechatAlarm;
    }

    /**
    * 获得负责人用户编号，sys_user.user_id
    * @return CHARGE_USER_ID
    */
    public String getChargeUserId() {
        return this.chargeUserId;
    }

    /**
    * 设置负责人用户编号，sys_user.user_id
    * @param chargeUserId
    */
    public void setChargeUserId(String chargeUserId) {
        this.chargeUserId = chargeUserId;
    }

    /**
    * 获得负责人用户警号
    * @return CHARGE_POLICE_CODE
    */
    public String getChargePoliceCode() {
        return this.chargePoliceCode;
    }

    /**
    * 设置负责人用户警号
    * @param chargePoliceCode
    */
    public void setChargePoliceCode(String chargePoliceCode) {
        this.chargePoliceCode = chargePoliceCode;
    }

    /**
    * 获得负责人用户姓名
    * @return CHARGE_NAME
    */
    public String getChargeName() {
        return this.chargeName;
    }

    /**
    * 设置负责人用户姓名
    * @param chargeName
    */
    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    /**
    * 获得负责人用户身份证号码
    * @return CHARGE_IDCARD
    */
    public String getChargeIdcard() {
        return this.chargeIdcard;
    }

    /**
    * 设置负责人用户身份证号码
    * @param chargeIdcard
    */
    public void setChargeIdcard(String chargeIdcard) {
        this.chargeIdcard = chargeIdcard;
    }

    /**
    * 获得负责人用户联系方式
    * @return CHARGE_TEL
    */
    public String getChargeTel() {
        return this.chargeTel;
    }

    /**
    * 设置负责人用户联系方式
    * @param chargeTel
    */
    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel;
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
    * 获得场所介绍
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置场所介绍
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
    * 获得数据行状态（0：无效，1：有效）
    * @return ROW_STATUS
    */
    public String getRowStatus() {
        return this.rowStatus;
    }

    /**
    * 设置数据行状态（0：无效，1：有效）
    * @param rowStatus
    */
    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
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

    /**
    * 获得预留字段9
    * @return RESERVE9
    */
    public String getReserve9() {
        return this.reserve9;
    }

    /**
    * 设置预留字段9
    * @param reserve9
    */
    public void setReserve9(String reserve9) {
        this.reserve9 = reserve9;
    }

    /**
    * 获得预留字段10
    * @return RESERVE10
    */
    public String getReserve10() {
        return this.reserve10;
    }

    /**
    * 设置预留字段10
    * @param reserve10
    */
    public void setReserve10(String reserve10) {
        this.reserve10 = reserve10;
    }


}