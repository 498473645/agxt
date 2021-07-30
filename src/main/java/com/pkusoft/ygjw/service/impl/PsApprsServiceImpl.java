package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
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
        //根据设备唯一标识码获取设备信息
        BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(psApprs.getCreateId());//字段接口调用将eid放在CreateId中
        if (bdEquipment != null) {
            psApprs.setOrgCode(bdEquipment.getOrgCode());
            psApprs.setOrgName(bdEquipment.getOrgName());
            psApprs.setOwnOrg1(bdEquipment.getGaOwnerDept1());
            psApprs.setOwnOrg2(bdEquipment.getGaOwnerDept2());
            psApprs.setOwnOrg3(bdEquipment.getGaOwnerDept3());
            psApprs.setOwnOrg4(bdEquipment.getGaOwnerDept4());
            psApprs.setOwnOrg5(bdEquipment.getGaOwnerDept5());
        }
        int num = psApprsMapper.insertSelective(psApprs);
        return num;
    }

    public int psApprsUpdate(PsApprs psApprs, Map<String,String> map){
        Date date = new Date();
        psApprs.setModerTime(date);
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