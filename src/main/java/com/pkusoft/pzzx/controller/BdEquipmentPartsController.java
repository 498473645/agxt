package com.pkusoft.pzzx.controller;

import com.pkusoft.pzzx.po.BdEquipmentParts;
import com.pkusoft.pzzx.req.BdEquipmentPartsReqParam;
import com.pkusoft.pzzx.service.BdEquipmentPartsService;
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
* 基础数据_接警平台设备参数配置表 相关操作
* Auto-generated
*/
@Controller
public class BdEquipmentPartsController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(BdEquipmentPartsController.class);

    @Autowired
    private BdEquipmentPartsService bdEquipmentPartsService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台设备参数配置表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台设备参数配置表", notes = "查询接警平台设备参数配置表", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/bdEquipmentPartsList")
    @ResponseBody
    public ResponseData<List<BdEquipmentParts>> bdEquipmentPartsList(HttpServletRequest request, @RequestBody BdEquipmentPartsReqParam bdEquipmentParts){
        ResponseDto<List<BdEquipmentParts>> dto = new ResponseDto<List<BdEquipmentParts>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<BdEquipmentParts> list = bdEquipmentPartsService.getBdEquipmentPartsList(bdEquipmentParts,user);
            int count = bdEquipmentPartsService.getBdEquipmentPartsCount(bdEquipmentParts,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台设备参数配置表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台设备参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台设备参数配置表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台设备参数配置表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台设备参数配置表", notes = "新增或修改接警平台设备参数配置表", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/bdEquipmentPartsSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> bdEquipmentPartsSaveOrUpdate(@RequestBody BdEquipmentParts bdEquipmentParts, HttpServletRequest request){
        try {
            if (!StringUtils.hasText(bdEquipmentParts.getEObjid())){
                return new ResponseData<String>(ResponseData.STATUS_CODE_PARAM,"设备id不能为空");
            }
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(bdEquipmentParts.getObjid())) {
                //添加接警平台设备参数配置表
                num = bdEquipmentPartsService.bdEquipmentPartsSave(bdEquipmentParts, user);
            }else{
                //修改接警平台设备参数配置表
                num = bdEquipmentPartsService.bdEquipmentPartsUpdate(bdEquipmentParts, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }else if (num==-1){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能找到参数对应的设备信息");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台设备参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台设备参数配置表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台设备参数配置表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台设备参数配置表详情", notes = "查看接警平台设备参数配置表详情", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/bdEquipmentPartsModel")
    @ResponseBody
    public ResponseData<BdEquipmentParts> bdEquipmentPartsModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdEquipmentParts bdEquipmentParts = bdEquipmentPartsService.getBdEquipmentParts(objid);
            return new ResponseData<BdEquipmentParts>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipmentParts);
        }catch (Exception e){
            logger.error("查看接警平台设备参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台设备参数配置表详情错误:"+e.getMessage());
        }
    }

    /**
     * 根据设备主键获取设备参数集合
     * @return
     */
    @ApiOperation(value = "根据设备主键获取设备参数集合", notes = "根据设备主键获取设备参数集合", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/getBdEquipmentPartsMapByEobjid")
    @ResponseBody
    public ResponseData<Map> getBdEquipmentPartsMapByEobjid(@RequestBody Map map) {
        String equipObjid = (String) map.get("equipObjid");
        if (!StringUtils.hasText(equipObjid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            Map<String,Object> bdEquipmentPartsMap = bdEquipmentPartsService.getBdEquipmentPartsMapByEobjid(equipObjid);
            return new ResponseData<Map>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipmentPartsMap);
        }catch (Exception e){
            logger.error("查看接警平台设备参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台设备参数配置表详情错误:"+e.getMessage());
        }
    }

    /**
     * 根据设备类型获取当前单位的设备参数集合
     * @return
     */
    @ApiOperation(value = "根据设备主键获取设备参数集合", notes = "根据设备主键获取设备参数集合", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/getBdEquipmentPartsMapByObjtype")
    @ResponseBody
    public ResponseData<Map> getBdEquipmentPartsMapByObjtype(@RequestBody Map map, HttpServletRequest request) {
        String objtype = (String) map.get("objtype");
        if (!StringUtils.hasText(objtype)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            Map<String,Object> bdEquipmentPartsMap = bdEquipmentPartsService.getBdEquipmentPartsMapByObjtype(objtype,user);
            return new ResponseData<Map>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipmentPartsMap);
        }catch (Exception e){
            logger.error("查看接警平台设备参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台设备参数配置表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台设备参数配置表
     * @return
     */
    @ApiOperation(value = "删除接警平台设备参数配置表", notes = "删除接警平台设备参数配置表", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/bdEquipmentPartsDelete")
    @ResponseBody
    public ResponseData<String> bdEquipmentPartsDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = bdEquipmentPartsService.bdEquipmentPartsDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台设备参数配置表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台设备参数配置表错误:"+e.getMessage());
        }
    }

    /**
     * 根据设备类型获取当前单位的设备参数对象集合
     * @return
     */
    @ApiOperation(value = "根据设备主键获取设备参数对象集合", notes = "根据设备主键获取设备参数对象集合", httpMethod = "POST")
    @RequestMapping("/bdEquipmentParts/getBdEquipmentPartsListByObjtype")
    @ResponseBody
    public ResponseData<List<BdEquipmentParts>> getBdEquipmentPartsListByObjtype(@RequestBody Map map, HttpServletRequest request) {
        String equipObjid = (String) map.get("equipObjid");
        if (!StringUtils.hasText(equipObjid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            //获取当前操作用户信息
            List<BdEquipmentParts> bdEquipmentPartsList = bdEquipmentPartsService.getBdEquipmentPartsListByObjtype(equipObjid);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipmentPartsList);
        }catch (Exception e){
            logger.error("查看接警平台设备参数配置表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台设备参数配置表详情错误:"+e.getMessage());
        }
    }
}
