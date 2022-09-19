package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FilePage;
import com.pkusoft.agxt.model.FilePageRecycle;

/**
* @author
* @title: FilePageRecycleService
*/
public interface FilePageRecycleService {

    /**
    * 查询案卷页回收记录表集合
    * @param map	查询条件集合
    * @return
    */
    List<FilePageRecycle> getFilePageRecycleList(Map<String, String> map);

    /**
    * 查询案卷页回收记录表总数
    * @param map	查询条件集合
    * @return
    */
    int getFilePageRecycleCount(Map<String, String> map);

    /**
    * 新增案卷页回收记录表
    * @param filePageRecycle	案卷页回收记录表
    * @param map	用户集合
    * @return
    */
    int filePageRecycleSave(FilePageRecycle filePageRecycle, Map<String,String> map);

    /**
    * 修改案卷页回收记录表
    * @param filePageRecycle	案卷页回收记录表
    * @param map	用户集合
    * @return
    */
    int filePageRecycleUpdate(FilePageRecycle filePageRecycle, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FilePageRecycle getFilePageRecycle(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int filePageRecycleDelete(String id);

    int saveFilePageRecycle(List<FilePage> list);
}
