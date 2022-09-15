package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.SmartDev;

/**
* @author
* @title: SmartDevService
*/
public interface SmartDevService {

    /**
    * 查询案管智能终端设备信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SmartDev> getSmartDevList(Map<String, String> map);

    /**
    * 查询案管智能终端设备信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSmartDevCount(Map<String, String> map);

    /**
    * 新增案管智能终端设备信息表
    * @param smartDev	案管智能终端设备信息表
    * @param map	用户集合
    * @return
    */
    int smartDevSave(SmartDev smartDev, Map<String,String> map);

    /**
    * 修改案管智能终端设备信息表
    * @param smartDev	案管智能终端设备信息表
    * @param map	用户集合
    * @return
    */
    int smartDevUpdate(SmartDev smartDev, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    SmartDev getSmartDev(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int smartDevDelete(String id);

}
