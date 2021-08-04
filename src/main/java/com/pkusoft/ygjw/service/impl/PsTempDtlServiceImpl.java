package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.ygjw.mapper.PsTempDtlMapper;
import com.pkusoft.ygjw.mapper.PsTempMapper;
import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.model.PsTempDtl;
import com.pkusoft.ygjw.req.PsTempDtlReqParam;
import com.pkusoft.ygjw.service.PsTempDtlService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class PsTempDtlServiceImpl implements PsTempDtlService {

    @Autowired
    private PsTempDtlMapper psTempDtlMapper;

    @Autowired
    private PsTempMapper psTempMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    public List<PsTempDtl> getPsTempDtlList(PsTempDtlReqParam psTempDtlReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psTempDtlReqParam.getStart(),psTempDtlReqParam.getPageSize());
        Example example = new Example(PsTempDtl.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTempDtlReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psTempDtlReqParam.getPageSize()){
            return psTempDtlMapper.selectByExample(example);
        }
        return psTempDtlMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<PsTempDtl> getAllPsTempDtlList(PsTempDtlReqParam psTempDtlReqParam, Map<String, String> map) {

        Example example = new Example(PsTempDtl.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTempDtlReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psTempDtlMapper.selectByExample(example);
    }

    public int getPsTempDtlCount(PsTempDtlReqParam psTempDtlReqParam,Map<String, String> map) {

        Example example = new Example(PsTempDtl.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTempDtlReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psTempDtlMapper.selectCountByExample(example);
    }
    public void setCommonCondition(Example.Criteria criteria, PsTempDtlReqParam psTempDtlReqParam, Map<String, String> map){
        if(StringUtils.isNotBlank(psTempDtlReqParam.getName())){
            criteria.andLike("name",psTempDtlReqParam.getName()+"%");
        }
        if(StringUtils.isNotBlank(psTempDtlReqParam.getType())){
            criteria.andEqualTo("type",psTempDtlReqParam.getType());
        }
    }

    public int psTempDtlSave(PsTempDtl psTempDtl, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        psTempDtl.setId(id);
        psTempDtl.setStatus("2010");
        Date date = new Date();
        psTempDtl.setCreateTime(date);
        psTempDtl.setModerTime(date);
        //根据设备唯一标识码获取设备信息
        BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(psTempDtl.getCreateId());//字段接口调用将eid放在CreateId中
        if (bdEquipment != null) {
            psTempDtl.setOrgCode(bdEquipment.getOrgCode());
            psTempDtl.setOrgName(bdEquipment.getOrgName());
            psTempDtl.setOwnOrg1(bdEquipment.getGaOwnerDept1());
            psTempDtl.setOwnOrg2(bdEquipment.getGaOwnerDept2());
            psTempDtl.setOwnOrg3(bdEquipment.getGaOwnerDept3());
            psTempDtl.setOwnOrg4(bdEquipment.getGaOwnerDept4());
            psTempDtl.setOwnOrg5(bdEquipment.getGaOwnerDept5());
        }
        int num = psTempDtlMapper.insertSelective(psTempDtl);
        return num;
    }

    public int psTempDtlUpdate(PsTempDtl psTempDtl, Map<String,String> map){
        int num = psTempDtlMapper.updateByPrimaryKeySelective(psTempDtl);
        return num;
    }

    public PsTempDtl getPsTempDtl(String id){
        return psTempDtlMapper.selectByPrimaryKey(id);
    }

    @Override
    public PsTempDtl getPsTempDtlNew(String id) {
        PsTempDtl psTempDtl = psTempDtlMapper.selectByPrimaryKey(id);
        PsTemp psTemp = psTempMapper.selectByPrimaryKey(psTempDtl.getTempId());
        psTempDtl.setReserve1(psTemp.getSketchMap());
        return psTempDtl;
    }

    public int psTempDtlDelete(String id){
        int num = psTempDtlMapper.deleteByPrimaryKey(id);
        return num;
    }

}