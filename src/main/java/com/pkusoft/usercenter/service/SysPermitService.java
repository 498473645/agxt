package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysUser;
import pkubatis.common.utils.OrgData;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

public interface SysPermitService {

	/**
	 *  判断是否是案管员或法制员,是案管员就返回对应条件,不是就返回空,
	 * @param operId
	 * @return
	 */
	Map<String,Object> getSysRoleUserMapBySysRoleUser(String operId);

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

	SysUser getJobFileInfoListBySysRole(String idCard);
}
