package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysPermitMapper;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.po.SysDept;
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

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

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
     * 通用数据查询权限
     * @param user		  用户信息
     * @param permitsType  数据权限类型 ( 100002--案件业务办理查询权限  100003--业务数据查询统计权限  100004--警情业务办理查询权限 100005--文件上传业务办理查询权限)
     */
    @Override
    public Map<String,String> setUserDataPermits(Map<String, String> user, String permitsType) {
        Map<String,String> retData = new HashMap<>();
        //查询当前登录人的权限级别
        //获取用户的查询权限（0-查询所有单位数据；1-查询所属省级及下级单位数据；2-查询所属县级以及下级单位数据；3-查询所属分局以及下级单位数据；4-查询所属派出所及其下级单位的单位数据；8-本单位办理的；9-本人办理的；）
        String permitValue = sysPermitService.getUserPermitValue(user.get("userId"), permitsType);
        if (org.springframework.util.StringUtils.hasText(permitValue)) {
            //查询权限单位id
            String permitDeptId = sysDeptService.getDeptIdBypermit(user,permitValue);
            //判断是否有权限单位
            if (org.springframework.util.StringUtils.hasText(permitDeptId)) {
                retData.put("level",permitValue);
                retData.put("deptId",permitDeptId);
            }else {//如果没有权限单位则查不出数据
                retData.put("level","");
                retData.put("deptId","");
            }
        }else {//如果没有权限则查不出数据
            retData.put("level","");
            retData.put("deptId","");
        }
        return retData;
    }

    /**
     * 报案办事通用数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitsType  数据权限类型 ( 200001--办案区基础数据查询权限  200002--业务办理数据查询权限  300001--业务数据查询统计权限)
     */
    @Override
    public void setUserDataPermitsBabs(Example.Criteria criteria, Map<String, String> user, String permitsType) {
        //查询当前登录人的权限级别
        //获取用户的查询权限（9-本人办理的；8-本办案区办理的；4-全派出所办理的；3-全分局办理的；2-全市局办理的）
//        String permitValue = SpringContextHolder.getBean(SysPermitService.class).getUserPermitValue(user.get("userId"), permitsType);
        String permitValue ="2";
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
     * 办案区基础数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setBabsDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //默认查询启用的
//        criteria.andEqualTo("rowStatus","1");
        //循环判断对应权限
        switch (permitValue){
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("ownOrg2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("ownOrg3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("ownOrg4", permitDeptId);
                break;
            //所属办案区数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人警号查询警员表的所属单位id
                String orgCode = "0";
                SysDept dept = sysDeptService.getSysDept(user.get("deptId"));
                if (null!=dept||dept.getDeptId()!=null){
                    orgCode = dept.getDeptId();
                }
                criteria.andEqualTo("orgCode",orgCode );
                break;
            default:
                break;
        }
    }

    /**
     * 报案办事通用数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitsType  数据权限类型 ( 200001--办案区基础数据查询权限  200002--业务办理数据查询权限  300001--业务数据查询统计权限)
     */
    @Override
    public void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType) {
        //查询当前登录人的权限级别
        //获取用户的查询权限（9-本人办理的；8-本办案区办理的；4-全派出所办理的；3-全分局办理的；2-全市局办理的）
//        String permitValue = SpringContextHolder.getBean(SysPermitService.class).getUserPermitValue(user.get("userId"), permitsType);
        String permitValue ="2";
        if (StringUtils.hasText(permitValue)) {
            //查询权限单位id
            String permitDeptId = sysDeptService.getDeptIdBypermit(user,permitValue);
            //判断权限类型
            switch (permitsType){
                //办案区基础数据查询权限
                case "100002":
                    setJbjDataPermits(criteria,user,permitValue,permitDeptId);
                    break;
                default:
                    break;
            }
        }else {//如果没有权限则查不出数据
            criteria.andEqualTo("objid","0");
        }
    }
    /**
     * 办案区基础数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setJbjDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //默认查询启用的
//        criteria.andEqualTo("rowStatus","1");
        //循环判断对应权限
        switch (permitValue){
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("gaOwnerDept2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("gaOwnerDept3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("gaOwnerDept4", permitDeptId);
                break;
            //所属办案区数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人警号查询警员表的所属单位id
                String orgCode = "0";
                SysDept dept = sysDeptService.getSysDept(user.get("deptId"));
                if (null!=dept||dept.getDeptId()!=null){
                    orgCode = dept.getDeptId();
                }
                criteria.andEqualTo("orgCode",orgCode );
                break;
            default:
                break;
        }
    }

    /**
     * 报案办事监督当前用户角色数据权限
     * @param criteria    	查询条件
     * @param sysUser		用户信息
     * @param permitsType 	权限类型
     */
    @Override
    public void setUserDataPermits_2(Example.Criteria criteria, Map<String, String> sysUser, String permitsType)  {
        try {
            //查询当前用户角色数据权限
            String permitValue = getUserPermitValue(sysUser.get("userId"), permitsType);
            if(StringUtils.hasText(permitValue)){
                String deptId = this.getDeptIdBypermit(sysUser,permitValue);
                switch (permitsType) {
                    case PermitType.PERMITTYPE_100002:
                        setAjxxDataPermits(criteria, sysUser, deptId, permitValue);
                        break;
                    default:
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("查询当前用户角色数据权限错误");
        }
    }

    public String getDeptIdBypermit(Map<String, String> sysUser, String permitValue) throws IOException {
        String deptId = "";
        //1.根据登录人及权限等级查询权限部门id,根据用户所属部门查询数据归属单位表
        SysDataOwnerDept owner = sysDataOwnerDeptService.selectByDeptId(sysUser.get("deptId"));
        if (owner==null){
            return deptId;
        }
        //循环判断对应权限所属部门
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                deptId = owner.getOwnerDept1();
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                deptId = owner.getOwnerDept2();
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                deptId = owner.getOwnerDept3();
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                deptId = owner.getOwnerDept4();
                break;
            //所属办案区数据查询权限及本人数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                deptId = owner.getOwnerDept5();
                break;
        }
        return deptId;
    }

    public void setAjxxDataPermits(Example.Criteria criteria,Map<String, String> sysUser, String deptId, String permitValue) {
        //判断是否有权限单位
        if (StringUtils.hasText(deptId)) {
            switch (permitValue){
                //省级单位数据查询权限
                case PermitType.PERMIT_VALUE_DEPT_1:
                    criteria.andEqualTo("gaOwnerDept1", deptId);
                    break;
                //市局单位数据查询权限
                case PermitType.PERMIT_VALUE_DEPT_2:
                    criteria.andEqualTo("gaOwnerDept2", deptId);
                    break;
                //分局单位数据查询权限
                case PermitType.PERMIT_VALUE_DEPT_3:
                    criteria.andEqualTo("gaOwnerDept3", deptId);
                    break;
                //派出所数据查询权限
                case PermitType.PERMIT_VALUE_DEPT_4:
                    criteria.andEqualTo("gaOwnerDept4", deptId);
                    break;
                //本办案区办理的
                case PermitType.PERMIT_VALUE_AREA:
                    criteria.andEqualTo("gaOwnerDept5", deptId);
                    break;
                //查询所有数据
                default:
                    break;
            }
        }else {//如果没有权限则查不出数据
            criteria.andEqualTo("id","0");
        }
    }
}
