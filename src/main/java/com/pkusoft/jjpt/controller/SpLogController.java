package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpLog;
import com.pkusoft.jjpt.req.SpLogReqParam;
import com.pkusoft.jjpt.service.SpLogService;
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
* 接口调用日志表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpLogController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpLogController.class);

    @Autowired
    private SpLogService spLogService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台接口调用日志表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台接口调用日志表", notes = "查询接警平台接口调用日志表", httpMethod = "POST")
    @RequestMapping("/spLog/spLogList")
    @ResponseBody
    public ResponseData<List<SpLog>> spLogList(HttpServletRequest request, @RequestBody SpLogReqParam spLog){
        ResponseDto<List<SpLog>> dto = new ResponseDto<List<SpLog>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpLog> list = spLogService.getSpLogList(spLog,user);
            int count = spLogService.getSpLogCount(spLog,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接口调用日志表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接口调用日志表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接口调用日志表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台接口调用日志表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台接口调用日志表", notes = "新增或修改接警平台接口调用日志表", httpMethod = "POST")
    @RequestMapping("/spLog/spLogSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spLogSaveOrUpdate(@RequestBody SpLog spLog, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spLog.getObjid())) {
                //添加接警平台接口调用日志表
                num = spLogService.spLogSave(spLog, user);
            }else{
                //修改接警平台接口调用日志表
                num = spLogService.spLogUpdate(spLog, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台接口调用日志表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台接口调用日志表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台接口调用日志表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台接口调用日志表详情", notes = "查看接警平台接口调用日志表详情", httpMethod = "POST")
    @RequestMapping("/spLog/spLogModel")
    @ResponseBody
    public ResponseData<SpLog> spLogModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpLog spLog = spLogService.getSpLog(objid);
            return new ResponseData<SpLog>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spLog);
        }catch (Exception e){
            logger.error("查看接警平台接口调用日志表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台接口调用日志表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台接口调用日志表
     * @return
     */
    @ApiOperation(value = "删除接警平台接口调用日志表", notes = "删除接警平台接口调用日志表", httpMethod = "POST")
    @RequestMapping("/spLog/spLogDelete")
    @ResponseBody
    public ResponseData<String> spLogDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spLogService.spLogDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台接口调用日志表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台接口调用日志表错误:"+e.getMessage());
        }
    }
}
