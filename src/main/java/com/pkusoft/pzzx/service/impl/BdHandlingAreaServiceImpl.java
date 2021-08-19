package com.pkusoft.pzzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.pzzx.req.BdHandlingAreaReqParam;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.service.BdHandlingAreaService;
import com.pkusoft.pzzx.mapper.BdHandlingAreaMapper;

@Service
@Transactional
public class BdHandlingAreaServiceImpl implements BdHandlingAreaService {

    @Autowired
    private BdHandlingAreaMapper bdHandlingAreaMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<BdHandlingArea> getBdHandlingAreaList(BdHandlingAreaReqParam bdHandlingArea, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(bdHandlingArea.getStart(),bdHandlingArea.getPageSize());
        Example example = new Example(BdHandlingArea.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdHandlingArea, map);
        sysPermitService.setUserDataPermits(criteria,map, PermitType.PERMIT_TYPE_DEPT_QUERY);
        return bdHandlingAreaMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getBdHandlingAreaCount(BdHandlingAreaReqParam bdHandlingArea,Map<String, String> map) {

        Example example = new Example(BdHandlingArea.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited
        this.setCommonCondition(criteria,bdHandlingArea, map);
        sysPermitService.setUserDataPermits(criteria,map, PermitType.PERMIT_TYPE_DEPT_QUERY);
        return bdHandlingAreaMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, BdHandlingAreaReqParam bdHandlingArea, Map<String, String> map){
        if(StringUtils.hasText(bdHandlingArea.getOrgCode())){
            criteria.andEqualTo("orgCode",bdHandlingArea.getOrgCode());
        }
        if (StringUtils.hasText(bdHandlingArea.getObjtype())){
            criteria.andEqualTo("objtype",bdHandlingArea.getObjtype());
        }
        if (StringUtils.hasText(bdHandlingArea.getObjname())){
            criteria.andLike("objname","%"+bdHandlingArea.getObjname()+"%");
        }
    }

    public int bdHandlingAreaSave(BdHandlingArea bdHandlingArea, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        bdHandlingArea.setObjid(objid);
        bdHandlingArea.setStatus("2010");
        Date date = new Date();
        String objcode = bdHandlingArea.getObjcode();
        SysDept sysDept = sysDeptService.getSysDept(objcode);
        if (sysDept==null) {
            return -1;
        }
        bdHandlingArea.setOrgCode(sysDept.getDeptId());
        bdHandlingArea.setOrgName(sysDept.getDeptName());
        bdHandlingArea.setCreateName(map.get("userName"));
        bdHandlingArea.setCreateId(map.get("userId"));
        bdHandlingArea.setCreateTime(date);
        bdHandlingArea.setModerName(map.get("userName"));
        bdHandlingArea.setModerId(map.get("userId"));
        bdHandlingArea.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(objcode);
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                bdHandlingArea.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                bdHandlingArea.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                bdHandlingArea.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                bdHandlingArea.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                bdHandlingArea.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = bdHandlingAreaMapper.insertSelective(bdHandlingArea);
        return num;
    }

    public int bdHandlingAreaUpdate(BdHandlingArea bdHandlingArea, Map<String,String> map){
        bdHandlingArea.setModerName(map.get("userName"));
        bdHandlingArea.setModerId(map.get("userId"));
        bdHandlingArea.setModerTime(new Date());
        int num = bdHandlingAreaMapper.updateByPrimaryKeySelective(bdHandlingArea);
        return num;
    }

    public BdHandlingArea getBdHandlingArea(String objid){
        return bdHandlingAreaMapper.selectByPrimaryKey(objid);
    }

    public int bdHandlingAreaDelete(String objid){
        int num = 0;
        num = bdHandlingAreaMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public BdHandlingArea getBdHandlingAreaByUser(Map<String, String> user) {

        Example example = new Example(BdHandlingArea.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        example.setOrderByClause("CREATE_TIME DESC");
        String orgcode = user.get("deptId");
        if (StringUtils.hasText(orgcode)){
            criteria.andEqualTo("orgCode",orgcode);
        }
        List<BdHandlingArea> bdHandlingAreaList = bdHandlingAreaMapper.selectByExample(example);
        if (!bdHandlingAreaList.isEmpty()){
            return bdHandlingAreaList.get(0);
        }
        return null;
    }

    @Override
    public List<BdHandlingArea> bdHandlingAreaByParam(BdHandlingAreaReqParam bdHandlingArea, Map<String, String> map) {
        Example example = new Example(BdHandlingArea.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited
        this.setCommonCondition(criteria,bdHandlingArea, map);
        return bdHandlingAreaMapper.selectByExample(example);
    }

}
