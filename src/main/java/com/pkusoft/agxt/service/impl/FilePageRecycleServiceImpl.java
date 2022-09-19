package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.model.FilePage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FilePageRecycle;
import com.pkusoft.agxt.service.FilePageRecycleService;
import com.pkusoft.agxt.mapper.FilePageRecycleMapper;

@Service
@Transactional
public class FilePageRecycleServiceImpl implements FilePageRecycleService {

    @Autowired
    private FilePageRecycleMapper filePageRecycleMapper;

    public List<FilePageRecycle> getFilePageRecycleList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FilePageRecycle.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageRecycleMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFilePageRecycleCount(Map<String, String> map) {

        Example example = new Example(FilePageRecycle.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageRecycleMapper.selectCountByExample(example);
    }

    public int filePageRecycleSave(FilePageRecycle filePageRecycle, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        filePageRecycle.setId(id);
        int num = filePageRecycleMapper.insertSelective(filePageRecycle);
        return num;
    }

    public int filePageRecycleUpdate(FilePageRecycle filePageRecycle, Map<String,String> map){
        int num = filePageRecycleMapper.updateByPrimaryKeySelective(filePageRecycle);
        return num;
    }

    public FilePageRecycle getFilePageRecycle(String id){
        return filePageRecycleMapper.selectByPrimaryKey(id);
    }

    public int filePageRecycleDelete(String id){
        int num = filePageRecycleMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int saveFilePageRecycle(List<FilePage> list) {
        if(null!=list&&list.size()>0){
            for (FilePage jobFilePage : list) {
                FilePageRecycle filePageRecyle = new FilePageRecycle();
                BeanUtils.copyProperties(jobFilePage, filePageRecyle);
                filePageRecyle.setOperType(JobConstant.ZUOFEISHANCHU);
                filePageRecyle.setOperTime(new Date());
                filePageRecycleMapper.insertSelective(filePageRecyle);
            }
        }
        return 0;
    }

}
