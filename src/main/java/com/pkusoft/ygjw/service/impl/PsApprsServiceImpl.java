package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.ygjw.mapper.PsApprsMapper;
import com.pkusoft.ygjw.model.PsApprs;
import com.pkusoft.ygjw.req.PsApprsReqParam;
import com.pkusoft.ygjw.service.PsApprsService;
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
public class PsApprsServiceImpl implements PsApprsService {

    @Autowired
    private PsApprsMapper psApprsMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<PsApprs> getPsApprsList(PsApprsReqParam psApprsReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psApprsReqParam.getStart(),psApprsReqParam.getPageSize());
        Example example = new Example(PsApprs.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psApprsReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psApprsReqParam.getPageSize()){
            return psApprsMapper.selectByExample(example);
        }
        return psApprsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsApprsCount(PsApprsReqParam psApprsReqParam, Map<String, String> map) {

        Example example = new Example(PsApprs.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psApprsReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psApprsMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsApprsReqParam psApprsReqParam, Map<String, String> map){
        if(StringUtils.hasText(psApprsReqParam.getTransId())){
            criteria.andEqualTo("transId",psApprsReqParam.getTransId());
        }
        if(StringUtils.hasText(psApprsReqParam.getOrgCode())){
            criteria.andEqualTo("orgCode",psApprsReqParam.getOrgCode());
        }
        if(StringUtils.hasText(psApprsReqParam.getStatus())){
            criteria.andEqualTo("status",psApprsReqParam.getStatus());
        }
        if(StringUtils.hasText(psApprsReqParam.getDataType())){
            criteria.andEqualTo("dataType",psApprsReqParam.getDataType());
        }
        if(StringUtils.hasText(psApprsReqParam.getScore())){
            criteria.andEqualTo("score",psApprsReqParam.getScore());
        }
        if( StringUtils.hasText(psApprsReqParam.getStartApTime()) && StringUtils.hasText(psApprsReqParam.getEndApTime()) ){
            //开始截止时间
            criteria.andCondition("AP_TIME between to_date('"+psApprsReqParam.getStartApTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psApprsReqParam.getEndApTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        if( StringUtils.hasText(psApprsReqParam.getStartHandleTime()) && StringUtils.hasText(psApprsReqParam.getEndHandleTime()) ){
            //开始截止时间
            criteria.andCondition("HANDLE_TIME between to_date('"+psApprsReqParam.getStartHandleTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psApprsReqParam.getEndHandleTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
    }

    public int psApprsSave(PsApprs psApprs, Map<String,String> map){
        if (!StringUtils.hasText(psApprs.getId())){
            String id = UUID.randomUUID().toString();
            psApprs.setId(id);
        }
        psApprs.setStatus("2010");
        Date date = new Date();
        psApprs.setApTime(date);
        psApprs.setCreateTime(date);
        psApprs.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(psApprs.getOrgCode());
        if (sysDataOwnerDept != null) {
            psApprs.setOwnOrg1(sysDataOwnerDept.getOwnerDept1());
            psApprs.setOwnOrg2(sysDataOwnerDept.getOwnerDept2());
            psApprs.setOwnOrg3(sysDataOwnerDept.getOwnerDept3());
            psApprs.setOwnOrg4(sysDataOwnerDept.getOwnerDept4());
            psApprs.setOwnOrg5(sysDataOwnerDept.getOwnerDept5());
        }
        int num = psApprsMapper.insertSelective(psApprs);
        return num;
    }

    public int psApprsUpdate(PsApprs psApprs, Map<String,String> map){
        Date date = new Date();
        psApprs.setModerTime(date);
        psApprs.setHandlerId(map.get("userId"));
        psApprs.setHandlerName(map.get("userName"));
        psApprs.setHandleTime(date);
        int num = psApprsMapper.updateByPrimaryKeySelective(psApprs);
        return num;
    }

    public PsApprs getPsApprs(String id){
        return psApprsMapper.selectByPrimaryKey(id);
    }

    public int psApprsDelete(String id){
        int num = psApprsMapper.deleteByPrimaryKey(id);
        return num;
    }

}