package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.req.FileNoteParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.usercenter.po.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileNote;
import com.pkusoft.agxt.service.FileNoteService;
import com.pkusoft.agxt.mapper.FileNoteMapper;

@Service
@Transactional
public class FileNoteServiceImpl implements FileNoteService {

    @Autowired
    private FileNoteMapper fileNoteMapper;

    public List<FileNote> getFileNoteList(FileNoteParam fileNoteParam) {

        RowBounds rowBounds = new RowBounds(fileNoteParam.getStart(),fileNoteParam.getPageSize());
        Example example = new Example(FileNote.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria, fileNoteParam);
        return fileNoteMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileNoteCount(FileNoteParam fileNoteParam) {

        Example example = new Example(FileNote.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria, fileNoteParam);
        return fileNoteMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, FileNoteParam fileNoteParam) {
        criteria.andEqualTo("rowStatus", 3);
        if(StringUtils.hasText(fileNoteParam.getFileId())){
            criteria.andEqualTo("fileId", fileNoteParam.getFileId());
        }
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
