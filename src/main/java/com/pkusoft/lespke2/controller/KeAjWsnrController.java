package com.pkusoft.lespke2.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.lespke2.po.KeAjWsnr;
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



import com.pkusoft.lespke2.service.KeAjWsnrService;



import org.support.commons.springmvc.ResponseData;

/**
 * @author
 * 案件的文书内容 相关操作
 */
@Api(value="案件的文书内容",tags={"案件的文书内容 相关操作"})
@Controller
public class KeAjWsnrController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(KeAjWsnrController.class);

    @Autowired
    private KeAjWsnrService keAjWsnrService ;


    /**
    * 查询案件的文书内容
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查询案件的文书内容", notes="查询案件的文书内容",httpMethod = "POST")
    @RequestMapping(value = "/keAjWsnr/keAjWsnrList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<KeAjWsnr>> keAjWsnrList(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null|| !StringUtils.hasText(requestBody.get("ajbh"))) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "案件编号参数为空");
        }
        if (requestBody == null|| !StringUtils.hasText(requestBody.get("wsbt"))) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "文书类型参数为空");
        }
        try {
            // TODO: 业务逻辑
            List<KeAjWsnr> wsnr=keAjWsnrService.getKeAjWsnrList(requestBody);
            if(null == wsnr || wsnr.size()<1){
                return new ResponseData<>("90", "未查询到数据");
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, wsnr);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

    /**
    * 查看案件的文书内容
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案件的文书内容", notes="查看案件的文书内容",httpMethod = "POST")
    @RequestMapping(value = "/keAjWsnr/keAjWsnrDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> keAjWsnrDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
