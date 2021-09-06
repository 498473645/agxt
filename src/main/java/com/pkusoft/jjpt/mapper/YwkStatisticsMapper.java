package com.pkusoft.jjpt.mapper;

import com.pkusoft.lesp.po.StatisticsData;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface YwkStatisticsMapper extends Mapper<StatisticsData> {


    /**
     ********************************************查询业务库的统计方法******************************************************
     */
    StatisticsData getSmbaData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("ly") String ly);
    List<StatisticsData> getYbafsdbData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("ly") String ly);
    List<StatisticsData> getYbaclztfxData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("ly") String ly);
    List<StatisticsData> getBalxData(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("ly") String ly);
    List<StatisticsData> getYbaclztfxDataByDept(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("ly") String ly);
    List<StatisticsData> getPyzbData(@Param("deptId") String deptId,@Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);
    List<StatisticsData> getPymydData(@Param("deptId") String deptId,@Param("deptLevel") String deptLevel, @Param("year") String year, @Param("month") String month, @Param("day") String day);
}

