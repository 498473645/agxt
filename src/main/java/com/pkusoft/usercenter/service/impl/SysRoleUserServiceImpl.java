package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysRoleUserMapper;
import com.pkusoft.usercenter.po.SysRoleUser;
import com.pkusoft.usercenter.service.SysRoleUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    public List<SysRoleUser> getSysRoleUserList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysRoleUser.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysRoleUserMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSysRoleUserCount(Map<String, String> map) {

        Example example = new Example(SysRoleUser.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysRoleUserMapper.selectCountByExample(example);
    }

    public SysRoleUser getSysRoleUser(Integer roleUserId){
        return sysRoleUserMapper.selectByPrimaryKey(roleUserId);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.pkusoft.admin.service.SysRoleUserService#getSysRoleUserListByUserId
     * (java.lang.Long)
     */
    public List<SysRoleUser> getSysRoleUserListByUserId(String userId) {
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setUserId(userId);
        List<SysRoleUser> roleUserList = sysRoleUserMapper.select(sysRoleUser);
        return roleUserList;
    }
}
