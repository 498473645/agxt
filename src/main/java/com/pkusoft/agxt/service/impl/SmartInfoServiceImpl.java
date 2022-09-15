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

import com.pkusoft.agxt.model.SmartInfo;
import com.pkusoft.agxt.service.SmartInfoService;
import com.pkusoft.agxt.mapper.SmartInfoMapper;

@Service
@Transactional
public class SmartInfoServiceImpl implements SmartInfoService {

    @Autowired
    private SmartInfoMapper smartInfoMapper;

    public List<SmartInfo> getSmartInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SmartInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return smartInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSmartInfoCount(Map<String, String> map) {

        Example example = new Example(SmartInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return smartInfoMapper.selectCountByExample(example);
    }

    public int smartInfoSave(SmartInfo smartInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        smartInfo.setId(id);
        int num = smartInfoMapper.insertSelective(smartInfo);
        return num;
    }

    public int smartInfoUpdate(SmartInfo smartInfo, Map<String,String> map){
        int num = smartInfoMapper.updateByPrimaryKeySelective(smartInfo);
        return num;
    }

    public SmartInfo getSmartInfo(String id){
        return smartInfoMapper.selectByPrimaryKey(id);
    }

    public int smartInfoDelete(String id){
        int num = smartInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
