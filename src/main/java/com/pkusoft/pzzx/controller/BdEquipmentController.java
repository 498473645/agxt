package com.pkusoft.pzzx.controller;

import com.pkusoft.pzzx.po.BdEquipment;
import com.pkusoft.pzzx.req.BdEquipmentReqParam;
import com.pkusoft.pzzx.service.BdEquipmentService;
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
* 基础数据_接警平台设备登记表 相关操作
* Auto-generated
*/
@Controller
public class BdEquipmentController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(BdEquipmentController.class);

    @Autowired
    private BdEquipmentService bdEquipmentService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台设备登记表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台设备登记表", notes = "查询接警平台设备登记表", httpMethod = "POST")
    @RequestMapping("/bdEquipment/bdEquipmentList")
    @ResponseBody
    public ResponseData<List<BdEquipment>> bdEquipmentList(HttpServletRequest request, @RequestBody BdEquipmentReqParam bdEquipment){
        ResponseDto<List<BdEquipment>> dto = new ResponseDto<List<BdEquipment>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<BdEquipment> list = bdEquipmentService.getBdEquipmentList(bdEquipment,user);
            int count = bdEquipmentService.getBdEquipmentCount(bdEquipment,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台设备登记表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台设备登记表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台设备登记表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台设备登记表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台设备登记表", notes = "新增或修改接警平台设备登记表", httpMethod = "POST")
    @RequestMapping("/bdEquipment/bdEquipmentSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> bdEquipmentSaveOrUpdate(@RequestBody BdEquipment bdEquipment, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if (StringUtils.hasText(bdEquipment.getEId()) && !StringUtils.hasText(bdEquipment.getObjid())) { // 唯一标识
               BdEquipment newBdEquipment = bdEquipmentService.getBdEquipmentByEId(bdEquipment.getEId());
               if (newBdEquipment.getObjid() != null) {
                   return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"设备唯一标识已存在");
               }
            }
            if(!StringUtils.hasText(bdEquipment.getObjid())) {
                //添加接警平台设备登记表
                num = bdEquipmentService.bdEquipmentSave(bdEquipment, user);
            }else{
                BdEquipment newBdEquipment = bdEquipmentService.getBdEquipmentByEId(bdEquipment.getEId());
                // 根据唯一标识查询设备信息，如果获取的设备id不相同，就说明存在其他的设备，相同就是直接修改
                if (newBdEquipment.getObjid() !=null && !bdEquipment.getObjid().equals(newBdEquipment.getObjid())) {
                    return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"设备唯一标识已存在");
                }
                //修改接警平台设备登记表
                num = bdEquipmentService.bdEquipmentUpdate(bdEquipment, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台设备登记表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台设备登记表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台设备登记表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台设备登记表详情", notes = "查看接警平台设备登记表详情", httpMethod = "POST")
    @RequestMapping("/bdEquipment/bdEquipmentModel")
    @ResponseBody
    public ResponseData<BdEquipment> bdEquipmentModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdEquipment bdEquipment = bdEquipmentService.getBdEquipment(objid);
            return new ResponseData<BdEquipment>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipment);
        }catch (Exception e){
            logger.error("查看接警平台设备登记表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台设备登记表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台设备登记表
     * @return
     */
    @ApiOperation(value = "删除接警平台设备登记表", notes = "删除接警平台设备登记表", httpMethod = "POST")
    @RequestMapping("/bdEquipment/bdEquipmentDelete")
    @ResponseBody
    public ResponseData<String> bdEquipmentDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = bdEquipmentService.bdEquipmentDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台设备登记表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台设备登记表错误:"+e.getMessage());
        }
    }

    /**
     * 根据eid查看接警平台设备登记表详情
     * @return
     */
    @ApiOperation(value = "根据eid查看接警平台设备登记表详情", notes = "根据eid查看接警平台设备登记表详情", httpMethod = "POST")
    @RequestMapping("/bdEquipment/bdEquipmentModelByEid")
    @ResponseBody
    public ResponseData<BdEquipment> bdEquipmentModelByEid(@RequestBody Map map) {
        String eid = (String) map.get("eid");
        if (!StringUtils.hasText(eid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            BdEquipment bdEquipment = bdEquipmentService.getBdEquipmentByEId(eid);
            if (null == bdEquipment.getObjid()) {
                return new ResponseData<BdEquipment>("90", "未查询到数据", null);
            }
            return new ResponseData<BdEquipment>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",bdEquipment);
        }catch (Exception e){
            logger.error("根据eid查看接警平台设备登记表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "根据eid查看接警平台设备登记表详情错误:"+e.getMessage());
        }
    }
}
