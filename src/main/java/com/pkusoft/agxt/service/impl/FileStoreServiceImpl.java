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

import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.service.FileStoreService;
import com.pkusoft.agxt.mapper.FileStoreMapper;

@Service
@Transactional
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    private FileStoreMapper fileStoreMapper;

    public List<FileStore> getFileStoreList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileStore.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileStoreMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileStoreCount(Map<String, String> map) {

        Example example = new Example(FileStore.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileStoreMapper.selectCountByExample(example);
    }

    public int fileStoreSave(FileStore fileStore, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileStore.setId(id);
        int num = fileStoreMapper.insertSelective(fileStore);
        return num;
    }

    public int fileStoreUpdate(FileStore fileStore, Map<String,String> map){
        int num = fileStoreMapper.updateByPrimaryKeySelective(fileStore);
        return num;
    }

    public FileStore getFileStore(String id){
        return fileStoreMapper.selectByPrimaryKey(id);
    }

    public int fileStoreDelete(String id){
        int num = fileStoreMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public List<FileStore> getJobFileStoreByAreaId(String code) {
        FileStore fileStore = new FileStore();
        fileStore.setAreaId(code);
        return fileStoreMapper.select(fileStore);
    }

}
