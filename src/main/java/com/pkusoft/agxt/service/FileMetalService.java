package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileMetal;

/**
* @author
* @title: FileMetalService
*/
public interface FileMetalService {

    /**
    * 查询案卷材料信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FileMetal> getFileMetalList(Map<String, String> map);

    /**
    * 查询案卷材料信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFileMetalCount(Map<String, String> map);

    /**
    * 新增案卷材料信息表
    * @param fileMetal	案卷材料信息表
    * @param map	用户集合
    * @return
    */
    int fileMetalSave(FileMetal fileMetal, Map<String,String> map);

    /**
    * 修改案卷材料信息表
    * @param fileMetal	案卷材料信息表
    * @param map	用户集合
    * @return
    */
    int fileMetalUpdate(FileMetal fileMetal, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileMetal getFileMetal(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileMetalDelete(String id);

}
