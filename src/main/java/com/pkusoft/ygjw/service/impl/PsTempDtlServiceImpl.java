package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.ygjw.mapper.PsTempDtlMapper;
import com.pkusoft.ygjw.mapper.PsTempMapper;
import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.model.PsTempDtl;
import com.pkusoft.ygjw.req.PsTempDtlReqParam;
import com.pkusoft.ygjw.service.PsTempDtlService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class PsTempDtlServiceImpl implements PsTempDtlService {

    @Autowired
    private PsTempDtlMapper psTempDtlMapper;

    @Autowired
    private PsTempMapper psTempMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${HzywIp}")
    private String hzywIp;

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
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            if (org.springframework.util.StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                psTempDtl.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (org.springframework.util.StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                psTempDtl.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (org.springframework.util.StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                psTempDtl.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (org.springframework.util.StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                psTempDtl.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (org.springframework.util.StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                psTempDtl.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
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

    @Override
    public ResponseData<Map<String, Object>> getMaterialsGroupList(String sxbh, String ssxq) {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("bizCode", sxbh);
        requestBody.put("area", ssxq);
        try {
            ResponseData<Map<String, Object>> response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/dfmBizTemplate/getMaterialsGroupList",requestBody, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取材料数据异常；" + e.getMessage());
        }
    }

}
