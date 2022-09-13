package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysPermitMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.*;
import com.pkusoft.usercenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.OrgData;
import pkubatis.common.utils.PermitType;
import pkubatis.common.utils.UserUtil;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private SysRoleUserService sysRoleUserService;

    @Autowired
    private SysRoleService sysRoleService;

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

    //判断是否是案管员,是案管员就返回对应条件,不是就返回空
    public Map<String, Object> getSysRoleUserMapBySysRole(SysUser sysUser) {
        OrgData orgData = userOrg(sysUser.getIdcard());
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> roleIdList = new ArrayList<String>();
        int number = 0;//返回最大的角色
        if (null != sysUser) {
            List<SysRoleUser> list = sysRoleUserService.getSysRoleUserListByUserId(sysUser.getUserId());
            for (int i = 0; i < list.size(); i++) {
                roleIdList.add(String.valueOf(list.get(i).getRoleId()));
            }
            if (roleIdList.size() > 0) {
                List<SysRole> sysRoleList = sysRoleService.getSysRoleListByRoleIdList(roleIdList);
                for (int i = 0; i < sysRoleList.size(); i++) {
                    SysRole sysRole = sysRoleList.get(i);
                    if (sysRole.getRoleName().equals("市局案管员") || sysRole.getRoleName().equals("市局案审员")) {
                        if (number < 3) {//找最大的角色
                            number = 3;
                        }
                    } else if (sysRole.getRoleName().equals("分局案管员") || sysRole.getRoleName().equals("分局案审员")) {
                        if (number < 2) {
                            number = 2;
                        }
                    } else if (sysRole.getRoleName().equals("派出所案管员")) {
                        if (number < 1) {
                            number = 1;
                        }
                    }
                }
                if (number != 0) {
                    if (number == 3) {
                        map.put("orgCData", orgData.getOrgCData());
                        map.put("deptId", orgData.getDeptId());
                        return map;
                    } else if (number == 2) {
                        map.put("orgSData", orgData.getOrgSData());
                        map.put("deptId", orgData.getDeptId());
                        return map;
                    } else if (number == 1) {
                        map.put("orgTData", orgData.getOrgTData());
                        map.put("deptId", orgData.getDeptId());
                        return map;
                    }
                }
            }
        }
        return null;
    }

    /**
     * 获取当前用户信息
     *
     * @param str(身份证号码或userid)
     * @return OrgData
     */
    public OrgData userOrg(String str) {
        OrgData orgData = new OrgData();
//    String matchString2 = "^[1-9]\\d{5}[1-9]\\d{3}((0[1-9])||(1[0-2]))((0[1-9])||(1\\d)||(2\\d)||(3[0-1]))\\d{3}([0-9]||X||x)$";
        SysUser sysUser = new SysUser();
//    if(str.matches(matchString2)){//传值为身份证号码
        Pattern pattern = null;
        boolean bo = false;
        if (str.length() == 18) {
            bo = UserUtil.checkId(str);
        } else if (str.length() == 15) {
            pattern = Pattern.compile("^(\\d{8}(0[1-9]|1[12])(0[1-9]|[12]\\d|3[01])\\d{3})$");
            Matcher m = pattern.matcher(str);
            bo = m.matches();
        }
        if (bo) {//传值为身份证号码
            Example example = new Example(SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("idcard", str);
            List<SysUser> list = sysUserService.selectSysUserListByExample(example);
            if (list.size() == 1) {
                sysUser = list.get(0);
            } else if (list.size() == 0) {
                orgData.setErrorMessage("未查询到用户信息(身份证号:" + str + ")！");
                return orgData;
            } else {
                orgData.setErrorMessage("查询到多个用户信息(身份证号:" + str + ")！");
                return orgData;
            }
        } else {//传值为userId
            sysUser = sysUserMapper.selectByPrimaryKey(str);
        }
        //SysDept sysDept=WebUtils.getBean(SysDeptService.class).get(sysUser.getDeptId());
        if (sysUser != null) {
            orgData = deptOrg(sysUser.getDeptId());
            orgData.setIdCard(sysUser.getIdcard());
            orgData.setPoliceCode(sysUser.getPoliceCode());
            orgData.setUserName(sysUser.getUserName());
        }

    /*orgData.setDeptName(sysDept.getDeptName());
    orgData.setDeptId(sysDept.getDeptId());
    orgData.setOrgC(sysDept.getCunitid());
    orgData.setOrgS(sysDept.getSunitid());
    orgData.setOrgT(sysDept.getTunitid());
    orgData.setOrgCData(sysDept.getDataCunitid());
    orgData.setOrgSData(sysDept.getDataSunitid());
    orgData.setOrgTData(sysDept.getDataTunitid());
    orgData.setIdCard(sysUser.getIdcard());*/
        return orgData;
    }

    /**
     * 获取当前单位信息，无身份证号码（IdCard）信息。
     *
     * @param str(单位编号)
     * @return OrgData
     */
    public OrgData deptOrg(String str) {
        OrgData orgData = new OrgData();

        SysDept newSysDept = new SysDept();
        newSysDept.setDeptId(str);
        SysDept sysDept = sysDeptMapper.selectOne(newSysDept);
        orgData.setDeptName(sysDept.getDeptName());
        orgData.setDeptId(sysDept.getDeptId());
        orgData.setOrgC(sysDept.getCunitid());
        orgData.setOrgS(sysDept.getSunitid());
        orgData.setOrgT(sysDept.getTunitid());
        orgData.setOrgCData(sysDept.getDataCunitid());
        orgData.setOrgSData(sysDept.getDataSunitid());
        orgData.setOrgTData(sysDept.getDataTunitid());

        return orgData;
    }


}
