package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpCjrxx;
import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.req.SpCjrxxReqParam;


public interface SpCjrxxService {

    /**
    * 查询业务数据_处警人员记录表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpCjrxx> getSpCjrxxList(SpCjrxxReqParam spCjrxx,Map<String, String> map);

    /**
    * 查询业务数据_处警人员记录表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpCjrxxCount(SpCjrxxReqParam spCjrxx,Map<String, String> map);

    /**
    * 新增业务数据_处警人员记录表
    * @param spCjrxx	业务数据_处警人员记录表
    * @param map	用户集合
    * @return
    */
    int spCjrxxSave(SpCjrxx spCjrxx, Map<String,String> map);

    /**
    * 修改业务数据_处警人员记录表
    * @param spCjrxx	业务数据_处警人员记录表
    * @param map	用户集合
    * @return
    */
    int spCjrxxUpdate(SpCjrxx spCjrxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpCjrxx getSpCjrxx(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spCjrxxDelete(String objid);

    /**
     * 根据处警单id修改处警人状态为已反馈
     * @param spFkxx
     * @return
     */
    int uptSpCjrxxStatus(SpFkxx spFkxx, Map<String,String> map);

    /**
     * 根据参数查询处警人列表
     * @param map	查询条件集合
     * @return
     */
    List<SpCjrxx> getSpCjrxxListByParam(SpCjrxx spCjrxx,Map<String, String> map);

}
