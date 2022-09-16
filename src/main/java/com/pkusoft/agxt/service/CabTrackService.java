package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabTrack;

/**
* @author
* @title: CabTrackService
*/
public interface CabTrackService {

    /**
    * 查询案卷柜操作轨迹表集合
    * @param map	查询条件集合
    * @return
    */
    List<CabTrack> getCabTrackList(Map<String, String> map);

    /**
    * 查询案卷柜操作轨迹表总数
    * @param map	查询条件集合
    * @return
    */
    int getCabTrackCount(Map<String, String> map);

    /**
    * 新增案卷柜操作轨迹表
    * @param cabTrack	案卷柜操作轨迹表
    * @param map	用户集合
    * @return
    */
    int cabTrackSave(CabTrack cabTrack, Map<String,String> map);

    /**
    * 修改案卷柜操作轨迹表
    * @param cabTrack	案卷柜操作轨迹表
    * @param map	用户集合
    * @return
    */
    int cabTrackUpdate(CabTrack cabTrack, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabTrack getCabTrack(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int cabTrackDelete(String id);

    void insertCabTrack(CabTrack jobCabTrack);
}
