package com.pkusoft.ygjw.service.impl;

import com.pkusoft.jjpt.service.HadoopService;
import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.ygjw.mapper.PsTempMapper;
import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.req.PsTempReqParam;
import com.pkusoft.ygjw.service.PsTempService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PsTempServiceImpl implements PsTempService {

    @Autowired
    private PsTempMapper psTempMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private HadoopService hadoopService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<PsTemp> getPsTempList(PsTempReqParam psTempReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psTempReqParam.getStart(),psTempReqParam.getPageSize());
        Example example = new Example(PsTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTempReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psTempReqParam.getStart() && 0 == psTempReqParam.getPageSize()){
            return psTempMapper.selectByExample(example);
        }
        return psTempMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsTempCount(PsTempReqParam psTempReqParam,Map<String, String> map) {

        Example example = new Example(PsTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psTempReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psTempMapper.selectCountByExample(example);
    }
    public void setCommonCondition(Example.Criteria criteria, PsTempReqParam psTempReqParam, Map<String, String> map){
        if(StringUtils.isNotBlank(psTempReqParam.getCode())){
            criteria.andEqualTo("code",psTempReqParam.getCode());
        }
        if(StringUtils.isNotBlank(psTempReqParam.getName())){
            criteria.andLike("name",psTempReqParam.getName()+"%");
        }

    }

    public int psTempSave(PsTemp psTemp, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        psTemp.setId(id);
        psTemp.setStatus("2010");
        Date date = new Date();
        psTemp.setCreateTime(date);
        psTemp.setModerTime(date);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        if (sysDataOwnerDept != null) {
            psTemp.setOrgCode(map.get("deptId"));
            psTemp.setOrgName(map.get("deptName"));
            psTemp.setOwnOrg1(sysDataOwnerDept.getOwnerDept1());
            psTemp.setOwnOrg2(sysDataOwnerDept.getOwnerDept2());
            psTemp.setOwnOrg3(sysDataOwnerDept.getOwnerDept3());
            psTemp.setOwnOrg4(sysDataOwnerDept.getOwnerDept4());
            psTemp.setOwnOrg5(sysDataOwnerDept.getOwnerDept5());
        }
        int num = psTempMapper.insertSelective(psTemp);
        return num;
    }

    public int psTempUpdate(PsTemp psTemp, Map<String,String> map){
        int num = psTempMapper.updateByPrimaryKeySelective(psTemp);
        return num;
    }

    public PsTemp getPsTemp(String id){
        return psTempMapper.selectByPrimaryKey(id);
    }

    public int psTempDelete(String id){
        int num = psTempMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public String savePsTempFile(String contentBase) {
        String ret = hadoopService.hadoopFileUpload(contentBase);
        return ret;
    }

    @Override
    public Map<String,Object> getModelNm() {
        Map<String, Object> result = new HashMap<>();
        Example example = new Example(PsTemp.class);
        example.setOrderByClause("SN DESC");
        List<PsTemp> psTemps = psTempMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(psTemps)){
            //result.put("maxCode","CL00001");
            result.put("maxSn",1);
        }else{
            result.put("maxSn",psTemps.get(0).getSn()+1);
            //List<Integer> codeList = psTemps.stream().map(e ->Integer.valueOf(e.getCode().replace("CL", ""))).collect(Collectors.toList());
            //result.put("maxCode",getMaxCode(Collections.max(codeList)+1));
        }
        return result;
    }

    private String getMaxCode(Integer code){
        Integer s = String.valueOf(code).length();
        String prefix = "CL";
        for (int i = s ; i < 5;i++){
            prefix +="0";
        }
        return prefix+code;
    }

}