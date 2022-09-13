package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabSpaceAct;
import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: CabSpaceActService
*/
public interface CabSpaceActService {

    /**
    * 查询案卷柜空间指令表集合C
    * @param cabSpaceActParam	查询条件集合
    * @return
    */
    List<CabSpaceAct> getCabSpaceActList(CabSpaceActParam cabSpaceActParam, SysUser sysUser);

    /**
    * 查询案卷柜空间指令表总数
    * @param cabSpaceActParam	查询条件集合
    * @return
    */
    int getCabSpaceActCount(CabSpaceActParam cabSpaceActParam, SysUser sysUser);

    /**
    * 新增案卷柜空间指令表
    * @param cabSpaceAct	案卷柜空间指令表
    * @param sysUser	用户集合
    * @return
    */
    int cabSpaceActSave(CabSpaceAct cabSpaceAct, SysUser sysUser);

    /**
    * 修改案卷柜空间指令表
    * @param cabSpaceAct	案卷柜空间指令表
    * @param sysUser	用户集合
    * @return
    */
    int cabSpaceActUpdate(CabSpaceAct cabSpaceAct, SysUser sysUser);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabSpaceAct getCabSpaceAct(String id);

    /**
    * 根据主键ID删除规则信息
    * @param ids
    * @return
    */
    int cabSpaceActDelete(String[] ids);

}
