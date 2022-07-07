package com.pkusoft.jjpt.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: SpMedia
 */
@ApiModel("审讯视音频信息表")
@Table(name = "SP_MEDIA")
public class SpMediaReqParam extends Page {

 	/**
     * 主键ID
     */
    @Id
    @Column(name = "OBJID")
    @ApiModelProperty(value = "主键ID")
    private String objid;

 	/**
     * 接警信息表OBJID，SP_JJXX.OBJID
     */
    @Column(name = "J_OBJID")
    @ApiModelProperty(value = "接警信息表OBJID，SP_JJXX.OBJID")
    private String jObjid;

 	/**
     * 类型. 0010-接警录像; 1010-笔录签名录像; 1020-处警录像
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "类型. 0010-接警录像; 1010-笔录签名录像; 1020-处警录像")
    private String type;

 	/**
     * 序号
     */
    @Column(name = "SN")
    @ApiModelProperty(value = "序号")
    private Integer sn;

 	/**
     * 开始时间
     */
    @Column(name = "BEGIN_TIME")
    @ApiModelProperty(value = "开始时间")
    private java.util.Date beginTime;

 	/**
     * 结束时间
     */
    @Column(name = "END_TIME")
    @ApiModelProperty(value = "结束时间")
    private java.util.Date endTime;

 	/**
     * 数据来源类型. 0010-SVR; 0020-NVR; 0030-InnoMTS; 0040-云审讯主机;0050-执法记录仪; 1000-Hadoop; 9000-本地文件
     */
    @Column(name = "SRC_TYPE")
    @ApiModelProperty(value = "数据来源类型. 0010-SVR; 0020-NVR; 0030-InnoMTS; 0040-云审讯主机;0050-执法记录仪; 1000-Hadoop; 9000-本地文件")
    private String srcType;

 	/**
     * 数据来源. 当类型为SVR和NVR时存储IP和通道编号; 类型为InnoMTS时存储URL和通道编号; 类型为本地文件时存储路径文件名
     */
    @Column(name = "SRC")
    @ApiModelProperty(value = "数据来源. 当类型为SVR和NVR时存储IP和通道编号; 类型为InnoMTS时存储URL和通道编号; 类型为本地文件时存储路径文件名")
    private String src;

 	/**
     * 审讯人1编号
     */
    @Column(name = "INQER1_CODE")
    @ApiModelProperty(value = "审讯人1编号")
    private String inqer1Code;

 	/**
     * 审讯人1姓名
     */
    @Column(name = "INQER1_NAME")
    @ApiModelProperty(value = "审讯人1姓名")
    private String inqer1Name;

 	/**
     * 审讯人2编号
     */
    @Column(name = "INQER2_CODE")
    @ApiModelProperty(value = "审讯人2编号")
    private String inqer2Code;

 	/**
     * 审讯人2姓名
     */
    @Column(name = "INQER2_NAME")
    @ApiModelProperty(value = "审讯人2姓名")
    private String inqer2Name;

 	/**
     * 记录员编号
     */
    @Column(name = "RECER_CODE")
    @ApiModelProperty(value = "记录员编号")
    private String recerCode;

 	/**
     * 记录员姓名
     */
    @Column(name = "RECER_NAME")
    @ApiModelProperty(value = "记录员姓名")
    private String recerName;

 	/**
     * 状态. 0010-已创建; 0020-录制中; 9000-已结束
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态. 0010-已创建; 0020-录制中; 9000-已结束")
    private String status;

 	/**
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo;

 	/**
     * 数据行状态（0 - 不可见，不可用; 1 - 可见; 2 - 可用）
     */
    @Column(name = "ROW_STATUS")
    @ApiModelProperty(value = "数据行状态（0 - 不可见，不可用; 1 - 可见; 2 - 可用）")
    private String rowStatus;

 	/**
     * 创建者ID
     */
    @Column(name = "CREATE_ID")
    @ApiModelProperty(value = "创建者ID")
    private String createId;

 	/**
     * 创建者名称
     */
    @Column(name = "CREATE_NAME")
    @ApiModelProperty(value = "创建者名称")
    private String createName;

 	/**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;

 	/**
     * 最后修改者ID
     */
    @Column(name = "MODER_ID")
    @ApiModelProperty(value = "最后修改者ID")
    private String moderId;

 	/**
     * 最后修改者名称
     */
    @Column(name = "MODER_NAME")
    @ApiModelProperty(value = "最后修改者名称")
    private String moderName;

 	/**
     * 最后修改时间
     */
    @Column(name = "MODER_TIME")
    @ApiModelProperty(value = "最后修改时间")
    private java.util.Date moderTime;

 	/**
     * 公安一级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安一级归属单位")
    private String gaOwnerDept1;

 	/**
     * 公安二级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安二级归属单位")
    private String gaOwnerDept2;

 	/**
     * 公安三级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安三级归属单位")
    private String gaOwnerDept3;

 	/**
     * 公安四级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安四级归属单位")
    private String gaOwnerDept4;

 	/**
     * 公安五级归属单位
     */
    @Column(name = "GA_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安五级归属单位")
    private String gaOwnerDept5;

 	/**
     * 预留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "预留字段1")
    private String reserve1;

 	/**
     * 预留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "预留字段2")
    private String reserve2;

 	/**
     * 预留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "预留字段3")
    private String reserve3;

 	/**
     * 所属机构编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属机构编码")
    private String orgCode;

 	/**
     * 所属机构名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "所属机构名称")
    private String orgName;

 	/**
     * 房间编码
     */
    @Column(name = "ROOM_ID")
    @ApiModelProperty(value = "房间编码")
    private String roomId;

