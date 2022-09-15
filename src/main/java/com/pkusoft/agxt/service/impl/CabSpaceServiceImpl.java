package com.pkusoft.agxt.service.impl;

import java.util.*;

import com.pkusoft.agxt.mapper.*;
import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.service.*;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.JobUtil;
import pkubatis.common.utils.OrgData;
import pkubatis.constants.JobConstant;
import pkubatis.constants.PropertiesFileUtils;
import tk.mybatis.mapper.entity.Example;

@Service
@Transactional
public class CabSpaceServiceImpl implements CabSpaceService {

    @Autowired
    private CabSpaceMapper cabSpaceMapper;
    @Autowired
    private CabSpaceActService cabSpaceActService;
    @Autowired
    private CabSpaceActMapper cabSpaceActMapper;
    @Autowired
    private CabAreaService cabAreaService;
    @Autowired
    private CabAreaMapper cabAreaMapper;
    @Autowired
    private CabPlaceService cabPlaceService;
    @Autowired
    private CabPlaceMapper cabPlaceMapper;
    @Autowired
    private SysPermitService sysPermitService;
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private FileStoreService fileStoreService;

    static Map<String, String>  act_public = PropertiesFileUtils.readProperties2Map("spaceAct-public.properties");
    static Map<String, String>  act_qj = PropertiesFileUtils.readProperties2Map("spaceAct-qj.properties");

    public List<CabSpaceParam> getCabSpaceParamList(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

//        example.setOrderByClause("CREATE_TIME");
        example.setOrderByClause("REGEXP_SUBSTR(NAME, '^\\D*') NULLS FIRST, TO_NUMBER(REGEXP_SUBSTR(NAME, '\\d+'))");
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());


