package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.model.CaseInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.CaseInfoH;
import com.pkusoft.agxt.service.CaseInfoHService;
import com.pkusoft.agxt.mapper.CaseInfoHMapper;

@Service
@Transactional
public class CaseInfoHServiceImpl implements CaseInfoHService {

    @Autowired
    private CaseInfoHMapper caseInfoHMapper;

    public List<CaseInfoH> getCaseInfoHList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CaseInfoH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoHMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseInfoHCount(Map<String, String> map) {

        Example example = new Example(CaseInfoH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoHMapper.selectCountByExample(example);
    }

    public int caseInfoHSave(CaseInfoH caseInfoH, Map<String,String> map){
        String hisId = UUID.randomUUID().toString();
        caseInfoH.setHisId(hisId);
        int num = caseInfoHMapper.insertSelective(caseInfoH);
        return num;
    }

    public int caseInfoHUpdate(CaseInfoH caseInfoH, Map<String,String> map){
        int num = caseInfoHMapper.updateByPrimaryKeySelective(caseInfoH);
        return num;
    }

    public CaseInfoH getCaseInfoH(String hisId){
        return caseInfoHMapper.selectByPrimaryKey(hisId);
    }

    public int caseInfoHDelete(String hisId){
        int num = caseInfoHMapper.deleteByPrimaryKey(hisId);
        return num;
    }

    //将变更数据存入历史表
    public void TemporalTable(CaseInfo jobCaseInfo){
        CaseInfoH jobCaseInfoH = new CaseInfoH();
        BeanUtils.copyProperties(jobCaseInfo,jobCaseInfoH);
        jobCaseInfoH.setHisId(UUID.randomUUID().toString());
        caseInfoHMapper.insertSelective(jobCaseInfoH);
    }

}
