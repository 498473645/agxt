package com.pkusoft.jjpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.mapper.PsTransTypeMapper;
import com.pkusoft.jjpt.po.PsTransType;
import com.pkusoft.jjpt.service.PsTransTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;


@Service
@Transactional
public class PsTransTypeServiceImpl implements PsTransTypeService {

    @Autowired
    private PsTransTypeMapper psTransTypeMapper;

    public List<PsTransType> getPsTransTypeList(Map<String, String> map) {

        //RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(map.get("type"))){
            criteria.andEqualTo("type",map.get("type").toString());
        }
        return psTransTypeMapper.selectByExample(example);
    }

    public int getPsTransTypeCount(Map<String, String> map) {

        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(map.get("type"))){
            criteria.andEqualTo("type",map.get("type").toString());
        }
        return psTransTypeMapper.selectCountByExample(example);
    }

    public int psTransTypeSave(PsTransType psTransType){

        int num = psTransTypeMapper.insertSelective(psTransType);
        return num;
    }

    public int psTransTypeUpdate(PsTransType psTransType){
        int num = psTransTypeMapper.updateByPrimaryKeySelective(psTransType);
        return num;
    }

    public PsTransType getPsTransType(String id){
        return psTransTypeMapper.selectByPrimaryKey(id);
    }

    public int psTransTypeDelete(String[] id){
        int num = 0;
        for(int i = 0; i < id.length; i ++){
        num = psTransTypeMapper.deleteByPrimaryKey(id[i]);
        }
        return num;
    }

}
