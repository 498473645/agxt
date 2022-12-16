package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CabArea;
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
    List<CabSpaceParam> getCabSpaceParamList(CabSpaceParam cabSpaceParam, SysUser sysUser);

    /**
     * 查询案卷柜空间信息表总数
     * @param sysUser	查询条件集合
     * @return
     */
    int getCabSpaceParamCount(CabSpaceParam cabSpaceParam, SysUser sysUser);

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
    * @param sysUser	用户集合
    * @return
    */
    int cabSpaceSave(CabSpace cabSpace, String ip,String port, SysUser sysUser);

    /**
    * 修改案卷柜空间信息表
    * @param cabSpace	案卷柜空间信息表
    * @param sysUser	用户集合
    * @return
    */
    int cabSpaceUpdate(CabSpace cabSpace, SysUser sysUser);

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

    void updateByAreaId(CabArea cabArea, SysUser sysUser);

    /**
     * 查询案管人像SID+code(人像柜中SID+code必须唯一)
     * @param reserve1
     * @param code
     * @return
     */
    List<CabSpace> getJobCabSpaceByreserve1(String reserve1,String code,String orgCode);

    List<CabSpace> getJobCabSpaceBySnAndGroupCode(Double sn, String groupCode,String areaId);

    String batchInsertCabSpace(CabSpaceParam cabSpaceParam, SysUser sysUser);

    int insertJobCabSpaceW(CabSpace jobCabSpace, String ip, String port, SysUser user);

    int deleteJobCabSpace(String[] id);
}
