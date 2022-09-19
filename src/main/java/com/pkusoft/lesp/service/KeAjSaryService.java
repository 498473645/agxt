package com.pkusoft.lesp.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lesp.model.KeAjSary;

/**
* @author
* @title: KeAjSaryService
*/
public interface KeAjSaryService {

    /**
    * 查询案件-涉案人员集合
    * @param map	查询条件集合
    * @return
    */
    List<KeAjSary> getKeAjSaryList(Map<String, String> map);

    /**
    * 查询案件-涉案人员总数
    * @param map	查询条件集合
    * @return
    */
    int getKeAjSaryCount(Map<String, String> map);

    /**
    * 新增案件-涉案人员
    * @param keAjSary	案件-涉案人员
    * @param map	用户集合
    * @return
    */
    int keAjSarySave(KeAjSary keAjSary, Map<String,String> map);

    /**
    * 修改案件-涉案人员
    * @param keAjSary	案件-涉案人员
    * @param map	用户集合
    * @return
    */
    int keAjSaryUpdate(KeAjSary keAjSary, Map<String,String> map);

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

    /**
     * 通过案件编号查询嫌疑人
     *
     * @param keAjSary 对象
     * @return 插入记录数
     */
    List<KeAjSary> getKeAjSaryByAjbh(String ajbh,String sarylbBh);

}
