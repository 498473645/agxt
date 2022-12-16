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

import com.pkusoft.agxt.model.FileTrackDtl;
import com.pkusoft.agxt.service.FileTrackDtlService;
import com.pkusoft.agxt.mapper.FileTrackDtlMapper;

@Service
@Transactional
public class FileTrackDtlServiceImpl implements FileTrackDtlService {

    @Autowired
    private FileTrackDtlMapper fileTrackDtlMapper;

    public List<FileTrackDtl> getFileTrackDtlList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileTrackDtl.class);
        Example.Criteria criteria = example.createCriteria();

        return fileTrackDtlMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileTrackDtlCount(Map<String, String> map) {

        Example example = new Example(FileTrackDtl.class);
        Example.Criteria criteria = example.createCriteria();

        return fileTrackDtlMapper.selectCountByExample(example);
    }

    public int fileTrackDtlSave(FileTrackDtl fileTrackDtl, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileTrackDtl.setId(id);
        int num = fileTrackDtlMapper.insertSelective(fileTrackDtl);
        return num;
    }

    public int fileTrackDtlUpdate(FileTrackDtl fileTrackDtl, Map<String,String> map){
        int num = fileTrackDtlMapper.updateByPrimaryKeySelective(fileTrackDtl);
        return num;
    }

    public FileTrackDtl getFileTrackDtl(String id){
        return fileTrackDtlMapper.selectByPrimaryKey(id);
    }

    public int fileTrackDtlDelete(String id){
        int num = fileTrackDtlMapper.deleteByPrimaryKey(id);
        return num;
    }

}
