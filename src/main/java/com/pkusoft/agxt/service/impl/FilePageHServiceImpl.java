package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.agxt.model.FilePage;
import com.pkusoft.agxt.service.FilePageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FilePageH;
import com.pkusoft.agxt.service.FilePageHService;
import com.pkusoft.agxt.mapper.FilePageHMapper;

@Service
@Transactional
public class FilePageHServiceImpl implements FilePageHService {

    @Autowired
    private FilePageHMapper filePageHMapper;
    @Autowired
    private FilePageService filePageService;

    public List<FilePageH> getFilePageHList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FilePageH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageHMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFilePageHCount(Map<String, String> map) {

        Example example = new Example(FilePageH.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return filePageHMapper.selectCountByExample(example);
    }

    public int filePageHSave(FilePageH filePageH, Map<String,String> map){
        String hisId = UUID.randomUUID().toString();
        filePageH.setHisId(hisId);
        int num = filePageHMapper.insertSelective(filePageH);
        return num;
    }

    public int filePageHUpdate(FilePageH filePageH, Map<String,String> map){
        int num = filePageHMapper.updateByPrimaryKeySelective(filePageH);
        return num;
    }

    public FilePageH getFilePageH(String hisId){
        return filePageHMapper.selectByPrimaryKey(hisId);
    }

    public int filePageHDelete(String hisId){
        int num = filePageHMapper.deleteByPrimaryKey(hisId);
        return num;
    }

    public void TemporalTableByFileId(String fileId){
        List<FilePage> jobFilePage= filePageService.getJobFilePageByFileId(fileId);
        for(int i=0;i<jobFilePage.size();i++){
            FilePageH jobFilePageH = new FilePageH();
            BeanUtils.copyProperties(jobFilePage.get(i),jobFilePageH);
            jobFilePageH.setHisId(UUID.randomUUID().toString());
            filePageHMapper.insertSelective(jobFilePageH);
        }
    }

}
