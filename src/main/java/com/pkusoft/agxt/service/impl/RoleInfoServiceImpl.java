package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.RoleInfo;
import com.pkusoft.agxt.service.RoleInfoService;
import com.pkusoft.agxt.mapper.RoleInfoMapper;

@Service
@Transactional
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    public List<RoleInfo> getRoleInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RoleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return roleInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRoleInfoCount(Map<String, String> map) {

        Example example = new Example(RoleInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return roleInfoMapper.selectCountByExample(example);
    }

    public int roleInfoSave(RoleInfo roleInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        roleInfo.setId(id);
        int num = roleInfoMapper.insertSelective(roleInfo);
        return num;
    }

    public int roleInfoUpdate(RoleInfo roleInfo, Map<String,String> map){
        int num = roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
        return num;
    }

    public RoleInfo getRoleInfo(String id){
        return roleInfoMapper.selectByPrimaryKey(id);
    }

    public int roleInfoDelete(String id){
        int num = roleInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
