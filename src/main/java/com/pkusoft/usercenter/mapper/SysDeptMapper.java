package com.pkusoft.usercenter.mapper;

import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.vo.DeptTree;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysDeptMapper extends Mapper<SysDept> {
	List<SysDept> getReleDeptListByParent(Map<String, Object> params);

	List<SysDept> getDeptListByOwnerDept(Map<String, String> map);

	List<SysDept> queryDeptList(Map<String, Object> params);

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

	List<DeptTree> getSysDeptList(@Param("deptLevel") String deptLevel, @Param("deptId") String deptId);
}
