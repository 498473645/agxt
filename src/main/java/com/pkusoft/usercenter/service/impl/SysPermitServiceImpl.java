package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysPermitMapper;
import com.pkusoft.usercenter.mapper.SysRoleMapper;
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

    @Autowired
    private SysRoleMapper sysRoleMapper;

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

    public SysUser getJobFileInfoListBySysRole(String operId){
        SysUser newSysUser = new SysUser();
        newSysUser.setIdcard(operId);
        SysUser sysUser= sysUserMapper.selectOne(newSysUser);
        if(null != sysUser){
            List<SysRoleUser> list = sysRoleUserService.getSysRoleUserListByUserId(sysUser.getUserId());
            for(int i=0;i<list.size();i++){
                SysRole newSysRole = new SysRole();
                newSysRole.setRoleId(list.get(i).getRoleId());
                SysRole sysRole = sysRoleMapper.selectOne(newSysRole);
                if(sysRole.getRoleName().endsWith("案管员")){
                    return sysUser;
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
