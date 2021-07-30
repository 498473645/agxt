package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.mapper.PcWtmxMapper;
import com.pkusoft.lesppc.service.PcWtmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PcWtmxServiceImpl implements PcWtmxService {

    @Autowired
    private PcWtmxMapper pcWtmxMapper;


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
}
