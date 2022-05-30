package com.pkusoft.rkxt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 
 * @title: XtBizType 
 */
@ApiModel("系统业务类型信息表")
@Table(name = "XT_BIZ_TYPE")
public class XtBizType {

 	/**
     * 流水号（主键）
     */
    @Id
    @Column(name = "LSH")
    @ApiModelProperty(value = "流水号（主键）")
    private String lsh; 

 	/**
     * 业务编号
     */
    @Column(name = "BIZ_NO")
    @ApiModelProperty(value = "业务编号")
    private String bizNo; 

 	/**
     * 父级业务类型编号
     */
    @Column(name = "BIZ_PARENT_NO")
    @ApiModelProperty(value = "父级业务类型编号")
    private String bizParentNo; 

 	/**
     * 业务名称来源（1-业务办理，2-业务预约）
     */
    @Column(name = "BIZ_SOURCE")
    @ApiModelProperty(value = "业务名称来源（1-业务办理，2-业务预约）")
    private String bizSource; 

 	/**
     * 业务名称
     */
    @Column(name = "BIZ_NAME")
    @ApiModelProperty(value = "业务名称")
    private String bizName; 

 	/**
     * 业务名称分类
     */
    @Column(name = "BIZ_TYPE")
    @ApiModelProperty(value = "业务名称分类")
    private String bizType; 

 	/**
     * 业务名称级别
     */
    @Column(name = "BIZ_LEVEL")
    @ApiModelProperty(value = "业务名称级别")
    private String bizLevel; 

 	/**
     * 业务名称图标
     */
    @Column(name = "BIZ_ICON")
    @ApiModelProperty(value = "业务名称图标")
    private String bizIcon; 

 	/**
     * 业务名称图标颜色
     */
    @Column(name = "BIZ_ICON_COLOR")
    @ApiModelProperty(value = "业务名称图标颜色")
    private String bizIconColor; 

 	/**
     * 业务名称显示排序
     */
    @Column(name = "BIZ_ORDER")
    @ApiModelProperty(value = "业务名称显示排序")
    private Integer bizOrder; 

 	/**
     * 业务名称跳转URL地址
     */
    @Column(name = "BIZ_URL")
    @ApiModelProperty(value = "业务名称跳转URL地址")
    private String bizUrl; 

 	/**
     * 业务名称角标
     */
    @Column(name = "BIZ_LABEL")
    @ApiModelProperty(value = "业务名称角标")
    private String bizLabel; 

 	/**
     * 业务办理范围（1-自治区内，2-盟市内，3-区县内，4-自治区外，5-全国）
     */
    @Column(name = "BIZ_RANGE")
    @ApiModelProperty(value = "业务办理范围（1-自治区内，2-盟市内，3-区县内，4-自治区外，5-全国）")
    private String bizRange; 

 	/**
     * 业务所属省市县区
     */
    @Column(name = "SSXQ")
    @ApiModelProperty(value = "业务所属省市县区")
    private String ssxq; 

 	/**
     * 业务名称状态（1-使用中，0-停用）
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "业务名称状态（1-使用中，0-停用）")
    private String status; 

 	/**
     * 业务名称是否显示在微户政主页（1-是，0-否）
     */
    @Column(name = "HOME_DISPLAY")
    @ApiModelProperty(value = "业务名称是否显示在微户政主页（1-是，0-否）")
    private String homeDisplay; 

 	/**
     * 业务名称在微户政主页显示排序
     */
    @Column(name = "HOME_ORDER")
    @ApiModelProperty(value = "业务名称在微户政主页显示排序")
    private Integer homeOrder; 

 	/**
     * 业务是否开通（1-已开通，0-未开通）
     */
    @Column(name = "IS_OPEN")
    @ApiModelProperty(value = "业务是否开通（1-已开通，0-未开通）")
    private String isOpen; 

 	/**
     * 是否需要进行前置问答
     */
    @Column(name = "IS_NEED_QA")
    @ApiModelProperty(value = "是否需要进行前置问答")
    private String isNeedQa; 

 	/**
     * 业务步骤编号
     */
    @Column(name = "STEP_NUM")
    @ApiModelProperty(value = "业务步骤编号")
    private Integer stepNum; 

 	/**
     * 内蒙公安关联事项ID
     */
    @Column(name = "ITEM_ID")
    @ApiModelProperty(value = "内蒙公安关联事项ID")
    private String itemId; 

