package com.pkusoft.lesppc.service;

import com.pkusoft.lesppc.req.*;

import java.util.Map;

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

    /**
     * 查询问题模型，并查询出总数
     * @param deptId        单位id
     * @param deptLevel     单位级别
     * @param wtLyBh        问题领域编号
     * @return
     */
    Map<String,Object> getJbjWtmxAndCount(String deptId,String deptLevel,String wtLyBh,String wtwd1,String lx);



}
