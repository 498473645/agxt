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

import com.pkusoft.agxt.model.CabPlace;
import com.pkusoft.agxt.service.CabPlaceService;
import com.pkusoft.agxt.mapper.CabPlaceMapper;

@Service
@Transactional
public class CabPlaceServiceImpl implements CabPlaceService {

    @Autowired
    private CabPlaceMapper cabPlaceMapper;

    public List<CabPlace> getCabPlaceList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CabPlace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return cabPlaceMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabPlaceCount(Map<String, String> map) {

        Example example = new Example(CabPlace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return cabPlaceMapper.selectCountByExample(example);
    }

    public int cabPlaceSave(CabPlace cabPlace, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        cabPlace.setId(id);
        int num = cabPlaceMapper.insertSelective(cabPlace);
        return num;
    }

    public int cabPlaceUpdate(CabPlace cabPlace, Map<String,String> map){
        int num = cabPlaceMapper.updateByPrimaryKeySelective(cabPlace);
        return num;
    }

    public CabPlace getCabPlace(String id){
        return cabPlaceMapper.selectByPrimaryKey(id);
    }

    public int cabPlaceDelete(String id){
        int num = cabPlaceMapper.deleteByPrimaryKey(id);
        return num;
    }

}
