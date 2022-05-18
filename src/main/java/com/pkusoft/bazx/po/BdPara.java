package com.pkusoft.bazx.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "BD_PARA")
public class BdPara {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJCODE")
    private String objcode;     //参数编号

    @Column(name = "OBJNAME")
    private String objname;     //参数名称

    @Column(name = "OBJTYPE")
    private String objtype;     //参数类型

    @Column(name = "AREA_OBJID")
    private String areaObjid;     //办案区id，bd_handling_area.objid

    @Column(name = "AREA_OBJNAME")
    private String areaObjname;     //办案区名称，bd_handling_area.objname

    @Column(name = "ROOM_OBJID")
    private String roomObjid;     //功能区域id，bd_function_room.objid

    @Column(name = "ROOM_OBJNAME")
    private String roomObjname;     //功能区域名称，bd_function_room.objname

    @Column(name = "PARA_VALUE1")
    private String paraValue1;     //系统参数值1

    @Column(name = "PARA_VALUE2")
    private String paraValue2;     //系统参数值2

    @Column(name = "PARA_VALUE3")
    private String paraValue3;     //系统参数值3
    
    @Column(name = "ENABLE")
    private String enable;     //是否启用

    @Column(name = "VISIABLE")
    private String visiable;     //是否可编辑

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

    @Column(name = "ORG_C")
    private String orgC;     //所属市局

    @Column(name = "ORG_S")
    private String orgS;     //所属分局

    @Column(name = "ORG_T")
    private String orgT;     //所属派出所

    @Column(name = "ORG_C_DATA")
    private String orgCData;     //数据归属市局

    @Column(name = "ORG_S_DATA")
    private String orgSData;     //数据归属分局

    @Column(name = "ORG_T_DATA")
    private String orgTData;     //数据归属派出所


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
    * 获得参数编号
    * @return OBJCODE
    */
    public String getObjcode() {
        return this.objcode;
    }

    /**
    * 设置参数编号
    * @param objcode
    */
    public void setObjcode(String objcode) {
        this.objcode = objcode;
    }

    /**
    * 获得参数名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置参数名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得参数类型
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置参数类型
    * @param objtype
    */
    public void setObjtype(String objtype) {
        this.objtype = objtype;
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
    * 获得系统参数值1
    * @return PARA_VALUE1
    */
    public String getParaValue1() {
        return this.paraValue1;
    }

    /**
    * 设置系统参数值1
    * @param paraValue1
    */
    public void setParaValue1(String paraValue1) {
        this.paraValue1 = paraValue1;
    }

    /**
    * 获得系统参数值2
    * @return PARA_VALUE2
    */
    public String getParaValue2() {
        return this.paraValue2;
    }

    /**
    * 设置系统参数值2
    * @param paraValue2
    */
    public void setParaValue2(String paraValue2) {
        this.paraValue2 = paraValue2;
    }

    /**
    * 获得系统参数值3
    * @return PARA_VALUE3
    */
    public String getParaValue3() {
        return this.paraValue3;
    }

    /**
    * 设置系统参数值3
    * @param paraValue3
    */
    public void setParaValue3(String paraValue3) {
        this.paraValue3 = paraValue3;
    }

    /**
    * 获得是否可编辑
    * @return VISIABLE
    */
    public String getVisiable() {
        return this.visiable;
    }

    /**
    * 设置是否可编辑
    * @param visiable
    */
    public void setVisiable(String visiable) {
        this.visiable = visiable;
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
    * 获得所属市局
    * @return ORG_C
    */
    public String getOrgC() {
        return this.orgC;
    }

    /**
    * 设置所属市局
    * @param orgC
    */
    public void setOrgC(String orgC) {
        this.orgC = orgC;
    }

    /**
    * 获得所属分局
    * @return ORG_S
    */
    public String getOrgS() {
        return this.orgS;
    }

    /**
    * 设置所属分局
    * @param orgS
    */
    public void setOrgS(String orgS) {
        this.orgS = orgS;
    }

    /**
    * 获得所属派出所
    * @return ORG_T
    */
    public String getOrgT() {
        return this.orgT;
    }

    /**
    * 设置所属派出所
    * @param orgT
    */
    public void setOrgT(String orgT) {
        this.orgT = orgT;
    }

    /**
    * 获得数据归属市局
    * @return ORG_C_DATA
    */
    public String getOrgCData() {
        return this.orgCData;
    }

    /**
    * 设置数据归属市局
    * @param orgCData
    */
    public void setOrgCData(String orgCData) {
        this.orgCData = orgCData;
    }

    /**
    * 获得数据归属分局
    * @return ORG_S_DATA
    */
    public String getOrgSData() {
        return this.orgSData;
    }

    /**
    * 设置数据归属分局
    * @param orgSData
    */
    public void setOrgSData(String orgSData) {
        this.orgSData = orgSData;
    }

    /**
    * 获得数据归属派出所
    * @return ORG_T_DATA
    */
    public String getOrgTData() {
        return this.orgTData;
    }

    /**
    * 设置数据归属派出所
    * @param orgTData
    */
    public void setOrgTData(String orgTData) {
        this.orgTData = orgTData;
    }

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
    
    


}