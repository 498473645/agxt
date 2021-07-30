package com.pkusoft.jjpt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.req.SpFkxxReqParam;
import com.pkusoft.jjpt.res.Jcjxx;


public interface SpFkxxService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<SpFkxx> getSpFkxxList(SpFkxxReqParam spFkxx,Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getSpFkxxCount(SpFkxxReqParam spFkxx,Map<String, String> map);

    /**
    * 新增
    * @param spFkxx
    * @param map	用户集合
    * @return
    */
    int spFkxxSave(SpFkxx spFkxx, Map<String,String> map);

    /**
     * 新增
     * @param spFkxx
     * @return
     */
    int spFkxxSave(SpFkxx spFkxx);

    /**
    * 修改
    * @param spFkxx
    * @param map	用户集合
    * @return
    */
    int spFkxxUpdate(SpFkxx spFkxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpFkxx getSpFkxx(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spFkxxDelete(String objid);

    /**
     * 根据处警主键查询警情和处警信息
     * @param jjdObjid
     * @return
     */
    Jcjxx getJjCjxx(String jjdObjid);

    /**
     * 根据处警主键查询警情和处警信息
     * @param spFkxx
     * @param map	用户集合
     * @return
     */
    String postfeedBack(SpFkxx spFkxx, Map<String,String> map);

}
