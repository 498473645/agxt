package com.pkusoft.lesp.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;
import java.util.Date;

/**
 * @author
 * @title: RsJbjJgxtDynamic
 */
@ApiModel("接报警监管系统动态数据表")
@Table(name = "RS_JBJ_JGXT_DYNAMIC")
public class RsJbjJgxtDynamic {

    /**
     * 接警编号*
     */
    @Id
    @Column(name = "JJBH")
    @ApiModelProperty(value = "接警编号*")
    private String jjbh;

    /**
     * 接警单编号
     */
    @Column(name = "JJDBH")
    @ApiModelProperty(value = "接警单编号")
    private String jjdbh;

    /**
     * 案件编号
     */
    @Column(name = "AJBH")
    @ApiModelProperty(value = "案件编号")
    private String ajbh;

    /**
     * 来源*(自助机，公众号)
     */
    @Column(name = "JQLY")
    @ApiModelProperty(value = "来源*(自助机，公众号)")
    private String jqly;

    /**
     * 报警人姓名*
     */
    @Column(name = "BJRXM")
    @ApiModelProperty(value = "报警人姓名*")
    private String bjrxm;

    /**
     * 报警人公民身份证号码*
     */
    @Column(name = "BJRGMSFHM")
    @ApiModelProperty(value = "报警人公民身份证号码*")
    private String bjrgmsfhm;

    /**
     * 事发地点*
     */
    @Column(name = "SFDD")
    @ApiModelProperty(value = "事发地点*")
    private String sfdd;

    /**
     * 报警时间*
     */
    @Column(name = "BJSJ")
    @ApiModelProperty(value = "报警时间*")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date bjsj;

    /**
     * 报警人性别*
     */
    @Column(name = "BJRXB")
    @ApiModelProperty(value = "报警人性别*")
    private String bjrxb;

    /**
     * 报警人联系电话*
     */
    @Column(name = "BJRLXDH")
    @ApiModelProperty(value = "报警人联系电话*")
    private String bjrlxdh;

    /**
     * 报警电话*
     */
    @Column(name = "BJDH")
    @ApiModelProperty(value = "报警电话*")
    private String bjdh;

    /**
     * 简要案情*
     */
    @Column(name = "JYAQ")
    @ApiModelProperty(value = "简要案情*")
    private String jyaq;

    /**
     * 接警人姓名*
     */
    @Column(name = "JJRXM")
    @ApiModelProperty(value = "接警人姓名*")
    private String jjrxm;

    /**
     * 接警单位*
     */
    @Column(name = "JJDW")
    @ApiModelProperty(value = "接警单位*")
    private String jjdw;

    /**
     * 接警单位名称*
     */
    @Column(name = "JJDWMC")
    @ApiModelProperty(value = "接警单位名称*")
    private String jjdwmc;

    /**
     * 接警时间*
     */
    @Column(name = "JJSJ")
    @ApiModelProperty(value = "接警时间*")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date jjsj;

    /**
     * 警情类别*
     */
    @Column(name = "JQTYPEID1")
    @ApiModelProperty(value = "警情类别*")
    private String jqtypeid1;

    /**
     * 警情类别名称*
     */
    @Column(name = "JQTYPE_NAME1")
    @ApiModelProperty(value = "警情类别名称*")
    private String jqtypeName1;

    /**
     * 警情类型*
     */
    @Column(name = "JQTYPEID2")
    @ApiModelProperty(value = "警情类型*")
    private String jqtypeid2;

    /**
     * 警情类型名称*
     */
    @Column(name = "JQTYPE_NAME2")
    @ApiModelProperty(value = "警情类型名称*")
    private String jqtypeName2;

    /**
     * 警情细类*
     */
    @Column(name = "JQTYPEID3")
    @ApiModelProperty(value = "警情细类*")
    private String jqtypeid3;

    /**
     * 警情细类名称*
     */
    @Column(name = "JQTYPE_NAME3")
    @ApiModelProperty(value = "警情细类名称*")
    private String jqtypeName3;

    /**
     * 报警内容*
     */
    @Column(name = "BJNR")
    @ApiModelProperty(value = "报警内容*")
    private String bjnr;

    /**
     * 处警人
     */
    @Column(name = "CJR")
    @ApiModelProperty(value = "处警人")
    private String cjr;

    /**
     * 处警类别代码
     */
    @Column(name = "CJLBDM")
    @ApiModelProperty(value = "处警类别代码")
    private String cjlbdm;

    /**
     * 处警类别
     */
    @Column(name = "CJLB")
    @ApiModelProperty(value = "处警类别")
    private String cjlb;

