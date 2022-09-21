package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.FileInfoHMapper;
import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.FileInfoH;
import com.pkusoft.agxt.service.FileInfoHService;
import com.pkusoft.agxt.service.FileInfoService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class FileInfoHServiceImpl implements FileInfoHService {

    @Autowired
    private FileInfoHMapper fileInfoHMapper;
    @Autowired
    private FileInfoService fileInfoService;

    public List<FileInfoH> getFileInfoHList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileInfoH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoHMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileInfoHCount(Map<String, String> map) {

        Example example = new Example(FileInfoH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoHMapper.selectCountByExample(example);
    }

    public int fileInfoHSave(FileInfoH fileInfoH, Map<String,String> map){
        String hisId = UUID.randomUUID().toString();
        fileInfoH.setHisId(hisId);
        int num = fileInfoHMapper.insertSelective(fileInfoH);
        return num;
    }

    public int fileInfoHUpdate(FileInfoH fileInfoH, Map<String,String> map){
        int num = fileInfoHMapper.updateByPrimaryKeySelective(fileInfoH);
        return num;
    }

    public FileInfoH getFileInfoH(String hisId){
        return fileInfoHMapper.selectByPrimaryKey(hisId);
    }

    public int fileInfoHDelete(String hisId){
        int num = fileInfoHMapper.deleteByPrimaryKey(hisId);
        return num;
    }

    //将变更数据存入历史表
    public void TemporalTableById(String id){
        FileInfo jobFileInfo= fileInfoService.getFileInfo(id);
        FileInfoH jobFileInfoH = new FileInfoH();
        BeanUtils.copyProperties(jobFileInfo,jobFileInfoH);
        jobFileInfoH.setHisId(UUID.randomUUID().toString());
        fileInfoHMapper.insertSelective(jobFileInfoH);
    }
}
