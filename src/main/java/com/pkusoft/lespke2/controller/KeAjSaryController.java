package com.pkusoft.lespke2.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.lespke2.po.KeAjSary;
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



import com.pkusoft.lespke2.service.KeAjSaryService;



import org.support.commons.springmvc.ResponseData;

/**
 * @author
 * 案件涉案人员信息（201912版） 相关操作
 */
@Api(value="案件涉案人员信息（201912版）",tags={"案件涉案人员信息（201912版） 相关操作"})
@Controller
public class KeAjSaryController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(KeAjSaryController.class);

    @Autowired
    private KeAjSaryService keAjSaryService ;


    /**
    * 查询案件涉案人员信息（201912版）
    * @param requestBody
    * @return
    */
    @ApiOperation(value="根据身份证查询案件涉案人员信息（201912版）", notes="根据身份证查询案件涉案人员信息（201912版）")
    @RequestMapping(value = "/keAjSary/keAjSaryList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<KeAjSary>> keAjSaryList(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null&& null==requestBody.get("sfzh")) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            List<KeAjSary> ajSaryList = keAjSaryService.getKeAjSaryList(requestBody);
            if(null == ajSaryList || ajSaryList.size()<1){
                return new ResponseData<>("90", "未查询到数据");
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, ajSaryList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

    /**
    * 查看案件涉案人员信息（201912版）
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案件涉案人员信息（201912版）", notes="查看案件涉案人员信息（201912版）")
    @RequestMapping(value = "/keAjSary/keAjSaryDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> keAjSaryDetails(@RequestBody(required = false) Map<String, String> requestBody){
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
