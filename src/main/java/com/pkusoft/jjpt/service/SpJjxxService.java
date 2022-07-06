package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpJjxxReqParam;


public interface SpJjxxService {

    /**
    * 查询业务数据_接警信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpJjxx> getSpJjxxList(SpJjxxReqParam spJjxx,Map<String, String> map);

    /**
    * 查询业务数据_接警信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpJjxxCount(SpJjxxReqParam spJjxx,Map<String, String> map);

    /**
     * 查询最近受理任务
     * @param spJjxx
     * @param user
     * @return
     */
    List<SpJjxx> selectRecentSpJjxxList(SpJjxxReqParam spJjxx,Map<String,String> user);

    /**
     * 查询最近受理任务数量
     * @param spJjxx
     * @param user
     * @return
     */
    int selectRecentSpJjxxCount(SpJjxxReqParam spJjxx,Map<String,String> user);


    Map<String, Integer> getBigscreenSpJjxxCount(Map<String,String> user);

    /**
    * 新增业务数据_接警信息表
    * @param spJjxx	业务数据_接警信息表
    * @param map	用户集合
    * @return
    */
    int spJjxxSave(SpJjxx spJjxx, Map<String,String> map);

    /**
     * 仅插入一条数据
     * @param spJjxx
     * @return
     */
    int spJjxxSave(SpJjxx spJjxx);

    /**
     * 通用保存
     * @param spJjxx
     * @param map
     * @return
     */
    int doSpJjxxSave(SpJjxx spJjxx, Map<String,String> map);

    /**
     * 派警及反馈修改报警状态
     * @return
     */
    String receiveAlarmAndSendPolice(SpJjxx spJjxx, Map<String, String> user);

    /**
     * 黄冈报警编号生成规则：单位编号+时间戳
     * @return
     */
    String generateJjdbh(String orgCode);

    /**
     * 黄冈处警编号生成规则：单位编号+时间戳
     * @return
     */
    String generateCjdbh(String orgCode);

    /**
    * 修改业务数据_接警信息表
    * @param spJjxx	业务数据_接警信息表
    * @param map	用户集合
    * @return
    */
    int spJjxxUpdate(SpJjxx spJjxx, Map<String,String> map);

    /**
     * 修改接警信息
     * @param spJjxx	业务数据_接警信息表
     * @param map	用户集合
     * @return
     */
    int updateSpJjxx(SpJjxx spJjxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpJjxx getSpJjxx(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spJjxxDelete(String objid);

    /**
     * 根据登录人信息查询接警信息
     * @param objid
     * @param status
     * @return
     */
    List<SpJjxx> spJjxxByCjrCode(String objid,String status);

    SpJjxx getSpJjxxData(SpJjxx spJjxx);
}
