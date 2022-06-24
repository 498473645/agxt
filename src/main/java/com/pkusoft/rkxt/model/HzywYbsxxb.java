package com.pkusoft.rkxt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;

/**
 * @author
 * @title: HzywYbsxxb
 */
@ApiModel("预办事信息表")
@Table(name = "HZYW_YBSXXB")
public class HzywYbsxxb {

 	/**
     * 办事编号
     */
    @Id
    @Column(name = "CODE")
    @ApiModelProperty(value = "办事编号", required = false, example = "办事编号")
    private String code;

 	/**
     * 办事名称
     */
    @Column(name = "NAME")
    @ApiModelProperty(value = "办事名称", required = false, example = "办事名称")
    private String name;

 	/**
     * 办事类型
     */
    @Column(name = "TYPE")
    @ApiModelProperty(value = "办事类型", required = false, example = "办事类型")
    private String type;

 	/**
     * 办事人姓名
     */
    @Column(name = "REP_NAME")
    @ApiModelProperty(value = "办事人姓名", required = false, example = "办事人姓名")
    private String repName;

 	/**
     * 办事人证件类型
     */
    @Column(name = "REP_CARD_TYPE")
    @ApiModelProperty(value = "办事人证件类型", required = false, example = "办事人证件类型")
    private String repCardType;

 	/**
     * 办事人证件号码
     */
    @Column(name = "REP_IDCARD")
    @ApiModelProperty(value = "办事人证件号码", required = false, example = "办事人证件号码")
    private String repIdcard;

 	/**
     * 办事人性别
     */
    @Column(name = "REP_SEX")
    @ApiModelProperty(value = "办事人性别", required = false, example = "办事人性别")
    private String repSex;

 	/**
     * 办事人出生日期
     */
    @Column(name = "REP_BRITHDAY")
    @ApiModelProperty(value = "办事人出生日期", required = false, example = "办事人出生日期")
    private String repBrithday;

 	/**
     * 办事人联系方式
     */
    @Column(name = "REP_TEL")
    @ApiModelProperty(value = "办事人联系方式", required = false, example = "办事人联系方式")
    private String repTel;

 	/**
     * 办事时间
     */
    @Column(name = "REP_TIME")
    @ApiModelProperty(value = "办事时间", required = false, example = "办事时间")
    private java.util.Date repTime;

 	/**
     * 数据类型（0：自助机，1：微信）
     */
    @Column(name = "DATA_TYPE")
    @ApiModelProperty(value = "数据类型（0：自助机，1：微信）", required = false, example = "数据类型（0：自助机，1：微信）")
    private String dataType;

 	/**
     * 所属机构编码
     */
    @Column(name = "ORG_CODE")
    @ApiModelProperty(value = "所属机构编码", required = false, example = "所属机构编码")
    private String orgCode;

 	/**
     * 所属机构名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "所属机构名称", required = false, example = "所属机构名称")
    private String orgName;

 	/**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = false, example = "创建时间")
    private java.util.Date createTime;

 	/**
     * 业务类型编号
     */
    @Column(name = "YWLXBH")
    @ApiModelProperty(value = "业务类型编号", required = false, example = "业务类型编号")
    private String ywlxbh;

 	/**
     * 业务办理事项名称
     */
    @Column(name = "YWLXMC")
    @ApiModelProperty(value = "业务办理事项名称", required = false, example = "业务办理事项名称")
    private String ywlxmc;

 	/**
     * 业务办理状态
     */
    @Column(name = "YWBLZT")
    @ApiModelProperty(value = "业务办理状态", required = false, example = "业务办理状态")
    private String ywblzt;

 	/**
     * 业务流水号组
     */
    @Column(name = "YWLSHZ")
    @ApiModelProperty(value = "业务流水号组", required = false, example = "业务流水号组")
    private String ywlshz;

 	/**
     * 受理人员编号
     */
    @Column(name = "SLRBH")
    @ApiModelProperty(value = "受理人员编号", required = false, example = "受理人员编号")
    private String slrbh;

 	/**
     * 受理人员姓名
     */
    @Column(name = "SLRXM")
    @ApiModelProperty(value = "受理人员姓名", required = false, example = "受理人员姓名")
    private String slrxm;

 	/**
     * 受理单位代码
     */
    @Column(name = "SLDWDM")
    @ApiModelProperty(value = "受理单位代码", required = false, example = "受理单位代码")
    private String sldwdm;

