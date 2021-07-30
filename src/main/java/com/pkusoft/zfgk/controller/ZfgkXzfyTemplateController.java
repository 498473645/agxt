package com.pkusoft.zfgk.controller;


import com.pkusoft.zfgk.model.ZfgkXzfyTemplate;
import com.pkusoft.zfgk.req.ZfgkXzfyTemplateReqParam;
import com.pkusoft.zfgk.service.ZfgkXzfyTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 
 *  相关操作
 */
@Api(value="行政复议",tags={"执法公开相关操作"})
@Controller
public class ZfgkXzfyTemplateController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(ZfgkXzfyTemplateController.class);

    @Autowired(required=false)
    private ZfgkXzfyTemplateService zfgkXzfyTemplateService ;


    /**
    * 查询行政复议列表
    * @param zfgkXzfyTemplateReqParam
    * @return
    */
    @ApiOperation(value="查询行政复议列表", notes="查询行政复议列表", httpMethod="POST")
    @RequestMapping(value = "/zfgkXzfyTemplate/zfgkXzfyTemplateList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<ZfgkXzfyTemplate>> zfgkXzfyTemplateList(HttpServletRequest request, @RequestBody ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam){
        ResponseDto<List<ZfgkXzfyTemplate>> dto = new ResponseDto<List<ZfgkXzfyTemplate>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<ZfgkXzfyTemplate> list = zfgkXzfyTemplateService.getZfgkXzfyTemplateList(zfgkXzfyTemplateReqParam,user);
            int count = zfgkXzfyTemplateService.getZfgkXzfyTemplateCount(zfgkXzfyTemplateReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询行政复议数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询行政复议数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询行政复议数据错误"+e.getMessage());
        }
    }
    
    /**
    * 查看行政复议
    * @param map
    * @return
    */
    @ApiOperation(value="查看行政复议", notes="查看行政复议", httpMethod="POST")
    @RequestMapping(value = "/zfgkXzfyTemplate/zfgkXzfyTemplateDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<ZfgkXzfyTemplate> zfgkXzfyTemplateDetails(@RequestBody Map map){
        String xzfyTid = (String) map.get("xzfyTid");
        if (!StringUtils.hasText(xzfyTid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            ZfgkXzfyTemplate zfgkXzfyTemplate = zfgkXzfyTemplateService.getZfgkXzfyTemplate(xzfyTid);
            if (null == zfgkXzfyTemplate.getXzfyTid()) {
                return new ResponseData<ZfgkXzfyTemplate>("90", "未查询到数据", null);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zfgkXzfyTemplate);
        }catch (Exception e){
            logger.error("查看行政复议数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看行政复议详情错误:"+e.getMessage());
        }
    }


}
