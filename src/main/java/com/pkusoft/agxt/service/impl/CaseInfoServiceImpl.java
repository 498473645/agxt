package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.CaseInfoMapper;
import com.pkusoft.agxt.model.CaseInfo;
import com.pkusoft.agxt.req.CaseInfoParam;
import com.pkusoft.agxt.service.CaseInfoService;
import com.pkusoft.usercenter.po.SysUser;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class CaseInfoServiceImpl implements CaseInfoService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    public List<CaseInfo> getCaseInfoList(CaseInfoParam caseInfo, SysUser user) {

        RowBounds rowBounds = new RowBounds(caseInfo.getStart(),caseInfo.getPageSize());
        Example example = new Example(CaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseInfoCount(CaseInfoParam caseInfo, SysUser user) {
        RowBounds rowBounds = new RowBounds(caseInfo.getStart(),caseInfo.getPageSize());
        Example example = new Example(CaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoMapper.selectCountByExample(example);
    }

    public int caseInfoSave(CaseInfo caseInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        caseInfo.setId(id);
        int num = caseInfoMapper.insertSelective(caseInfo);
        return num;
    }

    public int caseInfoUpdate(CaseInfo caseInfo, Map<String,String> map){
        int num = caseInfoMapper.updateByPrimaryKeySelective(caseInfo);
        return num;
    }

    public CaseInfo getCaseInfo(String id){
        return caseInfoMapper.selectByPrimaryKey(id);
    }

    public int caseInfoDelete(String id){
        int num = caseInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
