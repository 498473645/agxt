package com.pkusoft.pzzx.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.req.BdHandlingAreaReqParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ControllerUtil;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;

import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.service.BdHandlingAreaService;

import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

/**
* 基础数据_接处警功能场所记录表 相关操作
* Auto-generated
*/
@Controller
public class BdHandlingAreaController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(BdHandlingAreaController.class);

    @Autowired
    private BdHandlingAreaService bdHandlingAreaService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接处警功能场所记录表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接处警功能场所记录表", notes = "查询接处警功能场所记录表", httpMethod = "POST")
    @RequestMapping("/bdHandlingArea/bdHandlingAreaList")
    @ResponseBody
    public ResponseData<List<BdHandlingArea>> bdHandlingAreaList(HttpServletRequest request, @RequestBody BdHandlingAreaReqParam bdHandlingArea){
        ResponseDto<List<BdHandlingArea>> dto = new ResponseDto<List<BdHandlingArea>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<BdHandlingArea> list = bdHandlingAreaService.getBdHandlingAreaList(bdHandlingArea,user);
            int count = bdHandlingAreaService.getBdHandlingAreaCount(bdHandlingArea,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接处警功能场所记录表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接处警功能场所记录表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接处警功能场所记录表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接处警功能场所记录表
     * @return
     */
    @ApiOperation(value = "新增或修改接处警功能场所记录表", notes = "新增或修改接处警功能场所记录表", httpMethod = "POST")
    @RequestMapping("/bdHandlingArea/bdHandlingAreaSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> bdHandlingAreaSaveOrUpdate(@RequestBody BdHandlingArea bdHandlingArea, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(bdHandlingArea.getObjid())) {
                //添加接处警功能场所记录表
                num = bdHandlingAreaService.bdHandlingAreaSave(bdHandlingArea, user);
            }else{
                //修改接处警功能场所记录表
                num = bdHandlingAreaService.bdHandlingAreaUpdate(bdHandlingArea, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }else if (num == -1){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能根据场所单位编码找到对应单位信息");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接处警功能场所记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接处警功能场所记录表错误"+e.getMessage());
        }
    }

    /**
     * 查看接处警功能场所记录表详情
     * @return
     */
    @ApiOperation(value = "查看接处警功能场所记录表详情", notes = "查看接处警功能场所记录表详情", httpMethod = "POST")
    @RequestMapping("/bdHandlingArea/bdHandlingAreaModel")
    @ResponseBody
    public ResponseData<BdHandlingArea> bdHandlingAreaModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdHandlingArea bdHandlingArea = bdHandlingAreaService.getBdHandlingArea(objid);
            return new ResponseData<BdHandlingArea>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdHandlingArea);
        }catch (Exception e){
            logger.error("查看接处警功能场所记录表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接处警功能场所记录表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接处警功能场所记录表
     * @return
     */
    @ApiOperation(value = "删除接处警功能场所记录表", notes = "删除接处警功能场所记录表", httpMethod = "POST")
    @RequestMapping("/bdHandlingArea/bdHandlingAreaDelete")
    @ResponseBody
    public ResponseData<String> bdHandlingAreaDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = bdHandlingAreaService.bdHandlingAreaDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接处警功能场所记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接处警功能场所记录表错误:"+e.getMessage());
        }
    }

    /**
     * 校验是否有重复场所
     * @return
     */
    @ApiOperation(value = "校验是否有重复场所", notes = "校验是否有重复场所", httpMethod = "POST")
    @RequestMapping("/bdHandlingArea/bdHandlingAreaByParam")
    @ResponseBody
    public ResponseData<List<BdHandlingArea>> bdHandlingAreaByParam(@RequestBody BdHandlingAreaReqParam bdHandlingArea) {
        ResponseDto<List<BdHandlingArea>> dto = new ResponseDto<List<BdHandlingArea>>();
        try{
            List<BdHandlingArea> list = bdHandlingAreaService.bdHandlingAreaByParam(bdHandlingArea,null);
            return new ResponseData<List<BdHandlingArea>>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",list);
        }catch (Exception e){
            logger.error("查看接处警功能场所记录表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接处警功能场所记录表详情错误:"+e.getMessage());
        }
    }
}
