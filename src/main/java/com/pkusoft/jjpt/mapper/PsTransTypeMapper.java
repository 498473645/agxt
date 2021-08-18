package com.pkusoft.jjpt.mapper;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.PsTransType;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


public interface PsTransTypeMapper extends Mapper<PsTransType> {

    List<PsTransType> getPsTransTypeGroup();
}
