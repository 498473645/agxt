package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.SpPatrolProblemMapper;
import com.pkusoft.jjpt.po.SpPatrolProblem;
import com.pkusoft.jjpt.req.SpPatrolProblemReqParam;
import com.pkusoft.jjpt.service.SpPatrolProblemService;
import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class SpPatrolProblemServiceImpl implements SpPatrolProblemService {

    @Autowired
    private SpPatrolProblemMapper spPatrolProblemMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<SpPatrolProblem> getSpPatrolProblemList(SpPatrolProblemReqParam spPatrolProblemReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spPatrolProblemReqParam.getStart(),spPatrolProblemReqParam.getPageSize());
        Example example = new Example(SpPatrolProblem.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spPatrolProblemReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        if(0 == spPatrolProblemReqParam.getPageSize()){
            return spPatrolProblemMapper.selectByExample(example);
        }

        return spPatrolProblemMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpPatrolProblemCount(SpPatrolProblemReqParam spPatrolProblemReqParam, Map<String, String> map) {

        Example example = new Example(SpPatrolProblem.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spPatrolProblemReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        return spPatrolProblemMapper.selectCountByExample(example);
    }

    public int spPatrolProblemSave(SpPatrolProblem spPatrolProblem, Map<String,String> map){
        Date date = new Date();
        spPatrolProblem.setCreateName(map.get("userName"));
        spPatrolProblem.setCreateId(map.get("userId"));
        spPatrolProblem.setCreateTime(date);
        spPatrolProblem.setModerName(map.get("userName"));
        spPatrolProblem.setModerId(map.get("userId"));
        spPatrolProblem.setModerTime(date);
        spPatrolProblem.setOrgCode(map.get("deptId"));
        spPatrolProblem.setOrgName(map.get("deptName"));
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        //获取归属单位
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spPatrolProblem.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spPatrolProblem.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spPatrolProblem.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spPatrolProblem.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spPatrolProblem.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = spPatrolProblemMapper.insertSelective(spPatrolProblem);
        return num;
    }

    public int spPatrolProblemUpdate(SpPatrolProblem spPatrolProblem, Map<String,String> map){
        Date date = new Date();
        spPatrolProblem.setModerName(map.get("userName"));
        spPatrolProblem.setModerId(map.get("userId"));
        spPatrolProblem.setModerTime(date);
        int num = spPatrolProblemMapper.updateByPrimaryKeySelective(spPatrolProblem);
        return num;
    }

    public SpPatrolProblem getSpPatrolProblem(String objid){
        return spPatrolProblemMapper.selectByPrimaryKey(objid);
    }

    public int spPatrolProblemDelete(String objid){
        int num = spPatrolProblemMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public void setCommonCondition(Example.Criteria criteria, SpPatrolProblemReqParam spPatrolProblemReqParam, Map<String, String> map){
        if(StringUtils.hasText(spPatrolProblemReqParam.getTitle())){
            criteria.andLike("title","%"  + spPatrolProblemReqParam.getTitle() + "%");
        }
        if( StringUtils.hasText(spPatrolProblemReqParam.getStartCreateTime()) && StringUtils.hasText(spPatrolProblemReqParam.getEndCreateTime()) ){
            criteria.andCondition("CREATE_TIME between to_date('"+spPatrolProblemReqParam.getStartCreateTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+spPatrolProblemReqParam.getEndCreateTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
    }


}
