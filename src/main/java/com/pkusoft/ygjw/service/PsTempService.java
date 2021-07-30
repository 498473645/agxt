package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.req.PsTempReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsTempService
*/
public interface PsTempService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<PsTemp> getPsTempList(PsTempReqParam psTempReqParam, Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getPsTempCount(PsTempReqParam psTempReqParam, Map<String, String> map);

    /**
    * 新增
    * @param psTemp	
    * @param map	用户集合
    * @return
    */
    int psTempSave(PsTemp psTemp, Map<String, String> map);

    /**
    * 修改
    * @param psTemp	
    * @param map	用户集合
    * @return
    */
    int psTempUpdate(PsTemp psTemp, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsTemp getPsTemp(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psTempDelete(String id);

    /**
     * 存儲材料模板圖片信息
     * @param contentBase
     * @return
     */
    String savePsTempFile(String contentBase);

    /**
     * 生成材料模板编号和序号
     * @return
     */
    Map<String,Object> getModelNm();

}