 	/**
     * 房间名称
     */
    @Column(name = "ROOM_NAME")
    @ApiModelProperty(value = "房间名称")
    private String roomName;


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
    * 获得接警信息表OBJID，SP_JJXX.OBJID
    * @return J_OBJID
    */
    public String getJObjid() {
        return this.jObjid;
    }

    /**
    * 设置接警信息表OBJID，SP_JJXX.OBJID
    * @param jObjid
    */
    public void setJObjid(String jObjid) {
        this.jObjid = jObjid;
    }

    /**
    * 获得类型. 0010-接警录像; 1010-笔录签名录像; 1020-处警录像
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型. 0010-接警录像; 1010-笔录签名录像; 1020-处警录像
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得序号
    * @return SN
    */
    public Integer getSn() {
        return this.sn;
    }

    /**
    * 设置序号
    * @param sn
    */
    public void setSn(Integer sn) {
        this.sn = sn;
    }

    /**
    * 获得开始时间
    * @return BEGIN_TIME
    */
    public java.util.Date getBeginTime() {
        return this.beginTime;
    }

    /**
    * 设置开始时间
    * @param beginTime
    */
    public void setBeginTime(java.util.Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
    * 获得结束时间
    * @return END_TIME
    */
    public java.util.Date getEndTime() {
        return this.endTime;
    }

    /**
    * 设置结束时间
    * @param endTime
    */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }

    /**
    * 获得数据来源类型. 0010-SVR; 0020-NVR; 0030-InnoMTS; 0040-云审讯主机;0050-执法记录仪; 1000-Hadoop; 9000-本地文件
    * @return SRC_TYPE
    */
    public String getSrcType() {
        return this.srcType;
    }

    /**
    * 设置数据来源类型. 0010-SVR; 0020-NVR; 0030-InnoMTS; 0040-云审讯主机;0050-执法记录仪; 1000-Hadoop; 9000-本地文件
    * @param srcType
    */
    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    /**
    * 获得数据来源. 当类型为SVR和NVR时存储IP和通道编号; 类型为InnoMTS时存储URL和通道编号; 类型为本地文件时存储路径文件名
    * @return SRC
    */
    public String getSrc() {
        return this.src;
    }

    /**
    * 设置数据来源. 当类型为SVR和NVR时存储IP和通道编号; 类型为InnoMTS时存储URL和通道编号; 类型为本地文件时存储路径文件名
    * @param src
    */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
    * 获得审讯人1编号
    * @return INQER1_CODE
    */
    public String getInqer1Code() {
        return this.inqer1Code;
    }

    /**
    * 设置审讯人1编号
    * @param inqer1Code
    */
    public void setInqer1Code(String inqer1Code) {
        this.inqer1Code = inqer1Code;
    }

    /**
    * 获得审讯人1姓名
    * @return INQER1_NAME
    */
    public String getInqer1Name() {
        return this.inqer1Name;
    }

    /**
    * 设置审讯人1姓名
    * @param inqer1Name
    */
    public void setInqer1Name(String inqer1Name) {
        this.inqer1Name = inqer1Name;
    }

    /**
    * 获得审讯人2编号
    * @return INQER2_CODE
    */
    public String getInqer2Code() {
        return this.inqer2Code;
    }

    /**
    * 设置审讯人2编号
    * @param inqer2Code
    */
    public void setInqer2Code(String inqer2Code) {
        this.inqer2Code = inqer2Code;
    }

    /**
    * 获得审讯人2姓名
    * @return INQER2_NAME
    */
    public String getInqer2Name() {
        return this.inqer2Name;
    }

    /**
    * 设置审讯人2姓名
    * @param inqer2Name
    */
    public void setInqer2Name(String inqer2Name) {
        this.inqer2Name = inqer2Name;
    }

    /**
    * 获得记录员编号
    * @return RECER_CODE
    */
    public String getRecerCode() {
        return this.recerCode;
    }

    /**
    * 设置记录员编号
    * @param recerCode
    */
    public void setRecerCode(String recerCode) {
        this.recerCode = recerCode;
    }

    /**
    * 获得记录员姓名
    * @return RECER_NAME
    */
    public String getRecerName() {
        return this.recerName;
    }

    /**
    * 设置记录员姓名
    * @param recerName
    */
    public void setRecerName(String recerName) {
        this.recerName = recerName;
    }

    /**
    * 获得状态. 0010-已创建; 0020-录制中; 9000-已结束
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态. 0010-已创建; 0020-录制中; 9000-已结束
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
    * 获得数据行状态（0 - 不可见，不可用; 1 - 可见; 2 - 可用）
    * @return ROW_STATUS
    */
    public String getRowStatus() {
        return this.rowStatus;
    }

    /**
    * 设置数据行状态（0 - 不可见，不可用; 1 - 可见; 2 - 可用）
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
    * 获得房间编码
    * @return ROOM_ID
    */
    public String getRoomId() {
        return this.roomId;
    }

    /**
    * 设置房间编码
    * @param roomId
    */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
    * 获得房间名称
    * @return ROOM_NAME
    */
    public String getRoomName() {
        return this.roomName;
    }

    /**
    * 设置房间名称
    * @param roomName
    */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


}
