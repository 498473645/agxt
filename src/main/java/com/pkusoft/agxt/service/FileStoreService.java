package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.model.UserInfo;
import org.support.commons.springmvc.ResponseData;

/**
* @author
* @title: FileStoreService
*/
public interface FileStoreService {

    /**
    * 查询案卷存储表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileStore> getFileStoreList(Map<String, String> map);

    /**
    * 查询案卷存储表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileStoreCount(Map<String, String> map);

    /**
    * 新增案卷存储表
    * @param fileStore	案卷存储表
    * @param map	用户集合
    * @return
    */
    int fileStoreSave(FileStore fileStore, Map<String,String> map);

    /**
    * 修改案卷存储表
    * @param fileStore	案卷存储表
    * @param map	用户集合
    * @return
    */
    int fileStoreUpdate(FileStore fileStore, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileStore getFileStore(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileStoreDelete(String id);

    List<FileStore> getJobFileStoreByAreaId(String code);

    FileStore getJobFileStoreByFileCode(String code);

    ResponseData updateJobFileStoreByJobCabSpaceBGWZ(List<FileInfo> jobfileinfo, CabSpace jobCabSpace, UserInfo userInfo);

    FileStore getJobFileStoreByFileIdAndPageIdAndMetalId(Map<String, Object> map);

    /**
     * 检查是否有案件在该改柜子里
     * @param spaceId
     * @return
     */
    List<FileStore> getJobFileStoreBySpaceId(String spaceId);

    /**
     * 案卷存储表删除信息
     *
     * @param ajbh
     * @return 删除记录数
     */
    int deleteJobFileStoreByAjbh(String ajbh);
}
