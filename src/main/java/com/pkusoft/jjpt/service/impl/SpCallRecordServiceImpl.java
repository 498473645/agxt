package com.pkusoft.jjpt.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpCallRecordReqParam;
import com.pkusoft.jjpt.service.SpFkxxService;
import com.pkusoft.jjpt.service.SpJjxxService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.constants.JjptConstantCode;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpCallRecord;
import com.pkusoft.jjpt.service.SpCallRecordService;
import com.pkusoft.jjpt.mapper.SpCallRecordMapper;

@Service
@Transactional
public class SpCallRecordServiceImpl implements SpCallRecordService {

    @Autowired
    private SpCallRecordMapper spCallRecordMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SpJjxxService spJjxxService;

    @Autowired
    private SpFkxxService spFkxxService;

    public List<SpCallRecord> getSpCallRecordList(SpCallRecordReqParam spCallRecord, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spCallRecord.getStart(),spCallRecord.getPageSize());
        Example example = new Example(SpCallRecord.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME desc");
        //The query conditions are edited here
        this.setCommonCondition(criteria,spCallRecord,map);

        return spCallRecordMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpCallRecordCount(SpCallRecordReqParam spCallRecord,Map<String, String> map) {

        Example example = new Example(SpCallRecord.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spCallRecord,map);

        return spCallRecordMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpCallRecordReqParam spCallRecord, Map<String, String> map){
        criteria.andEqualTo("orgCode",map.get("deptId"));
        if (StringUtils.hasText(spCallRecord.getStatus())){
            criteria.andEqualTo("status",spCallRecord.getStatus());
        }
        if (StringUtils.hasText(spCallRecord.getLdhm())){
            criteria.andLike("ldhm","%"+spCallRecord.getLdhm()+"%");
        }
        if( StringUtils.hasText(spCallRecord.getStartBjsj()) && StringUtils.hasText(spCallRecord.getEndBjsj()) ){
            //开始截止时间
            criteria.andCondition("CREATE_TIME between to_date('"+spCallRecord.getStartBjsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+spCallRecord.getEndBjsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        //电话处理时间
        if( StringUtils.hasText(spCallRecord.getStartClsj()) && StringUtils.hasText(spCallRecord.getEndClsj()) ){
            //开始截止时间
            criteria.andCondition("CLSJ between to_date('"+spCallRecord.getStartClsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+spCallRecord.getEndClsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
    }

    public List<SpCallRecord> getActiveCallRecordList(SpCallRecordReqParam spCallRecord, Map<String, String> map) {

//        RowBounds rowBounds = new RowBounds(spCallRecord.getStart(),spCallRecord.getPageSize());
        Example example = new Example(SpCallRecord.class);
        example.setOrderByClause("CREATE_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        // 现在只显示24小时内的
        criteria.andEqualTo("orgCode",map.get("deptId"));
        criteria.andCondition("CREATE_TIME >= sysdate-1");
        return spCallRecordMapper.selectByExample(example);
//        criteria.andEqualTo("orgCode",map.get("deptId"));
//        if (StringUtils.hasText(spCallRecord.getStatus())){
//            // 如果查询已闭环，则显示24小时内的，未闭环则显示所有的未闭环
////            criteria.andEqualTo("status",spCallRecord.getStatus());
//            if (JjptConstantCode.IF_CALL_CLOSE_STATUS_2010.equals(spCallRecord.getStatus())){
//                // 如果已闭环，则显示24小时内的，未闭环则显示所有的
//                criteria.andEqualTo("status",JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
//                criteria.andCondition("CREATE_TIME >= sysdate-1");
//            }else {
//                criteria.andNotEqualTo("status",JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
//            }
//        }
//        return spCallRecordMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getActiveCallRecordCount(String callStatus, Map<String, String> map) {

        Example example = new Example(SpCallRecord.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("orgCode",map.get("deptId"));
        if (StringUtils.hasText(callStatus)){
//            criteria.andEqualTo("status",callStatus);
            if (JjptConstantCode.IF_CALL_CLOSE_STATUS_2010.equals(callStatus)){
                // 如果已闭环，则显示24小时内的，未闭环则显示所有的
                criteria.andEqualTo("status",JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
                criteria.andCondition("CREATE_TIME >= sysdate-1");
            }else {
                criteria.andNotEqualTo("status",JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
            }
        }

        return spCallRecordMapper.selectCountByExample(example);
    }

    public int spCallRecordSave(SpCallRecord spCallRecord, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spCallRecord.setObjid(objid);
        if(!StringUtils.hasText(spCallRecord.getLdTypeCode())){
            spCallRecord.setLdType("未接");
            spCallRecord.setLdTypeCode("23");
        }
        Date date = new Date();
        spCallRecord.setCreateName(map.get("userName"));
        spCallRecord.setCreateId(map.get("userId"));
        spCallRecord.setCreateTime(date);
        spCallRecord.setModerName(map.get("userName"));
        spCallRecord.setModerId(map.get("userId"));
        spCallRecord.setModerTime(date);
        spCallRecord.setOrgCode(map.get("deptId"));
        spCallRecord.setOrgName(map.get("deptName"));
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spCallRecord.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spCallRecord.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spCallRecord.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spCallRecord.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spCallRecord.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = spCallRecordMapper.insertSelective(spCallRecord);
        return num;
    }

    public int spCallRecordUpdate(SpCallRecord spCallRecord, Map<String,String> map){
        spCallRecord.setModerName(map.get("userName"));
        spCallRecord.setModerId(map.get("userId"));
        spCallRecord.setModerTime(new Date());
        int num = spCallRecordMapper.updateByPrimaryKeySelective(spCallRecord);
        return num;
    }

    public int updateAllRelatedSpCall(SpJjxx spJjxx, Map<String,String> map){
        int num = 0;
        Example example = new Example(SpCallRecord.class);
        example.setOrderByClause("CREATE_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ldhm",spJjxx.getLxdh());
        criteria.andEqualTo("status",JjptConstantCode.IF_CALL_CLOSE_STATUS_1010);
        criteria.andEqualTo("ldTypeCode",JjptConstantCode.CALL_TYPE_STATUS_21);
        List<SpCallRecord> spCallRecordList = spCallRecordMapper.selectByExample(example);
        for (SpCallRecord spCallRecord:spCallRecordList) {
            spCallRecord.setStatus(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
            spCallRecord.setJjObjid(spJjxx.getObjid());
            spCallRecord.setJjdbh(spJjxx.getBjdh());
            spCallRecord.setClsj(new Date());
            spCallRecord.setModerName(map.get("userName"));
            spCallRecord.setModerId(map.get("userId"));
            spCallRecord.setModerTime(new Date());
            num += spCallRecordMapper.updateByPrimaryKeySelective(spCallRecord);
        }
        return num;
    }

    public int laterHandlePolice(SpCallRecord spCallRecord, Map<String,String> map){
        int num = 0;
        // 新增一条无报警信息的接警警情
        SpJjxx spJjxx = new SpJjxx();
        spJjxx.setCaId(spCallRecord.getObjid());
        Date date = new Date();
//            spJjxx.setOrgCode(map.get("deptId"));
//            spJjxx.setOrgName(map.get("deptName"));
//            spJjxx.setCreateName(map.get("userName"));
//            spJjxx.setCreateId(map.get("userId"));
//            spJjxx.setCreateTime(date);
//            spJjxx.setModerName(map.get("userName"));
//            spJjxx.setModerId(map.get("userId"));
//            spJjxx.setModerTime(date);
//            SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
//            if (sysDataOwnerDept != null) {
//                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
//                    spJjxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
//                }
//                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
//                    spJjxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
//                }
//                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
//                    spJjxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
//                }
//                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
//                    spJjxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
//                }
//                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
//                    spJjxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
//                }
//                spJjxx.setOwnerType("1");
//            }
        String jjdbh = spJjxxService.generateJjdbh(map.get("deptId"));
        spJjxx.setJjdbh(jjdbh);
        spJjxx.setLxdh(spJjxx.getBjdh());
        spJjxx.setStatus(JjptConstantCode.CASESTATUS_1001);//添加后默认是接警状态
        spJjxx.setReporterSource(JjptConstantCode.REPORT_SOURCE_1003);
        spJjxx.setBjdh(spCallRecord.getLdhm());
        spJjxx.setLxdh(spCallRecord.getLdhm());
        spJjxx.setJjsj(date);
        spJjxx.setBjsj(date);
        spJjxx.setJjyCode(map.get("userId"));
        spJjxx.setJjy(map.get("userName"));
        spJjxx.setJjdw(map.get("deptId"));
        spJjxx.setJjdwmc(map.get("deptName"));
        int jjNum = spJjxxService.doSpJjxxSave(spJjxx,map);
        if (jjNum>0){
            // 将电话闭环
            String jjObjid = spJjxx.getObjid();
            spCallRecord.setStatus(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
            spCallRecord.setJjObjid(jjObjid);
            spCallRecord.setJjdbh(jjdbh);
            spCallRecord.setClsj(new Date());
            spCallRecord.setModerName(map.get("userName"));
            spCallRecord.setModerId(map.get("userId"));
            spCallRecord.setModerTime(new Date());
            num = spCallRecordMapper.updateByPrimaryKeySelective(spCallRecord);
        }
        return num;
    }

    public int noUseCallRecord(SpCallRecordReqParam spCallRecordReqParam, Map<String,String> map){
        int num = 0;
        SpCallRecord spCallRecord = new SpCallRecord();
        BeanUtils.copyProperties(spCallRecordReqParam,spCallRecord);
        // 新增一条接警警情
        SpJjxx spJjxx = new SpJjxx();
        String jjdbh = spJjxxService.generateJjdbh(map.get("deptId"));
        spJjxx.setJjdbh(jjdbh);
        spJjxx.setCaId(spCallRecord.getObjid());
        Date date = new Date();
        spJjxx.setStatus(JjptConstantCode.CASESTATUS_1004);//添加后默认是已反馈
        spJjxx.setReporterSource(JjptConstantCode.REPORT_SOURCE_1003);
        spJjxx.setJqtypeid1(spCallRecordReqParam.getCjjgbm());
        spJjxx.setJqtypeName1(spCallRecordReqParam.getCjjgmc());
        spJjxx.setBjnr(spCallRecordReqParam.getCjjgmc());
        spJjxx.setBjdh(spCallRecordReqParam.getLdhm());
        spJjxx.setLxdh(spCallRecordReqParam.getLdhm());
        spJjxx.setJjsj(date);
        spJjxx.setJjsj(date);
        spJjxx.setBjsj(date);
        spJjxx.setCjsj(date);
        spJjxx.setDdsj(date);
        spJjxx.setFksj(date);
        spJjxx.setJjyCode(map.get("userId"));
        spJjxx.setJjy(map.get("userName"));
        spJjxx.setJjdw(map.get("deptId"));
        spJjxx.setJjdwmc(map.get("deptName"));
        spJjxx.setDdsj(date);
        spJjxx.setDdrCode(map.get("userId"));
        spJjxx.setDdrName(map.get("userName"));
        spJjxx.setSldw(map.get("deptId"));
        spJjxx.setSldwName(map.get("deptName"));
        spJjxx.setGxdw(map.get("deptId"));
        spJjxx.setGxdwName(map.get("deptName"));
        int jjNum = spJjxxService.doSpJjxxSave(spJjxx,map);
        if (jjNum>0){
            // 新增一条反馈警情
            SpFkxx spFkxx = new SpFkxx();
            BeanUtils.copyProperties(spJjxx,spFkxx);
            String cjdbh = spJjxxService.generateCjdbh(map.get("deptId"));
            spFkxx.setCjdbh(cjdbh);
            spFkxx.setJjdObjid(spJjxx.getObjid());
            spFkxx.setJjdbh(jjdbh);
            spFkxx.setCjjgbm(spCallRecordReqParam.getCjjgbm());
            spFkxx.setCjjgmc(spCallRecordReqParam.getCjjgmc());
            spFkxx.setCjjg(spCallRecordReqParam.getCjjgmc());
            int fkNum = spFkxxService.spFkxxSave(spFkxx,map);
            if (fkNum>0){
                // 将电话闭环
                BeanUtils.copyProperties(spCallRecordReqParam,spCallRecord);
                spCallRecord.setStatus(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
                spCallRecord.setJjObjid(spJjxx.getObjid());
                spCallRecord.setJjdbh(jjdbh);
                spCallRecord.setClsj(new Date());
                num = this.spCallRecordUpdate(spCallRecord,map);
                // 更新反馈单信息
                spJjxx.setCjdObjid(spFkxx.getObjid());
                spJjxx.setCjdbh(cjdbh);
                spJjxxService.spJjxxUpdate(spJjxx,map);
            }
        }
        return num;
    }

//    public int noUseCallRecord(SpCallRecordReqParam spCallRecordReqParam, Map<String,String> map){
//        // 接警表和处警表主键
//        String jjObjid = UUID.randomUUID().toString();
//        String cjObjid = UUID.randomUUID().toString();
//        String jjdbh = spJjxxService.generateJjdbh(map.get("deptId"));
//        String cjdbh = spJjxxService.generateCjdbh(map.get("deptId"));
//        // 将电话闭环
//        SpCallRecord spCallRecord = new SpCallRecord();
//        BeanUtils.copyProperties(spCallRecordReqParam,spCallRecord);
//        spCallRecord.setStatus(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
//        spCallRecord.setJjObjid(jjObjid);
//        spCallRecord.setClsj(new Date());
//        spCallRecord.setModerName(map.get("userName"));
//        spCallRecord.setModerId(map.get("userId"));
//        spCallRecord.setModerTime(new Date());
//        int num = spCallRecordMapper.updateByPrimaryKeySelective(spCallRecord);
//        if (num>0){
//            // 新增一条接警警情
//            SpJjxx spJjxx = new SpJjxx();
////            spJjxx.setObjid(jjObjid);
//            spJjxx.setJjdbh(jjdbh);
//            spJjxx.setCaId(spCallRecord.getObjid());
//            spJjxx.setCjdObjid(cjObjid);
//            spJjxx.setCjdbh(cjdbh);
//            Date date = new Date();
////            spJjxx.setOrgCode(map.get("deptId"));
////            spJjxx.setOrgName(map.get("deptName"));
////            spJjxx.setCreateName(map.get("userName"));
////            spJjxx.setCreateId(map.get("userId"));
////            spJjxx.setCreateTime(date);
////            spJjxx.setModerName(map.get("userName"));
////            spJjxx.setModerId(map.get("userId"));
////            spJjxx.setModerTime(date);
//            spJjxx.setStatus(JjptConstantCode.CASESTATUS_1004);//添加后默认是已反馈
//            spJjxx.setReporterSource(JjptConstantCode.REPORT_SOURCE_1003);
//            spJjxx.setJjsj(date);
//            spJjxx.setBjsj(date);
//            spJjxx.setCjsj(date);
//            spJjxx.setDdsj(date);
//            spJjxx.setFksj(date);
//            spJjxx.setJjyCode(map.get("userId"));
//            spJjxx.setJjy(map.get("userName"));
//            spJjxx.setJjdw(map.get("deptId"));
//            spJjxx.setJjdwmc(map.get("deptName"));
//            spJjxx.setDdsj(date);
//            spJjxx.setDdrCode(map.get("userId"));
//            spJjxx.setDdrName(map.get("userName"));
//            spJjxx.setSldw(map.get("deptId"));
//            spJjxx.setSldwName(map.get("deptName"));
//            spJjxx.setGxdw(map.get("deptId"));
//            spJjxx.setGxdwName(map.get("deptName"));
////            SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
////            if (sysDataOwnerDept != null) {
////                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
////                    spJjxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
////                }
////                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
////                    spJjxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
////                }
////                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
////                    spJjxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
////                }
////                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
////                    spJjxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
////                }
////                if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
////                    spJjxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
////                }
////                spJjxx.setOwnerType("1");
////            }
//            int jjNum = spJjxxService.doSpJjxxSave(spJjxx,map);
//            if (jjNum>0){
//                // 新增一条反馈警情
//                SpFkxx spFkxx = new SpFkxx();
//                BeanUtils.copyProperties(spJjxx,spFkxx);
////                spFkxx.setObjid(cjObjid);
//                spFkxx.setCjdbh(cjdbh);
//                spFkxx.setJjdObjid(jjObjid);
//                spFkxx.setJjdbh(jjdbh);
//                spFkxx.setCjjgbm(spCallRecordReqParam.getCjjgbm());
//                spFkxx.setCjjgmc(spCallRecordReqParam.getCjjgmc());
//                spFkxx.setCjjg(spCallRecordReqParam.getCjjgmc());
////                spFkxx.setCreateName(map.get("userName"));
////                spFkxx.setCreateId(map.get("userId"));
////                spFkxx.setCreateTime(date);
////                spFkxx.setModerName(map.get("userName"));
////                spFkxx.setModerId(map.get("userId"));
////                spFkxx.setModerTime(date);
//                int fkNum = spFkxxService.spFkxxSave(spFkxx,map);
//            }
//            // 如果有对接，需要在此调用反馈接口
//        }
//        return num;
//    }

    public SpCallRecord getSpCallRecord(String objid){
        return spCallRecordMapper.selectByPrimaryKey(objid);
    }

    public int ifAlreadyCalledWithinTime(String ldhm, String time) throws Exception {
        Example example = new Example(SpCallRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ldhm",ldhm);
        Calendar cal = Calendar.getInstance();
        int timeInt = Integer.parseInt(time);
        cal.add(Calendar.HOUR, -timeInt);
        Date date = cal.getTime();
//        criteria.andGreaterThanOrEqualTo("createTime",date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeFmt = sdf.format(date);
        criteria.andCondition("CREATE_TIME >= to_date('"+timeFmt+"', 'yyyy-mm-dd hh24:mi:ss')");
        return spCallRecordMapper.selectCountByExample(example);
    }

    public int spCallRecordDelete(String objid){
        int num = 0;
        num = spCallRecordMapper.deleteByPrimaryKey(objid);
        return num;
    }

}
