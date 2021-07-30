package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.po.ZzjbjBjxx;
import com.pkusoft.jjpt.req.ZzjbjBjxxReqParam;
import com.pkusoft.jjpt.res.Ybjxx;

import java.util.List;
import java.util.Map;


public interface ZzjbjBjxxService {

    /**
    * 查询微信自助报警-报警信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<ZzjbjBjxx> getZzjbjBjxxList(ZzjbjBjxxReqParam zzjbjBjxxReqParam,Map<String, String> map);

    /**
     * 查询微信自助报警-报警信息表总数
     * @param map	查询条件集合
     * @return
     */
    int getZzjbjBjxxCount(ZzjbjBjxxReqParam zzjbjBjxxReqParam,Map<String, String> map);


    /**
     * 查询微信自助报警-报警信息表集合
     * @param map	查询条件集合
     * @return
     */
    List<ZzjbjBjxx> getScreenZzjbjBjxxList(Map<String, String> map, String ifAccept);

    /**
     * 接警大屏-预报警信息列表
     * @param map
     * @return
     */
    List<Ybjxx> getBigScreenYbjxxList(Map<String, String> map);

    int updateAcceptWechatAlarm(String bjdwdm, SpJjxx spJjxx);

    /**
     * 查询已闭环/未闭环的预报警数量
     * @return
     */
    int getZzjbjBjxxCountByHandleStatus(String HandleStatus,String deptId);

    /**
    * 新增微信自助报警-报警信息表
    * @param zzjbjBjxx	微信自助报警-报警信息表
    * @param map	用户集合
    * @return
    */
    int zzjbjBjxxSave(ZzjbjBjxx zzjbjBjxx, Map<String, String> map);

    /**
    * 修改微信自助报警-报警信息表
    * @param zzjbjBjxx	微信自助报警-报警信息表
    * @param map	用户集合
    * @return
    */
    int zzjbjBjxxUpdate(ZzjbjBjxx zzjbjBjxx, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param bjid
    * @return
    */
    ZzjbjBjxx getZzjbjBjxx(String bjid);

    /**
    * 根据主键ID删除规则信息
    * @param bjid
    * @return
    */
    int zzjbjBjxxDelete(String[] bjid);

}