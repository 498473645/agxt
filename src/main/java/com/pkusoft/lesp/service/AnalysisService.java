package com.pkusoft.lesp.service;

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

}
