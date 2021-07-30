package com.pkusoft.jjpt.service.impl;

import java.util.*;

import com.pkusoft.jjpt.req.SpAlarmTypeReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpAlarmType;
import com.pkusoft.jjpt.service.SpAlarmTypeService;
import com.pkusoft.jjpt.mapper.SpAlarmTypeMapper;

@Service
@Transactional
public class SpAlarmTypeServiceImpl implements SpAlarmTypeService {

    @Autowired
    private SpAlarmTypeMapper spAlarmTypeMapper;

    public List<SpAlarmType> getSpAlarmTypeList(SpAlarmTypeReqParam spAlarmType, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spAlarmType.getStart(),spAlarmType.getPageSize());
        Example example = new Example(SpAlarmType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spAlarmType);

        return spAlarmTypeMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpAlarmTypeCount(SpAlarmTypeReqParam spAlarmType,Map<String, String> map) {

        Example example = new Example(SpAlarmType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spAlarmType);

        return spAlarmTypeMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpAlarmTypeReqParam spAlarmType){
        if (StringUtils.hasText(spAlarmType.getDicLevel())){
            criteria.andEqualTo("dicLevel",spAlarmType.getDicLevel());
        }
        if (StringUtils.hasText(spAlarmType.getDicVersion())){
            criteria.andEqualTo("dicVersion",spAlarmType.getDicVersion());
        }
    }

    public List<SpAlarmType> getSpAlarmTypeListByLevelAndType(SpAlarmType spAlarmType) {
        Example example = new Example(SpAlarmType.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        String level = spAlarmType.getDicLevel();
        if ("1".equals(level)) {
            criteria.andEqualTo("dicLevel",level);
        }else if ("2".equals(level)) {
            criteria.andEqualTo("dicLevel",level);
            criteria.andEqualTo("bjlbdm",spAlarmType.getObjcode());
        }else if ("3".equals(level)) {
            criteria.andEqualTo("dicLevel",level);
            criteria.andEqualTo("bjlxdm",spAlarmType.getObjcode());
        }else {
            return new ArrayList<SpAlarmType>();
        }
        if (StringUtils.hasText(spAlarmType.getDicVersion())){
            criteria.andEqualTo("dicVersion",spAlarmType.getDicVersion());
        }
        return spAlarmTypeMapper.selectByExample(example);
    }

    public int spAlarmTypeSave(SpAlarmType spAlarmType, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spAlarmType.setObjid(objid);
        int num = spAlarmTypeMapper.insertSelective(spAlarmType);
        return num;
    }

    public int spAlarmTypeUpdate(SpAlarmType spAlarmType, Map<String,String> map){
        int num = spAlarmTypeMapper.updateByPrimaryKeySelective(spAlarmType);
        return num;
    }

    public SpAlarmType getSpAlarmType(String objid){
        return spAlarmTypeMapper.selectByPrimaryKey(objid);
    }

    public int spAlarmTypeDelete(String objid){
        int num = 0;
        num = spAlarmTypeMapper.deleteByPrimaryKey(objid);
        return num;
    }

}
