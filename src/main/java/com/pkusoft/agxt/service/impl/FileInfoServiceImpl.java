package com.pkusoft.agxt.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.pkusoft.agxt.controller.FileInfoController;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.*;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileInfoServiceImpl.class);

    @Value("${sync_flag}")
    private Boolean sync_flag;
    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Autowired
    private CaseInfoService caseInfoService;

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private CaseInfoHService caseInfoHService;

    @Autowired
    private FileMetalService fileMetalService;

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

    @Autowired
    private FilePageService filePageService;

    @Autowired
    private FilePageMapper filePageMapper;

    @Autowired
    private FilePageHService filePageHService;

    @Autowired
    private FileInfoHService fileInfoHService;

    @Autowired
    private FileTempService fileTempService;

    @Autowired
    private FileTempMapper fileTempMapper;

    @Autowired
    private FileNoteMapper fileNoteMapper;

    public List<FileInfo> getFileInfoList(FileInfoParam fileInfoParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(fileInfoParam.getStart(), fileInfoParam.getPageSize());
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return fileInfoMapper.selectByExampleAndRowBounds(example, rowBounds);
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

    public int fileInfoSave(FileInfo fileInfo, Map<String, String> map) {
        String id = UUID.randomUUID().toString();
        fileInfo.setId(id);
        int num = fileInfoMapper.insertSelective(fileInfo);
        return num;
    }

    public int fileInfoUpdate(FileInfo fileInfo, Map<String, String> map) {
        int num = fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
        return num;
    }

    public FileInfo getFileInfo(String id) {
        return fileInfoMapper.selectByPrimaryKey(id);
    }

    public int fileInfoDelete(String id) {
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
        Map<String, Object> param = sysPermitService.getSysRoleUserMapBySysRole(sysUser);

        if (null == param) {
            param = new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        } else {
            param.put("orgCode", orgData.getDeptId());
        }
        if (StringUtils.hasText(fileInfoParam.getCode())) {
            param.put("ajbh", fileInfoParam.getCode().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getName())) {
            param.put("ajmc", fileInfoParam.getName().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getKeywords())) {
            param.put("saryxm", "%" + fileInfoParam.getKeywords() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getSpaceId())) {
            param.put("spaceId", fileInfoParam.getSpaceId());
        }
        if (StringUtils.hasText(fileInfoParam.getHandleOrgCode())) {
            param.put("handleOrgCode", fileInfoParam.getHandleOrgCode());
        }
        if (StringUtils.hasText(fileInfoParam.getHosterId())) {
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        if (StringUtils.hasText(fileInfoParam.getStatus())) {
            param.put("status", fileInfoParam.getStatus());
        }
        if (StringUtils.hasText(fileInfoParam.getReserve3())) {
            param.put("reserve3", fileInfoParam.getReserve3());
        }
        param.put("start", fileInfoParam.getStart());
        param.put("pageSize", 20);
        param.put("ajzfStatus", JobConstant.ZUOFEISTATUS);
        param.put("zbrId", orgData.getIdCard());
        List<FileInfoParam> list = fileInfoMapper.jobFileInfoListDataSMCJ(param);
        return list;
    }

    @Override
    public List<FileInfoParam> getJobFileInfoByFileAuthoperIdKg(FileInfoParam fileInfoParam, SysUser sysUser) {
        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        Map<String, Object> param = sysPermitService.getSysRoleUserMapBySysRole(sysUser);
        if (null == param) {
            param = new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        } else {
//			param.put("handleOrgCode", sysUser.getDeptId());
        }
        if (StringUtils.hasText(fileInfoParam.getCode())) {
            param.put("ajbh", fileInfoParam.getCode().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getName())) {
            param.put("ajmc", fileInfoParam.getName() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getSpaceId())) {
            param.put("spaceId", fileInfoParam.getSpaceId());
        }
        if (StringUtils.hasText(fileInfoParam.getHandleOrgCode())) {
            param.put("handleOrgCode", fileInfoParam.getHandleOrgCode());
        }
        if (StringUtils.hasText(fileInfoParam.getHosterId())) {
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        param.put("orgCData", JobUtil.returnNull(orgData.getOrgCData()));
        if (orgData.getOrgSData() != null)
            param.put("orgSData", JobUtil.returnNull(orgData.getOrgSData()));
        if (orgData.getOrgTData() != null)
            param.put("orgTData", JobUtil.returnNull(orgData.getOrgTData()));
        param.put("status1", JobConstant.JSAJSTATUS);
        param.put("operType1", JobConstant.JSAJSTATUS);
        param.put("status2", JobConstant.PUTONGSTATUS);
        param.put("operType2", JobConstant.PUTONGSTATUS);
        param.put("status3", JobConstant.TQDBSTATUS);
        param.put("status4", JobConstant.YSQSSTATUS);
        param.put("status5", JobConstant.YIYISONGSHENHESTATUS);
        param.put("status6", JobConstant.YIYIJIAO_FEIZHUBANREN);
        param.put("pageStatus1", JobConstant.PUTONGSTATUS);
        param.put("pageStatus2", JobConstant.JSAJSTATUS);
        param.put("yzf", JobConstant.ZUOFEISTATUS);
        if (StringUtils.hasText(fileInfoParam.getHandleOrgCode())) {
            param.put("orgCode", fileInfoParam.getHandleOrgCode());
        } else {
            param.put("orgCode", orgData.getDeptId());
        }
        param.put("start", fileInfoParam.getStart());
        param.put("pageSize", 20);
        List<FileInfoParam> list = fileInfoMapper.getJobFileInfoByFileAuthoperIdKg(param);

        return list;
    }

    //确定模板的层级关系
    private void tempToMetal(CaseInfo caseInfo, String tempParentId, FileMetal parentMetal, List<FileTemp> tempList, List<FileMetal> metalList, UserInfo userInfo) {
        for (int i = 0; i < tempList.size(); i++) {
            FileTemp temp = tempList.get(i);
            if (temp.getLev() > 2) {
                if (tempParentId.equals(temp.getParentId())) {
                    FileMetal metal = JobUtil.changeJobFileMetal(temp, caseInfo, userInfo);
                    metal.setParentId(parentMetal.getId());
                    metal.setTreePath(parentMetal.getTreePath() + "/" + metal.getId());
                    metalList.add(metal);
                    tempToMetal(caseInfo, temp.getId(), metal, tempList, metalList, userInfo);
                }
            }
        }
    }

    //创建案卷
    public ResponseData jianJuan(CaseInfo caseInfo, List<FileTemp> tempList, CabSpace space, UserInfo userInfo) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setCode(caseInfo.getCode());
        FileInfo file = fileInfoMapper.selectOne(fileInfo);
        if (file != null) {
            //案卷作废后重新建卷要删除原来数据.
            if (JobConstant.ZUOFEISTATUS.equals(file.getStatus())) {
                caseInfoService.deleteZFSCAJ(caseInfo.getCode());
            } else {
                return new ResponseData(ResponseData.STATUS_CODE_OTHER, "此案件已建卷, 其主办人为 : " + file.getHosterName() + ", 身份证号为 : " + file.getHosterId() + ", 警号为 : " + file.getHosterPcode() + ".");
            }
        }
        if (caseInfo.getName() == null || "".equals(caseInfo.getName())) {
            caseInfo.setName(caseInfo.getCode());
        }
        if (null == caseInfo.getCode()) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "未设置案件编号");
        }

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("idcard", caseInfo.getHosterId());
        SysUser zbrSysUser = sysUserMapper.selectOneByExample(example);//查询主办人信息
        if (null == zbrSysUser) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "未找到主办人 :" + caseInfo.getHosterName() + " 身份证号为 " + caseInfo.getHosterId() + " 的人员信息");
        }

        Example example2 = new Example(SysUser.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("paraCode", "AGXT_FilePath");
        SysPara sysPara = sysParaMapper.selectOneByExample(example2);
        if (null == sysPara) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数：AGXT_FilePath 未找到。（案管系统存入hadoop中文件路径的前缀）");
        }
        List<FileMetal> metals = new ArrayList<>();
        for (int i = 0; i < tempList.size(); i++) {
            FileTemp temp = tempList.get(i);
            if (temp.getLev() == 2) {
                FileMetal metal = JobUtil.changeJobFileMetal(temp, caseInfo, userInfo);
                metal.setParentId(JobUtil.IDDEFAULT);
                metal.setTreePath("/" + metal.getId());
                metals.add(metal);
                String tempParentId = temp.getId();
                tempToMetal(caseInfo, tempParentId, metal, tempList, metals, userInfo);
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
        FileStore store = JobUtil.getJobFileStore(space, userInfo, caseInfo);
        FileInfo jobFileInfo = JobUtil.establishJobFileInfo(store, caseInfo, userInfo);//生成案卷对象
        jobFileInfo.setDiskPath(sysPara.getParaValue() + "/" + jobFileInfo.getCode());
        for (int i = 0; i < metals.size(); i++) {
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
        if (caseInfo.getOrgTData() != null) {
            jobFileInfo.setCurOrgData(caseInfo.getCurOrgData());
        } else if (caseInfo.getOrgSData() != null) {
            jobFileInfo.setCurOrgData(caseInfo.getOrgSData());
        } else if (caseInfo.getOrgCData() != null) {
            jobFileInfo.setCurOrgData(caseInfo.getOrgCData());
        }

        if (caseInfo.getOrgT() != null) {
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        } else if (caseInfo.getOrgS() != null) {
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        } else if (caseInfo.getOrgC() != null) {
            jobFileInfo.setCurOrg(caseInfo.getCurOrg());
        }

        jobFileInfo.setHandleOrgCode(caseInfo.getHandleOrgCode());
        jobFileInfo.setHandleOrgName(caseInfo.getHandleOrgName());
        jobFileInfo.setCreateTime(new Date());
        jobFileInfo.setModTime(new Date());
        caseHandlerService.insertHandler(caseInfo, jobFileInfo, userInfo);//保存案件办案人信息表对象(办案人权限也是在这加的)
        FileTrack track = JobUtil.establishTrack(jobFileInfo, userInfo);
        track.setOperType(JobConstant.XJAJ);//0010
        track.setOperDetail("由 " + userInfo.getName() + " 新建案卷");//新建案卷
        track.setFileId(jobFileInfo.getId());
        track.setFileName(jobFileInfo.getName());
        track.setFileCode(jobFileInfo.getCode());
        track.setIsOpened(0);
        track.setLoginType(userInfo.getLoginType());
        if (jobFileInfo.getName() != null && !jobFileInfo.getName().equals("")) {
            String code = PinyinUtils.getPinyin(jobFileInfo.getName());//案卷拼音码
            jobFileInfo.setNameSpell(code.toUpperCase());
        }
        if (StringUtils.hasText(jobFileInfo.getHosterName())) {
            String hosterName = PinyinUtils.getPinyin(jobFileInfo.getHosterName());//主办人拼音码
            jobFileInfo.setHosterSpell(hosterName.toUpperCase());
        }
        jobFileInfo.setSuppleinvCount(0);
        KeAgAjztxx ajjbxx = keAgAjztxxService.getKeAgAjztxx(caseInfo.getCode());
        if (ajjbxx != null) {
            if (ajjbxx.getSaryxm() != null) {
                jobFileInfo.setKeywords(ajjbxx.getSaryxm());
            }
            if (ajjbxx.getSaryxmpym() != null) {
                jobFileInfo.setReserve1(ajjbxx.getSaryxmpym());
            }
        }
        fileTrackMapper.insertSelective(track);//保存案卷操作轨迹表对象
        fileInfoMapper.insertSelective(jobFileInfo);//保存案卷信息表对象
        //保存案件状态表信息
        keAgAjztxxService.updateKeAgAjztxx(caseInfo.getCode(), JobConstant.YJJ_1, userInfo.getIdCard(), userInfo.getName(), 1);
        if (space != null && StringUtils.hasText(space.getId()) && !JobUtil.IDDEFAULT.equals(space.getId())) {
            Example example3 = new Example(FileInfo.class);
            Example.Criteria criteria3 = example3.createCriteria();
            criteria3.andEqualTo("spaceId", space.getId());
            Integer count = fileInfoMapper.selectCountByExample(example3);

            space.setStatus(JobConstant.YICUNFANG_GUAN);
            space.setCurFileCount(count);
            space.setModerId(userInfo.getIdCard());
            space.setModerName(userInfo.getName());
            space.setModTime(new Date());

            cabSpaceMapper.updateByPrimaryKeySelective(space);

            FileTrack track2 = JobUtil.establishTrack(jobFileInfo, userInfo);
            track2.setOperType(JobConstant.AJRG);//0010
            track2.setOperDetail("案卷入柜");//新建案卷
            track2.setFileId(jobFileInfo.getId());
            track2.setFileName(jobFileInfo.getName());
            track2.setFileCode(jobFileInfo.getCode());
            track2.setIsOpened(0);
            fileTrackMapper.insertSelective(track2);//保存案卷操作轨迹表对象
            //保存到案件状态表(入柜保存的时候往状态表加一条入柜的数据)
            keAgAjztxxService.updateKeAgAjztxx(caseInfo.getCode(), JobConstant.YRG_1, userInfo.getIdCard(), userInfo.getName(), 3);
        }
        List<FileTrackDtl> jobFileTrackDtl = new ArrayList<FileTrackDtl>();
        FileTrackDtl trackdtl = JobUtil.changeJobFileTrackDtlByJobFileInfo(jobFileInfo, store, userInfo);
        trackdtl.setTrackId(track.getId());
        trackdtl.setOperType(JobConstant.XJAJ);
        fileTrackDtlMapper.insertSelective(JobUtil.notNullJobFileTrackDtl(trackdtl));
        jobFileTrackDtl.add(JobUtil.notNullJobFileTrackDtl(trackdtl));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("FILE_INFO", JobUtil.notNull(jobFileInfo));
        map.put("FILE_TRACK_DTL", JobUtil.isNotNullJobFileTrackDtl(jobFileTrackDtl));
        //回填状态表
        KeAgAjztxx ajztxx = keAgAjztxxService.getKeAgAjztxx(caseInfo.getCode());
        if (ajztxx.getZbrSfzhm() == null || "".equals(ajztxx.getZbrSfzhm())) {
            KeAgAjztxx keAgAjztxx = new KeAgAjztxx();
            keAgAjztxx.setAjbh(caseInfo.getCode());
            keAgAjztxx.setZbrJh(caseInfo.getHosterPcode());
            keAgAjztxx.setZbrXm(caseInfo.getHosterName());
            keAgAjztxx.setZbrSfzhm(caseInfo.getHosterId());
            if (caseInfo.getHosterName() != null) {
                String hosterName = PinyinUtils.getPinyin(caseInfo.getHosterName()).toUpperCase();//主办人拼音码
                keAgAjztxx.setZbrXmPym(hosterName);
            }
            keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
        }
        if (!StringUtils.hasText(ajztxx.getBadwBm()) || !StringUtils.hasText(ajztxx.getCstationid())) {
            KeAgAjztxx keAgAjztxx = new KeAgAjztxx();
            keAgAjztxx.setAjbh(caseInfo.getCode());
            keAgAjztxx.setBadwBm(caseInfo.getHandleOrgCode());
            keAgAjztxx.setBadwMc(caseInfo.getHandleOrgName());
            keAgAjztxx.setCstationid(caseInfo.getOrgCData());
            keAgAjztxx.setSstationid(caseInfo.getOrgSData());
            keAgAjztxx.setTstationid(caseInfo.getOrgTData());
            keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
        }
        return new ResponseData(ResponseData.STATUS_CODE_SUCCESS, "新建案卷成功", map);
    }

    @Override
    public int deleteJobFileInfoByAjbh(String ajbh) {
        Example example = new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("code", ajbh);
        return fileInfoMapper.deleteByExample(example);
    }

    //案卷公用查询方法（阅卷）
    public List<FileInfoParam> getJobFileInfoByFileAuthoperIdAJYL(FileInfoParam fileInfoParam, SysUser sysUser) {
        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        Map<String, Object> param = sysPermitService.getSysRoleUserMapBySysRoleUser(orgData.getIdCard());
        if (null == param) {
            param = new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        } else {
            param.put("orgCode", orgData.getDeptId());
        }
        if (StringUtils.hasText(fileInfoParam.getCode())) {
            param.put("ajbh", fileInfoParam.getCode().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getName())) {
            param.put("ajmc", fileInfoParam.getName().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getKeywords())) {
            param.put("saryxm", "%" + fileInfoParam.getKeywords() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getSpaceId())) {
            param.put("spaceId", fileInfoParam.getSpaceId());
        }
        if (StringUtils.hasText(fileInfoParam.getOrgSData())) {
            param.put("sstationid", fileInfoParam.getOrgSData());
        }
        if (StringUtils.hasText(fileInfoParam.getOrgTData())) {
            param.put("tstationid", fileInfoParam.getOrgTData());
        }
        if (StringUtils.hasText(fileInfoParam.getHosterId())) {
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        if (StringUtils.hasText(fileInfoParam.getStatus())) {
            param.put("status", fileInfoParam.getStatus());
        }
        if (StringUtils.hasText(fileInfoParam.getType())) {
            param.put("type", fileInfoParam.getType());
        }
        if (StringUtils.hasText(fileInfoParam.getAcceptTimeStart())) {
            Date date = DateTimeUtils.parse(fileInfoParam.getAcceptTimeStart(), null);
            param.put("acceptTimeq", date);
        }
        if (StringUtils.hasText(fileInfoParam.getAcceptTimeEnd())) {
            Date date = DateTimeUtils.parse(fileInfoParam.getAcceptTimeEnd(), null);
            param.put("acceptTimej", date);
        }
        if (StringUtils.hasText(fileInfoParam.getReserve3())) {
            param.put("reserve3", fileInfoParam.getReserve3());
        }

        param.put("start", fileInfoParam.getStart());

        List<FileInfoParam> list = fileInfoMapper.getJobFileInfoByFileAuthoperIdAJYL(param);
        return list;
    }

    @Override
    public List<FileInfoParam> getJobFileInfoByFileAuthoperIdRg(FileInfoParam fileInfoParam, SysUser sysUser) {
        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        Map<String, Object> param = sysPermitService.getSysRoleUserMapBySysRole(sysUser);
        if (null == param) {
            param = new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        } else {
        }
        if (StringUtils.hasText(fileInfoParam.getCode())) {
            param.put("ajbh", fileInfoParam.getCode().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getName())) {
            param.put("ajmc", fileInfoParam.getName().toUpperCase() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getKeywords())) {
            param.put("saryxm", "%" + fileInfoParam.getKeywords() + "%");
        }
        if (StringUtils.hasText(fileInfoParam.getSpaceId())) {
            param.put("spaceId", fileInfoParam.getSpaceId());
        }
        if (StringUtils.hasText(fileInfoParam.getHandleOrgCode())) {
            param.put("handleOrgCode", fileInfoParam.getHandleOrgCode());
        }
        if (StringUtils.hasText(fileInfoParam.getHosterId())) {
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        if (orgData.getOrgCData() != null)
            param.put("orgCData", JobUtil.returnNull(orgData.getOrgCData()));
        if (orgData.getOrgSData() != null)
            param.put("orgSData", JobUtil.returnNull(orgData.getOrgSData()));
        if (orgData.getOrgTData() != null)
            param.put("orgTData", JobUtil.returnNull(orgData.getOrgTData()));
        param.put("status1", JobConstant.JSAJSTATUS);
        param.put("operType1", JobConstant.JSAJSTATUS);
        param.put("status2", JobConstant.PUTONGSTATUS);
        param.put("operType2", JobConstant.PUTONGSTATUS);
        param.put("status3", JobConstant.TQDBSTATUS);
        param.put("status4", JobConstant.YSQSSTATUS);
        param.put("pageStatus1", JobConstant.PUTONGSTATUS);
        param.put("pageStatus2", JobConstant.JSAJSTATUS);
        param.put("orgCode", orgData.getDeptId());
        //param.put("status5", null);
        param.put("status6", JobUtil.IDDEFAULT);
        param.put("yzf", JobConstant.ZUOFEISTATUS);
        param.put("start", fileInfoParam.getStart());
        param.put("ajzfStatus", JobConstant.ZUOFEISTATUS);
        List<FileInfoParam> list = fileInfoMapper.getJobFileInfoByFileAuthoperIdRg(param);

        return list;
    }

    //案卷归档
    public ResponseData AnJuanGuiDang(FileInfo jobFileInfo, UserInfo userInfo) {
        //更新page状态
        List<FilePage> pages=filePageService.getJobFilePageByFileId(jobFileInfo.getId());
        for(FilePage jobFilePage:pages){
            jobFilePage.setStatus(JobConstant.GUIDANGSTATUS);
            jobFilePage.setModerId(userInfo.getIdCard());
            jobFilePage.setModerName(userInfo.getName());
            jobFilePage.setModTime(new Date());
            if(sync_flag){
                Map<String, Object> data = filePageService.TabZfjdArchiveData(jobFilePage,0);
                if(data != null && !"API-COMMON-INF-OK".equals(data.get("statusCode"))){
                    log.error("案卷数据:["+jobFilePage.getId()+"]同步失败,statusCode:["+data.get("statusCode")+"],statusMessage:["+data.get("statusMessage")+"]");
                }else{
                    log.error("案卷数据:["+jobFilePage.getId()+"]同步成功");
                }
            }
            filePageMapper.updateByPrimaryKeySelective(jobFilePage);

        }
        //更新案卷状态
        jobFileInfo.setStatus(JobConstant.GUIDANGSTATUS);
        jobFileInfo.setModerId(userInfo.getIdCard());
        jobFileInfo.setModerName(userInfo.getName());
        jobFileInfo.setModTime(new Date());
        fileInfoMapper.updateByPrimaryKeySelective(jobFileInfo);
        //更新材料状态

        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileId", jobFileInfo.getId());
        List<FileMetal> metals= fileMetalMapper.selectByExample(example);
        for(FileMetal jobFileMetal:metals){
            jobFileMetal.setStatus(JobConstant.GUIDANGSTATUS);
            jobFileMetal.setModerId(userInfo.getIdCard());
            jobFileMetal.setModerName(userInfo.getName());
            jobFileMetal.setModTime(new Date());
            fileMetalMapper.updateByPrimaryKeySelective(jobFileMetal);
        }
        filePageHService.TemporalTableByFileId(jobFileInfo.getId());//将案卷页信息存入历史表
        fileInfoHService.TemporalTableById(jobFileInfo.getId());//将案卷信息存入历史表
        fileMetalHService.TemporalTableByFileId(jobFileInfo.getId());//将材料存入历史表
        FileTrack track=JobUtil.changeTrack(jobFileInfo,userInfo);
        track.setOperType(JobConstant.AJGD);
        track.setOperDetail("由 "+userInfo.getName() +" 将案卷归档");
        track.setStatus(JobConstant.GUIDANGSTATUS);
        track.setLoginType(userInfo.getLoginType());
        fileTrackMapper.insertSelective(track);

        return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"案卷归档成功");
    }

    //变更案卷性质查询列表
    public List<FileInfoParam> getJobFileInfoByFileAuthoperIdChangeNatureData(FileInfoParam fileInfoParam,SysUser sysUser) {
        OrgData orgData=sysPermitService.userOrg(sysUser.getUserId());
        Map<String,Object> map=sysPermitService.getSysRoleUserMapBySysRole(sysUser);
        Map<String,Object> param=new HashMap<String, Object>();
        if(null == map){
            param=new HashMap<String, Object>();
            param.put("operId", orgData.getIdCard());
        }else{
            param.put("orgCode", orgData.getDeptId());
        }
        if(StringUtils.hasText(fileInfoParam.getCode())){
            param.put("ajbh", fileInfoParam.getCode().toUpperCase()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getName())){
            param.put("ajmc", fileInfoParam.getName()+"%");
        }
        if(StringUtils.hasText(fileInfoParam.getHandleOrgCode())){
            param.put("handleOrgCode", fileInfoParam.getHandleOrgCode());
        }
        if(StringUtils.hasText(orgData.getOrgCData())){
            param.put("orgCData", orgData.getOrgCData());
        }
        if(StringUtils.hasText(orgData.getOrgSData())){
            param.put("orgSData", orgData.getOrgSData());
        }
        if(StringUtils.hasText(orgData.getOrgTData())){
            param.put("orgTData", orgData.getOrgTData());
        }

        if(StringUtils.hasText(fileInfoParam.getHosterId())){
            param.put("hosterId", fileInfoParam.getHosterId());
        }
        if(StringUtils.hasText(fileInfoParam.getKeywords())){
            param.put("saryxm","%"+ fileInfoParam.getKeywords()+"%");
        }
//		param.put("type1", JobConstant.XINGSHI);
//		param.put("type2", JobConstant.XINGZHENG);
        param.put("start", fileInfoParam.getStart());
        param.put("orgCode", orgData.getDeptId());
        param.put("status1", JobConstant.PUTONGSTATUS);
        param.put("status2", JobConstant.JSAJSTATUS);
        List<FileInfoParam> list=fileInfoMapper.getJobFileInfoByFileAuthoperIdChangeNatureData(param);
        return list;
    }

    //变更案卷性质
    public void changeFileInfoNature(String temp, String fileId,String tempType,SysUser sysUser) {// tempType 是存储变更后的案件类型(就是选择模板页面选择的类型)
        OrgData orgData=sysPermitService.userOrg(sysUser.getUserId());
        String[] tempIds=temp.trim().split(",");
        FileInfo jobFileInfo=this.getFileInfo(fileId);
        CaseInfo jobCaseInfo= caseInfoService.getCaseInfo(jobFileInfo.getCaseId());
        List<FileTemp> tempList= new ArrayList<>();
        List<FileMetal> metals= new ArrayList<>();
        for(int i=0;i<tempIds.length;i++){//模板信息保存
            //二级模板
            FileTemp jobFileTemp=fileTempService.getFileTemp(tempIds[i]);//选择模板信息

            Example example = new Example(FileTemp.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("diskPath", jobFileTemp.getDiskPath()+"%");
            //子目录
            List<FileTemp> temps= fileTempMapper.selectByExample(example);
            tempList.addAll(temps);
        }

        FileMetal jobFileMetal=new FileMetal();
        String metalName;
        String type;//存储变更前的案件类型名称
        String tempTypeName;//存储变更后的案件类型名称
        if(JobConstant.XINGSHI.equals(tempType)){
            tempTypeName="刑事案卷";
        }else if(JobConstant.XINGZHENG.equals(tempType)){
            tempTypeName="行政案卷";
        }else if(JobConstant.XINGZHENGFUYI.equals(tempType)){
            tempTypeName="行政复议案卷";
        }else if(JobConstant.GUOJIAPEICHANG.equals(tempType)){
            tempTypeName="国家赔偿案卷";
        }else if(JobConstant.XINGZHENGSS.equals(tempType)){
            tempTypeName="行政诉讼案卷";
        }else if(JobConstant.XINGSHIFUYI.equals(tempType)){
            tempTypeName="刑事复议案卷";
        }else{
            tempTypeName="其他案卷";
        }
        if(JobConstant.XINGSHI.equals(jobFileInfo.getType())){
            type="刑事案卷";
            metalName="刑事卷宗";
        }else if(JobConstant.XINGZHENG.equals(jobFileInfo.getType())){
            type="行政案卷";
            metalName="行政卷宗";
        }else if(JobConstant.XINGZHENGFUYI.equals(jobFileInfo.getType())){
            type="行政复议案卷";
            metalName="行政复议卷宗";
        }else if(JobConstant.GUOJIAPEICHANG.equals(jobFileInfo.getType())){
            type="国家赔偿案卷";
            metalName="国家赔偿卷宗";
        }else if(JobConstant.XINGZHENGSS.equals(jobFileInfo.getType())){
            type="行政诉讼案卷";
            metalName="行政诉讼卷宗";
        }else if(JobConstant.XINGSHIFUYI.equals(jobFileInfo.getType())){
            type="刑事复议案卷";
            metalName="刑事复议卷宗";
        }else{
            type="其他案卷";
            metalName="其他卷宗";
        }
        //修改要素库里面该案件的记录
        if(jobCaseInfo != null && StringUtils.hasText(jobCaseInfo.getCode())){
            Example example = new Example(KeAgAjztxx.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("ajbh",jobCaseInfo.getCode());
            KeAgAjztxx keAgAjztxx = keAgAjztxxMapper.selectOneByExample(example);

            if("刑事案卷".equals(tempTypeName)){
                keAgAjztxx.setAjlb("01");
            }else if("行政案卷".equals(tempTypeName)){
                keAgAjztxx.setAjlb("02");
            }else if("行政复议案卷".equals(tempTypeName)){
                keAgAjztxx.setAjlb("03");
            }else if("国家赔偿案卷".equals(tempTypeName)){
                keAgAjztxx.setAjlb("05");
            }else if("行政诉讼案卷".equals(tempTypeName)){
                keAgAjztxx.setAjlb("04");
            }else{
                keAgAjztxx.setAjlb("06");
            }
            if(keAgAjztxx != null){
                keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
            }
        }

        //新加一个材料,如果是 刑事 转 行政 那材料名叫 刑事卷宗  , 如果是 行政 转 刑事 那材料名叫 行政卷宗
        jobFileMetal.setName(metalName);
        String uuid= fileMetalService.JobFileMetalAdd(jobFileMetal,jobFileInfo.getCaseId(),sysUser);

        //删除除了新建的刑事卷宗 或行政卷宗外,其他的材料
        Example example = new Example(FileMetal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fileId", fileId);
        criteria.andNotEqualTo("id", uuid);
        fileMetalMapper.deleteByExample(example);

        FilePage jobFilePage=new FilePage();
        jobFilePage.setMetalId(uuid);
        jobFilePage.setMetalName(metalName);
        jobFilePage.setModerId(orgData.getIdCard());
        jobFilePage.setModerName(orgData.getUserName());
        jobFilePage.setModTime(new Date());
        //将所有的页转到新加的 刑事卷宗  或 行政卷宗 材料下

        Example example2 = new Example(FilePage.class);
        Example.Criteria criteria2 = example2.createCriteria();
        criteria2.andEqualTo("fileId", fileId);
        criteria2.andEqualTo("rowStatus", 3);
        if(sync_flag){
            List<FilePage> pageList = filePageService.getJobFilePageByFileId(fileId);
            for (FilePage jobFilePage1 : pageList) {
                jobFilePage1.setMetalId(uuid);
                jobFilePage1.setMetalName(metalName);
                jobFilePage1.setModerId(orgData.getIdCard());
                jobFilePage1.setModerName(orgData.getUserName());
                jobFilePage1.setModTime(new Date());
                Map<String, Object> data = filePageService.TabZfjdArchiveData(jobFilePage1, 0);
                if(data != null && !"API-COMMON-INF-OK".equals(data.get("statusCode"))){
                    log.error("案卷数据:["+jobFilePage1.getId()+"]同步失败,statusCode:["+data.get("statusCode")+"],statusMessage:["+data.get("statusMessage")+"]");
                }else{
                    log.error("案卷数据:["+jobFilePage1.getId()+"]同步成功");
                }
            }
        }
        filePageMapper.updateByExampleSelective(jobFilePage, example2);

        //将所有的备注转到新加的 刑事卷宗  或 行政卷宗 材料下
        FileNote jobFileNote=new FileNote();
        jobFileNote.setMetalId(uuid);
        jobFileNote.setMetalName(metalName);
        jobFileNote.setModerId(orgData.getIdCard());
        jobFileNote.setModerName(orgData.getUserName());
        jobFileNote.setModTime(new Date());

        Example example3 = new Example(FileNote.class);
        Example.Criteria criteria3 = example3.createCriteria();
        criteria3.andEqualTo("fileId", fileId);
        fileNoteMapper.updateByExampleSelective(jobFileNote, example3);

        //变更案卷的类型
        jobFileInfo.setType(tempType);
        jobFileInfo.setModerId(orgData.getIdCard());
        jobFileInfo.setModerName(orgData.getUserName());
        jobFileInfo.setModTime(new Date());
        fileInfoMapper.updateByPrimaryKeySelective(jobFileInfo);
        //变更案件的类型
        jobCaseInfo.setType(tempType);
        jobCaseInfo.setTypeName(tempTypeName);
        jobCaseInfo.setModerId(orgData.getIdCard());
        jobCaseInfo.setModerName(orgData.getUserName());
        jobCaseInfo.setModTime(new Date());
        caseInfoMapper.updateByPrimaryKeySelective(jobCaseInfo);

        UserInfo userInfo=new UserInfo();
        userInfo.setName(sysUser.getUserName());
        userInfo.setCode(sysUser.getLoginName());
        userInfo.setPoliceCode(orgData.getPoliceCode());
        userInfo.setId(orgData.getIdCard());
        userInfo.setIdCard(orgData.getIdCard());
        userInfo.setLoginType(JobConstant.USERNAMELOGIN);
        userInfo.setDeptCode(orgData.getDeptId());
        userInfo.setDeptName(orgData.getDeptName());

        for(int i=0;i<tempList.size();i++){
            FileTemp fileTemp = tempList.get(i);
            if(fileTemp.getLev()==2){
                FileMetal metal = JobUtil.changeJobFileMetal(fileTemp, jobCaseInfo,userInfo);
                metal.setParentId(JobUtil.IDDEFAULT);
                metal.setTreePath("/"+metal.getId());
                metals.add(metal);
                String tempParentId = fileTemp.getId();
                tempToMetal(jobCaseInfo, tempParentId, metal, tempList, metals,userInfo);
            }
        }
        //新加需要的材料
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
        //更新卷宗的sn
        Integer sn=fileMetalMapper.getJobFileMetalSn(fileId);
        FileMetal metal = new FileMetal();
        metal.setId(uuid);
        metal.setSn(sn+1+0.0);
        fileMetalMapper.updateByPrimaryKeySelective(metal);
        FileTrack jobFileTrack=JobUtil.establishTrack(jobFileInfo,userInfo);
        jobFileTrack.setOperType(JobConstant.CHANGE_PROPERTY);
        jobFileTrack.setLoginType(JobConstant.USERNAMELOGIN);
        jobFileTrack.setOperDetail("由"+userInfo.getName()+"将案卷 '"+jobFileInfo.getName()+"' 从 '"+type+"' 类型变更为 '"+tempTypeName+"' 类型");
        fileTrackMapper.insertSelective(jobFileTrack);
    }
}