 	/**
     * 受理单位名称
     */
    @Column(name = "SLDWMC")
    @ApiModelProperty(value = "受理单位名称", required = false, example = "受理单位名称")
    private String sldwmc;

 	/**
     * SHSJ
     */
    @Column(name = "SLSJ")
    @ApiModelProperty(value = "SHSJ", required = false, example = "SHSJ")
    private String slsj;

 	/**
     * 受理状态
     */
    @Column(name = "SLZT")
    @ApiModelProperty(value = "受理状态", required = false, example = "受理状态")
    private String slzt;

 	/**
     * 审核人员编号
     */
    @Column(name = "SHRBH")
    @ApiModelProperty(value = "审核人员编号", required = false, example = "审核人员编号")
    private String shrbh;

 	/**
     * 审核人员姓名
     */
    @Column(name = "SHRXM")
    @ApiModelProperty(value = "审核人员姓名", required = false, example = "审核人员姓名")
    private String shrxm;

 	/**
     * 审核单位代码
     */
    @Column(name = "SHDWDM")
    @ApiModelProperty(value = "审核单位代码", required = false, example = "审核单位代码")
    private String shdwdm;

 	/**
     * 审核单位名称
     */
    @Column(name = "SHDWMC")
    @ApiModelProperty(value = "审核单位名称", required = false, example = "审核单位名称")
    private String shdwmc;

 	/**
     * 审核时间
     */
    @Column(name = "SHSJ")
    @ApiModelProperty(value = "审核时间", required = false, example = "审核时间")
    private String shsj;

 	/**
     * 审核状态
     */
    @Column(name = "SHZT")
    @ApiModelProperty(value = "审核状态", required = false, example = "审核状态")
    private String shzt;

 	/**
     * 办结人员编号
     */
    @Column(name = "BJRBH")
    @ApiModelProperty(value = "办结人员编号", required = false, example = "办结人员编号")
    private String bjrbh;

 	/**
     * 办结人员姓名
     */
    @Column(name = "BJRXM")
    @ApiModelProperty(value = "办结人员姓名", required = false, example = "办结人员姓名")
    private String bjrxm;

 	/**
     * 办结单位代码
     */
    @Column(name = "BJDWDM")
    @ApiModelProperty(value = "办结单位代码", required = false, example = "办结单位代码")
    private String bjdwdm;

 	/**
     * 办结单位名称
     */
    @Column(name = "BJDWMC")
    @ApiModelProperty(value = "办结单位名称", required = false, example = "办结单位名称")
    private String bjdwmc;

 	/**
     * 办结时间
     */
    @Column(name = "BJSJ")
    @ApiModelProperty(value = "办结时间  ", required = false, example = "办结时间  ")
    private String bjsj;

 	/**
     * 办结状态
     */
    @Column(name = "BJZT")
    @ApiModelProperty(value = "办结状态 ", required = false, example = "办结状态 ")
    private String bjzt;

 	/**
     * 预留字段1
     */
    @Column(name = "RESERVE1")
    @ApiModelProperty(value = "预留字段1", required = false, example = "预留字段1")
    private String reserve1;

 	/**
     * 预留字段2
     */
    @Column(name = "RESERVE2")
    @ApiModelProperty(value = "预留字段2", required = false, example = "预留字段2")
    private String reserve2;

 	/**
     * 预留字段3
     */
    @Column(name = "RESERVE3")
    @ApiModelProperty(value = "预留字段3", required = false, example = "预留字段3")
    private String reserve3;

 	/**
     * 预留字段4
     */
    @Column(name = "RESERVE4")
    @ApiModelProperty(value = "预留字段4", required = false, example = "预留字段4")
    private String reserve4;

 	/**
     * 预留字段5
     */
    @Column(name = "RESERVE5")
    @ApiModelProperty(value = "预留字段5", required = false, example = "预留字段5")
    private String reserve5;

    private Date slsjStart;

    private Date slsjEnd;

    public Date getSlsjStart() {
        return slsjStart;
    }

    public void setSlsjStart(Date slsjStart) {
        this.slsjStart = slsjStart;
    }

    public Date getSlsjEnd() {
        return slsjEnd;
    }

    public void setSlsjEnd(Date slsjEnd) {
        this.slsjEnd = slsjEnd;
    }

    /**
    * 获得办事编号
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置办事编号
    * @param code
    */
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * 获得办事名称
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置办事名称
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 获得办事类型
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置办事类型
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得办事人姓名
    * @return REP_NAME
    */
    public String getRepName() {
        return this.repName;
    }

