package com.pkusoft.agxt.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.pkusoft.usercenter.po.SysPara;
import com.pkusoft.usercenter.service.SysParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import pkubatis.common.utils.JobFilePage;
import pkubatis.common.utils.TokenUtil;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FilePage;
import com.pkusoft.agxt.service.FilePageService;
import com.pkusoft.agxt.mapper.FilePageMapper;

@Service
@Transactional
public class FilePageServiceImpl implements FilePageService {

    @Value(value = "${agxt-hadoop}")
    private String agxtHadoop;
    @Autowired
    private FilePageMapper filePageMapper;
    @Autowired
    private SysParaService sysParaService;

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    @Override
    public List<FilePage> getJobFilePageByFileId(String fileId) {
        Example example = new Example(FilePage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileId", fileId);
        return filePageMapper.selectByExample(example);
    }

    @Override
    public Map<String, Object> TabZfjdArchiveData(FilePage jobFilePage, Integer sfsc) {
        Map<String, Object> multiValueMap = new HashMap<String, Object>();
        String sId = "BDGK"+jobFilePage.getId();
        multiValueMap.put("sId", sId);
        multiValueMap.put("lybid", jobFilePage.getId());
        multiValueMap.put("ajzllxid", "1");

        multiValueMap.put("ajid", jobFilePage.getCaseCode());
        SysPara sysPara= sysParaService.getSysParaByParaCode("HadoopUrlNew");
        if(sysPara != null){
            multiValueMap.put("zltpdz", agxtHadoop+"?sId="+sId);
        }
        multiValueMap.put("zlpx", jobFilePage.getSn().intValue());
        multiValueMap.put("sfsc", sfsc);
        multiValueMap.put("gxsj", new Date());
        multiValueMap.put("tjsj",  simpleDateFormat.format(jobFilePage.getCreateTime()));
        multiValueMap.put("xtly", "E");
        Map<String, Object> data = TokenUtil.getData("/TabZfjdArchiveData", multiValueMap);
        return data;
    }

}
