package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.service.AnalysisService;
import com.pkusoft.lesp.service.RsJbjJjxxService;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
import com.pkusoft.usercenter.vo.DeptTree;
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
import java.util.List;
import java.util.Map;

/**
 * 分析
 */
@Controller
public class ScreenAnalysisController {

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
     * 一屏查询----上门报案
     * @return
     */
    @ApiOperation(value = "一屏查询----上门报案", notes = "一屏查询----上门报案", httpMethod = "POST")
    @RequestMapping("/analysis/getSmbaData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getSmbaData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> dataMap = analysisService.getSmbaData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",dataMap);
        }catch(Exception e){
            logger.error("查询统计_上门报案数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询统计_上门报案数据错误");
        }
    }

    /**
     * 一屏查询----预报案方式对比
     * @return
     */
    @ApiOperation(value = "一屏查询----预报案方式对比", notes = "一屏查询----预报案方式对比", httpMethod = "POST")
    @RequestMapping("/analysis/getYbafsdbData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getYbafsdbData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> data = analysisService.getYbafsdbData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("查询统计_上门报案数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询统计_上门报案数据错误");
        }
    }

    /**
     * 一屏查询----预报案处理状态分析
     * @return
     */
    @ApiOperation(value = "一屏查询----预报案处理状态分析", notes = "一屏查询----预报案处理状态分析", httpMethod = "POST")
    @RequestMapping("/analysis/getYbaclztfxData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getYbaclztfxData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> data = analysisService.getYbaclztfxData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("一屏查询----预报案处理状态分析",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"一屏查询----预报案处理状态分析");
        }
    }

    /**
     * 一屏查询----报案类型分析
     * @return
     */
    @ApiOperation(value = "一屏查询----报案类型分析", notes = "一屏查询----报案类型分析", httpMethod = "POST")
    @RequestMapping("/analysis/getBalxData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getBalxData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> data = analysisService.getBalxData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("一屏查询----预报案处理状态分析",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"一屏查询----预报案处理状态分析");
        }
    }

    /**
     * 一屏查询----评议占比分析
     * @return
     */
    @ApiOperation(value = "一屏查询----评议占比分析", notes = "一屏查询----评议占比分析", httpMethod = "POST")
    @RequestMapping("/analysis/getPyzbData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getPyzbData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> data = analysisService.getPyzbData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("一屏查询----评议占比分析",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"一屏查询----评议占比分析");
        }
    }

    /**
     * 一屏查询----评议占比分析
     * @return
     */
    @ApiOperation(value = "一屏查询----评议满意度分析", notes = "一屏查询----评议满意度分析", httpMethod = "POST")
    @RequestMapping("/analysis/getPymydData")
    @ResponseBody
    public ResponseData<Map<String,Object>> getPymydData(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            Map<String,Object> data = analysisService.getPymydData(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("一屏查询----评议占比分析",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"一屏查询----评议占比分析");
        }
    }

    /**
     * 一屏查询----单位实时数据
     * @return
     */
    @ApiOperation(value = "一屏查询----单位实时数据", notes = "一屏查询----单位实时数据", httpMethod = "POST")
    @RequestMapping("/analysis/getYbaclztfxDataByDept")
    @ResponseBody
    public ResponseData<List> getYbaclztfxDataByDept(@RequestBody Map<String,String> map, HttpServletRequest request){
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
            List<DeptTree> data = analysisService.getYbaclztfxDataByDept(deptId,deptLevel,dataType);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"成功",data);
        }catch(Exception e){
            logger.error("一屏查询----评议占比分析",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"一屏查询----评议占比分析");
        }
    }
}
