package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CasePerson;

/**
* @author
* @title: CasePersonService
*/
public interface CasePersonService {

    /**
    * 查询涉案人员表集合
    * @param map	查询条件集合
    * @return
    */
    List<CasePerson> getCasePersonList(Map<String, String> map);

    /**
    * 查询涉案人员表总数
    * @param map	查询条件集合
    * @return
    */
    int getCasePersonCount(Map<String, String> map);

    /**
    * 新增涉案人员表
    * @param casePerson	涉案人员表
    * @param map	用户集合
    * @return
    */
    int casePersonSave(CasePerson casePerson, Map<String,String> map);

    /**
    * 修改涉案人员表
    * @param casePerson	涉案人员表
    * @param map	用户集合
    * @return
    */
    int casePersonUpdate(CasePerson casePerson, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CasePerson getCasePerson(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int casePersonDelete(String id);

    /**
     * 涉案人员表删除信息
     *
     * @param ajbh
     * @return 删除记录数
     */
    int deleteJobCasePersonByAjbh(String ajbh);
}
