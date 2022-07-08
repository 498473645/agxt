package com.pkusoft.pzzx.service.impl;

import com.pkusoft.pzzx.mapper.BdEquipmentPartsMapper;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.po.BdEquipmentParts;
import com.pkusoft.pzzx.req.BdEquipmentPartsReqParam;
import com.pkusoft.pzzx.service.BdEquipmentPartsService;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class BdEquipmentPartsServiceImpl implements BdEquipmentPartsService {

    @Autowired
    private BdEquipmentPartsMapper bdEquipmentPartsMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    public List<BdEquipmentParts> getBdEquipmentPartsList(BdEquipmentPartsReqParam bdEquipmentParts, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(bdEquipmentParts.getStart(),bdEquipmentParts.getPageSize());
        Example example = new Example(BdEquipmentParts.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdEquipmentParts,map);
        example.setOrderByClause("SN,CREATE_TIME DESC");

        return bdEquipmentPartsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getBdEquipmentPartsCount(BdEquipmentPartsReqParam bdEquipmentParts,Map<String, String> map) {

        Example example = new Example(BdEquipmentParts.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdEquipmentParts,map);

        return bdEquipmentPartsMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, BdEquipmentPartsReqParam bdEquipmentParts,Map<String, String> map){
        criteria.andEqualTo("eObjid",bdEquipmentParts.geteObjid());
        if (StringUtils.hasText(bdEquipmentParts.getParaCode())){
            criteria.andLike("paraCode","%"+bdEquipmentParts.getParaCode()+"%");
        }
        if (StringUtils.hasText(bdEquipmentParts.getParaValue())){
            criteria.andLike("paraValue","%"+bdEquipmentParts.getParaValue()+"%");
        }
    }

    public int bdEquipmentPartsSave(BdEquipmentParts bdEquipmentParts, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        bdEquipmentParts.setObjid(objid);
        bdEquipmentParts.setStatus("2010");
        Date date = new Date();
        bdEquipmentParts.setCreateName(map.get("userName"));
        bdEquipmentParts.setCreateId(map.get("userId"));
        bdEquipmentParts.setCreateTime(date);
        bdEquipmentParts.setModerName(map.get("userName"));
        bdEquipmentParts.setModerId(map.get("userId"));
        bdEquipmentParts.setModerTime(date);

        BdEquipment bdEquipment = bdEquipmentService.getBdEquipment(bdEquipmentParts.getEObjid());
        if (bdEquipment!=null) {
            bdEquipmentParts.setOrgCode(bdEquipment.getOrgCode());
            bdEquipmentParts.setOrgName(bdEquipment.getOrgName());
            bdEquipmentParts.setGaOwnerDept1(bdEquipment.getGaOwnerDept1());
            bdEquipmentParts.setGaOwnerDept2(bdEquipment.getGaOwnerDept2());
            bdEquipmentParts.setGaOwnerDept3(bdEquipment.getGaOwnerDept3());
            bdEquipmentParts.setGaOwnerDept4(bdEquipment.getGaOwnerDept4());
            bdEquipmentParts.setGaOwnerDept5(bdEquipment.getGaOwnerDept5());
        }else {
            return -1;
        }
        int num = bdEquipmentPartsMapper.insertSelective(bdEquipmentParts);
        return num;
    }

    public int bdEquipmentPartsUpdate(BdEquipmentParts bdEquipmentParts, Map<String,String> map){
        bdEquipmentParts.setModerName(map.get("userName"));
        bdEquipmentParts.setModerId(map.get("userId"));
        bdEquipmentParts.setModerTime(new Date());
        int num = bdEquipmentPartsMapper.updateByPrimaryKeySelective(bdEquipmentParts);
        return num;
    }

    public BdEquipmentParts getBdEquipmentParts(String objid){
        return bdEquipmentPartsMapper.selectByPrimaryKey(objid);
    }

    public Map<String,Object> getBdEquipmentPartsMapByEobjid(String equipObjid){
        Map<String,Object> map = new HashMap<>();
        Example example = new Example(BdEquipmentParts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eObjid",equipObjid);
        List<BdEquipmentParts> bdEquipmentPartsList = bdEquipmentPartsMapper.selectByExample(example);
        for (BdEquipmentParts bdEquipmentParts:bdEquipmentPartsList){
            map.put(bdEquipmentParts.getParaCode(),bdEquipmentParts.getParaValue());
        }
        return map;
    }

    public Map<String,Object> getBdEquipmentPartsMapByObjtype(String objtype,Map<String, String> user){
        Map<String,Object> map = new HashMap<>();
        List<BdEquipment> bdEquipmentList = bdEquipmentService.getBdEquipmentListByObjtype(objtype,user);
        if (bdEquipmentList.isEmpty()){
            return map;
        }
        Example example = new Example(BdEquipmentParts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eObjid",bdEquipmentList.get(0).getObjid());
        List<BdEquipmentParts> bdEquipmentPartsList = bdEquipmentPartsMapper.selectByExample(example);
        for (BdEquipmentParts bdEquipmentParts:bdEquipmentPartsList){
            map.put(bdEquipmentParts.getParaCode(),bdEquipmentParts.getParaValue());
        }
        return map;
    }

    public int bdEquipmentPartsDelete(String objid){
        int num = 0;
        num = bdEquipmentPartsMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public List<BdEquipmentParts> getBdEquipmentPartsListByObjtype(String equipObjid){
        Example example = new Example(BdEquipmentParts.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eObjid",equipObjid);
        List<BdEquipmentParts> bdEquipmentPartsList = bdEquipmentPartsMapper.selectByExample(example);
        return bdEquipmentPartsList;
    }

}
