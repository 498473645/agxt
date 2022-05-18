package com.pkusoft.bazx.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "BD_CAMERA")
public class BdCamera {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJCODE")
    private String objcode;     //摄像头编号

    @Column(name = "OBJNAME")
    private String objname;     //摄像头名称

    @Column(name = "OBJTYPE")
    private String objtype;     //摄像头类型

    @Column(name = "AREA_OBJID")
    private String areaObjid;     //办案区id，bd_handling_area.objid

    @Column(name = "AREA_OBJNAME")
    private String areaObjname;     //办案区名称，bd_handling_area.objname

    @Column(name = "ROOM_OBJID")
    private String roomObjid;     //功能区域id，bd_function_room.objid

    @Column(name = "ROOM_OBJNAME")
    private String roomObjname;     //功能区域名称，bd_function_room.objname

    @Column(name = "CAMERA_SUPPLIER")
    private String cameraSupplier;     //摄像机供应商（1010：海康，1020：科达，1030：大华）

    @Column(name = "P_C")
    private String pC;     //全景或特写（1010：全景摄像头，1020：特写摄像头）

    @Column(name = "CAMERA_INFO")
    private String cameraInfo;     //摄像头信息（ip，用户名，密码等信息，用/分隔）

    @Column(name = "IS_STREAMING")
    private String isStreaming;     //是否接入流媒体（1：是，0：否）

    @Column(name = "IS_TRACE")
    private String isTrace;     //是否在视随人动功能调用该摄像头（1：是，0：否）

    @Column(name = "IS_VISUALIZE")
    private String isVisualize;     //是否在可视化管理页面调用该摄像头（1：是，0：否）

    @Column(name = "RTSP")
    private String rtsp;     //rtsp数据

    @Column(name = "CAD_XY")
    private String cadXy;     //CAD上坐标，示例：10.20,10.23

    @Column(name = "BG_XY")
    private String bgXy;     //背景图坐标，示例：10,20

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属机构编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属机构名称

    @Column(name = "STATUS")
    private String status;     //状态

    @Column(name = "MEMO")
    private String memo;     //设备说明

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
    * 获得摄像头编号
    * @return OBJCODE
    */
    public String getObjcode() {
        return this.objcode;
    }

    /**
    * 设置摄像头编号
    * @param objcode
    */
    public void setObjcode(String objcode) {
        this.objcode = objcode;
    }

    /**
    * 获得摄像头名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置摄像头名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得摄像头类型
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置摄像头类型
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
    * 获得摄像机供应商（1010：海康，1020：科达，1030：大华）
    * @return CAMERA_SUPPLIER
    */
    public String getCameraSupplier() {
        return this.cameraSupplier;
    }

    /**
    * 设置摄像机供应商（1010：海康，1020：科达，1030：大华）
    * @param cameraSupplier
    */
    public void setCameraSupplier(String cameraSupplier) {
        this.cameraSupplier = cameraSupplier;
    }

    /**
    * 获得全景或特写（1010：全景摄像头，1020：特写摄像头）
    * @return P_C
    */
    public String getPC() {
        return this.pC;
    }

    /**
    * 设置全景或特写（1010：全景摄像头，1020：特写摄像头）
    * @param pC
    */
    public void setPC(String pC) {
        this.pC = pC;
    }

    /**
    * 获得摄像头信息（ip，用户名，密码等信息，用/分隔）
    * @return CAMERA_INFO
    */
    public String getCameraInfo() {
        return this.cameraInfo;
    }

    /**
    * 设置摄像头信息（ip，用户名，密码等信息，用/分隔）
    * @param cameraInfo
    */
    public void setCameraInfo(String cameraInfo) {
        this.cameraInfo = cameraInfo;
    }

    /**
    * 获得是否接入流媒体（1：是，0：否）
    * @return IS_STREAMING
    */
    public String getIsStreaming() {
        return this.isStreaming;
    }

    /**
    * 设置是否接入流媒体（1：是，0：否）
    * @param isStreaming
    */
    public void setIsStreaming(String isStreaming) {
        this.isStreaming = isStreaming;
    }

    /**
    * 获得是否在视随人动功能调用该摄像头（1：是，0：否）
    * @return IS_TRACE
    */
    public String getIsTrace() {
        return this.isTrace;
    }

    /**
    * 设置是否在视随人动功能调用该摄像头（1：是，0：否）
    * @param isTrace
    */
    public void setIsTrace(String isTrace) {
        this.isTrace = isTrace;
    }

    /**
    * 获得是否在可视化管理页面调用该摄像头（1：是，0：否）
    * @return IS_VISUALIZE
    */
    public String getIsVisualize() {
        return this.isVisualize;
    }

    /**
    * 设置是否在可视化管理页面调用该摄像头（1：是，0：否）
    * @param isVisualize
    */
    public void setIsVisualize(String isVisualize) {
        this.isVisualize = isVisualize;
    }

    /**
    * 获得rtsp数据
    * @return RTSP
    */
    public String getRtsp() {
        return this.rtsp;
    }

    /**
    * 设置rtsp数据
    * @param rtsp
    */
    public void setRtsp(String rtsp) {
        this.rtsp = rtsp;
    }

    /**
    * 获得CAD上坐标，示例：10.20,10.23
    * @return CAD_XY
    */
    public String getCadXy() {
        return this.cadXy;
    }

    /**
    * 设置CAD上坐标，示例：10.20,10.23
    * @param cadXy
    */
    public void setCadXy(String cadXy) {
        this.cadXy = cadXy;
    }

    /**
    * 获得背景图坐标，示例：10,20
    * @return BG_XY
    */
    public String getBgXy() {
        return this.bgXy;
    }

    /**
    * 设置背景图坐标，示例：10,20
    * @param bgXy
    */
    public void setBgXy(String bgXy) {
        this.bgXy = bgXy;
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