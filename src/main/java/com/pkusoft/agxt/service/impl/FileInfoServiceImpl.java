package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.mapper.*;
import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.service.*;
import com.pkusoft.lesp.mapper.KeAgAjztxxMapper;
import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.service.KeAgAjztxxService;
import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysParaMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysPara;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.JobUtil;
import pkubatis.common.utils.OrgData;
import pkubatis.common.utils.PinyinUtils;
import pkubatis.common.utils.UserUtil;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Autowired
    private CaseInfoService caseInfoService;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseInfoHService caseInfoHService;

    @Autowired
    private FileMetalMapper fileMetalMapper;

    @Autowired
    private FileMetalHService fileMetalHService;

    @Autowired
    private FileStoreMapper fileStoreMapper;

    @Autowired
    private FileStoreHService fileStoreHService;

    @Autowired
    private CaseHandlerService caseHandlerService;

    @Autowired
    private SysParaMapper sysParaMapper;

    @Autowired
    private KeAgAjztxxService keAgAjztxxService;

    @Autowired
    private KeAgAjztxxMapper keAgAjztxxMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysPermitService sysPermitService;

    @Autowired
    private FileTrackMapper fileTrackMapper;

    @Autowired
    private CabSpaceMapper cabSpaceMapper;

    @Autowired
    private FileTrackDtlMapper fileTrackDtlMapper;

    public List<FileInfo> getFileInfoList(FileInfoParam fileInfoParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(fileInfoParam.getStart(),fileInfoParam.getPageSize());
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<FileInfo> getFileInfoListByIdList(FileInfoParam fileInfoParam, SysUser sysUser) {

        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andIn("id", fileInfoParam.getIdList());
        return fileInfoMapper.selectByExample(example);
    }

    public int getFileInfoCount(FileInfoParam fileInfoParam, SysUser sysUser) {

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

    @Override
    public List<FileInfoParam> getJobFileInfoByFileAuthoperIdKg(FileInfoParam fileInfoParam, SysUser sysUser) {
        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        Map<String,Object> param = sysPermitService.getSysRoleUserMapBySysRole(sysUser);
        if(null == param){
            param=new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        }else{
//			param.put("handleOrgCode", sysUser.getDeptId());
        }
        if(StringUtils.hasText(fileInfoParam.getCode())){
            param.put("ajbh", fileInfoParam.getCode().toUpperCase()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getName())){
            param.put("ajmc", fileInfoParam.getName()+"%");
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
        //param.put("start", start);
        param.put("orgCData", JobUtil.returnNull(orgData.getOrgCData()));
        if(orgData.getOrgSData() != null)
            param.put("orgSData",JobUtil.returnNull(orgData.getOrgSData()));
        if(orgData.getOrgTData() != null)
            param.put("orgTData",JobUtil.returnNull(orgData.getOrgTData()));
        param.put("status1", JobConstant.JSAJSTATUS);
        param.put("operType1", JobConstant.JSAJSTATUS);
        param.put("status2", JobConstant.PUTONGSTATUS);
        param.put("operType2", JobConstant.PUTONGSTATUS);
        param.put("status3", JobConstant.TQDBSTATUS);
//		param.put("operType3", JobConstant.JSAJSTATUS);
//		param.put("operType4", JobConstant.PUTONGSTATUS);
//		param.put("operType5", JobConstant.YIYISONGSHENHESTATUS);
        param.put("status4", JobConstant.YSQSSTATUS);
        param.put("status5", JobConstant.YIYISONGSHENHESTATUS);
        param.put("status6", JobConstant.YIYIJIAO_FEIZHUBANREN);
        param.put("pageStatus1", JobConstant.PUTONGSTATUS);
        param.put("pageStatus2", JobConstant.JSAJSTATUS);
        param.put("yzf", JobConstant.ZUOFEISTATUS);
        if(StringUtils.hasText(fileInfoParam.getHandleOrgCode())){
            param.put("orgCode", fileInfoParam.getHandleOrgCode());
        }else{
            param.put("orgCode", orgData.getDeptId());
        }
        param.put("start", fileInfoParam.getStart());
        param.put("pageSize",20);
        //param.put("status5", null);
        //param.put("status6", JobUtil.IDDEFAULT);
        List<FileInfoParam> list = fileInfoMapper.getJobFileInfoByFileAuthoperIdKg(param);

        return list;
    }

    //确定模板的层级关系
    private void tempToMetal(CaseInfo caseInfo, String tempParentId, FileMetal parentMetal, List<FileTemp> tempList, List<FileMetal> metalList,UserInfo userInfo) {
        for(int i=0;i<tempList.size();i++){
            FileTemp temp = tempList.get(i);
            if(temp.getLev() > 2){
                if (tempParentId.equals(temp.getParentId())) {
                    FileMetal metal = JobUtil.changeJobFileMetal(temp, caseInfo,userInfo);
                    metal.setParentId(parentMetal.getId());
                    metal.setTreePath(parentMetal.getTreePath()+"/"+metal.getId());
                    metalList.add(metal);
                    tempToMetal(caseInfo, temp.getId(), metal, tempList, metalList,userInfo);
                }
            }
        }
    }

    //创建案卷
    public ResponseData jianJuan(CaseInfo caseInfo, List<FileTemp> tempList, CabSpace space, UserInfo userInfo){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setCode(caseInfo.getCode());
        FileInfo file = fileInfoMapper.selectOne(fileInfo);
        if(file != null){
            //案卷作废后重新建卷要删除原来数据.
            if(JobConstant.ZUOFEISTATUS.equals(file.getStatus())){
                caseInfoService.deleteZFSCAJ(caseInfo.getCode());
            }else{
                return new ResponseData(ResponseData.STATUS_CODE_OTHER,"此案件已建卷, 其主办人为 : "+file.getHosterName()+", 身份证号为 : "+file.getHosterId()+", 警号为 : "+file.getHosterPcode()+".");
            }
        }
        if(caseInfo.getName() == null || "".equals(caseInfo.getName())){
            caseInfo.setName(caseInfo.getCode());
        }
//	    JobCaseInfo cas=jobCaseInfoService.getByProperty("code", caseInfo.getCode());
        if(null==caseInfo.getCode()){
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"未设置案件编号");
        }

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idcard", caseInfo.getHosterId());
        SysUser zbrSysUser = sysUserMapper.selectOneByExample(example);//查询主办人信息
        if(null == zbrSysUser){
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"未找到主办人 :"+caseInfo.getHosterName()+" 身份证号为 "+caseInfo.getHosterId()+" 的人员信息");
        }

        Example example2 = new Example(SysUser.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("paraCode", "AGXT_FilePath");
        SysPara sysPara = sysParaMapper.selectOneByExample(example2);
        if(null == sysPara){
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"参数：AGXT_FilePath 未找到。（案管系统存入hadoop中文件路径的前缀）");
        }
        List<FileMetal> metals= new ArrayList<>();
        for(int i=0;i<tempList.size();i++){
            FileTemp temp = tempList.get(i);
            if(temp.getLev()==2){
                FileMetal metal = JobUtil.changeJobFileMetal(temp, caseInfo,userInfo);
                metal.setParentId(JobUtil.IDDEFAULT);
                metal.setTreePath("/"+metal.getId());
                metals.add(metal);
                String tempParentId = temp.getId();
                tempToMetal(caseInfo, tempParentId, metal, tempList, metals,userInfo);
            }
        }
        caseInfo.setModerId(userInfo.getIdCard());//
        caseInfo.setModerName(userInfo.getName());
        caseInfo.setModTime(new Date());
        caseInfo.setCreaterId(userInfo.getIdCard());
        caseInfo.setCreaterName(userInfo.getName());
        caseInfo.setCreateTime(new Date());
        caseInfo.setStatus(JobConstant.PUTONGSTATUS);
        caseInfoMapper.insertSelective(caseInfo);//保存案件基本信息表对象
        caseInfoHService.TemporalTable(caseInfo);//记录案件历史信息
        FileStore store=JobUtil.getJobFileStore(space,userInfo,caseInfo);
        FileInfo jobFileInfo=JobUtil.establishJobFileInfo(store,caseInfo,userInfo);//生成案卷对象
        jobFileInfo.setDiskPath(sysPara.getParaValue()+"/"+jobFileInfo.getCode());
        for(int i=0;i<metals.size();i++){
            metals.get(i).setTreePath(metals.get(i).getTreePath() + "/");
            metals.get(i).setDiskPath(metals.get(i).getTreePath());
            metals.get(i).setFileId(jobFileInfo.getId());
            metals.get(i).setFileName(jobFileInfo.getName());
            metals.get(i).setFileCode(jobFileInfo.getCode());
            metals.get(i).setCreateTime(new Date());
            metals.get(i).setModTime(new Date());
            fileMetalMapper.insertSelective(metals.get(i));//保存案卷材料信息表对象
            fileMetalHService.TemporalTable(metals.get(i));//将材料存入历史表
        }
        store.setId(UUID.randomUUID().toString());
        store.setFileId(jobFileInfo.getId());
        store.setFileName(jobFileInfo.getName());
        store.setFileCode(jobFileInfo.getCode());
        store.setMetalId(UUID.fromString(JobUtil.IDDEFAULT).toString());
        store.setPageId(UUID.fromString(JobUtil.IDDEFAULT).toString());
        fileStoreMapper.insertSelective(store);//保存案卷存储表对象
        fileStoreHService.TemporalTable(store);//将案卷存储表信息存入历史表
        jobFileInfo.setCaseId(caseInfo.getId());
        jobFileInfo.setReserve3(caseInfo.getReserve3());
        jobFileInfo.setCaseName(caseInfo.getName());
        jobFileInfo.setCaseCode(caseInfo.getCode());
        if(caseInfo.getOrgTData() != null){
            jobFileInfo.setCurOrgData(caseInfo.getCurOrgData());
        }else if(caseInfo.getOrgSData() != null){
            jobFileInfo.setCurOrgData(caseInfo.getOrgSData());
        }else if(caseInfo.getOrgCData() != null){
            jobFileInfo.setCurOrgData(caseInfo.getOrgCData());
        }

        if(caseInfo.getOrgT() != null){
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        }else if(caseInfo.getOrgS() != null){
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        }else if(caseInfo.getOrgC() != null){
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        }

        jobFileInfo.setHandleOrgCode(caseInfo.getHandleOrgCode());
        jobFileInfo.setHandleOrgName(caseInfo.getHandleOrgName());
        jobFileInfo.setCreateTime(new Date());
        jobFileInfo.setModTime(new Date());
        caseHandlerService.insertHandler(caseInfo,jobFileInfo,userInfo);//保存案件办案人信息表对象(办案人权限也是在这加的)
        FileTrack track=JobUtil.establishTrack(jobFileInfo,userInfo);
        track.setOperType(JobConstant.XJAJ);//0010
        track.setOperDetail("由 "+userInfo.getName()+" 新建案卷");//新建案卷
        track.setFileId(jobFileInfo.getId());
        track.setFileName(jobFileInfo.getName());
        track.setFileCode(jobFileInfo.getCode());
        track.setIsOpened(0);
        track.setLoginType(userInfo.getLoginType());
        if(jobFileInfo.getName() != null && !jobFileInfo.getName().equals("")){
            String code= PinyinUtils.getPinyin(jobFileInfo.getName());//案卷拼音码
            jobFileInfo.setNameSpell(code.toUpperCase());
        }
        if(StringUtils.hasText(jobFileInfo.getHosterName())){
            String hosterName=PinyinUtils.getPinyin(jobFileInfo.getHosterName());//主办人拼音码
            jobFileInfo.setHosterSpell(hosterName.toUpperCase());
        }
        jobFileInfo.setSuppleinvCount(0);
        KeAgAjztxx ajjbxx=keAgAjztxxService.getKeAgAjztxx(caseInfo.getCode());
        if(ajjbxx != null){
            if(ajjbxx.getSaryxm() != null){
                jobFileInfo.setKeywords(ajjbxx.getSaryxm());
            }
            if(ajjbxx.getSaryxmpym() != null){
                jobFileInfo.setReserve1(ajjbxx.getSaryxmpym());
            }
        }
        fileTrackMapper.insertSelective(track);//保存案卷操作轨迹表对象
        fileInfoMapper.insertSelective(jobFileInfo);//保存案卷信息表对象
        //保存案件状态表信息
        keAgAjztxxService.updateKeAgAjztxx(caseInfo.getCode(), JobConstant.YJJ_1,userInfo.getIdCard(),userInfo.getName(), 1);
        if(space != null &&StringUtils.hasText(space.getId())&& !JobUtil.IDDEFAULT.equals(space.getId())){
            Example example3 = new Example(FileInfo.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("spaceId", space.getId());
            Integer count= fileInfoMapper.selectCountByExample(example3);

            space.setStatus(JobConstant.YICUNFANG_GUAN);
            space.setCurFileCount(count);
            space.setModerId(userInfo.getIdCard());
            space.setModerName(userInfo.getName());
            space.setModTime(new Date());

            cabSpaceMapper.updateByPrimaryKeySelective(space);

            FileTrack track2=JobUtil.establishTrack(jobFileInfo,userInfo);
            track2.setOperType(JobConstant.AJRG);//0010
            track2.setOperDetail("案卷入柜");//新建案卷
            track2.setFileId(jobFileInfo.getId());
            track2.setFileName(jobFileInfo.getName());
            track2.setFileCode(jobFileInfo.getCode());
            track2.setIsOpened(0);
            fileTrackMapper.insertSelective(track2);//保存案卷操作轨迹表对象
            //保存到案件状态表(入柜保存的时候往状态表加一条入柜的数据)
            keAgAjztxxService.updateKeAgAjztxx(caseInfo.getCode(), JobConstant.YRG_1,userInfo.getIdCard(),userInfo.getName(),3);
        }
        List<FileTrackDtl> jobFileTrackDtl=new ArrayList<FileTrackDtl>();
        FileTrackDtl trackdtl=JobUtil.changeJobFileTrackDtlByJobFileInfo(jobFileInfo, store,userInfo);
        trackdtl.setTrackId(track.getId());
        trackdtl.setOperType(JobConstant.XJAJ);
        fileTrackDtlMapper.insertSelective(JobUtil.notNullJobFileTrackDtl(trackdtl));
        jobFileTrackDtl.add(JobUtil.notNullJobFileTrackDtl(trackdtl));
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("FILE_INFO", JobUtil.notNull(jobFileInfo));
        map.put("FILE_TRACK_DTL",JobUtil.isNotNullJobFileTrackDtl(jobFileTrackDtl));
        //回填状态表
        KeAgAjztxx ajztxx =keAgAjztxxService.getKeAgAjztxx(caseInfo.getCode());
        if(ajztxx.getZbrSfzhm() == null || "".equals(ajztxx.getZbrSfzhm())){
            KeAgAjztxx keAgAjztxx=new KeAgAjztxx();
            keAgAjztxx.setAjbh(caseInfo.getCode());
            keAgAjztxx.setZbrJh(caseInfo.getHosterPcode());
            keAgAjztxx.setZbrXm(caseInfo.getHosterName());
            keAgAjztxx.setZbrSfzhm(caseInfo.getHosterId());
            if(caseInfo.getHosterName() != null){
                String hosterName=PinyinUtils.getPinyin(caseInfo.getHosterName()).toUpperCase();//主办人拼音码
                keAgAjztxx.setZbrXmPym(hosterName);
            }
            keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
        }
        if(!StringUtils.hasText(ajztxx.getBadwBm()) || !StringUtils.hasText(ajztxx.getCstationid())){
            KeAgAjztxx keAgAjztxx=new KeAgAjztxx();
            keAgAjztxx.setAjbh(caseInfo.getCode());
            keAgAjztxx.setBadwBm(caseInfo.getHandleOrgCode());
            keAgAjztxx.setBadwMc(caseInfo.getHandleOrgName());
            keAgAjztxx.setCstationid(caseInfo.getOrgCData());
            keAgAjztxx.setSstationid(caseInfo.getOrgSData());
            keAgAjztxx.setTstationid(caseInfo.getOrgTData());
            keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
        }
        return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"新建案卷成功",map);
    }

    @Override
    public int deleteJobFileInfoByAjbh(String ajbh) {
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code", ajbh);
        return fileInfoMapper.deleteByExample(example);
    }
}
