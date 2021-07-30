package com.pkusoft.lesppc.mapper;

import com.pkusoft.lesp.po.StatisticsData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface StasticMapper extends Mapper<StatisticsData> {

    StatisticsData getWtmxCount(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel);

}
