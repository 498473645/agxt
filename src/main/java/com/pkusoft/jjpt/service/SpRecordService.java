package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpRecord;
import com.pkusoft.jjpt.req.SpRecordReqParam;


public interface SpRecordService {

    /**
    * 查询业务数据_笔录信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpRecord> getSpRecordList(SpRecordReqParam spRecord,Map<String, String> map);

    /**
    * 查询业务数据_笔录信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpRecordCount(SpRecordReqParam spRecord,Map<String, String> map);

    /**
    * 新增业务数据_笔录信息表
    * @param spRecord	业务数据_笔录信息表
    * @param map	用户集合
    * @return
    */
    int spRecordSave(SpRecord spRecord, Map<String,String> map);

    /**
     * 保存主方法
     * @param spRecord
     * @param map
     * @return
     */
    int doSpRecordSave(SpRecord spRecord, Map<String,String> map);

    /**
    * 修改业务数据_笔录信息表
    * @param spRecord	业务数据_笔录信息表
    * @param map	用户集合
    * @return
    */
    int spRecordUpdate(SpRecord spRecord, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpRecord getSpRecord(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spRecordDelete(String objid);

    /**
     * 查看当前笔录是第几次，用于打印页面的显示
     * @param spRecord
     * @return
     */
    int getRecordTime(SpRecord spRecord);

}
