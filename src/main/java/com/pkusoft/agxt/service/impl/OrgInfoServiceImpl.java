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

import com.pkusoft.agxt.model.OrgInfo;
import com.pkusoft.agxt.service.OrgInfoService;
import com.pkusoft.agxt.mapper.OrgInfoMapper;

@Service
@Transactional
public class OrgInfoServiceImpl implements OrgInfoService {

    @Autowired
    private OrgInfoMapper orgInfoMapper;

    public List<OrgInfo> getOrgInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(OrgInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return orgInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getOrgInfoCount(Map<String, String> map) {

        Example example = new Example(OrgInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return orgInfoMapper.selectCountByExample(example);
    }

    public int orgInfoSave(OrgInfo orgInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        orgInfo.setId(id);
        int num = orgInfoMapper.insertSelective(orgInfo);
        return num;
    }

    public int orgInfoUpdate(OrgInfo orgInfo, Map<String,String> map){
        int num = orgInfoMapper.updateByPrimaryKeySelective(orgInfo);
        return num;
    }

    public OrgInfo getOrgInfo(String id){
        return orgInfoMapper.selectByPrimaryKey(id);
    }

    public int orgInfoDelete(String id){
        int num = orgInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
