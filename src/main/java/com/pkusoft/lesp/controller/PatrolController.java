package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjSxtxx;
import com.pkusoft.lesp.service.RsJbjSxtxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 动态
 */
@Controller
public class PatrolController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    @Autowired
    private RsJbjSxtxxService rsJbjSxtxxService ;

    /**
     * 巡查----获取单位列表
     * @return
     */
    @ApiOperation(value = "巡查----获取单位列表", notes = "巡查----获取单位列表", httpMethod = "POST")
    @RequestMapping("/patrol/getDeptList")
    @ResponseBody
    public ResponseData<List<RsJbjSxtxx>> getDeptList(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<Map<String,Object>> dto = new ResponseDto<Map<String,Object>>();
        try{
            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
//            String deptId = map.get("depts");
//            if (!StringUtils.hasText(deptId)){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
//            }

            List<RsJbjSxtxx> data = rsJbjSxtxxService.getDeptList(userInfo);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 巡查----获取摄像头信息列表
     * @return
     */
    @ApiOperation(value = "巡查----获取摄像头信息列表", notes = "巡查----获取摄像头信息列表", httpMethod = "POST")
    @RequestMapping("/patrol/getCameraList")
    @ResponseBody
    public ResponseData<List<Map<String,Object>>> getCameraList(@RequestBody Map<String,String> map, HttpServletRequest request){
//        ResponseDto<Map<String,Object>> dto = new ResponseDto<Map<String,Object>>();
        try{
            String deptId = map.get("depts");
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }

            List<Map<String,Object>> data = rsJbjSxtxxService.getCameraList(deptId);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }


}
