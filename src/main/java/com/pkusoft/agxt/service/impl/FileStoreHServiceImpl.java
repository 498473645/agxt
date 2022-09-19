package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.model.FileStore;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileStoreH;
import com.pkusoft.agxt.service.FileStoreHService;
import com.pkusoft.agxt.mapper.FileStoreHMapper;

@Service
@Transactional
public class FileStoreHServiceImpl implements FileStoreHService {

    @Autowired
    private FileStoreHMapper fileStoreHMapper;

    public List<FileStoreH> getFileStoreHList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileStoreH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileStoreHMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileStoreHCount(Map<String, String> map) {

        Example example = new Example(FileStoreH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileStoreHMapper.selectCountByExample(example);
    }

    public int fileStoreHSave(FileStoreH fileStoreH, Map<String,String> map){
        String hisId = UUID.randomUUID().toString();
        fileStoreH.setHisId(hisId);
        int num = fileStoreHMapper.insertSelective(fileStoreH);
        return num;
    }

    public int fileStoreHUpdate(FileStoreH fileStoreH, Map<String,String> map){
        int num = fileStoreHMapper.updateByPrimaryKeySelective(fileStoreH);
        return num;
    }

    public FileStoreH getFileStoreH(String hisId){
        return fileStoreHMapper.selectByPrimaryKey(hisId);
    }

    public int fileStoreHDelete(String hisId){
        int num = fileStoreHMapper.deleteByPrimaryKey(hisId);
        return num;
    }
    //将案卷存储表数据存入历史表
    public void TemporalTable(FileStore jobFileStore){
        FileStoreH jobFileStoreH = new FileStoreH();
        BeanUtils.copyProperties(jobFileStore,jobFileStoreH);
        jobFileStoreH.setHisId(UUID.randomUUID().toString());
        fileStoreHMapper.insertSelective(jobFileStoreH);
    }
}
