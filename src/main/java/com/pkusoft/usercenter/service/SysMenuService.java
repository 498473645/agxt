package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysMenu;

import java.util.List;
import java.util.Map;


public interface SysMenuService {

    /**
    * 查询菜单表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysMenu> getSysMenuList(Map<String, String> map);

    /**
    * 查询菜单表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysMenuCount(Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param menuId
    * @return
    */
    SysMenu getSysMenu(String menuId);

    /**
     * 根据用户和所示系统得到用户的菜单信息
     * @param userId
     * @return
     */
    List<SysMenu> getUserMenuList(String userId);

}
