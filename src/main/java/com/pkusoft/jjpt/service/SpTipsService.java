package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpTips;
import com.pkusoft.jjpt.req.SpTipsReqParam;


public interface SpTipsService {

    /**
    * 查询业务数据_提示板信息储存表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpTips> getSpTipsList(SpTipsReqParam spTips,Map<String, String> map);

    /**
    * 查询业务数据_提示板信息储存表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpTipsCount(SpTipsReqParam spTips,Map<String, String> map);

    /**
    * 新增业务数据_提示板信息储存表
    * @param spTips	业务数据_提示板信息储存表
    * @param map	用户集合
    * @return
    */
    int spTipsSave(SpTips spTips, Map<String,String> map);

    /**
    * 修改业务数据_提示板信息储存表
    * @param spTips	业务数据_提示板信息储存表
    * @param map	用户集合
    * @return
    */
    int spTipsUpdate(SpTips spTips, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpTips getSpTips(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spTipsDelete(String objid);

}