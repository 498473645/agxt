package com.pkusoft.jjpt.service.impl;

import java.util.*;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpFkxxReqParam;
import com.pkusoft.jjpt.res.Jcjxx;
import com.pkusoft.jjpt.service.SpCjrxxService;
import com.pkusoft.jjpt.service.SpJjxxService;
import com.pkusoft.jjpt.service.ZzjbjBjxxService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.service.SpFkxxService;
import com.pkusoft.jjpt.mapper.SpFkxxMapper;

@Service
@Transactional
public class SpFkxxServiceImpl implements SpFkxxService {

    @Autowired
    private SpFkxxMapper spFkxxMapper;

    @Autowired
    private SpJjxxService spJjxxService;

    @Autowired
    private SpCjrxxService spCjrxxService;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;


    public List<SpFkxx> getSpFkxxList(SpFkxxReqParam spFkxx, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(spFkxx.getStart(),spFkxx.getPageSize());
        Example example = new Example(SpFkxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spFkxx);

        return spFkxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSpFkxxCount(SpFkxxReqParam spFkxx, Map<String, String> map) {

        Example example = new Example(SpFkxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,spFkxx);

        return spFkxxMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, SpFkxxReqParam spFkxx){
        if (StringUtils.hasText(spFkxx.getOrgCode())){
            criteria.andEqualTo("orgCode",spFkxx.getOrgCode());
        }
    }

    public int spFkxxSave(SpFkxx spFkxx, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spFkxx.setObjid(objid);
        Date date = new Date();
        spFkxx.setCreateName(map.get("userName"));
        spFkxx.setCreateId(map.get("userId"));
        spFkxx.setCreateTime(date);
        spFkxx.setModerName(map.get("userName"));
        spFkxx.setModerId(map.get("userId"));
        spFkxx.setModerTime(date);
        spFkxx.setOrgCode(map.get("deptId"));
        spFkxx.setOrgName(map.get("deptName"));
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        //获取归属单位
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                spFkxx.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                spFkxx.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                spFkxx.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                spFkxx.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                spFkxx.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = spFkxxMapper.insertSelective(spFkxx);
        return num;
    }

    public int spFkxxSave(SpFkxx spFkxx){
        int num = spFkxxMapper.insertSelective(spFkxx);
        return num;
    }

    public int spFkxxUpdate(SpFkxx spFkxx, Map<String,String> map){
        Date date = new Date();
        spFkxx.setModerName(map.get("userName"));
        spFkxx.setModerId(map.get("userId"));
        spFkxx.setModerTime(date);
        int num = spFkxxMapper.updateByPrimaryKeySelective(spFkxx);
        return num;
    }

    public SpFkxx getSpFkxx(String objid){
        if(StringUtils.hasText(objid)){
            return spFkxxMapper.selectByPrimaryKey(objid);
        }
        return null;
    }

    public int spFkxxDelete(String objid){
        int num = 0;
        num = spFkxxMapper.deleteByPrimaryKey(objid);
        return num;
    }

	@Override
	public String postfeedBack(SpFkxx spFkxx, Map<String,String> map) {
        //更改处警单状态
        if(spFkxx!=null){
            spFkxx.setFkrxm(map.get("userName"));
            spFkxx.setFkrgh(map.get("userId"));
            spFkxx.setStatus("1004");
            spFkxx.setFksj(new Date());
            int num = spFkxxUpdate(spFkxx,map);
            //更新成功后更新处警人信息及接警单状态
            if (num>0){
                //修改处警人的状态
                spCjrxxService.uptSpCjrxxStatus(spFkxx,map);
                //反馈时更改接警单状态
                SpJjxx jjxx = new SpJjxx();
                jjxx.setObjid(spFkxx.getJjdObjid());
                jjxx.setStatus("1004");
                jjxx.setFksj(spFkxx.getFksj());
                spJjxxService.spJjxxUpdate(jjxx,map);
            }
            return "反馈成功!";
        }else {
            return "根据处警单id未查询到处警信息!";
        }
	}

	@Override
    public Jcjxx getJjCjxx(String jjdObjid) {
        Jcjxx jcjxx = new Jcjxx();
        //根据处警信息所属接警id查询接警信息
        SpJjxx spJjxx = spJjxxService.getSpJjxx(jjdObjid);
        //根据处警id查询处警信息
        SpFkxx spFkxx = getSpFkxx(spJjxx.getCjdObjid());
        BeanUtils.copyProperties(spJjxx,jcjxx);
        jcjxx.setJjdObjid(spJjxx.getObjid());
        if(spFkxx!=null && StringUtils.hasText(spFkxx.getObjid())){
            jcjxx.setCjdObjid(spFkxx.getObjid());
            jcjxx.setCjjg(spFkxx.getCjjg());
            jcjxx.setDcsj(spFkxx.getDcsj());
            jcjxx.setFksj(spFkxx.getFksj());
        }
        return jcjxx;
    }

}
