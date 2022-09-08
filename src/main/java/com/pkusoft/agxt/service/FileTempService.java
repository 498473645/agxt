package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: FileTempService
*/
public interface FileTempService {

    /**
    * 查询案卷模板信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<FileTemp> getFileTempList(FileTempParam fileTempParam, SysUser sysUser);

    /**
    * 查询案卷模板信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getFileTempCount(FileTempParam fileTempParam, SysUser sysUser);

    /**
    * 新增案卷模板信息表
    * @param fileTemp	案卷模板信息表
    * @param sysUser	用户集合
    * @return
    */
    int fileTempSave(FileTemp fileTemp, SysUser sysUser);

    /**
    * 修改案卷模板信息表
    * @param fileTemp	案卷模板信息表
    * @param sysUser	用户集合
    * @return
    */
    int fileTempUpdate(FileTemp fileTemp, SysUser sysUser);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileTemp getFileTemp(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileTempDelete(String id, SysUser sysUser);

}
