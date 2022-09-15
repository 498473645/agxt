package com.pkusoft.agxt.controller;


import java.util.Map;


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



import com.pkusoft.agxt.service.FileTrackDtlService;



import org.support.commons.springmvc.ResponseData;

/**
 * @author
 * 案卷操作轨迹表(副表) 相关操作
 */
@Api(value="案卷操作轨迹表(副表)",tags={"案卷操作轨迹表(副表) 相关操作"})
@Controller
public class FileTrackDtlController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileTrackDtlController.class);

    @Autowired
    private FileTrackDtlService fileTrackDtlService ;


    /**
    * 查询案卷操作轨迹表(副表)
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷操作轨迹表(副表)", notes="查询案卷操作轨迹表(副表)")
    @RequestMapping(value = "/fileTrackDtl/fileTrackDtlList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTrackDtlList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷操作轨迹表(副表)
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷操作轨迹表(副表)", notes="新增案卷操作轨迹表(副表)")
    @RequestMapping(value = "/fileTrackDtl/fileTrackDtlSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTrackDtlSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷操作轨迹表(副表)
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷操作轨迹表(副表)", notes="修改案卷操作轨迹表(副表)")
    @RequestMapping(value = "/fileTrackDtl/fileTrackDtlUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTrackDtlUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷操作轨迹表(副表)
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷操作轨迹表(副表)", notes="查看案卷操作轨迹表(副表)")
    @RequestMapping(value = "/fileTrackDtl/fileTrackDtlDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTrackDtlDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷操作轨迹表(副表)
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷操作轨迹表(副表)", notes="删除案卷操作轨迹表(副表)")
    @RequestMapping(value = "/fileTrackDtl/fileTrackDtlDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTrackDtlDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
