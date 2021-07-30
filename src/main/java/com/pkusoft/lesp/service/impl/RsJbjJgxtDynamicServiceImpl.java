package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjJgxtDynamicMapper;
import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import com.pkusoft.lesp.service.RsJbjJgxtDynamicService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class RsJbjJgxtDynamicServiceImpl implements RsJbjJgxtDynamicService {

    @Autowired
    private RsJbjJgxtDynamicMapper rsJbjJgxtDynamicMapper;

    public List<RsJbjJgxtDynamic> getDynamicData(Map<String, String> map) {
        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
        String status = map.get("status");
        String reporterSource = map.get("reporterSource");
        String jjsjStart = map.get("jjsjStart");
        String jjsjEnd = map.get("jjsjEnd");
        int start = Integer.parseInt(map.get("start"));
        int pageSize = Integer.parseInt(map.get("pageSize"));

        RowBounds rowBounds = new RowBounds(start,pageSize);
        Example example = new Example(RsJbjJgxtDynamic.class);
        example.setOrderByClause("JJSJ desc,BJSJ desc");
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }
        if (StringUtils.hasText(status)){
            criteria.andEqualTo("status",status);
        }
        if (StringUtils.hasText(reporterSource)){
            criteria.andEqualTo("reporterSource",reporterSource);
        }
        if(StringUtils.hasText(jjsjStart)&& StringUtils.hasText(jjsjStart)){
            criteria.andCondition("JJSJ BETWEEN to_date('"+jjsjStart+"', 'yyyy-mm-dd') and  to_date('"+jjsjEnd+"', 'yyyy-mm-dd')");
        }

        return rsJbjJgxtDynamicMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getDynamicCount(Map<String, String> map) {
//        Example example = new Example(RsJbjJgxtDynamic.class);
//        Example.Criteria criteria = example.createCriteria();

        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
        String status = map.get("status");
        String reporterSource = map.get("reporterSource");
        String jjsjStart = map.get("jjsjStart");
        String jjsjEnd = map.get("jjsjEnd");

        //The query conditions are edited here
//        String deptCon = "";
//        if ("2".equals(deptLevel)){
////            criteria.andEqualTo("gaOwnerDept2",deptId);
//            deptCon = "t.GA_OWNER_DEPT_2 = '"+deptId+"'";
//        }else if ("3".equals(deptLevel)){
////            criteria.andEqualTo("gaOwnerDept3",deptId);
//            deptCon = "t.GA_OWNER_DEPT_3 = '"+deptId+"'";
//        }else if ("4".equals(deptLevel)){
////            criteria.andEqualTo("gaOwnerDept4",deptId);
//            deptCon = "t.GA_OWNER_DEPT_4 = '"+deptId+"'";
//        }
//        String statusStr = "";
//        if (StringUtils.hasText(status)){
////            criteria.andEqualTo("status",status);
//            statusStr = "t.STATUS = '"+status+"'";
//        }
//        String jqlyStr = "";
//        if (StringUtils.hasText(jqly)){
////            criteria.andEqualTo("jqly",jqly);
//            statusStr = "t.JQLY = '"+jqly+"'";
//        }
//        String jjsjStr = "";
//        if(StringUtils.hasText(jjsjStart)&&StringUtils.hasText(jjsjEnd)){
////            criteria.andCondition("JJSJ BETWEEN to_char('"+jjsjStart+"', 'yyyy-mm-dd') and  to_char('"+jjsjStart+"', 'yyyy-mm-dd')");
//            jjsjStr = "to_char('"+jjsjStart+"', 'yyyy-mm-dd') and  to_char('"+jjsjStart+"', 'yyyy-mm-dd')";
//        }

//        jjsjStart = "to_date('"+jjsjStart+"', 'yyyy-mm-dd')";
//        jjsjEnd = "to_date('"+jjsjEnd+"', 'yyyy-mm-dd')";

        return rsJbjJgxtDynamicMapper.getDynamicCount(deptId,deptLevel,status,reporterSource,jjsjStart,jjsjEnd);
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