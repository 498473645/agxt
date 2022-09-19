package com.pkusoft.agxt.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.CabTrack;
import com.pkusoft.agxt.req.FileInfoParam;
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



import com.pkusoft.agxt.service.CabTrackService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

/**
 * @author
 * 案卷柜操作轨迹表 相关操作
 */
@Api(value="案卷柜操作轨迹表",tags={"案卷柜操作轨迹表 相关操作"})
@Controller
public class CabTrackController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabTrackController.class);

    @Autowired
    private CabTrackService cabTrackService ;


    /**
    * 查询案卷柜操作轨迹表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案卷柜操作轨迹表", notes="查询案卷柜操作轨迹表")
    @RequestMapping(value = "/cabTrack/cabTrackList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabTrackList(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 新增案卷柜操作轨迹表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷柜操作轨迹表", notes="新增案卷柜操作轨迹表")
    @RequestMapping(value = "/cabTrack/cabTrackSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabTrackSave(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 修改案卷柜操作轨迹表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷柜操作轨迹表", notes="修改案卷柜操作轨迹表")
    @RequestMapping(value = "/cabTrack/cabTrackUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabTrackUpdate(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 查看案卷柜操作轨迹表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷柜操作轨迹表", notes="查看案卷柜操作轨迹表")
    @RequestMapping(value = "/cabTrack/cabTrackDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabTrackDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
    * 删除案卷柜操作轨迹表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷柜操作轨迹表", notes="删除案卷柜操作轨迹表")
    @RequestMapping(value = "/cabTrack/cabTrackDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabTrackDelete(@RequestBody(required = false) Map<String, String> requestBody){
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
     * 查询开启案卷柜轨迹数据
     * @param fileId
     * @return
     */
    @RequestMapping("/archives/cabTrackSpaceList")
    @ResponseBody
    public ResponseData<List<CabTrack>> cabTrackSpaceList(String fileId) {
        ResponseDto<List<CabTrack>> dto = new ResponseDto<>();

        List<CabTrack> list = cabTrackService.getJobCabTrackListByFileId(fileId);
        dto.setData(list);
        dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
        dto.setStatusMsg("查询案卷模板树信息表成功");
        return dto;
    }

}
