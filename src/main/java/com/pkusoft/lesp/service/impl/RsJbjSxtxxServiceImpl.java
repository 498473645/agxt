package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjSxtxxMapper;
import com.pkusoft.lesp.po.RsJbjSxtxx;
import com.pkusoft.lesp.service.RsJbjSxtxxService;
import com.pkusoft.lesp.until.PermitType;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class RsJbjSxtxxServiceImpl implements RsJbjSxtxxService {

    @Autowired
    private RsJbjSxtxxMapper rsJbjSxtxxMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<RsJbjSxtxx> getDeptList( Map<String, String> map) {

//        Example example = new Example(RsJbjSxtxx.class);
//        Example.Criteria criteria = example.createCriteria();
//        sysPermitService.setUserDataPermits(criteria, map, PermitType.PERMIT_TYPE_CASE_QUERY);
//        return rsJbjSxtxxMapper.selectByExample(example);
        Map<String,String> retData = sysPermitService.setUserDataPermits(map, PermitType.PERMIT_TYPE_CASE_QUERY);
        String deptLevel = retData.get("level");
        String deptId = retData.get("deptId");
        if (StringUtils.hasText(deptLevel)&& StringUtils.hasText(deptId)){
            return rsJbjSxtxxMapper.getDeptList(deptLevel,deptId,map.get("deptId"));
        }
        return new ArrayList<RsJbjSxtxx>();
    }

    public List<Map<String,Object>> getCameraList(String deptId) {
        List<Map<String,Object>> videoList = new ArrayList<>();

        String[] deptArr = deptId.split(",");
        for (String dept:deptArr){
            Map<String,Object> video = new HashMap<>();
            Example example = new Example(RsJbjSxtxx.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orgCode",dept);
            List<Map<String,String>> dataList = new ArrayList<>();
            example.orderBy("orgCode");
            List<RsJbjSxtxx> rsJbjSxtxxList = rsJbjSxtxxMapper.selectByExample(example);
            for (RsJbjSxtxx sxtxx:rsJbjSxtxxList){
                Map<String,String> sxt = new HashMap<>();
                sxt.put("objid",sxtxx.getObjid());
                sxt.put("name",sxtxx.getObjname());
                sxt.put("url",sxtxx.getRtmp());
                dataList.add(sxt);
            }
            video.put("id",dept);
            video.put("name",rsJbjSxtxxList.get(0).getOrgName());
            video.put("dataList",dataList);
            videoList.add(video);
        }
        return videoList;
    }

    public List<RsJbjSxtxx> getRsJbjSxtxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjSxtxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjSxtxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjSxtxxCount(Map<String, String> map) {

        Example example = new Example(RsJbjSxtxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjSxtxxMapper.selectCountByExample(example);
    }

    public int rsJbjSxtxxSave(RsJbjSxtxx rsJbjSxtxx, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        rsJbjSxtxx.setObjid(objid);
        int num = rsJbjSxtxxMapper.insertSelective(rsJbjSxtxx);
        return num;
    }

    public int rsJbjSxtxxUpdate(RsJbjSxtxx rsJbjSxtxx, Map<String,String> map){
        int num = rsJbjSxtxxMapper.updateByPrimaryKeySelective(rsJbjSxtxx);
        return num;
    }

    public RsJbjSxtxx getRsJbjSxtxx(String objid){
        return rsJbjSxtxxMapper.selectByPrimaryKey(objid);
    }

    public int rsJbjSxtxxDelete(String[] objid){
        int num = 0;
        for(int i = 0; i < objid.length; i ++){
        num = rsJbjSxtxxMapper.deleteByPrimaryKey(objid[i]);
        }
        return num;
    }

}