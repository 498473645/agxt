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

import com.pkusoft.agxt.model.FileTrack;
import com.pkusoft.agxt.service.FileTrackService;
import com.pkusoft.agxt.mapper.FileTrackMapper;

@Service
@Transactional
public class FileTrackServiceImpl implements FileTrackService {

    @Autowired
    private FileTrackMapper fileTrackMapper;

    public List<FileTrack> getFileTrackListByFileId(String fileId) {
        Example example = new Example(FileTrack.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("fileId", fileId);
        example.setOrderByClause("CREATE_TIME desc");
        return fileTrackMapper.selectByExample(example);
    }

    public int getFileTrackCount(Map<String, String> map) {

        Example example = new Example(FileTrack.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileTrackMapper.selectCountByExample(example);
    }

    public int fileTrackSave(FileTrack fileTrack, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileTrack.setId(id);
        int num = fileTrackMapper.insertSelective(fileTrack);
        return num;
    }

    public int fileTrackUpdate(FileTrack fileTrack, Map<String,String> map){
        int num = fileTrackMapper.updateByPrimaryKeySelective(fileTrack);
        return num;
    }

    public FileTrack getFileTrack(String id){
        return fileTrackMapper.selectByPrimaryKey(id);
    }

    public int fileTrackDelete(String id){
        int num = fileTrackMapper.deleteByPrimaryKey(id);
        return num;
    }

}
