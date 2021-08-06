package com.pkusoft.lesp.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lesp.po.RsJbjPyjd;

/**
* @author
* @title: RsJbjPyjdService
*/
public interface RsJbjPyjdService {

    /**
    * 查询业务数据_评议监督表集合
    * @param map	查询条件集合
    * @return
    */
    List<RsJbjPyjd> getRsJbjPyjdList(Map<String, String> map);

    /**
    * 查询业务数据_评议监督表总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjPyjdCount(Map<String, String> map);

    /**
    * 新增业务数据_评议监督表
    * @param rsJbjPyjd	业务数据_评议监督表
    * @param map	用户集合
    * @return
    */
    int rsJbjPyjdSave(RsJbjPyjd rsJbjPyjd, Map<String, String> map);

    /**
    * 修改业务数据_评议监督表
    * @param rsJbjPyjd	业务数据_评议监督表
    * @param map	用户集合
    * @return
    */
    int rsJbjPyjdUpdate(RsJbjPyjd rsJbjPyjd, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param pyjdId
    * @return
    */
    RsJbjPyjd getRsJbjPyjd(String pyjdId);

    /**
    * 根据主键ID删除规则信息
    * @param pyjdId
    * @return
    */
    int rsJbjPyjdDelete(String pyjdId);

}