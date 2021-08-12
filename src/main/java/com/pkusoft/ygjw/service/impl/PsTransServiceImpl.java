package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.ygjw.mapper.PsTransMapper;
import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.req.PsTransReqParam;
import com.pkusoft.ygjw.service.PsTransService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class PsTransServiceImpl implements PsTransService {

    @Autowired
    private PsTransMapper psTransMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<PsTrans> getPsTransList(PsTransReqParam psTransReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psTransReqParam.getStart(),psTransReqParam.getPageSize());
        Example example = new Example(PsTrans.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTransReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psTransReqParam.getPageSize()){
            return psTransMapper.selectByExample(example);
        }
        return psTransMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsTransCount(PsTransReqParam psTransReqParam,Map<String, String> map) {

        Example example = new Example(PsTrans.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTransReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psTransMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsTransReqParam psTransReqParam, Map<String, String> map){
        if(StringUtils.hasText(psTransReqParam.getRepName())){
            criteria.andLike("repName","%"+psTransReqParam.getRepName()+"%");
        }
        if(StringUtils.hasText(psTransReqParam.getRepSex())){
            criteria.andEqualTo("repSex",psTransReqParam.getRepSex());
        }
        if(StringUtils.hasText(psTransReqParam.getType())){
            criteria.andEqualTo("type",psTransReqParam.getType());
        }
        if(StringUtils.hasText(psTransReqParam.getLy())){
            criteria.andEqualTo("ly",psTransReqParam.getLy());
        }
        if(StringUtils.hasText(psTransReqParam.getStatus())){
            criteria.andEqualTo("status",psTransReqParam.getStatus());
        }
        if(StringUtils.hasText(psTransReqParam.getOrgCode())){
            criteria.andEqualTo("orgCode",psTransReqParam.getOrgCode());
        }
        if(StringUtils.hasText(psTransReqParam.getDataType())){
            criteria.andEqualTo("dataType",psTransReqParam.getDataType());
        }
        if( StringUtils.hasText(psTransReqParam.getStartOccTime()) && StringUtils.hasText(psTransReqParam.getEndOccTime()) ){
            //开始截止时间
            criteria.andCondition("OCC_TIME between to_date('"+psTransReqParam.getStartOccTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psTransReqParam.getEndOccTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        if( StringUtils.hasText(psTransReqParam.getStartRepTime()) && StringUtils.hasText(psTransReqParam.getEndRepTime()) ){
            //开始截止时间
            criteria.andCondition("REP_TIME between to_date('"+psTransReqParam.getStartRepTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psTransReqParam.getEndRepTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
    }

    public int psTransSave(PsTrans psTrans, Map<String,String> map){
        if (!StringUtils.hasText(psTrans.getId())){
            String id = UUID.randomUUID().toString();
            psTrans.setId(id);
        }
        psTrans.setStatus("2010");
        Date date = new Date();
        psTrans.setCreateTime(date);
        psTrans.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(psTrans.getOrgCode());
        if (sysDataOwnerDept != null) {
            psTrans.setOwnOrg1(sysDataOwnerDept.getOwnerDept1());
            psTrans.setOwnOrg2(sysDataOwnerDept.getOwnerDept2());
            psTrans.setOwnOrg3(sysDataOwnerDept.getOwnerDept3());
            psTrans.setOwnOrg4(sysDataOwnerDept.getOwnerDept4());
            psTrans.setOwnOrg5(sysDataOwnerDept.getOwnerDept5());
        }
        if (!StringUtils.hasText(psTrans.getCode())){
            psTrans.setCode(this.generateJjdbh(psTrans.getOrgCode()));
        }
        int num = psTransMapper.insertSelective(psTrans);
        return num;
    }

    public  String generateJjdbh(String orgCode){
        return "YBJ"+orgCode + new Date().getTime();
    }

    public int psTransUpdate(PsTrans psTrans, Map<String,String> map){
        int num = psTransMapper.updateByPrimaryKeySelective(psTrans);
        return num;
    }

    public PsTrans getPsTrans(String id){
        return psTransMapper.selectByPrimaryKey(id);
    }

    public int psTransDelete(String id){
        int num = psTransMapper.deleteByPrimaryKey(id);
        return num;
    }

}