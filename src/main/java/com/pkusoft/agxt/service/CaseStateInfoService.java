package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CaseStateInfo;

/**
* @author
* @title: CaseStateInfoService
*/
public interface CaseStateInfoService {

    /**
    * 查询案件状态信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<CaseStateInfo> getCaseStateInfoList(Map<String, String> map);

    /**
    * 查询案件状态信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getCaseStateInfoCount(Map<String, String> map);

    /**
    * 新增案件状态信息表
    * @param caseStateInfo	案件状态信息表
    * @param map	用户集合
    * @return
    */
    int caseStateInfoSave(CaseStateInfo caseStateInfo, Map<String,String> map);

    /**
    * 修改案件状态信息表
    * @param caseStateInfo	案件状态信息表
    * @param map	用户集合
    * @return
    */
    int caseStateInfoUpdate(CaseStateInfo caseStateInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CaseStateInfo getCaseStateInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int caseStateInfoDelete(String id);

}
