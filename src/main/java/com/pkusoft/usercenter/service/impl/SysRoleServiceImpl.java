package com.pkusoft.usercenter.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.usercenter.po.SysRole;
import com.pkusoft.usercenter.service.SysRoleService;
import com.pkusoft.usercenter.mapper.SysRoleMapper;

@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Value(value = "${shiro-proxy.proxy-id}")
    private String proxyId;

    public List<SysRole> getSysRoleList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysRoleMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSysRoleCount(Map<String, String> map) {

        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysRoleMapper.selectCountByExample(example);
    }

    public SysRole getSysRole(Integer roleId){
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    public List<SysRole> getSysRoleListByRoleIdList(List<String> roleIdList) {
        if(roleIdList == null || roleIdList.size() == 0){
            return new ArrayList<SysRole>();
        }

        Example example = new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("roleId", roleIdList);
//        if(StringUtils.hasText(proxyId)){
//            criteria.andEqualTo("sysId",proxyId);
//        }
        List<SysRole> list = sysRoleMapper.selectByExample(example);
        return list;
    }
}
