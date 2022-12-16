package com.pkusoft.agxt.controller;


import java.util.*;


import com.alibaba.fastjson.JSON;
import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.agxt.service.FileInfoService;
import com.pkusoft.agxt.service.FileStoreService;
import com.pkusoft.agxt.service.FileTrackService;
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

    @Autowired
    private FileStoreService fileStoreService;

    @Autowired
    private FileTrackService fileTrackService;

    @Autowired
    private CabSpaceService cabSpaceService;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷信息表getCaseListDate
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
    * @param map
    * @return
    */
    @ApiOperation(value="查看案卷信息表", notes="查看案卷信息表")
    @RequestMapping(value = "/fileInfo/fileInfoDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<FileInfo> fileInfoDetails(@RequestBody(required = false) Map<String, String> map){
        String id = map.get("id");
        if (!StringUtils.hasText(id)) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数不能为空");
        }
        try {
            FileInfo fileInfo = fileInfoService.getFileInfo(id);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", fileInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查看案卷信息表出错：" + e.getMessage());
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
    public ResponseData<List<FileInfoParam>> jobFileInfoListDataSMCJNew(@RequestBody FileInfoParam fileInfoParam, HttpServletRequest request) {
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
     * 案卷公用查询方法（阅卷）
     *
     * @param fileInfoParam
     *            查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/jobFileInfoListDataAllNew")
    @ResponseBody
    public ResponseData<List<FileInfoParam>> jobFileInfoListDataNew(@RequestBody FileInfoParam fileInfoParam, HttpServletRequest request) {
        ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
        try {
            SysUser sysUser = sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService.getJobFileInfoByFileAuthoperIdAJYL(fileInfoParam,sysUser);
            for(FileInfoParam jobFileInfoChange: list){

                if(StringUtils.hasText(jobFileInfoChange.getReserve3()) && jobFileInfoChange.getReserve3().equals("1")){
                    jobFileInfoChange.setReserve3("是");
                }else{
                    jobFileInfoChange.setReserve3("否");
                }
            }
            int count = 0;
            if (list.size() > 0) {
                count = Integer.valueOf(list.get(0).getTot_cnt());
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
     * 案卷公用查询方法（案卷整改）
     *
     * @param fileInfoParam
     *            查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/jobFileInfoListDataAll")
    @ResponseBody
    public ResponseData<List<FileInfoParam>> jobFileInfoListData(@RequestBody FileInfoParam fileInfoParam, HttpServletRequest request) {
        ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
        try {
            SysUser sysUser=sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService.getJobFileInfoByFileAuthoperIdAJYL(fileInfoParam,sysUser);
            int count = 0;
            if (list.size() > 0) {
                count = Integer.valueOf(list.get(0).getTot_cnt());
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
     * 案卷公用查询方法（扫描采集）(电子案卷列表信息)
     *
     * @param fileInfoParam
     *            查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/jobFileInfoListDataAllSmcj")
    @ResponseBody
    public ResponseData<List<FileInfoParam>> jobFileInfoListDataSMCJ(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
        try {
            SysUser sysUser = sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService.jobFileInfoListDataSMCJ(fileInfoParam,sysUser);
            int count = 0;
            if (list.size() > 0) {
                count = Integer.valueOf(list.get(0).getTot_cnt());
            }
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷列表信息成功");
            return dto;

        } catch (Exception e) {
            log.error("案卷信息表查询列表数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷信息表查询列表数据出错：" + e.getMessage());
        }
    }

    /**
     * 检查柜子是否在本单位
     *
     * @param fileInfoParam
     * @return
     */
    @RequestMapping("/archives/checkSpaceByOrg")
    @ResponseBody
    public ResponseData checkSpaceByOrg(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        try {
            SysUser sysUser= sysUserService.getCurrentUser(request);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pageId", "00000000-0000-0000-0000-000000000000");
            map.put("metalId", "00000000-0000-0000-0000-000000000000");
            for (int i = 0; i < fileInfoParam.getFileIds().length; i++) {
                map.put("fileId", fileInfoParam.getFileIds()[i]);
                FileStore jobFileStore = fileStoreService.getJobFileStoreByFileIdAndPageIdAndMetalId(map);
                if (StringUtils.hasText(jobFileStore.getSpaceId())) {
                    CabSpace jobCabSpace = cabSpaceService.getCabSpace(jobFileStore.getSpaceId());
                    if (!jobCabSpace.getOrgCode().equals(sysUser.getDeptId())) {
                        return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, jobFileStore.getSpaceName() + "柜子不在本单位，无法开柜！");
                    }
                }
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null);
        } catch (Exception e) {
            log.error("案卷归档失败", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷归档失败：" + e.getMessage());

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

    /**
     * 查询轨迹数据
     *
     * @param fileId
     * @return
     */
    @RequestMapping("/archives/fileInfoActionGlListData")
    @ResponseBody
    public ResponseData<List<FileTrack>> gjcxFileInfoListData(String fileId) {
        ResponseDto<List<FileTrack>> dto = new ResponseDto<>();
        List<FileTrack> list = fileTrackService.getFileTrackListByFileId(fileId);

        dto.setData(list);
        dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
        dto.setStatusMsg("查询轨迹数据成功");
        return dto;
    }

    /**
     * 待入柜案卷列表查询
     *
     * @param fileInfoParam
     *            查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/rgJobFileInfoListDataSpace")
    @ResponseBody
    public ResponseData jobFileInfoListRgData(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        try {
            ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
            SysUser sysUser=sysUserService.getCurrentUser(request);

            List<FileInfoParam> list = fileInfoService.getJobFileInfoByFileAuthoperIdRg(fileInfoParam,sysUser);
            int count = 0;
            if (list.size() != 0) {
                count = Integer.parseInt(list.get(0).getTot_cnt());
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
     * web端案卷归档
     *
     * @param fileId
     * @return
     */
    @RequestMapping("/archives/ajgdFileInfoSave")
    @ResponseBody
    public ResponseData ajgdFileInfoSave(String fileId,HttpServletRequest request) {
        try {
            SysUser sysUser=sysUserService.getCurrentUser(request);
            FileInfo jobFileInfo = fileInfoService.getFileInfo(fileId);
            UserInfo jobUserInfo = new UserInfo();
            jobUserInfo.setId(UUID.randomUUID().toString());
            jobUserInfo.setCode(sysUser.getIdcard());
            jobUserInfo.setName(sysUser.getUserName());

            fileInfoService.AnJuanGuiDang(jobFileInfo, jobUserInfo);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "案卷归档成功");
        } catch (Exception e) {
            log.error("案卷归档失败", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷归档失败：" + e.getMessage());
        }
    }

    /**
     * 变更案卷性质案卷列表
     *
     * @param fileInfoParam
     * @return
     */
    @RequestMapping("/archives/changeNatureData")
    @ResponseBody
    public ResponseData<List<FileInfoParam>> changeNatureData(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        try {
            ResponseDto<List<FileInfoParam>> dto = new ResponseDto<>();
            SysUser sysUser=sysUserService.getCurrentUser(request);
            List<FileInfoParam> list = fileInfoService.getJobFileInfoByFileAuthoperIdChangeNatureData(fileInfoParam,sysUser);
            int count = 0;
            if (list.size() > 0) {
                count = Integer.valueOf(list.get(0).getTot_cnt());
            }
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询变更案卷性质案卷列表成功");
            return dto;
        } catch (Exception e) {
            log.error("案卷信息表查询列表数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷信息表查询列表数据出错：" + e.getMessage());
        }
    }

    /**
     * 变更案卷性质
     *
     * @param fileId
     * @return
     */
    @RequestMapping("/archives/changeFileInfoNature")
    @ResponseBody
    public ResponseData changeFileInfoNature(String temp, String fileId,
                                           String tempType,HttpServletRequest request) {
        try {
            SysUser sysUser=sysUserService.getCurrentUser(request);
            fileInfoService.changeFileInfoNature(temp, fileId, tempType,sysUser);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "变更案卷性质成功");
        } catch (Exception e) {
            log.error("变更案卷性质失败", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "变更案卷性质失败：" + e.getMessage());
        }
    }

    /**
     * 案卷归档/恢复(web端)
     *
     * @param fileInfoParam
     * @return
     */
    @RequestMapping("/archives/ajgdJobFileInfoListData")
    @ResponseBody
    public ResponseData ajgdJobFileInfoListData(@RequestBody FileInfoParam fileInfoParam,HttpServletRequest request) {
        try {
            SysUser sysUser=sysUserService.getCurrentUser(request);
            String bussType = "";
            if (fileInfoParam.getBussType() == null || "".equals(fileInfoParam.getBussType())) {
                bussType = JobConstant.AJGD;
            }
            return fileInfoService
                    .getJobFileInfoListByBussType(sysUser,
                            bussType, fileInfoParam.getPageSize(), fileInfoParam.getStart(),
                            null, null, null, fileInfoParam.getKeywords(),null,null);
        } catch (Exception e) {
            log.error("案卷信息表查询列表数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "案卷信息表查询列表数据出错：" + e.getMessage());
        }
    }


}
