package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.CabAreaMapper;
import com.pkusoft.agxt.mapper.CabPlaceMapper;
import com.pkusoft.agxt.model.CabArea;
import com.pkusoft.agxt.model.CabPlace;
import com.pkusoft.agxt.req.CabAreaParam;
import com.pkusoft.agxt.service.CabAreaService;
import com.pkusoft.agxt.service.CabPlaceService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.OrgData;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CabAreaServiceImpl implements CabAreaService {

    @Autowired
    private CabAreaMapper cabAreaMapper;

    @Autowired
    private CabPlaceService cabPlaceService;

    @Autowired
    private CabPlaceMapper cabPlaceMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<CabAreaParam> getCabAreaParamList(CabAreaParam cabAreaParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabAreaParam.getStart(),cabAreaParam.getPageSize());
        Example example = new Example(CabArea.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        example.setOrderByClause("sn");

        this.setConditions(criteria,cabAreaParam, sysUser);

        criteria.andEqualTo("curOrg", sysUser.getDeptId());

        List<CabArea> list = cabAreaMapper.selectByExampleAndRowBounds(example,rowBounds);
        List<CabAreaParam> cabAreaParamList = new ArrayList<>();
        for (CabArea cabArea : list) {
            CabAreaParam newCabAreaParam = new CabAreaParam();
            BeanUtils.copyProperties(cabArea, newCabAreaParam);
            cabAreaParamList.add(newCabAreaParam);
        }
        return cabAreaParamList;
    }

    public int getCabAreaParamCount(CabAreaParam cabAreaParam, SysUser sysUser) {

        Example example = new Example(CabArea.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,cabAreaParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());
        return cabAreaMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabAreaParam cabAreaParam, SysUser user) {
        if(StringUtils.hasText(cabAreaParam.getName())){
            criteria.andLike("name", '%' + cabAreaParam.getName() + '%');
        }
    }

    public int cabAreaSave(CabArea cabArea, SysUser sysUser){
        OrgData orgData= sysPermitService.userOrg(sysUser.getUserId());

        //场所表空间总数更新
        CabPlace jobCabPlace= cabPlaceService.getCabPlace(cabArea.getPlaceId());
        if(jobCabPlace.getAreaCount()!=null){
            jobCabPlace.setAreaCount(jobCabPlace.getAreaCount()+1);
        }else{
            jobCabPlace.setAreaCount(1);
        }

        //区域表
        cabArea.setId(UUID.randomUUID().toString());
        cabArea.setCode(orgData.getDeptId());
        cabArea.setOrgCode(orgData.getDeptId());
        cabArea.setOrgName(orgData.getDeptName());
        cabArea.setRowStatus(3);
        cabArea.setCreaterId(orgData.getIdCard());
        cabArea.setCreaterName(sysUser.getUserName());
        cabArea.setCreateTime(new Date());
        Double sn=Double.valueOf(maxSn()+1);
        cabArea.setSn(sn);
        cabArea.setModerId(orgData.getIdCard());
        cabArea.setModerName(sysUser.getUserName());
        cabArea.setModTime(new Date());
        cabArea.setOrgC(orgData.getOrgC());
        cabArea.setOrgS(orgData.getOrgS());
        cabArea.setOrgT(orgData.getOrgT());
        cabArea.setOrgCData(orgData.getOrgCData());
        cabArea.setOrgSData(orgData.getOrgSData());
        cabArea.setOrgTData(orgData.getOrgTData());
        cabArea.setSpaceCount(0);
        cabArea.setCellCount(0);
        cabArea.setCurOrg(orgData.getDeptId());
        cabArea.setCurOrgData(orgData.getDeptId());
        cabArea.setType("0000");
        cabArea.setGroupCode("1");

        cabPlaceMapper.updateByPrimaryKeySelective(jobCabPlace);

        int num = cabAreaMapper.insertSelective(cabArea);
        return num;
    }

    public int cabAreaUpdate(CabArea cabArea, SysUser sysUser){
        int num = cabAreaMapper.updateByPrimaryKeySelective(cabArea);
        return num;
    }

    public CabArea getCabArea(String id){
        return cabAreaMapper.selectByPrimaryKey(id);
    }

    public int cabAreaDelete(String[] ids){
        int num = 0;
        for (int i = 0; i < ids.length; i++) {
            num = cabAreaMapper.deleteByPrimaryKey(ids[i]);
        }
        return num;
    }

    @Override
    public void updateJobCabAreaByPlaceId(CabPlace cabPlace) {
        CabArea jobCabArea = new CabArea();
        jobCabArea.setPlaceName(cabPlace.getName());

        Example example = new Example(CabArea.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("placeId", cabPlace.getId());
        cabAreaMapper.updateByExampleSelective(jobCabArea, example);
    }

    /**
     * 最大排序号
     *
     * @return 排序号 sn
     */
    private Double maxSn() {
        Integer sn = cabAreaMapper.getMaxSN();
        return Double.valueOf(sn);
    }

}
