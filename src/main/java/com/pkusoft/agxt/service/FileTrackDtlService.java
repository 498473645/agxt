package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileTrackDtl;

/**
* @author
* @title: FileTrackDtlService
*/
public interface FileTrackDtlService {

    /**
    * 查询案卷操作轨迹表(副表)集合
    * @param map	查询条件集合
    * @return
    */
    List<FileTrackDtl> getFileTrackDtlList(Map<String, String> map);

    /**
    * 查询案卷操作轨迹表(副表)总数
    * @param map	查询条件集合
    * @return
    */
    int getFileTrackDtlCount(Map<String, String> map);

    /**
    * 新增案卷操作轨迹表(副表)
    * @param fileTrackDtl	案卷操作轨迹表(副表)
    * @param map	用户集合
    * @return
    */
    int fileTrackDtlSave(FileTrackDtl fileTrackDtl, Map<String,String> map);

    /**
    * 修改案卷操作轨迹表(副表)
    * @param fileTrackDtl	案卷操作轨迹表(副表)
    * @param map	用户集合
    * @return
    */
    int fileTrackDtlUpdate(FileTrackDtl fileTrackDtl, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileTrackDtl getFileTrackDtl(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileTrackDtlDelete(String id);

}
