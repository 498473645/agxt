package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.SysDicitem;

/**
* @author
* @title: SysDicitemService
*/
public interface SysDicitemService {

    /**
    * 查询系统字典表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysDicitem> getSysDicitemList(Map<String, String> map);

    /**
    * 查询系统字典表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysDicitemCount(Map<String, String> map);

    /**
    * 新增系统字典表
    * @param sysDicitem	系统字典表
    * @param map	用户集合
    * @return
    */
    int sysDicitemSave(SysDicitem sysDicitem, Map<String,String> map);

    /**
    * 修改系统字典表
    * @param sysDicitem	系统字典表
    * @param map	用户集合
    * @return
    */
    int sysDicitemUpdate(SysDicitem sysDicitem, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    SysDicitem getSysDicitem(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int sysDicitemDelete(String id);

}
