package com.pkusoft.lesp.mapper;

import com.pkusoft.lesp.po.RsJbjSxtxx;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RsJbjSxtxxMapper extends Mapper<RsJbjSxtxx> {
    List<RsJbjSxtxx> getDeptList(@Param("deptLevel") String deptLevel, @Param("deptId") String deptId, @Param("userDeptId") String userDeptId);
}