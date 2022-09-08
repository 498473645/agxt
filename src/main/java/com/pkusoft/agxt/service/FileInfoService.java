package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileInfo;

/**
* @author
* @title: FileInfoService
*/
public interface FileInfoService {

    /**
    * 查询案卷信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileInfo> getFileInfoList(Map<String, String> map);

    /**
    * 查询案卷信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileInfoCount(Map<String, String> map);

    /**
    * 新增案卷信息表
    * @param fileInfo	案卷信息表
    * @param map	用户集合
    * @return
    */
    int fileInfoSave(FileInfo fileInfo, Map<String,String> map);

    /**
    * 修改案卷信息表
    * @param fileInfo	案卷信息表
    * @param map	用户集合
    * @return
    */
    int fileInfoUpdate(FileInfo fileInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileInfo getFileInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileInfoDelete(String id);

    FileInfo checkCaseInfo(FileInfo fileInfo);
}
