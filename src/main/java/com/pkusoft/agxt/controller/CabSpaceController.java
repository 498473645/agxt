package com.pkusoft.agxt.controller;


import java.util.*;


import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.usercenter.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import com.pkusoft.agxt.service.CabSpaceService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.OrgData;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷柜空间信息表 相关操作
 */
@Api(value="案卷柜空间信息表",tags={"案卷柜空间信息表 相关操作"})
@Controller
public class CabSpaceController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabSpaceController.class);

    @Autowired
    private CabSpaceService cabSpaceService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysPermitService sysPermitService;

    /**
    * 查询案卷柜空间信息表
    * @param cabSpaceParam
    * @return
    */
    @ApiOperation(value="查询案卷柜空间信息表", notes="查询案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CabSpaceParam>> cabSpaceList(HttpServletRequest request, @RequestBody CabSpaceParam cabSpaceParam){
            ResponseDto<List<CabSpaceParam>> dto = new ResponseDto<List<CabSpaceParam>>();
            SysUser sysUser=sysUserService.getCurrentUser(request);
            try {
                List<CabSpaceParam> list = cabSpaceService.getCabSpaceParamList(cabSpaceParam, sysUser);
                for (int i = 0; i < list.size(); i++) {
                    SysDept dept = sysDeptService.getSysDept(list.get(i).getOrgCode());
                    SysDept dept1 = sysDeptService.getSysDept(list.get(i).getCurOrg());
                    if(dept!=null){
                        list.get(i).setDeptName(dept.getDeptName());
                    }
                    if(dept1!=null){
                        list.get(i).setCurOrgName(dept1.getDeptName());
                    }
                }
                int count = cabSpaceService.getCabSpaceParamCount(cabSpaceParam, sysUser);

                dto.setData(list);
                dto.setCount(count);
                dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
                dto.setStatusMsg("查询案卷柜空间信息表成功");
                return dto;
            } catch (Exception e) {
                log.error("空间表查询列表数据出错", e);
                e.printStackTrace();
                return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"空间表查询列表数据出错");
            }

    }

    /**
    * 新增/修改案卷柜空间信息表
    * @param cabSpace
    * @return
    */
    @ApiOperation(value="新增/修改案卷柜空间信息表", notes="新增/修改案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceSave(@RequestBody CabSpace cabSpace, String ip, String port, HttpServletRequest request){
//        try {
//            List<CabSpace> list = null;
//            cabSpace.setOrgCode(dwId);
//            jobCabSpace.setOrgName(dwmc);
//            jobCabSpace.setOwnerId(id);
//            jobCabSpace.setOwnerName(xm);
//
//            if (cabSpace == null) {
//                return new ResponseData(ResponseData.STATUS_CODE_BIZ, "参数不能为空");
//            }
//            ResponseData responseData = new ResponseData();
//            SysUser sysUser = sysUserService.getCurrentUser(request);
//            OrgData orgData= sysPermitService.userOrg(sysUser.getUserId().toString());
//            if(StringUtils.hasText(jobCabSpace.getReserve1())){
//                list = jobCabSpaceService.getJobCabSpaceByreserve1(jobCabSpace.getReserve1(), jobCabSpace.getCode(), sysUser.getDeptId());
//            }
//            if(!StringUtils.hasText(jobCabSpace.getName())){
//                if(list != null && list.size() > 0){
//                    return new ResponseData(ResponseData.STATUS_CODE_BIZ, "操作失败,该SID+存放空间编码已存在");
//                }
//                if("0040".equals(cabSpace.getReserve2())){
//                    //判断该组中是否存在该柜子
//                    List<CabSpace> jobCabSpaceOld = jobCabSpaceService.getJobCabSpaceBySnAndGroupCode(jobCabSpace.getSn(), jobCabSpace.getGroupCode(),jobCabSpace.getAreaId());
//                    if(jobCabSpaceOld.size()>0){
//                        return new ResponseData(ResponseData.STATUS_CODE_BIZ, "操作失败,该组中已存在此柜子");
//                    }
//                }
//                cabSpaceService.cabSpaceSave(cabSpace,ip,port,sysUser);
//                responseData.setStatusMsg("新增案卷柜空间信息成功！");
//                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
//            }else{	//修改
//
//                cabSpace.setId(jobCabSpace.getName());
//                if(list != null && list.size() > 0 && !jobCabSpace.getId().equals(list.get(0).getId())){
//                    return new ResponseData(ResponseData.STATUS_CODE_BIZ, "操作失败,该SID+存放空间编码已存在");
//                }
//                List<FileStore> jobFileStoreList = jobFileStoreService.getJobFileStoreBySpaceId(jobCabSpace.getId());
//                if(jobFileStoreList.size()>0){
//                    return new ResponseData(ResponseData.STATUS_CODE_BIZ, "操作失败,该空间下的柜子中存在案卷");
//                }else{
//
//                    CabSpace CabSpace=jobCabSpaceService.getByProperty("id",jobCabSpace.getId());
//                    CabTrack jobCabTrack=new CabTrack();
//                    jobCabTrack.setId(UUID.randomUUID().toString());
//                    jobCabTrack.setPlaceId(CabSpace.getPlaceId());
//                    jobCabTrack.setPlaceName(CabSpace.getPlaceName());
//                    jobCabTrack.setAreaId(jobCabSpace.getAreaId());
//                    jobCabTrack.setAreaName(jobCabSpace.getAreaName());
//                    jobCabTrack.setSpaceId(jobCabSpace.getId());
//                    jobCabTrack.setSpaceName(CabSpace.getName());
//                    jobCabTrack.setCellId(JobUtil.IDDEFAULT);
//                    jobCabTrack.setCellName("");
//                    jobCabTrack.setOperTime(new Date());
//                    jobCabTrack.setOperName(sysUser.getUserName());
//                    jobCabTrack.setOperId(orgData.getIdCard());
//                    jobCabTrack.setOperType(JobConstant.DELETE_SPACE);
//                    jobCabTrack.setOperReson(orgData.getUserName()+" 将案卷柜 "+CabSpace.getPlaceName()+" "+CabSpace.getAreaName()+" "+CabSpace.getName()+" 变更为 "+ CabSpace.getPlaceName()+" "+jobCabSpace.getAreaName()+" "+CabSpace.getName());
//                    jobCabTrack.setFileId("");
//                    jobCabTrack.setFileName("");
//                    jobCabTrack.setFileCode("");
//                    jobCabTrack.setMetalId(JobUtil.IDDEFAULT);
//                    jobCabTrack.setMetalName("");
//                    jobCabTrack.setPageId(JobUtil.IDDEFAULT);
//                    jobCabTrack.setPageName("");
//                    jobCabTrack.setStatus("");
//                    jobCabTrack.setRowStatus(3);
//                    jobCabTrack.setCreaterId(orgData.getIdCard());
//                    jobCabTrack.setCreaterName(sysUser.getUserName());
//                    jobCabTrack.setCreateTime(new Date());
//                    jobCabTrack.setModerId(orgData.getIdCard());
//                    jobCabTrack.setModerName(sysUser.getUserName());
//                    jobCabTrack.setModTime(new Date());
//                    jobCabTrack.setOrgC(orgData.getOrgC());
//                    jobCabTrack.setOrgCData(orgData.getOrgCData());
//                    jobCabTrack.setOrgS(orgData.getOrgS());
//                    jobCabTrack.setOrgSData(orgData.getOrgSData());
//                    jobCabTrack.setOrgT(orgData.getOrgT());
//                    jobCabTrack.setOrgTData(orgData.getOrgTData());
//                    WebUtils.getBean(JobCabTrackService.class).insert(jobCabTrack);
//
//
//                    cabSpaceService.cabSpaceUpdate(cabSpace,sysUser);
//                    responseData.setStatusMsg("修改案卷柜空间信息成功！");
//                    responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
//                }
//            }
//            return responseData;
//        }catch ( Exception e){
//            e.printStackTrace();
//            log.error(e.getMessage(), e);
//            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"新增/修改案卷模板信息出错!");
//        }
        return null;
    }

    /**
    * 查看案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷柜空间信息表", notes="查看案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceDetails(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }


	/**
    * 删除案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷柜空间信息表", notes="删除案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceDelete(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

    /**
     * 案卷柜空间信息表列表数据
     *
     * @param cabSpaceParam 查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/jobCabSpaceListDataWeb")
    @ResponseBody
    public ResponseData<List<CabSpace>> jobCabSpaceListDataWeb(@RequestBody CabSpaceParam cabSpaceParam,HttpServletRequest request) {
        ResponseDto<List<CabSpace>> dto = new ResponseDto<List<CabSpace>>();
        try {
            SysUser user = sysUserService.getCurrentUser(request);
            List<CabSpace> list = cabSpaceService.getCabSpaceList(cabSpaceParam, user);
            int count = cabSpaceService.getCabSpaceCount(cabSpaceParam, user);

            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷柜空间信息表成功");
            return dto;
        } catch (Exception e) {
            log.error("空间表查询列表数据出错", e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"空间表查询列表数据出错");
        }
    }

}
