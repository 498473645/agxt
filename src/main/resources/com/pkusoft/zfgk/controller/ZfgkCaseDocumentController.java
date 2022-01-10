package com.pkusoft.zfgk.controller;


import com.pkusoft.zfgk.model.ZfgkCaseDocument;
import com.pkusoft.zfgk.req.ZfgkCaseDocumentReqParam;
import com.pkusoft.zfgk.service.ZfgkCaseDocumentService;
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
 * 录取公开文书 相关操作
 */
@Api(value="录取公开文书",tags={"执法公开相关操作"})
@Controller
public class ZfgkCaseDocumentController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(ZfgkCaseDocumentController.class);

    @Autowired(required=false)
    private ZfgkCaseDocumentService zfgkCaseDocumentService ;


    /**
    * 查询录取公开文书
    * @param zfgkCaseDocumentReqParam
    * @return
    */
    @ApiOperation(value="查询录取公开文书列表", notes="查询录取公开文书列表", httpMethod="POST")
    @RequestMapping(value = "/zfgkCaseDocument/zfgkCaseDocumentList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<ZfgkCaseDocument>> zfgkCaseDocumentList(HttpServletRequest request, @RequestBody ZfgkCaseDocumentReqParam zfgkCaseDocumentReqParam){
        ResponseDto<List<ZfgkCaseDocument>> dto = new ResponseDto<List<ZfgkCaseDocument>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<ZfgkCaseDocument> list = zfgkCaseDocumentService.getZfgkCaseDocumentList(zfgkCaseDocumentReqParam,user);
            int count = zfgkCaseDocumentService.getZfgkCaseDocumentCount(zfgkCaseDocumentReqParam,user);
            dto.setData(list);
            dto.setCount(count);
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
    @ApiOperation(value="查看录取公开文书", notes="查看录取公开文书", httpMethod="POST")
    @RequestMapping(value = "/zfgkCaseDocument/zfgkCaseDocumentDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<ZfgkCaseDocument> zfgkCaseDocumentDetails(@RequestBody Map map){
        String docId = (String) map.get("docId");
        if (!StringUtils.hasText(docId)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            ZfgkCaseDocument zfgkCaseDocument = zfgkCaseDocumentService.getZfgkCaseDocument(docId);
            if (null == zfgkCaseDocument.getDocId()) {
                return new ResponseData<ZfgkCaseDocument>("90", "未查询到数据", null);
            }
            return new ResponseData<ZfgkCaseDocument>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zfgkCaseDocument);
        }catch (Exception e){
            logger.error("查看录取公开文书数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看录取公开文书详情错误:"+e.getMessage());
        }
    }

}
