package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.mapper.FileInfoMapper;
import com.pkusoft.agxt.mapper.FileTrackDtlMapper;
import com.pkusoft.agxt.mapper.FileTrackMapper;
import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.service.FileTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.JobUtil;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.service.FileStoreService;
import com.pkusoft.agxt.mapper.FileStoreMapper;

@Service
@Transactional
public class FileStoreServiceImpl implements FileStoreService {

    @Autowired
    private FileStoreMapper fileStoreMapper;

    @Autowired
    private FileTrackMapper fileTrackMapper;

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Autowired
    private FileTrackDtlMapper fileTrackDtlMapper;

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

    public FileStore  getJobFileStoreByFileCode(String fileCode){
        Map<String,Object> map= new HashMap<>();
        map.put("pageId", JobUtil.IDDEFAULT);
        map.put("metalId", JobUtil.IDDEFAULT);
        map.put("fileCode", fileCode);
        FileStore jobFileStore= fileStoreMapper.getJobFileStoreByFileCode(map);
        if(null == jobFileStore){
            return null;
        }
        return JobUtil.changeJobFileStore(jobFileStore);
    }

    //变更案卷存储位置
    public ResponseData updateJobFileStoreByJobCabSpaceBGWZ(List<FileInfo> jobfileinfo, CabSpace jobCabSpace, UserInfo userInfo) {
        List<FileTrackDtl> jobFileTrackDtlList=new ArrayList<FileTrackDtl>();
        for (int i = 0; i < jobfileinfo.size(); i++) {
            FileTrack jobFileTrack=JobUtil.establishTrack( jobfileinfo.get(i) ,userInfo);
            jobFileTrack.setOperType(JobConstant.BIANGENGCUNFANGWEIZHI);
            jobFileTrack.setOperDetail("由"+userInfo.getName()+" 从 "+jobfileinfo.get(i).getSpaceName()+" 变更存放位置到 : "+jobCabSpace.getName());
            jobFileTrack.setLoginType(userInfo.getLoginType());
            fileTrackMapper.insertSelective(jobFileTrack);
            if(jobfileinfo.get(i).getHandleOrgCode().equals(userInfo.getDeptCode())){
                FileInfo jobFileInfo=new FileInfo();
                jobFileInfo.setPlaceId(jobCabSpace.getPlaceId());
                jobFileInfo.setPlaceName(jobCabSpace.getPlaceName());
                jobFileInfo.setAreaId(jobCabSpace.getAreaId());
                jobFileInfo.setAreaName(jobCabSpace.getAreaName());
                jobFileInfo.setSpaceId(jobCabSpace.getId());
                jobFileInfo.setSpaceName(jobCabSpace.getName());
                jobFileInfo.setModerId(userInfo.getIdCard());
                jobFileInfo.setModerName(userInfo.getName());
                jobFileInfo.setModTime(new Date());
                jobFileInfo.setId(jobfileinfo.get(i).getId());
                fileInfoMapper.updateByPrimaryKeySelective(jobFileInfo);
            }

            Example example = new Example(FileStore.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("fileId", jobfileinfo.get(i).getId());
            criteria.andEqualTo("rowStatus", 3);
            List<FileStore> jobFileStorelist = fileStoreMapper.selectByExample(example);

            FileStore jobFileStore=new FileStore();
            jobFileStore.setPlaceId(jobCabSpace.getPlaceId());
            jobFileStore.setPlaceName(jobCabSpace.getPlaceName());
            jobFileStore.setAreaId(jobCabSpace.getAreaId());
            jobFileStore.setAreaName(jobCabSpace.getAreaName());
            jobFileStore.setSpaceId(jobCabSpace.getId());
            jobFileStore.setSpaceName(jobCabSpace.getName());
            jobFileStore.setModerId(userInfo.getIdCard());
            jobFileStore.setModerName(userInfo.getName());
            jobFileStore.setModTime(new Date());

            Example example2 = new Example(FileStore.class);
            Example.Criteria criteria2 = example2.createCriteria();
            criteria2.andEqualTo("fileCode", jobfileinfo.get(i).getCode());
            criteria2.andEqualTo("rowStatus", 3);
            fileStoreMapper.updateByExampleSelective(jobFileStore, example2);

            FileTrackDtl trackdtl=JobUtil.changeJobFileTrackDtlByJobFileInfo(jobfileinfo.get(i), null,userInfo);
            if(jobFileStorelist != null && jobFileStorelist.size()>0){
                trackdtl.setPlaceId(jobFileStorelist.get(0).getPlaceId());
                trackdtl.setPlaceName(jobFileStorelist.get(0).getPlaceName());
                trackdtl.setAreaId(jobFileStorelist.get(0).getAreaId());
                trackdtl.setAreaName(jobFileStorelist.get(0).getAreaName());
                trackdtl.setSpaceId(jobFileStorelist.get(0).getSpaceId());
                trackdtl.setSpaceName(jobFileStorelist.get(0).getSpaceName());
            }
            trackdtl.setTrackId(jobFileTrack.getId());
            trackdtl.setOperType(JobConstant.BIANGENGCUNFANGWEIZHI);
            trackdtl.setMemo("变更前");
            fileTrackDtlMapper.insertSelective(JobUtil.notNullJobFileTrackDtl(trackdtl));
            jobFileTrackDtlList.add(JobUtil.notNullJobFileTrackDtl(trackdtl));

            FileTrackDtl trackdtl2=JobUtil.changeJobFileTrackDtlByJobFileInfo(jobfileinfo.get(i), jobFileStore,userInfo);
            trackdtl2.setTrackId(jobFileTrack.getId());
            trackdtl2.setOperType(JobConstant.BIANGENGCUNFANGWEIZHI);
            trackdtl2.setMemo("变更后");
            trackdtl2.setPlaceId(jobCabSpace.getPlaceId());
            trackdtl2.setPlaceName(jobCabSpace.getPlaceName());
            trackdtl2.setAreaId(jobCabSpace.getAreaId());
            trackdtl2.setAreaName(jobCabSpace.getAreaName());
            trackdtl2.setSpaceId(jobCabSpace.getId());
            trackdtl2.setSpaceName(jobCabSpace.getName());
            fileTrackDtlMapper.insertSelective(JobUtil.notNullJobFileTrackDtl(trackdtl2));
            jobFileTrackDtlList.add(JobUtil.notNullJobFileTrackDtl(trackdtl2));
        }
        return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"变更案卷存储位置成功",jobFileTrackDtlList);
    }

    @Override
    public FileStore getJobFileStoreByFileIdAndPageIdAndMetalId(Map<String, Object> map) {
        return fileStoreMapper.getJobFileStoreByFileIdAndPageIdAndMetalId(map);
    }

    public List<FileStore> getJobFileStoreBySpaceId(String spaceId){
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageId", JobUtil.IDDEFAULT);
        map.put("metalId", JobUtil.IDDEFAULT);
        map.put("spaceId", spaceId);
        List<FileStore> list = fileStoreMapper.getJobFileStoreBySpaceId(map);
        return list;
    }

    @Override
    public int deleteJobFileStoreByAjbh(String ajbh) {
        Example example = new Example(FileStore.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return fileStoreMapper.deleteByExample(example);
    }
}
