package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysDept
 */
@ApiModel("部门表")
@Table(name = "SYS_DEPT")
public class SysDept {

    /**
     * 部门标识号
     */
    @Id
    @Column(name = "DEPT_ID")
    @ApiModelProperty(value = "部门标识号")
    private String deptId;

    /**
     * 部门名称
     */
    @Column(name = "DEPT_NAME")
    @ApiModelProperty(value = "部门名称")
    private String deptName;

    /**
     * 部门级别
     */
    @Column(name = "DEPT_LEVEL")
    @ApiModelProperty(value = "部门级别")
    private String deptLevel;

    /**
     * 机构树级别
     */
    @Column(name = "TREE_LEVEL")
    @ApiModelProperty(value = "机构树级别")
    private Integer treeLevel;

    /**
     * 上级部门标识号
     */
    @Column(name = "PARENT_DEPT_ID")
    @ApiModelProperty(value = "上级部门标识号")
    private String parentDeptId;

    /**
     * 排序
     */
    @Column(name = "ORDER_FLAG")
    @ApiModelProperty(value = "排序")
    private Integer orderFlag;

    /**
     * 电话
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "电话")
    private String tel;

    /**
     * 传真
     */
    @Column(name = "FAX")
    @ApiModelProperty(value = "传真")
    private String fax;

    /**
     * 是否为主管单位
     */
    @Column(name = "IS_MAIN_DEPT")
    @ApiModelProperty(value = "是否为主管单位")
    private String isMainDept;

    /**
     * 所属市局
     */
    @Column(name = "CUNITID")
    @ApiModelProperty(value = "所属市局")
    private String cunitid;

    /**
     * 所属分局
     */
    @Column(name = "SUNITID")
    @ApiModelProperty(value = "所属分局")
    private String sunitid;

    /**
     * 所属派出所
     */
    @Column(name = "TUNITID")
    @ApiModelProperty(value = "所属派出所")
    private String tunitid;

    /**
     * 数据归属市局
     */
    @Column(name = "DATA_CUNITID")
    @ApiModelProperty(value = "数据归属市局")
    private String dataCunitid;

    /**
     * 数据归属分局
     */
    @Column(name = "DATA_SUNITID")
    @ApiModelProperty(value = "数据归属分局")
    private String dataSunitid;

    /**
     * 数据归属派出所
     */
    @Column(name = "DATA_TUNITID")
    @ApiModelProperty(value = "数据归属派出所")
    private String dataTunitid;

    /**
     * 预留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "预留字段1")
    private String reserve1;

    /**
     * 31分局，32市局直属局，33市局直属单位，41派出所，42分局直属单位
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "31分局，32市局直属局，33市局直属单位，41派出所，42分局直属单位")
    private String reserve2;

    /**
     * 预留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "预留字段3")
    private String reserve3;

    /**
     * 是否办案单位（1 是，2否）
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "是否办案单位（1 是，2否）")
    private String reserve4;

    /**
     * 预留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "预留字段5")
    private String reserve5;

    /**
     * 负责人
     */
    @Column(name = "MANAGER")
    @ApiModelProperty(value = "负责人")
    private String manager;

    /**
     * 部门类型
     */
    @Column(name = "DEPT_TYPE")
    @ApiModelProperty(value = "部门类型")
    private String deptType;

    /**
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 录入用户姓名
     */
    @Column(name = "ADD_USER_NAME")
    @ApiModelProperty(value = "录入用户姓名")
    private String addUserName;

    /**
     * 录入时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "录入时间")
    private java.util.Date addTime;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime;

    /**
     * 所属省市县区
     */
    @Column(name = "SSXQ")
    @ApiModelProperty(value = "所属省市县区")
    private String ssxq;

    /**
     * 状态（0.停用，1.正常）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态（0.停用，1.正常）")
    private String status;

    /**
     * 录入人编号
     */
    @Column(name = "ADD_USER_ID")
    @ApiModelProperty(value = "录入人编号")
    private String addUserId;

    /**
     * 修改用户编号
     */
    @Column(name = "MODIFY_USER_ID")
    @ApiModelProperty(value = "修改用户编号")
    private String modifyUserId;

    /**
     * 修改用户姓名
     */
    @Column(name = "MODIFY_USER_NAME")
    @ApiModelProperty(value = "修改用户姓名")
    private String modifyUserName;

    /**
     * 法律文书单位简称
     */
    @Column(name = "FLWS_DWJC")
    @ApiModelProperty(value = "法律文书单位简称")
    private String flwsDwjc;


    /**
     * 获得部门标识号
     * @return DEPT_ID
     */
    public String getDeptId() {
        return this.deptId;
    }

    /**
     * 设置部门标识号
     * @param deptId
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获得部门名称
     * @return DEPT_NAME
     */
    public String getDeptName() {
        return this.deptName;
    }

    /**
     * 设置部门名称
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获得部门级别
     * @return DEPT_LEVEL
     */
    public String getDeptLevel() {
        return this.deptLevel;
    }

    /**
     * 设置部门级别
     * @param deptLevel
     */
    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    /**
     * 获得机构树级别
     * @return TREE_LEVEL
     */
    public Integer getTreeLevel() {
        return this.treeLevel;
    }

    /**
     * 设置机构树级别
     * @param treeLevel
     */
    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * 获得上级部门标识号
     * @return PARENT_DEPT_ID
     */
    public String getParentDeptId() {
        return this.parentDeptId;
    }

