package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysPermitMapper;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkubatis.common.utils.CodeUtils;
import pkubatis.common.utils.PermitType;
import pkubatis.toolkit.SpringContextHolder;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SysPermitServiceImpl implements SysPermitService {

    /**
     * 全部数据权限
     */
    public static final String DATA_SCOPE_ALL = "00";

    /**
     * 两位字符匹配__
     */
//	public static final String DATA_SCOPE_MATCHING = "__";
    public static final String FORMAT_STRING_ALL = "ORG_CODE like '%s%s' ";

    public static final String FORMAT_STRING = "ORG_CODE like '%s__' ";


  /*
  中兴写法 勿删
   public static final String FORMAT_STRING_ALIAS_ALL = " %s.ORG_CODE like '%s%s' ";

    public static final String FORMAT_STRING_ALIAS = " %s.ORG_CODE like '%s__' ";

    public static final String ADMIN_NO = "admin";

    public static final String ADMIN_ID = "1";
    */


    //拼接型sql语句查询 yv
    public static final String FORMAT_STRING_ALL_SPLICE = "%s%s";

    public static final String FORMAT_STRING_SPLICE = "%s__";


    @Autowired
    private SysPermitMapper sysPermitMapper;

    @Value(value = "${user-center-proxy.sys-id}")
    private String proxyId;

    @Autowired
    private SysDeptService sysDeptService ;


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
        //String permitValue = sysPermitMapper.getUserPermitValue(paraMap);
        //获取数据权限（新版本）
        String permitValue = sysPermitMapper.getUserOwnerRuleValue(paraMap);
        return permitValue;
    }

    /**
     * 通用数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitsType  数据权限类型 ( 100002--案件业务办理查询权限  100003--业务数据查询统计权限  100004--警情业务办理查询权限 100005--文件上传业务办理查询权限)
     */
  /*  @Override
    public void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType) {
        //查询当前登录人的权限级别
        //获取用户的查询权限（0-查询所有单位数据；1-查询所属省级及下级单位数据；2-查询所属县级以及下级单位数据；3-查询所属分局以及下级单位数据；4-查询所属派出所及其下级单位的单位数据；8-本单位办理的；9-本人办理的；）
        String permitValue = SpringContextHolder.getBean(SysPermitService.class).getUserPermitValue(user.get("userId"), permitsType);
        if (StringUtils.hasText(permitValue)) {
            //查询权限单位id
            String permitDeptId = sysDeptService.getDeptIdBypermit(user,permitValue);
            //判断是否有权限单位
            if (StringUtils.hasText(permitDeptId)) {
                switch (permitsType){
                    //案件业务办理查询权限
                    case PermitType.PERMIT_TYPE_CASE_QUERY:
                        setCaseDataPermits(criteria,user,permitValue,permitDeptId);
                        break;
                    //警情业务办理查询权限
                    case PermitType.PERMIT_TYPE_INCIDENT_QUERY:
                        setIncidentDataPermits(criteria, user, permitValue,permitDeptId);
                        break;
                    //业务数据查询统计权限
                    case PermitType.PERMIT_TYPE_COUNT_QUERY:
                        setStatisticDataPermits(criteria,user,permitValue,permitDeptId);
                        break;
                    //文件上传业务办理查询权限
                    case PermitType.PERMIT_TYPE_FILES_QUERY:
                        setFilesDataPermits(criteria,user,permitValue,permitDeptId);
                        break;
                    default:
                        break;
                }
            }else {//如果没有权限单位则查不出数据
                criteria.andEqualTo("objid","0");
            }
        }else {//如果没有权限则查不出数据
            criteria.andEqualTo("objid","0");
        }

    }
*/
    /**
     * 案件业务办理查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setCaseDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //默认查询启用的
        criteria.andEqualTo("rowStatus","2010");
        //循环判断对应权限
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                criteria.andEqualTo("stationLevel1", permitDeptId);
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("stationLevel2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("stationLevel3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("stationLevel4", permitDeptId);
                break;
            //所属单位数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人信息获取所属单位id
                criteria.andEqualTo("orgCode",user.get("deptId") );
                break;
            //查询所有数据
            default:
                break;
        }
    }

    /**
     * 警情业务办理查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setIncidentDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //默认查询启用的
        criteria.andEqualTo("rowStatus","2010");
        //循环判断对应权限
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                criteria.andEqualTo("stationLevel1", permitDeptId);
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("stationLevel2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("stationLevel3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("stationLevel4", permitDeptId);
                break;
            //所属单位数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人信息获取所属单位id
                criteria.andEqualTo("orgCode",user.get("deptId") );
                break;
            //查询所有数据
            default:
                break;
        }
    }

    public void setFilesDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId){
        //默认查询启用的
        criteria.andEqualTo("rowStatus","2010");
        //循环判断对应权限
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                criteria.andEqualTo("stationLevel1", permitDeptId);
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("stationLevel2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("stationLevel3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("stationLevel4", permitDeptId);
                break;
            //所属单位数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人信息获取所属单位idcriteria.andEqualTo("orgCode",user.get("deptId") );

                break;
            //查询所有数据
            default:
                break;
        }
    }
    /**
     * 业务办理数据查询权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setYwblDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //循环判断对应权限
        switch (permitValue){
            //本办案区业务数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人信息获取所属单位id
                criteria.andEqualTo("orgCode",user.get("deptId") );
                break;
            //本人业务数据查询权限--查询本办案区本人的
            case PermitType.PERMIT_VALUE_SOLO:
                //根据登录人警号查询警员表的所属办案区id
                //BdAreaPolice police1 = bdAreaPoliceService.getPoliceByPoliceCode(user.get("policeCode"));
                //if(StringUtils.hasText(police1.getObjid())){
                //    criteria.andEqualTo("areaObjid", police1.getAreaObjid());
                //}else{
                //    criteria.andEqualTo("areaObjid","0");
                //}
                ////根据人员信息查询
                //List<String> hObjidList = haPeopleService.selectByPoliceCode(user.get("policeCode"));
                ////只查询本人参与的案件
                //criteria.andIn("hObjid", hObjidList);
                break;
            default:
                break;
        }
    }


    /**
     * 业务数据查询统计权限
     * @param criteria   查询对象
     * @param user		  用户信息
     * @param permitValue  权限等级
     * @param permitDeptId 权限单位
     */
    public void setStatisticDataPermits(Example.Criteria criteria, Map<String, String> user, String permitValue , String permitDeptId) {
        //默认查询启用的
        criteria.andEqualTo("rowStatus","2010");
        //循环判断对应权限
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                criteria.andEqualTo("stationLevel1", permitDeptId);
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                criteria.andEqualTo("stationLevel2", permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                criteria.andEqualTo("stationLevel3", permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                criteria.andEqualTo("stationLevel4", permitDeptId);
                break;
            //所属单位数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人警号查询警员表的所属单位id
                criteria.andEqualTo("orgCode",user.get("deptId") );
                break;
            //查询所有数据
            default:
                break;
        }
    }

   /* *//**
     * 自写统计方法调用的权限类
     * @param params
     * @param user
     *//*
    public void setUserStatisticPermits(Map<String, Object> params, Map<String, String> user) {
        //查询当前登录人的权限级别
        //获取用户的查询权限（0-查询所有单位数据；1-查询所属省级及下级单位数据；2-查询所属县级以及下级单位数据；3-查询所属分局以及下级单位数据；4-查询所属派出所及其下级单位的单位数据；8-本单位办理的；9-本人办理的；）
        String permitValue = SpringContextHolder.getBean(SysPermitService.class).getUserPermitValue(user.get("userId"),PermitType.PERMIT_TYPE_COUNT_QUERY);
        if (StringUtils.hasText(permitValue)) {
            //查询权限单位id
            String permitDeptId = sysDeptService.getDeptIdBypermit(user,permitValue);
            //判断是否有权限单位
            if (StringUtils.hasText(permitDeptId)) {
                setStatisticDataPermitsByParams(params,user,permitValue,permitDeptId);
            }else {//如果没有权限单位则查不出数据
                params.put("orgCode","0");
            }
        }else {//如果没有权限则查不出数据
            params.put("orgCode","0");
        }

    } */

    public void setStatisticDataPermitsByParams(Map<String, Object> params, Map<String, String> user, String permitValue , String permitDeptId) {
        //循环判断对应权限
        switch (permitValue){
            //省级单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_1:
                params.put("stationLevel1",permitDeptId);
                break;
            //市局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_2:
                params.put("stationLevel2",permitDeptId);
                break;
            //分局单位数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_3:
                params.put("stationLevel3",permitDeptId);
                break;
            //派出所数据查询权限
            case PermitType.PERMIT_VALUE_DEPT_4:
                params.put("stationLevel4",permitDeptId);
                break;
            //所属单位数据查询权限
            case PermitType.PERMIT_VALUE_AREA:
                //根据登录人警号查询警员表的所属单位id
                params.put("orgCode",user.get("deptId"));
                break;
            //查询所有数据
            default:
                break;
        }
    }


    //新权限方法


    @Override
    public void setUserDataPermits(Example.Criteria criteria, Map<String, String> user, String permitsType) {
        String sql = this.getUserDataPermitsSql(user);
        criteria.andCondition(sql);
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
        String permitValue = SpringContextHolder.getBean(SysPermitService.class).getUserPermitValue(user.get("userId"), permitsType);
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

    @Override
    public String getUserDataPermitsSql(Map<String, String> user) {
        StringBuilder sqlString = new StringBuilder();
        /* if(user.get("userName").equals(ADMIN_NO)||user.get("userName").equals(ADMIN_ID)) {
            criteria.andEqualTo("objid","0");
        } */
        String dataScope = user.get("deptId");
        String policeClassify = CodeUtils.getPoliceClassifyCode(dataScope);
        String last4 = CodeUtils.getLast4Character(dataScope);
        if (DATA_SCOPE_ALL.equals(policeClassify)) {
            sqlString.append(String.format(FORMAT_STRING_ALL, StringUtils.substringBefore(dataScope, last4),"%"));
        } else {
            sqlString.append(String.format(FORMAT_STRING, StringUtils.substringBeforeLast(dataScope, last4) +"%"+ policeClassify));
        }
        String sql = sqlString.toString();
        return  sql;
    }


    public void setUserStatisticPermits(Map<String, Object> params, Map<String, String> user) {
        //根据user 获取其查询条件
        String sqlValue = setValuePermits(user);
        params.put("orgCode",sqlValue);
    }


    @Override
    public void setDeptStatisticPermits(Map<String, String> params, Map<String, String> user) {
        String sqlValue = setValuePermits(user);
        params.put("deptId",sqlValue);
    }


    /**
     * 权限获取方法
     * @param user
     * @return
     */
    private String setValuePermits(Map<String,String> user){
        String dataScope = user.get("deptId");
        String policeClassify = CodeUtils.getPoliceClassifyCode(dataScope);
        String last4 = CodeUtils.getLast4Character(dataScope);
        if (DATA_SCOPE_ALL.equals(policeClassify)) {
            return String.format(FORMAT_STRING_ALL_SPLICE, StringUtils.substringBefore(dataScope, last4),"%");
        } else {
            return String.format(FORMAT_STRING_SPLICE, StringUtils.substringBeforeLast(dataScope, last4) +"%"+ policeClassify);
        }
    }
}
