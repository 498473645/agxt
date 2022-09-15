package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FilePage;

/**
* @author
* @title: FilePageService
*/
public interface FilePageService {

    /**
    * 查询案卷页信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<FilePage> getFilePageList(Map<String, String> map);

    /**
    * 查询案卷页信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getFilePageCount(Map<String, String> map);

    /**
    * 新增案卷页信息表
    * @param filePage	案卷页信息表
    * @param map	用户集合
    * @return
    */
    int filePageSave(FilePage filePage, Map<String,String> map);

    /**
    * 修改案卷页信息表
    * @param filePage	案卷页信息表
    * @param map	用户集合
    * @return
    */
    int filePageUpdate(FilePage filePage, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FilePage getFilePage(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int filePageDelete(String id);

}
