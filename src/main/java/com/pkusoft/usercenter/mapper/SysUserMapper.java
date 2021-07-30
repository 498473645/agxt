package com.pkusoft.usercenter.mapper;

import com.pkusoft.usercenter.po.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SysUserMapper extends Mapper<SysUser> {

	int updateSysUser(SysUser sysUser);
}
