package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.FileMetal;

public interface FileMetalMapper extends Mapper<FileMetal> {

    int updatefileMetalBySn(Map<String, Object> map);

    Integer getJobFileMetalSn(String fileId);
}
