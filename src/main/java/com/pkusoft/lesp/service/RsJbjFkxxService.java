package com.pkusoft.lesp.service;

import com.pkusoft.lesp.po.RsJbjFkxx;

import java.util.List;
import java.util.Map;


public interface RsJbjFkxxService {

    /**
    * 查询要素数据_反馈信息集合
    * @param map	查询条件集合
    * @return
    */
    List<RsJbjFkxx> getRsJbjFkxxList(Map<String, String> map);

    /**
    * 查询要素数据_反馈信息总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjFkxxCount(Map<String, String> map);

    /**
    * 新增要素数据_反馈信息
    * @param rsJbjFkxx	要素数据_反馈信息
    * @param map	用户集合
    * @return
    */
    int rsJbjFkxxSave(RsJbjFkxx rsJbjFkxx, Map<String, String> map);

    /**
    * 修改要素数据_反馈信息
    * @param rsJbjFkxx	要素数据_反馈信息
    * @param map	用户集合
    * @return
    */
    int rsJbjFkxxUpdate(RsJbjFkxx rsJbjFkxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param cjdbh
    * @return
    */
    RsJbjFkxx getRsJbjFkxx(String cjdbh);

    /**
    * 根据主键ID删除规则信息
    * @param cjdbh
    * @return
    */
    int rsJbjFkxxDelete(String[] cjdbh);

}