package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileMetal;
import com.pkusoft.agxt.model.FileMetalH;

/**
* @author
* @title: FileMetalHService
*/
public interface FileMetalHService {

    /**
    * 查询案卷材料历史信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileMetalH> getFileMetalHList(Map<String, String> map);

    /**
    * 查询案卷材料历史信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileMetalHCount(Map<String, String> map);

    /**
    * 新增案卷材料历史信息表
    * @param fileMetalH	案卷材料历史信息表
    * @param map	用户集合
    * @return
    */
    int fileMetalHSave(FileMetalH fileMetalH, Map<String,String> map);

    /**
    * 修改案卷材料历史信息表
    * @param fileMetalH	案卷材料历史信息表
    * @param map	用户集合
    * @return
    */
    int fileMetalHUpdate(FileMetalH fileMetalH, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param hisId
    * @return
    */
    FileMetalH getFileMetalH(String hisId);

    /**
    * 根据主键ID删除规则信息
    * @param hisId
    * @return
    */
    int fileMetalHDelete(String hisId);

    /**
     * 将材料表信息写入历史表
     * @param jobFileMetal
     */
    void TemporalTable(FileMetal jobFileMetal);

    /**
     * 将该案卷下所有的材料存入历史表
     * @param fileId
     */
    void TemporalTableByFileId(String fileId);
}
