package com.pkusoft.pzzx.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.pzzx.po.BdParam;
import com.pkusoft.pzzx.req.BdParamReqParam;


public interface BdParamService {

    /**
    * 查询基础数据_接警平台参数配置表集合
    * @param map	查询条件集合
    * @return
    */
    List<BdParam> getBdParamList(BdParamReqParam bdParam,Map<String, String> map);

    /**
    * 查询基础数据_接警平台参数配置表总数
    * @param map	查询条件集合
    * @return
    */
    int getBdParamCount(BdParamReqParam bdParam,Map<String, String> map);

    /**
    * 新增基础数据_接警平台参数配置表
    * @param bdParam	基础数据_接警平台参数配置表
    * @param map	用户集合
    * @return
    */
    int bdParamSave(BdParam bdParam, Map<String,String> map);

    /**
    * 修改基础数据_接警平台参数配置表
    * @param bdParam	基础数据_接警平台参数配置表
    * @param map	用户集合
    * @return
    */
    int bdParamUpdate(BdParam bdParam, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param paraCode
    * @return
    */
    BdParam getBdParam(String paraCode);

    /**
    * 根据主键ID删除规则信息
    * @param paraCode
    * @return
    */
    int bdParamDelete(String paraCode);

}