package com.pkusoft.rkxt.controller;

import com.pkusoft.lesp.controller.RsJbjJjxxController;
import com.pkusoft.lesppc.req.ModelCountVo;
import com.pkusoft.rkxt.model.HzywYbsxxb;
import com.pkusoft.rkxt.service.HzywYbsxxbService;
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
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;

import java.util.Map;

/**
 * 监督
 */
@Controller
@Api(value="",tags={"户政相关业务操作"})
@RequestMapping("/hzyw")
public class HzywYbsxxbController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    @Autowired
    private HzywYbsxxbService hywYbsxxbService;

    /**
     * 推送数据至户政服务
     *
     * @param hzywYbsxxb
     * @return
     */
    @ApiOperation(value = "推送数据至户政服务", notes = "推送数据至户政服务", httpMethod = "POST")
    @RequestMapping(value = "/hzywYbsxxbSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<HzywYbsxxb> hzywYbsxxbSave(@RequestBody(required = false) HzywYbsxxb hzywYbsxxb) {
        try {
            hywYbsxxbService.hzywYbsxxbSave(hzywYbsxxb);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "同步预办事数据成功");
        } catch (Exception e) {
            logger.error("查询问题模型数量出错；" + e.getMessage(), e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询问题模型数量出错；" + e.getMessage());
        }
    }

    /**
     * 调用人口系统接口获取办事过程数据
     *
     * @param hzywYbsxxb
     * @return
     */
    @ApiOperation(value = "调用人口系统接口获取办事过程数据", notes = "调用人口系统接口获取办事过程数据", httpMethod = "POST")
    @RequestMapping(value = "/getHzywYbsxxb", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<HzywYbsxxb> getHzywYbsxxb(@RequestBody(required = false) HzywYbsxxb hzywYbsxxb) {
        try {
            hywYbsxxbService.getHzywYbsxxb(hzywYbsxxb);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "同步预办事数据成功");
        } catch (Exception e) {
            logger.error("查询问题模型数量出错；" + e.getMessage(), e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询问题模型数量出错；" + e.getMessage());
        }
    }

}
