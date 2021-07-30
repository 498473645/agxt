package com.pkusoft.lesp.mapper;

import com.pkusoft.lesp.po.StatisticsData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface StatisticsMapper extends Mapper<StatisticsData> {

    StatisticsData getYbjData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);

    StatisticsData getJjData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);

    List<StatisticsData> getCjfkData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);

    StatisticsData getYbjflData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);

    StatisticsData getFljqData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);

    StatisticsData getWtmxCount(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel);

    StatisticsData getZjqsJjData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel);
    StatisticsData getZjqsYbjData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel);


    StatisticsData getMonthlyYbjData(@Param("deptId") String deptId, @Param("year") String year, @Param("month") String month);

    StatisticsData getMonthlyYbjflData(@Param("deptId") String deptId, @Param("year") String year, @Param("month") String month);

    StatisticsData getMonthlyJjData(@Param("deptId") String deptId, @Param("year") String year, @Param("month") String month);

    StatisticsData getMonthlyFljqData(@Param("deptId") String deptId, @Param("year") String year, @Param("month") String month);

//    StatisticsData getZjqsJjData(@Param("deptId") String deptId);
//    StatisticsData getZjqsYbjData(@Param("deptId") String deptId);
}
