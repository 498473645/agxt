package com.pkusoft.jjpt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.req.SpCjrxxReqParam;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpCjrxx;
import com.pkusoft.jjpt.service.SpCjrxxService;
import com.pkusoft.jjpt.mapper.SpCjrxxMapper;

@Service
@Transactional
public class SpCjrxxServiceImpl implements SpCjrxxService {

    @Autowired
    private SpCjrxxMapper spCjrxxMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<SpCjrxx> getSpCjrxxList(SpCjrxxReqParam spCjrxx, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spCjrxx.getStart(), spCjrxx.getPageSize());
        Example example = new Example(SpCjrxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria, spCjrxx);

        return spCjrxxMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public int getSpCjrxxCount(SpCjrxxReqParam spCjrxx, Map<String, String> map) {

        Example example = new Example(SpCjrxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria, spCjrxx);

        return spCjrxxMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpCjrxxReqParam spCjrxx) {
        if (StringUtils.hasText(spCjrxx.getOrgCode())) {
            criteria.andEqualTo("orgCode", spCjrxx.getOrgCode());
        }
        if (StringUtils.hasText(spCjrxx.getCjdObjid())) {
            criteria.andEqualTo("cjdObjid", spCjrxx.getCjdObjid());
        }
    }

    public int spCjrxxSave(SpCjrxx spCjrxx, Map<String, String> map) {
        String objid = UUID.randomUUID().toString();
        spCjrxx.setObjid(objid);
        Date date = new Date();
        spCjrxx.setCreateName(map.get("userName"));
        spCjrxx.setCreateId(map.get("userId"));
        spCjrxx.setCreateTime(date);
        spCjrxx.setModerName(map.get("userName"));
        spCjrxx.setModerId(map.get("userId"));
        spCjrxx.setModerTime(date);
        spCjrxx.setOrgCode(map.get("deptId"));
        spCjrxx.setOrgName(map.get("deptName"));
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        //获取归属单位
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spCjrxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spCjrxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spCjrxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spCjrxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spCjrxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = spCjrxxMapper.insertSelective(spCjrxx);
        return num;
    }

    public int spCjrxxUpdate(SpCjrxx spCjrxx, Map<String, String> map) {
        Date date = new Date();
        spCjrxx.setModerName(map.get("userName"));
        spCjrxx.setModerId(map.get("userId"));
        spCjrxx.setModerTime(date);
        int num = spCjrxxMapper.updateByPrimaryKeySelective(spCjrxx);
        return num;
    }

    public SpCjrxx getSpCjrxx(String objid) {
        return spCjrxxMapper.selectByPrimaryKey(objid);
    }

    public int spCjrxxDelete(String objid) {
        int num = 0;
        num = spCjrxxMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public int uptSpCjrxxStatus(SpFkxx spFkxx, Map<String,String> map) {
        int num = 0;
        //根据处警单id查询相关处警人信息
        SpCjrxx spCjrxx = new SpCjrxx();
        spCjrxx.setCjdObjid(spFkxx.getObjid());
        List<SpCjrxx> SpCjrxxs=getSpCjrxxListByParam(spCjrxx,map);
        for (SpCjrxx cjr : SpCjrxxs){
            //修改处警人状态
            SpCjrxx cjrxx = new SpCjrxx();
            cjrxx.setObjid(cjr.getObjid());
            cjrxx.setStatus(spFkxx.getStatus());
            cjrxx.setDcData(spFkxx.getDcsj());
            cjrxx.setFkData(spFkxx.getFksj());
            num = spCjrxxUpdate(cjr,map);
        }

        return num;
    }

    @Override
    public List<SpCjrxx> getSpCjrxxListByParam(SpCjrxx spCjrxx, Map<String, String> map) {
        Example example = new Example(SpCjrxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(spCjrxx.getCjdObjid())) {
            criteria.andEqualTo("cjdObjid", spCjrxx.getCjdObjid());
        }
        return spCjrxxMapper.selectByExample(example);
    }

}
