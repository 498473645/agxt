package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysDataOwnerDept;

import java.util.List;
import java.util.Map;


public interface SysDataOwnerDeptService {

    /**
    * 查询数据归属单位集合
    * @param map	查询条件集合
    * @return
    */
    List<SysDataOwnerDept> getSysDataOwnerDeptList(Map<String, String> map);

    /**
    * 查询数据归属单位总数
    * @param map	查询条件集合
    * @return
    */
    int getSysDataOwnerDeptCount(Map<String, String> map);

    /**
    * 新增数据归属单位
    * @param sysDataOwnerDept	数据归属单位
    * @param map	用户集合
    * @return
    */
    int sysDataOwnerDeptSave(SysDataOwnerDept sysDataOwnerDept, Map<String, String> map);

    /**
    * 修改数据归属单位
    * @param sysDataOwnerDept	数据归属单位
    * @param map	用户集合
    * @return
    */
    int sysDataOwnerDeptUpdate(SysDataOwnerDept sysDataOwnerDept, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param dataOwnerDeptId
    * @return
    */
    SysDataOwnerDept getSysDataOwnerDept(String dataOwnerDeptId);

    /**
    * 根据主键ID删除规则信息
    * @param dataOwnerDeptId
    * @return
    */
    int sysDataOwnerDeptDelete(String[] dataOwnerDeptId);

    SysDataOwnerDept selectByDeptId(String deptId);
}
