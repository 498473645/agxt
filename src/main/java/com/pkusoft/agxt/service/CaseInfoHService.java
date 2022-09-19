package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CaseInfo;
import com.pkusoft.agxt.model.CaseInfoH;

/**
* @author
* @title: CaseInfoHService
*/
public interface CaseInfoHService {

    /**
    * 查询案件历史信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<CaseInfoH> getCaseInfoHList(Map<String, String> map);

    /**
    * 查询案件历史信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getCaseInfoHCount(Map<String, String> map);

    /**
    * 新增案件历史信息表
    * @param caseInfoH	案件历史信息表
    * @param map	用户集合
    * @return
    */
    int caseInfoHSave(CaseInfoH caseInfoH, Map<String,String> map);

    /**
    * 修改案件历史信息表
    * @param caseInfoH	案件历史信息表
    * @param map	用户集合
    * @return
    */
    int caseInfoHUpdate(CaseInfoH caseInfoH, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param hisId
    * @return
    */
    CaseInfoH getCaseInfoH(String hisId);

    /**
    * 根据主键ID删除规则信息
    * @param hisId
    * @return
    */
    int caseInfoHDelete(String hisId);

    /**
     * 将案件信息表数据存入案件历史表
     * @param jobCaseInfo
     */
    void TemporalTable(CaseInfo jobCaseInfo);

}
