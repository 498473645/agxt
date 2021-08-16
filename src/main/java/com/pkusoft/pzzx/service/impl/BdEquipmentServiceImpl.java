package com.pkusoft.pzzx.service.impl;

import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.pzzx.mapper.BdEquipmentMapper;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.req.BdEquipmentReqParam;
import com.pkusoft.pzzx.service.BdEquipmentService;
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
import java.util.UUID;

@Service
@Transactional
public class BdEquipmentServiceImpl implements BdEquipmentService {

    @Autowired
    private BdEquipmentMapper bdEquipmentMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<BdEquipment> getBdEquipmentList(BdEquipmentReqParam bdEquipment, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(bdEquipment.getStart(),bdEquipment.getPageSize());
        Example example = new Example(BdEquipment.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdEquipment,map);
        example.setOrderByClause("CREATE_TIME DESC");
        sysPermitService.setUserDataPermits(criteria,map, PermitType.PERMIT_TYPE_DEPT_QUERY);

        return bdEquipmentMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getBdEquipmentCount(BdEquipmentReqParam bdEquipment,Map<String, String> map) {

        Example example = new Example(BdEquipment.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,bdEquipment,map);
        sysPermitService.setUserDataPermits(criteria,map, PermitType.PERMIT_TYPE_DEPT_QUERY);
        return bdEquipmentMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, BdEquipmentReqParam bdEquipment, Map<String, String> map){
        if (StringUtils.hasText(bdEquipment.getObjtype())){
            criteria.andEqualTo("objtype",bdEquipment.getObjtype());
        }
        if (StringUtils.hasText(bdEquipment.getObjname())){
            criteria.andLike("objname","%"+bdEquipment.getObjname()+"%");
        }
        if (StringUtils.hasText(bdEquipment.getEId())){
            criteria.andLike("eId","%"+bdEquipment.getEId()+"%");
        }
        criteria.andEqualTo("orgCode",map.get("deptId"));
    }

    public int bdEquipmentSave(BdEquipment bdEquipment, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        bdEquipment.setObjid(objid);
        bdEquipment.setStatus("2010");
        Date date = new Date();
        bdEquipment.setOrgCode(map.get("deptId"));
        bdEquipment.setOrgName(map.get("deptName"));
        bdEquipment.setCreateName(map.get("userName"));
        bdEquipment.setCreateId(map.get("userId"));
        bdEquipment.setCreateTime(date);
        bdEquipment.setModerName(map.get("userName"));
        bdEquipment.setModerId(map.get("userId"));
        bdEquipment.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                bdEquipment.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                bdEquipment.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                bdEquipment.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                bdEquipment.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                bdEquipment.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = bdEquipmentMapper.insertSelective(bdEquipment);
        return num;
    }

    public int bdEquipmentUpdate(BdEquipment bdEquipment, Map<String,String> map){
        bdEquipment.setModerName(map.get("userName"));
        bdEquipment.setModerId(map.get("userId"));
        bdEquipment.setModerTime(new Date());
        int num = bdEquipmentMapper.updateByPrimaryKeySelective(bdEquipment);
        return num;
    }

    public BdEquipment getBdEquipment(String objid){
        return bdEquipmentMapper.selectByPrimaryKey(objid);
    }

    public int bdEquipmentDelete(String objid){
        int num = 0;
        num = bdEquipmentMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public List<BdEquipment> getBdEquipmentListByObjtype(String objtype,Map<String, String> user) {
        Example example = new Example(BdEquipment.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME desc");
        //The query conditions are edited here
        criteria.andEqualTo("objtype",objtype);//扫码枪
        String deptId = user.get("deptId");
        if (StringUtils.hasText(deptId)) {
            criteria.andEqualTo("orgCode", deptId);
        }
        return bdEquipmentMapper.selectByExample(example);
    }

    public BdEquipment getBdEquipmentByEId(String eId) {
        BdEquipment bdEquipment = new BdEquipment();
        Example example = new Example(BdEquipment.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME desc");
        //The query conditions are edited here
        criteria.andEqualTo("eId",eId);//唯一标识码
        List<BdEquipment> BdEquipments= bdEquipmentMapper.selectByExample(example);
        if(BdEquipments!=null && BdEquipments.size()>0){
            bdEquipment = BdEquipments.get(0);
        }
        return bdEquipment;
    }

}