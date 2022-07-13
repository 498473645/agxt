package com.pkusoft.ygjw.service.impl;

import com.pkusoft.jjpt.mapper.SpFilesMapper;
import com.pkusoft.jjpt.po.SpFiles;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.service.SpFilesService;
import com.pkusoft.jjpt.service.SpJjxxService;
import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.ygjw.mapper.PsApprsMapper;
import com.pkusoft.ygjw.model.PsApprs;
import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.req.PsApprsReqParam;
import com.pkusoft.ygjw.req.PsApprsYgjwReqParam;
import com.pkusoft.ygjw.service.PsApprsService;
import com.pkusoft.ygjw.service.PsTransService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class PsApprsServiceImpl implements PsApprsService {

    @Autowired
    private PsApprsMapper psApprsMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private PsTransService psTransService;

    @Autowired
    private SpFilesService spFilesService;

    @Autowired
    private SpFilesMapper spFilesMapper;

    @Autowired
    private SysPermitService sysPermitService;

    @Autowired
    private SpJjxxService spJjxxService;

    public List<PsApprs> getPsApprsList(PsApprsReqParam psApprsReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psApprsReqParam.getStart(),psApprsReqParam.getPageSize());
        Example example = new Example(PsApprs.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psApprsReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        if(0 == psApprsReqParam.getPageSize()){
            return psApprsMapper.selectByExample(example);
        }
        return psApprsMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<PsApprs> psApprsListByIdcard(String idcard) {
        List<PsTrans> psTransList = psTransService.getPsTransListByIdcard(idcard,"");
        List<String> tranIdList = new ArrayList<>();
        for (PsTrans psTrans:psTransList){
            tranIdList.add(psTrans.getJjdObjid());
        }
        if (!tranIdList.isEmpty()){
            Example example = new Example(PsApprs.class);
            Example.Criteria criteria = example.createCriteria();
            //The query conditions are edited here
            example.setOrderByClause("CREATE_TIME DESC");
            criteria.andIn("jjdObjid",tranIdList);
            return psApprsMapper.selectByExample(example);
        }
        return new ArrayList<>();
    }

    public int getPsApprsCount(PsApprsReqParam psApprsReqParam, Map<String, String> map) {

        Example example = new Example(PsApprs.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psApprsReqParam,map);
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        example.setOrderByClause("CREATE_TIME DESC");
        return psApprsMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsApprsReqParam psApprsReqParam, Map<String, String> map){
        if(StringUtils.hasText(psApprsReqParam.getJjdObjid())){
            criteria.andEqualTo("jjdObjid",psApprsReqParam.getJjdObjid());
        }
        if(StringUtils.hasText(psApprsReqParam.getJjdbh())){
            criteria.andEqualTo("jjdbh",psApprsReqParam.getJjdbh());
        }
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
        psApprs.setStatus("1001");
        Date date = new Date();
        psApprs.setApTime(date);
        psApprs.setCreateTime(date);
        psApprs.setModerTime(date);

        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(psApprs.getOrgCode());
        if (sysDataOwnerDept != null) {
            psApprs.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            psApprs.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            psApprs.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            psApprs.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            psApprs.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
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

    public int psApprsSave(PsApprsYgjwReqParam psApprsYgjwReqParam, Map<String,String> map){
        PsApprs psApprs = new PsApprs();
        BeanUtils.copyProperties(psApprsYgjwReqParam,psApprs);
        if (!StringUtils.hasText(psApprs.getId())){
            String id = UUID.randomUUID().toString();
            psApprs.setId(id);
        }
        psApprs.setStatus("1001");
        Date date = new Date();
        psApprs.setApTime(date);
        psApprs.setCreateTime(date);
        psApprs.setModerTime(date);
        SpJjxx spJjxx = spJjxxService.getSpJjxx(psApprs.getJjdObjid());
        int num = 0;
        if (spJjxx!=null){
            psApprs.setOrgCode(spJjxx.getOrgCode());
            psApprs.setOrgName(spJjxx.getOrgName());
            psApprs.setGaOwnerDept1(spJjxx.getGaOwnerDept1());
            psApprs.setGaOwnerDept2(spJjxx.getGaOwnerDept2());
            psApprs.setGaOwnerDept3(spJjxx.getGaOwnerDept3());
            psApprs.setGaOwnerDept4(spJjxx.getGaOwnerDept4());
            psApprs.setGaOwnerDept5(spJjxx.getGaOwnerDept5());
            psApprs.setDataType(spJjxx.getReporterSource());
            psApprs.setType(spJjxx.getJqtypeid1());
            psApprs.setName(spJjxx.getJqtypeName1());
            psApprs.setJjdbh(spJjxx.getJjdbh());
            num = psApprsMapper.insertSelective(psApprs);
            if (num > 0) {
                //评议完成后修改jjxx表中的评议状态
                SpJjxx uptJjxx = new SpJjxx();
                uptJjxx.setObjid(spJjxx.getObjid());
                uptJjxx.setIsPy("1");
                spJjxxService.spJjxxUpdate(uptJjxx,map);
                List<SpFiles> list = spFilesService.selectPicByCase(psApprs.getJjdObjid(),"0102");
                for (SpFiles spFiles : list) {
                    spFiles.setAObjid(psApprs.getId());
                    spFiles.setOrgCode(spJjxx.getOrgCode());
                    spFiles.setOrgName(spJjxx.getOrgName());
                    spFilesMapper.updateByPrimaryKeySelective(spFiles);
                }
            }
        }
//        if (num>0 && "1".equals(psApprs.getDataType()) && !psApprsYgjwReqParam.getMultiFilePaths().isEmpty()){
//            // 关联材料
//            List<String> files = psApprsYgjwReqParam.getMultiFilePaths();
//            for (String fileId:files) {
//                SpFiles spFiles = spFilesService.getSpFiles(fileId);
//                spFiles.setTempDtlId(psApprs.getId());
//            }
//        }
        return num;
    }

    public int psApprsUpdate(PsApprsYgjwReqParam psApprsYgjwReqParam, Map<String,String> map){
        PsApprs psApprs = new PsApprs();
        BeanUtils.copyProperties(psApprsYgjwReqParam,psApprs);
        Date date = new Date();
//        psApprs.setModerTime(date);
        psApprs.setHandleTime(date);
        int num = psApprsMapper.updateByPrimaryKeySelective(psApprs);
        return num;
    }

    public PsApprs getPsApprs(String id){
        return psApprsMapper.selectByPrimaryKey(id);
    }

    public PsApprs getPsApprsDetailsByTranId(String transId){
        Example example = new Example(PsApprs.class);
        example.setOrderByClause("AP_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("transId",transId);
        List<PsApprs> psApprsList = psApprsMapper.selectByExample(example);
        if (psApprsList.isEmpty()){
            return null;
        }
        return psApprsList.get(0);
    }

    public int psApprsDelete(String id){
        int num = psApprsMapper.deleteByPrimaryKey(id);
        return num;
    }

}
