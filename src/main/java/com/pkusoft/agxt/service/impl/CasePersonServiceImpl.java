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

import com.pkusoft.agxt.model.CasePerson;
import com.pkusoft.agxt.service.CasePersonService;
import com.pkusoft.agxt.mapper.CasePersonMapper;

@Service
@Transactional
public class CasePersonServiceImpl implements CasePersonService {

    @Autowired
    private CasePersonMapper casePersonMapper;

    public List<CasePerson> getCasePersonList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CasePerson.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return casePersonMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCasePersonCount(Map<String, String> map) {

        Example example = new Example(CasePerson.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return casePersonMapper.selectCountByExample(example);
    }

    public int casePersonSave(CasePerson casePerson, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        casePerson.setId(id);
        int num = casePersonMapper.insertSelective(casePerson);
        return num;
    }

    public int casePersonUpdate(CasePerson casePerson, Map<String,String> map){
        int num = casePersonMapper.updateByPrimaryKeySelective(casePerson);
        return num;
    }

    public CasePerson getCasePerson(String id){
        return casePersonMapper.selectByPrimaryKey(id);
    }

    public int casePersonDelete(String id){
        int num = casePersonMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobCasePersonByAjbh(String ajbh) {
        Example example = new Example(CasePerson.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("caseCode", ajbh);
        return casePersonMapper.deleteByExample(example);
    }
}
