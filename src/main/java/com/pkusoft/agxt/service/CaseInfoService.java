package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.CaseInfo;
import com.pkusoft.agxt.req.CaseInfoParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: CaseInfoService
*/
public interface CaseInfoService {

    /**
    * 查询案件信息表集合
    * @param user	查询条件集合
    * @return
    */
    List<CaseInfo> getCaseInfoList(CaseInfoParam caseInfo,  SysUser user);

    /**
    * 查询案件信息表总数
    * @param user	查询条件集合
    * @return
    */
    int getCaseInfoCount(CaseInfoParam caseInfo, SysUser user);

    /**
    * 新增案件信息表
    * @param caseInfo	案件信息表
    * @param map	用户集合
    * @return
    */
    int caseInfoSave(CaseInfo caseInfo, Map<String,String> map);

    /**
    * 修改案件信息表
    * @param caseInfo	案件信息表
    * @param map	用户集合
    * @return
    */
    int caseInfoUpdate(CaseInfo caseInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    CaseInfo getCaseInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int caseInfoDelete(String id);

}
