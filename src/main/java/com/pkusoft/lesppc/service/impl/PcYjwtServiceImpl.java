package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.lesppc.mapper.PcYjwtMapper;
import com.pkusoft.lesppc.mapper.StasticMapper;
import com.pkusoft.lesppc.model.PcYjwt;
import com.pkusoft.lesppc.service.PcYjwtService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.PermitType;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
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

    @Autowired
    private SysPermitService sysPermitService;


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
    public List<PcYjwt> getYjxxListData(Map<String,String> map) {
        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");
        String wtmxBh = map.get("wtmxBh");
        String start = map.get("start");
        String pageSize = map.get("pageSize");
        String wtwd3 = map.get("ybabh");

        RowBounds rowBounds = new RowBounds(Integer.parseInt(start),Integer.parseInt(pageSize));
        Example example = new Example(PcYjwt.class);
        example.setOrderByClause("CREATED_DATE desc");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh",wtmxBh);
        criteria.andEqualTo("wtzt","1");
        if (StringUtils.hasText(wtwd3)){
            criteria.andLike("wtwd3","%"+wtwd3.trim()+"%");
        }
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
    public int getYjxxListCount(Map<String,String> map) {
        String deptId = map.get("deptId");
        String deptLevel = map.get("deptLevel");
        String wtmxBh = map.get("wtmxBh");
        String wtwd1 = map.get("ybabh");

        Example example = new Example(PcYjwt.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh",wtmxBh);
        criteria.andEqualTo("wtzt","1");
        if (StringUtils.hasText(wtwd1)){
            criteria.andLike("wtwd1","%"+wtwd1.trim()+"%");
        }
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }

        return pcYjwtMapper.selectCountByExample(example);
    }

    @Override
    public int getYjxxListCount(String deptId, String deptLevel,String wtwd1, String wtmxBh) {
        Example example = new Example(PcYjwt.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtmxBh",wtmxBh);
        criteria.andEqualTo("wtzt","1");
        if (StringUtils.hasText(wtwd1)){
            criteria.andLike("wtwd1","%"+wtwd1.trim()+"%");
        }
        if ("2".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept2",deptId);
        }else if ("3".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept3",deptId);
        }else if ("4".equals(deptLevel)){
            criteria.andEqualTo("gaOwnerDept4",deptId);
        }

        return pcYjwtMapper.selectCountByExample(example);
    }

    @Override
    public int updateSdbh(PcYjwt pcYjwt, Map<String,String> userInfo) {
        pcYjwt.setWtzt("0");// 手动闭环更改问题状态
        pcYjwt.setModifiedUserId(userInfo.get("userId"));
        pcYjwt.setModifiedDeptId(userInfo.get("deptId"));
        pcYjwt.setModifiedDeptName(userInfo.get("deptName"));
        pcYjwt.setModifiedDate(new Date());
        int num = pcYjwtMapper.updateByPrimaryKeySelective(pcYjwt);
        return num;
    }
}
