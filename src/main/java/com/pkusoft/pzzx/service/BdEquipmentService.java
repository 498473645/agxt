package com.pkusoft.pzzx.service;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.req.BdEquipmentReqParam;

import java.util.List;
import java.util.Map;


public interface BdEquipmentService {

    /**
    * 查询基础数据_接警平台设备登记表集合
    * @param map	查询条件集合
    * @return
    */
    List<BdEquipment> getBdEquipmentList(BdEquipmentReqParam bdEquipment,Map<String, String> map);

    /**
    * 查询基础数据_接警平台设备登记表总数
    * @param map	查询条件集合
    * @return
    */
    int getBdEquipmentCount(BdEquipmentReqParam bdEquipment,Map<String, String> map);

    /**
    * 新增基础数据_接警平台设备登记表
    * @param bdEquipment	基础数据_接警平台设备登记表
    * @param map	用户集合
    * @return
    */
    int bdEquipmentSave(BdEquipment bdEquipment, Map<String,String> map);

    /**
    * 修改基础数据_接警平台设备登记表
    * @param bdEquipment	基础数据_接警平台设备登记表
    * @param map	用户集合
    * @return
    */
    int bdEquipmentUpdate(BdEquipment bdEquipment, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    BdEquipment getBdEquipment(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int bdEquipmentDelete(String objid);

    /**
     * 根据设备类型获取当前用户所属单位的设备列表
     * @param objtype
     * @param map
     * @return
     */
    List<BdEquipment> getBdEquipmentListByObjtype(String objtype,Map<String, String> map);

    /**
     * 根据eId查看规则信息详情
     * @param eId
     * @return
     */
    BdEquipment getBdEquipmentByEId(String eId);

}