package com.pkusoft.lesp.service;

import com.pkusoft.lesp.po.RsJbjJgxtDynamic;

import java.util.List;
import java.util.Map;


public interface RsJbjJgxtDynamicService {

    /**
     * 动态----获取动态
     * @return
     */
    List<RsJbjJgxtDynamic> getDynamicData(Map<String, String> map, Map<String, String> userInfo);

    int getDynamicCount(Map<String, String> map, Map<String, String> userInfo);

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<RsJbjJgxtDynamic> getRsJbjJgxtDynamicList(Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjJgxtDynamicCount(Map<String, String> map);

    /**
    * 新增
    * @param rsJbjJgxtDynamic
    * @param map	用户集合
    * @return
    */
    int rsJbjJgxtDynamicSave(RsJbjJgxtDynamic rsJbjJgxtDynamic, Map<String, String> map);

    /**
    * 修改
    * @param rsJbjJgxtDynamic
    * @param map	用户集合
    * @return
    */
    int rsJbjJgxtDynamicUpdate(RsJbjJgxtDynamic rsJbjJgxtDynamic, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    RsJbjJgxtDynamic getRsJbjJgxtDynamic(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int rsJbjJgxtDynamicDelete(String[] objid);

}
