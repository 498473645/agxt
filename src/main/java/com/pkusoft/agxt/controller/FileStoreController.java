package com.pkusoft.agxt.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.model.UserInfo;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.req.FileStoreParam;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.agxt.service.FileInfoService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.usercenter.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import com.pkusoft.agxt.service.FileStoreService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.OrgData;
import pkubatis.constants.JobConstant;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷存储表 相关操作
 */
@Api(value="案卷存储表",tags={"案卷存储表 相关操作"})
@Controller
public class FileStoreController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileStoreController.class);

    @Autowired
    private FileStoreService fileStoreService ;

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    private CabSpaceService cabSpaceService;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermitService sysPermitService;

    /**
    * 查询案卷存储表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷存储表", notes="查询案卷存储表")
    @RequestMapping(value = "/fileStore/fileStoreList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileStoreList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷存储表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷存储表", notes="新增案卷存储表")
    @RequestMapping(value = "/fileStore/fileStoreSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileStoreSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷存储表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷存储表", notes="修改案卷存储表")
    @RequestMapping(value = "/fileStore/fileStoreUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileStoreUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷存储表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷存储表", notes="查看案卷存储表")
    @RequestMapping(value = "/fileStore/fileStoreDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileStoreDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷存储表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷存储表", notes="删除案卷存储表")
    @RequestMapping(value = "/fileStore/fileStoreDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileStoreDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
     * 存储位置变更
     *
     * @param fileStoreParam 对象
     * @return json结果
     */
    @RequestMapping(value = "/archives/jobFileStoreChangeSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData jobFileInfoChangeSpaceSave(@RequestBody(required = false) FileStoreParam fileStoreParam, HttpServletRequest request) {
        FileStore jobFileStore=new FileStore();
        SysUser sysUser = sysUserService.getCurrentUser(request);
        try {
            String[] fileIds= fileStoreParam.getFileCode().split(",");
            List<String> list = new ArrayList<String>();
            for(int i=0;i<fileIds.length;i++){
                list.add(fileIds[i]);
            }

            FileInfoParam fileInfoParam = new FileInfoParam();
            fileInfoParam.setIdList(list);
            List<FileInfo> jobfileinfo = fileInfoService.getFileInfoListByIdList(fileInfoParam, sysUser);
            if(jobfileinfo.size()>0){
                jobFileStore = fileStoreService.getJobFileStoreByFileCode(jobfileinfo.get(0).getCode());
            }
            CabSpace jobCabSpace = cabSpaceService.getCabSpace(fileStoreParam.getSpaceId());
            UserInfo userInfo=new UserInfo();
            OrgData orgData= sysPermitService.userOrg(sysUser.getUserId().toString());
            userInfo.setId(sysUser.getUserId().toString());
            userInfo.setIdCard(orgData.getIdCard());
            userInfo.setPoliceCode(orgData.getPoliceCode());
            userInfo.setName(sysUser.getUserName());
            userInfo.setLoginType(JobConstant.USERNAMELOGIN);
//			userInfo.setReserve1(orgData.getDeptId());
            userInfo.setDeptCode(orgData.getDeptId());
            userInfo.setDeptName(orgData.getDeptName());
            fileStoreService.updateJobFileStoreByJobCabSpaceBGWZ(jobfileinfo,jobCabSpace,userInfo);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, jobFileStore.getSpaceId());
        } catch (Exception e) {
            log.error("保存案卷存储表出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "保存案卷存储表出错：" + e.getMessage());
        }
    }
}
