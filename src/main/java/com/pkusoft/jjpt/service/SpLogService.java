package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpLog;
import com.pkusoft.jjpt.req.SpLogReqParam;


public interface SpLogService {

    /**
    * 查询接口调用日志表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpLog> getSpLogList(SpLogReqParam spLog,Map<String, String> map);

    /**
    * 查询接口调用日志表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpLogCount(SpLogReqParam spLog,Map<String, String> map);

    /**
    * 新增接口调用日志表
    * @param spLog	接口调用日志表
    * @param map	用户集合
    * @return
    */
    int spLogSave(SpLog spLog, Map<String,String> map);

    /**
    * 修改接口调用日志表
    * @param spLog	接口调用日志表
    * @param map	用户集合
    * @return
    */
    int spLogUpdate(SpLog spLog, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpLog getSpLog(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spLogDelete(String objid);

}