package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.CabSpace;

public interface CabSpaceMapper extends Mapper<CabSpace> {

    Integer getMaxSN();
}
