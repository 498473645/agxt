package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileInfoA;

/**
* @author
* @title: FileInfoAService
*/
public interface FileInfoAService {

    /**
    * 查询案卷信息归档表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileInfoA> getFileInfoAList(Map<String, String> map);

    /**
    * 查询案卷信息归档表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileInfoACount(Map<String, String> map);

    /**
    * 新增案卷信息归档表
    * @param fileInfoA	案卷信息归档表
    * @param map	用户集合
    * @return
    */
    int fileInfoASave(FileInfoA fileInfoA, Map<String,String> map);

    /**
    * 修改案卷信息归档表
    * @param fileInfoA	案卷信息归档表
    * @param map	用户集合
    * @return
    */
    int fileInfoAUpdate(FileInfoA fileInfoA, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileInfoA getFileInfoA(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileInfoADelete(String id);

    /**
     * 查询已归档的数据
     * @param map
     * @return
     */
    List<FileInfoA> getFileInfoAListAJGD(Map<String, Object> map);

    Integer getFileInfoAListAJGDConut(Map<String, Object> map);
}
