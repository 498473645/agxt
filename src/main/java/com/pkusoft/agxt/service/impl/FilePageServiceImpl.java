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

import com.pkusoft.agxt.model.FilePage;
import com.pkusoft.agxt.service.FilePageService;
import com.pkusoft.agxt.mapper.FilePageMapper;

@Service
@Transactional
public class FilePageServiceImpl implements FilePageService {

    @Autowired
    private FilePageMapper filePageMapper;

    public List<FilePage> getFilePageList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FilePage.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFilePageCount(Map<String, String> map) {

        Example example = new Example(FilePage.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageMapper.selectCountByExample(example);
    }

    public int filePageSave(FilePage filePage, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        filePage.setId(id);
        int num = filePageMapper.insertSelective(filePage);
        return num;
    }

    public int filePageUpdate(FilePage filePage, Map<String,String> map){
        int num = filePageMapper.updateByPrimaryKeySelective(filePage);
        return num;
    }

    public FilePage getFilePage(String id){
        return filePageMapper.selectByPrimaryKey(id);
    }

    public int filePageDelete(String id){
        int num = filePageMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public List<FilePage> getJobFilePageByajbh(String ajbh) {
        Example example = new Example(FilePage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return filePageMapper.selectByExample(example);
    }

    @Override
    public int deleteJobFilePageByAjbh(String ajbh) {
        Example example = new Example(FilePage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return filePageMapper.deleteByExample(criteria);
    }

}
