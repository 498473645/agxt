package com.pkusoft.lesppc.service;

import com.pkusoft.lesppc.req.*;

/**
* @author
* @title: PcWtmxService
*/
public interface PcWtmxService {


    /**
     * 查询问题模型数量
     * @param wtLyBh 问题领域编号
     * @return
     */
    ModelCountVo getModelCount(String wtLyBh);



}
