package com.pkusoft.lesp.swagger;

import com.pkusoft.lesp.until.FieldNotNull;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: hed
 * @Date: 2020/9/24 15:20
 * @Description:
 */
@Api(tags = { "接报警源头监督子系统接口" })
@Controller
@RequestMapping("/JGXTService")
public class swagger {

    @Autowired
    private RestTemplate restTemplate;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Value(value = "${shiro-proxy.sso-server-url}")
    private String userCenterUrl;
    /**
     * 获取token
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取token", notes = "获取token接口", httpMethod = "POST")
    @RequestMapping("/getToken")
    @ResponseBody
    public ResponseData<Object> getToken(@RequestBody Map<String, Object> requestBody, HttpServletRequest httpServletRequest) {
        try {
            return new ResponseData<Object>(FieldNotNull.STATUS_CODE_SUCCESS, "成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData<Object>(FieldNotNull.STATUS_CODE_ERROR, "失败!",e.toString());
        }
    }

}
