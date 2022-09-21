package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FilePageH;

/**
* @author
* @title: FilePageHService
*/
public interface FilePageHService {

    /**
    * 查询案卷页历史信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FilePageH> getFilePageHList(Map<String, String> map);

    /**
    * 查询案卷页历史信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFilePageHCount(Map<String, String> map);

    /**
    * 新增案卷页历史信息表
    * @param filePageH	案卷页历史信息表
    * @param map	用户集合
    * @return
    */
    int filePageHSave(FilePageH filePageH, Map<String,String> map);

    /**
    * 修改案卷页历史信息表
    * @param filePageH	案卷页历史信息表
    * @param map	用户集合
    * @return
    */
    int filePageHUpdate(FilePageH filePageH, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param hisId
    * @return
    */
    FilePageH getFilePageH(String hisId);

    /**
    * 根据主键ID删除规则信息
    * @param hisId
    * @return
    */
    int filePageHDelete(String hisId);

    /**
     * 将该案件下所有的案卷页写入历史表
     * @param fileId
     */
    void TemporalTableByFileId(String fileId);
}
