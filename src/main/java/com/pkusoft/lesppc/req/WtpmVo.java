package com.pkusoft.lesppc.req;

public class WtpmVo {

    /**
     * 单位编号
     */
    private String deptId;

    /**
     * 单位名称
     */
    private String deptName;

    /**
     * 问题统计数量
     */
    private int total;


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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
