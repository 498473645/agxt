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

import com.pkusoft.agxt.model.FileMetal;
import com.pkusoft.agxt.service.FileMetalService;
import com.pkusoft.agxt.mapper.FileMetalMapper;

@Service
@Transactional
public class FileMetalServiceImpl implements FileMetalService {

    @Autowired
    private FileMetalMapper fileMetalMapper;

    public List<FileMetal> getFileMetalList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileMetalCount(Map<String, String> map) {

        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalMapper.selectCountByExample(example);
    }

    public int fileMetalSave(FileMetal fileMetal, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileMetal.setId(id);
        int num = fileMetalMapper.insertSelective(fileMetal);
        return num;
    }

    public int fileMetalUpdate(FileMetal fileMetal, Map<String,String> map){
        int num = fileMetalMapper.updateByPrimaryKeySelective(fileMetal);
        return num;
    }

    public FileMetal getFileMetal(String id){
        return fileMetalMapper.selectByPrimaryKey(id);
    }

    public int fileMetalDelete(String id){
        int num = fileMetalMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobFileMetalByAjbh(String ajbh) {
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return fileMetalMapper.deleteByExample(example);
    }

}
