package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpAlarmType;
import com.pkusoft.jjpt.req.SpAlarmTypeReqParam;
import com.pkusoft.jjpt.service.SpAlarmTypeService;
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
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
* 报警类别/报警类型/报警细类字典表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpAlarmTypeController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpAlarmTypeController.class);

    @Autowired
    private SpAlarmTypeService spAlarmTypeService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 获取报警类别/报警类型/报警细类字典
     * @param spAlarmType
     * @param request
     * @return
     */
    @RequestMapping("/spAlarmType/getSpAlarmType")
    @ResponseBody
    public ResponseData<List<SpAlarmType>> getSpAlarmType(@RequestBody SpAlarmType spAlarmType, HttpServletRequest request){
        ResponseData<List<SpAlarmType>> dto = new ResponseData<List<SpAlarmType>>();
        if (!StringUtils.hasText(spAlarmType.getDicLevel())) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
            dto.setStatusMsg("参数为空");
        }else {
            try{
                String paraValue = userCenterProxyHelper.getPara("JJPT_ALARM_TYPE_VERSION");
                spAlarmType.setDicVersion(paraValue);
                List<SpAlarmType> list = spAlarmTypeService.getSpAlarmTypeListByLevelAndType(spAlarmType);
                dto.setData(list);
                dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
                dto.setStatusMsg("查询字典成功");
            }catch(Exception e){
                logger.error("查询字典错误",e);
                e.printStackTrace();
                dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
            }
        }
        return dto;
    }

    /**
     * 获取报警类别/报警类型/报警细类字典
     * @param request
     * @return
     */
    @RequestMapping(value="/spAlarmType/spAlarmTypeDic", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<SpAlarmType>> spAlarmTypeDic(String dicLevel,String dicVersion,String objcode,HttpServletRequest request){
        ResponseData<List<SpAlarmType>> dto = new ResponseData<List<SpAlarmType>>();
        try{
            String paraValue = userCenterProxyHelper.getPara("JJPT_ALARM_TYPE_VERSION");
            SpAlarmType spAlarmType = new SpAlarmType();
            spAlarmType.setDicLevel(dicLevel);
            spAlarmType.setObjcode(objcode);
            spAlarmType.setDicVersion(paraValue);
            List<SpAlarmType> list = spAlarmTypeService.getSpAlarmTypeListByLevelAndType(spAlarmType);
            dto.setData(list);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
        }catch(Exception e){
            logger.error("查询字典错误",e);
            e.printStackTrace();
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
        }
        return dto;
    }

    /**
     * 查询接警平台报警类别/报警类型/报警细类字典表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台报警类别/报警类型/报警细类字典表", notes = "查询接警平台报警类别/报警类型/报警细类字典表", httpMethod = "POST")
    @RequestMapping("/spAlarmType/spAlarmTypeList")
    @ResponseBody
    public ResponseData<List<SpAlarmType>> spAlarmTypeList(HttpServletRequest request, @RequestBody SpAlarmTypeReqParam spAlarmType){
        ResponseDto<List<SpAlarmType>> dto = new ResponseDto<List<SpAlarmType>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String paraValue = userCenterProxyHelper.getPara("JJPT_ALARM_TYPE_VERSION");
            spAlarmType.setDicVersion(paraValue);
            List<SpAlarmType> list = spAlarmTypeService.getSpAlarmTypeList(spAlarmType,user);
            int count = spAlarmTypeService.getSpAlarmTypeCount(spAlarmType,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台报警类别/报警类型/报警细类字典表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台报警类别/报警类型/报警细类字典表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台报警类别/报警类型/报警细类字典表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台报警类别/报警类型/报警细类字典表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台报警类别/报警类型/报警细类字典表", notes = "新增或修改接警平台报警类别/报警类型/报警细类字典表", httpMethod = "POST")
    @RequestMapping("/spAlarmType/spAlarmTypeSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spAlarmTypeSaveOrUpdate(@RequestBody SpAlarmType spAlarmType, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spAlarmType.getObjid())) {
                //添加接警平台报警类别/报警类型/报警细类字典表
                num = spAlarmTypeService.spAlarmTypeSave(spAlarmType, user);
            }else{
                //修改接警平台报警类别/报警类型/报警细类字典表
                num = spAlarmTypeService.spAlarmTypeUpdate(spAlarmType, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台报警类别/报警类型/报警细类字典表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台报警类别/报警类型/报警细类字典表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台报警类别/报警类型/报警细类字典表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台报警类别/报警类型/报警细类字典表详情", notes = "查看接警平台报警类别/报警类型/报警细类字典表详情", httpMethod = "POST")
    @RequestMapping("/spAlarmType/spAlarmTypeModel")
    @ResponseBody
    public ResponseData<SpAlarmType> spAlarmTypeModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpAlarmType spAlarmType = spAlarmTypeService.getSpAlarmType(objid);
            return new ResponseData<SpAlarmType>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spAlarmType);
        }catch (Exception e){
            logger.error("查看接警平台报警类别/报警类型/报警细类字典表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台报警类别/报警类型/报警细类字典表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台报警类别/报警类型/报警细类字典表
     * @return
     */
    @ApiOperation(value = "删除接警平台报警类别/报警类型/报警细类字典表", notes = "删除接警平台报警类别/报警类型/报警细类字典表", httpMethod = "POST")
    @RequestMapping("/spAlarmType/spAlarmTypeDelete")
    @ResponseBody
    public ResponseData<String> spAlarmTypeDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spAlarmTypeService.spAlarmTypeDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台报警类别/报警类型/报警细类字典表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台报警类别/报警类型/报警细类字典表错误:"+e.getMessage());
        }
    }
}
