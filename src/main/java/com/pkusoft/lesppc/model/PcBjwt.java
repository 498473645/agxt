package com.pkusoft.lesppc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author
 * @title: PcBjwt
 */
@ApiModel("报警问题信息表")
@Table(name = "PC_BJWT")
public class PcBjwt {
    @Id
    @Column(name = "bjwt_bh")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bjwtBh;

    @Column(name = "wtmx_bh")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtmxBh;

    @Column(name = "wtmx_mc")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtmxMc;

    @Column(name = "wtly_bh")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtlyBh;

    @Column(name = "wtly_mc")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtlyMc;

    @Column(name = "sjly")
    @ApiModelProperty(value = "", required = false, example = "")
    private String sjly;

    @Column(name = "wtwd1")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtwd1;

    @Column(name = "wtwd2")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtwd2;

    @Column(name = "wtwd3")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtwd3;

    @Column(name = "wtwd4")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtwd4;

    @Column(name = "wtwd5")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtwd5;

    @Column(name = "ywry_bh")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywryBh;

    @Column(name = "ywry_xm")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywryXm;

    @Column(name = "ywry_sfzhm")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywrySfzhm;

    @Column(name = "ywry_jh")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywryJh;

    @Column(name = "ywdw_bm")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywdwBm;

    @Column(name = "ywdw_mc")
    @ApiModelProperty(value = "", required = false, example = "")
    private String ywdwMc;

    @Column(name = "ga_owner_dept_1")
    @ApiModelProperty(value = "", required = false, example = "")
    private String gaOwnerDept1;

    @Column(name = "ga_owner_dept_2")
    @ApiModelProperty(value = "", required = false, example = "")
    private String gaOwnerDept2;

    @Column(name = "ga_owner_dept_3")
    @ApiModelProperty(value = "", required = false, example = "")
    private String gaOwnerDept3;

    @Column(name = "ga_owner_dept_4")
    @ApiModelProperty(value = "", required = false, example = "")
    private String gaOwnerDept4;

    @Column(name = "ga_owner_dept_5")
    @ApiModelProperty(value = "", required = false, example = "")
    private String gaOwnerDept5;

    @Column(name = "bz_owner_dept_1")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bzOwnerDept1;

    @Column(name = "bz_owner_dept_2")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bzOwnerDept2;

    @Column(name = "bz_owner_dept_3")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bzOwnerDept3;

    @Column(name = "bz_owner_dept_4")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bzOwnerDept4;

    @Column(name = "bz_owner_dept_5")
    @ApiModelProperty(value = "", required = false, example = "")
    private String bzOwnerDept5;

    @Column(name = "wtzt")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtzt;

    @Column(name = "wtzt2")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtzt2;

    @Column(name = "wtlx")
    @ApiModelProperty(value = "", required = false, example = "")
    private String wtlx;

    @Column(name = "created_user_id")
    @ApiModelProperty(value = "", required = false, example = "")
    private String createdUserId;

    @Column(name = "created_date")
    @ApiModelProperty(value = "", required = false, example = "")
    private Date createdDate;

    @Column(name = "created_dept_id")
    @ApiModelProperty(value = "", required = false, example = "")
    private String createdDeptId;

    @Column(name = "created_dept_name")
    @ApiModelProperty(value = "", required = false, example = "")
    private String createdDeptName;

    @Column(name = "modified_user_id")
    @ApiModelProperty(value = "", required = false, example = "")
    private String modifiedUserId;

    @Column(name = "modified_date")
    @ApiModelProperty(value = "", required = false, example = "")
    private Date modifiedDate;

    @Column(name = "modified_dept_id")
    @ApiModelProperty(value = "", required = false, example = "")
    private String modifiedDeptId;

    @Column(name = "modified_dept_name")
    @ApiModelProperty(value = "", required = false, example = "")
    private String modifiedDeptName;

    public String getBjwtBh() {
        return bjwtBh;
    }

    public String getWtmxBh() {
        return wtmxBh;
    }

    public String getWtmxMc() {
        return wtmxMc;
    }

    public String getWtlyBh() {
        return wtlyBh;
    }

    public String getWtlyMc() {
        return wtlyMc;
    }

    public String getSjly() {
        return sjly;
    }

    public String getWtwd1() {
        return wtwd1;
    }

    public String getWtwd2() {
        return wtwd2;
    }

    public String getWtwd3() {
        return wtwd3;
    }

    public String getWtwd4() {
        return wtwd4;
    }

    public String getWtwd5() {
        return wtwd5;
    }

    public String getYwryBh() {
        return ywryBh;
    }

    public String getYwryXm() {
        return ywryXm;
    }

