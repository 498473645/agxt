package com.pkusoft.usercenter.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

/**
 * @author
 * @title: SysMenu
 */
@ApiModel("菜单表")
@Table(name = "SYS_MENU")
public class SysMenu {

    /**
     * 菜单标识号
     */
    @Id
    @Column(name = "MENU_ID")
    @ApiModelProperty(value = "菜单标识号")
    private String menuId;

    /**
     * 菜单名称
     */
    @Column(name = "MENU_NAME")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    /**
     * 系统标识
     */
    @Column(name = "SYS_ID")
    @ApiModelProperty(value = "系统标识")
    private String sysId;

    /**
     * 系统名称
     */
    @Column(name = "SYS_NAME")
    @ApiModelProperty(value = "系统名称")
    private String sysName;

    /**
     * 图标
     */
    @Column(name = "ICON")
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 菜单等级
     */
    @Column(name = "MENU_LEVEL")
    @ApiModelProperty(value = "菜单等级")
    private String menuLevel;

    /**
     * 菜单树等级
     */
    @Column(name = "TREE_LEVEL")
    @ApiModelProperty(value = "菜单树等级")
    private Integer treeLevel;

    /**
     * 父菜单编号
     */
    @Column(name = "TREE_PARENTID")
    @ApiModelProperty(value = "父菜单编号")
    private String treeParentid;

    /**
     * 是否可用
     */
    @Column(name = "VISIABLE")
    @ApiModelProperty(value = "是否可用")
    private String visiable;

    /**
     * 是否展开
     */
    @Column(name = "EXPAND")
    @ApiModelProperty(value = "是否展开")
    private String expand;

    /**
     * 菜单顺序
     */
    @Column(name = "ORDER_FLAG")
    @ApiModelProperty(value = "菜单顺序")
    private Integer orderFlag;

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
     * 备注
     */
    @Column(name = "MEMO")
    @ApiModelProperty(value = "备注")
    private String memo;

    /**
     * 录入时间
     */
    @Column(name = "ADD_TIME")
    @ApiModelProperty(value = "录入时间")
    private java.util.Date addTime;

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
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间")
    private java.util.Date modifyTime;

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
     * 链接路径
     */
    @Column(name = "MENU_URL")
    @ApiModelProperty(value = "链接路径")
    private String menuUrl;


    /**
     * 获得菜单标识号
     * @return MENU_ID
     */
    public String getMenuId() {
        return this.menuId;
    }

    /**
     * 设置菜单标识号
     * @param menuId
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获得菜单名称
     * @return MENU_NAME
     */
    public String getMenuName() {
        return this.menuName;
    }

    /**
     * 设置菜单名称
     * @param menuName
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获得系统标识
     * @return SYS_ID
     */
    public String getSysId() {
        return this.sysId;
    }

    /**
     * 设置系统标识
     * @param sysId
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     * 获得系统名称
     * @return SYS_NAME
     */
    public String getSysName() {
        return this.sysName;
    }

    /**
     * 设置系统名称
     * @param sysName
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * 获得图标
     * @return ICON
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * 设置图标
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获得菜单等级
     * @return MENU_LEVEL
     */
    public String getMenuLevel() {
        return this.menuLevel;
    }

    /**
     * 设置菜单等级
     * @param menuLevel
     */
    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 获得菜单树等级
     * @return TREE_LEVEL
     */
    public Integer getTreeLevel() {
        return this.treeLevel;
    }

    /**
     * 设置菜单树等级
     * @param treeLevel
     */
    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * 获得父菜单编号
     * @return TREE_PARENTID
     */
    public String getTreeParentid() {
        return this.treeParentid;
    }

    /**
     * 设置父菜单编号
     * @param treeParentid
     */
    public void setTreeParentid(String treeParentid) {
        this.treeParentid = treeParentid;
    }

    /**
     * 获得是否可用
     * @return VISIABLE
     */
    public String getVisiable() {
        return this.visiable;
    }

    /**
     * 设置是否可用
     * @param visiable
     */
    public void setVisiable(String visiable) {
        this.visiable = visiable;
    }

    /**
     * 获得是否展开
     * @return EXPAND
     */
    public String getExpand() {
        return this.expand;
    }

    /**
     * 设置是否展开
     * @param expand
     */
    public void setExpand(String expand) {
        this.expand = expand;
    }

    /**
     * 获得菜单顺序
     * @return ORDER_FLAG
     */
    public Integer getOrderFlag() {
        return this.orderFlag;
    }

    /**
     * 设置菜单顺序
     * @param orderFlag
     */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
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
     * 获得链接路径
     * @return MENU_URL
     */
    public String getMenuUrl() {
        return this.menuUrl;
    }

    /**
     * 设置链接路径
     * @param menuUrl
     */
    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }


}
