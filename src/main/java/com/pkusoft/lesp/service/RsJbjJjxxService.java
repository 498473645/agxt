package com.pkusoft.lesp.service;

import com.pkusoft.lesp.po.RsJbjJjxx;
import com.pkusoft.lesp.po.StatisticsData;

import java.util.List;
import java.util.Map;


public interface RsJbjJjxxService {

    /**
     * 接警数据
     * @param deptId
     * @param year
     * @param month
     * @return
     */
    StatisticsData getMonthlyJjData(String deptId, String year, String month);

    /**
     * 分类警情
     * @param deptId
     * @param year
     * @param month
     * @return
     */
    StatisticsData getMonthlyFljqData(String deptId, String year, String month);

//    /**
//     * 最近趋势
//     * @param deptId
//     * @return
//     */
//    Map<String,Object> getZjqsData(String deptId);

    /**
    * 查询要素数据_接警信息集合
    * @param map	查询条件集合
    * @return
    */
    List<RsJbjJjxx> getRsJbjJjxxList(Map<String, String> map);

    /**
    * 查询要素数据_接警信息总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjJjxxCount(Map<String, String> map);

    /**
    * 新增要素数据_接警信息
    * @param rsJbjJjxx	要素数据_接警信息
    * @param map	用户集合
    * @return
    */
    int rsJbjJjxxSave(RsJbjJjxx rsJbjJjxx, Map<String, String> map);

    /**
    * 修改要素数据_接警信息
    * @param rsJbjJjxx	要素数据_接警信息
    * @param map	用户集合
    * @return
    */
    int rsJbjJjxxUpdate(RsJbjJjxx rsJbjJjxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param jjdbh
    * @return
    */
    RsJbjJjxx getRsJbjJjxx(String jjdbh);

    /**
    * 根据主键ID删除规则信息
    * @param jjdbh
    * @return
    */
    int rsJbjJjxxDelete(String[] jjdbh);

}