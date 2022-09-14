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



import com.pkusoft.agxt.service.CabPlaceService;



import org.support.commons.springmvc.ResponseData;

/**
 * @author
 * 案卷柜场所信息表 相关操作
 */
@Api(value="案卷柜场所信息表",tags={"案卷柜场所信息表 相关操作"})
@Controller
public class CabPlaceController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabPlaceController.class);

    @Autowired
    private CabPlaceService cabPlaceService ;


    /**
    * 查询案卷柜场所信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷柜场所信息表", notes="查询案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷柜场所信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷柜场所信息表", notes="新增案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷柜场所信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷柜场所信息表", notes="修改案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷柜场所信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷柜场所信息表", notes="查看案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷柜场所信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷柜场所信息表", notes="删除案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
