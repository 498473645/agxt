package com.pkusoft.lespke2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.lespke2.po.KeAjSary;
import com.pkusoft.lespke2.service.KeAjSaryService;
import com.pkusoft.lespke2.mapper.KeAjSaryMapper;

@Service
@Transactional
public class KeAjSaryServiceImpl implements KeAjSaryService {

    @Autowired
    private KeAjSaryMapper keAjSaryMapper;

    public List<KeAjSary> getKeAjSaryList(Map<String, String> map) {

        Example example = new Example(KeAjSary.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(map.get("sfz"))){
            criteria.andLike("sarySfzhm",map.get("sfz"));
        }
        return keAjSaryMapper.selectByExample(example);
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

}
