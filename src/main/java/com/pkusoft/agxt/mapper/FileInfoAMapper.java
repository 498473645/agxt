package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.FileInfoA;

public interface FileInfoAMapper extends Mapper<FileInfoA> {

    List<FileInfoA> getFileInfoAListAJGD(Map<String, Object> map);

    Integer getFileInfoAListAJGDConut(Map<String, Object> map);
}
