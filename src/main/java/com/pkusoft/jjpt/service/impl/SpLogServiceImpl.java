package com.pkusoft.jjpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.req.SpLogReqParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpLog;
import com.pkusoft.jjpt.service.SpLogService;
import com.pkusoft.jjpt.mapper.SpLogMapper;

@Service
@Transactional
public class SpLogServiceImpl implements SpLogService {

    @Autowired
    private SpLogMapper spLogMapper;

    public List<SpLog> getSpLogList(SpLogReqParam spLog,Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spLog.getStart(),spLog.getPageSize());
        Example example = new Example(SpLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("LOG_TIME DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,spLog);

        return spLogMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpLogCount(SpLogReqParam spLog,Map<String, String> map) {

        Example example = new Example(SpLog.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spLog);

        return spLogMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpLogReqParam spLog){
        if (StringUtils.hasText(spLog.getJjdObjid())){
            criteria.andEqualTo("jjdObjid",spLog.getJjdObjid());
        }
        if (StringUtils.hasText(spLog.getJjdbh())){
            criteria.andLike("jjdbh","%"+spLog.getJjdbh()+"%");
        }
        if (StringUtils.hasText(spLog.getType())){
            criteria.andLike("type","%"+spLog.getType()+"%");
        }
    }

    public int spLogSave(SpLog spLog, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spLog.setObjid(objid);
        spLog.setLogTime(new Date());
        int num = spLogMapper.insertSelective(spLog);
        return num;
    }

    public int spLogUpdate(SpLog spLog, Map<String,String> map){
        int num = spLogMapper.updateByPrimaryKeySelective(spLog);
        return num;
    }

    public SpLog getSpLog(String objid){
        return spLogMapper.selectByPrimaryKey(objid);
    }

    public int spLogDelete(String objid){
        int num = 0;
        num = spLogMapper.deleteByPrimaryKey(objid);
        return num;
    }

}
