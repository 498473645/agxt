package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.ygjw.mapper.PsWindowMapper;
import com.pkusoft.ygjw.model.PsWindow;
import com.pkusoft.ygjw.req.PsWindowReqParam;
import com.pkusoft.ygjw.service.PsWindowService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class PsWindowServiceImpl implements PsWindowService {

    @Autowired
    private PsWindowMapper psWindowMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<PsWindow> getPsWindowList(PsWindowReqParam psWindowReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psWindowReqParam.getStart(),psWindowReqParam.getPageSize());
        Example example = new Example(PsWindow.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psWindowReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psWindowReqParam.getPageSize()){
            return psWindowMapper.selectByExample(example);
        }
        return psWindowMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsWindowCount(PsWindowReqParam psWindowReqParam, Map<String, String> map) {

        Example example = new Example(PsWindow.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psWindowReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psWindowMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsWindowReqParam psWindowReqParam, Map<String, String> map){
        if(StringUtils.hasText(psWindowReqParam.geteId())){
            //根据eid查询场所信息
            BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(psWindowReqParam.geteId());
            if(StringUtils.hasText(bdEquipment.getObjid())){
                criteria.andEqualTo("orgCode", bdEquipment.getOrgCode());
            }
        }
        if (StringUtils.hasText(psWindowReqParam.getHostBusiness())){
            criteria.andLike("hostBusiness","%"+psWindowReqParam.getHostBusiness()+"%");
        }
        //根据场所id查询窗口
        if(StringUtils.hasText(psWindowReqParam.getHandlingId())){
            criteria.andEqualTo("handlingId", psWindowReqParam.getHandlingId());
        }
    }

    public int psWindowSave(PsWindow psWindow, Map<String,String> map){
        if (!StringUtils.hasText(psWindow.getId())){
            String id = UUID.randomUUID().toString();
            psWindow.setId(id);
        }
        psWindow.setStatus("2010");
        Date date = new Date();
        psWindow.setOrgCode(map.get("deptId"));
        psWindow.setOrgName(map.get("deptName"));
        psWindow.setCreateName(map.get("userName"));
        psWindow.setCreateId(map.get("userId"));
        psWindow.setCreateTime(date);
        psWindow.setModerName(map.get("userName"));
        psWindow.setModerId(map.get("userId"));
        psWindow.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                psWindow.setOwnOrg1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                psWindow.setOwnOrg2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                psWindow.setOwnOrg3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                psWindow.setOwnOrg4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                psWindow.setOwnOrg5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = psWindowMapper.insertSelective(psWindow);
        return num;
    }

    public int psWindowUpdate(PsWindow psWindow, Map<String,String> map){
        int num = psWindowMapper.updateByPrimaryKeySelective(psWindow);
        return num;
    }

    public PsWindow getPsWindow(String id){
        return psWindowMapper.selectByPrimaryKey(id);
    }

    public int psWindowDelete(String id){
        int num = psWindowMapper.deleteByPrimaryKey(id);
        return num;
    }

}