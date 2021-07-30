package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjYbjxxMapper;
import com.pkusoft.lesp.mapper.StatisticsMapper;
import com.pkusoft.lesp.po.RsJbjYbjxx;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class RsJbjYbjxxServiceImpl implements RsJbjYbjxxService {

    @Autowired
    private RsJbjYbjxxMapper rsJbjYbjxxMapper;

    @Autowired
    private StatisticsMapper statisticsMapper;

    public List<RsJbjYbjxx> getTelephoneData(String deptId,String deptLevel,String jqly) {
        RowBounds rowBounds = new RowBounds(0,10);
        Example example = new Example(RsJbjYbjxx.class);
        example.setOrderByClause("BJSJ desc");
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("jqly",jqly);
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }
        return rsJbjYbjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public StatisticsData getMonthlyYbjData(String deptId,String year,String month) {
        return statisticsMapper.getMonthlyYbjData(deptId, year, month);
    }

    public StatisticsData getMonthlyYbjflData(String deptId,String year,String month) {
        return statisticsMapper.getMonthlyYbjflData(deptId, year, month);
    }

    public List<RsJbjYbjxx> getRsJbjYbjxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjYbjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjYbjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjYbjxxCount(Map<String, String> map) {

        Example example = new Example(RsJbjYbjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjYbjxxMapper.selectCountByExample(example);
    }

    public int rsJbjYbjxxSave(RsJbjYbjxx rsJbjYbjxx, Map<String,String> map){
        String bjid = UUID.randomUUID().toString();
        rsJbjYbjxx.setBjid(bjid);
//        rsJbjYbjxx.setModifyUserName(map.get("userName"));
//        rsJbjYbjxx.setModifyUserId(map.get("userId"));
//        rsJbjYbjxx.setModifyTime(new Date());
        int num = rsJbjYbjxxMapper.insertSelective(rsJbjYbjxx);
        return num;
    }

    public int rsJbjYbjxxUpdate(RsJbjYbjxx rsJbjYbjxx, Map<String,String> map){
//        rsJbjYbjxx.setModifyUserName(map.get("userName"));
//        rsJbjYbjxx.setModifyUserId(map.get("userId"));
//        rsJbjYbjxx.setModifyTime(new Date());
        int num = rsJbjYbjxxMapper.updateByPrimaryKeySelective(rsJbjYbjxx);
        return num;
    }

    public RsJbjYbjxx getRsJbjYbjxx(String bjid){
        return rsJbjYbjxxMapper.selectByPrimaryKey(bjid);
    }

    public int rsJbjYbjxxDelete(String[] bjid){
        int num = 0;
        for(int i = 0; i < bjid.length; i ++){
        num = rsJbjYbjxxMapper.deleteByPrimaryKey(bjid[i]);
        }
        return num;
    }

}
