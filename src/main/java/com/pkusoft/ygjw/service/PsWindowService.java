package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsWindow;
import com.pkusoft.ygjw.req.PsWindowReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsWindowService
*/
public interface PsWindowService {

    /**
    * 查询业务数据_窗口表集合
    * @param map	查询条件集合
    * @return
    */
    List<PsWindow> getPsWindowList(PsWindowReqParam psWindowReqParam, Map<String, String> map);

    /**
    * 查询业务数据_窗口表总数
    * @param map	查询条件集合
    * @return
    */
    int getPsWindowCount(PsWindowReqParam psWindowReqParam,Map<String, String> map);

    /**
    * 新增业务数据_窗口表
    * @param psWindow	业务数据_窗口表
    * @param map	用户集合
    * @return
    */
    int psWindowSave(PsWindow psWindow, Map<String, String> map);

    /**
    * 修改业务数据_窗口表
    * @param psWindow	业务数据_窗口表
    * @param map	用户集合
    * @return
    */
    int psWindowUpdate(PsWindow psWindow, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsWindow getPsWindow(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psWindowDelete(String id);

}