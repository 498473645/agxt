package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.model.FileStoreH;

/**
* @author
* @title: FileStoreHService
*/
public interface FileStoreHService {

    /**
    * 查询案卷存储历史表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileStoreH> getFileStoreHList(Map<String, String> map);

    /**
    * 查询案卷存储历史表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileStoreHCount(Map<String, String> map);

    /**
    * 新增案卷存储历史表
    * @param fileStoreH	案卷存储历史表
    * @param map	用户集合
    * @return
    */
    int fileStoreHSave(FileStoreH fileStoreH, Map<String,String> map);

    /**
    * 修改案卷存储历史表
    * @param fileStoreH	案卷存储历史表
    * @param map	用户集合
    * @return
    */
    int fileStoreHUpdate(FileStoreH fileStoreH, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param hisId
    * @return
    */
    FileStoreH getFileStoreH(String hisId);

    /**
    * 根据主键ID删除规则信息
    * @param hisId
    * @return
    */
    int fileStoreHDelete(String hisId);

    /**
     * 记录案卷存储表历史
     * @param jobFileStore
     */
    void TemporalTable(FileStore jobFileStore);
}
