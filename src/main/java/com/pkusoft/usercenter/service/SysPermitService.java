package com.pkusoft.usercenter.service;

import tk.mybatis.mapper.entity.Example;

import java.util.Map;

public interface SysPermitService {

    /**
     * 根据当前用户id和权限类型获取用户角色下的权限信息的值
     * @param userId
     * @param permitType
     * @return
     */
   String getUserPermitValue(String userId, String permitType);

	/**
	 * 通用数据查询权限
	 * @param criteria   查询对象
	 * @param user		  用户信息
	 * @param permitsType  数据权限类型 ( 100002--案件业务办理查询权限  100003--业务数据查询统计权限  100004--警情业务办理查询权限 100005--文件上传业务办理查询权限)
	 */
   //void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType);

	//获取人员拼接权限
   void setUserStatisticPermits(Map<String, Object> params, Map<String, String> user);


	//获取权限
	void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType);

	Map<String,String> setUserDataPermits(Map<String, String> user, String permitsType);



	//根据用户权限获取拼接好的sql
	String getUserDataPermitsSql(Map<String, String> user);

	//获取单位拼接权限
	void setDeptStatisticPermits(Map<String, String> params, Map<String, String> user);

}
