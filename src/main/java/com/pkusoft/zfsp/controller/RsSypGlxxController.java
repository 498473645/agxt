package com.pkusoft.zfsp.controller;


import com.pkusoft.zfsp.model.RsSypGlxx;
import com.pkusoft.zfsp.service.RsSypGlxxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;

import java.util.List;

/**
 * @author 
 *  执法视音频相关操作
 */
@Api(value="",tags={" 执法视音频相关操作"})
@Controller
public class RsSypGlxxController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(RsSypGlxxController.class);

    @Autowired
    private RsSypGlxxService rsSypGlxxService ;


    /**
    * 查询执法视屏列表
    * @param rsSypGlxx
    * @return
    */
    @ApiOperation(value="查询执法视屏列表", notes="查询执法视屏列表")
    @RequestMapping(value = "/rsSypGlxx/rsSypGlxxList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<RsSypGlxx>> rsSypGlxxList(@RequestBody RsSypGlxx rsSypGlxx){
        // 检查参数
        if (rsSypGlxx.getJjbh() == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "接警编号不能为空");
        }
        try {
            // TODO: 业务逻辑
            List<RsSypGlxx> responseData = rsSypGlxxService.getRsSypGlxxList(rsSypGlxx);
            return new ResponseData<List<RsSypGlxx>>(ResponseData.STATUS_CODE_SUCCESS, "查询成功", responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询失败：" + e.getMessage());
        }
    }

}
