package com.pkusoft.lesp.service;

import com.pkusoft.lesp.po.RsJbjYbjxx;
import com.pkusoft.lesp.po.StatisticsData;

import java.util.List;
import java.util.Map;


public interface RsJbjYbjxxService {

    List<RsJbjYbjxx> getTelephoneData(String deptId, String deptLevel, String jqly);

    /**
     * 预报警数据
     * @param deptId
     * @param year
     * @param month
     * @return
     */
    StatisticsData getMonthlyYbjData(String deptId, String year, String month);

    /**
     * 预报警数据
     * @param deptId
     * @param year
     * @param month
     * @return
     */
    StatisticsData getMonthlyYbjflData(String deptId, String year, String month);

    /**
    * 查询要素数据_预报警基本信息集合
    * @param map	查询条件集合
    * @return
    */
    List<RsJbjYbjxx> getRsJbjYbjxxList(Map<String, String> map);

    /**
    * 查询要素数据_预报警基本信息总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjYbjxxCount(Map<String, String> map);

    /**
    * 新增要素数据_预报警基本信息
    * @param rsJbjYbjxx	要素数据_预报警基本信息
    * @param map	用户集合
    * @return
    */
    int rsJbjYbjxxSave(RsJbjYbjxx rsJbjYbjxx, Map<String, String> map);

    /**
    * 修改要素数据_预报警基本信息
    * @param rsJbjYbjxx	要素数据_预报警基本信息
    * @param map	用户集合
    * @return
    */
    int rsJbjYbjxxUpdate(RsJbjYbjxx rsJbjYbjxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param bjid
    * @return
    */
    RsJbjYbjxx getRsJbjYbjxx(String bjid);

    /**
    * 根据主键ID删除规则信息
    * @param bjid
    * @return
    */
    int rsJbjYbjxxDelete(String[] bjid);

}
