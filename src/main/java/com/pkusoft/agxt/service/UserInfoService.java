package com.pkusoft.agxt.service;

import java.util.List;
import java.util.Map;

import com.pkusoft.agxt.model.UserInfo;

/**
* @author
* @title: UserInfoService
*/
public interface UserInfoService {

    /**
    * 查询用户信息表集合
    * @param map	查询条件集合
    * @return
    */
    List<UserInfo> getUserInfoList(Map<String, String> map);

    /**
    * 查询用户信息表总数
    * @param map	查询条件集合
    * @return
    */
    int getUserInfoCount(Map<String, String> map);

    /**
    * 新增用户信息表
    * @param userInfo	用户信息表
    * @param map	用户集合
    * @return
    */
    int userInfoSave(UserInfo userInfo, Map<String,String> map);

    /**
    * 修改用户信息表
    * @param userInfo	用户信息表
    * @param map	用户集合
    * @return
    */
    int userInfoUpdate(UserInfo userInfo, Map<String,String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    UserInfo getUserInfo(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int userInfoDelete(String id);

}
