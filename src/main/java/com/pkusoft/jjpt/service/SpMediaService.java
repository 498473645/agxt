package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.SpMedia;
import com.pkusoft.jjpt.req.SpMediaReqParam;

import java.util.List;
import java.util.Map;


/**
* @author
* @title: SpMediaService
*/
public interface SpMediaService {

    /**
    * 查询审讯视音频信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpMedia> getSpMediaList(SpMedia spMedia, Map<String, String> map);

    /**
    * 查询审讯视音频信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpMediaCount(SpMedia spMedia, Map<String, String> map);

    /**
    * 新增审讯视音频信息表
    * @param spMedia	审讯视音频信息表
    * @param map	用户集合
    * @return
    */
    int spMediaSave(SpMedia spMedia, Map<String,String> map);

    /**
    * 修改审讯视音频信息表
    * @param spMedia	审讯视音频信息表
    * @param map	用户集合
    * @return
    */
    int spMediaUpdate(SpMedia spMedia, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpMedia getSpMedia(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spMediaDelete(String objid);

}
