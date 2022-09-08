package com.pkusoft.lesp.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.req.KeAgAjztxxParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: KeAgAjztxxService
*/
public interface KeAgAjztxxService {

    /**
    * 查询案管-案件状态信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<KeAgAjztxx> getKeAgAjztxxList(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser);

    /**
    * 查询案管-案件状态信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getKeAgAjztxxCount(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser);

    /**
    * 新增案管-案件状态信息表
    * @param keAgAjztxx	案管-案件状态信息表
    * @param map	用户集合
    * @return
    */
    int keAgAjztxxSave(KeAgAjztxx keAgAjztxx, Map<String,String> map);

    /**
    * 修改案管-案件状态信息表
    * @param keAgAjztxx	案管-案件状态信息表
    * @param map	用户集合
    * @return
    */
    int keAgAjztxxUpdate(KeAgAjztxx keAgAjztxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param ajbh
    * @return
    */
    KeAgAjztxx getKeAgAjztxx(String ajbh);

    /**
    * 根据主键ID删除规则信息
    * @param ajbh
    * @return
    */
    int keAgAjztxxDelete(String ajbh);

}
