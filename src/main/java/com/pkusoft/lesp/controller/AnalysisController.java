package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.service.AnalysisService;
import com.pkusoft.lesp.service.RsJbjJjxxService;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 分析
 */
@Controller
public class AnalysisController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private RsJbjYbjxxService rsJbjYbjxxService ;

    @Autowired
    private RsJbjJjxxService rsJbjJjxxService ;

    @Autowired
    private AnalysisService analysisService ;

    /**
     * 分析----预报警分析
     * @return
     */
    @ApiOperation(value = "分析----预报警分析", notes = "分析----预报警分析", httpMethod = "POST")
    @RequestMapping("/analysis/getYbjData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getYbjData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
            Map<String,Object> data = analysisService.getYbjData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 分析----接警分析
     * @return
     */
    @ApiOperation(value = "分析----接警分析", notes = "分析----接警分析", httpMethod = "POST")
    @RequestMapping("/analysis/getJjData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getJjData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
            Map<String,Object> data = analysisService.getJjData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 分析----处警反馈
     * @return
     */
    @ApiOperation(value = "分析----接警分析", notes = "分析----接警分析", httpMethod = "POST")
    @RequestMapping("/analysis/getCjfkData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getCjfkData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
            Map<String,Object> data = analysisService.getCjfkData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 分析----预报警分类
     * @return
     */
    @ApiOperation(value = "分析----预报警分类", notes = "分析----预报警分类", httpMethod = "POST")
    @RequestMapping("/analysis/getYbjflData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getYbjflData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
            Map<String,Object> data = analysisService.getYbjflData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 分析----分类警情
     * @return
     */
    @ApiOperation(value = "分析----分类警情", notes = "分析----分类警情", httpMethod = "POST")
    @RequestMapping("/analysis/getFljqData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getFljqData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
          Map<String,Object> data = analysisService.getFljqData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }

    /**
     * 分析----最近趋势
     * @return
     */
    @ApiOperation(value = "分析----最近趋势", notes = "分析----最近趋势", httpMethod = "POST")
    @RequestMapping("/analysis/getZjqsData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getZjqsData(@RequestBody Map<String,String> map, HttpServletRequest request){
        try{
            String deptId = map.get("deptId");
            String deptLevel = map.get("deptLevel");// 2-市局，3-分局，4-派出所
            String dataType = map.get("dataType");//10-日，20-周，30-月，40-年
            if (!StringUtils.hasText(deptId)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位不能为空");
            }
            if (!StringUtils.hasText(deptLevel)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"单位级别不能为空");
            }
            if (!StringUtils.hasText(dataType)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"统计类型不能为空");
            }
//            Map<String, String> user = userCenterProxyHelper.getUser(request);
            Map<String,Object> data = new HashMap<>();
            // 最近十天
            Map<String,Object> zjqs = analysisService.getZjqsData(deptId,deptLevel,dataType);

            data.put("zjqs",zjqs);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_最近受理数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"报案类型分析查询统计错误");
        }
    }
}
