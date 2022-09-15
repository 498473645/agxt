package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.SmartInfo;

/**
* @author
* @title: SmartInfoService
*/
public interface SmartInfoService {

    /**
    * 查询案管智能终端信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SmartInfo> getSmartInfoList(Map<String, String> map);

    /**
    * 查询案管智能终端信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSmartInfoCount(Map<String, String> map);

    /**
    * 新增案管智能终端信息表
    * @param smartInfo	案管智能终端信息表
    * @param map	用户集合
    * @return
    */
    int smartInfoSave(SmartInfo smartInfo, Map<String,String> map);

    /**
    * 修改案管智能终端信息表
    * @param smartInfo	案管智能终端信息表
    * @param map	用户集合
    * @return
    */
    int smartInfoUpdate(SmartInfo smartInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    SmartInfo getSmartInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int smartInfoDelete(String id);

}
