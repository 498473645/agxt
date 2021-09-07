package com.pkusoft.lespke2.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lespke2.po.KeAjWsnr;

/**
* @author
* @title: KeAjWsnrService
*/
public interface KeAjWsnrService {

    /**
    * 查询案件的文书内容集合
    * @param map	查询条件集合
    * @return
    */
    List<KeAjWsnr> getKeAjWsnrList(Map<String, String> map);

    /**
    * 查询案件的文书内容总数
    * @param map	查询条件集合
    * @return
    */
    int getKeAjWsnrCount(Map<String, String> map);

    /**
    * 新增案件的文书内容
    * @param keAjWsnr	案件的文书内容
    * @param map	用户集合
    * @return
    */
    int keAjWsnrSave(KeAjWsnr keAjWsnr, Map<String, String> map);

    /**
    * 修改案件的文书内容
    * @param keAjWsnr	案件的文书内容
    * @param map	用户集合
    * @return
    */
    int keAjWsnrUpdate(KeAjWsnr keAjWsnr, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param flwsbh
    * @return
    */
    KeAjWsnr getKeAjWsnr(String flwsbh);

    /**
    * 根据主键ID删除规则信息
    * @param flwsbh
    * @return
    */
    int keAjWsnrDelete(String flwsbh);

}
