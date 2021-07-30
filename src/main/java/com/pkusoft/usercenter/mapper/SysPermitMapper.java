package com.pkusoft.usercenter.mapper;

import com.pkusoft.usercenter.po.SysPermit;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * 系统数据权限数据接口
 */
public interface SysPermitMapper extends Mapper<SysPermit> {
    /**
     * 根据当前用户id和权限类型获取用户角色下的权限信息的值
     * @param paraMap
     * @return
     */
    String getUserPermitValue(Map<String, String> paraMap);

    /**
     * 根据当前用户id和权限类型获取用户角色下的权限信息的值
     * @param paraMap
     * @return
     */
    String getUserOwnerRuleValue(Map<String, String> paraMap);

}
