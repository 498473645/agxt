package com.pkusoft.jjpt.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "PI_FACE_MATCH")
public class PiFaceMatch {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJTYPE")
    private String objtype;     //类型（1010：民警，1020：协警，2010：嫌疑人）

    @Column(name = "H_OBJID")
    private String hObjid;     //办案记录id

    @Column(name = "E_ID")
    private String eId;     //设备硬件编号，bd_equipment.e_id

    @Column(name = "E_IP")
    private String eIp;     //设备硬件ip，bd_equipment.e_ip

    @Column(name = "AREA_OBJID")
    private String areaObjid;     //办案区id，bd_handling_area.objid

    @Column(name = "AREA_OBJNAME")
    private String areaObjname;     //办案区名称，bd_handling_area.objname

    @Column(name = "ROOM_OBJID")
    private String roomObjid;     //功能区域id，bd_function_room.objid

    @Column(name = "ROOM_OBJNAME")
    private String roomObjname;     //功能区域名称，bd_function_room.objname

    @Column(name = "THRESHOLD")
    private String threshold;     //人像比对程序阈值

    @Column(name = "DATA_STR")
    private String dataStr;     //接口接受的数据字符串

    @Column(name = "PIC_FACE")
    private String picFace;     //人脸图片路径

    @Column(name = "PIC_SCENE")
    private String picScene;     //场景图片路径

    @Column(name = "ADD_TIME")
    private String addTime;     //人脸图片获取时间

    @Column(name = "PERSON_CODE")
    private String personCode;     //人员编号(民警是存警号)

    @Column(name = "PERSON_NAME")
    private String personName;     //人员姓名

    @Column(name = "PERSON_CARD_TYPE")
    private String personCardType;     //证件类型

    @Column(name = "PERSON_IDCARD")
    private String personIdcard;     //人员身份证号码

    @Column(name = "PERSON_DEPTID")
    private String personDeptid;     //民警所属单位编号

    @Column(name = "PERSON_DEPT_NAME")
    private String personDeptName;     //民警所属单位名称

