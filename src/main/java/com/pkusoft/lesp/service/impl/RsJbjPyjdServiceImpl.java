package com.pkusoft.lesp.service.impl;

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

import com.pkusoft.lesp.po.RsJbjPyjd;
import com.pkusoft.lesp.service.RsJbjPyjdService;
import com.pkusoft.lesp.mapper.RsJbjPyjdMapper;

@Service
@Transactional
public class RsJbjPyjdServiceImpl implements RsJbjPyjdService {

    @Autowired
    private RsJbjPyjdMapper rsJbjPyjdMapper;

    public List<RsJbjPyjd> getRsJbjPyjdList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjPyjd.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjPyjdMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjPyjdCount(Map<String, String> map) {

        Example example = new Example(RsJbjPyjd.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjPyjdMapper.selectCountByExample(example);
    }

    public int rsJbjPyjdSave(RsJbjPyjd rsJbjPyjd, Map<String,String> map){
        String pyjdId = UUID.randomUUID().toString();
        rsJbjPyjd.setPyjdId(pyjdId);
        int num = rsJbjPyjdMapper.insertSelective(rsJbjPyjd);
        return num;
    }

    public int rsJbjPyjdUpdate(RsJbjPyjd rsJbjPyjd, Map<String,String> map){
        int num = rsJbjPyjdMapper.updateByPrimaryKeySelective(rsJbjPyjd);
        return num;
    }

    public RsJbjPyjd getRsJbjPyjd(String pyjdId){
        return rsJbjPyjdMapper.selectByPrimaryKey(pyjdId);
    }

    public int rsJbjPyjdDelete(String pyjdId){
        int num = rsJbjPyjdMapper.deleteByPrimaryKey(pyjdId);
        return num;
    }

}