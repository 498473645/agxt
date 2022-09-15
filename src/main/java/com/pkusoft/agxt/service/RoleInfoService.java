package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.RoleInfo;

/**
* @author
* @title: RoleInfoService
*/
public interface RoleInfoService {

    /**
    * 查询角色信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<RoleInfo> getRoleInfoList(Map<String, String> map);

    /**
    * 查询角色信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getRoleInfoCount(Map<String, String> map);

    /**
    * 新增角色信息表
    * @param roleInfo	角色信息表
    * @param map	用户集合
    * @return
    */
    int roleInfoSave(RoleInfo roleInfo, Map<String,String> map);

    /**
    * 修改角色信息表
    * @param roleInfo	角色信息表
    * @param map	用户集合
    * @return
    */
    int roleInfoUpdate(RoleInfo roleInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    RoleInfo getRoleInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int roleInfoDelete(String id);

}
