package com.pkusoft.lesppc.service;

import com.pkusoft.lesppc.model.PcBjwt;
import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.req.*;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PcBjwtService
*/
public interface PcBjwtService {


    /**
     * 统计涉案财物产生的问题数
     * @return
     */
    int getSacwWtCount(Map<String, String> map);


    /**
     * 涉案财物督办问题
     * @param map
     * @return
     */
    int getSacwDbCount(Map<String, String> map);


    /**
     * 涉案财物整改闭环问题
     * @param map
     * @return
     */
    int getSacwBhCount(Map<String, String> map);


    /**
     *
     * 涉案财物--按问题类型统计该类模型产生的问题数
     * @return
     */
    List<YjWtVo> getWtCountByMxType();


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
     * 查询未闭环问题列表
     * @param map
     * @return
     */
    List<WtLbVo> getWtList(Map<String, String> map);

    /**
     * 监控快照业务保存到问题子表
     * @param pcBjwt
     * @param wtmxbh
     * @param user
     * @return
     */
    int pcBjwtSave(PcBjwt pcBjwt, String wtmxbh,Map<String, String> user);
}
