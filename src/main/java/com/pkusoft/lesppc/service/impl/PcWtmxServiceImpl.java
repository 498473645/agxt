package com.pkusoft.lesppc.service.impl;

import com.pkusoft.jjpt.po.SpCjrxx;
import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.model.PcYjwt;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.mapper.PcWtmxMapper;
import com.pkusoft.lesppc.service.PcWtmxService;
import com.pkusoft.lesppc.service.PcYjwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PcWtmxServiceImpl implements PcWtmxService {

    @Autowired
    private PcWtmxMapper pcWtmxMapper;

    @Autowired
    private PcYjwtService pcYjwtService;

    /**
     * 查询问题模型数量
     *
     * @param wtLyBh 问题领域编号
     * @return
     */
    @Override
    public ModelCountVo getModelCount(String wtLyBh) {
        ModelCountVo modelCount = new ModelCountVo();
        int wts = pcWtmxMapper.getWtmxs(wtLyBh);
        int yjs = pcWtmxMapper.getYjmxs(wtLyBh);
        modelCount.setWtMx(wts);
        modelCount.setYjMx(yjs);
        return modelCount;
    }

    public Map<String,Object> getJbjWtmxAndCount(String deptId,String deptLevel,String wtlyBh,String wtwd1,String lx) {
        Map<String,Object> retMap = new HashMap<>();
        Example example = new Example(PcWtmx.class);
        example.setOrderByClause("XH ASC");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("wtlyBh",wtlyBh);
        criteria.andEqualTo("lx",lx);
        List<PcWtmx> pcWtmxList = pcWtmxMapper.selectByExample(example);
        for (PcWtmx pcWtmx:pcWtmxList){
            int num = pcYjwtService.getYjxxListCount(deptId,deptLevel,wtwd1,pcWtmx.getWtmxBh());
            pcWtmx.setModifiedDeptName(num+"");
            retMap.put(pcWtmx.getWtmxBh(),pcWtmx);
        }
        return retMap;
    }
}
