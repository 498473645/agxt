package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpCallRecord;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpCallRecordReqParam;


public interface SpCallRecordService {

    /**
    * 查询业务数据_通话记录表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpCallRecord> getSpCallRecordList(SpCallRecordReqParam spCallRecord,Map<String, String> map);

    /**
    * 查询业务数据_通话记录表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpCallRecordCount(SpCallRecordReqParam spCallRecord,Map<String, String> map);

    /**
     * 查询业务数据_通话记录表集合
     * @param map	查询条件集合
     * @return
     */
    List<SpCallRecord> getActiveCallRecordList(SpCallRecordReqParam spCallRecord,Map<String, String> map);
    int getActiveCallRecordCount(String callStatus,Map<String, String> map);

    /**
    * 新增业务数据_通话记录表
    * @param spCallRecord	业务数据_通话记录表
    * @param map	用户集合
    * @return
    */
    int spCallRecordSave(SpCallRecord spCallRecord, Map<String,String> map);

    /**
    * 修改业务数据_通话记录表
    * @param spCallRecord	业务数据_通话记录表
    * @param map	用户集合
    * @return
    */
    int spCallRecordUpdate(SpCallRecord spCallRecord, Map<String,String> map);

    /**
     * 电话警情在处警后闭环所有该电话的预报警
     * @param map
     * @return
     */
    int updateAllRelatedSpCall(SpJjxx spJjxx, Map<String,String> map);

    /**
     * 稍后录入：在闭环警情的同时，生成一条无报警数据的接警数据
     * @param spCallRecord
     * @param map
     * @return
     */
    int laterHandlePolice(SpCallRecord spCallRecord, Map<String,String> map);

    /**
     * 无效报警：在闭环电话的同时，生成一条接警数据和处警数据
     * @param spCallRecord
     * @param map
     * @return
     */
    int noUseCallRecord(SpCallRecordReqParam spCallRecord, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpCallRecord getSpCallRecord(String objid);

    /**
     * 查看固定时间内是否已来电过
     * @param ldhm 电话号码
     * @param time 小时数，若为3，则是查询3小时内数据
     * @return
     * @throws Exception
     */
    int ifAlreadyCalledWithinTime(String ldhm, String time) throws Exception ;

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spCallRecordDelete(String objid);

}