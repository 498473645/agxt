package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileAuth;

/**
* @author
* @title: FileAuthService
*/
public interface FileAuthService {

    /**
    * 查询案卷权限信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileAuth> getFileAuthList(Map<String, String> map);

    /**
    * 查询案卷权限信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileAuthCount(Map<String, String> map);

    /**
    * 新增案卷权限信息表
    * @param fileAuth	案卷权限信息表
    * @param map	用户集合
    * @return
    */
    int fileAuthSave(FileAuth fileAuth, Map<String,String> map);

    /**
    * 修改案卷权限信息表
    * @param fileAuth	案卷权限信息表
    * @param map	用户集合
    * @return
    */
    int fileAuthUpdate(FileAuth fileAuth, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileAuth getFileAuth(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileAuthDelete(String id);

}
