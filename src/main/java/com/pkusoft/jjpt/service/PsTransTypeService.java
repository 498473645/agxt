package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.PsTransType;


public interface PsTransTypeService {

    /**
    * 查询业务类型集合
    * @param map	查询条件集合
    * @return
    */
    List<PsTransType> getPsTransTypeList(Map<String, String> map);

    /**
    * 查询业务类型总数
    * @param map	查询条件集合
    * @return
    */
    int getPsTransTypeCount(Map<String, String> map);

    /**
    * 新增业务类型
    * @param psTransType	业务类型
    * @return
    */
    int psTransTypeSave(PsTransType psTransType);

    /**
    * 修改业务类型
    * @param psTransType	业务类型
    * @return
    */
    int psTransTypeUpdate(PsTransType psTransType);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsTransType getPsTransType(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psTransTypeDelete(String[] id);

}
