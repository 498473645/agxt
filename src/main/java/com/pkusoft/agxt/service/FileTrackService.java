package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.FileTrack;

/**
* @author
* @title: FileTrackService
*/
public interface FileTrackService {

    /**
    * 查询案卷操作轨迹表(主表)集合
    * @param map	查询条件集合
    * @return
    */
    List<FileTrack> getFileTrackList(Map<String, String> map);

    /**
    * 查询案卷操作轨迹表(主表)总数
    * @param map	查询条件集合
    * @return
    */
    int getFileTrackCount(Map<String, String> map);

    /**
    * 新增案卷操作轨迹表(主表)
    * @param fileTrack	案卷操作轨迹表(主表)
    * @param map	用户集合
    * @return
    */
    int fileTrackSave(FileTrack fileTrack, Map<String,String> map);

    /**
    * 修改案卷操作轨迹表(主表)
    * @param fileTrack	案卷操作轨迹表(主表)
    * @param map	用户集合
    * @return
    */
    int fileTrackUpdate(FileTrack fileTrack, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    FileTrack getFileTrack(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int fileTrackDelete(String id);

}
