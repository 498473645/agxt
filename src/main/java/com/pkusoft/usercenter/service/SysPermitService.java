package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysUser;
import pkubatis.common.utils.OrgData;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

public interface SysPermitService {

	/**
	 * 报案办事通用数据查询权限
	 * @param criteria   查询对象
	 * @param user		  用户信息
	 * @param permitsType  数据权限类型 ( 200001--报案办事基础数据查询权限)
	 */
	void setUserDataPermits(Example.Criteria criteria, SysUser user, String permitsType);

	/**
	 * 根据当前用户id和权限类型获取用户角色下的权限信息的值
	 * @param userId
	 * @param permitType
	 * @return
	 */
	String getUserPermitValue(String userId, String permitType);

	/**
	 *  判断是否是案管员,是案管员就返回对应条件,不是就返回空
	 * @param sysUser
	 * @return
	 */
	Map<String, Object> getSysRoleUserMapBySysRole(SysUser sysUser);

	/**
	 * 获取当前用户信息
	 *
	 * @param str(身份证号码或userid)
	 * @return OrgData
	 */
	OrgData userOrg(String str);

	/**
	 * 获取当前单位信息，无身份证号码（IdCard）信息。
	 *
	 * @param str(单位编号)
	 * @return OrgData
	 */
	OrgData deptOrg(String str);
}
