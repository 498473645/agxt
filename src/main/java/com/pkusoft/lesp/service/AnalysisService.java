package com.pkusoft.lesp.service;

import com.pkusoft.usercenter.vo.DeptTree;

import java.util.List;
import java.util.Map;


public interface AnalysisService {


    /**
     * 预报警数据
     * @param deptId
     * @return
     */
    Map<String,Object> getYbjData(String deptId, String deptLevel, String dataType);

    /**
     * 接警数据
     * @return
     */
    Map<String,Object> getJjData(String deptId, String deptLevel, String dataType);

    /**
     * 处警反馈
     * @return
     */
    Map<String,Object> getCjfkData(String deptId, String deptLevel, String dataType);

    /**
     * 预报警分类
     * @return
     */
    Map<String,Object> getYbjflData(String deptId, String deptLevel, String dataType);

    /**
     * 分类警情
     * @return
     */
    Map<String,Object> getFljqData(String deptId, String deptLevel, String dataType);

    /**
     * 最近趋势
     * @param deptId
     * @return
     */
    Map<String,Object> getZjqsData(String deptId, String deptLevel, String dataType);

//    /**
//     * 分类警情
//     * @param deptId
//     * @param year
//     * @param month
//     * @return
//     */
//    StatisticsData getMonthlyFljqData(String deptId, String year, String month);
//
//    /**
//     * 最近趋势
//     * @param deptId
//     * @return
//     */
//    Map<String,Object> getZjqsData(String deptId);
//
//    /**
//     * 预报警数据
//     * @param deptId
//     * @param year
//     * @param month
//     * @return
//     */
//    StatisticsData getYbjData(String deptId,String year,String month);
//
//    /**
//     * 预报警数据
//     * @param deptId
//     * @param year
//     * @param month
//     * @return
//     */
//    StatisticsData getMonthlyYbjflData(String deptId,String year,String month);


    /**
     * 上门报案
     * @param deptId
     * @return
     */
    Map<String,Object> getSmbaData(String deptId, String deptLevel, String dataType);

    /**
     * 预报案方式对比
     * @param deptId
     * @return
     */
    Map<String,Object> getYbafsdbData(String deptId, String deptLevel, String dataType);

    /**
     * 预报案处理状态分析
     * @param deptId
     * @return
     */
    Map<String,Object> getYbaclztfxData(String deptId, String deptLevel, String dataType);

    /**
     * 报案类型分析
     * @param deptId
     * @return
     */
    Map<String,Object> getBalxData(String deptId, String deptLevel, String dataType);

    /**
     * 评议占比分析
     * @param deptId
     * @return
     */
    Map<String,Object> getPyzbData(String deptId, String deptLevel, String dataType);

    /**
     * 评议满意度分析
     * @param deptId
     * @return
     */
    Map<String,Object> getPymydData(String deptId, String deptLevel, String dataType);

    /**
     * 单位实时数据
     * @param deptId
     * @return
     */
    List<DeptTree> getYbaclztfxDataByDept(String deptId, String deptLevel, String dataType);
}
