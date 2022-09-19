package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.usercenter.po.SysUser;
import org.support.commons.springmvc.ResponseData;

/**
* @author
* @title: FileInfoService
*/
public interface FileInfoService {

    /**
    * 查询案卷信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<FileInfo> getFileInfoList(FileInfoParam fileInfoParam, SysUser sysUser);

    /**
     * 查询案卷信息表集合
     * @param sysUser	查询条件集合
     * @return
     */
    List<FileInfo> getFileInfoListByIdList(FileInfoParam fileInfoParam, SysUser sysUser);

    /**
    * 查询案卷信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getFileInfoCount(FileInfoParam fileInfoParam, SysUser sysUser);

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

    /**
     * web 扫描采集查询
     * @param fileInfoParam
     * @param sysUser
     */
    List<FileInfoParam> jobFileInfoListDataSMCJ(FileInfoParam fileInfoParam, SysUser sysUser);

    List<FileInfoParam> getJobFileInfoByFileAuthoperIdKg(FileInfoParam fileInfoParam, SysUser sysUser);

    /**
     * 创建案卷(保存 JobCaseInfo,JobFileMetal,JobFileStore,JobFileTrack,JobFileInfo,JobCasePerson,JobCaseOrg,JobCaseHandler表的信息)
     *
     * @param jobCaseInfo jobCaseInfo,JobFileMetal metal,JobFileStore store
     * @return 插入记录数
     */
    ResponseData jianJuan(CaseInfo jobCaseInfo, List<FileTemp> temp, CabSpace space, UserInfo userInfo);

    int deleteJobFileInfoByAjbh(String ajbh);
    /**
     * 案卷阅览查询
     * @return
     */
    List<FileInfoParam> getJobFileInfoByFileAuthoperIdAJYL(FileInfoParam fileInfoParam, SysUser sysUser);
}
