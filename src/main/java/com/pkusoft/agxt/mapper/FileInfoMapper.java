package com.pkusoft.agxt.mapper;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.req.FileInfoParam;
import tk.mybatis.mapper.common.Mapper;

import com.pkusoft.agxt.model.FileInfo;

public interface FileInfoMapper extends Mapper<FileInfo> {

    List<FileInfoParam> jobFileInfoListDataSMCJ(Map<String,Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdKg(Map<String, Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdAJYL(Map<String, Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdRg(Map<String, Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdChangeNatureData(Map<String, Object> param);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdYssh(Map<String, Object> map);

    List<FileInfo> getJobFileInfoByFileAuthoperIdYSQSTQDB(Map<String, Object> map);

    Integer getJobFileInfoByFileAuthoperIdYSQSTQDB_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoByFileAuthDeptId(Map<String, Object> map);

    Integer getJobFileInfoByFileAuthDeptId_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoByHandlerId(Map<String, Object> map);

    Integer getJobFileInfoByHandlerId_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoListSMCJ(Map<String, Object> map);

    Integer getJobFileInfoListSMCJ_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoByFileAuthoperIdAJKL(Map<String, Object> map);

    Integer getJobFileInfoByFileAuthoperIdAJKL_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoByFileAuthoperIdYLAJ(Map<String, Object> map);

    Integer getJobFileInfoByFileAuthoperIdYLAJ_Count(Map<String, Object> map);

    List<FileInfo> getJobFileInfoListAJZF(Map<String, Object> map);

    Integer getJobFileInfoListAJZF_Count(Map<String, Object> map);

    List<FileInfoParam> jobFileInfoListDataBGBADW(Map<String, Object> map);

    List<FileInfoParam> getJobFileInfoListAJGD(Map<String, Object> map);
}
