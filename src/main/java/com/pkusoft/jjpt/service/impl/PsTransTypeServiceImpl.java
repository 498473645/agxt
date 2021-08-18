package com.pkusoft.jjpt.service.impl;

import java.util.*;

import com.pkusoft.jjpt.mapper.PsTransTypeMapper;
import com.pkusoft.jjpt.po.PsTransType;
import com.pkusoft.jjpt.req.PsTransTypeReqParam;
import com.pkusoft.jjpt.service.PsTransTypeService;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
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

    public List<PsTransType> getPsTransTypeList(PsTransTypeReqParam psTransType, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psTransType.getStart(),psTransType.getPageSize());
        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(psTransType.getCode())){
            criteria.andEqualTo("code",psTransType.getCode());
        }
        return psTransTypeMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsTransTypeCount(PsTransTypeReqParam psTransType,Map<String, String> map) {

        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(psTransType.getCode())){
            criteria.andEqualTo("code",psTransType.getCode());
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

    @Override
    public List<PsTransType> getPsTransTypeByParam(PsTransType psTransType) {
        PsTransType transType = new PsTransType();
        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(psTransType.getCode())){
            criteria.andEqualTo("code",psTransType.getCode());
        }
        if (StringUtils.hasText(psTransType.getType())){
            criteria.andEqualTo("type",psTransType.getType());
        }
        List<PsTransType> t = psTransTypeMapper.selectByExample(example);
        if (null != t && t.size()>0){
            transType = t.get(0);
        }
        return t;
    }

    @Override
    public List<PsTransType> getPsTransTypeByType(String type) {
        List<PsTransType> psTransTypeList = new ArrayList<>();
        Example example = new Example(PsTransType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(type)){
            criteria.andEqualTo("type",type);
        } else {
            return psTransTypeList;
        }
        psTransTypeList = psTransTypeMapper.selectByExample(example);
        return psTransTypeList;
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

    @Override
    public List<PsTransType> getPsTransTypeGroup(String type) {
        List<PsTransType> a = psTransTypeMapper.getPsTransTypeGroup();
        return a;
    }

}
