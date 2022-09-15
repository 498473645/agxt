package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.OrgInfo;

/**
* @author
* @title: OrgInfoService
*/
public interface OrgInfoService {

    /**
    * 查询组织机构信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<OrgInfo> getOrgInfoList(Map<String, String> map);

    /**
    * 查询组织机构信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getOrgInfoCount(Map<String, String> map);

    /**
    * 新增组织机构信息表
    * @param orgInfo	组织机构信息表
    * @param map	用户集合
    * @return
    */
    int orgInfoSave(OrgInfo orgInfo, Map<String,String> map);

    /**
    * 修改组织机构信息表
    * @param orgInfo	组织机构信息表
    * @param map	用户集合
    * @return
    */
    int orgInfoUpdate(OrgInfo orgInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    OrgInfo getOrgInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int orgInfoDelete(String id);

}
