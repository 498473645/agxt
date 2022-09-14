package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabPlace;

/**
* @author
* @title: CabPlaceService
*/
public interface CabPlaceService {

    /**
    * 查询案卷柜场所信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<CabPlace> getCabPlaceList(Map<String, String> map);

    /**
    * 查询案卷柜场所信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getCabPlaceCount(Map<String, String> map);

    /**
    * 新增案卷柜场所信息表
    * @param cabPlace	案卷柜场所信息表
    * @param map	用户集合
    * @return
    */
    int cabPlaceSave(CabPlace cabPlace, Map<String,String> map);

    /**
    * 修改案卷柜场所信息表
    * @param cabPlace	案卷柜场所信息表
    * @param map	用户集合
    * @return
    */
    int cabPlaceUpdate(CabPlace cabPlace, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabPlace getCabPlace(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int cabPlaceDelete(String id);

}
