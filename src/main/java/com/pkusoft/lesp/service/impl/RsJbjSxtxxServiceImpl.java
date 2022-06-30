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

//        Map<String,String> retData = sysPermitService.setUserDataPermits(map, PermitType.PERMIT_TYPE_BABS_QUERY);
        String deptLevel = map.get("level");
        String deptId = map.get("deptId");
        if (StringUtils.hasText(deptLevel)&& StringUtils.hasText(deptId)){
            return rsJbjSxtxxMapper.getDeptList(deptLevel,deptId,map.get("deptId"));
        }
        return new ArrayList<RsJbjSxtxx>();
    }

    public List<Map<String,Object>> getCameraList(String deptId, String isBabs) {
        List<Map<String,Object>> videoList = new ArrayList<>();

        String[] deptArr = deptId.split(",");
        for (String dept:deptArr){
            Map<String,Object> video = new HashMap<>();
            Example example = new Example(RsJbjSxtxx.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orgCode",dept);
            criteria.andEqualTo("isBabs", isBabs);
            List<Map<String,String>> dataList = new ArrayList<>();
            example.orderBy("orgCode");
            List<RsJbjSxtxx> rsJbjSxtxxList = rsJbjSxtxxMapper.selectByExample(example);
            for (RsJbjSxtxx sxtxx:rsJbjSxtxxList){
                Map<String,String> sxt = new HashMap<>();
                sxt.put("objid",sxtxx.getObjid());
                sxt.put("name",sxtxx.getObjname());
                sxt.put("url",sxtxx.getRtmp());             //3.0流媒体播放地址 4.0流媒体接口地址
                sxt.put("deviceId",sxtxx.getDeviceId());    //设备号通道号等流媒体配置信息
                sxt.put("serviceIp",sxtxx.getServiceIp());  //流媒体服务器IP
                sxt.put("secret",sxtxx.getSecret());        //秘钥
                sxt.put("isRtsp",sxtxx.getIsRtsp());        // 是否新国标
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
