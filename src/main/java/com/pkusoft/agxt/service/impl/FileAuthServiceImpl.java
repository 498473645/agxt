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

import com.pkusoft.agxt.model.FileAuth;
import com.pkusoft.agxt.service.FileAuthService;
import com.pkusoft.agxt.mapper.FileAuthMapper;

@Service
@Transactional
public class FileAuthServiceImpl implements FileAuthService {

    @Autowired
    private FileAuthMapper fileAuthMapper;

    public List<FileAuth> getFileAuthList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileAuth.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileAuthMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileAuthCount(Map<String, String> map) {

        Example example = new Example(FileAuth.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileAuthMapper.selectCountByExample(example);
    }

    public int fileAuthSave(FileAuth fileAuth, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileAuth.setId(id);
        int num = fileAuthMapper.insertSelective(fileAuth);
        return num;
    }

    public int fileAuthUpdate(FileAuth fileAuth, Map<String,String> map){
        int num = fileAuthMapper.updateByPrimaryKeySelective(fileAuth);
        return num;
    }

    public FileAuth getFileAuth(String id){
        return fileAuthMapper.selectByPrimaryKey(id);
    }

    public int fileAuthDelete(String id){
        int num = fileAuthMapper.deleteByPrimaryKey(id);
        return num;
    }

}
