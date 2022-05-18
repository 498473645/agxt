package com.pkusoft.pzzx.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.req.BdHandlingAreaReqParam;


public interface BdHandlingAreaService {

    /**
    * 查询基础数据_接处警功能场所记录表集合
    * @param map	查询条件集合
    * @return
    */
    List<BdHandlingArea> getBdHandlingAreaList(BdHandlingAreaReqParam bdHandlingArea,Map<String, String> map);

    /**
    * 查询基础数据_接处警功能场所记录表总数
    * @param map	查询条件集合
    * @return
    */
    int getBdHandlingAreaCount(BdHandlingAreaReqParam bdHandlingArea,Map<String, String> map);

    /**
    * 新增基础数据_接处警功能场所记录表
    * @param bdHandlingArea	基础数据_接处警功能场所记录表
    * @param map	用户集合
    * @return
    */
    int bdHandlingAreaSave(BdHandlingArea bdHandlingArea, Map<String,String> map);

    /**
    * 修改基础数据_接处警功能场所记录表
    * @param bdHandlingArea	基础数据_接处警功能场所记录表
    * @param map	用户集合
    * @return
    */
    int bdHandlingAreaUpdate(BdHandlingArea bdHandlingArea, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    BdHandlingArea getBdHandlingArea(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int bdHandlingAreaDelete(String objid);

    /**
     * 根据用户信息获取接警场所信息
     * @param user
     * @return
     */
    BdHandlingArea getBdHandlingAreaByUser(Map<String, String> user);

    List<BdHandlingArea> bdHandlingAreaByParam(BdHandlingAreaReqParam bdHandlingArea,Map<String, String> map);

    /**
     * 根据单位id查询办案区
     *
     * @param request
     * @return
     */
    BdHandlingArea getBdHandlingAreaByDeptId(String deptid);

}
