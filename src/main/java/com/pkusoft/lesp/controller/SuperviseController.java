package com.pkusoft.lesp.controller;

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
public class SuperviseController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    @Autowired
    private PcYjwtService pcYjwtService ;

    /**
     * 监督----获取问题模型统计总数
     * @return
     */
    @ApiOperation(value = "动态----获取问题模型统计总数", notes = "动态----获取问题模型统计总数", httpMethod = "POST")
    @RequestMapping("/supervise/getWtmxCount")
    @ResponseBody
    public ResponseData<Map<String,Object>> getWtmxCount(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<Map<String,Object>> dto = new ResponseDto<Map<String,Object>>();
        try{
//            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }

            Map<String,Object> data = pcYjwtService.getWtmxCount(deptId,deptLevel);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 监督----获取预警问题列表
     * @return
     */
    @ApiOperation(value = "监督----获取预警问题列表", notes = "监督----获取预警问题列表", httpMethod = "POST")
    @RequestMapping("/supervise/getYjxxListData")
    @ResponseBody
    public ResponseData<List<PcYjwt>> getYjxxListData(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<List<PcYjwt>> dto = new ResponseDto<List<PcYjwt>>();
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");
            String wtmxBh = map.get("wtmxBh");
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(wtmxBh)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"问题模型编号不能为空");
            }
//            Map<String, String> userInfo = userCenterProxyHelper.getUser(request);

            List<PcYjwt> data = pcYjwtService.getYjxxListData(deptId,deptLevel,wtmxBh);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

}
