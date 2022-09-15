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

import com.pkusoft.agxt.model.CaseStateInfo;
import com.pkusoft.agxt.service.CaseStateInfoService;
import com.pkusoft.agxt.mapper.CaseStateInfoMapper;

@Service
@Transactional
public class CaseStateInfoServiceImpl implements CaseStateInfoService {

    @Autowired
    private CaseStateInfoMapper caseStateInfoMapper;

    public List<CaseStateInfo> getCaseStateInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CaseStateInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseStateInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseStateInfoCount(Map<String, String> map) {

        Example example = new Example(CaseStateInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseStateInfoMapper.selectCountByExample(example);
    }

    public int caseStateInfoSave(CaseStateInfo caseStateInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        caseStateInfo.setId(id);
        int num = caseStateInfoMapper.insertSelective(caseStateInfo);
        return num;
    }

    public int caseStateInfoUpdate(CaseStateInfo caseStateInfo, Map<String,String> map){
        int num = caseStateInfoMapper.updateByPrimaryKeySelective(caseStateInfo);
        return num;
    }

    public CaseStateInfo getCaseStateInfo(String id){
        return caseStateInfoMapper.selectByPrimaryKey(id);
    }

    public int caseStateInfoDelete(String id){
        int num = caseStateInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
