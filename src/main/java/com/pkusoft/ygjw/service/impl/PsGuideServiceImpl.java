package com.pkusoft.ygjw.service.impl;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.service.BdEquipmentService;
import com.pkusoft.ygjw.mapper.PsGuideMapper;
import com.pkusoft.ygjw.model.PsGuide;
import com.pkusoft.ygjw.model.XtBizGuide;
import com.pkusoft.ygjw.req.GuideParamVo;
import com.pkusoft.ygjw.req.PsGuideReqParam;
import com.pkusoft.ygjw.service.PsGuideService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.StringUtil;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class PsGuideServiceImpl implements PsGuideService {

    @Autowired
    private PsGuideMapper psGuideMapper;

    @Autowired
    private BdEquipmentService bdEquipmentService;

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${HzywIp}")
    private String hzywIp;

    public List<PsGuide> getPsGuideList(PsGuideReqParam psGuideReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(psGuideReqParam.getStart(),psGuideReqParam.getPageSize());
        Example example = new Example(PsGuide.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psGuideReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        if(0 == psGuideReqParam.getPageSize()){
            return psGuideMapper.selectByExample(example);
        }
        return psGuideMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPsGuideCount(PsGuideReqParam psGuideReqParam, Map<String, String> map) {

        Example example = new Example(PsGuide.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,psGuideReqParam,map);
        example.setOrderByClause("CREATE_TIME DESC");
        return psGuideMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, PsGuideReqParam psGuideReqParam, Map<String, String> map){
        if(StringUtils.isNotBlank(psGuideReqParam.getType())){
            criteria.andEqualTo("type",psGuideReqParam.getType());
        }

    }

    public int psGuideSave(PsGuide psGuide, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        psGuide.setId(id);
        psGuide.setStatus("2010");
        Date date = new Date();
        psGuide.setCreateTime(date);
        psGuide.setModerTime(date);
        //根据设备唯一标识码获取设备信息
        BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(psGuide.getCreateId());//字段接口调用将eid放在CreateId中
        if (bdEquipment != null) {
            psGuide.setOrgCode(bdEquipment.getOrgCode());
            psGuide.setOrgName(bdEquipment.getOrgName());
            psGuide.setGaOwnerDept1(bdEquipment.getGaOwnerDept1());
            psGuide.setGaOwnerDept2(bdEquipment.getGaOwnerDept2());
            psGuide.setGaOwnerDept3(bdEquipment.getGaOwnerDept3());
            psGuide.setGaOwnerDept4(bdEquipment.getGaOwnerDept4());
            psGuide.setGaOwnerDept5(bdEquipment.getGaOwnerDept5());
        }
        int num = psGuideMapper.insertSelective(psGuide);
        return num;
    }

    public int psGuideUpdate(PsGuide psGuide, Map<String,String> map){
        int num = psGuideMapper.updateByPrimaryKeySelective(psGuide);
        return num;
    }

    public PsGuide getPsGuide(String id){
        return psGuideMapper.selectByPrimaryKey(id);
    }

    public int psGuideDelete(String id){
        int num = psGuideMapper.deleteByPrimaryKey(id);
        return num;
    }

    public PsGuide getPsGuidByType(PsGuide psGuide){
        return psGuideMapper.selectOne(psGuide);
    }

    @Override
    public ResponseData<XtBizGuide> getXtBizTypeByBizCode(String sxbh, String ssxq) {
        GuideParamVo guideParamVo = new GuideParamVo();
        guideParamVo.setSxbh(sxbh);
        guideParamVo.setSsxqdm(ssxq);
        try {
            ResponseData<XtBizGuide> response = restTemplate.postForObject(hzywIp + "/hzywYbsxxb/getXtBizTypeByBizCode",guideParamVo, ResponseData.class);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取办事过程数据异常；" + e.getMessage());
        }
    }


}
