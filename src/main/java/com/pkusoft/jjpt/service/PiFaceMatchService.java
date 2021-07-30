package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.PiFaceMatch;

import java.util.List;
import java.util.Map;


public interface PiFaceMatchService {

    /**
    * 查询业务数据_人脸识别图片信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<PiFaceMatch> getPiFaceMatchList(Map<String, String> map);

    /**
     * 查询业务数据_人脸识别图片信息表集合
     * @param map	查询条件集合
     * @return
     */
    List<PiFaceMatch> getPiFaceMatchList(Map<String, String> map, int limit);

    /**
    * 查询业务数据_人脸识别图片信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getPiFaceMatchCount(Map<String, String> map);

    /**
    * 新增业务数据_人脸识别图片信息表
    * @param piFaceMatch	业务数据_人脸识别图片信息表
    * @param map	用户集合
    * @return
    */
    int piFaceMatchSave(PiFaceMatch piFaceMatch, Map<String, String> map);

    /**
    * 修改业务数据_人脸识别图片信息表
    * @param piFaceMatch	业务数据_人脸识别图片信息表
    * @param map	用户集合
    * @return
    */
    int piFaceMatchUpdate(PiFaceMatch piFaceMatch, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    PiFaceMatch getPiFaceMatch(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int piFaceMatchDelete(String[] objid);

}