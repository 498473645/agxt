package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.FileStore;

public interface FileStoreMapper extends Mapper<FileStore> {

    FileStore getJobFileStoreByFileCode(Map<String, Object> map);

    FileStore getJobFileStoreByFileIdAndPageIdAndMetalId(Map<String, Object> map);
}
