package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.PiFaceMatchMapper;
import com.pkusoft.jjpt.po.PiFaceMatch;
import com.pkusoft.jjpt.service.PiFaceMatchService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
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
public class PiFaceMatchServiceImpl implements PiFaceMatchService {

    @Autowired
    private PiFaceMatchMapper piFaceMatchMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

    public List<PiFaceMatch> getPiFaceMatchList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(PiFaceMatch.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return piFaceMatchMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<PiFaceMatch> getPiFaceMatchList(Map<String, String> map, int limit) {

        RowBounds rowBounds = new RowBounds(0,limit);
        Example example = new Example(PiFaceMatch.class);
        example.setOrderByClause("add_time desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("orgCode",map.get("deptId"));

        return piFaceMatchMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getPiFaceMatchCount(Map<String, String> map) {

        Example example = new Example(PiFaceMatch.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return piFaceMatchMapper.selectCountByExample(example);
    }

    public int piFaceMatchSave(PiFaceMatch piFaceMatch, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        piFaceMatch.setObjid(objid);
        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(map.get("deptId"));
        Date date = new Date();
        piFaceMatch.setCreateName(map.get("userName"));
        piFaceMatch.setCreateId(map.get("userId"));
        piFaceMatch.setCreateTime(date);
        piFaceMatch.setModerName(map.get("userName"));
        piFaceMatch.setModerId(map.get("userId"));
        piFaceMatch.setModerTime(date);
        piFaceMatch.setOrgCode(map.get("deptId"));
        piFaceMatch.setOrgName(map.get("deptName"));
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                piFaceMatch.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                piFaceMatch.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                piFaceMatch.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                piFaceMatch.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                piFaceMatch.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }
        int num = piFaceMatchMapper.insertSelective(piFaceMatch);
        return num;
    }

    public int piFaceMatchUpdate(PiFaceMatch piFaceMatch, Map<String,String> map){
        int num = piFaceMatchMapper.updateByPrimaryKeySelective(piFaceMatch);
        return num;
    }

    public PiFaceMatch getPiFaceMatch(String objid){
        return piFaceMatchMapper.selectByPrimaryKey(objid);
    }

    public int piFaceMatchDelete(String[] objid){
        int num = 0;
        for(int i = 0; i < objid.length; i ++){
        num = piFaceMatchMapper.deleteByPrimaryKey(objid[i]);
        }
        return num;
    }

}
