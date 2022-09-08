package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.mapper.FileInfoMapper;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    public List<FileInfo> getFileInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileInfoCount(Map<String, String> map) {

        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectCountByExample(example);
    }

    public int fileInfoSave(FileInfo fileInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileInfo.setId(id);
        int num = fileInfoMapper.insertSelective(fileInfo);
        return num;
    }

    public int fileInfoUpdate(FileInfo fileInfo, Map<String,String> map){
        int num = fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
        return num;
    }

    public FileInfo getFileInfo(String id){
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    public int fileInfoDelete(String id){
        int num = fileInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public FileInfo checkCaseInfo(FileInfo fileInfo) {
        return fileInfoMapper.selectOne(fileInfo);
    }

}
