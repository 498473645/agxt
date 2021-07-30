package com.pkusoft.lesp.service;

import com.pkusoft.lesp.po.RsJbjSxtxx;

import java.util.List;
import java.util.Map;


public interface RsJbjSxtxxService {

    /**
     * 巡查_列出所有派出所
     * @return
     */
    List<RsJbjSxtxx> getDeptList(Map<String, String> userInfo);

    /**
     * 巡查_列出摄像头信息
     * @return
     */
    List<Map<String,Object>> getCameraList(String deptId);

    /**
     * 查询要素数据_派出所摄像头基本信息集合
     * @param map	查询条件集合
     * @return
     */
    List<RsJbjSxtxx> getRsJbjSxtxxList(Map<String, String> map);

    /**
    * 查询要素数据_派出所摄像头基本信息总数
    * @param map	查询条件集合
    * @return
    */
    int getRsJbjSxtxxCount(Map<String, String> map);

    /**
    * 新增要素数据_派出所摄像头基本信息
    * @param rsJbjSxtxx	要素数据_派出所摄像头基本信息
    * @param map	用户集合
    * @return
    */
    int rsJbjSxtxxSave(RsJbjSxtxx rsJbjSxtxx, Map<String, String> map);

    /**
    * 修改要素数据_派出所摄像头基本信息
    * @param rsJbjSxtxx	要素数据_派出所摄像头基本信息
    * @param map	用户集合
    * @return
    */
    int rsJbjSxtxxUpdate(RsJbjSxtxx rsJbjSxtxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    RsJbjSxtxx getRsJbjSxtxx(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int rsJbjSxtxxDelete(String[] objid);

}