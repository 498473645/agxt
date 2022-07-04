package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjJgxtDynamicMapper;
import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import com.pkusoft.lesp.service.RsJbjJgxtDynamicService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.PermitType;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class RsJbjJgxtDynamicServiceImpl implements RsJbjJgxtDynamicService {

    @Autowired
    private RsJbjJgxtDynamicMapper rsJbjJgxtDynamicMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<RsJbjJgxtDynamic> getDynamicData(Map<String, String> map, Map<String, String> userInfo) {
        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
        String jjsjStart = map.get("jjsjStart");
        String jjsjEnd = map.get("jjsjEnd");
        String ybabh = map.get("ybabh");
        int start = Integer.parseInt(map.get("start"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        RowBounds rowBounds = new RowBounds(start,pageSize);
        Example example = new Example(RsJbjJgxtDynamic.class);
        example.setOrderByClause("JJSJ desc");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
//        if ("2".equals(deptLevel)){
//            criteria.andEqualTo("gaOwnerDept2",deptId);
//        }else if ("3".equals(deptLevel)){
//            criteria.andEqualTo("gaOwnerDept3",deptId);
//        }else if ("4".equals(deptLevel)){
//            criteria.andEqualTo("gaOwnerDept4",deptId);
//        }
        if (StringUtils.hasText(deptId)){
            criteria.andEqualTo("jjdw",deptId);
        }
        if (StringUtils.hasText(map.get("yjjbm"))){
            criteria.andEqualTo("yjjbm",map.get("yjjbm"));
        }
        if (StringUtils.hasText(map.get("jqly"))){
            criteria.andEqualTo("jqly",map.get("jqly"));
        }
        if (StringUtils.hasText(ybabh)){
            criteria.andLike("jjbh","%"+ybabh.trim()+"%");
        }
        if(StringUtils.hasText(jjsjStart)&& StringUtils.hasText(jjsjStart)){
            criteria.andCondition("jjsj BETWEEN to_date('"+jjsjStart+"', 'yyyy-mm-dd') and  to_date('"+jjsjEnd+"', 'yyyy-mm-dd')");
        }
        sysPermitService.setUserDataPermitsBabs(criteria,userInfo, PermitType.PERMITTYPE_100002);
        return rsJbjJgxtDynamicMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getDynamicCount(Map<String, String> map, Map<String, String> userInfo) {
//        Example example = new Example(RsJbjJgxtDynamic.class);
//        Example.Criteria criteria = example.createCriteria();

        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
        String status = map.get("status");
        String reporterSource = map.get("reporterSource");
        String jjsjStart = map.get("jjsjStart");
        String jjsjEnd = map.get("jjsjEnd");
        String ybabh = map.get("ybabh");
        if(StringUtils.hasText(ybabh)){
            ybabh = "%"+ybabh.trim()+"%";
        }
        String jqly = map.get("jqly");
        String ybjStatus = map.get("ybjStatus");
        return rsJbjJgxtDynamicMapper.getDynamicCount(deptId,deptLevel,status,reporterSource,ybabh,jqly,jjsjStart,jjsjEnd,ybjStatus);
    }

    public List<RsJbjJgxtDynamic> getRsJbjJgxtDynamicList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjJgxtDynamic.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjJgxtDynamicMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjJgxtDynamicCount(Map<String, String> map) {

        Example example = new Example(RsJbjJgxtDynamic.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjJgxtDynamicMapper.selectCountByExample(example);
    }

    public int rsJbjJgxtDynamicSave(RsJbjJgxtDynamic rsJbjJgxtDynamic, Map<String,String> map){
        String bjrxm = UUID.randomUUID().toString();
        rsJbjJgxtDynamic.setBjrxm(bjrxm);
        int num = rsJbjJgxtDynamicMapper.insertSelective(rsJbjJgxtDynamic);
        return num;
    }

    public int rsJbjJgxtDynamicUpdate(RsJbjJgxtDynamic rsJbjJgxtDynamic, Map<String,String> map){
        int num = rsJbjJgxtDynamicMapper.updateByPrimaryKeySelective(rsJbjJgxtDynamic);
        return num;
    }

    public RsJbjJgxtDynamic getRsJbjJgxtDynamic(String bjrxm){
        return rsJbjJgxtDynamicMapper.selectByPrimaryKey(bjrxm);
    }

    public int rsJbjJgxtDynamicDelete(String[] bjrxm){
        int num = 0;
        for(int i = 0; i < bjrxm.length; i ++){
        num = rsJbjJgxtDynamicMapper.deleteByPrimaryKey(bjrxm[i]);
        }
        return num;
    }

}
