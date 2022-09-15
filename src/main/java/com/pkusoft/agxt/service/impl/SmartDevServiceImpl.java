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

import com.pkusoft.agxt.model.SmartDev;
import com.pkusoft.agxt.service.SmartDevService;
import com.pkusoft.agxt.mapper.SmartDevMapper;

@Service
@Transactional
public class SmartDevServiceImpl implements SmartDevService {

    @Autowired
    private SmartDevMapper smartDevMapper;

    public List<SmartDev> getSmartDevList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SmartDev.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return smartDevMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSmartDevCount(Map<String, String> map) {

        Example example = new Example(SmartDev.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return smartDevMapper.selectCountByExample(example);
    }

    public int smartDevSave(SmartDev smartDev, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        smartDev.setId(id);
        int num = smartDevMapper.insertSelective(smartDev);
        return num;
    }

    public int smartDevUpdate(SmartDev smartDev, Map<String,String> map){
        int num = smartDevMapper.updateByPrimaryKeySelective(smartDev);
        return num;
    }

    public SmartDev getSmartDev(String id){
        return smartDevMapper.selectByPrimaryKey(id);
    }

    public int smartDevDelete(String id){
        int num = smartDevMapper.deleteByPrimaryKey(id);
        return num;
    }

}
