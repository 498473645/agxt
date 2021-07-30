package com.pkusoft.usercenter.mapper;

import com.pkusoft.usercenter.po.SysMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysMenuMapper extends Mapper<SysMenu> {
    /**
     * 根据用户和所示系统得到用户的菜单信息
     * @param paraMap
     * @return
     */
    List<SysMenu> getUserMenuList(Map<String, String> paraMap);
}