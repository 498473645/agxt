package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.lesppc.mapper.PcYjwtMapper;
import com.pkusoft.lesppc.mapper.StasticMapper;
import com.pkusoft.lesppc.model.PcYjwt;
import com.pkusoft.lesppc.service.PcYjwtService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PcYjwtServiceImpl implements PcYjwtService {

    @Autowired
    private PcYjwtMapper pcYjwtMapper;

    @Autowired
    private StasticMapper stasticMapper;


    /**
     * 统计涉案财物产生的预警数
     *
     * @return
     */
    @Override
    public int getSaCwYjCount() {
        return pcYjwtMapper.getSaCwYjCount();
    }

    /**
     * 涉案财物--按预警类型统计该类模型产生的问题数
     *
     * @return
     */
    @Override
    public List<YjWtVo> getYjCountByMxType() {
        return pcYjwtMapper.getYjCountByMxType();
    }

    /**
     * 查询最新预警问题列表
     *
     * @param map
     * @return
     */
    @Override
    public List<WtLbVo> getYjList(Map<String, String> map) {
        return pcYjwtMapper.getYjList(map);
    }


    @Override
    public List<PcYjwt> getWechatUnclosedData(String deptId, String deptLevel) {
        RowBounds rowBounds = new RowBounds(0,10);
        Example example = new Example(PcYjwt.class);
        example.setOrderByClause("CREATED_DATE desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh","LESP_PMS0403");
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }

        return pcYjwtMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public Map<String,Object> getWtmxCount(String deptId, String deptLevel) {
        Map<String,Object> data = new HashMap<>();
        StatisticsData sd = stasticMapper.getWtmxCount(deptId,deptLevel);
        data.put("countData",sd);
        return data;
    }

    @Override
    public int getYjwtCountByWtmx(PcWtmx pcWtmx) {
        Example example = new Example(PcYjwt.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh",pcWtmx.getWtmxBh());
        return pcYjwtMapper.selectCountByExample(example);
    }

    @Override
    public List<PcYjwt> getYjxxListData(String deptId, String deptLevel, String wtmxBh) {
        RowBounds rowBounds = new RowBounds(0,10);
        Example example = new Example(PcYjwt.class);
        example.setOrderByClause("CREATED_DATE desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh",wtmxBh);
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }

        return pcYjwtMapper.selectByExampleAndRowBounds(example,rowBounds);
    }
}