    /**
     * 设置上级部门标识号
     * @param parentDeptId
     */
    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    /**
     * 获得排序
     * @return ORDER_FLAG
     */
    public Integer getOrderFlag() {
        return this.orderFlag;
    }

    /**
     * 设置排序
     * @param orderFlag
     */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    /**
     * 获得电话
     * @return TEL
     */
    public String getTel() {
        return this.tel;
    }

    /**
     * 设置电话
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获得传真
     * @return FAX
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * 设置传真
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 获得是否为主管单位
     * @return IS_MAIN_DEPT
     */
    public String getIsMainDept() {
        return this.isMainDept;
    }

    /**
     * 设置是否为主管单位
     * @param isMainDept
     */
    public void setIsMainDept(String isMainDept) {
        this.isMainDept = isMainDept;
    }

    /**
     * 获得所属市局
     * @return CUNITID
     */
    public String getCunitid() {
        return this.cunitid;
    }

    /**
     * 设置所属市局
     * @param cunitid
     */
    public void setCunitid(String cunitid) {
        this.cunitid = cunitid;
    }

    /**
     * 获得所属分局
     * @return SUNITID
     */
    public String getSunitid() {
        return this.sunitid;
    }

    /**
     * 设置所属分局
     * @param sunitid
     */
    public void setSunitid(String sunitid) {
        this.sunitid = sunitid;
    }

    /**
     * 获得所属派出所
     * @return TUNITID
     */
    public String getTunitid() {
        return this.tunitid;
    }

    /**
     * 设置所属派出所
     * @param tunitid
     */
    public void setTunitid(String tunitid) {
        this.tunitid = tunitid;
    }

    /**
     * 获得数据归属市局
     * @return DATA_CUNITID
     */
    public String getDataCunitid() {
        return this.dataCunitid;
    }

    /**
     * 设置数据归属市局
     * @param dataCunitid
     */
    public void setDataCunitid(String dataCunitid) {
        this.dataCunitid = dataCunitid;
    }

    /**
     * 获得数据归属分局
     * @return DATA_SUNITID
     */
    public String getDataSunitid() {
        return this.dataSunitid;
    }

    /**
     * 设置数据归属分局
     * @param dataSunitid
     */
    public void setDataSunitid(String dataSunitid) {
        this.dataSunitid = dataSunitid;
    }

    /**
     * 获得数据归属派出所
     * @return DATA_TUNITID
     */
    public String getDataTunitid() {
        return this.dataTunitid;
    }

    /**
     * 设置数据归属派出所
     * @param dataTunitid
     */
    public void setDataTunitid(String dataTunitid) {
        this.dataTunitid = dataTunitid;
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
     * 获得31分局，32市局直属局，33市局直属单位，41派出所，42分局直属单位
     * @return RESERVE2
     */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
     * 设置31分局，32市局直属局，33市局直属单位，41派出所，42分局直属单位
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
     * 获得是否办案单位（1 是，2否）
     * @return RESERVE4
     */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
     * 设置是否办案单位（1 是，2否）
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
     * 获得负责人
     * @return MANAGER
     */
    public String getManager() {
        return this.manager;
    }

    /**
     * 设置负责人
     * @param manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 获得部门类型
     * @return DEPT_TYPE
     */
    public String getDeptType() {
        return this.deptType;
    }

    /**
     * 设置部门类型
     * @param deptType
     */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
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
     * 获得录入用户姓名
     * @return ADD_USER_NAME
     */
    public String getAddUserName() {
        return this.addUserName;
    }

    /**
     * 设置录入用户姓名
     * @param addUserName
     */
    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    /**
     * 获得录入时间
     * @return ADD_TIME
     */
    public java.util.Date getAddTime() {
        return this.addTime;
    }

    /**
     * 设置录入时间
     * @param addTime
     */
    public void setAddTime(java.util.Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获得修改时间
     * @return MODIFY_TIME
     */
    public java.util.Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 设置修改时间
     * @param modifyTime
     */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获得所属省市县区
     * @return SSXQ
     */
    public String getSsxq() {
        return this.ssxq;
    }

    /**
     * 设置所属省市县区
     * @param ssxq
     */
    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    /**
     * 获得状态（0.停用，1.正常）
     * @return STATUS
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * 设置状态（0.停用，1.正常）
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获得录入人编号
     * @return ADD_USER_ID
     */
    public String getAddUserId() {
        return this.addUserId;
    }

    /**
     * 设置录入人编号
     * @param addUserId
     */
    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    /**
     * 获得修改用户编号
     * @return MODIFY_USER_ID
     */
    public String getModifyUserId() {
        return this.modifyUserId;
    }

    /**
     * 设置修改用户编号
     * @param modifyUserId
     */
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
     * 获得修改用户姓名
     * @return MODIFY_USER_NAME
     */
    public String getModifyUserName() {
        return this.modifyUserName;
    }

    /**
     * 设置修改用户姓名
     * @param modifyUserName
     */
    public void setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
    }

    /**
     * 获得法律文书单位简称
     * @return FLWS_DWJC
     */
    public String getFlwsDwjc() {
        return this.flwsDwjc;
    }

    /**
     * 设置法律文书单位简称
     * @param flwsDwjc
     */
    public void setFlwsDwjc(String flwsDwjc) {
        this.flwsDwjc = flwsDwjc;
    }


}
