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


}
