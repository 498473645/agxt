package com.pkusoft.pzzx.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pkusoft.pzzx.po.BdParam;
import com.pkusoft.pzzx.req.BdParamReqParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;

import com.pkusoft.pzzx.service.BdParamService;

import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

/**
* 基础数据_接警平台参数配置表 相关操作
* Auto-generated
*/
@Controller
public class BdParamController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(BdParamController.class);

    @Autowired
    private BdParamService bdParamService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台参数配置表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台参数配置表", notes = "查询接警平台参数配置表", httpMethod = "POST")
    @RequestMapping("/bdParam/bdParamList")
    @ResponseBody
    public ResponseData<List<BdParam>> bdParamList(HttpServletRequest request, @RequestBody BdParamReqParam bdParam){
        ResponseDto<List<BdParam>> dto = new ResponseDto<List<BdParam>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<BdParam> list = bdParamService.getBdParamList(bdParam,user);
            int count = bdParamService.getBdParamCount(bdParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台参数配置表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台参数配置表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台参数配置表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台参数配置表", notes = "新增或修改接警平台参数配置表", httpMethod = "POST")
    @RequestMapping("/bdParam/bdParamSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> bdParamSaveOrUpdate(@RequestBody BdParam bdParam, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            BdParam bp = bdParamService.getBdParam(bdParam.getParaCode());
            if (bp==null){
                num = bdParamService.bdParamSave(bdParam, user);
            } else {
                num = bdParamService.bdParamUpdate(bdParam, user);
            }
//            if(!StringUtils.hasText(bdParam.getParaCode())) {
//                //添加接警平台参数配置表
//                num = bdParamService.bdParamSave(bdParam, user);
//            }else{
//                //修改接警平台参数配置表
//                num = bdParamService.bdParamUpdate(bdParam, user);
//            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台参数配置表错误"+e.getMessage());
        }
    }

    /**
     * 检验参数编码是否唯一
     * @return
     */
    @ApiOperation(value = "检验参数编码是否唯一", notes = "检验参数编码是否唯一", httpMethod = "POST")
    @RequestMapping("/bdParam/checkParacodeUniq")
    @ResponseBody
    public ResponseData<String> checkParacodeUniq(@RequestBody Map map) {
        String paracode = (String) map.get("paracode");
        if (!StringUtils.hasText(paracode)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdParam bdParam = bdParamService.getBdParam(paracode);
            if (bdParam==null){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功","");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败","");
        }catch (Exception e){
            logger.error("查看接警平台参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "检验参数编码是否唯一错误:"+e.getMessage());
        }
    }

    /**
     * 查看接警平台参数配置表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台参数配置表详情", notes = "查看接警平台参数配置表详情", httpMethod = "POST")
    @RequestMapping("/bdParam/bdParamModel")
    @ResponseBody
    public ResponseData<BdParam> bdParamModel(@RequestBody Map map) {
        String objid = (String) map.get("paraCode");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdParam bdParam = bdParamService.getBdParam(objid);
            return new ResponseData<BdParam>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdParam);
        }catch (Exception e){
            logger.error("查看接警平台参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台参数配置表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台参数配置表
     * @return
     */
    @ApiOperation(value = "删除接警平台参数配置表", notes = "删除接警平台参数配置表", httpMethod = "POST")
    @RequestMapping("/bdParam/bdParamDelete")
    @ResponseBody
    public ResponseData<String> bdParamDelete(@RequestBody Map map) {
        String paraCode = (String) map.get("paraCode");
        if (!StringUtils.hasText(paraCode)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = bdParamService.bdParamDelete(paraCode);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台参数配置表错误:"+e.getMessage());
        }
    }
}
