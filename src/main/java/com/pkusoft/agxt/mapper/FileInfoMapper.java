package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.req.FileInfoParam;
import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.FileInfo;

public interface FileInfoMapper extends Mapper<FileInfo> {

    List<FileInfoParam> jobFileInfoListDataSMCJ(Map<String,Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdKg(Map<String, Object> param);
}
