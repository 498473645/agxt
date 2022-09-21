package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileInfoH;

/**
* @author
* @title: FileInfoHService
*/
public interface FileInfoHService {

    /**
    * 查询案卷历史信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileInfoH> getFileInfoHList(Map<String, String> map);

    /**
    * 查询案卷历史信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileInfoHCount(Map<String, String> map);

    /**
    * 新增案卷历史信息表
    * @param fileInfoH	案卷历史信息表
    * @param map	用户集合
    * @return
    */
    int fileInfoHSave(FileInfoH fileInfoH, Map<String,String> map);

    /**
    * 修改案卷历史信息表
    * @param fileInfoH	案卷历史信息表
    * @param map	用户集合
    * @return
    */
    int fileInfoHUpdate(FileInfoH fileInfoH, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param hisId
    * @return
    */
    FileInfoH getFileInfoH(String hisId);

    /**
    * 根据主键ID删除规则信息
    * @param hisId
    * @return
    */
    int fileInfoHDelete(String hisId);

    /**
     * 先将案卷信息查出来在存入历史表(主要用于修改);
     * @param id
     */
    void TemporalTableById(String id);
}
