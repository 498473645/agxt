package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.CabArea;

public interface CabAreaMapper extends Mapper<CabArea> {

    Integer getMaxSN();
}
