package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CaseOrg;

/**
* @author
* @title: CaseOrgService
*/
public interface CaseOrgService {

    /**
    * 查询涉案单位表集合
    * @param map	查询条件集合
    * @return
    */
    List<CaseOrg> getCaseOrgList(Map<String, String> map);

    /**
    * 查询涉案单位表总数
    * @param map	查询条件集合
    * @return
    */
    int getCaseOrgCount(Map<String, String> map);

    /**
    * 新增涉案单位表
    * @param caseOrg	涉案单位表
    * @param map	用户集合
    * @return
    */
    int caseOrgSave(CaseOrg caseOrg, Map<String,String> map);

    /**
    * 修改涉案单位表
    * @param caseOrg	涉案单位表
    * @param map	用户集合
    * @return
    */
    int caseOrgUpdate(CaseOrg caseOrg, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CaseOrg getCaseOrg(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int caseOrgDelete(String id);

    /**
     * 涉案单位表删除信息
     *
     * @param ajbh
     * @return 删除记录数
     */
    int deleteJobCaseOrgByAjbh(String ajbh);
}
