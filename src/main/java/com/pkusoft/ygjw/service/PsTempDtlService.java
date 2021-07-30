package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsTempDtl;
import com.pkusoft.ygjw.req.PsTempDtlReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsTempDtlService
*/
public interface PsTempDtlService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<PsTempDtl> getPsTempDtlList(PsTempDtlReqParam psTempDtlReqParam, Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getPsTempDtlCount(PsTempDtlReqParam psTempDtlReqParam, Map<String, String> map);

    /**
    * 新增
    * @param psTempDtl	
    * @param map	用户集合
    * @return
    */
    int psTempDtlSave(PsTempDtl psTempDtl, Map<String, String> map);

    /**
    * 修改
    * @param psTempDtl	
    * @param map	用户集合
    * @return
    */
    int psTempDtlUpdate(PsTempDtl psTempDtl, Map<String, String> map);

    /**
     * 根据主键ID查看规则信息详情
     * @param id
     * @return
     */
    PsTempDtl getPsTempDtl(String id);

    /**
     * 根据主键ID查看规则信息详情
     * @param id
     * @return
     */
    PsTempDtl getPsTempDtlNew(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psTempDtlDelete(String id);

}