package com.pkusoft.pzzx.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "BD_EQUIPMENT")
public class BdEquipment {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJNAME")
    private String objname;     //设备名称

    @Column(name = "OBJTYPE")
    private String objtype;     //设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头

    @Column(name = "E_ID")
    private String eId;     //设备唯一标识码

    @Column(name = "SN")
    private Integer sn;     //排序序号

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态

    @Column(name = "MEMO")
    private String memo;     //设备说明

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

    @Column(name = "OWNER_TYPE")
    private String ownerType;     //归属单位类型（1-公安单位；2-业务单位）

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

    @Column(name = "AREA_ID")
    private String areaId;     //场所id

    @Column(name = "AREA_NAME")
    private String areaName;     //场所id

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
    * 获得设备名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置设备名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头
    * @param objtype
    */
    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    /**
    * 获得设备唯一标识码
    * @return E_ID
    */
    public String getEId() {
        return this.eId;
    }

    /**
    * 设置设备唯一标识码
    * @param eId
    */
    public void setEId(String eId) {
        this.eId = eId;
    }

    /**
    * 获得排序序号
    * @return SN
    */
    public Integer getSn() {
        return this.sn;
    }

    /**
    * 设置排序序号
    * @param sn
    */
    public void setSn(Integer sn) {
        this.sn = sn;
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
    * 获得设备说明
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置设备说明
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
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
