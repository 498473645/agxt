package com.pkusoft.usercenter.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.usercenter.po.SysPara;

/**
* @author
* @title: SysParaService
*/
public interface SysParaService {

    /**
    * 查询系统参数表集合
    * @param map	查询条件集合
    * @return
    */
    List<SysPara> getSysParaList(Map<String, String> map);

    /**
    * 查询系统参数表总数
    * @param map	查询条件集合
    * @return
    */
    int getSysParaCount(Map<String, String> map);

    /**
    * 新增系统参数表
    * @param sysPara	系统参数表
    * @param map	用户集合
    * @return
    */
    int sysParaSave(SysPara sysPara, Map<String,String> map);

    /**
    * 修改系统参数表
    * @param sysPara	系统参数表
    * @param map	用户集合
    * @return
    */
    int sysParaUpdate(SysPara sysPara, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param paraCode
    * @return
    */
    SysPara getSysPara(String paraCode);

    /**
    * 根据主键ID删除规则信息
    * @param paraCode
    * @return
    */
    int sysParaDelete(String paraCode);

    /**
     * 查询参数
     * @param hadoopUrlNew
     * @return
     */
    SysPara getSysParaByParaCode(String hadoopUrlNew);
}
