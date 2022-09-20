package com.pkusoft.agxt.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.FileNote;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.agxt.req.FileNoteParam;
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



import com.pkusoft.agxt.service.FileNoteService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

/**
 * @author
 * 案卷页备注信息表 相关操作
 */
@Api(value="案卷页备注信息表",tags={"案卷页备注信息表 相关操作"})
@Controller
public class FileNoteController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileNoteController.class);

    @Autowired
    private FileNoteService fileNoteService ;


    /**
    * 查询案卷页备注信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷页备注信息表", notes="查询案卷页备注信息表")
    @RequestMapping(value = "/fileNote/fileNoteList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileNoteList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷页备注信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷页备注信息表", notes="新增案卷页备注信息表")
    @RequestMapping(value = "/fileNote/fileNoteSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileNoteSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷页备注信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷页备注信息表", notes="修改案卷页备注信息表")
    @RequestMapping(value = "/fileNote/fileNoteUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileNoteUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷页备注信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷页备注信息表", notes="查看案卷页备注信息表")
    @RequestMapping(value = "/fileNote/fileNoteDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileNoteDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷页备注信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷页备注信息表", notes="删除案卷页备注信息表")
    @RequestMapping(value = "/fileNote/fileNoteDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileNoteDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
     * 整改意见
     *
     * @param fileNoteParam 查询条件
     * @return 标准列表对象
     */
    @RequestMapping("/archives/jobNoteDetailDataWeb")
    @ResponseBody
    public ResponseData<List<FileNote>> jobNoteDetailDataWeb(@RequestBody FileNoteParam fileNoteParam) {
        ResponseDto<List<FileNote>> dto = new ResponseDto<>();
        try {
            List<FileNote> list = fileNoteService.getFileNoteList(fileNoteParam);
            int count = fileNoteService.getFileNoteCount(fileNoteParam);

            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询整改意见数据成功");
            return dto;
        } catch (Exception e) {
            log.error("查询整改意见数据出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询整改意见数据出错：" + e.getMessage());
        }
    }
}
