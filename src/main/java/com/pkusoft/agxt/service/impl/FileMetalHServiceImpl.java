package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.mapper.FileMetalMapper;
import com.pkusoft.agxt.model.FileMetal;
import com.pkusoft.agxt.service.FileMetalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileMetalH;
import com.pkusoft.agxt.service.FileMetalHService;
import com.pkusoft.agxt.mapper.FileMetalHMapper;

@Service
@Transactional
public class FileMetalHServiceImpl implements FileMetalHService {

    @Autowired
    private FileMetalHMapper fileMetalHMapper;
    @Autowired
    private FileMetalMapper fileMetalMapper;

    public List<FileMetalH> getFileMetalHList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileMetalH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalHMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileMetalHCount(Map<String, String> map) {

        Example example = new Example(FileMetalH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalHMapper.selectCountByExample(example);
    }

    public int fileMetalHSave(FileMetalH fileMetalH, Map<String,String> map){
        String hisId = UUID.randomUUID().toString();
        fileMetalH.setHisId(hisId);
        int num = fileMetalHMapper.insertSelective(fileMetalH);
        return num;
    }

    public int fileMetalHUpdate(FileMetalH fileMetalH, Map<String,String> map){
        int num = fileMetalHMapper.updateByPrimaryKeySelective(fileMetalH);
        return num;
    }

    public FileMetalH getFileMetalH(String hisId){
        return fileMetalHMapper.selectByPrimaryKey(hisId);
    }

    public int fileMetalHDelete(String hisId){
        int num = fileMetalHMapper.deleteByPrimaryKey(hisId);
        return num;
    }

    //??????????????????????????????
    public void TemporalTable(FileMetal jobFileMetal){
        FileMetalH jobFileMetalH = new FileMetalH();
        BeanUtils.copyProperties(jobFileMetal,jobFileMetalH);
        jobFileMetalH.setHisId(UUID.randomUUID().toString());
        fileMetalHMapper.insertSelective(jobFileMetalH);
    }

    //??????????????????????????????
    public void TemporalTableByFileId(String fileId){
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileId", fileId);
        List<FileMetal> jobFileMetal= fileMetalMapper.selectByExample(example);
        for(int i=0;i<jobFileMetal.size();i++){
            FileMetalH jobFileMetalH = new FileMetalH();
            BeanUtils.copyProperties(jobFileMetal.get(i),jobFileMetalH);
            jobFileMetalH.setHisId(UUID.randomUUID().toString());
            fileMetalHMapper.insertSelective(jobFileMetalH);
        }
    }
}
