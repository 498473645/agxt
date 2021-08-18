package com.pkusoft.jjpt.mapper;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.PsTransType;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface PsTransTypeMapper extends Mapper<PsTransType> {

    List<Map<String,String>> getPsTransTypeGroup(@Param("type")  String type);
}
