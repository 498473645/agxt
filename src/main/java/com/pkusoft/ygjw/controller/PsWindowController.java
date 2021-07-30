package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsWindow;
import com.pkusoft.ygjw.req.PsWindowReqParam;
import com.pkusoft.ygjw.service.PsWindowService;
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
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 
 * 业务数据_窗口表 相关操作
 */
@Api(value="业务数据_窗口表",tags={"业务数据_窗口表 相关操作"})
@Controller
public class PsWindowController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsWindowController.class);

    @Autowired
    private PsWindowService psWindowService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    /**
    * 查询业务数据_窗口表
    * @param request
    * @return
    */
    @ApiOperation(value="查询业务数据_窗口表", notes="查询业务数据_窗口表")
    @RequestMapping(value = "/psWindow/psWindowList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsWindow>> psWindowList(HttpServletRequest request, @RequestBody PsWindowReqParam psWindowReqParam){
        ResponseDto<List<PsWindow>> dto = new ResponseDto<List<PsWindow>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsWindow> list = psWindowService.getPsWindowList(psWindowReqParam,user);
            int count = psWindowService.getPsWindowCount(psWindowReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询事务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询窗口数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询窗口数据错误"+e.getMessage());
        }
    }

    /**
    * 新增业务数据_窗口表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增业务数据_窗口表", notes="新增业务数据_窗口表")
    @RequestMapping(value = "/psWindow/psWindowSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> psWindowSave(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }
    
    /**
    * 修改业务数据_窗口表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改业务数据_窗口表", notes="修改业务数据_窗口表")
    @RequestMapping(value = "/psWindow/psWindowUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> psWindowUpdate(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }
    
    /**
    * 查看业务数据_窗口表
    * @param map
    * @return
    */
    @ApiOperation(value="查看业务数据_窗口表", notes="查看业务数据_窗口表")
    @RequestMapping(value = "/psWindow/psWindowDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsWindow> psWindowDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsWindow psWindow = psWindowService.getPsWindow(id);
            if (null == psWindow.getId()) {
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psWindow);
        }catch (Exception e){
            logger.error("查看事务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看事务数据详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除业务数据_窗口表
    * @param map
    * @return
    */
    @ApiOperation(value="删除业务数据_窗口表", notes="删除业务数据_窗口表")
    @RequestMapping(value = "/psWindow/psWindowDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psWindowDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psWindowService.psWindowDelete(id);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除事务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除事务数据错误:"+e.getMessage());
        }
    }

    /**
     * 新增或修改窗口数据(阳光警务客户端调用)
     * @return
     */
    @ApiOperation(value = "新增或修改窗口数据(阳光警务客户端调用)", notes = "新增或修改窗口数据(阳光警务客户端调用)", httpMethod = "POST")
    @RequestMapping("/psTrans/psWindowSaveOrUpdateYGJW")
    @ResponseBody
    public ResponseData<String> psWindowSaveOrUpdateYGJW(@RequestBody PsWindow psWindow, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = new HashMap<>();
            PsWindow oldPsWindows = psWindowService.getPsWindow(psWindow.getId());
            if(oldPsWindows==null) {
                //添加事务数据
                num = psWindowService.psWindowSave(psWindow, user);
            }else{
                //修改事务数据
                num = psWindowService.psWindowUpdate(psWindow, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改窗口数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "增加/修改窗口数据错误"+e.getMessage());
        }
    }


    /**
     * 新增或修改窗口数据
     * @return
     */
    @ApiOperation(value = "新增或修改窗口数据", notes = "新增或修改窗口数据", httpMethod = "POST")
    @RequestMapping("/psTrans/psWindowSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> psWindowSaveOrUpdate(@RequestBody PsWindow psWindow, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(psWindow.getId() == null) {
                //添加事务数据
                num = psWindowService.psWindowSave(psWindow, user);
            }else{
                //修改事务数据
                num = psWindowService.psWindowUpdate(psWindow, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改窗口数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "增加/修改窗口数据错误"+e.getMessage());
        }
    }

}
