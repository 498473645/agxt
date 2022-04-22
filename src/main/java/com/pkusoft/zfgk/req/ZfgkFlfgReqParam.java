package com.pkusoft.zfgk.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import pkubatis.common.base.YgjwPage;

import java.util.Date;

@ApiModel("法律法规依据")
public class ZfgkFlfgReqParam extends YgjwPage {

    /**
     * 法律法规主键
     */
    @ApiModelProperty(value = "法律法规主键")
    private String lawId;

    /**
     * 法律法规标题
     */
    @ApiModelProperty(value = "法律法规标题")
    private String lawTitle;

    /**
     * 主题分类代码
     */
    @ApiModelProperty(value = "主题分类代码")
    private String themeCode;

    /**
     * 主题分类名称
     */
    @ApiModelProperty(value = "主题分类名称")
    private String themeName;

    /**
     * 类别代码
     */
    @ApiModelProperty(value = "类别代码")
    private String classCode;

    /**
     * 类别名称
     */
    @ApiModelProperty(value = "类别名称")
    private String className;

    /**
     * 目录类别代码
     */
    @ApiModelProperty(value = "目录类别代码")
    private String dirCode;

    /**
     * 目录类别名称
     */
    @ApiModelProperty(value = "目录类别名称")
    private String dirName;

    /**
     * 颁布单位
     */
    @ApiModelProperty(value = "颁布单位")
    private String enactUnit;

    /**
     * 颁布日期
     */
    @ApiModelProperty(value = "颁布日期")
    private Date enactDate;

    /**
     * 生效日期
     */
    @ApiModelProperty(value = "生效日期")
    private Date effectiveDate;

    /**
     * 有效性代码
     */
    @ApiModelProperty(value = "有效性代码")
    private String effectiveCode;

    /**
     * 有效性名称
     */
    @ApiModelProperty(value = "有效性名称")
    private String effectiveName;

    /**
     * 发文号
     */
    @ApiModelProperty(value = "发文号")
    private String dispatchNo;

    /**
     * 法律法规数据来源
     */
    @ApiModelProperty(value = "法律法规数据来源")
    private String lawDataSource;

    /**
     * 采集人
     */
    @ApiModelProperty(value = "采集人")
    private String collectPerson;

    /**
     * 采集时间
     */
    @ApiModelProperty(value = "采集时间")
    private Date collectDate;

    /**
     * 预留字段1
     */
    @ApiModelProperty(value = "预留字段1")
    private String reserve1;

    /**
     * 预留字段2
     */
    @ApiModelProperty(value = "预留字段2")
    private String reserve2;

    /**
     * 预留字段3
     */
    @ApiModelProperty(value = "预留字段3")
    private String reserve3;

    /**
     * 预留字段4
     */
    @ApiModelProperty(value = "预留字段4")
    private String reserve4;

    /**
     * 预留字段5
     */
    @ApiModelProperty(value = "预留字段5")
    private String reserve5;

    /**
     * 法律法规文本
     */
    @ApiModelProperty(value = "法律法规文本")
    private String lawText;

    /**
     * 否公开1：已公开，0：未公开
     */
    @ApiModelProperty(value = "否公开1：已公开，0：未公开")
    private String sfgk;

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public String getLawTitle() {
        return lawTitle;
    }

    public void setLawTitle(String lawTitle) {
        this.lawTitle = lawTitle;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDirCode() {
        return dirCode;
    }

    public void setDirCode(String dirCode) {
        this.dirCode = dirCode;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public String getEnactUnit() {
        return enactUnit;
    }

    public void setEnactUnit(String enactUnit) {
        this.enactUnit = enactUnit;
    }

    public Date getEnactDate() {
        return enactDate;
    }

    public void setEnactDate(Date enactDate) {
        this.enactDate = enactDate;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectiveCode() {
        return effectiveCode;
    }

    public void setEffectiveCode(String effectiveCode) {
        this.effectiveCode = effectiveCode;
    }

    public String getEffectiveName() {
        return effectiveName;
    }

    public void setEffectiveName(String effectiveName) {
        this.effectiveName = effectiveName;
    }

    public String getDispatchNo() {
        return dispatchNo;
    }

    public void setDispatchNo(String dispatchNo) {
        this.dispatchNo = dispatchNo;
    }

    public String getLawDataSource() {
        return lawDataSource;
    }

    public void setLawDataSource(String lawDataSource) {
        this.lawDataSource = lawDataSource;
    }

    public String getCollectPerson() {
        return collectPerson;
    }

    public void setCollectPerson(String collectPerson) {
        this.collectPerson = collectPerson;
    }

    public Date getCollectDate() {
        return collectDate;
    }

    public void setCollectDate(Date collectDate) {
        this.collectDate = collectDate;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    public String getLawText() {
        return lawText;
    }

    public void setLawText(String lawText) {
        this.lawText = lawText;
    }

    public String getSfgk() {
        return sfgk;
    }

    public void setSfgk(String sfgk) {
        this.sfgk = sfgk;
    }
}
