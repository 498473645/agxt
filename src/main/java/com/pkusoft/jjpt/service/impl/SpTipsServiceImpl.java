package com.pkusoft.jjpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.req.SpTipsReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpTips;
import com.pkusoft.jjpt.service.SpTipsService;
import com.pkusoft.jjpt.mapper.SpTipsMapper;

@Service
@Transactional
public class SpTipsServiceImpl implements SpTipsService {

    @Autowired
    private SpTipsMapper spTipsMapper;

    public List<SpTips> getSpTipsList(SpTipsReqParam spTips, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spTips.getStart(),spTips.getPageSize());
        Example example = new Example(SpTips.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spTips);

        return spTipsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpTipsCount(SpTipsReqParam spTips,Map<String, String> map) {

        Example example = new Example(SpTips.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spTips);

        return spTipsMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpTipsReqParam spTips){
        if (StringUtils.hasText(spTips.getOrgCode())){
            criteria.andEqualTo("orgCode",spTips.getOrgCode());
        }
    }

    public int spTipsSave(SpTips spTips, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spTips.setObjid(objid);
        int num = spTipsMapper.insertSelective(spTips);
        return num;
    }

    public int spTipsUpdate(SpTips spTips, Map<String,String> map){
        int num = spTipsMapper.updateByPrimaryKeySelective(spTips);
        return num;
    }

    public SpTips getSpTips(String objid){
        return spTipsMapper.selectByPrimaryKey(objid);
    }

    public int spTipsDelete(String objid){
        int num = 0;
        num = spTipsMapper.deleteByPrimaryKey(objid);
        return num;
    }

}