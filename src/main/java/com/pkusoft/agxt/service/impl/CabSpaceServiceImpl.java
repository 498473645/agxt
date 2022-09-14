package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.mapper.CabSpaceActMapper;
import com.pkusoft.agxt.model.CabArea;
import com.pkusoft.agxt.model.CabSpaceAct;
import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.service.CabSpaceActService;
import com.pkusoft.usercenter.po.SysUser;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private CabSpaceActService cabSpaceActService;

    @Autowired
    private CabSpaceActMapper cabSpaceActMapper;

    public List<CabSpaceParam> getCabSpaceParamList(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

//        example.setOrderByClause("CREATE_TIME");
        example.setOrderByClause("REGEXP_SUBSTR(NAME, '^\\D*') NULLS FIRST, TO_NUMBER(REGEXP_SUBSTR(NAME, '\\d+'))");
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());


        List<CabSpace> list = cabSpaceMapper.selectByExampleAndRowBounds(example,rowBounds);
        List<CabSpaceParam> cabSpaceParamList = new ArrayList<>();
        for (CabSpace cabSpace : list) {
            CabSpaceParam cabSpaceParam1 = new CabSpaceParam();
            BeanUtils.copyProperties(cabSpace, cabSpaceParam1);
            cabSpaceParamList.add(cabSpaceParam1);
        }
        return cabSpaceParamList;
    }

    public int getCabSpaceParamCount(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());
        return cabSpaceMapper.selectCountByExample(example);
    }

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
        if(StringUtils.hasText(cabSpaceParam.getCode())){
            criteria.andLike("code", '%' + cabSpaceParam.getCode() + '%');
        }
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

    @Override
    public void updateByAreaId(CabArea cabArea, SysUser sysUser) {
        CabSpace cabSpace=new CabSpace();
        cabSpace.setOrgCode(cabArea.getOrgCode());
        cabSpace.setOrgName(cabArea.getOrgName());
        cabSpace.setOwnerId("");
        cabSpace.setOwnerName("");
        cabSpace.setAreaName(cabArea.getName());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("areaId", cabArea.getId());
        cabSpaceMapper.updateByExampleSelective(cabSpace, example);

        CabSpace newCabSpace = new CabSpace();
        newCabSpace.setAreaId(cabArea.getId());
        List<CabSpace> jobCabSpaceList= cabSpaceMapper.select(newCabSpace);
        for (CabSpace jobCabSpace2 : jobCabSpaceList) {
            //修改空间指令表
            CabSpaceAct cabSpaceAct = new CabSpaceAct();
            cabSpaceAct.setSpaceId(jobCabSpace2.getId());
            List<CabSpaceAct> jobCabSpaceActList = cabSpaceActMapper.select(cabSpaceAct);
            for(CabSpaceAct jobCabSpaceAct : jobCabSpaceActList){

                jobCabSpaceAct.setCurOrg(cabArea.getOrgCode());
                cabSpaceActMapper.updateByPrimaryKey(jobCabSpaceAct);
            }
        }
    }

}
