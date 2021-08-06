package com.pkusoft.lesppc.controller;

import com.pkusoft.lesppc.service.PcWtmxService;
import com.pkusoft.lesppc.service.SplitScreenService;
import com.pkusoft.lesppc.req.ModelCountVo;
import com.pkusoft.lesp.controller.RsJbjJjxxController;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
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

import java.util.Map;

/**
 * 监督
 */
@Controller
@Api(value="",tags={"监督相关业务操作"})
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

    @Autowired
    private PcWtmxService pcWtmxService ;

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

    /**
     * 查询问题模型，并查询出总数
     * @param map
     * @return
     */
    @ApiOperation(value = "查询问题模型，并查询出总数", notes = "查询问题模型，并查询出总数", httpMethod = "POST")
    @RequestMapping(value = "/getJbjWtmxAndCount", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map<String,Object>> getJbjWtmxAndCount(@RequestBody(required = false) Map<String, String> map) {
        try {
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");
            String wtwd1 = map.get("ybabh");
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            String wtlyBh = userCenterProxyHelper.getPara("JJPT_WTLY_BH");
            wtlyBh = "LESP_PMS";
            if (!StringUtils.hasText(wtlyBh)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "请配置接报警问题领域编号");
            }
            Map<String,Object> ret = pcWtmxService.getJbjWtmxAndCount(deptId,deptLevel,wtlyBh,wtwd1);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "成功",ret);
        } catch (Exception e) {
            logger.error("查询问题模型，并查询出总数出错；" + e.getMessage(), e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "查询问题模型，并查询出总数出错；" + e.getMessage());
        }
    }

}
