package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.*;
import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.CaseInfoParam;
import com.pkusoft.agxt.service.*;
import com.pkusoft.lesp.mapper.KeAgAjztxxMapper;
import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.model.KeAjSary;
import com.pkusoft.lesp.service.KeAgAjztxxService;
import com.pkusoft.lesp.service.KeAjSaryService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.JobUtil;
import pkubatis.common.utils.OrgData;
import pkubatis.common.utils.PinyinUtils;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
@Transactional
public class CaseInfoServiceImpl implements CaseInfoService {

    @Autowired
    private CaseInfoMapper caseInfoMapper;

    @Autowired
    private FileTempService fileTempService;

    @Autowired
    private FileTempMapper fileTempMapper;

    @Autowired
    private KeAjSaryService keAjSaryService;

    @Autowired
    private KeAgAjztxxService keAgAjztxxService;

    @Autowired
    private KeAgAjztxxMapper keAgAjztxxMapper;

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private FileMetalService fileMetalService;

    @Autowired
    private FileNoteService fileNoteService;

    @Autowired
    private FileAuthService fileAuthService;

    @Autowired
    private FilePageRecycleService filePageRecycleService;

    @Autowired
    private FilePageService filePageService;

    @Autowired
    private FileStoreService fileStoreService;

    @Autowired
    private CaseHandlerService caseHandlerService;

    @Autowired
    private CaseOrgService caseOrgService;

    @Autowired
    private CasePersonService casePersonService;

    @Autowired
    private SysPermitService sysPermitService;

