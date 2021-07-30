package com.pkusoft.jjpt.mapper;

import com.pkusoft.jjpt.po.ZzjbjBjxx;
import com.pkusoft.jjpt.res.Ybjxx;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ZzjbjBjxxMapper extends Mapper<ZzjbjBjxx> {
    List<Ybjxx> getBigScreenYbjxxList(@Param("orgCode")  String orgCode);
}