    /**
     * 处警时间
     */
    @Column(name = "CJSJ")
    @ApiModelProperty(value = "处警时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date cjsj;

    /**
     * 处警结果内容
     */
    @Column(name = "CJJGNR")
    @ApiModelProperty(value = "处警结果内容")
    private String cjjgnr;

    /**
     * 处警结果
     */
    @Column(name = "CJJG")
    @ApiModelProperty(value = "处警结果")
    private String cjjg;

    /**
     * 处警结果代码
     */
    @Column(name = "CJJGDM")
    @ApiModelProperty(value = "处警结果代码")
    private String cjjgdm;

    /**
     * 处警单位
     */
    @Column(name = "CJDW")
    @ApiModelProperty(value = "处警单位")
    private String cjdw;

    /**
     * 处警单位名称
     */
    @Column(name = "CJDWMC")
    @ApiModelProperty(value = "处警单位名称")
    private String cjdwmc;

    /**
     * 审批日期
     */
    @Column(name = "SPRQ")
    @ApiModelProperty(value = "审批日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date sprq;

    /**
     * 审批意见
     */
    @Column(name = "SPYJ")
    @ApiModelProperty(value = "审批意见")
    private String spyj;

    /**
     * 公安归属单位1*
     */
    @Column(name = "GA_OWNER_DEPT_1")
    @ApiModelProperty(value = "公安归属单位1*")
    private String gaOwnerDept1;

    /**
     * 公安归属单位2*
     */
    @Column(name = "GA_OWNER_DEPT_2")
    @ApiModelProperty(value = "公安归属单位2*")
    private String gaOwnerDept2;

    /**
     * 公安归属单位3*
     */
    @Column(name = "GA_OWNER_DEPT_3")
    @ApiModelProperty(value = "公安归属单位3*")
    private String gaOwnerDept3;

    /**
     * 公安归属单位4*
     */
    @Column(name = "GA_OWNER_DEPT_4")
    @ApiModelProperty(value = "公安归属单位4*")
    private String gaOwnerDept4;

    /**
     * 公安归属单位5*
     */
    @Column(name = "GA_OWNER_DEPT_5")
    @ApiModelProperty(value = "公安归属单位5*")
    private String gaOwnerDept5;

    /**
     * 修改时间
     */
    @Column(name = "XGSJ")
    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date xgsj;

    /**
     * 案发时间
     */
    @Column(name = "AFSJ")
    @ApiModelProperty(value = "案发时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "PRC")
    private java.util.Date afsj;

    /**
     * 案件类型
     */
    @Column(name = "AJLX")
    @ApiModelProperty(value = "案件类型")
    private String ajlx;

    public String getAjlx() {
        return ajlx;
    }

    public void setAjlx(String ajlx) {
        this.ajlx = ajlx;
    }

    public Date getAfsj() {
        return afsj;
    }

    public void setAfsj(Date afsj) {
        this.afsj = afsj;
    }

    /**
     * 获得接警编号*
     * @return JJBH
     */
    public String getJjbh() {
        return this.jjbh;
    }

    /**
     * 设置接警编号*
     * @param jjbh
     */
    public void setJjbh(String jjbh) {
        this.jjbh = jjbh;
    }

    /**
     * 获得接警单编号
     * @return JJDBH
     */
    public String getJjdbh() {
        return this.jjdbh;
    }

    /**
     * 设置接警单编号
     * @param jjdbh
     */
    public void setJjdbh(String jjdbh) {
        this.jjdbh = jjdbh;
    }

    /**
     * 获得案件编号
     * @return AJBH
     */
    public String getAjbh() {
        return this.ajbh;
    }

    /**
     * 设置案件编号
     * @param ajbh
     */
    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    /**
     * 获得来源*(自助机，公众号)
     * @return JQLY
     */
    public String getJqly() {
        return this.jqly;
    }

    /**
     * 设置来源*(自助机，公众号)
     * @param jqly
     */
    public void setJqly(String jqly) {
        this.jqly = jqly;
    }

    /**
     * 获得报警人姓名*
     * @return BJRXM
     */
    public String getBjrxm() {
        return this.bjrxm;
    }

    /**
     * 设置报警人姓名*
     * @param bjrxm
     */
    public void setBjrxm(String bjrxm) {
        this.bjrxm = bjrxm;
    }

    /**
     * 获得报警人公民身份证号码*
     * @return BJRGMSFHM
     */
    public String getBjrgmsfhm() {
        return this.bjrgmsfhm;
    }

    /**
     * 设置报警人公民身份证号码*
     * @param bjrgmsfhm
     */
    public void setBjrgmsfhm(String bjrgmsfhm) {
        this.bjrgmsfhm = bjrgmsfhm;
    }

    /**
     * 获得事发地点*
     * @return SFDD
     */
    public String getSfdd() {
        return this.sfdd;
    }

    /**
     * 设置事发地点*
     * @param sfdd
     */
    public void setSfdd(String sfdd) {
        this.sfdd = sfdd;
    }

    /**
     * 获得报警人性别*
     * @return BJRXB
     */
    public String getBjrxb() {
        return this.bjrxb;
    }

    /**
     * 设置报警人性别*
     * @param bjrxb
     */
    public void setBjrxb(String bjrxb) {
        this.bjrxb = bjrxb;
    }

    /**
     * 获得报警人联系电话*
     * @return BJRLXDH
     */
    public String getBjrlxdh() {
        return this.bjrlxdh;
    }

    /**
     * 设置报警人联系电话*
     * @param bjrlxdh
     */
    public void setBjrlxdh(String bjrlxdh) {
        this.bjrlxdh = bjrlxdh;
    }

    /**
     * 获得报警电话*
     * @return BJDH
     */
    public String getBjdh() {
        return this.bjdh;
    }

    /**
     * 设置报警电话*
     * @param bjdh
     */
    public void setBjdh(String bjdh) {
        this.bjdh = bjdh;
    }

    /**
     * 获得简要案情*
     * @return JYAQ
     */
    public String getJyaq() {
        return this.jyaq;
    }

    /**
     * 设置简要案情*
     * @param jyaq
     */
    public void setJyaq(String jyaq) {
        this.jyaq = jyaq;
    }

    /**
     * 获得接警人姓名*
     * @return JJRXM
     */
    public String getJjrxm() {
        return this.jjrxm;
    }

    /**
     * 设置接警人姓名*
     * @param jjrxm
     */
    public void setJjrxm(String jjrxm) {
        this.jjrxm = jjrxm;
    }

    /**
     * 获得接警单位*
     * @return JJDW
     */
    public String getJjdw() {
        return this.jjdw;
    }

    /**
     * 设置接警单位*
     * @param jjdw
     */
    public void setJjdw(String jjdw) {
        this.jjdw = jjdw;
    }

    /**
     * 获得接警单位名称*
     * @return JJDWMC
     */
    public String getJjdwmc() {
        return this.jjdwmc;
    }

    /**
     * 设置接警单位名称*
     * @param jjdwmc
     */
    public void setJjdwmc(String jjdwmc) {
        this.jjdwmc = jjdwmc;
    }

    /**
     * 获得接警时间*
     * @return JJSJ
     */
    public java.util.Date getJjsj() {
        return this.jjsj;
    }

    /**
     * 设置接警时间*
     * @param jjsj
     */
    public void setJjsj(java.util.Date jjsj) {
        this.jjsj = jjsj;
    }

    /**
     * 获得警情类别*
     * @return JQTYPEID1
     */
    public String getJqtypeid1() {
        return this.jqtypeid1;
    }

    /**
     * 设置警情类别*
     * @param jqtypeid1
     */
    public void setJqtypeid1(String jqtypeid1) {
        this.jqtypeid1 = jqtypeid1;
    }

    /**
     * 获得警情类别名称*
     * @return JQTYPE_NAME1
     */
    public String getJqtypeName1() {
        return this.jqtypeName1;
    }

    /**
     * 设置警情类别名称*
     * @param jqtypeName1
     */
    public void setJqtypeName1(String jqtypeName1) {
        this.jqtypeName1 = jqtypeName1;
    }

    /**
     * 获得警情类型*
     * @return JQTYPEID2
     */
    public String getJqtypeid2() {
        return this.jqtypeid2;
    }

    /**
     * 设置警情类型*
     * @param jqtypeid2
     */
    public void setJqtypeid2(String jqtypeid2) {
        this.jqtypeid2 = jqtypeid2;
    }

    /**
     * 获得警情类型名称*
     * @return JQTYPE_NAME2
     */
    public String getJqtypeName2() {
        return this.jqtypeName2;
    }

    /**
     * 设置警情类型名称*
     * @param jqtypeName2
     */
    public void setJqtypeName2(String jqtypeName2) {
        this.jqtypeName2 = jqtypeName2;
    }

    /**
     * 获得警情细类*
     * @return JQTYPEID3
     */
    public String getJqtypeid3() {
        return this.jqtypeid3;
    }

    /**
     * 设置警情细类*
     * @param jqtypeid3
     */
    public void setJqtypeid3(String jqtypeid3) {
        this.jqtypeid3 = jqtypeid3;
    }

    /**
     * 获得警情细类名称*
     * @return JQTYPE_NAME3
     */
    public String getJqtypeName3() {
        return this.jqtypeName3;
    }

    /**
     * 设置警情细类名称*
     * @param jqtypeName3
     */
    public void setJqtypeName3(String jqtypeName3) {
        this.jqtypeName3 = jqtypeName3;
    }

    /**
     * 获得报警内容*
     * @return BJNR
     */
    public String getBjnr() {
        return this.bjnr;
    }

    /**
     * 设置报警内容*
     * @param bjnr
     */
    public void setBjnr(String bjnr) {
        this.bjnr = bjnr;
    }

    /**
     * 获得处警人
     * @return CJR
     */
    public String getCjr() {
        return this.cjr;
    }

    /**
     * 设置处警人
     * @param cjr
     */
    public void setCjr(String cjr) {
        this.cjr = cjr;
    }

    /**
     * 获得处警类别代码
     * @return CJLBDM
     */
    public String getCjlbdm() {
        return this.cjlbdm;
    }

    /**
     * 设置处警类别代码
     * @param cjlbdm
     */
    public void setCjlbdm(String cjlbdm) {
        this.cjlbdm = cjlbdm;
    }

    /**
     * 获得处警类别
     * @return CJLB
     */
    public String getCjlb() {
        return this.cjlb;
    }

    /**
     * 设置处警类别
     * @param cjlb
     */
    public void setCjlb(String cjlb) {
        this.cjlb = cjlb;
    }

    /**
     * 获得处警时间
     * @return CJSJ
     */
    public java.util.Date getCjsj() {
        return this.cjsj;
    }

    /**
     * 设置处警时间
     * @param cjsj
     */
    public void setCjsj(java.util.Date cjsj) {
        this.cjsj = cjsj;
    }

    /**
     * 获得处警结果内容
     * @return CJJGNR
     */
    public String getCjjgnr() {
        return this.cjjgnr;
    }

    /**
     * 设置处警结果内容
     * @param cjjgnr
     */
    public void setCjjgnr(String cjjgnr) {
        this.cjjgnr = cjjgnr;
    }

    /**
     * 获得处警结果
     * @return CJJG
     */
    public String getCjjg() {
        return this.cjjg;
    }

    /**
     * 设置处警结果
     * @param cjjg
     */
    public void setCjjg(String cjjg) {
        this.cjjg = cjjg;
    }

    /**
     * 获得处警结果代码
     * @return CJJGDM
     */
    public String getCjjgdm() {
        return this.cjjgdm;
    }

    /**
     * 设置处警结果代码
     * @param cjjgdm
     */
    public void setCjjgdm(String cjjgdm) {
        this.cjjgdm = cjjgdm;
    }

    /**
     * 获得处警单位
     * @return CJDW
     */
    public String getCjdw() {
        return this.cjdw;
    }

    /**
     * 设置处警单位
     * @param cjdw
     */
    public void setCjdw(String cjdw) {
        this.cjdw = cjdw;
    }

    /**
     * 获得处警单位名称
     * @return CJDWMC
     */
    public String getCjdwmc() {
        return this.cjdwmc;
    }

    /**
     * 设置处警单位名称
     * @param cjdwmc
     */
    public void setCjdwmc(String cjdwmc) {
        this.cjdwmc = cjdwmc;
    }

    /**
     * 获得审批日期
     * @return SPRQ
     */
    public java.util.Date getSprq() {
        return this.sprq;
    }

    /**
     * 设置审批日期
     * @param sprq
     */
    public void setSprq(java.util.Date sprq) {
        this.sprq = sprq;
    }

    /**
     * 获得审批意见
     * @return SPYJ
     */
    public String getSpyj() {
        return this.spyj;
    }

    /**
     * 设置审批意见
     * @param spyj
     */
    public void setSpyj(String spyj) {
        this.spyj = spyj;
    }

    /**
     * 获得公安归属单位1*
     * @return GA_OWNER_DEPT_1
     */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
     * 设置公安归属单位1*
     * @param gaOwnerDept1
     */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
     * 获得公安归属单位2*
     * @return GA_OWNER_DEPT_2
     */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
     * 设置公安归属单位2*
     * @param gaOwnerDept2
     */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
     * 获得公安归属单位3*
     * @return GA_OWNER_DEPT_3
     */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
     * 设置公安归属单位3*
     * @param gaOwnerDept3
     */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
     * 获得公安归属单位4*
     * @return GA_OWNER_DEPT_4
     */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
     * 设置公安归属单位4*
     * @param gaOwnerDept4
     */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
     * 获得公安归属单位5*
     * @return GA_OWNER_DEPT_5
     */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
     * 设置公安归属单位5*
     * @param gaOwnerDept5
     */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }

    /**
     * 获得修改时间
     * @return XGSJ
     */
    public java.util.Date getXgsj() {
        return this.xgsj;
    }

    /**
     * 设置修改时间
     * @param xgsj
     */
    public void setXgsj(java.util.Date xgsj) {
        this.xgsj = xgsj;
    }

    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }
}
