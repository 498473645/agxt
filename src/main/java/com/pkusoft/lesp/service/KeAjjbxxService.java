package com.pkusoft.lesp.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lesp.model.KeAjjbxx;

/**
* @author
* @title: KeAjjbxxService
*/
public interface KeAjjbxxService {

    /**
    * 查询案件基本信息集合
    * @param map	查询条件集合
    * @return
    */
    List<KeAjjbxx> getKeAjjbxxList(Map<String, String> map);

    /**
    * 查询案件基本信息总数
    * @param map	查询条件集合
    * @return
    */
    int getKeAjjbxxCount(Map<String, String> map);

    /**
    * 新增案件基本信息
    * @param keAjjbxx	案件基本信息
    * @param map	用户集合
    * @return
    */
    int keAjjbxxSave(KeAjjbxx keAjjbxx, Map<String,String> map);

    /**
    * 修改案件基本信息
    * @param keAjjbxx	案件基本信息
    * @param map	用户集合
    * @return
    */
    int keAjjbxxUpdate(KeAjjbxx keAjjbxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param ajbh
    * @return
    */
    KeAjjbxx getKeAjjbxx(String ajbh);

    /**
    * 根据主键ID删除规则信息
    * @param ajbh
    * @return
    */
    int keAjjbxxDelete(String ajbh);

}
