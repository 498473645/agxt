package com.pkusoft.lesppc.mapper;

import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.model.PcYjwt;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface PcYjwtMapper extends Mapper<PcYjwt> {

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
     * 查看预警列表
     * @param map
     * @return
     */
    List<WtLbVo> getYjList(Map<String, String> map);

    /**
     * 黄冈大屏——预警信息列表
     * @param param
     * @return
     */
    List<PcYjwt> getYjxxListByParams(Map<String, Object> param);

    /**
     * 黄冈大屏——预警信息数
     * @param param
     * @return
     */
    int getYjxxCountByParams(Map<String, Object> param);


}
