package com.pkusoft.lesp.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.req.KeAgAjztxxParam;
import com.pkusoft.usercenter.po.SysUser;

/**
* @author
* @title: KeAgAjztxxService
*/
public interface KeAgAjztxxService {

    /**
    * 查询案管-案件状态信息表集合
    * @param sysUser	查询条件集合
    * @return
    */
    List<KeAgAjztxx> getKeAgAjztxxList(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser);

    /**
    * 查询案管-案件状态信息表总数
    * @param sysUser	查询条件集合
    * @return
    */
    int getKeAgAjztxxCount(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser);

    /**
    * 新增案管-案件状态信息表
    * @param keAgAjztxx	案管-案件状态信息表
    * @param map	用户集合
    * @return
    */
    int keAgAjztxxSave(KeAgAjztxx keAgAjztxx, Map<String,String> map);

    /**
    * 修改案管-案件状态信息表
    * @param keAgAjztxx	案管-案件状态信息表
    * @param map	用户集合
    * @return
    */
    int keAgAjztxxUpdate(KeAgAjztxx keAgAjztxx, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param ajbh
    * @return
    */
    KeAgAjztxx getKeAgAjztxx(String ajbh);

    /**
    * 根据主键ID删除规则信息
    * @param ajbh
    * @return
    */
    int keAgAjztxxDelete(String ajbh);


    /**
     * 案管-案件状态信息表修改信息
     *
     * @param ajbh 案件编号
     * @param zt 状态
     * @param czyBh 操作人编号(身份证号/警号/ID)
     * @param czyXm 操作人姓名
     * @param index 等于1就修改状态1(建卷),等于2就修改状态2(采集)的数据.3(入柜),4(未使用)
     * @return 更新记录数
     */
    int updateKeAgAjztxx(String ajbh,String zt,String czyBh,String czyXm,int index);

}
