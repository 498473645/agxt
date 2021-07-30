package com.pkusoft.zfgk.controller;

import com.pkusoft.zfgk.model.ZfgkCasePublic;
import com.pkusoft.zfgk.req.ZfgkCasePublicReqParam;
import com.pkusoft.zfgk.service.ZfgkCasePublicService;


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

@Api(value="政府管控",tags={"执法公开相关操作"})
@Controller
public class ZfgkCasePublicController {

    @Autowired(required=false)
    private ZfgkCasePublicService zfgkCasePublicService;

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(ZfgkCasePublicController.class);

    /**
     * 查询案件列表
     * @param zfgkCasePublicReqParam
     * @return
     */
    @ApiOperation(value="查询案件列表", notes="查询案件列表", httpMethod="POST")
    @RequestMapping(value = "/zfgkCasePublic/zfgkCasePublicList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<ZfgkCasePublic>> ZfgkCasePublicList(HttpServletRequest request, @RequestBody ZfgkCasePublicReqParam zfgkCasePublicReqParam){
        ResponseDto<List<ZfgkCasePublic>> dto = new ResponseDto<List<ZfgkCasePublic>>();
        try{
            if(org.apache.commons.lang.StringUtils.isEmpty(zfgkCasePublicReqParam.getHgbh())){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"参数异常！");
            }
            Map<String, String> user = new HashMap<>();
            List<ZfgkCasePublic> list = zfgkCasePublicService.getZfgkCasePublicList(zfgkCasePublicReqParam,user);
            //int count = zfgkCasePublicService.getZfgkCasePublicCount(ZfgkCasePublicReqParam,user);
            dto.setData(list);
            //dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询事务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询事务数据错误"+e.getMessage());
        }
    }

    /**
     * 查看录取公开文书
     * @param map
     * @return
     */
    @ApiOperation(value="查看案件", notes="查看案件", httpMethod="POST")
    @RequestMapping(value = "/zfgkCasePublic/zfgkCasePublicDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<ZfgkCasePublic> ZfgkCasePublicDetails(@RequestBody Map map){
        String docId = (String) map.get("publicId");
        if (!StringUtils.hasText(docId)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            ZfgkCasePublic zfgkCasePublic = zfgkCasePublicService.getZfgkCasePublic(docId);
            if (null == zfgkCasePublic.getPublicId()) {
                return new ResponseData<ZfgkCasePublic>("90", "未查询到数据", null);
            }
            return new ResponseData<ZfgkCasePublic>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zfgkCasePublic);
        }catch (Exception e){
            logger.error("查看案件详情数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看案件详情错误:"+e.getMessage());
        }
    }

}
