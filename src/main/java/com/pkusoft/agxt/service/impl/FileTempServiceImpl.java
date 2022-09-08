package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.FileTempMapper;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.FileTempService;
import com.pkusoft.usercenter.po.SysUser;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class FileTempServiceImpl implements FileTempService {

    @Autowired
    private FileTempMapper fileTempMapper;

    public List<FileTemp> getFileTempList(FileTempParam fileTempParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(fileTempParam.getStart(),fileTempParam.getPageSize());
        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,fileTempParam, sysUser);
        return fileTempMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileTempCount(FileTempParam fileTempParam, SysUser sysUser) {

        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,fileTempParam, sysUser);
        return fileTempMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, FileTempParam fileTempParam, SysUser user) {
        criteria.andEqualTo("parentId", "00000000-0000-0000-0000-000000000000");
        criteria.andEqualTo("isPublic", "1");
    }

    public int fileTempSave(FileTemp fileTemp, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileTemp.setId(id);
        int num = fileTempMapper.insertSelective(fileTemp);
        return num;
    }

    public int fileTempUpdate(FileTemp fileTemp, Map<String,String> map){
        int num = fileTempMapper.updateByPrimaryKeySelective(fileTemp);
        return num;
    }

    public FileTemp getFileTemp(String id){
        return fileTempMapper.selectByPrimaryKey(id);
    }

    public int fileTempDelete(String id){
        int num = fileTempMapper.deleteByPrimaryKey(id);
        return num;
    }

}
