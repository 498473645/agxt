package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysMenuMapper;
import com.pkusoft.usercenter.po.SysMenu;
import com.pkusoft.usercenter.service.SysMenuService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Value("${user-center-proxy.sys-id}")
    private String sysId;

    @Override
    public List<SysMenu> getSysMenuList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysMenu.class);
        //Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysMenuMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public int getSysMenuCount(Map<String, String> map) {

        Example example = new Example(SysMenu.class);
        //Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysMenuMapper.selectCountByExample(example);
    }

    @Override
    public SysMenu getSysMenu(String menuId){
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    /**
     * 根据用户和所示系统得到用户的菜单信息
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getUserMenuList(String userId){
        Map<String,String> map = new HashMap<>(2);
        map.put("userId",userId);
        map.put("sysId",sysId);
        //得到用户菜单信息
        return sysMenuMapper.getUserMenuList(map);
    }
}