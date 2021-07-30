package com.pkusoft.lesppc.controller;

import com.pkusoft.lesppc.service.SplitScreenService;
import com.pkusoft.lesppc.req.ModelCountVo;
import com.pkusoft.lesp.controller.RsJbjJjxxController;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
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

import java.util.Map;

/**
 * 监督
 */
@Controller
@RequestMapping("/api/jjpt")
public class JDSplitScreenController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private RsJbjYbjxxService rsJbjYbjxxService ;

    @Autowired
    private SplitScreenService splitScreenService ;

    /**
     * 查询问题模型数量
     *
     * @param map
     * @return
     */
    @ApiOperation(value = "查询问题模型数量", notes = "查询问题模型数量", httpMethod = "POST")
    @RequestMapping(value = "/getModelCount", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<ModelCountVo> getModelCount(@RequestBody(required = false) Map<String, String> map) {
        try {

            ModelCountVo modelCount = splitScreenService.getModelCount(map);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "", modelCount);
        } catch (Exception e) {
            logger.error("查询问题模型数量出错；" + e.getMessage(), e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询问题模型数量出错；" + e.getMessage());
        }
    }

}
