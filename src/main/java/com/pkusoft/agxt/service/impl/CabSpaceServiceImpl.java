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
import org.springframework.util.Assert;
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

    static Map<String, String> act_public = PropertiesFileUtils.readProperties2Map("spaceAct-public.properties");
    static Map<String, String> act_qj = PropertiesFileUtils.readProperties2Map("spaceAct-qj.properties");

    public List<CabSpaceParam> getCabSpaceParamList(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

//        example.setOrderByClause("CREATE_TIME");
        example.setOrderByClause("REGEXP_SUBSTR(NAME, '^\\D*') NULLS FIRST, TO_NUMBER(REGEXP_SUBSTR(NAME, '\\d+'))");
        //The query conditions are edited here
        this.setConditions(criteria, cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());


        List<CabSpace> list = cabSpaceMapper.selectByExampleAndRowBounds(example, rowBounds);
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
        this.setConditions(criteria, cabSpaceParam, sysUser);
        criteria.andEqualTo("curOrg", sysUser.getDeptId());
        return cabSpaceMapper.selectCountByExample(example);
    }

    public List<CabSpace> getCabSpaceList(CabSpaceParam cabSpaceParam, SysUser user) {

        RowBounds rowBounds = new RowBounds(cabSpaceParam.getStart(), cabSpaceParam.getPageSize());
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();

        example.setOrderByClause("group_code,sn");

        this.setConditions2(criteria, cabSpaceParam, user);
        return cabSpaceMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    public int getCabSpaceCount(CabSpaceParam cabSpaceParam, SysUser sysUser) {

        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions2(criteria, cabSpaceParam, sysUser);
        return cabSpaceMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, CabSpaceParam cabSpaceParam, SysUser user) {
        if (StringUtils.hasText(cabSpaceParam.getCode())) {
            criteria.andLike("code", '%' + cabSpaceParam.getCode() + '%');
        }
        if (StringUtils.hasText(cabSpaceParam.getOrgCode())) {
            criteria.andEqualTo("orgCode", cabSpaceParam.getOrgCode());
        }
    }

    private void setConditions2(Example.Criteria criteria, CabSpaceParam cabSpaceParam, SysUser user) {
        OrgData orgData = sysPermitService.userOrg(user.getUserId());
        SysUser sysUser = sysPermitService.getJobFileInfoListBySysRole(orgData.getIdCard());//????????????????????????,????????????????????????????????????
        if (sysUser == null) {
            criteria.andEqualTo("ownerId", orgData.getIdCard());
            if (StringUtils.hasText(cabSpaceParam.getAreaId())) {
                criteria.andEqualTo("areaId", cabSpaceParam.getAreaId());
            }
        } else {//?????????
            if (StringUtils.hasText(cabSpaceParam.getAreaId())) {
                criteria.andEqualTo("areaId", cabSpaceParam.getAreaId());
            }
            criteria.andEqualTo("orgCode", user.getDeptId());
        }
        //???????????????????????????????????????????????????,?????????????????????????????????????????????????????????0????????????,????????????spaceId?????????,??????????????????????????????,???????????????????????????,????????????.
        if (cabSpaceParam.getFileId() != null) {
            FileInfo jobFileInfo = fileInfoMapper.selectByPrimaryKey(cabSpaceParam.getFileId());
            if (cabSpaceParam.getFileId() != null && jobFileInfo.getStatus() != null
                    && (jobFileInfo.getStatus().equals(JobConstant.TQDBSTATUS) || jobFileInfo.getStatus().equals(JobConstant.YSQSSTATUS))) {
                FileStore jobFileStore = fileStoreService.getJobFileStoreByFileCode(jobFileInfo.getCode());
                if (jobFileStore != null && jobFileStore.getSpaceId() != null && !jobFileStore.getSpaceId().equals(JobUtil.IDDEFAULT)) {
                    criteria.andEqualTo("id", jobFileStore.getSpaceId());
                }
            }
        }
        List<String> status = new ArrayList<>();
        status.add("0900");
        status.add("0910");
        status.add("0920");
        status.add("0930");
        criteria.andNotIn("status", status);
    }

    public int cabSpaceSave(CabSpace cabSpace, String ip, String port, SysUser sysUser) {
        String id = UUID.randomUUID().toString();
        cabSpace.setId(id);

        OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
        CabArea jobCabArea = cabAreaService.getCabArea(cabSpace.getAreaId());//?????????
        CabPlace jobCabPlace = cabPlaceService.getCabPlace(jobCabArea.getPlaceId());//?????????

        //?????????
        cabSpace.setId(UUID.randomUUID().toString());
        cabSpace.setName(cabSpace.getCode());
        cabSpace.setPlaceId(jobCabArea.getPlaceId());
        cabSpace.setPlaceName(jobCabArea.getPlaceName());
        cabSpace.setStatus("0000");
        if (!"0040".equals(cabSpace.getReserve2()) && !"0050".equals(cabSpace.getReserve2()) && !"0060".equals(cabSpace.getReserve2()) && !"0070".equals(cabSpace.getReserve2()) && !"0041".equals(cabSpace.getReserve2()) && !"0042".equals(cabSpace.getReserve2())) {
            Double sn = new Double(maxSn() + 1);
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
        cabSpace.setCapacity(2000);//??????????????????????????????2000
        cabSpace.setReserve3("0");
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();//????????????
        CabSpaceAct jobCabSpaceActCheck = new CabSpaceAct();//????????????
        Double sn = cabSpace.getSn();
        String type = cabSpace.getReserve2();
        if (("0050".equals(type) || "0060".equals(type) || "0070".equals(type))) {
            //????????????
//			if(14>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(cabSpace, sysUser, sn, type, ip, port, orgData);//??????????????????
//			}
        } else if (("0040".equals(type) || "0041".equals(type) || "0042".equals(type))) {
            //????????????
//			if(18>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(cabSpace, sysUser, sn, type, ip, port, orgData);//??????????????????
            jobCabSpaceActCheck = insertSpaceActCheck(cabSpace, sysUser, sn, type, ip, port, orgData);//??????????????????
//			}
        } else {
            //???????????????
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
            if (StringUtils.hasText(port)) {
                jobCabSpaceAct.setPort(Integer.valueOf(port));
            }
        }


        //????????????
        if (jobCabArea.getSpaceCount() != null) {
            jobCabPlace.setSpaceCount(jobCabPlace.getSpaceCount() + 1);
        } else {
            jobCabPlace.setSpaceCount(1);
        }
        if (jobCabArea.getSpaceCount() != null) {
            jobCabArea.setSpaceCount(jobCabArea.getSpaceCount() + 1);
        } else {
            jobCabArea.setSpaceCount(1);
        }

        cabPlaceMapper.updateByPrimaryKeySelective(jobCabPlace);
        cabAreaMapper.updateByPrimaryKeySelective(jobCabArea);
        if (jobCabSpaceAct.getId() != null) {
            cabSpaceActMapper.insertSelective(jobCabSpaceAct);
        }
        if (jobCabSpaceActCheck.getId() != null) {
            cabSpaceActMapper.insertSelective(jobCabSpaceActCheck);
        }

        int num = cabSpaceMapper.insertSelective(cabSpace);
        return num;
    }

    public int cabSpaceUpdate(CabSpace cabSpace, SysUser sysUser) {
        int num = cabSpaceMapper.updateByPrimaryKeySelective(cabSpace);
        return num;
    }

    public CabSpace getCabSpace(String id) {
        return cabSpaceMapper.selectByPrimaryKey(id);
    }

    public int cabSpaceDelete(String id) {
        int num = cabSpaceMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public void updateByAreaId(CabArea cabArea, SysUser sysUser) {
        CabSpace cabSpace = new CabSpace();
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
        List<CabSpace> jobCabSpaceList = cabSpaceMapper.select(newCabSpace);
        for (CabSpace jobCabSpace2 : jobCabSpaceList) {
            //?????????????????????
            CabSpaceAct cabSpaceAct = new CabSpaceAct();
            cabSpaceAct.setSpaceId(jobCabSpace2.getId());
            List<CabSpaceAct> jobCabSpaceActList = cabSpaceActMapper.select(cabSpaceAct);
            for (CabSpaceAct jobCabSpaceAct : jobCabSpaceActList) {

                jobCabSpaceAct.setCurOrg(cabArea.getOrgCode());
                cabSpaceActMapper.updateByPrimaryKey(jobCabSpaceAct);
            }
        }
    }

    public List<CabSpace> getJobCabSpaceByreserve1(String reserve1, String code, String orgCode) {
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("reserve1", reserve1);
        criteria.andEqualTo("code", code);
        criteria.andEqualTo("orgCode", orgCode);
        List<CabSpace> list = cabSpaceMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<CabSpace> getJobCabSpaceBySnAndGroupCode(Double sn,
                                                         String groupCode, String areaId) {
        Example example = new Example(CabSpace.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sn", sn);
        criteria.andEqualTo("areaId", areaId);
        criteria.andEqualTo("groupCode", groupCode);
        List<CabSpace> list = cabSpaceMapper.selectByExample(example);
        return list;
    }

    @Override
    public String batchInsertCabSpace(CabSpaceParam cabSpaceParam, SysUser sysUser) {
        String codes = "";
        for (int i = 0; i < cabSpaceParam.getSpaceNoCountValue(); i++) {
            String code = cabSpaceParam.getSpaceNoPrefix() + org.apache.commons.lang.StringUtils.leftPad(String.valueOf(i + cabSpaceParam.getSpaceNoStartValue()), String.valueOf(cabSpaceParam.getSpaceNoStartValue() + cabSpaceParam.getSpaceNoCountValue()).length(), "0");
            if (StringUtils.hasText(cabSpaceParam.getReserve1())) {//????????????????????????SID+code ????????????,??????
                OrgData orgData = sysPermitService.userOrg(sysUser.getUserId());
                List<CabSpace> list = getJobCabSpaceByreserve1(cabSpaceParam.getReserve1(), code, orgData.getDeptId());
                if (list != null && list.size() > 0) {
                    if ("".equals(codes)) {
                        codes = code;
                    } else {
                        codes += ("," + code);
                    }
                    continue;//???????????????sid???code?????????,?????????code??????????????????????????????,??????????????????
                }
            }
            cabSpaceParam.setSn(Double.valueOf(cabSpaceParam.getSpaceNoStartValue() + i));
            cabSpaceParam.setCode(code);
            cabSpaceParam.setName(code);

            CabSpace cabSpace = new CabSpace();
            BeanUtils.copyProperties(cabSpaceParam, cabSpace);
            this.insertJobCabSpaceW(cabSpace, cabSpaceParam.getIp(), cabSpaceParam.getPort(), sysUser);

        }
        return codes;
    }

    @Override
    public int insertJobCabSpaceW(CabSpace jobCabSpace, String ip, String port, SysUser user) {

        OrgData orgData = sysPermitService.userOrg(user.getUserId());
        CabArea jobCabArea = cabAreaService.getCabArea(jobCabSpace.getAreaId());//?????????
        CabPlace jobCabPlace = cabPlaceService.getCabPlace(jobCabArea.getPlaceId());//?????????

        //?????????
        jobCabSpace.setId(UUID.randomUUID().toString());
        jobCabSpace.setName(jobCabSpace.getCode());
        jobCabSpace.setPlaceId(jobCabArea.getPlaceId());
        jobCabSpace.setPlaceName(jobCabArea.getPlaceName());
        jobCabSpace.setStatus("0000");
        if (!"0040".equals(jobCabSpace.getReserve2()) && !"0050".equals(jobCabSpace.getReserve2()) && !"0060".equals(jobCabSpace.getReserve2()) && !"0070".equals(jobCabSpace.getReserve2()) && !"0041".equals(jobCabSpace.getReserve2()) && !"0042".equals(jobCabSpace.getReserve2())) {
            Double sn = new Double(maxSn() + 1);
            jobCabSpace.setSn(sn);
        }

        jobCabSpace.setRowStatus(3);
        jobCabSpace.setCreaterId(orgData.getIdCard());
        jobCabSpace.setCreaterName(user.getUserName());
        jobCabSpace.setCreateTime(new Date());
        jobCabSpace.setModerId(orgData.getIdCard());
        jobCabSpace.setModerName(user.getUserName());
        jobCabSpace.setModTime(new Date());
        jobCabSpace.setOrgC(orgData.getOrgC());
        jobCabSpace.setOrgS(orgData.getOrgS());
        jobCabSpace.setOrgT(orgData.getOrgT());
        jobCabSpace.setOrgCData(orgData.getOrgCData());
        jobCabSpace.setOrgSData(orgData.getOrgSData());
        jobCabSpace.setOrgTData(orgData.getOrgTData());
        jobCabSpace.setCellCount(0);
        jobCabSpace.setCurOrg(orgData.getDeptId());
        jobCabSpace.setCurOrgData(orgData.getDeptId());
        jobCabSpace.setCapacity(2000);//??????????????????????????????2000
        jobCabSpace.setReserve3("0");
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();//????????????
        CabSpaceAct jobCabSpaceActCheck = new CabSpaceAct();//????????????
        Double sn = jobCabSpace.getSn();
        String type = jobCabSpace.getReserve2();
        if (("0050".equals(type) || "0060".equals(type) || "0070".equals(type))) {
            //????????????
//			if(14>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(jobCabSpace, user, sn, type, ip, port, orgData);//??????????????????
//			}
        } else if (("0040".equals(type) || "0041".equals(type) || "0042".equals(type))) {
            //????????????
//			if(18>=sn && sn>=1){
            jobCabSpaceAct = insertSpaceAct(jobCabSpace, user, sn, type, ip, port, orgData);//??????????????????
            jobCabSpaceActCheck = insertSpaceActCheck(jobCabSpace, user, sn, type, ip, port, orgData);//??????????????????
//			}
        } else {
            //???????????????
            jobCabSpaceAct.setId(UUID.randomUUID().toString());
            jobCabSpaceAct.setCode(jobCabSpace.getCode());
            jobCabSpaceAct.setName(jobCabSpace.getName());
            jobCabSpaceAct.setPlaceId(jobCabSpace.getPlaceId());
            jobCabSpaceAct.setPlaceName(jobCabSpace.getPlaceName());
            jobCabSpaceAct.setAreaId(jobCabSpace.getAreaId());
            jobCabSpaceAct.setAreaName(jobCabSpace.getAreaName());
            jobCabSpaceAct.setSpaceId(jobCabSpace.getId());
            jobCabSpaceAct.setSpaceName(jobCabSpace.getName());
            jobCabSpaceAct.setType(jobCabSpace.getType());
            jobCabSpaceAct.setSn(jobCabSpace.getSn());
            jobCabSpaceAct.setRowStatus(3);
            jobCabSpaceAct.setCreaterId(orgData.getIdCard());
            jobCabSpaceAct.setCreaterName(user.getUserName());
            jobCabSpaceAct.setCreateTime(new Date());
            jobCabSpaceAct.setModerId(orgData.getIdCard());
            jobCabSpaceAct.setModerName(user.getUserName());
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
            if (StringUtils.hasText(port)) {
                jobCabSpaceAct.setPort(Integer.valueOf(port));
            }
        }


        //????????????
        if (jobCabArea.getSpaceCount() != null) {
            jobCabPlace.setSpaceCount(jobCabPlace.getSpaceCount() + 1);
        } else {
            jobCabPlace.setSpaceCount(1);
        }
        if (jobCabArea.getSpaceCount() != null) {
            jobCabArea.setSpaceCount(jobCabArea.getSpaceCount() + 1);
        } else {
            jobCabArea.setSpaceCount(1);
        }


        cabPlaceMapper.updateByPrimaryKeySelective(jobCabPlace);
        cabAreaMapper.updateByPrimaryKeySelective(jobCabArea);
        if (jobCabSpaceAct.getId() != null) {
            cabSpaceActMapper.insertSelective(jobCabSpaceAct);
        }
        if (jobCabSpaceActCheck.getId() != null) {
            cabSpaceActMapper.insertSelective(jobCabSpaceActCheck);
        }
        return cabSpaceMapper.insertSelective(jobCabSpace);
    }

    public int deleteJobCabSpace(String[] id) {

        int count = 0;
        for (int i = 0; i < id.length; i++) {
            CabSpace jobCabSpace = cabSpaceMapper.selectByPrimaryKey(id[i]);

            CabPlace newJobCabPlace = cabPlaceMapper.selectByPrimaryKey(jobCabSpace.getPlaceId());
            CabArea newJobCabArea = cabAreaMapper.selectByPrimaryKey(jobCabSpace.getAreaId());
            count = count + cabSpaceMapper.deleteByPrimaryKey(id[i]);

            newJobCabArea.setSpaceCount(newJobCabArea.getSpaceCount() -1);
            newJobCabPlace.setSpaceCount(newJobCabPlace.getSpaceCount() - 1);
            cabAreaMapper.updateByPrimaryKeySelective(newJobCabArea);// ?????????????????????
            cabPlaceMapper.updateByPrimaryKeySelective(newJobCabPlace);// ?????????????????????

        }
        return count;
    }

    public CabSpaceAct insertSpaceActCheck(CabSpace jobCabSpace, SysUser sysUser, Double sn, String type, String ip, String port, OrgData orgData) {
        int i = sn.intValue();
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();
        jobCabSpaceAct.setId(UUID.randomUUID().toString());
        jobCabSpaceAct.setCode(jobCabSpace.getCode());
        jobCabSpaceAct.setType("G0201");
        jobCabSpaceAct.setIp(ip);
        jobCabSpaceAct.setPort(Integer.valueOf(port));
        if ("0040".equals(type)) {
            jobCabSpaceAct.setCmd(act_qj.get("check" + i));
        } else if ("0050".equals(type)) {
            jobCabSpaceAct.setCmd(act_public.get("check" + i));
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

    public CabSpaceAct insertSpaceAct(CabSpace jobCabSpace, SysUser sysUser, Double sn, String type, String ip, String port, OrgData orgData) {
        int i = sn.intValue();
        CabSpaceAct jobCabSpaceAct = new CabSpaceAct();
        jobCabSpaceAct.setId(UUID.randomUUID().toString());
        jobCabSpaceAct.setCode(jobCabSpace.getCode());
        jobCabSpaceAct.setType("G0204");
        jobCabSpaceAct.setIp(ip);
        jobCabSpaceAct.setPort(Integer.valueOf(port));
        if ("0040".equals(type)) {
            jobCabSpaceAct.setCmd(act_qj.get("open" + i));
        } else if ("0050".equals(type)) {
            jobCabSpaceAct.setCmd(act_public.get("open" + i));
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
     * ???????????????
     *
     * @return ????????? sn
     */
    private Double maxSn() {
        Integer sn = cabSpaceMapper.getMaxSN();
        return Double.valueOf(sn);
    }
}
