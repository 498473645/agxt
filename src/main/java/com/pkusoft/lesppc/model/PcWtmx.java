package com.pkusoft.lesppc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: PcWtmx
 */
@ApiModel("问题模型信息")
@Table(name = "PC_WTMX")
public class PcWtmx {

 	/**
     * 问题模型编号（主键）
     */
    @Id
    @Column(name = "WTMX_BH")
    @ApiModelProperty(value = "问题模型编号（主键）")
    private String wtmxBh;

 	/**
     * 问题模型名称
     */
    @Column(name = "WTMX_MC")
    @ApiModelProperty(value = "问题模型名称")
    private String wtmxMc;

 	/**
     * 问题模型简称
     */
    @Column(name = "WTMX_JC")
    @ApiModelProperty(value = "问题模型简称")
    private String wtmxJc;

 	/**
     * 问题领域编号
     */
    @Column(name = "WTLY_BH")
    @ApiModelProperty(value = "问题领域编号")
    private String wtlyBh;

 	/**
     * 问题领域名称
     */
    @Column(name = "WTLY_MC")
    @ApiModelProperty(value = "问题领域名称")
    private String wtlyMc;

 	/**
     * 问题领域简称
     */
    @Column(name = "WTLY_JC")
    @ApiModelProperty(value = "问题领域简称")
    private String wtlyJc;

 	/**
     * 报警问题描述
     */
    @Column(name = "BJWT_MS")
    @ApiModelProperty(value = "报警问题描述")
    private String bjwtMs;

 	/**
     * 预警问题描述
     */
    @Column(name = "YJWT_MS")
    @ApiModelProperty(value = "预警问题描述")
    private String yjwtMs;

 	/**
     * 问题维度1的显示名称
     */
    @Column(name = "WTWD1")
    @ApiModelProperty(value = "问题维度1的显示名称")
    private String wtwd1;

 	/**
     * 问题维度2的显示名称
     */
    @Column(name = "WTWD2")
    @ApiModelProperty(value = "问题维度2的显示名称")
    private String wtwd2;

 	/**
     * 问题维度3的显示名称
     */
    @Column(name = "WTWD3")
    @ApiModelProperty(value = "问题维度3的显示名称")
    private String wtwd3;

 	/**
     * 问题维度4的显示名称
     */
    @Column(name = "WTWD4")
    @ApiModelProperty(value = "问题维度4的显示名称")
    private String wtwd4;

 	/**
     * 问题维度5的显示名称
     */
    @Column(name = "WTWD5")
    @ApiModelProperty(value = "问题维度5的显示名称")
    private String wtwd5;

 	/**
     * 序号
     */
    @Column(name = "XH")
    @ApiModelProperty(value = "序号")
    private Integer xh;

 	/**
     * 类型（十进制存储。转二进制的第1位、疑似问题；第2位，预警问题；第3位，报警问题。每一位的值，0、未实现；1、已实现）
     */
    @Column(name = "LX")
    @ApiModelProperty(value = "类型（十进制存储。转二进制的第1位、疑似问题；第2位，预警问题；第3位，报警问题。每一位的值，0、未实现；1、已实现）")
    private Integer lx;

 	/**
     * 来源
     */
    @Column(name = "LY")
    @ApiModelProperty(value = "来源")
    private String ly;

 	/**
     *
     */
    @Column(name = "LY_WTBH")
    @ApiModelProperty(value = "")
    private String lyWtbh;

 	/**
     * 来源的报警问题编号
     */
    @Column(name = "LY_BJWT_BH")
    @ApiModelProperty(value = "来源的报警问题编号")
    private String lyBjwtBh;

 	/**
     * 来源的预警问题编号
     */
    @Column(name = "LY_YJWT_BH")
    @ApiModelProperty(value = "来源的预警问题编号")
    private String lyYjwtBh;

 	/**
     * 修改用户编号
     */
    @Column(name = "MODIFIED_USER_ID")
    @ApiModelProperty(value = "修改用户编号")
    private String modifiedUserId;

