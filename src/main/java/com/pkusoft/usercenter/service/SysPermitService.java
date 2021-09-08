package com.pkusoft.usercenter.service;

import tk.mybatis.mapper.entity.Example;

import java.util.Map;

public interface SysPermitService {

	/**
	 * 报案办事通用数据查询权限
	 * @param criteria   查询对象
	 * @param user		  用户信息
	 * @param permitsType  数据权限类型 ( 200001--报案办事基础数据查询权限)
	 */
	void setUserDataPermitsBabs(Example.Criteria criteria, Map<String, String> user, String permitsType);


	/**
	 * 接报警通用数据查询权限
	 * @param criteria   查询对象
	 * @param user		  用户信息
	 * @param permitsType  数据权限类型 ( 200001--报案办事基础数据查询权限)
	 */
	void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType);

	Map<String,String> setUserDataPermits(Map<String, String> user, String permitsType);

	/**
	 * 根据当前用户id和权限类型获取用户角色下的权限信息的值
	 * @param userId
	 * @param permitType
	 * @return
	 */
	String getUserPermitValue(String userId, String permitType);

}
