package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.ZzjbjFjxx;

import java.util.List;
import java.util.Map;


public interface ZzjbjFjxxService {

    /**
    * 查询微信自助报警-附件信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<ZzjbjFjxx> getZzjbjFjxxList(Map<String, String> map);


    List<ZzjbjFjxx> getZzjbjFjxxByBjid(String bjid);

    /**
    * 查询微信自助报警-附件信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getZzjbjFjxxCount(Map<String, String> map);

    /**
    * 新增微信自助报警-附件信息表
    * @param zzjbjFjxx	微信自助报警-附件信息表
    * @param map	用户集合
    * @return
    */
    int zzjbjFjxxSave(ZzjbjFjxx zzjbjFjxx, Map<String, String> map);

    /**
    * 修改微信自助报警-附件信息表
    * @param zzjbjFjxx	微信自助报警-附件信息表
    * @param map	用户集合
    * @return
    */
    int zzjbjFjxxUpdate(ZzjbjFjxx zzjbjFjxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param fjbh
    * @return
    */
    ZzjbjFjxx getZzjbjFjxx(String fjbh);

    /**
    * 根据主键ID删除规则信息
    * @param fjbh
    * @return
    */
    int zzjbjFjxxDelete(String[] fjbh);

}