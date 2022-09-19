package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CaseHandler;
import com.pkusoft.agxt.model.CaseInfo;
import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.UserInfo;

/**
* @author
* @title: CaseHandlerService
*/
public interface CaseHandlerService {

    /**
    * 查询案件办案人信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<CaseHandler> getCaseHandlerList(Map<String, String> map);

    /**
    * 查询案件办案人信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getCaseHandlerCount(Map<String, String> map);

    /**
    * 新增案件办案人信息表
    * @param caseHandler	案件办案人信息表
    * @param map	用户集合
    * @return
    */
    int caseHandlerSave(CaseHandler caseHandler, Map<String,String> map);

    /**
    * 修改案件办案人信息表
    * @param caseHandler	案件办案人信息表
    * @param map	用户集合
    * @return
    */
    int caseHandlerUpdate(CaseHandler caseHandler, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CaseHandler getCaseHandler(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int caseHandlerDelete(String id);

    /**
     * 案件办案人信息表删除信息
     *
     * @param ajbh
     * @return 删除记录数
     */
    int deleteJobCaseHandlerByAjbh(String ajbh);

    /**
     * 从执法监督平台(lesp_rs)库里查出案件信息把协办人存入agxt库里
     *
     * @return
     */
    void insertHandler(CaseInfo caseinfo, FileInfo jobFileInfo, UserInfo userInfo);
}
