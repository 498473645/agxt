package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.usercenter.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.agxt.mapper.CabSpaceMapper;

@Service
@Transactional
public class CabSpaceServiceImpl implements CabSpaceService {

    @Autowired
    private CabSpaceMapper cabSpaceMapper;

    public List<CabSpace> getCabSpaceList(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

        example.setOrderByClause("CREATE_TIME");
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        return cabSpaceMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabSpaceCount(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        return cabSpaceMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabSpaceParam cabSpaceParam, SysUser user) {
        if(StringUtils.hasText(cabSpaceParam.getOrgCode())){
            criteria.andEqualTo("orgCode", cabSpaceParam.getOrgCode());
        }
    }

    public int cabSpaceSave(CabSpace cabSpace, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        cabSpace.setId(id);
        int num = cabSpaceMapper.insertSelective(cabSpace);
        return num;
    }

    public int cabSpaceUpdate(CabSpace cabSpace, Map<String,String> map){
        int num = cabSpaceMapper.updateByPrimaryKeySelective(cabSpace);
        return num;
    }

    public CabSpace getCabSpace(String id){
        return cabSpaceMapper.selectByPrimaryKey(id);
    }

    public int cabSpaceDelete(String id){
        int num = cabSpaceMapper.deleteByPrimaryKey(id);
        return num;
    }

}
