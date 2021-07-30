package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpAlarmType;
import com.pkusoft.jjpt.req.SpAlarmTypeReqParam;


public interface SpAlarmTypeService {

    /**
     * 查询报警类别/报警类型/报警细类字典表集合
     * @return
     */
    List<SpAlarmType> getSpAlarmTypeListByLevelAndType(SpAlarmType spAlarmType);

    /**
    * 查询报警类别/报警类型/报警细类字典表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpAlarmType> getSpAlarmTypeList(SpAlarmTypeReqParam spAlarmType,Map<String, String> map);

    /**
    * 查询报警类别/报警类型/报警细类字典表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpAlarmTypeCount(SpAlarmTypeReqParam spAlarmType,Map<String, String> map);

    /**
    * 新增报警类别/报警类型/报警细类字典表
    * @param spAlarmType	报警类别/报警类型/报警细类字典表
    * @param map	用户集合
    * @return
    */
    int spAlarmTypeSave(SpAlarmType spAlarmType, Map<String,String> map);

    /**
    * 修改报警类别/报警类型/报警细类字典表
    * @param spAlarmType	报警类别/报警类型/报警细类字典表
    * @param map	用户集合
    * @return
    */
    int spAlarmTypeUpdate(SpAlarmType spAlarmType, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpAlarmType getSpAlarmType(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spAlarmTypeDelete(String objid);

}