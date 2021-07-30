package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
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
    private BdEquipmentService bdEquipmentService;

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
        //根据设备唯一标识码获取设备信息
        BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(psTrans.getCreateId());//字段接口调用将eid放在CreateId中
        if (bdEquipment != null) {
            psTrans.setOrgCode(bdEquipment.getOrgCode());
            psTrans.setOrgName(bdEquipment.getOrgName());
            psTrans.setOwnOrg1(bdEquipment.getGaOwnerDept1());
            psTrans.setOwnOrg2(bdEquipment.getGaOwnerDept2());
            psTrans.setOwnOrg3(bdEquipment.getGaOwnerDept3());
            psTrans.setOwnOrg4(bdEquipment.getGaOwnerDept4());
            psTrans.setOwnOrg5(bdEquipment.getGaOwnerDept5());
        }
        int num = psTransMapper.insertSelective(psTrans);
        return num;
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