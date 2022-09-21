package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.mapper.FileTrackMapper;
import com.pkusoft.agxt.model.FileTrack;
import com.pkusoft.agxt.service.FileMetalHService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.JobUtil;
import pkubatis.common.utils.OrgData;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileMetal;
import com.pkusoft.agxt.service.FileMetalService;
import com.pkusoft.agxt.mapper.FileMetalMapper;

@Service
@Transactional
public class FileMetalServiceImpl implements FileMetalService {

    @Autowired
    private FileMetalMapper fileMetalMapper;

    @Autowired
    private FileMetalHService fileMetalHService;

    @Autowired
    private FileTrackMapper fileTrackMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<FileMetal> getFileMetalList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileMetalCount(Map<String, String> map) {

        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileMetalMapper.selectCountByExample(example);
    }

    public int fileMetalSave(FileMetal fileMetal, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileMetal.setId(id);
        int num = fileMetalMapper.insertSelective(fileMetal);
        return num;
    }

    public int fileMetalUpdate(FileMetal fileMetal, Map<String,String> map){
        int num = fileMetalMapper.updateByPrimaryKeySelective(fileMetal);
        return num;
    }

    public FileMetal getFileMetal(String id){
        return fileMetalMapper.selectByPrimaryKey(id);
    }

    public int fileMetalDelete(String id){
        int num = fileMetalMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobFileMetalByAjbh(String ajbh) {
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return fileMetalMapper.deleteByExample(example);
    }
    //web端案卷采集功能中增加材料
    public String JobFileMetalAdd(FileMetal jobFileMetal, String caseId, SysUser sysUser) {
        Date dete=new Date();
        String uuid=UUID.randomUUID().toString();
        OrgData orgData=sysPermitService.userOrg(sysUser.getUserId());
        FileMetal fileMetal;
        if(StringUtils.hasText(caseId)){
            Example example = new Example(FileMetal.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("caseId", caseId);
            example.setOrderByClause("sn");
            List<FileMetal> list = fileMetalMapper.selectByExample(example);

            fileMetal=list.get(0);
//            fileMetal.setType("");
            fileMetal.setTreePath("/"+uuid+"/");
            fileMetal.setDiskPath("/"+uuid+"/");
            fileMetal.setParentId(JobUtil.IDDEFAULT);
            fileMetal.setSn(list.get(list.size()-1).getSn()+1);
        }else{
            fileMetal = this.getFileMetal(jobFileMetal.getParentId());
            fileMetal.setTreePath(fileMetal.getDiskPath()+uuid+"/");
            fileMetal.setDiskPath(fileMetal.getDiskPath()+uuid+"/");
            fileMetal.setParentId(jobFileMetal.getParentId());

            Example example = new Example(FileMetal.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("parentId", jobFileMetal.getParentId());
            example.setOrderByClause("sn");
            List<FileMetal> list = fileMetalMapper.selectByExample(example);

            Double sn=null;
            if(list != null && list.size() > 0){
                sn=list.get(list.size()-1).getSn();
            }else{
                sn=fileMetal.getSn();
            }

            fileMetal.setSn(sn+1);
            //修改大于该材料的sn
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("moderId", sysUser.getIdcard());
            map.put("moderName", sysUser.getUserName());
            map.put("modTime",dete);
            map.put("sn", sn);
            map.put("fileId", fileMetal.getFileId());
            fileMetalMapper.updatefileMetalBySn(map);
        }
        fileMetal.setId(uuid);
        fileMetal.setName(jobFileMetal.getName());
        fileMetal.setCreaterId(sysUser.getIdcard());
        fileMetal.setCreaterName(sysUser.getUserName());
        fileMetal.setCreateTime(dete);
        fileMetal.setModerId(sysUser.getIdcard());
        fileMetal.setModerName(sysUser.getUserName());
        fileMetal.setModTime(dete);
        fileMetal.setIsScan(0);
        fileMetal.setPageCount(0);
        fileMetal.setPageStart(0);
        fileMetal.setPageEnd(0);
        fileMetal.setPrintCode("");
        fileMetal.setPrintCount(0);
        fileMetal.setBurnCount(0);
        fileMetal.setKeywords("");
        fileMetal.setStatus(JobConstant.PUTONGSTATUS);
        fileMetal.setReserve1("");
        fileMetal.setReserve2("");
        fileMetal.setReserve3("");
        fileMetal.setMemo("");
        fileMetal.setRowStatus(3);
        fileMetalMapper.insertSelective(fileMetal);
        fileMetalHService.TemporalTable(fileMetal);//记录历史表数据
        FileTrack jobFileTrack=JobUtil.establishTrackByMetal(fileMetal);
        jobFileTrack.setOperId(sysUser.getIdcard());
        jobFileTrack.setOperCode(sysUser.getPoliceCode());
        jobFileTrack.setOperName(sysUser.getUserName());
        jobFileTrack.setCreaterId(sysUser.getIdcard());
        jobFileTrack.setCreaterName(sysUser.getUserName());
        jobFileTrack.setModerId(sysUser.getIdcard());
        jobFileTrack.setModerName(sysUser.getUserName());
        jobFileTrack.setOperType(JobConstant.ADD_METAL);
        jobFileTrack.setOperDetail("由 "+sysUser.getUserName()+" 给案卷 : "+fileMetal.getFileName()+" 增加材料 : "+fileMetal.getName());
        jobFileTrack.setLoginType(JobConstant.USERNAMELOGIN);
        jobFileTrack.setOperdeptCode(orgData.getDeptId());
        jobFileTrack.setOperdeptName(orgData.getDeptName());
        fileTrackMapper.insertSelective(jobFileTrack);
        return uuid;
    }
}
