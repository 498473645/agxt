package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysDept;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;


public interface SysDeptService {

    /**
    * 查询部门表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysDept> getSysDeptList(Map<String, String> map);

    /**
    * 查询部门表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysDeptCount(Map<String, String> map);

    /**
    * 新增部门表
    * @param sysDept	部门表
    * @param map	用户集合
    * @return
    */
    int sysDeptSave(SysDept sysDept, Map<String, String> map);

    /**
    * 修改部门表
    * @param sysDept	部门表
    * @param map	用户集合
    * @return
    */
    int sysDeptUpdate(SysDept sysDept, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param deptId
    * @return
    */
    SysDept getSysDept(String deptId);

    /**
    * 根据主键ID删除规则信息
    * @param deptId
    * @return
    */
    int sysDeptDelete(String[] deptId);

    /**
     * 根据条件筛选单位信息
     * @param example
     * @return
     */
	List<SysDept> selectSysDeptListByExample(Example example);

	/**
	 * 根据map筛选单位信息
	 * @param params
	 * @return
	 */
	List<SysDept> selectSysDeptListByMap(Map<String, Object> params);

	/**
	 * 根据实体中的参数查询
	 * @param sysDept
	 * @return
	 */
	List<SysDept> selectSysDeptList(SysDept sysDept);

	/**
	 * 根据用户权限等级查询单位id
	 * @param user
	 * @param permitValue
	 * @return
	 */
	String getDeptIdBypermit(Map<String, String> user, String permitValue);

	/**
	 * 根据用户权限等级id查询单位列表
	 * @param permitDeptId
	 * @return
	 */
	List<SysDept> selectSysDeptList(String permitDeptId);
	List<SysDept> getAllSysDeptList();
	List<SysDept> getDeptListByOwnerDept(SysDept dept);

	List<SysDept> getDeptList(Map<String, String> user, String deptLevel);

	/**
	 * 获取下级归属单位信息和当前单位信息
	 * @param deptId
	 * @return
	 */
	List<SysDept> getParentDeptId(String deptId);

	/**
	 * 获取下级归属单位信息
	 * @param deptId
	 * @return
	 */
	List<SysDept> getOnlyParentDeptId(String deptId);
}
