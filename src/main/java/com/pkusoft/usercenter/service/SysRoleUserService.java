package com.pkusoft.usercenter.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.usercenter.po.SysRoleUser;

/**
* @author
* @title: SysRoleUserService
*/
public interface SysRoleUserService {

    /**
    * 查询角色用户表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysRoleUser> getSysRoleUserList(Map<String, String> map);

    /**
    * 查询角色用户表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysRoleUserCount(Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param roleUserId
    * @return
    */
    SysRoleUser getSysRoleUser(Integer roleUserId);

    /**
     * 按用户标识号查询列表
     *
     * @param userId
     * @return
     */
    List<SysRoleUser> getSysRoleUserListByUserId(String userId);
}
