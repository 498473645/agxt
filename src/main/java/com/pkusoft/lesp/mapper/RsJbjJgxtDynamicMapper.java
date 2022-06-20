package com.pkusoft.lesp.mapper;

import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface RsJbjJgxtDynamicMapper extends Mapper<RsJbjJgxtDynamic> {
    int getDynamicCount(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel,
                        @Param("status") String status, @Param("reporterSource") String reporterSource,
                        @Param("ybabh") String ybabh, @Param("jqly") String jqly,
                        @Param("jjsjStart") String jjsjStart, @Param("jjsjEnd") String jjsjEnd,
                        @Param("ybjStatus") String ybjStatus
    );

    int getDynamic(@Param("deptId") String deptId, @Param("deptLevel") String deptLevel,
                        @Param("status") String status, @Param("reporterSource") String reporterSource,
                        @Param("ybabh") String ybabh, @Param("jqly") String jqly,
                        @Param("jjsjStart") String jjsjStart, @Param("jjsjEnd") String jjsjEnd,
                        @Param("ybjStatus") String ybjStatus
    );
}