    public List<CaseInfo> getCaseInfoList(CaseInfoParam caseInfo, SysUser user) {

        RowBounds rowBounds = new RowBounds(caseInfo.getStart(),caseInfo.getPageSize());
        Example example = new Example(CaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCaseInfoCount(CaseInfoParam caseInfo, SysUser user) {
        RowBounds rowBounds = new RowBounds(caseInfo.getStart(),caseInfo.getPageSize());
        Example example = new Example(CaseInfo.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return caseInfoMapper.selectCountByExample(example);
    }

    public int caseInfoSave(CaseInfo caseInfo, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        caseInfo.setId(id);
        int num = caseInfoMapper.insertSelective(caseInfo);
        return num;
    }

    public int caseInfoUpdate(CaseInfo caseInfo, Map<String,String> map){
        int num = caseInfoMapper.updateByPrimaryKeySelective(caseInfo);
        return num;
    }

    public CaseInfo getCaseInfo(String id){
        return caseInfoMapper.selectByPrimaryKey(id);
    }

    public int caseInfoDelete(String id){
        int num = caseInfoMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public int insertLsCaseInfo(CaseInfo jobCaseInfo,SysUser sysUser) {
        Date date=new Date();
        OrgData orgDataUser= sysPermitService.userOrg(sysUser.getUserId().toString());
        OrgData orgData= sysPermitService.userOrg(jobCaseInfo.getHosterId());
        String code="";//案件名称拼音码
        String hosterName="";//主办人姓名拼音码
        //案件
        String uid=UUID.randomUUID().toString();
        jobCaseInfo.setId(uid);
        jobCaseInfo.setSn(0.00);
        jobCaseInfo.setCaseTimeD(jobCaseInfo.getCaseTimeU());
        jobCaseInfo.setHosterPcode(orgData.getPoliceCode());
        jobCaseInfo.setCurstepId(JobUtil.IDDEFAULT);
        jobCaseInfo.setRowStatus(3);
        jobCaseInfo.setFilesCount(0);
        jobCaseInfo.setCreaterId(orgDataUser.getIdCard());
        jobCaseInfo.setCreaterName(sysUser.getUserName());
//		jobCaseInfo.setCaseTimeD(new Date());
        jobCaseInfo.setModerId(orgDataUser.getIdCard());
        jobCaseInfo.setModerName(sysUser.getUserName());
        jobCaseInfo.setModTime(date);
        jobCaseInfo.setOrgC(orgData.getOrgC());
        jobCaseInfo.setOrgS(orgData.getOrgS());
        jobCaseInfo.setOrgT(orgData.getOrgT());
        jobCaseInfo.setOrgCData(orgData.getOrgCData());
        jobCaseInfo.setOrgSData(orgData.getOrgSData());
        jobCaseInfo.setOrgTData(orgData.getOrgTData());
        jobCaseInfo.setCurOrg(orgData.getDeptId());
        jobCaseInfo.setCurOrgData(orgData.getDeptId());
        jobCaseInfo.setDataSource("1");//临时手工录入
        if(jobCaseInfo.getName() != null && !jobCaseInfo.getName().equals("")){
            code = PinyinUtils.getPinyin(jobCaseInfo.getName()).toUpperCase();//案卷拼音码
            jobCaseInfo.setNameSpell(code);

        }
        if(StringUtils.hasText(jobCaseInfo.getHosterName())){
            hosterName=PinyinUtils.getPinyin(jobCaseInfo.getHosterName()).toUpperCase();//主办人拼音码
            jobCaseInfo.setHosterSpell(hosterName);
        }

        Example example = new Example(FileTemp.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", jobCaseInfo.getType());
        criteria.andEqualTo("id", jobCaseInfo.getReserve1());
        criteria.andEqualTo("parentId", JobUtil.IDDEFAULT);

        List<FileTemp> list = fileTempMapper.selectByExample(example);
        jobCaseInfo.setReserve1(null);
        List<FileTemp> temps=new ArrayList<FileTemp>();
        //模板
        if(list.size()>0&&list!=null){
            Example example2 = new Example(FileTemp.class);
            Example.Criteria criteria2 = example.createCriteria();

            criteria2.andLike("treePath", list.get(0).getTreePath()+"%");
            temps = fileTempMapper.selectByExample(example2);
            if (temps.size()==1) {
                return 1;
            }
        }else{
            return 1;
        }

        //用户信息
        UserInfo userInfo=new UserInfo();
        userInfo.setName(sysUser.getUserName());
        userInfo.setCode(sysUser.getLoginName());
        userInfo.setPoliceCode(orgData.getPoliceCode());
        userInfo.setId(orgData.getIdCard());
        userInfo.setIdCard(orgData.getIdCard());
        userInfo.setLoginType(JobConstant.USERNAMELOGIN);
        CabSpace jobCabSpace=new CabSpace();
        jobCabSpace.setId(JobUtil.IDDEFAULT);
        jobCabSpace.setAreaId(JobUtil.IDDEFAULT);
        jobCabSpace.setPlaceId(JobUtil.IDDEFAULT);

        userInfo.setDeptCode(orgData.getDeptId());
        userInfo.setDeptName(orgData.getDeptName());
        //建卷

        //手动建卷时向案件状态信息表插入基础数据
        KeAgAjztxx keAgAjztxx=new KeAgAjztxx();
        keAgAjztxx.setAjbh(jobCaseInfo.getCode());
        keAgAjztxx.setAjmc(jobCaseInfo.getName());
        keAgAjztxx.setAjmcPym(code);
        keAgAjztxx.setAjlb(JobUtil.operationType(jobCaseInfo.getType(), 1));
        keAgAjztxx.setSlsj(jobCaseInfo.getAcceptTime());
        keAgAjztxx.setBadwBm(jobCaseInfo.getHandleOrgCode());
        keAgAjztxx.setBadwMc(jobCaseInfo.getHandleOrgName());
        keAgAjztxx.setZbrSfzhm(jobCaseInfo.getHosterId());
        keAgAjztxx.setZbrJh(jobCaseInfo.getHosterPcode());
        keAgAjztxx.setZbrXm(jobCaseInfo.getHosterName());
        keAgAjztxx.setZbrXmPym(hosterName);
        keAgAjztxx.setAjSjzt("0");
        keAgAjztxx.setCstationid(orgData.getOrgCData());
        keAgAjztxx.setSstationid(orgData.getOrgSData());
        keAgAjztxx.setTstationid(orgData.getOrgTData());
        keAgAjztxx.setZt1("1");
        keAgAjztxx.setZt1CzyBh(orgDataUser.getIdCard());
        keAgAjztxx.setZt1CzyXm(sysUser.getUserName());
        keAgAjztxx.setZt1Czsj(date);
        keAgAjztxx.setZt2("0");
        keAgAjztxx.setZt3("0");
        keAgAjztxx.setZt4("0");
        keAgAjztxx.setZt5("0");
        keAgAjztxx.setZt6("0");
        keAgAjztxx.setZt7("0");
        keAgAjztxx.setZt8("0");
        keAgAjztxx.setZt9("0");
        keAgAjztxx.setZt10("0");
        if(jobCaseInfo.getCode() != null){
            String saryxm=null;
            String saryxmpym=null;
            List<KeAjSary> keAjSaryList=keAjSaryService.getKeAjSaryByAjbh(jobCaseInfo.getCode(), "1");
            if(keAjSaryList != null && keAjSaryList.size() > 0){
                for(KeAjSary keAjSary : keAjSaryList){
                    if(keAjSary.getXm() != null){
                        if(saryxm == null){
                            saryxm = keAjSary.getXm();
                            saryxmpym = PinyinUtils.getPinyin(keAjSary.getXm()).toUpperCase();
                        }else{
                            saryxm +=(","+ keAjSary.getXm());
                            saryxmpym += ("," + PinyinUtils.getPinyin(keAjSary.getXm()).toUpperCase());
                        }
                    }
                }
                keAgAjztxx.setSaryxm(saryxm);
                keAgAjztxx.setSaryxmpym(saryxmpym);
            }
        }
        keAgAjztxxMapper.insertSelective(keAgAjztxx);
        fileInfoService.jianJuan(jobCaseInfo, temps, jobCabSpace, userInfo);
        return 0;
    }

    @Override//案件删除和案卷作废后重新建卷要删除原来数据.
    public void deleteZFSCAJ(String ajbh) {
        Example caseInfoExample = new Example(CaseInfo.class);
        Example.Criteria caseInfoCriteria = caseInfoExample.createCriteria();
        caseInfoCriteria.andEqualTo("code", ajbh);
        caseInfoMapper.deleteByExample(caseInfoExample);

        fileAuthService.deleteJobFileAuthByAjbh(ajbh);
        fileInfoService.deleteJobFileInfoByAjbh(ajbh);
        fileMetalService.deleteJobFileMetalByAjbh(ajbh);
        fileNoteService.deleteJobFileNoteByAjbh(ajbh);
        //通过案件编号获取案卷页信息
        List<FilePage> jobFilePagelist= filePageService.getJobFilePageByajbh(ajbh);
        //保存案卷页信息到案卷页回收记录表
        filePageRecycleService.saveFilePageRecycle(jobFilePagelist);
        filePageService.deleteJobFilePageByAjbh(ajbh);
        fileStoreService.deleteJobFileStoreByAjbh(ajbh);
        caseHandlerService.deleteJobCaseHandlerByAjbh(ajbh);
        caseOrgService.deleteJobCaseOrgByAjbh(ajbh);
        casePersonService.deleteJobCasePersonByAjbh(ajbh);
    }
}
