package com.pkusoft.lesppc.mapper;

import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.model.PcBjwt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface PcBjwtMapper extends Mapper<PcBjwt> {

    /**
     * 统计问题数
     * @param map
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
     * 黄冈大屏——问题信息列表
     * @param param
     * @return
     */
    List<PcBjwt> getWtxxListByParams(Map<String, Object> param);

    /**
     * 黄冈大屏——问题信息数
     * @param param
     * @return
     */
    int getWtxxCountByParams(Map<String, Object> param);

}