 	/**
     * 修改日期
     */
    @Column(name = "MODIFIED_DATE")
    @ApiModelProperty(value = "修改日期")
    private java.util.Date modifiedDate;

 	/**
     * 修改单位编号
     */
    @Column(name = "MODIFIED_DEPT_ID")
    @ApiModelProperty(value = "修改单位编号")
    private String modifiedDeptId;

 	/**
     * 修改单位名称
     */
    @Column(name = "MODIFIED_DEPT_NAME")
    @ApiModelProperty(value = "修改单位名称")
    private String modifiedDeptName;


    /**
    * 获得问题模型编号（主键）
    * @return WTMX_BH
    */
    public String getWtmxBh() {
        return this.wtmxBh;
    }

    /**
    * 设置问题模型编号（主键）
    * @param wtmxBh
    */
    public void setWtmxBh(String wtmxBh) {
        this.wtmxBh = wtmxBh;
    }

    /**
    * 获得问题模型名称
    * @return WTMX_MC
    */
    public String getWtmxMc() {
        return this.wtmxMc;
    }

    /**
    * 设置问题模型名称
    * @param wtmxMc
    */
    public void setWtmxMc(String wtmxMc) {
        this.wtmxMc = wtmxMc;
    }

    /**
    * 获得问题模型简称
    * @return WTMX_JC
    */
    public String getWtmxJc() {
        return this.wtmxJc;
    }

    /**
    * 设置问题模型简称
    * @param wtmxJc
    */
    public void setWtmxJc(String wtmxJc) {
        this.wtmxJc = wtmxJc;
    }

    /**
    * 获得问题领域编号
    * @return WTLY_BH
    */
    public String getWtlyBh() {
        return this.wtlyBh;
    }

    /**
    * 设置问题领域编号
    * @param wtlyBh
    */
    public void setWtlyBh(String wtlyBh) {
        this.wtlyBh = wtlyBh;
    }

    /**
    * 获得问题领域名称
    * @return WTLY_MC
    */
    public String getWtlyMc() {
        return this.wtlyMc;
    }

    /**
    * 设置问题领域名称
    * @param wtlyMc
    */
    public void setWtlyMc(String wtlyMc) {
        this.wtlyMc = wtlyMc;
    }

    /**
    * 获得问题领域简称
    * @return WTLY_JC
    */
    public String getWtlyJc() {
        return this.wtlyJc;
    }

    /**
    * 设置问题领域简称
    * @param wtlyJc
    */
    public void setWtlyJc(String wtlyJc) {
        this.wtlyJc = wtlyJc;
    }

    /**
    * 获得报警问题描述
    * @return BJWT_MS
    */
    public String getBjwtMs() {
        return this.bjwtMs;
    }

    /**
    * 设置报警问题描述
    * @param bjwtMs
    */
    public void setBjwtMs(String bjwtMs) {
        this.bjwtMs = bjwtMs;
    }

    /**
    * 获得预警问题描述
    * @return YJWT_MS
    */
    public String getYjwtMs() {
        return this.yjwtMs;
    }

    /**
    * 设置预警问题描述
    * @param yjwtMs
    */
    public void setYjwtMs(String yjwtMs) {
        this.yjwtMs = yjwtMs;
    }

    /**
    * 获得问题维度1的显示名称
    * @return WTWD1
    */
    public String getWtwd1() {
        return this.wtwd1;
    }

    /**
    * 设置问题维度1的显示名称
    * @param wtwd1
    */
    public void setWtwd1(String wtwd1) {
        this.wtwd1 = wtwd1;
    }

    /**
    * 获得问题维度2的显示名称
    * @return WTWD2
    */
    public String getWtwd2() {
        return this.wtwd2;
    }

    /**
    * 设置问题维度2的显示名称
    * @param wtwd2
    */
    public void setWtwd2(String wtwd2) {
        this.wtwd2 = wtwd2;
    }

    /**
    * 获得问题维度3的显示名称
    * @return WTWD3
    */
    public String getWtwd3() {
        return this.wtwd3;
    }

