package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.service.FileInfoService;
import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.OrgData;
import pkubatis.common.utils.UserUtil;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.mapper.FileInfoMapper;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<FileInfo> getFileInfoList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getFileInfoCount(Map<String, String> map) {

        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectCountByExample(example);
    }

    public int fileInfoSave(FileInfo fileInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        fileInfo.setId(id);
        int num = fileInfoMapper.insertSelective(fileInfo);
        return num;
    }

    public int fileInfoUpdate(FileInfo fileInfo, Map<String,String> map){
        int num = fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
        return num;
    }

    public FileInfo getFileInfo(String id){
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    public int fileInfoDelete(String id){
        int num = fileInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public FileInfo checkCaseInfo(FileInfo fileInfo) {
        return fileInfoMapper.selectOne(fileInfo);
    }

    //案卷公用查询方法（扫描采集）
    public List<FileInfoParam> jobFileInfoListDataSMCJ(FileInfoParam fileInfoParam, SysUser sysUser) {
        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        // TODO (加权限)
        Map<String,Object> param= sysPermitService.getSysRoleUserMapBySysRole(sysUser);

//      SysUser sysUser=UserUtil.getJobFileInfoListBySysRole(orgData.getIdCard());//判断是否是案管员,是案管员就返回案管员信息
//        Map<String,Object> param=new HashMap<String,Object>();
        if(null == param){
            param=new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        }else{
            param.put("orgCode", orgData.getDeptId());
        }
        if(StringUtils.hasText(fileInfoParam.getCode())){
            param.put("ajbh", fileInfoParam.getCode().toUpperCase()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getName())){
            param.put("ajmc", fileInfoParam.getName().toUpperCase()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getKeywords())){
            param.put("saryxm","%"+ fileInfoParam.getKeywords()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getSpaceId())){
            param.put("spaceId", fileInfoParam.getSpaceId());
        }
        if(StringUtils.hasText(fileInfoParam.getHandleOrgCode())){
            param.put("handleOrgCode", fileInfoParam.getHandleOrgCode());
        }
        if(StringUtils.hasText(fileInfoParam.getHosterId())){
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        if(StringUtils.hasText(fileInfoParam.getStatus())){
            param.put("status", fileInfoParam.getStatus());
        }
        if(StringUtils.hasText(fileInfoParam.getReserve3())){
            param.put("reserve3", fileInfoParam.getReserve3());
        }
        param.put("start", fileInfoParam.getStart());
        param.put("pageSize",20);
        param.put("ajzfStatus", JobConstant.ZUOFEISTATUS);
//        param.put("YSQSSTATUS", JobConstant.YSQSSTATUS);
        param.put("zbrId", orgData.getIdCard());
        List<FileInfoParam> list= fileInfoMapper.jobFileInfoListDataSMCJ(param);
        return list;
    }
}
