package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.UserInfo;
import com.pkusoft.agxt.service.UserInfoService;
import com.pkusoft.agxt.mapper.UserInfoMapper;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getUserInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return userInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getUserInfoCount(Map<String, String> map) {

        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return userInfoMapper.selectCountByExample(example);
    }

    public int userInfoSave(UserInfo userInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        userInfo.setId(id);
        int num = userInfoMapper.insertSelective(userInfo);
        return num;
    }

    public int userInfoUpdate(UserInfo userInfo, Map<String,String> map){
        int num = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return num;
    }

    public UserInfo getUserInfo(String id){
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public int userInfoDelete(String id){
        int num = userInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

}
