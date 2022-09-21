package com.pkusoft.agxt.controller;


import com.pkusoft.agxt.model.CaseInfo;
import com.pkusoft.agxt.req.CaseInfoParam;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.service.CaseInfoService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysUserService;
import com.pkusoft.usercenter.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 案件信息表 相关操作
 */
@Api(value="案件信息表",tags={"案件信息表 相关操作"})
@Controller
public class CaseInfoController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CaseInfoController.class);

    @Autowired
    private CaseInfoService caseInfoService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 案卷创建 案件查询
    * @param caseInfo
    * @return
    */
    @ApiOperation(value="案件查询", notes="案件查询")
    @RequestMapping(value = "/caseInfo/caseInfoList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CaseInfo>> caseInfoList(HttpServletRequest request, @RequestBody CaseInfoParam caseInfo){
        ResponseDto<List<CaseInfo>> dto = new ResponseDto<List<CaseInfo>>();
        try{
            SysUser user = sysUserService.getCurrentUser(request);
            List<CaseInfo> list = caseInfoService.getCaseInfoList(caseInfo,user);
            int count = caseInfoService.getCaseInfoCount(caseInfo,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询业务类型数据成功");
            return dto;
        }catch(Exception e){
            log.error("查询业务类型数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询业务类型");
        }
    }

    /**
     * 保存临时案件信息
     *
     * @param jobCaseInfo 对象
     * @return json结果
     */
    @RequestMapping(value = "/archives/lsCaseInfoSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData lsCaseInfoSave(CaseInfo jobCaseInfo,HttpServletRequest request) {
        try {
            SysUser sysUser = sysUserService.getCurrentUser(request);
            int i= caseInfoService.insertLsCaseInfo(jobCaseInfo,sysUser);
            if(i==1){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "没有可用的模板！");
            }else{
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null);
            }
        } catch (Exception e) {
            log.error("保存临时案件信息出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"保存临时案件信息出错");
        }
    }

    /**
    * 新增案件信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案件信息表", notes="新增案件信息表")
    @RequestMapping(value = "/caseInfo/caseInfoSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> caseInfoSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案件信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案件信息表", notes="修改案件信息表")
    @RequestMapping(value = "/caseInfo/caseInfoUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> caseInfoUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案件信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案件信息表", notes="查看案件信息表")
    @RequestMapping(value = "/caseInfo/caseInfoDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> caseInfoDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案件信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案件信息表", notes="删除案件信息表")
    @RequestMapping(value = "/caseInfo/caseInfoDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> caseInfoDelete(@RequestBody(required = false) Map<String, String> requestBody){
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

}
