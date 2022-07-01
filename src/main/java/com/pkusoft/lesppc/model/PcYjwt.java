package com.pkusoft.lesppc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 * @title: PcYjwt
 */
@ApiModel("预警问题")
@Table(name = "PC_YJWT")
public class PcYjwt {

 	/**
     * 预警问题编号（主键）
     */
    @Id
    @Column(name = "YJWT_BH")
    @ApiModelProperty(value = "预警问题编号（主键）")
    private String yjwtBh;

 	/**
     * 问题模型编号（问题模型信息的外键）
     */
    @Column(name = "WTMX_BH")
    @ApiModelProperty(value = "问题模型编号（问题模型信息的外键）")
    private String wtmxBh;

 	/**
     * 问题模型名称
     */
    @Column(name = "WTMX_MC")
    @ApiModelProperty(value = "问题模型名称")
    private String wtmxMc;

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
     * 数据来源（00、模型分析；10、用户登记；20、外部导入）
     */
    @Column(name = "SJLY")
    @ApiModelProperty(value = "数据来源（00、模型分析；10、用户登记；20、外部导入）")
    private String sjly;

 	/**
     * 问题维度1
     */
    @Column(name = "WTWD1")
    @ApiModelProperty(value = "问题维度1")
    private String wtwd1;

 	/**
     * 问题维度2
     */
    @Column(name = "WTWD2")
    @ApiModelProperty(value = "问题维度2")
    private String wtwd2;

 	/**
     * 问题维度3
     */
    @Column(name = "WTWD3")
    @ApiModelProperty(value = "问题维度3")
    private String wtwd3;

 	/**
     * 问题维度4
     */
    @Column(name = "WTWD4")
    @ApiModelProperty(value = "问题维度4")
    private String wtwd4;

 	/**
     * 问题维度5
     */
    @Column(name = "WTWD5")
    @ApiModelProperty(value = "问题维度5")
    private String wtwd5;

 	/**
     *
     */
    @Column(name = "YWRY_BH")
    @ApiModelProperty(value = "")
    private String ywryBh;

 	/**
     * 业务人员姓名
     */
    @Column(name = "YWRY_XM")
    @ApiModelProperty(value = "业务人员姓名")
    private String ywryXm;

 	/**
     * 业务人员身份证号码
     */
    @Column(name = "YWRY_SFZHM")
    @ApiModelProperty(value = "业务人员身份证号码")
    private String ywrySfzhm;

 	/**
     * 业务人员警号
     */
    @Column(name = "YWRY_JH")
    @ApiModelProperty(value = "业务人员警号")
    private String ywryJh;

 	/**
     * 业务单位编号
     */
    @Column(name = "YWDW_BM")
    @ApiModelProperty(value = "业务单位编号")
    private String ywdwBm;

 	/**
     * 业务单位名称
     */
    @Column(name = "YWDW_MC")
    @ApiModelProperty(value = "业务单位名称")
    private String ywdwMc;

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
     * 业务单位的一级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_1")
    @ApiModelProperty(value = "业务单位的一级归属单位")
    private String bzOwnerDept1;

 	/**
     * 业务单位的二级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_2")
    @ApiModelProperty(value = "业务单位的二级归属单位")
    private String bzOwnerDept2;

 	/**
     * 业务单位的三级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_3")
    @ApiModelProperty(value = "业务单位的三级归属单位")
    private String bzOwnerDept3;

 	/**
     * 业务单位的四级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_4")
    @ApiModelProperty(value = "业务单位的四级归属单位")
    private String bzOwnerDept4;

 	/**
     * 业务单位的五级归属单位
     */
    @Column(name = "BZ_OWNER_DEPT_5")
    @ApiModelProperty(value = "业务单位的五级归属单位")
    private String bzOwnerDept5;

 	/**
     * 问题状态（0、不需预警；1、需要预警）
     */
    @Column(name = "WTZT")
    @ApiModelProperty(value = "问题状态（0、不需预警；1、需要预警）")
    private String wtzt;

 	/**
     * 截止日期
     */
    @Column(name = "JZRQ")
    @ApiModelProperty(value = "截止日期")
    private java.util.Date jzrq;

 	/**
     * 创建用户编号
     */
    @Column(name = "CREATED_USER_ID")
    @ApiModelProperty(value = "创建用户编号")
    private String createdUserId;

