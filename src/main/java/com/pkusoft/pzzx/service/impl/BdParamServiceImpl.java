package com.pkusoft.pzzx.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.pzzx.req.BdParamReqParam;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.PermitType;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.pzzx.po.BdParam;
import com.pkusoft.pzzx.service.BdParamService;
import com.pkusoft.pzzx.mapper.BdParamMapper;

@Service
@Transactional
public class BdParamServiceImpl implements BdParamService {

    @Autowired
    private BdParamMapper bdParamMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<BdParam> getBdParamList(BdParamReqParam bdParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(bdParam.getStart(),bdParam.getPageSize());
        Example example = new Example(BdParam.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdParam);
        sysPermitService.setUserDataPermitsBabs(criteria, map, PermitType.PERMITTYPE_100002);
        return bdParamMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getBdParamCount(BdParamReqParam bdParam,Map<String, String> map) {

        Example example = new Example(BdParam.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdParam);
        sysPermitService.setUserDataPermitsBabs(criteria, map, PermitType.PERMITTYPE_100002);
        return bdParamMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, BdParamReqParam bdParam){
        if (StringUtils.hasText(bdParam.getParaCode())){
            criteria.andLike("paraCode","%"+bdParam.getParaCode()+"%");
        }
        if (StringUtils.hasText(bdParam.getParaName())){
            criteria.andLike("paraName","%"+bdParam.getParaName()+"%");
        }
        if (StringUtils.hasText(bdParam.getParaValue())){
            criteria.andLike("paraValue","%"+bdParam.getParaValue()+"%");
        }
    }

    public int bdParamSave(BdParam bdParam, Map<String,String> map){
        bdParam.setStatus("2010");
        Date date = new Date();
        bdParam.setOrgCode(map.get("deptId"));
        bdParam.setOrgName(map.get("deptName"));
        bdParam.setCreateName(map.get("userName"));
        bdParam.setCreateId(map.get("userId"));
        bdParam.setCreateTime(date);
        bdParam.setModerName(map.get("userName"));
        bdParam.setModerId(map.get("userId"));
        bdParam.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                bdParam.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                bdParam.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                bdParam.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                bdParam.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                bdParam.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = bdParamMapper.insertSelective(bdParam);
        return num;
    }

    public int bdParamUpdate(BdParam bdParam, Map<String,String> map){
        bdParam.setModerName(map.get("userName"));
        bdParam.setModerId(map.get("userId"));
        bdParam.setModerTime(new Date());
        int num = bdParamMapper.updateByPrimaryKeySelective(bdParam);
        return num;
    }

    public BdParam getBdParam(String paraCode){
        return bdParamMapper.selectByPrimaryKey(paraCode);
    }

    public int bdParamDelete(String paraCode){
        int num = 0;
        num = bdParamMapper.deleteByPrimaryKey(paraCode);
        return num;
    }

}
