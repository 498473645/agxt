package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabPlace;
import com.pkusoft.agxt.req.CabPlaceParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: CabPlaceService
*/
public interface CabPlaceService {

    /**
    * 查询案卷柜场所信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<CabPlace> getCabPlaceList(CabPlaceParam cabPlaceParam, SysUser sysUser);

    /**
    * 查询案卷柜场所信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getCabPlaceCount(CabPlaceParam cabPlaceParam, SysUser sysUser);

    /**
    * 新增案卷柜场所信息表
    * @param cabPlace	案卷柜场所信息表
    * @param sysUser	用户集合
    * @return
    */
    int cabPlaceSave(CabPlace cabPlace, SysUser sysUser);

    /**
    * 修改案卷柜场所信息表
    * @param cabPlace	案卷柜场所信息表
    * @param sysUser	用户集合
    * @return
    */
    int cabPlaceUpdate(CabPlace cabPlace, SysUser sysUser);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabPlace getCabPlace(String id);

    /**
    * 根据主键ID删除规则信息
    * @param ids
    * @return
    */
    int cabPlaceDelete(String[] ids);

}
