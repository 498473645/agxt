package com.pkusoft.usercenter.service;

import com.pkusoft.usercenter.po.SysUser;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


public interface SysUserService {

    /**
    * 通过部门id查询用户信息
    * @param deptId	 部门id
    * @return
    */
    List<SysUser> getSysUserListByDept(String deptId);

    /**
     * 根据主键ID查看用户信息详情
     * @param userId
     * @return
     */
    SysUser getSysUser(String userId);

    List<SysUser> getSysUserListByCodeOrName(String policeCode, String userName);

    List<SysUser> getSysUserListByCode(String search, String policeCode, Map<String, String> userMap);

    /**
     * 根据筛选条件选着用户
     * @param example
     * @return
     */
    List<SysUser> selectSysUserListByExample(Example example);

    SysUser getCurrentUser(HttpServletRequest request);
}
