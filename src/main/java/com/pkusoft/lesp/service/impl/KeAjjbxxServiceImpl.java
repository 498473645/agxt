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

import com.pkusoft.lesp.model.KeAjjbxx;
import com.pkusoft.lesp.service.KeAjjbxxService;
import com.pkusoft.lesp.mapper.KeAjjbxxMapper;

@Service
@Transactional
public class KeAjjbxxServiceImpl implements KeAjjbxxService {

    @Autowired
    private KeAjjbxxMapper keAjjbxxMapper;

    public List<KeAjjbxx> getKeAjjbxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(KeAjjbxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjjbxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getKeAjjbxxCount(Map<String, String> map) {

        Example example = new Example(KeAjjbxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjjbxxMapper.selectCountByExample(example);
    }

    public int keAjjbxxSave(KeAjjbxx keAjjbxx, Map<String,String> map){
        String ajbh = UUID.randomUUID().toString();
        keAjjbxx.setAjbh(ajbh);
        int num = keAjjbxxMapper.insertSelective(keAjjbxx);
        return num;
    }

    public int keAjjbxxUpdate(KeAjjbxx keAjjbxx, Map<String,String> map){
        int num = keAjjbxxMapper.updateByPrimaryKeySelective(keAjjbxx);
        return num;
    }

    public KeAjjbxx getKeAjjbxx(String ajbh){
        return keAjjbxxMapper.selectByPrimaryKey(ajbh);
    }

    public int keAjjbxxDelete(String ajbh){
        int num = keAjjbxxMapper.deleteByPrimaryKey(ajbh);
        return num;
    }

}