 	/**
     * web端跳转地址
     */
    @Column(name = "WEB_URL")
    @ApiModelProperty(value = "web端跳转地址")
    private String webUrl; 

 	/**
     * 备注
     */
    @Column(name = "NOTES")
    @ApiModelProperty(value = "备注")
    private String notes; 

 	/**
     * 录入用户编号
     */
    @Column(name = "ADD_USER_ID")
    @ApiModelProperty(value = "录入用户编号")
    private String addUserId; 

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
    private String addTime; 

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
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private String modifyTime; 

 	/**
     * 保留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "保留字段1")
    private String reserve1; 

 	/**
     * 保留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "保留字段2")
    private String reserve2; 

 	/**
     * 保留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "保留字段3")
    private String reserve3; 

 	/**
     * 保留字段4
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "保留字段4")
    private String reserve4; 

 	/**
     * 保留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "保留字段5")
    private String reserve5; 


    /**
    * 获得流水号（主键）
    * @return LSH
    */
    public String getLsh() {
        return this.lsh;
    }

    /**
    * 设置流水号（主键）
    * @param lsh
    */
    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    /**
    * 获得业务编号
    * @return BIZ_NO
    */
    public String getBizNo() {
        return this.bizNo;
    }

    /**
    * 设置业务编号
    * @param bizNo
    */
    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    /**
    * 获得父级业务类型编号
    * @return BIZ_PARENT_NO
    */
    public String getBizParentNo() {
        return this.bizParentNo;
    }

    /**
    * 设置父级业务类型编号
    * @param bizParentNo
    */
    public void setBizParentNo(String bizParentNo) {
        this.bizParentNo = bizParentNo;
    }

    /**
    * 获得业务名称来源（1-业务办理，2-业务预约）
    * @return BIZ_SOURCE
    */
    public String getBizSource() {
        return this.bizSource;
    }

    /**
    * 设置业务名称来源（1-业务办理，2-业务预约）
    * @param bizSource
    */
    public void setBizSource(String bizSource) {
        this.bizSource = bizSource;
    }

    /**
    * 获得业务名称
    * @return BIZ_NAME
    */
    public String getBizName() {
        return this.bizName;
    }

    /**
    * 设置业务名称
    * @param bizName
    */
    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    /**
    * 获得业务名称分类
    * @return BIZ_TYPE
    */
    public String getBizType() {
        return this.bizType;
    }

    /**
    * 设置业务名称分类
    * @param bizType
    */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
    * 获得业务名称级别
    * @return BIZ_LEVEL
    */
    public String getBizLevel() {
        return this.bizLevel;
    }

    /**
    * 设置业务名称级别
    * @param bizLevel
    */
    public void setBizLevel(String bizLevel) {
        this.bizLevel = bizLevel;
    }

    /**
    * 获得业务名称图标
    * @return BIZ_ICON
    */
    public String getBizIcon() {
        return this.bizIcon;
    }

    /**
    * 设置业务名称图标
    * @param bizIcon
    */
    public void setBizIcon(String bizIcon) {
        this.bizIcon = bizIcon;
    }

    /**
    * 获得业务名称图标颜色
    * @return BIZ_ICON_COLOR
    */
    public String getBizIconColor() {
        return this.bizIconColor;
    }

    /**
    * 设置业务名称图标颜色
    * @param bizIconColor
    */
    public void setBizIconColor(String bizIconColor) {
        this.bizIconColor = bizIconColor;
    }

    /**
    * 获得业务名称显示排序
    * @return BIZ_ORDER
    */
    public Integer getBizOrder() {
        return this.bizOrder;
    }

    /**
    * 设置业务名称显示排序
    * @param bizOrder
    */
    public void setBizOrder(Integer bizOrder) {
        this.bizOrder = bizOrder;
    }

    /**
    * 获得业务名称跳转URL地址
    * @return BIZ_URL
    */
    public String getBizUrl() {
        return this.bizUrl;
    }

    /**
    * 设置业务名称跳转URL地址
    * @param bizUrl
    */
    public void setBizUrl(String bizUrl) {
        this.bizUrl = bizUrl;
    }

    /**
    * 获得业务名称角标
    * @return BIZ_LABEL
    */
    public String getBizLabel() {
        return this.bizLabel;
    }

