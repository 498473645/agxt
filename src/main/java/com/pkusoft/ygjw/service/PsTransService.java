package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.req.PsTransReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsTransService
*/
public interface PsTransService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<PsTrans> getPsTransList(PsTransReqParam psTransReqParam, Map<String, String> map);

    List<PsTrans> getPsTransListByIdcard(String idcard,String ly);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getPsTransCount(PsTransReqParam psTransReqParam, Map<String, String> map);

    /**
    * 新增
    * @param psTrans
    * @param map	用户集合
    * @return
    */
    int psTransSave(PsTrans psTrans, Map<String, String> map);

    /**
    * 修改
    * @param psTrans
    * @param map	用户集合
    * @return
    */
    int psTransUpdate(PsTrans psTrans, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsTrans getPsTrans(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psTransDelete(String id);

    /**
     * 动态----获取动态
     * @return
     */
    List<PsTrans> getDynamicData(Map<String, String> map);

    int getDynamicCount(Map<String, String> map);

}
