package com.pkusoft.pzzx.service;

import com.pkusoft.pzzx.po.BdEquipmentParts;
import com.pkusoft.pzzx.req.BdEquipmentPartsReqParam;

import java.util.List;
import java.util.Map;


public interface BdEquipmentPartsService {

    /**
    * 查询基础数据_接警平台设备参数配置表集合
    * @param map	查询条件集合
    * @return
    */
    List<BdEquipmentParts> getBdEquipmentPartsList(BdEquipmentPartsReqParam bdEquipmentParts,Map<String, String> map);

    /**
    * 查询基础数据_接警平台设备参数配置表总数
    * @param map	查询条件集合
    * @return
    */
    int getBdEquipmentPartsCount(BdEquipmentPartsReqParam bdEquipmentParts,Map<String, String> map);

    /**
    * 新增基础数据_接警平台设备参数配置表
    * @param bdEquipmentParts	基础数据_接警平台设备参数配置表
    * @param map	用户集合
    * @return
    */
    int bdEquipmentPartsSave(BdEquipmentParts bdEquipmentParts, Map<String,String> map);

    /**
    * 修改基础数据_接警平台设备参数配置表
    * @param bdEquipmentParts	基础数据_接警平台设备参数配置表
    * @param map	用户集合
    * @return
    */
    int bdEquipmentPartsUpdate(BdEquipmentParts bdEquipmentParts, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    BdEquipmentParts getBdEquipmentParts(String objid);

    /**
     * 根据设备主键获取设备参数集合
     * @return
     */
    Map<String,Object> getBdEquipmentPartsMapByEobjid(String equipObjid);


    Map<String,Object> getBdEquipmentPartsMapByObjtype(String objtype,Map<String, String> map);

    List<BdEquipmentParts> getBdEquipmentPartsListByObjtype(String equipObjid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int bdEquipmentPartsDelete(String objid);

}