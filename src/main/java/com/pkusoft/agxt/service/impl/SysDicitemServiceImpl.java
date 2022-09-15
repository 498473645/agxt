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

import com.pkusoft.agxt.model.SysDicitem;
import com.pkusoft.agxt.service.SysDicitemService;
import com.pkusoft.agxt.mapper.SysDicitemMapper;

@Service
@Transactional
public class SysDicitemServiceImpl implements SysDicitemService {

    @Autowired
    private SysDicitemMapper sysDicitemMapper;

    public List<SysDicitem> getSysDicitemList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysDicitem.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysDicitemMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSysDicitemCount(Map<String, String> map) {

        Example example = new Example(SysDicitem.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysDicitemMapper.selectCountByExample(example);
    }

    public int sysDicitemSave(SysDicitem sysDicitem, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        sysDicitem.setId(id);
        int num = sysDicitemMapper.insertSelective(sysDicitem);
        return num;
    }

    public int sysDicitemUpdate(SysDicitem sysDicitem, Map<String,String> map){
        int num = sysDicitemMapper.updateByPrimaryKeySelective(sysDicitem);
        return num;
    }

    public SysDicitem getSysDicitem(String id){
        return sysDicitemMapper.selectByPrimaryKey(id);
    }

    public int sysDicitemDelete(String id){
        int num = sysDicitemMapper.deleteByPrimaryKey(id);
        return num;
    }

}
