package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsApprs;
import com.pkusoft.ygjw.req.PsApprsReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsApprsService
*/
public interface PsApprsService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<PsApprs> getPsApprsList(PsApprsReqParam psApprsReqParam, Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getPsApprsCount(PsApprsReqParam psApprsReqParam, Map<String, String> map);

    /**
    * 新增
    * @param psApprs	
    * @param map	用户集合
    * @return
    */
    int psApprsSave(PsApprs psApprs, Map<String, String> map);

    /**
    * 修改
    * @param psApprs	
    * @param map	用户集合
    * @return
    */
    int psApprsUpdate(PsApprs psApprs, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsApprs getPsApprs(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psApprsDelete(String id);

}