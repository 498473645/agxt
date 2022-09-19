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

import com.pkusoft.agxt.model.CaseOrg;
import com.pkusoft.agxt.service.CaseOrgService;
import com.pkusoft.agxt.mapper.CaseOrgMapper;

@Service
@Transactional
public class CaseOrgServiceImpl implements CaseOrgService {

    @Autowired
    private CaseOrgMapper caseOrgMapper;

    public List<CaseOrg> getCaseOrgList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CaseOrg.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseOrgMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseOrgCount(Map<String, String> map) {

        Example example = new Example(CaseOrg.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseOrgMapper.selectCountByExample(example);
    }

    public int caseOrgSave(CaseOrg caseOrg, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        caseOrg.setId(id);
        int num = caseOrgMapper.insertSelective(caseOrg);
        return num;
    }

    public int caseOrgUpdate(CaseOrg caseOrg, Map<String,String> map){
        int num = caseOrgMapper.updateByPrimaryKeySelective(caseOrg);
        return num;
    }

    public CaseOrg getCaseOrg(String id){
        return caseOrgMapper.selectByPrimaryKey(id);
    }

    public int caseOrgDelete(String id){
        int num = caseOrgMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobCaseOrgByAjbh(String ajbh) {
        Example example = new Example(CaseOrg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("caseCode", ajbh);
        return caseOrgMapper.deleteByExample(example);
    }
}