 	/**
     * 创建日期
     */
    @Column(name = "CREATED_DATE")
    @ApiModelProperty(value = "创建日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date createdDate;

 	/**
     * 创建单位编号
     */
    @Column(name = "CREATED_DEPT_ID")
    @ApiModelProperty(value = "创建单位编号")
    private String createdDeptId;

 	/**
     * 创建单位名称
     */
    @Column(name = "CREATED_DEPT_NAME")
    @ApiModelProperty(value = "创建单位名称")
    private String createdDeptName;

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
    * 获得预警问题编号（主键）
    * @return YJWT_BH
    */
    public String getYjwtBh() {
        return this.yjwtBh;
    }

    /**
    * 设置预警问题编号（主键）
    * @param yjwtBh
    */
    public void setYjwtBh(String yjwtBh) {
        this.yjwtBh = yjwtBh;
    }

    /**
    * 获得问题模型编号（问题模型信息的外键）
    * @return WTMX_BH
    */
    public String getWtmxBh() {
        return this.wtmxBh;
    }

    /**
    * 设置问题模型编号（问题模型信息的外键）
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
    * 获得数据来源（00、模型分析；10、用户登记；20、外部导入）
    * @return SJLY
    */
    public String getSjly() {
        return this.sjly;
    }

    /**
    * 设置数据来源（00、模型分析；10、用户登记；20、外部导入）
    * @param sjly
    */
    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    /**
    * 获得问题维度1
    * @return WTWD1
    */
    public String getWtwd1() {
        return this.wtwd1;
    }

    /**
    * 设置问题维度1
    * @param wtwd1
    */
    public void setWtwd1(String wtwd1) {
        this.wtwd1 = wtwd1;
    }

    /**
    * 获得问题维度2
    * @return WTWD2
    */
    public String getWtwd2() {
        return this.wtwd2;
    }

    /**
    * 设置问题维度2
    * @param wtwd2
    */
    public void setWtwd2(String wtwd2) {
        this.wtwd2 = wtwd2;
    }

    /**
    * 获得问题维度3
    * @return WTWD3
    */
    public String getWtwd3() {
        return this.wtwd3;
    }

    /**
    * 设置问题维度3
    * @param wtwd3
    */
    public void setWtwd3(String wtwd3) {
        this.wtwd3 = wtwd3;
    }

    /**
    * 获得问题维度4
    * @return WTWD4
    */
    public String getWtwd4() {
        return this.wtwd4;
    }

    /**
    * 设置问题维度4
    * @param wtwd4
    */
    public void setWtwd4(String wtwd4) {
        this.wtwd4 = wtwd4;
    }

    /**
    * 获得问题维度5
    * @return WTWD5
    */
    public String getWtwd5() {
        return this.wtwd5;
    }

    /**
    * 设置问题维度5
    * @param wtwd5
    */
    public void setWtwd5(String wtwd5) {
        this.wtwd5 = wtwd5;
    }

    /**
    * 获得
    * @return YWRY_BH
    */
    public String getYwryBh() {
        return this.ywryBh;
    }

    /**
    * 设置
    * @param ywryBh
    */
    public void setYwryBh(String ywryBh) {
        this.ywryBh = ywryBh;
    }

    /**
    * 获得业务人员姓名
    * @return YWRY_XM
    */
    public String getYwryXm() {
        return this.ywryXm;
    }

    /**
    * 设置业务人员姓名
    * @param ywryXm
    */
    public void setYwryXm(String ywryXm) {
        this.ywryXm = ywryXm;
    }

    /**
    * 获得业务人员身份证号码
    * @return YWRY_SFZHM
    */
    public String getYwrySfzhm() {
        return this.ywrySfzhm;
    }

    /**
    * 设置业务人员身份证号码
    * @param ywrySfzhm
    */
    public void setYwrySfzhm(String ywrySfzhm) {
        this.ywrySfzhm = ywrySfzhm;
    }

    /**
    * 获得业务人员警号
    * @return YWRY_JH
    */
    public String getYwryJh() {
        return this.ywryJh;
    }

    /**
    * 设置业务人员警号
    * @param ywryJh
    */
    public void setYwryJh(String ywryJh) {
        this.ywryJh = ywryJh;
    }

    /**
    * 获得业务单位编号
    * @return YWDW_BM
    */
    public String getYwdwBm() {
        return this.ywdwBm;
    }

    /**
    * 设置业务单位编号
    * @param ywdwBm
    */
    public void setYwdwBm(String ywdwBm) {
        this.ywdwBm = ywdwBm;
    }

    /**
    * 获得业务单位名称
    * @return YWDW_MC
    */
    public String getYwdwMc() {
        return this.ywdwMc;
    }

    /**
    * 设置业务单位名称
    * @param ywdwMc
    */
    public void setYwdwMc(String ywdwMc) {
        this.ywdwMc = ywdwMc;
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
    * 获得问题状态（0、不需预警；1、需要预警）
    * @return WTZT
    */
    public String getWtzt() {
        return this.wtzt;
    }

    /**
    * 设置问题状态（0、不需预警；1、需要预警）
    * @param wtzt
    */
    public void setWtzt(String wtzt) {
        this.wtzt = wtzt;
    }

    /**
    * 获得截止日期
    * @return JZRQ
    */
    public java.util.Date getJzrq() {
        return this.jzrq;
    }

    /**
    * 设置截止日期
    * @param jzrq
    */
    public void setJzrq(java.util.Date jzrq) {
        this.jzrq = jzrq;
    }

    /**
    * 获得创建用户编号
    * @return CREATED_USER_ID
    */
    public String getCreatedUserId() {
        return this.createdUserId;
    }

    /**
    * 设置创建用户编号
    * @param createdUserId
    */
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
    * 获得创建日期
    * @return CREATED_DATE
    */
    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }

    /**
    * 设置创建日期
    * @param createdDate
    */
    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
    * 获得创建单位编号
    * @return CREATED_DEPT_ID
    */
    public String getCreatedDeptId() {
        return this.createdDeptId;
    }

    /**
    * 设置创建单位编号
    * @param createdDeptId
    */
    public void setCreatedDeptId(String createdDeptId) {
        this.createdDeptId = createdDeptId;
    }

    /**
    * 获得创建单位名称
    * @return CREATED_DEPT_NAME
    */
    public String getCreatedDeptName() {
        return this.createdDeptName;
    }

    /**
    * 设置创建单位名称
    * @param createdDeptName
    */
    public void setCreatedDeptName(String createdDeptName) {
        this.createdDeptName = createdDeptName;
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
