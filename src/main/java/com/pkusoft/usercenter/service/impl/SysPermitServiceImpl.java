package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysPermitMapper;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.PermitType;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SysPermitServiceImpl implements SysPermitService {

    @Autowired
    private SysPermitMapper sysPermitMapper;

    @Value(value = "${user-center-proxy.sys-id}")
    private String proxyId;

    @Autowired
    private SysDeptService sysDeptService ;

    @Autowired
    private SysPermitService sysPermitService;

    /**
     * 根据当前用户id和权限类型获取用户角色下的权限信息的值
     * @param userId
     * @param permitType
     * @return
     */
    @Override
    public String getUserPermitValue(String userId,String permitType){
        Map<String,String> paraMap = new HashMap<String,String>(2);
        paraMap.put("userId", userId);
        paraMap.put("permitType", permitType);
        paraMap.put("proxyId", proxyId);
        //获取数据权限
//        String permitValue = sysPermitMapper.getUserPermitValue(paraMap);
        //获取数据权限（新版本）
        String permitValue = sysPermitMapper.getUserOwnerRuleValue(paraMap);
        return permitValue;
    }

    /**
     * 要素库通用数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitsType  数据权限类型 ( 200001--办案区基础数据查询权限  200002--业务办理数据查询权限  300001--业务数据查询统计权限)
     */
    @Override
    public void setUserDataPermits(Example.Criteria criteria, SysUser user, String permitsType) {
        //查询当前登录人的权限级别
        //获取用户的查询权限（9-本人办理的；8-本办案区办理的；4-全派出所办理的；3-全分局办理的；2-全市局办理的）
        String permitValue = sysPermitService.getUserPermitValue(user.getUserId(), permitsType);
        if (StringUtils.hasText(permitValue)) {
            //查询权限单位id
            String permitDeptId = sysDeptService.getDeptIdBypermit(user,permitValue);
            //判断权限类型
            switch (permitsType){
                //办案区基础数据查询权限
                case "100002":
                    setBabsDataPermits(criteria,user,permitValue,permitDeptId);
                    break;
                default:
                    break;
            }
        }else {//如果没有权限则查不出数据
            criteria.andEqualTo("objid","0");
        }
    }
    /**
     * 要素库基础数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setBabsDataPermits(Example.Criteria criteria, SysUser user, String permitValue , String permitDeptId) {
        //循环判断对应权限
        switch (permitValue){
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("cstationid", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("sstationid", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("tstationid", permitDeptId);
                break;
            default:
                break;
        }
    }

}
