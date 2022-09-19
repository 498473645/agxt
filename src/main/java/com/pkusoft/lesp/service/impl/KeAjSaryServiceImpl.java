package com.pkusoft.lesp.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.lesp.model.KeAjSary;
import com.pkusoft.lesp.service.KeAjSaryService;
import com.pkusoft.lesp.mapper.KeAjSaryMapper;

@Service
@Transactional
public class KeAjSaryServiceImpl implements KeAjSaryService {

    @Autowired
    private KeAjSaryMapper keAjSaryMapper;

    public List<KeAjSary> getKeAjSaryList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(KeAjSary.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjSaryMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getKeAjSaryCount(Map<String, String> map) {

        Example example = new Example(KeAjSary.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjSaryMapper.selectCountByExample(example);
    }

    public int keAjSarySave(KeAjSary keAjSary, Map<String,String> map){
        String ajbh = UUID.randomUUID().toString();
        keAjSary.setAjbh(ajbh);
        int num = keAjSaryMapper.insertSelective(keAjSary);
        return num;
    }

    public int keAjSaryUpdate(KeAjSary keAjSary, Map<String,String> map){
        int num = keAjSaryMapper.updateByPrimaryKeySelective(keAjSary);
        return num;
    }

    public KeAjSary getKeAjSary(String ajbh){
        return keAjSaryMapper.selectByPrimaryKey(ajbh);
    }

    public int keAjSaryDelete(String ajbh){
        int num = keAjSaryMapper.deleteByPrimaryKey(ajbh);
        return num;
    }

    @Override
    public List<KeAjSary> getKeAjSaryByAjbh(String ajbh, String sarylbBh) {
        Example example = new Example(KeAjSary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ajbh", ajbh);
        criteria.andEqualTo("sarylbBh", sarylbBh);
        List<KeAjSary> keAjSary=keAjSaryMapper.selectByExample(example);
        return keAjSary;
    }
}
