package com.pkusoft.usercenter.vo;

import com.pkusoft.lesp.po.StatisticsData;

import java.util.List;

public class DeptTree {
    private String deptId;

    private String deptName;

    private String deptLevel;

    private String parentDeptId;

    private List<DeptTree> children;

    private StatisticsData statisticsData;

    public StatisticsData getStatisticsData() {
        return statisticsData;
    }

    public void setStatisticsData(StatisticsData statisticsData) {
        this.statisticsData = statisticsData;
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

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public List<DeptTree> getChildren() {
        return children;
    }

    public void setChildren(List<DeptTree> children) {
        this.children = children;
    }
}
