package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.req.CabPlaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.OrgData;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.CabPlace;
import com.pkusoft.agxt.service.CabPlaceService;
import com.pkusoft.agxt.mapper.CabPlaceMapper;

@Service
@Transactional
public class CabPlaceServiceImpl implements CabPlaceService {

    @Autowired
    private CabPlaceMapper cabPlaceMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<CabPlace> getCabPlaceList(CabPlaceParam cabPlaceParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabPlaceParam.getStart(), cabPlaceParam.getPageSize());
        Example example = new Example(CabPlace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        example.setOrderByClause("create_time");

        this.setConditions(criteria,cabPlaceParam, sysUser);
        return cabPlaceMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabPlaceCount(CabPlaceParam cabPlaceParam, SysUser sysUser) {

        Example example = new Example(CabPlace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,cabPlaceParam, sysUser);
        return cabPlaceMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabPlaceParam cabPlaceParam, SysUser user) {
        criteria.andEqualTo("orgCode", user.getDeptId());
        if(StringUtils.hasText(cabPlaceParam.getName())){
            criteria.andLike("name", '%' + cabPlaceParam.getName() + '%');
        }
    }

    public int cabPlaceSave(CabPlace cabPlace, SysUser sysUser){
        OrgData orgData= sysPermitService.userOrg(sysUser.getUserId());

        cabPlace.setId(UUID.randomUUID().toString());
        cabPlace.setCode(orgData.getDeptId());
        cabPlace.setOrgCode(orgData.getDeptId());
        cabPlace.setOrgName(orgData.getDeptName());
        cabPlace.setRowStatus(3);
        cabPlace.setCreaterId(orgData.getIdCard());
        cabPlace.setCreaterName(sysUser.getUserName());
        cabPlace.setCreateTime(new Date());
        cabPlace.setModerId(orgData.getIdCard());
        cabPlace.setModerName(sysUser.getUserName());
        cabPlace.setModTime(new Date());
        cabPlace.setAreaCount(0);
        cabPlace.setSpaceCount(0);
        cabPlace.setCellCount(0);
        cabPlace.setOrgC(orgData.getOrgC());
        cabPlace.setOrgS(orgData.getOrgS());
        cabPlace.setOrgT(orgData.getOrgT());
        cabPlace.setOrgCData(orgData.getOrgCData());
        cabPlace.setOrgSData(orgData.getOrgSData());
        cabPlace.setOrgTData(orgData.getOrgTData());
        cabPlace.setCurOrg(orgData.getDeptId());
        cabPlace.setCurOrgData(orgData.getDeptId());
        cabPlace.setType("0010");
        cabPlace.setSn(0.00);

        int num = cabPlaceMapper.insertSelective(cabPlace);
        return num;
    }

    public int cabPlaceUpdate(CabPlace cabPlace, SysUser sysUser){
        cabPlace.setModerId(sysUser.getIdcard());
        cabPlace.setModerName(sysUser.getUserName());
        cabPlace.setModTime(new Date());

        int num = cabPlaceMapper.updateByPrimaryKeySelective(cabPlace);
        return num;
    }

    public CabPlace getCabPlace(String id){
        return cabPlaceMapper.selectByPrimaryKey(id);
    }

    public int cabPlaceDelete(String[] ids){
        int num = 0;
        for (int i = 0; i < ids.length; i++) {
            num = cabPlaceMapper.deleteByPrimaryKey(ids[i]);
        }
        return num;
    }

}
