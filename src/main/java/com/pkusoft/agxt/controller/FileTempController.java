package com.pkusoft.agxt.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.req.KeAgAjztxxParam;
import com.pkusoft.usercenter.po.SysUser;
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



import com.pkusoft.agxt.service.FileTempService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷模板信息表 相关操作
 */
@Api(value="案卷模板信息表",tags={"案卷模板信息表 相关操作"})
@Controller
public class FileTempController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileTempController.class);

    @Autowired
    private FileTempService fileTempService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷模板信息表
    * @param fileTempParam
    * @return
    */
    @ApiOperation(value="查询案卷模板信息表", notes="查询案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<FileTemp>> fileTempList(HttpServletRequest request, @RequestBody FileTempParam fileTempParam){
        ResponseDto<List<FileTemp>> dto = new ResponseDto<List<FileTemp>>();
        try{
            SysUser user = sysUserService.getCurrentUser(request);
            List<FileTemp> list = fileTempService.getFileTempList(fileTempParam,user);
            int count = fileTempService.getFileTempCount(fileTempParam,user);
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
    * 新增案卷模板信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷模板信息表", notes="新增案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTempSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷模板信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷模板信息表", notes="修改案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTempUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷模板信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷模板信息表", notes="查看案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTempDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷模板信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷模板信息表", notes="删除案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTempDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
