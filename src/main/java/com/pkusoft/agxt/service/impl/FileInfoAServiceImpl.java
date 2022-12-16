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

import com.pkusoft.agxt.model.FileInfoA;
import com.pkusoft.agxt.service.FileInfoAService;
import com.pkusoft.agxt.mapper.FileInfoAMapper;

@Service
@Transactional
public class FileInfoAServiceImpl implements FileInfoAService {

    @Autowired
    private FileInfoAMapper fileInfoAMapper;

    public List<FileInfoA> getFileInfoAList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileInfoA.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoAMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileInfoACount(Map<String, String> map) {

        Example example = new Example(FileInfoA.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoAMapper.selectCountByExample(example);
    }

    public int fileInfoASave(FileInfoA fileInfoA, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileInfoA.setId(id);
        int num = fileInfoAMapper.insertSelective(fileInfoA);
        return num;
    }

    public int fileInfoAUpdate(FileInfoA fileInfoA, Map<String,String> map){
        int num = fileInfoAMapper.updateByPrimaryKeySelective(fileInfoA);
        return num;
    }

    public FileInfoA getFileInfoA(String id){
        return fileInfoAMapper.selectByPrimaryKey(id);
    }

    public int fileInfoADelete(String id){
        int num = fileInfoAMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public List<FileInfoA> getFileInfoAListAJGD(Map<String, Object> map) {
        return fileInfoAMapper.getFileInfoAListAJGD(map);
    }

    @Override
    public Integer getFileInfoAListAJGDConut(Map<String, Object> map) {
        return fileInfoAMapper.getFileInfoAListAJGDConut(map);
    }

}
