package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpRecordTips;
import com.pkusoft.jjpt.req.SpRecordTipsReqParam;


public interface SpRecordTipsService {

    /**
    * 查询业务数据_笔录信息_提示板信息储存表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpRecordTips> getSpRecordTipsList(SpRecordTipsReqParam spRecordTips,Map<String, String> map);

    /**
    * 查询业务数据_笔录信息_提示板信息储存表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpRecordTipsCount(SpRecordTipsReqParam spRecordTips,Map<String, String> map);

    /**
    * 新增业务数据_笔录信息_提示板信息储存表
    * @param spRecordTips	业务数据_笔录信息_提示板信息储存表
    * @param map	用户集合
    * @return
    */
    int spRecordTipsSave(SpRecordTips spRecordTips, Map<String,String> map);

    /**
    * 修改业务数据_笔录信息_提示板信息储存表
    * @param spRecordTips	业务数据_笔录信息_提示板信息储存表
    * @param map	用户集合
    * @return
    */
    int spRecordTipsUpdate(SpRecordTips spRecordTips, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpRecordTips getSpRecordTips(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spRecordTipsDelete(String objid);

}