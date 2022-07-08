package com.pkusoft.ygjw.service.impl;

import com.pkusoft.lesp.mapper.RsJbjJgxtDynamicMapper;
import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import com.pkusoft.lesp.service.RsJbjJgxtDynamicService;
import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
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
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    @Autowired
    private RsJbjJgxtDynamicService rsJbjJgxtDynamicService;

    @Autowired
    private RsJbjJgxtDynamicMapper rsJbjJgxtDynamicMapper;

    public List<PsTrans> getPsTransListByIdcard(String idcard,String ly) {
        Example example = new Example(PsTrans.class);
        Example.Criteria criteria = example.createCriteria();
        example.setOrderByClause("CREATE_TIME DESC");
        if (StringUtils.hasText(idcard)) {
            criteria.andEqualTo("repIdcard", idcard);
        }
        if (StringUtils.hasText(ly)){
            criteria.andEqualTo("ly",ly);
        }
        return psTransMapper.selectByExample(example);
    }

    public List<PsTrans> getPsTransList(PsTransReqParam psTransReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psTransReqParam.getStart(),psTransReqParam.getPageSize());
        Example example = new Example(PsTrans.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTransReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
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
        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        return psTransMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsTransReqParam psTransReqParam, Map<String, String> map){
        if (StringUtils.hasText(psTransReqParam.getJjdbh())){
            criteria.andLike("jjdbh","%"+psTransReqParam.getJjdbh()+"%");
        }
        if(StringUtils.hasText(psTransReqParam.getRepName())){
            criteria.andLike("repName","%"+psTransReqParam.getRepName()+"%");
        }
        if(StringUtils.hasText(psTransReqParam.getRepSex())){
            criteria.andEqualTo("repSex",psTransReqParam.getRepSex());
        }
        if(StringUtils.hasText(psTransReqParam.getType())){
            criteria.andEqualTo("type",psTransReqParam.getType());
        }
        if(StringUtils.hasText(psTransReqParam.getLy())){
            criteria.andEqualTo("ly",psTransReqParam.getLy());
        }
        if(StringUtils.hasText(psTransReqParam.getStatus())){
            criteria.andEqualTo("status",psTransReqParam.getStatus());
        }
        if(StringUtils.hasText(psTransReqParam.getOrgCode())){
            criteria.andEqualTo("orgCode",psTransReqParam.getOrgCode());
        }
        if(StringUtils.hasText(psTransReqParam.getDataType())){
            criteria.andEqualTo("dataType",psTransReqParam.getDataType());
        }
        if( StringUtils.hasText(psTransReqParam.getStartOccTime()) && StringUtils.hasText(psTransReqParam.getEndOccTime()) ){
            //开始截止时间
            criteria.andCondition("OCC_TIME between to_date('"+psTransReqParam.getStartOccTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psTransReqParam.getEndOccTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        if( StringUtils.hasText(psTransReqParam.getStartRepTime()) && StringUtils.hasText(psTransReqParam.getEndRepTime()) ){
            //开始截止时间
            criteria.andCondition("REP_TIME between to_date('"+psTransReqParam.getStartRepTime()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+psTransReqParam.getEndRepTime()+"','yyyy-MM-dd hh24:mi:ss')");
        }
    }

    public String psTransSave(PsTrans psTrans, Map<String,String> map){
        if (!StringUtils.hasText(psTrans.getId())){
            String id = UUID.randomUUID().toString();
            psTrans.setId(id);
        }
        psTrans.setStatus("1010");
        Date date = new Date();
        psTrans.setCreateTime(date);
        psTrans.setModerTime(date);
        psTrans.setRepTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(psTrans.getOrgCode());
        if (sysDataOwnerDept != null) {
            psTrans.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            psTrans.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            psTrans.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            psTrans.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            psTrans.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
        }
        if (!StringUtils.hasText(psTrans.getCode())){
            psTrans.setCode(this.generateJjdbh(psTrans.getOrgCode()));
        }
        int num = psTransMapper.insertSelective(psTrans);
        if(num>0){
            //插入RsJbjJgxtDynamic
            RsJbjJgxtDynamic rsJbjJgxtDynamic = new RsJbjJgxtDynamic();
            //数据来源
            rsJbjJgxtDynamic.setYjjbm(psTrans.getId());
            rsJbjJgxtDynamic.setJqly(psTrans.getDataType());
            rsJbjJgxtDynamic.setBjrxm(psTrans.getRepName());
            rsJbjJgxtDynamic.setBjrgmsfhm(psTrans.getRepIdcard());
            rsJbjJgxtDynamic.setJjdw(psTrans.getOrgCode());
            rsJbjJgxtDynamic.setJjdwmc(psTrans.getOrgName());
            rsJbjJgxtDynamic.setBjsj(date);
            rsJbjJgxtDynamic.setSfdd(psTrans.getOccAddr());
            rsJbjJgxtDynamic.setBjrxb(psTrans.getRepSex());
            rsJbjJgxtDynamic.setBjrlxdh(psTrans.getRepTel());
            rsJbjJgxtDynamic.setBjnr(psTrans.getOccDescr());
            rsJbjJgxtDynamic.setAfsj(psTrans.getOccTime());
            rsJbjJgxtDynamic.setBjlx(psTrans.getType());
            rsJbjJgxtDynamic.setGaOwnerDept1(psTrans.getGaOwnerDept1());
            rsJbjJgxtDynamic.setGaOwnerDept2(psTrans.getGaOwnerDept2());
            rsJbjJgxtDynamic.setGaOwnerDept3(psTrans.getGaOwnerDept3());
            rsJbjJgxtDynamic.setGaOwnerDept4(psTrans.getGaOwnerDept4());
            rsJbjJgxtDynamic.setGaOwnerDept5(psTrans.getGaOwnerDept5());
            int num1 = rsJbjJgxtDynamicService.rsJbjJgxtDynamicSave(rsJbjJgxtDynamic,map);
        }
        return psTrans.getId();
    }

    public  String generateJjdbh(String orgCode){
        return "YBJ"+orgCode + new Date().getTime();
    }

    public int psTransUpdate(PsTrans psTrans, Map<String,String> map){
        int num = psTransMapper.updateByPrimaryKeySelective(psTrans);
        return num;
    }

    @Override
    public int psTransUpt(PsTrans psTrans, Map<String, String> map) {
        psTransUpdate(psTrans,map);
        //更新RsJbjJgxtDynamic
        RsJbjJgxtDynamic rsJbjJgxtDynamic = new RsJbjJgxtDynamic();
        rsJbjJgxtDynamic.setSfdd(psTrans.getOccAddr());
        rsJbjJgxtDynamic.setAfsj(psTrans.getOccTime());
        rsJbjJgxtDynamic.setBjnr(psTrans.getOccDescr());
        Example example = new Example(RsJbjJgxtDynamic.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("yjjbm",psTrans.getId());
        int num = rsJbjJgxtDynamicMapper.updateByExampleSelective(rsJbjJgxtDynamic,example);
        return num;
    }

    public PsTrans getPsTrans(String id){
        return psTransMapper.selectByPrimaryKey(id);
    }

    public int psTransDelete(String id){
        int num = psTransMapper.deleteByPrimaryKey(id);
        return num;
    }

    public List<PsTrans> getDynamicData(Map<String, String> map) {
        int start = Integer.parseInt(map.get("start"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        RowBounds rowBounds = new RowBounds(start,pageSize);
        Example example = new Example(PsTrans.class);
        example.setOrderByClause("REP_TIME desc");
        Example.Criteria criteria = example.createCriteria();
        this.setCondition(criteria,map);

        return psTransMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getDynamicCount(Map<String, String> map) {
        Example example = new Example(PsTrans.class);
        Example.Criteria criteria = example.createCriteria();
        this.setCondition(criteria,map);

        return psTransMapper.selectCountByExample(example);
    }

    public void setCondition(Example.Criteria criteria, Map<String, String> map){
        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
        String status = map.get("status");
        String reporterSource = map.get("reporterSource");
        String jjsjStart = map.get("jjsjStart");
        String jjsjEnd = map.get("jjsjEnd");
        String ybabh = map.get("ybabh");
        String jqly = map.get("jqly");
        String ybjStatus = map.get("ybjStatus");
        String ly = map.get("ly");
        String jjdbh = map.get("jjdbh");

        //The query conditions are edited here
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("ownOrg2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("ownOrg3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("ownOrg4",deptId);
        }
//        if (StringUtils.hasText(status)){
//            criteria.andEqualTo("status",status);
//        }
        if (StringUtils.hasText(ybabh)){
            criteria.andLike("code","%"+ybabh.trim()+"%");
        }
        if (StringUtils.hasText(jjdbh)){
            criteria.andLike("jjdbh","%"+jjdbh.trim()+"%");
        }
        if (StringUtils.hasText(reporterSource)){
            criteria.andEqualTo("reporterSource",reporterSource);
        }
        if (StringUtils.hasText(jqly)){
            criteria.andEqualTo("dataType",jqly);
        }
        if (StringUtils.hasText(ybjStatus)){
            criteria.andEqualTo("status",ybjStatus);
        }
//        if(StringUtils.hasText(jjsjStart)&& StringUtils.hasText(jjsjStart)){
//            criteria.andCondition("JJSJ BETWEEN to_date('"+jjsjStart+"', 'yyyy-mm-dd') and  to_date('"+jjsjEnd+"', 'yyyy-mm-dd')");
//        }

        criteria.andEqualTo("ly",ly);
    }

}
