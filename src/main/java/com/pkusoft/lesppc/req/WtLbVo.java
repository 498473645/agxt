package com.pkusoft.lesppc.req;


public class WtLbVo {

    /**
     * 问题列表主键
     */
    private String id;
    /**
     * 案件编号（问题维度1）
     */
    private String ajbh;
    /**
     * 案件名称（问题维度2）
     */
    private String ajmc;
    /**
     * 模型类别名称（问题模型名称）
     */
    private String mxlbmc;
    /**
     * 业务单位编号
     */
    private String deptId;
    /**
     * 业务单位名称
     */
    private String deptName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getAjmc() {
        return ajmc;
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    public String getMxlbmc() {
        return mxlbmc;
    }

    public void setMxlbmc(String mxlbmc) {
        this.mxlbmc = mxlbmc;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
