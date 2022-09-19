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

import com.pkusoft.agxt.model.FileNote;
import com.pkusoft.agxt.service.FileNoteService;
import com.pkusoft.agxt.mapper.FileNoteMapper;

@Service
@Transactional
public class FileNoteServiceImpl implements FileNoteService {

    @Autowired
    private FileNoteMapper fileNoteMapper;

    public List<FileNote> getFileNoteList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileNote.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileNoteMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileNoteCount(Map<String, String> map) {

        Example example = new Example(FileNote.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileNoteMapper.selectCountByExample(example);
    }

    public int fileNoteSave(FileNote fileNote, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileNote.setId(id);
        int num = fileNoteMapper.insertSelective(fileNote);
        return num;
    }

    public int fileNoteUpdate(FileNote fileNote, Map<String,String> map){
        int num = fileNoteMapper.updateByPrimaryKeySelective(fileNote);
        return num;
    }

    public FileNote getFileNote(String id){
        return fileNoteMapper.selectByPrimaryKey(id);
    }

    public int fileNoteDelete(String id){
        int num = fileNoteMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobFileNoteByAjbh(String ajbh) {
        Example example = new Example(FileNote.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return fileNoteMapper.deleteByExample(example);
    }

}
