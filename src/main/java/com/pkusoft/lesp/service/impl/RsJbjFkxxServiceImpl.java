package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjFkxxMapper;
import com.pkusoft.lesp.po.RsJbjFkxx;
import com.pkusoft.lesp.service.RsJbjFkxxService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class RsJbjFkxxServiceImpl implements RsJbjFkxxService {

    @Autowired
    private RsJbjFkxxMapper rsJbjFkxxMapper;

    public List<RsJbjFkxx> getRsJbjFkxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjFkxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjFkxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjFkxxCount(Map<String, String> map) {

        Example example = new Example(RsJbjFkxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjFkxxMapper.selectCountByExample(example);
    }

    public int rsJbjFkxxSave(RsJbjFkxx rsJbjFkxx, Map<String,String> map){
        String cjdbh = UUID.randomUUID().toString();
        rsJbjFkxx.setCjdbh(cjdbh);
        int num = rsJbjFkxxMapper.insertSelective(rsJbjFkxx);
        return num;
    }

    public int rsJbjFkxxUpdate(RsJbjFkxx rsJbjFkxx, Map<String,String> map){
        int num = rsJbjFkxxMapper.updateByPrimaryKeySelective(rsJbjFkxx);
        return num;
    }

    public RsJbjFkxx getRsJbjFkxx(String cjdbh){
        return rsJbjFkxxMapper.selectByPrimaryKey(cjdbh);
    }

    public int rsJbjFkxxDelete(String[] cjdbh){
        int num = 0;
        for(int i = 0; i < cjdbh.length; i ++){
        num = rsJbjFkxxMapper.deleteByPrimaryKey(cjdbh[i]);
        }
        return num;
    }

}