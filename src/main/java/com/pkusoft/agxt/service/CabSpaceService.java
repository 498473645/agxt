package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: CabSpaceService
*/
public interface CabSpaceService {

    /**
    * 查询案卷柜空间信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<CabSpace> getCabSpaceList(CabSpaceParam cabSpaceParam, SysUser sysUser);

    /**
    * 查询案卷柜空间信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getCabSpaceCount(CabSpaceParam cabSpaceParam, SysUser sysUser);

    /**
    * 新增案卷柜空间信息表
    * @param cabSpace	案卷柜空间信息表
    * @param map	用户集合
    * @return
    */
    int cabSpaceSave(CabSpace cabSpace, Map<String,String> map);

    /**
    * 修改案卷柜空间信息表
    * @param cabSpace	案卷柜空间信息表
    * @param map	用户集合
    * @return
    */
    int cabSpaceUpdate(CabSpace cabSpace, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabSpace getCabSpace(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int cabSpaceDelete(String id);

}
