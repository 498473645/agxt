package com.pkusoft.jjpt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.jjpt.req.SpRecordReqParam;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpRecord;
import com.pkusoft.jjpt.service.SpRecordService;
import com.pkusoft.jjpt.mapper.SpRecordMapper;

@Service
@Transactional
public class SpRecordServiceImpl implements SpRecordService {

    @Autowired
    private SpRecordMapper spRecordMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<SpRecord> getSpRecordList(SpRecordReqParam spRecord, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spRecord.getStart(),spRecord.getPageSize());
        Example example = new Example(SpRecord.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spRecord,map);

        return spRecordMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpRecordCount(SpRecordReqParam spRecord,Map<String, String> map) {

        Example example = new Example(SpRecord.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spRecord,map);

        return spRecordMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpRecordReqParam spRecord, Map<String, String> map){
        //criteria.andEqualTo("orgCode",map.get("deptId"));
        if (StringUtils.hasText(spRecord.getJjdObjid())) {
            criteria.andEqualTo("jjdObjid", spRecord.getJjdObjid());
        }else {
            criteria.andEqualTo("jjdObjid", "");
        }
    }

    public int doSpRecordSave(SpRecord spRecord, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spRecord.setObjid(objid);
        Date date = new Date();
        spRecord.setCreateName(map.get("userName"));
        spRecord.setCreateId(map.get("userId"));
        spRecord.setCreateTime(date);
        spRecord.setModerName(map.get("userName"));
        spRecord.setModerId(map.get("userId"));
        spRecord.setModerTime(date);
        spRecord.setOrgCode(map.get("deptId"));
        spRecord.setOrgName(map.get("deptName"));
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        //获取归属单位
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spRecord.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spRecord.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spRecord.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spRecord.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spRecord.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        return spRecordMapper.insertSelective(spRecord);
    }
    public int spRecordSave(SpRecord spRecord, Map<String,String> map){
        int num = this.doSpRecordSave(spRecord,map);
        return num;
    }

    public int spRecordUpdate(SpRecord spRecord, Map<String,String> map){
        spRecord.setModerName(map.get("userName"));
        spRecord.setModerId(map.get("userId"));
        spRecord.setModerTime(new Date());
        // 修改操作发生在保存笔录信息的时候
        if (spRecord.getJssj()==null && StringUtils.hasText(spRecord.getRecords())){
            spRecord.setJssj(new Date());
        }
        int num = spRecordMapper.updateByPrimaryKeySelective(spRecord);
        return num;
    }

    public SpRecord getSpRecord(String objid){
        return spRecordMapper.selectByPrimaryKey(objid);
    }

    public int spRecordDelete(String objid){
        int num = 0;
        num = spRecordMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public int getRecordTime(SpRecord spRecord) {

        Example example = new Example(SpRecord.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        String jjdObjid = spRecord.getJjdObjid();
        if (StringUtils.hasText(jjdObjid)) {
            criteria.andEqualTo("jjdObjid", jjdObjid);
        }else {
            return 0;
        }
        if (spRecord.getKssj() != null && spRecord.getJssj() != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            criteria.andCondition("jssj <= to_date('"+sdf.format(spRecord.getJssj())+"','yyyy-MM-dd HH24:Mi:ss')");
        }
        int ret = spRecordMapper.selectCountByExample(example);
        if (ret==0) {
            return 1;
        }
        return ret;
    }
}
