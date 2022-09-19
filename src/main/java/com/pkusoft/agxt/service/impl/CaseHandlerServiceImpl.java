package com.pkusoft.agxt.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
import com.pkusoft.agxt.mapper.FileAuthMapper;
import com.pkusoft.agxt.model.*;
import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysPara;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import pkubatis.common.utils.JobUtil;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.agxt.service.CaseHandlerService;
import com.pkusoft.agxt.mapper.CaseHandlerMapper;

@Service
@Transactional
public class CaseHandlerServiceImpl implements CaseHandlerService {

    @Autowired
    private CaseHandlerMapper caseHandlerMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private FileAuthMapper fileAuthMapper;
    @Autowired
    private SysParaService sysParaService;

    public List<CaseHandler> getCaseHandlerList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CaseHandler.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseHandlerMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseHandlerCount(Map<String, String> map) {

        Example example = new Example(CaseHandler.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseHandlerMapper.selectCountByExample(example);
    }

    public int caseHandlerSave(CaseHandler caseHandler, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        caseHandler.setId(id);
        int num = caseHandlerMapper.insertSelective(caseHandler);
        return num;
    }

    public int caseHandlerUpdate(CaseHandler caseHandler, Map<String,String> map){
        int num = caseHandlerMapper.updateByPrimaryKeySelective(caseHandler);
        return num;
    }

    public CaseHandler getCaseHandler(String id){
        return caseHandlerMapper.selectByPrimaryKey(id);
    }

    public int caseHandlerDelete(String id){
        int num = caseHandlerMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int deleteJobCaseHandlerByAjbh(String ajbh) {
        Example example = new Example(CaseHandler.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileCode", ajbh);
        return caseHandlerMapper.deleteByExample(example);
    }

    public void insertHandler(CaseInfo caseinfo, FileInfo jobFileInfo, UserInfo userInfo){
        if("1".equals(caseinfo.getDataSource())){//临时案件录入
            CaseHandler zbr=changeJobCaseHandler(caseinfo,jobFileInfo,userInfo);
            zbr.setHandlerId(caseinfo.getHosterId());

            Example example = new Example(SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("idcard", caseinfo.getHosterId());
            SysUser zbrSysUser= sysUserMapper.selectOneByExample(example);
            zbr.setHandlerCode(zbrSysUser.getPoliceCode());
            zbr.setHandlerName(caseinfo.getHosterName());
            zbr.setType(JobConstant.ZBR);
            caseHandlerMapper.insertSelective(zbr);
            FileAuth zbrJobFileAuth=getJobFileAuth(jobFileInfo, userInfo,zbrSysUser.getIdcard());
            zbrJobFileAuth.setOperType(JobConstant.BANANZHE);
            zbrJobFileAuth.setCurOrg(caseinfo.getHandleOrgCode());
            zbrJobFileAuth.setCurOrgData(caseinfo.getHandleOrgCode());

            fileAuthMapper.insertSelective(zbrJobFileAuth);//将主办人加入到权限表
        }else{//建卷
            SysPara sysPara = sysParaService.getSysPara("AJXX_DATA_SOURCE");
            if(sysPara !=  null && sysPara.getParaValue().equals("2")){
                CaseHandler zbr=changeJobCaseHandler(caseinfo,jobFileInfo,userInfo);
                zbr.setHandlerId(caseinfo.getHosterId());
                zbr.setHandlerCode(caseinfo.getHosterPcode());
                zbr.setHandlerName(caseinfo.getHosterName());
                zbr.setType(JobConstant.ZBR);
                caseHandlerMapper.insert(zbr);
                FileAuth zbrJobFileAuth=getJobFileAuth(jobFileInfo, userInfo,caseinfo.getHosterId());
                zbrJobFileAuth.setOperType(JobConstant.BANANZHE);
                zbrJobFileAuth.setCurOrg(caseinfo.getHandleOrgCode());
                zbrJobFileAuth.setCurOrgData(caseinfo.getHandleOrgCode());

                fileAuthMapper.insertSelective(zbrJobFileAuth);//将主办人加入到权限表
            }else{
                // TODO
//                DzajCaseInfo dzajCaseInfo=WebUtils.getBean(DzajCaseInfoService.class).getByProperty("caseId",caseinfo.getCode());
//                if(null != dzajCaseInfo){
//                    CaseHandler hand=changeJobCaseHandler(caseinfo,jobFileInfo,userInfo);
//                    hand.setHandlerId(dzajCaseInfo.getTransactor2Id());
//                    if(dzajCaseInfo.getTransactor2Id() != null){
//                        SysUser sysUser=WebUtils.getBean(SysUserService.class).getByProperty("idcard",dzajCaseInfo.getTransactor2Id());
//                        if(null != sysUser){
//                            hand.setHandlerCode(sysUser.getPoliceCode());
//                            hand.setHandlerName(dzajCaseInfo.getTransactor2Name());
//                            hand.setType(JobConstant.XBR);
//                            jobCaseHandlerMapper.insert(hand);
//                            JobFileAuth jobFileAuth=getJobFileAuth(jobFileInfo, userInfo, sysUser.getIdcard());
//                            jobFileAuth.setOperType(JobConstant.BANANZHE);
//                            jobFileAuth.setCurOrg(caseinfo.getHandleOrgCode());
//                            jobFileAuth.setCurOrgData(caseinfo.getHandleOrgCode());
//                            WebUtils.getBean(JobFileAuthService.class).insert(jobFileAuth);//将协办人加入到权限表
//                        }
//                    }
//                    CaseHandler zbr=changeJobCaseHandler(caseinfo,jobFileInfo,userInfo);
//                    zbr.setHandlerId(dzajCaseInfo.getTransactor1Id());
//                    SysUser zbrSysUser=WebUtils.getBean(SysUserService.class).getByProperty("idcard",dzajCaseInfo.getTransactor1Id());
//                    zbr.setHandlerCode(zbrSysUser.getPoliceCode());
//                    zbr.setHandlerName(dzajCaseInfo.getTransactor1Name());
//                    zbr.setType(JobConstant.ZBR);
//                    jobCaseHandlerMapper.insert(zbr);
//                    FileAuth zbrJobFileAuth=getJobFileAuth(jobFileInfo, userInfo,zbrSysUser.getIdcard());
//                    zbrJobFileAuth.setOperType(JobConstant.BANANZHE);
//                    zbrJobFileAuth.setCurOrg(caseinfo.getHandleOrgCode());
//                    zbrJobFileAuth.setCurOrgData(caseinfo.getHandleOrgCode());
//                    WebUtils.getBean(JobFileAuthService.class).insert(zbrJobFileAuth);//将主办人加入到权限表
//                }
            }
        }
    }

    public FileAuth getJobFileAuth(FileInfo jobFileInfo,UserInfo userInfo,String idCard){
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idcard", idCard);
        SysUser sysUser= sysUserMapper.selectOneByExample(example);

        Example example2 = new Example(SysUser.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("deptId", sysUser.getDeptId());
        SysDept sysdept= sysDeptMapper.selectOneByExample(example2);

        FileAuth jobFileAuth= JobUtil.changeJobFileAuth(jobFileInfo, userInfo);//案卷权限管理
        jobFileAuth.setOperId(idCard);
        jobFileAuth.setOperName(sysUser.getUserName());
        jobFileAuth.setOrgCode(sysdept.getDeptId());
        jobFileAuth.setOrgName(sysdept.getDeptName());
        jobFileAuth.setStatus(JobConstant.PUTONGSTATUS);
//        jobFileAuth.setOperType(JobConstant.XJAJ);
        jobFileAuth.setAuthType(1);
        jobFileAuth.setOrgC(jobFileInfo.getOrgC());
        jobFileAuth.setOrgS(jobFileInfo.getOrgS());
        jobFileAuth.setOrgT(jobFileInfo.getOrgT());
        jobFileAuth.setOrgCData(jobFileInfo.getOrgCData());
        jobFileAuth.setOrgSData(jobFileInfo.getOrgSData());
        jobFileAuth.setOrgTData(jobFileInfo.getOrgTData());
        return jobFileAuth;
    }

    public CaseHandler changeJobCaseHandler(CaseInfo caseinfo,FileInfo jobFileInfo,UserInfo userInfo){
        CaseHandler hand=new CaseHandler();
        hand.setId(UUID.randomUUID().toString());
        hand.setCaseId(caseinfo.getId());
        hand.setCaseCode(caseinfo.getCode());
        hand.setCaseName(caseinfo.getName());
        //hand.setHandlerId(UUID.randomUUID().toString());
//        hand.setType("协");
        hand.setSn(0.0);
        hand.setDataSource("0");
        hand.setStatus(JobConstant.PUTONGSTATUS);
//        hand.setReserve1("");
//        hand.setReserve2("");
//        hand.setReserve3("");
//        hand.setMemo(ajjbxx.getBz());
        hand.setRowStatus(3);
        hand.setCreaterId(userInfo.getIdCard());
        hand.setCreaterName(userInfo.getName());
        hand.setCreateTime(new Date());
        hand.setModerId(userInfo.getIdCard());
        hand.setModerName(userInfo.getName());
        hand.setModTime(new Date());
        hand.setFileId(jobFileInfo.getId());
        hand.setFileCode(jobFileInfo.getCode());
        hand.setFileName(jobFileInfo.getName());
        hand.setHandleOrgCode(caseinfo.getHandleOrgCode());
        hand.setHandleOrgName(caseinfo.getHandleOrgName());
        hand.setOrgC(caseinfo.getOrgC());
        hand.setOrgS(caseinfo.getOrgS());
        hand.setOrgT(caseinfo.getOrgT());
        hand.setOrgCData(caseinfo.getOrgCData());
        hand.setOrgSData(caseinfo.getOrgSData());
        hand.setOrgTData(caseinfo.getOrgTData());
//        jobCaseHandlerMapper.insert(hand);
        return hand;
    }
}
