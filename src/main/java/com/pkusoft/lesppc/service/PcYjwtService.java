package com.pkusoft.lesppc.service;

import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.model.PcYjwt;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PcYjwtService
*/
public interface PcYjwtService {

    /**
     * 统计涉案财物产生的预警数
     * @return
     */
    int getSaCwYjCount();

    /**
     * 涉案财物--按预警类型统计该类模型产生的问题数
     * @return
     */
    List<YjWtVo> getYjCountByMxType();

    /**
     * 查询最新预警问题列表
     * @param map
     * @return
     */
    List<WtLbVo> getYjList(Map<String, String> map);





    /**
     * 动态---微信扫码未闭环
     * @return
     */
    List<PcYjwt> getWechatUnclosedData(String deptId, String deptLevel);

    /**
     * 监督---获取问题模型统计总数
     * @param deptId
     * @param deptLevel
     * @return
     */
    Map<String,Object> getWtmxCount(String deptId, String deptLevel);


    int getYjwtCountByWtmx(PcWtmx pcWtmx);

    /**
     * 监督---获取问题模型统计总数
     * @return
     */
    List<PcYjwt> getYjxxListData(Map<String,String> map);

    int getYjxxListCount(Map<String,String> map);

    int getYjxxListCount(String deptId, String deptLevel,String wtwd1, String wtmxBh);

}
