package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.ToolUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;



    public List<SysUser> getSysUserListByDept(String deptId) {

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if(!StringUtils.isEmpty(deptId)){
        	criteria.andEqualTo("deptId", deptId);
        }
        return sysUserMapper.selectByExample(example);
    }

    public SysUser getSysUser(String userId){
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    public List<SysUser> getSysUserListByCodeOrName(String policeCode, String userName){
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(policeCode)){
            criteria.andEqualTo("policeCode", policeCode);
        }
        if(!StringUtils.isEmpty(userName)){
            criteria.andEqualTo("userName", userName);
        }
        return sysUserMapper.selectByExample(example);
    }

    public List<SysUser> getSysUserListByCode(String search, String policeCode, Map<String, String> userMap){
        RowBounds rowBounds = new RowBounds(0,30);
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(ToolUtils.isNumber(search)){
            criteria.andLike("policeCode","%" + search + "%");
        }else{
            criteria.andLike("userName","%" + search + "%");
        }
        //排序
        example.orderBy("policeCode").asc();
        return sysUserMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public List<SysUser> selectSysUserListByExample(Example example) {
        return sysUserMapper.selectByExample(example);
    }
}
