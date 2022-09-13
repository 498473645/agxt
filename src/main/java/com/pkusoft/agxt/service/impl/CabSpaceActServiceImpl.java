package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.CabSpaceActMapper;
import com.pkusoft.agxt.mapper.CabSpaceMapper;
import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.CabSpaceAct;
import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.CabSpaceActService;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.OrgData;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class CabSpaceActServiceImpl implements CabSpaceActService {

    @Autowired
    private CabSpaceActMapper cabSpaceActMapper;

    @Autowired
    private CabSpaceService cabSpaceService;

    @Autowired
    private CabSpaceMapper cabSpaceMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<CabSpaceAct> getCabSpaceActList(CabSpaceActParam cabSpaceActParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabSpaceActParam.getStart(), cabSpaceActParam.getPageSize());
        Example example = new Example(CabSpaceAct.class);
        Example.Criteria criteria = example.createCriteria();

        List<String> spaceIds = getCabSpaceListId(sysUser);
        example.setOrderByClause("REGEXP_SUBSTR(NAME, '^\\D*') NULLS FIRST, TO_NUMBER(REGEXP_SUBSTR(NAME, '\\d+'))");
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceActParam, sysUser);

        //根据空间id查询空间指令
        criteria.andIn("spaceId",spaceIds);

        return cabSpaceActMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabSpaceActCount(CabSpaceActParam cabSpaceActParam, SysUser sysUser) {

        Example example = new Example(CabSpaceAct.class);
        Example.Criteria criteria = example.createCriteria();

        List<String> spaceIds = getCabSpaceListId(sysUser);

        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceActParam, sysUser);

        //根据空间id查询空间指令
        criteria.andIn("spaceId",spaceIds);

        return cabSpaceActMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabSpaceActParam cabSpaceActParam, SysUser user) {
        if(StringUtils.hasText(cabSpaceActParam.getCode())){
            criteria.andLike("code", '%' + cabSpaceActParam.getCode() + '%');
        }
    }

    public int cabSpaceActSave(CabSpaceAct cabSpaceAct, SysUser sysUser){
        OrgData orgData=sysPermitService.userOrg(sysUser.getUserId());
        String cabSpaceId = cabSpaceAct.getSpaceId();
        String code = cabSpaceAct.getCode();
        CabSpace jobCabSpaceNew = cabSpaceMapper.selectByPrimaryKey(cabSpaceId);
        cabSpaceAct.setId(UUID.randomUUID().toString());
        cabSpaceAct.setName(code);
        cabSpaceAct.setPlaceId(jobCabSpaceNew.getPlaceId());
        cabSpaceAct.setPlaceName(jobCabSpaceNew.getPlaceName());
        cabSpaceAct.setAreaId(jobCabSpaceNew.getAreaId());
        cabSpaceAct.setAreaName(jobCabSpaceNew.getAreaName());
        cabSpaceAct.setSpaceId(jobCabSpaceNew.getId());
        cabSpaceAct.setSpaceName(jobCabSpaceNew.getName());
        cabSpaceAct.setCreaterId(sysUser.getIdcard());
        cabSpaceAct.setCreaterName(sysUser.getUserName());
        cabSpaceAct.setCreateTime(new Date());
        cabSpaceAct.setModerId(sysUser.getIdcard());
        cabSpaceAct.setModerName(sysUser.getUserName());
        cabSpaceAct.setModTime(new Date());
        cabSpaceAct.setOrgC(orgData.getOrgC());
        cabSpaceAct.setOrgS(orgData.getOrgS());
        cabSpaceAct.setOrgT(orgData.getOrgT());
        cabSpaceAct.setOrgCData(orgData.getOrgCData());
        cabSpaceAct.setOrgSData(orgData.getOrgSData());
        cabSpaceAct.setOrgTData(orgData.getOrgTData());
        cabSpaceAct.setCurOrg(orgData.getDeptId());
        cabSpaceAct.setCurOrgData(orgData.getDeptId());

        int num = cabSpaceActMapper.insertSelective(cabSpaceAct);
        return num;
    }

    public int cabSpaceActUpdate(CabSpaceAct cabSpaceAct, SysUser sysUser){
        cabSpaceAct.setModerId(sysUser.getIdcard());
        cabSpaceAct.setModerName(sysUser.getUserName());
        cabSpaceAct.setModTime(new Date());

        int num = cabSpaceActMapper.updateByPrimaryKeySelective(cabSpaceAct);
        return num;
    }

    public CabSpaceAct getCabSpaceAct(String id){
        return cabSpaceActMapper.selectByPrimaryKey(id);
    }

    public int cabSpaceActDelete(String[] ids){
        int num = 0;
        for (int i = 0; i < ids.length; i++) {
            num = cabSpaceActMapper.deleteByPrimaryKey(ids[i]);
        }
        return num;
    }

    /**
     * 获取当前用户权限下的空间id
     * @param sysUser
     * @return
     */
    private List<String> getCabSpaceListId (SysUser sysUser) {
        /**
         * 空间列表
         */
        CabSpaceParam cabSpaceParam = new CabSpaceParam();
        cabSpaceParam.setOrgCode(sysUser.getDeptId());

        List<String> spaceIds = new ArrayList<String>();
        List<CabSpace> list = cabSpaceService.getCabSpaceList(cabSpaceParam, sysUser);

        //获取当前用户权限下的空间id
        if(list.size()>0&&list!=null){
            for(CabSpace jobCabSpace:list){
                spaceIds.add(jobCabSpace.getId());
            }
        }
        return spaceIds;
    }
}