    public String getYwrySfzhm() {
        return ywrySfzhm;
    }

    public String getYwryJh() {
        return ywryJh;
    }

    public String getYwdwBm() {
        return ywdwBm;
    }

    public String getYwdwMc() {
        return ywdwMc;
    }

    public String getGaOwnerDept1() {
        return gaOwnerDept1;
    }

    public String getGaOwnerDept2() {
        return gaOwnerDept2;
    }

    public String getGaOwnerDept3() {
        return gaOwnerDept3;
    }

    public String getGaOwnerDept4() {
        return gaOwnerDept4;
    }

    public String getGaOwnerDept5() {
        return gaOwnerDept5;
    }

    public String getBzOwnerDept1() {
        return bzOwnerDept1;
    }

    public String getBzOwnerDept2() {
        return bzOwnerDept2;
    }

    public String getBzOwnerDept3() {
        return bzOwnerDept3;
    }

    public String getBzOwnerDept4() {
        return bzOwnerDept4;
    }

    public String getBzOwnerDept5() {
        return bzOwnerDept5;
    }

    public String getWtzt() {
        return wtzt;
    }

    public String getWtzt2() {
        return wtzt2;
    }

    public String getWtlx() {
        return wtlx;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getCreatedDeptId() {
        return createdDeptId;
    }

    public String getCreatedDeptName() {
        return createdDeptName;
    }

    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getModifiedDeptId() {
        return modifiedDeptId;
    }

    public String getModifiedDeptName() {
        return modifiedDeptName;
    }

    public void setBjwtBh(String bjwtBh) {
        this.bjwtBh = bjwtBh;
    }

    public void setWtmxBh(String wtmxBh) {
        this.wtmxBh = wtmxBh;
    }

    public void setWtmxMc(String wtmxMc) {
        this.wtmxMc = wtmxMc;
    }

    public void setWtlyBh(String wtlyBh) {
        this.wtlyBh = wtlyBh;
    }

    public void setWtlyMc(String wtlyMc) {
        this.wtlyMc = wtlyMc;
    }

    public void setSjly(String sjly) {
        this.sjly = sjly;
    }

    public void setWtwd1(String wtwd1) {
        this.wtwd1 = wtwd1;
    }

    public void setWtwd2(String wtwd2) {
        this.wtwd2 = wtwd2;
    }

    public void setWtwd3(String wtwd3) {
        this.wtwd3 = wtwd3;
    }

    public void setWtwd4(String wtwd4) {
        this.wtwd4 = wtwd4;
    }

    public void setWtwd5(String wtwd5) {
        this.wtwd5 = wtwd5;
    }

    public void setYwryBh(String ywryBh) {
        this.ywryBh = ywryBh;
    }

    public void setYwryXm(String ywryXm) {
        this.ywryXm = ywryXm;
    }

    public void setYwrySfzhm(String ywrySfzhm) {
        this.ywrySfzhm = ywrySfzhm;
    }

    public void setYwryJh(String ywryJh) {
        this.ywryJh = ywryJh;
    }

    public void setYwdwBm(String ywdwBm) {
        this.ywdwBm = ywdwBm;
    }

    public void setYwdwMc(String ywdwMc) {
        this.ywdwMc = ywdwMc;
    }

    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }

    public void setBzOwnerDept1(String bzOwnerDept1) {
        this.bzOwnerDept1 = bzOwnerDept1;
    }

    public void setBzOwnerDept2(String bzOwnerDept2) {
        this.bzOwnerDept2 = bzOwnerDept2;
    }

    public void setBzOwnerDept3(String bzOwnerDept3) {
        this.bzOwnerDept3 = bzOwnerDept3;
    }

    public void setBzOwnerDept4(String bzOwnerDept4) {
        this.bzOwnerDept4 = bzOwnerDept4;
    }

    public void setBzOwnerDept5(String bzOwnerDept5) {
        this.bzOwnerDept5 = bzOwnerDept5;
    }

    public void setWtzt(String wtzt) {
        this.wtzt = wtzt;
    }

    public void setWtzt2(String wtzt2) {
        this.wtzt2 = wtzt2;
    }

    public void setWtlx(String wtlx) {
        this.wtlx = wtlx;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedDeptId(String createdDeptId) {
        this.createdDeptId = createdDeptId;
    }

    public void setCreatedDeptName(String createdDeptName) {
        this.createdDeptName = createdDeptName;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setModifiedDeptId(String modifiedDeptId) {
        this.modifiedDeptId = modifiedDeptId;
    }

    public void setModifiedDeptName(String modifiedDeptName) {
        this.modifiedDeptName = modifiedDeptName;
    }
}
