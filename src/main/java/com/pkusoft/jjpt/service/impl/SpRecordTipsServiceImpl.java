package com.pkusoft.jjpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.req.SpRecordTipsReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpRecordTips;
import com.pkusoft.jjpt.service.SpRecordTipsService;
import com.pkusoft.jjpt.mapper.SpRecordTipsMapper;

@Service
@Transactional
public class SpRecordTipsServiceImpl implements SpRecordTipsService {

    @Autowired
    private SpRecordTipsMapper spRecordTipsMapper;

    public List<SpRecordTips> getSpRecordTipsList(SpRecordTipsReqParam spRecordTips, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spRecordTips.getStart(),spRecordTips.getPageSize());
        Example example = new Example(SpRecordTips.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spRecordTips);

        return spRecordTipsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpRecordTipsCount(SpRecordTipsReqParam spRecordTips,Map<String, String> map) {

        Example example = new Example(SpRecordTips.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spRecordTips);

        return spRecordTipsMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpRecordTipsReqParam spRecordTips){
        if (StringUtils.hasText(spRecordTips.getOrgCode())){
            criteria.andEqualTo("orgCode",spRecordTips.getOrgCode());
        }
    }

    public int spRecordTipsSave(SpRecordTips spRecordTips, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spRecordTips.setObjid(objid);
        int num = spRecordTipsMapper.insertSelective(spRecordTips);
        return num;
    }

    public int spRecordTipsUpdate(SpRecordTips spRecordTips, Map<String,String> map){
        int num = spRecordTipsMapper.updateByPrimaryKeySelective(spRecordTips);
        return num;
    }

    public SpRecordTips getSpRecordTips(String objid){
        return spRecordTipsMapper.selectByPrimaryKey(objid);
    }

    public int spRecordTipsDelete(String objid){
        int num = 0;
        num = spRecordTipsMapper.deleteByPrimaryKey(objid);
        return num;
    }

}