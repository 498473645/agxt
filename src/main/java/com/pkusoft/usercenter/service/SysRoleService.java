package com.pkusoft.usercenter.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.usercenter.po.SysRole;

/**
* @author
* @title: SysRoleService
*/
public interface SysRoleService {

    /**
    * 查询角色表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysRole> getSysRoleList(Map<String, String> map);

    /**
    * 查询角色表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysRoleCount(Map<String, String> map);


    /**
    * 根据主键ID查看规则信息详情
    * @param roleId
    * @return
    */
    SysRole getSysRole(Integer roleId);

    /**
     * 通过RoleId的集合 查询角色 (用的 in)
     * @param RoleIdList
     * @return
     */
    List<SysRole> getSysRoleListByRoleIdList(List<String> roleIdList);
}
