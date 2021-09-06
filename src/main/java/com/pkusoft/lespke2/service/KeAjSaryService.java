package com.pkusoft.lespke2.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lespke2.po.KeAjSary;

/**
* @author
* @title: KeAjSaryService
*/
public interface KeAjSaryService {

    /**
    * 查询案件涉案人员信息（201912版）集合
    * @param map	查询条件集合
    * @return
    */
    List<KeAjSary> getKeAjSaryList(Map<String, String> map);

    /**
    * 查询案件涉案人员信息（201912版）总数
    * @param map	查询条件集合
    * @return
    */
    int getKeAjSaryCount(Map<String, String> map);

    /**
    * 新增案件涉案人员信息（201912版）
    * @param keAjSary	案件涉案人员信息（201912版）
    * @param map	用户集合
    * @return
    */
    int keAjSarySave(KeAjSary keAjSary, Map<String, String> map);

    /**
    * 修改案件涉案人员信息（201912版）
    * @param keAjSary	案件涉案人员信息（201912版）
    * @param map	用户集合
    * @return
    */
    int keAjSaryUpdate(KeAjSary keAjSary, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param ajbh
    * @return
    */
    KeAjSary getKeAjSary(String ajbh);

    /**
    * 根据主键ID删除规则信息
    * @param ajbh
    * @return
    */
    int keAjSaryDelete(String ajbh);

}
