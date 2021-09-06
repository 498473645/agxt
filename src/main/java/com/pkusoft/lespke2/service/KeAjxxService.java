package com.pkusoft.lespke2.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lespke2.po.KeAjxx;

/**
* @author
* @title: KeAjxxService
*/
public interface KeAjxxService {

    /**
    * 根据身份证查询案件涉案人员信息
    * @param sfz	身份证
    * @return
    */
    List<KeAjxx> getKeAjxxListBySfz(String sfz);

}