    /**
    * 设置业务名称角标
    * @param bizLabel
    */
    public void setBizLabel(String bizLabel) {
        this.bizLabel = bizLabel;
    }

    /**
    * 获得业务办理范围（1-自治区内，2-盟市内，3-区县内，4-自治区外，5-全国）
    * @return BIZ_RANGE
    */
    public String getBizRange() {
        return this.bizRange;
    }

    /**
    * 设置业务办理范围（1-自治区内，2-盟市内，3-区县内，4-自治区外，5-全国）
    * @param bizRange
    */
    public void setBizRange(String bizRange) {
        this.bizRange = bizRange;
    }

    /**
    * 获得业务所属省市县区
    * @return SSXQ
    */
    public String getSsxq() {
        return this.ssxq;
    }

    /**
    * 设置业务所属省市县区
    * @param ssxq
    */
    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    /**
    * 获得业务名称状态（1-使用中，0-停用）
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置业务名称状态（1-使用中，0-停用）
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得业务名称是否显示在微户政主页（1-是，0-否）
    * @return HOME_DISPLAY
    */
    public String getHomeDisplay() {
        return this.homeDisplay;
    }

    /**
    * 设置业务名称是否显示在微户政主页（1-是，0-否）
    * @param homeDisplay
    */
    public void setHomeDisplay(String homeDisplay) {
        this.homeDisplay = homeDisplay;
    }

    /**
    * 获得业务名称在微户政主页显示排序
    * @return HOME_ORDER
    */
    public Integer getHomeOrder() {
        return this.homeOrder;
    }

    /**
    * 设置业务名称在微户政主页显示排序
    * @param homeOrder
    */
    public void setHomeOrder(Integer homeOrder) {
        this.homeOrder = homeOrder;
    }

    /**
    * 获得业务是否开通（1-已开通，0-未开通）
    * @return IS_OPEN
    */
    public String getIsOpen() {
        return this.isOpen;
    }

    /**
    * 设置业务是否开通（1-已开通，0-未开通）
    * @param isOpen
    */
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    /**
    * 获得是否需要进行前置问答
    * @return IS_NEED_QA
    */
    public String getIsNeedQa() {
        return this.isNeedQa;
    }

    /**
    * 设置是否需要进行前置问答
    * @param isNeedQa
    */
    public void setIsNeedQa(String isNeedQa) {
        this.isNeedQa = isNeedQa;
    }

    /**
    * 获得业务步骤编号
    * @return STEP_NUM
    */
    public Integer getStepNum() {
        return this.stepNum;
    }

    /**
    * 设置业务步骤编号
    * @param stepNum
    */
    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    /**
    * 获得内蒙公安关联事项ID
    * @return ITEM_ID
    */
    public String getItemId() {
        return this.itemId;
    }

    /**
    * 设置内蒙公安关联事项ID
    * @param itemId
    */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
    * 获得web端跳转地址
    * @return WEB_URL
    */
    public String getWebUrl() {
        return this.webUrl;
    }

    /**
    * 设置web端跳转地址
    * @param webUrl
    */
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    /**
    * 获得备注
    * @return NOTES
    */
    public String getNotes() {
        return this.notes;
    }

    /**
    * 设置备注
    * @param notes
    */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
    * 获得录入用户编号
    * @return ADD_USER_ID
    */
    public String getAddUserId() {
        return this.addUserId;
    }

    /**
    * 设置录入用户编号
    * @param addUserId
    */
    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
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
    public String getAddTime() {
        return this.addTime;
    }

    /**
    * 设置录入时间
    * @param addTime
    */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
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
    * 获得修改时间
    * @return MODIFY_TIME
    */
    public String getModifyTime() {
        return this.modifyTime;
    }

    /**
    * 设置修改时间
    * @param modifyTime
    */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
    * 获得保留字段1
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置保留字段1
    * @param reserve1
    */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
    * 获得保留字段2
    * @return RESERVE2
    */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
    * 设置保留字段2
    * @param reserve2
    */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    /**
    * 获得保留字段3
    * @return RESERVE3
    */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
    * 设置保留字段3
    * @param reserve3
    */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
    * 获得保留字段4
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置保留字段4
    * @param reserve4
    */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
    * 获得保留字段5
    * @return RESERVE5
    */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
    * 设置保留字段5
    * @param reserve5
    */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }


}