    /**
    * 设置办事人姓名
    * @param repName
    */
    public void setRepName(String repName) {
        this.repName = repName;
    }

    /**
    * 获得办事人证件类型
    * @return REP_CARD_TYPE
    */
    public String getRepCardType() {
        return this.repCardType;
    }

    /**
    * 设置办事人证件类型
    * @param repCardType
    */
    public void setRepCardType(String repCardType) {
        this.repCardType = repCardType;
    }

    /**
    * 获得办事人证件号码
    * @return REP_IDCARD
    */
    public String getRepIdcard() {
        return this.repIdcard;
    }

    /**
    * 设置办事人证件号码
    * @param repIdcard
    */
    public void setRepIdcard(String repIdcard) {
        this.repIdcard = repIdcard;
    }

    /**
    * 获得办事人性别
    * @return REP_SEX
    */
    public String getRepSex() {
        return this.repSex;
    }

    /**
    * 设置办事人性别
    * @param repSex
    */
    public void setRepSex(String repSex) {
        this.repSex = repSex;
    }

    /**
    * 获得办事人出生日期
    * @return REP_BRITHDAY
    */
    public String getRepBrithday() {
        return this.repBrithday;
    }

    /**
    * 设置办事人出生日期
    * @param repBrithday
    */
    public void setRepBrithday(String repBrithday) {
        this.repBrithday = repBrithday;
    }

    /**
    * 获得办事人联系方式
    * @return REP_TEL
    */
    public String getRepTel() {
        return this.repTel;
    }

    /**
    * 设置办事人联系方式
    * @param repTel
    */
    public void setRepTel(String repTel) {
        this.repTel = repTel;
    }

    /**
    * 获得办事时间
    * @return REP_TIME
    */
    public java.util.Date getRepTime() {
        return this.repTime;
    }

    /**
    * 设置办事时间
    * @param repTime
    */
    public void setRepTime(java.util.Date repTime) {
        this.repTime = repTime;
    }

    /**
    * 获得数据类型（0：自助机，1：微信）
    * @return DATA_TYPE
    */
    public String getDataType() {
        return this.dataType;
    }

