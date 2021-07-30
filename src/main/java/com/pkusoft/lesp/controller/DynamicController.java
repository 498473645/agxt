package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import com.pkusoft.lesp.service.RsJbjJgxtDynamicService;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
import com.pkusoft.lesppc.model.PcYjwt;
import com.pkusoft.lesppc.service.PcYjwtService;
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
public class DynamicController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    @Autowired
    private PcYjwtService pcYjwtService ;

    @Autowired
    private RsJbjYbjxxService rsJbjYbjxxService ;

    @Autowired
    private RsJbjJgxtDynamicService rsJbjJgxtDynamicService ;

    /**
     * 动态----微信扫码未闭环
     * @return
     */
    @ApiOperation(value = "动态----微信扫码未闭环", notes = "动态----微信扫码未闭环", httpMethod = "POST")
    @RequestMapping("/dynamic/getWechatUnclosedData")
    @ResponseBody
    public ResponseData<List<PcYjwt>> getWechatUnclosedData(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<List<PcYjwt>> dto = new ResponseDto<List<PcYjwt>>();
        try{
            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
//            String deptId = map.get("deptId");
//            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
//            if (!StringUtils.hasText(deptId)){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
//            }
//            if (!StringUtils.hasText(deptLevel)){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
//            }

            List<PcYjwt> data = pcYjwtService.getWechatUnclosedData(userInfo.get("deptId"),userInfo.get("userLevel"));
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

//    /**
//     * 动态----报警电话
//     * @return
//     */
//    @ApiOperation(value = "动态----报警电话", notes = "动态----报警电话", httpMethod = "POST")
//    @RequestMapping("/dynamic/getDynamicData")
//    @ResponseBody
//    public ResponseData<List<RsJbjYbjxx>> getDynamicData(@RequestBody Map<String,String> map, HttpServletRequest request){
//        ResponseDto<List<RsJbjYbjxx>> dto = new ResponseDto<List<RsJbjYbjxx>>();
//        try{
//            String jqly = map.get("jqly");
//            if (!StringUtils.hasText(jqly)){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"警情来源为空");
//            }
//            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
////            String deptId = map.get("deptId");
////            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
////            if (!StringUtils.hasText(deptId)){
////                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
////            }
////            if (!StringUtils.hasText(deptLevel)){
////                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
////            }
//
//            List<RsJbjYbjxx> data = rsJbjYbjxxService.getTelephoneData(userInfo.get("deptId"),userInfo.get("userLevel"),jqly);
//            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
//        }catch(Exception e){
//            logger.error("查询统计_最近受理数据错误",e);
//            e.printStackTrace();
//            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
//        }
//    }

    /**
     * 动态----获取动态
     * @return
     */
    @ApiOperation(value = "动态----获取动态", notes = "动态----获取动态", httpMethod = "POST")
    @RequestMapping("/dynamic/getDynamicData")
    @ResponseBody
    public ResponseData<List<RsJbjJgxtDynamic>> getDynamicData(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<List<RsJbjJgxtDynamic>> dto = new ResponseDto<List<RsJbjJgxtDynamic>>();
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
//            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);

            List<RsJbjJgxtDynamic> data = rsJbjJgxtDynamicService.getDynamicData(map);
            int count = rsJbjJgxtDynamicService.getDynamicCount(map);
            dto.setData(data);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            return dto;
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }


}
