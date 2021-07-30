package com.pkusoft.lesppc.service;

import com.pkusoft.lesppc.req.*;

import java.util.List;
import java.util.Map;

/**
 * 涉案财物分屏服务接口
 * @author
 */
public interface SplitScreenService {

    /**
     * 查询问题模型数量
     * @param map
     * @return
     */
    ModelCountVo getModelCount(Map<String, String> map);


    /**
     * 统计问题状态数量
     * @param map
     * @return
     */
    Map<String,Integer> getProblemStatusCount(Map<String, String> map);


    /**
     * 统计问题状态数量
     * @param map
     * @return
     */
    Map<String,Object> getYjWtListByMxType(Map<String, String> map);


    /**
     * 涉案财物--获取按单位统计的问题排名
     * @param map
     * @return
     */
    List<WtpmVo> getWtpmByDept(Map<String, String> map);

    /**
     * 涉案财物-获取问题总数
     * @param map
     * @return
     */
    int getWtTotal(Map<String, String> map);


    /**
     * 查询最新预警问题列表
     * @param map
     * @return
     */
    List<WtLbVo> getYjList(Map<String, String> map);

    /**
     * 查询未闭环问题列表
     * @param map
     * @return
     */
    List<WtLbVo> getWtList(Map<String, String> map);


}