    /**
    * 设置数据类型（0：自助机，1：微信）
    * @param dataType
    */
    public void setDataType(String dataType) {
        this.dataType = dataType;
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
    * 获得业务类型编号
    * @return YWLXBH
    */
    public String getYwlxbh() {
        return this.ywlxbh;
    }

    /**
    * 设置业务类型编号
    * @param ywlxbh
    */
    public void setYwlxbh(String ywlxbh) {
        this.ywlxbh = ywlxbh;
    }

    /**
    * 获得业务办理事项名称
    * @return YWLXMC
    */
    public String getYwlxmc() {
        return this.ywlxmc;
    }

    /**
    * 设置业务办理事项名称
    * @param ywlxmc
    */
    public void setYwlxmc(String ywlxmc) {
        this.ywlxmc = ywlxmc;
    }

    /**
    * 获得业务办理状态
    * @return YWBLZT
    */
    public String getYwblzt() {
        return this.ywblzt;
    }

    /**
    * 设置业务办理状态
    * @param ywblzt
    */
    public void setYwblzt(String ywblzt) {
        this.ywblzt = ywblzt;
    }

    /**
    * 获得业务流水号组
    * @return YWLSHZ
    */
    public String getYwlshz() {
        return this.ywlshz;
    }

    /**
    * 设置业务流水号组
    * @param ywlshz
    */
    public void setYwlshz(String ywlshz) {
        this.ywlshz = ywlshz;
    }

    /**
    * 获得受理人员编号
    * @return SLRBH
    */
    public String getSlrbh() {
        return this.slrbh;
    }

    /**
    * 设置受理人员编号
    * @param slrbh
    */
    public void setSlrbh(String slrbh) {
        this.slrbh = slrbh;
    }

    /**
    * 获得受理人员姓名
    * @return SLRXM
    */
    public String getSlrxm() {
        return this.slrxm;
    }

    /**
    * 设置受理人员姓名
    * @param slrxm
    */
    public void setSlrxm(String slrxm) {
        this.slrxm = slrxm;
    }

    /**
    * 获得受理单位代码
    * @return SLDWDM
    */
    public String getSldwdm() {
        return this.sldwdm;
    }

    /**
    * 设置受理单位代码
    * @param sldwdm
    */
    public void setSldwdm(String sldwdm) {
        this.sldwdm = sldwdm;
    }

    /**
    * 获得受理单位名称
    * @return SLDWMC
    */
    public String getSldwmc() {
        return this.sldwmc;
    }

    /**
    * 设置受理单位名称
    * @param sldwmc
    */
    public void setSldwmc(String sldwmc) {
        this.sldwmc = sldwmc;
    }

    /**
    * 获得SHSJ
    * @return SLSJ
    */
    public String getSlsj() {
        return this.slsj;
    }

    /**
    * 设置SHSJ
    * @param slsj
    */
    public void setSlsj(String slsj) {
        this.slsj = slsj;
    }

    /**
    * 获得受理状态
    * @return SLZT
    */
    public String getSlzt() {
        return this.slzt;
    }

    /**
    * 设置受理状态
    * @param slzt
    */
    public void setSlzt(String slzt) {
        this.slzt = slzt;
    }

    /**
    * 获得审核人员编号
    * @return SHRBH
    */
    public String getShrbh() {
        return this.shrbh;
    }

    /**
    * 设置审核人员编号
    * @param shrbh
    */
    public void setShrbh(String shrbh) {
        this.shrbh = shrbh;
    }

    /**
    * 获得审核人员姓名
    * @return SHRXM
    */
    public String getShrxm() {
        return this.shrxm;
    }

    /**
    * 设置审核人员姓名
    * @param shrxm
    */
    public void setShrxm(String shrxm) {
        this.shrxm = shrxm;
    }

    /**
    * 获得审核单位代码
    * @return SHDWDM
    */
    public String getShdwdm() {
        return this.shdwdm;
    }

    /**
    * 设置审核单位代码
    * @param shdwdm
    */
    public void setShdwdm(String shdwdm) {
        this.shdwdm = shdwdm;
    }

    /**
    * 获得审核单位名称
    * @return SHDWMC
    */
    public String getShdwmc() {
        return this.shdwmc;
    }

    /**
    * 设置审核单位名称
    * @param shdwmc
    */
    public void setShdwmc(String shdwmc) {
        this.shdwmc = shdwmc;
    }

    /**
    * 获得审核时间
    * @return SHSJ
    */
    public String getShsj() {
        return this.shsj;
    }

    /**
    * 设置审核时间
    * @param shsj
    */
    public void setShsj(String shsj) {
        this.shsj = shsj;
    }

    /**
    * 获得审核状态
    * @return SHZT
    */
    public String getShzt() {
        return this.shzt;
    }

    /**
    * 设置审核状态
    * @param shzt
    */
    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    /**
    * 获得办结人员编号
    * @return BJRBH
    */
    public String getBjrbh() {
        return this.bjrbh;
    }

    /**
    * 设置办结人员编号
    * @param bjrbh
    */
    public void setBjrbh(String bjrbh) {
        this.bjrbh = bjrbh;
    }

    /**
    * 获得办结人员姓名
    * @return BJRXM
    */
    public String getBjrxm() {
        return this.bjrxm;
    }

    /**
    * 设置办结人员姓名
    * @param bjrxm
    */
    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    /**
    * 获得办结单位代码
    * @return BJDWDM
    */
    public String getBjdwdm() {
        return this.bjdwdm;
    }

    /**
    * 设置办结单位代码
    * @param bjdwdm
    */
    public void setBjdwdm(String bjdwdm) {
        this.bjdwdm = bjdwdm;
    }

    /**
    * 获得办结单位名称
    * @return BJDWMC
    */
    public String getBjdwmc() {
        return this.bjdwmc;
    }

    /**
    * 设置办结单位名称
    * @param bjdwmc
    */
    public void setBjdwmc(String bjdwmc) {
        this.bjdwmc = bjdwmc;
    }

    /**
    * 获得办结时间
    * @return BJSJ
    */
    public String getBjsj() {
        return this.bjsj;
    }

    /**
    * 设置办结时间
    * @param bjsj
    */
    public void setBjsj(String bjsj) {
        this.bjsj = bjsj;
    }

    /**
    * 获得办结状态
    * @return BJZT
    */
    public String getBjzt() {
        return this.bjzt;
    }

    /**
    * 设置办结状态
    * @param bjzt
    */
    public void setBjzt(String bjzt) {
        this.bjzt = bjzt;
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
    * 获得预留字段4
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置预留字段4
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


}