    /**
    * 设置问题维度3的显示名称
    * @param wtwd3
    */
    public void setWtwd3(String wtwd3) {
        this.wtwd3 = wtwd3;
    }

    /**
    * 获得问题维度4的显示名称
    * @return WTWD4
    */
    public String getWtwd4() {
        return this.wtwd4;
    }

    /**
    * 设置问题维度4的显示名称
    * @param wtwd4
    */
    public void setWtwd4(String wtwd4) {
        this.wtwd4 = wtwd4;
    }

    /**
    * 获得问题维度5的显示名称
    * @return WTWD5
    */
    public String getWtwd5() {
        return this.wtwd5;
    }

    /**
    * 设置问题维度5的显示名称
    * @param wtwd5
    */
    public void setWtwd5(String wtwd5) {
        this.wtwd5 = wtwd5;
    }

    /**
    * 获得序号
    * @return XH
    */
    public Integer getXh() {
        return this.xh;
    }

    /**
    * 设置序号
    * @param xh
    */
    public void setXh(Integer xh) {
        this.xh = xh;
    }

    /**
    * 获得类型（十进制存储。转二进制的第1位、疑似问题；第2位，预警问题；第3位，报警问题。每一位的值，0、未实现；1、已实现）
    * @return LX
    */
    public Integer getLx() {
        return this.lx;
    }

    /**
    * 设置类型（十进制存储。转二进制的第1位、疑似问题；第2位，预警问题；第3位，报警问题。每一位的值，0、未实现；1、已实现）
    * @param lx
    */
    public void setLx(Integer lx) {
        this.lx = lx;
    }

    /**
    * 获得来源
    * @return LY
    */
    public String getLy() {
        return this.ly;
    }

    /**
    * 设置来源
    * @param ly
    */
    public void setLy(String ly) {
        this.ly = ly;
    }

    /**
    * 获得
    * @return LY_WTBH
    */
    public String getLyWtbh() {
        return this.lyWtbh;
    }

    /**
    * 设置
    * @param lyWtbh
    */
    public void setLyWtbh(String lyWtbh) {
        this.lyWtbh = lyWtbh;
    }

    /**
    * 获得来源的报警问题编号
    * @return LY_BJWT_BH
    */
    public String getLyBjwtBh() {
        return this.lyBjwtBh;
    }

    /**
    * 设置来源的报警问题编号
    * @param lyBjwtBh
    */
    public void setLyBjwtBh(String lyBjwtBh) {
        this.lyBjwtBh = lyBjwtBh;
    }

    /**
    * 获得来源的预警问题编号
    * @return LY_YJWT_BH
    */
    public String getLyYjwtBh() {
        return this.lyYjwtBh;
    }

    /**
    * 设置来源的预警问题编号
    * @param lyYjwtBh
    */
    public void setLyYjwtBh(String lyYjwtBh) {
        this.lyYjwtBh = lyYjwtBh;
    }

    /**
    * 获得修改用户编号
    * @return MODIFIED_USER_ID
    */
    public String getModifiedUserId() {
        return this.modifiedUserId;
    }

    /**
    * 设置修改用户编号
    * @param modifiedUserId
    */
    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    /**
    * 获得修改日期
    * @return MODIFIED_DATE
    */
    public java.util.Date getModifiedDate() {
        return this.modifiedDate;
    }

    /**
    * 设置修改日期
    * @param modifiedDate
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
    * 获得修改单位编号
    * @return MODIFIED_DEPT_ID
    */
    public String getModifiedDeptId() {
        return this.modifiedDeptId;
    }

    /**
    * 设置修改单位编号
    * @param modifiedDeptId
    */
    public void setModifiedDeptId(String modifiedDeptId) {
        this.modifiedDeptId = modifiedDeptId;
    }

    /**
    * 获得修改单位名称
    * @return MODIFIED_DEPT_NAME
    */
    public String getModifiedDeptName() {
        return this.modifiedDeptName;
    }

    /**
    * 设置修改单位名称
    * @param modifiedDeptName
    */
    public void setModifiedDeptName(String modifiedDeptName) {
        this.modifiedDeptName = modifiedDeptName;
    }


}
