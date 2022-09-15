package com.pkusoft.agxt.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.FileInfo;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.service.FileInfoService;
import com.pkusoft.usercenter.po.SysUser;
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





import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.constants.JobConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷信息表 相关操作
 */
@Api(value="案卷信息表",tags={"案卷信息表 相关操作"})
@Controller
public class FileInfoController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileInfoController.class);

    @Autowired
    private FileInfoService fileInfoService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷信息表", notes="查询案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileInfoList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷信息表", notes="新增案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileInfoSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷信息表", notes="修改案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileInfoUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷信息表", notes="查看案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileInfoDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷信息表", notes="删除案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileInfoDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
     * 检查案件是否已经建卷
     *
     * @param fileInfo
     * @return
     */
    @RequestMapping(value = "/fileInfo/checkCaseInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData checkCaseInfo(@RequestBody(required = false) FileInfo fileInfo) {
        try {
            FileInfo jobFileInfo = fileInfoService.checkCaseInfo(fileInfo);
            if (jobFileInfo == null) {
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null);
            } else {
                // 案卷作废后重新建卷要删除原来数据.
                if (JobConstant.ZUOFEISTATUS.equals(jobFileInfo.getStatus())) {
                    return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,
                            "案件 "
                                    + jobFileInfo.getName()
                                    + "( "
                                    + jobFileInfo.getCode()
                                    + " )曾创建过案卷，但是被作废掉了。如果您现在重新创建案卷，以前已采集的案卷信息将会全部丢失，并且不可恢复。是否继续建卷?");
                } else {
                    return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "案件已建卷，无法重复建卷！");
                }
            }
        } catch (Exception e) {
            log.error("检查案件是否已经建卷失败", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "检查案件是否已经建卷失败：" + e.getMessage());
        }
    }

    /**
     * 案卷采集
     * @param fileInfoParam
     * @param request
     * @return
     */
    @RequestMapping("/archives/jobFileInfoListDataAllSmcjNew")
    @ResponseBody
    public ResponseData jobFileInfoListDataSMCJNew(@RequestBody FileInfoParam fileInfoParam, HttpServletRequest request) {
        ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
        try {
            SysUser sysUser= sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService.jobFileInfoListDataSMCJ(fileInfoParam,sysUser);
            int count = 0;
            if (list.size() > 0) {
                count = Integer.valueOf(list.get(0).getTot_cnt());
            }
            for(FileInfoParam jobFileInfoChange: list){
                if(StringUtils.hasText(jobFileInfoChange.getReserve3()) && jobFileInfoChange.getReserve3().equals("1")){
                    jobFileInfoChange.setReserve3("是");
                }else{
                    jobFileInfoChange.setReserve3("否");
                }
            }
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷模板树信息表成功");
            return dto;

        } catch (Exception e) {
            log.error("案卷信息表查询列表数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷信息表查询列表数据出错：" + e.getMessage());
        }
    }

    /**
     * 案卷存储位置变更
     *
     * @param fileInfoParam
     *            查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/rgJobFileInfoListDataChangeSpace")
    @ResponseBody
    public ResponseData jobFileInfoListChangeSpaceData(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        try {
            ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
            SysUser sysUser= sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService
                    .getJobFileInfoByFileAuthoperIdKg(fileInfoParam,sysUser);
            dto.setData(list);
            dto.setCount(list.size());
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷模板树信息表成功");
            return dto;
        } catch (Exception e) {
            log.error("案卷信息表查询列表数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷信息表查询列表数据出错：" + e.getMessage());
        }
    }

}
