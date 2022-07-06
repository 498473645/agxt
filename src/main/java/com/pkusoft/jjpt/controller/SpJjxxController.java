package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpJjxxReqParam;
import com.pkusoft.jjpt.service.SpJjxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
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
* 业务数据_接警信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpJjxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpJjxxController.class);

    @Autowired
    private SpJjxxService spJjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台接警信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台接警信息表", notes = "查询接警平台接警信息表", httpMethod = "POST")
    @RequestMapping("/spJjxx/spJjxxList")
    @ResponseBody
    public ResponseData<List<SpJjxx>> spJjxxList(HttpServletRequest request, @RequestBody SpJjxxReqParam spJjxx){
        ResponseDto<List<SpJjxx>> dto = new ResponseDto<List<SpJjxx>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpJjxx> list = spJjxxService.getSpJjxxList(spJjxx,user);
            int count = spJjxxService.getSpJjxxCount(spJjxx,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 查询接警平台接警信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台接警信息表", notes = "查询接警平台接警信息表", httpMethod = "POST")
    @RequestMapping("/spJjxx/getSpJjxxData")
    @ResponseBody
    public ResponseData<SpJjxx> getSpJjxxData(HttpServletRequest request, @RequestBody SpJjxx spJjxx){
        ResponseDto<SpJjxx> dto = new ResponseDto<SpJjxx>();
        try{
//            Map<String, String> user = userCenterProxyHelper.getUser(request);
            SpJjxx result = spJjxxService.getSpJjxxData(spJjxx);

            dto.setData(result);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 查询最近受理任务
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询最近受理任务", notes = "查询最近受理任务", httpMethod = "POST")
    @RequestMapping("/spJjxx/selectRecentSpJjxxList")
    @ResponseBody
    public ResponseData<List<SpJjxx>> selectRecentSpJjxxList(HttpServletRequest request, @RequestBody SpJjxxReqParam spJjxx){
        ResponseDto<List<SpJjxx>> dto = new ResponseDto<List<SpJjxx>>();
        try{
            if (!StringUtils.hasText(spJjxx.getStatus())){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"查询最近受理任务失败：状态不能为空");
            }
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpJjxx> list = spJjxxService.selectRecentSpJjxxList(spJjxx,user);
//            int count = spJjxxService.selectRecentSpJjxxCount(spJjxx,user);
            dto.setData(list);
//            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 查询接警大屏预报警和接警总数
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警大屏预报警和接警总数", notes = "查询接警大屏预报警和接警总数", httpMethod = "POST")
    @RequestMapping("/spJjxx/getBigscreenSpJjxxCount")
    @ResponseBody
    public ResponseData<Map> getBigscreenSpJjxxCount(HttpServletRequest request, @RequestBody SpJjxxReqParam spJjxx){
        ResponseDto<Map> dto = new ResponseDto<Map>();
        try{
//            if (!StringUtils.hasText(spJjxx.getStatus())){
//                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"查询最近受理任务失败：状态不能为空");
//            }
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            Map<String, Integer> countData = spJjxxService.getBigscreenSpJjxxCount(user);
            dto.setData(countData);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台接警信息表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台接警信息表", notes = "新增或修改接警平台接警信息表", httpMethod = "POST")
    @RequestMapping("/spJjxx/spJjxxSaveOrUpdate")
    @ResponseBody
    public ResponseData<SpJjxx> spJjxxSaveOrUpdate(@RequestBody SpJjxx spJjxx, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spJjxx.getObjid())) {
                //添加接警平台接警信息表
                num = spJjxxService.spJjxxSave(spJjxx, user);
            }else{
                //修改接警平台接警信息表
                num = spJjxxService.updateSpJjxx(spJjxx, user);
            }
            if (num>0){
                return new ResponseData<SpJjxx>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spJjxx);
            }
            return new ResponseData<SpJjxx>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 派警/接警
     * @param request
     * @return
     */
    @ApiOperation(value = "派警", notes = "派警", httpMethod = "POST")
    @RequestMapping("/spJjxx/receiveAlarmAndSendPolice")
    @ResponseBody
    public ResponseData<SpJjxx> receiveAlarmAndSendPolice(@RequestBody SpJjxx spJjxx, HttpServletRequest request){
        try {
            if(!StringUtils.hasText(spJjxx.getObjid())){
                return new ResponseData(ResponseData.STATUS_CODE_PARAM,"主键id不能为空");
            }
            if(!StringUtils.hasText(spJjxx.getCjrCode())){
                return new ResponseData(ResponseData.STATUS_CODE_PARAM,"出警人不能为空");
            }
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String retStr = "";
            if(StringUtils.hasText(spJjxx.getObjid())){
                //添加业务数据_接警记录表
                retStr = spJjxxService.receiveAlarmAndSendPolice(spJjxx, user);
            }
            if ("666".equals(retStr)){
                return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spJjxx);
            }else {
                return new ResponseData(ResponseData.STATUS_CODE_OTHER,"操作失败："+retStr);
            }
        }catch (Exception e) {
            logger.error("派警及反馈修改报警状态错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"操作错误："+e.getMessage());
        }
    }

    /**
     * 查看接警平台接警信息表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台接警信息表详情", notes = "查看接警平台接警信息表详情", httpMethod = "POST")
    @RequestMapping("/spJjxx/spJjxxModel")
    @ResponseBody
    public ResponseData<SpJjxx> spJjxxModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpJjxx spJjxx = spJjxxService.getSpJjxx(objid);
            return new ResponseData<SpJjxx>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spJjxx);
        }catch (Exception e){
            logger.error("查看接警平台接警信息表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台接警信息表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台接警信息表
     * @return
     */
    @ApiOperation(value = "删除接警平台接警信息表", notes = "删除接警平台接警信息表", httpMethod = "POST")
    @RequestMapping("/spJjxx/spJjxxDelete")
    @ResponseBody
    public ResponseData<String> spJjxxDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spJjxxService.spJjxxDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台接警信息表错误:"+e.getMessage());
        }
    }

}
