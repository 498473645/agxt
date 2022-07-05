package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.SpPatrolProblem;
import com.pkusoft.jjpt.req.SpPatrolProblemReqParam;

import java.util.List;
import java.util.Map;


/**
* @author
* @title: SpPatrolProblemService
*/
public interface SpPatrolProblemService {

    /**
    * 查询巡查问题信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<SpPatrolProblem> getSpPatrolProblemList(SpPatrolProblemReqParam spPatrolProblemReqParam, Map<String, String> map);

    /**
    * 查询巡查问题信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getSpPatrolProblemCount(SpPatrolProblemReqParam spPatrolProblemReqParam, Map<String, String> map);

    /**
    * 新增巡查问题信息表
    * @param spPatrolProblem	巡查问题信息表
    * @param map	用户集合
    * @return
    */
    int spPatrolProblemSave(SpPatrolProblem spPatrolProblem, Map<String,String> map);

    /**
    * 修改巡查问题信息表
    * @param spPatrolProblem	巡查问题信息表
    * @param map	用户集合
    * @return
    */
    int spPatrolProblemUpdate(SpPatrolProblem spPatrolProblem, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param objid
    * @return
    */
    SpPatrolProblem getSpPatrolProblem(String objid);

    /**
    * 根据主键ID删除规则信息
    * @param objid
    * @return
    */
    int spPatrolProblemDelete(String objid);

}
