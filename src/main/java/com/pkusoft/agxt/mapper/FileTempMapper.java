package com.pkusoft.agxt.mapper;

import com.pkusoft.agxt.model.FileTemp;
import tk.mybatis.mapper.common.Mapper;

public interface FileTempMapper extends Mapper<FileTemp> {

    int getMaxSN();

}