        List<CabSpace> list = cabSpaceMapper.selectByExampleAndRowBounds(example,rowBounds);
        List<CabSpaceParam> cabSpaceParamList = new ArrayList<>();
        for (CabSpace cabSpace : list) {
            CabSpaceParam cabSpaceParam1 = new CabSpaceParam();
            BeanUtils.copyProperties(cabSpace, cabSpaceParam1);
            cabSpaceParamList.add(cabSpaceParam1);
        }
        return cabSpaceParamList;
    }

    public int getCabSpaceParamCount(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());
        return cabSpaceMapper.selectCountByExample(example);
    }

    public List<CabSpace> getCabSpaceList(CabSpaceParam cabSpaceParam, SysUser user) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

        example.setOrderByClause("group_code,sn");

        this.setConditions2(criteria,cabSpaceParam, user);
        return cabSpaceMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabSpaceCount(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions2(criteria,cabSpaceParam, sysUser);
        return cabSpaceMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabSpaceParam cabSpaceParam, SysUser user) {
        if(StringUtils.hasText(cabSpaceParam.getCode())){
            criteria.andLike("code", '%' + cabSpaceParam.getCode() + '%');
        }
        if(StringUtils.hasText(cabSpaceParam.getOrgCode())){
            criteria.andEqualTo("orgCode", cabSpaceParam.getOrgCode());
        }
    }

    private void setConditions2(Example.Criteria criteria, CabSpaceParam cabSpaceParam, SysUser user) {
        OrgData orgData= sysPermitService.userOrg(user.getUserId());
        SysUser sysUser= sysPermitService.getJobFileInfoListBySysRole(orgData.getIdCard());//判断是否是案管员,是案管员就返回案管员信息
        if(sysUser==null){
            criteria.andEqualTo("ownerId", orgData.getIdCard());
            if(StringUtils.hasText(cabSpaceParam.getAreaId())){
                criteria.andEqualTo("areaId", cabSpaceParam.getAreaId());
            }
        }else{//案管员
            if(StringUtils.hasText(cabSpaceParam.getAreaId())){
                criteria.andEqualTo("areaId", cabSpaceParam.getAreaId());
            }
            criteria.andEqualTo("orgCode", user.getDeptId());
        }
        //如果案卷的状态是提请逮捕或移送起诉,那么就查出该案卷在存储表中材料和页等于0的那一条,如果该条spaceId不为空,说明该案卷已入该柜子,就只查出这一个柜子,避免分卷.
        if (cabSpaceParam.getFileId() != null) {
            FileInfo jobFileInfo = fileInfoMapper.selectByPrimaryKey(cabSpaceParam.getFileId());
            if(cabSpaceParam.getFileId() != null && jobFileInfo.getStatus() != null
                    && (jobFileInfo.getStatus().equals(JobConstant.TQDBSTATUS) || jobFileInfo.getStatus().equals(JobConstant.YSQSSTATUS))){
                FileStore jobFileStore = fileStoreService.getJobFileStoreByFileCode(jobFileInfo.getCode());
                if(jobFileStore != null && jobFileStore.getSpaceId() != null && !jobFileStore.getSpaceId().equals(JobUtil.IDDEFAULT)){
                    criteria.andEqualTo("id", jobFileStore.getSpaceId());
                }
            }
        }
        List<String> status= new ArrayList<>();
        status.add("0900");
        status.add("0910");
        status.add("0920");
        status.add("0930");
        criteria.andNotIn("status", status);
    }

    public int cabSpaceSave(CabSpace cabSpace, String ip,String port, SysUser sysUser){
        String id = UUID.randomUUID().toString();
        cabSpace.setId(id);

        OrgData orgData= sysPermitService.userOrg(sysUser.getUserId());
        CabArea jobCabArea = cabAreaService.getCabArea(cabSpace.getAreaId());//区域表
        CabPlace jobCabPlace= cabPlaceService.getCabPlace(jobCabArea.getPlaceId());//场所表

        //空间表
        cabSpace.setId(UUID.randomUUID().toString());
        cabSpace.setName(cabSpace.getCode());
        cabSpace.setPlaceId(jobCabArea.getPlaceId());
        cabSpace.setPlaceName(jobCabArea.getPlaceName());
        cabSpace.setStatus("0000");
        if(!"0040".equals(cabSpace.getReserve2()) && !"0050".equals(cabSpace.getReserve2())  && !"0060".equals(cabSpace.getReserve2())  && !"0070".equals(cabSpace.getReserve2()) && !"0041".equals(cabSpace.getReserve2()) && !"0042".equals(cabSpace.getReserve2())){
            Double sn=new Double(maxSn()+1);
            cabSpace.setSn(sn);
        }

        cabSpace.setRowStatus(3);
        cabSpace.setCreaterId(orgData.getIdCard());
        cabSpace.setCreaterName(sysUser.getUserName());
        cabSpace.setCreateTime(new Date());
        cabSpace.setModerId(orgData.getIdCard());
        cabSpace.setModerName(sysUser.getUserName());
        cabSpace.setModTime(new Date());
        cabSpace.setOrgC(orgData.getOrgC());
        cabSpace.setOrgS(orgData.getOrgS());
        cabSpace.setOrgT(orgData.getOrgT());
        cabSpace.setOrgCData(orgData.getOrgCData());
        cabSpace.setOrgSData(orgData.getOrgSData());
        cabSpace.setOrgTData(orgData.getOrgTData());
        cabSpace.setCellCount(0);
        cabSpace.setCurOrg(orgData.getDeptId());
        cabSpace.setCurOrgData(orgData.getDeptId());
        cabSpace.setCapacity(2000);//最大存储数默认设置为2000
        cabSpace.setReserve3("0");
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();//开柜指令
        CabSpaceAct jobCabSpaceActCheck = new CabSpaceAct();//查询指令
        Double sn =cabSpace.getSn();
        String type = cabSpace.getReserve2();
        if(("0050".equals(type) || "0060".equals(type) || "0070".equals(type))){
            //公版柜子
//			if(14>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(cabSpace,sysUser,sn,type,ip,port, orgData);//新增开柜指令
//			}
        }else if(("0040".equals(type) || "0041".equals(type) || "0042".equals(type))){
            //潜江柜子
//			if(18>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(cabSpace,sysUser,sn,type,ip,port, orgData);//新增开柜指令
            jobCabSpaceActCheck  = insertSpaceActCheck(cabSpace,sysUser,sn,type,ip,port, orgData);//新增开柜指令
//			}
        }else{
            //空间指令表
            jobCabSpaceAct.setId(UUID.randomUUID().toString());
            jobCabSpaceAct.setCode(cabSpace.getCode());
            jobCabSpaceAct.setName(cabSpace.getName());
            jobCabSpaceAct.setPlaceId(cabSpace.getPlaceId());
            jobCabSpaceAct.setPlaceName(cabSpace.getPlaceName());
            jobCabSpaceAct.setAreaId(cabSpace.getAreaId());
            jobCabSpaceAct.setAreaName(cabSpace.getAreaName());
            jobCabSpaceAct.setSpaceId(cabSpace.getId());
            jobCabSpaceAct.setSpaceName(cabSpace.getName());
            jobCabSpaceAct.setType(cabSpace.getType());
            jobCabSpaceAct.setSn(cabSpace.getSn());
            jobCabSpaceAct.setRowStatus(3);
            jobCabSpaceAct.setCreaterId(orgData.getIdCard());
            jobCabSpaceAct.setCreaterName(sysUser.getUserName());
            jobCabSpaceAct.setCreateTime(new Date());
            jobCabSpaceAct.setModerId(orgData.getIdCard());
            jobCabSpaceAct.setModerName(sysUser.getUserName());
            jobCabSpaceAct.setModTime(new Date());
            jobCabSpaceAct.setOrgC(orgData.getOrgC());
            jobCabSpaceAct.setOrgS(orgData.getOrgS());
            jobCabSpaceAct.setOrgT(orgData.getOrgT());
            jobCabSpaceAct.setOrgCData(orgData.getOrgCData());
            jobCabSpaceAct.setOrgSData(orgData.getOrgSData());
            jobCabSpaceAct.setOrgTData(orgData.getOrgTData());
            jobCabSpaceAct.setCurOrg(orgData.getDeptId());
            jobCabSpaceAct.setCurOrgData(orgData.getDeptId());
            jobCabSpaceAct.setIp(ip);
            if(StringUtils.hasText(port)){
                jobCabSpaceAct.setPort(Integer.valueOf(port));
            }
        }


        //空间总数
        if(jobCabArea.getSpaceCount()!=null){
            jobCabPlace.setSpaceCount(jobCabPlace.getSpaceCount()+1);
        }else{
            jobCabPlace.setSpaceCount(1);
        }
        if(jobCabArea.getSpaceCount()!=null){
            jobCabArea.setSpaceCount(jobCabArea.getSpaceCount()+1);
        }else{
            jobCabArea.setSpaceCount(1);
        }

        cabPlaceMapper.updateByPrimaryKeySelective(jobCabPlace);
        cabAreaMapper.updateByPrimaryKeySelective(jobCabArea);
        if(jobCabSpaceAct.getId() != null){
            cabSpaceActMapper.insertSelective(jobCabSpaceAct);
        }
        if(jobCabSpaceActCheck.getId() != null){
            cabSpaceActMapper.insertSelective(jobCabSpaceActCheck);
        }

        int num = cabSpaceMapper.insertSelective(cabSpace);
        return num;
    }

    public int cabSpaceUpdate(CabSpace cabSpace, SysUser sysUser){
        int num = cabSpaceMapper.updateByPrimaryKeySelective(cabSpace);
        return num;
    }

    public CabSpace getCabSpace(String id){
        return cabSpaceMapper.selectByPrimaryKey(id);
    }

    public int cabSpaceDelete(String id){
        int num = cabSpaceMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public void updateByAreaId(CabArea cabArea, SysUser sysUser) {
        CabSpace cabSpace=new CabSpace();
        cabSpace.setOrgCode(cabArea.getOrgCode());
        cabSpace.setOrgName(cabArea.getOrgName());
        cabSpace.setOwnerId("");
        cabSpace.setOwnerName("");
        cabSpace.setAreaName(cabArea.getName());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("areaId", cabArea.getId());
        cabSpaceMapper.updateByExampleSelective(cabSpace, example);

        CabSpace newCabSpace = new CabSpace();
        newCabSpace.setAreaId(cabArea.getId());
        List<CabSpace> jobCabSpaceList= cabSpaceMapper.select(newCabSpace);
        for (CabSpace jobCabSpace2 : jobCabSpaceList) {
            //修改空间指令表
            CabSpaceAct cabSpaceAct = new CabSpaceAct();
            cabSpaceAct.setSpaceId(jobCabSpace2.getId());
            List<CabSpaceAct> jobCabSpaceActList = cabSpaceActMapper.select(cabSpaceAct);
            for(CabSpaceAct jobCabSpaceAct : jobCabSpaceActList){

                jobCabSpaceAct.setCurOrg(cabArea.getOrgCode());
                cabSpaceActMapper.updateByPrimaryKey(jobCabSpaceAct);
            }
        }
    }

    public CabSpaceAct insertSpaceActCheck(CabSpace jobCabSpace,SysUser sysUser,Double sn,String type,String ip,String port,OrgData orgData){
        int i=sn.intValue();
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();
        jobCabSpaceAct.setId(UUID.randomUUID().toString());
        jobCabSpaceAct.setCode(jobCabSpace.getCode());
        jobCabSpaceAct.setType("G0201");
        jobCabSpaceAct.setIp(ip);
        jobCabSpaceAct.setPort(Integer.valueOf(port));
        if("0040".equals(type)){
            jobCabSpaceAct.setCmd(act_qj.get("check"+i));
        }else if("0050".equals(type)){
            jobCabSpaceAct.setCmd(act_public.get("check"+i));
        }
        jobCabSpaceAct.setSn(sn);
        jobCabSpaceAct.setMemo(jobCabSpace.getReserve2());
        jobCabSpaceAct.setName(jobCabSpace.getCode());
        jobCabSpaceAct.setPlaceId(jobCabSpace.getPlaceId());
        jobCabSpaceAct.setPlaceName(jobCabSpace.getPlaceName());
        jobCabSpaceAct.setAreaId(jobCabSpace.getAreaId());
        jobCabSpaceAct.setAreaName(jobCabSpace.getAreaName());
        jobCabSpaceAct.setSpaceId(jobCabSpace.getId());
        jobCabSpaceAct.setSpaceName(jobCabSpace.getName());
        jobCabSpaceAct.setCreaterId(sysUser.getIdcard());
        jobCabSpaceAct.setCreaterName(sysUser.getUserName());
        jobCabSpaceAct.setCreateTime(new Date());
        jobCabSpaceAct.setModerId(sysUser.getIdcard());
        jobCabSpaceAct.setModerName(sysUser.getUserName());
        jobCabSpaceAct.setModTime(new Date());
        jobCabSpaceAct.setOrgC(orgData.getOrgC());
        jobCabSpaceAct.setOrgS(orgData.getOrgS());
        jobCabSpaceAct.setOrgT(orgData.getOrgT());
        jobCabSpaceAct.setOrgCData(orgData.getOrgCData());
        jobCabSpaceAct.setOrgSData(orgData.getOrgSData());
        jobCabSpaceAct.setOrgTData(orgData.getOrgTData());
        jobCabSpaceAct.setCurOrg(orgData.getDeptId());
        jobCabSpaceAct.setCurOrgData(orgData.getDeptId());
        return jobCabSpaceAct;
    }

    public CabSpaceAct insertSpaceAct(CabSpace jobCabSpace,SysUser sysUser,Double sn,String type,String ip,String port,OrgData orgData){
        int i=sn.intValue();
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();
        jobCabSpaceAct.setId(UUID.randomUUID().toString());
        jobCabSpaceAct.setCode(jobCabSpace.getCode());
        jobCabSpaceAct.setType("G0204");
        jobCabSpaceAct.setIp(ip);
        jobCabSpaceAct.setPort(Integer.valueOf(port));
        if("0040".equals(type)){
            jobCabSpaceAct.setCmd(act_qj.get("open"+i));
        }else if("0050".equals(type)){
            jobCabSpaceAct.setCmd(act_public.get("open"+i));
        }
        jobCabSpaceAct.setSn(sn);
        jobCabSpaceAct.setMemo(jobCabSpace.getReserve2());
        jobCabSpaceAct.setName(jobCabSpace.getCode());
        jobCabSpaceAct.setPlaceId(jobCabSpace.getPlaceId());
        jobCabSpaceAct.setPlaceName(jobCabSpace.getPlaceName());
        jobCabSpaceAct.setAreaId(jobCabSpace.getAreaId());
        jobCabSpaceAct.setAreaName(jobCabSpace.getAreaName());
        jobCabSpaceAct.setSpaceId(jobCabSpace.getId());
        jobCabSpaceAct.setSpaceName(jobCabSpace.getName());
        jobCabSpaceAct.setCreaterId(sysUser.getIdcard());
        jobCabSpaceAct.setCreaterName(sysUser.getUserName());
        jobCabSpaceAct.setCreateTime(new Date());
        jobCabSpaceAct.setModerId(sysUser.getIdcard());
        jobCabSpaceAct.setModerName(sysUser.getUserName());
        jobCabSpaceAct.setModTime(new Date());
        jobCabSpaceAct.setOrgC(orgData.getOrgC());
        jobCabSpaceAct.setOrgS(orgData.getOrgS());
        jobCabSpaceAct.setOrgT(orgData.getOrgT());
        jobCabSpaceAct.setOrgCData(orgData.getOrgCData());
        jobCabSpaceAct.setOrgSData(orgData.getOrgSData());
        jobCabSpaceAct.setOrgTData(orgData.getOrgTData());
        jobCabSpaceAct.setCurOrg(orgData.getDeptId());
        jobCabSpaceAct.setCurOrgData(orgData.getDeptId());
        return jobCabSpaceAct;
    }

    /**
     * 最大排序号
     *
     * @return 排序号 sn
     */
    private Double maxSn() {
        Integer sn = cabSpaceMapper.getMaxSN();
        return Double.valueOf(sn);
    }
}