    @Column(name = "EXAMINE")
    private Integer examine;     //人员核查(二进制位数表示1:是,0:否,第一位:在逃人员,第二位:吸毒人员,第三位:精神病人员,第四位:违法犯罪人员,第五位:全国重点人员)

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态 1000 - 未处理 1010 - 已入区登记

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "ROW_STATUS")
    private String rowStatus;     //数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用

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

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2

    @Column(name = "RESERVE3")
    private String reserve3;     //预留字段3


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
    * 获得类型（1010：民警，1020：协警，2010：嫌疑人）
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置类型（1010：民警，1020：协警，2010：嫌疑人）
    * @param objtype
    */
    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    /**
    * 获得办案记录id
    * @return H_OBJID
    */
    public String getHObjid() {
        return this.hObjid;
    }

    /**
    * 设置办案记录id
    * @param hObjid
    */
    public void setHObjid(String hObjid) {
        this.hObjid = hObjid;
    }

    /**
    * 获得设备硬件编号，bd_equipment.e_id
    * @return E_ID
    */
    public String getEId() {
        return this.eId;
    }

    /**
    * 设置设备硬件编号，bd_equipment.e_id
    * @param eId
    */
    public void setEId(String eId) {
        this.eId = eId;
    }

    /**
    * 获得设备硬件ip，bd_equipment.e_ip
    * @return E_IP
    */
    public String getEIp() {
        return this.eIp;
    }

    /**
    * 设置设备硬件ip，bd_equipment.e_ip
    * @param eIp
    */
    public void setEIp(String eIp) {
        this.eIp = eIp;
    }

    /**
    * 获得办案区id，bd_handling_area.objid
    * @return AREA_OBJID
    */
    public String getAreaObjid() {
        return this.areaObjid;
    }

    /**
    * 设置办案区id，bd_handling_area.objid
    * @param areaObjid
    */
    public void setAreaObjid(String areaObjid) {
        this.areaObjid = areaObjid;
    }

    /**
    * 获得办案区名称，bd_handling_area.objname
    * @return AREA_OBJNAME
    */
    public String getAreaObjname() {
        return this.areaObjname;
    }

    /**
    * 设置办案区名称，bd_handling_area.objname
    * @param areaObjname
    */
    public void setAreaObjname(String areaObjname) {
        this.areaObjname = areaObjname;
    }

    /**
    * 获得功能区域id，bd_function_room.objid
    * @return ROOM_OBJID
    */
    public String getRoomObjid() {
        return this.roomObjid;
    }

    /**
    * 设置功能区域id，bd_function_room.objid
    * @param roomObjid
    */
    public void setRoomObjid(String roomObjid) {
        this.roomObjid = roomObjid;
    }

    /**
    * 获得功能区域名称，bd_function_room.objname
    * @return ROOM_OBJNAME
    */
    public String getRoomObjname() {
        return this.roomObjname;
    }

    /**
    * 设置功能区域名称，bd_function_room.objname
    * @param roomObjname
    */
    public void setRoomObjname(String roomObjname) {
        this.roomObjname = roomObjname;
    }

    /**
    * 获得人像比对程序阈值
    * @return THRESHOLD
    */
    public String getThreshold() {
        return this.threshold;
    }

    /**
    * 设置人像比对程序阈值
    * @param threshold
    */
    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    /**
    * 获得接口接受的数据字符串
    * @return DATA_STR
    */
    public String getDataStr() {
        return this.dataStr;
    }

    /**
    * 设置接口接受的数据字符串
    * @param dataStr
    */
    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    /**
    * 获得人脸图片路径
    * @return PIC_FACE
    */
    public String getPicFace() {
        return this.picFace;
    }

    /**
    * 设置人脸图片路径
    * @param picFace
    */
    public void setPicFace(String picFace) {
        this.picFace = picFace;
    }

    /**
    * 获得场景图片路径
    * @return PIC_SCENE
    */
    public String getPicScene() {
        return this.picScene;
    }

    /**
    * 设置场景图片路径
    * @param picScene
    */
    public void setPicScene(String picScene) {
        this.picScene = picScene;
    }

    /**
    * 获得人脸图片获取时间
    * @return ADD_TIME
    */
    public String getAddTime() {
        return this.addTime;
    }

    /**
    * 设置人脸图片获取时间
    * @param addTime
    */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
    * 获得人员编号(民警是存警号)
    * @return PERSON_CODE
    */
    public String getPersonCode() {
        return this.personCode;
    }

    /**
    * 设置人员编号(民警是存警号)
    * @param personCode
    */
    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    /**
    * 获得人员姓名
    * @return PERSON_NAME
    */
    public String getPersonName() {
        return this.personName;
    }

    /**
    * 设置人员姓名
    * @param personName
    */
    public void setPersonName(String personName) {
        this.personName = personName;
    }

    /**
    * 获得证件类型
    * @return PERSON_CARD_TYPE
    */
    public String getPersonCardType() {
        return this.personCardType;
    }

    /**
    * 设置证件类型
    * @param personCardType
    */
    public void setPersonCardType(String personCardType) {
        this.personCardType = personCardType;
    }

    /**
    * 获得人员身份证号码
    * @return PERSON_IDCARD
    */
    public String getPersonIdcard() {
        return this.personIdcard;
    }

    /**
    * 设置人员身份证号码
    * @param personIdcard
    */
    public void setPersonIdcard(String personIdcard) {
        this.personIdcard = personIdcard;
    }

    /**
    * 获得民警所属单位编号
    * @return PERSON_DEPTID
    */
    public String getPersonDeptid() {
        return this.personDeptid;
    }

    /**
    * 设置民警所属单位编号
    * @param personDeptid
    */
    public void setPersonDeptid(String personDeptid) {
        this.personDeptid = personDeptid;
    }

    /**
    * 获得民警所属单位名称
    * @return PERSON_DEPT_NAME
    */
    public String getPersonDeptName() {
        return this.personDeptName;
    }

    /**
    * 设置民警所属单位名称
    * @param personDeptName
    */
    public void setPersonDeptName(String personDeptName) {
        this.personDeptName = personDeptName;
    }

    /**
    * 获得人员核查(二进制位数表示1:是,0:否,第一位:在逃人员,第二位:吸毒人员,第三位:精神病人员,第四位:违法犯罪人员,第五位:全国重点人员)
    * @return EXAMINE
    */
    public Integer getExamine() {
        return this.examine;
    }

    /**
    * 设置人员核查(二进制位数表示1:是,0:否,第一位:在逃人员,第二位:吸毒人员,第三位:精神病人员,第四位:违法犯罪人员,第五位:全国重点人员)
    * @param examine
    */
    public void setExamine(Integer examine) {
        this.examine = examine;
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
    * 获得状态 1000 - 未处理 1010 - 已入区登记
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态 1000 - 未处理 1010 - 已入区登记
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
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
    * 获得数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用
    * @return ROW_STATUS
    */
    public String getRowStatus() {
        return this.rowStatus;
    }

    /**
    * 设置数据行状态  0 - 不可见，不可用 1 - 可见 2 - 可用
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

    public String getGaOwnerDept1() {
        return gaOwnerDept1;
    }

    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    public String getGaOwnerDept2() {
        return gaOwnerDept2;
    }

    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    public String getGaOwnerDept3() {
        return gaOwnerDept3;
    }

    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    public String getGaOwnerDept4() {
        return gaOwnerDept4;
    }

    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    public String getGaOwnerDept5() {
        return gaOwnerDept5;
    }

    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
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


}
