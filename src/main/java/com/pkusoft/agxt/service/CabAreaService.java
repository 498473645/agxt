package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabArea;
import com.pkusoft.agxt.req.CabAreaParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: CabAreaService
*/
public interface CabAreaService {

    /**
    * 查询案卷柜区域信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<CabAreaParam> getCabAreaParamList(CabAreaParam cabAreaParam, SysUser sysUser);

    /**
    * 查询案卷柜区域信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getCabAreaParamCount(CabAreaParam cabAreaParam, SysUser sysUser);

    /**
    * 新增案卷柜区域信息表
    * @param cabArea	案卷柜区域信息表
    * @param sysUser	用户集合
    * @return
    */
    int cabAreaSave(CabArea cabArea, SysUser sysUser);

    /**
    * 修改案卷柜区域信息表
    * @param cabArea	案卷柜区域信息表
    * @param sysUser	用户集合
    * @return
    */
    int cabAreaUpdate(CabArea cabArea, SysUser sysUser);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CabArea getCabArea(String id);

    /**
    * 根据主键ID删除规则信息
    * @param ids
    * @return
    */
    int cabAreaDelete(String[] ids);

}
