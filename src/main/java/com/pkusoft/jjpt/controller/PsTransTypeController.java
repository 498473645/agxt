package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.PsTransType;
import com.pkusoft.jjpt.service.PsTransTypeService;
import com.pkusoft.usercenter.sysdicitem.SysDicItemValue;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ControllerUtil;
import org.support.commons.springmvc.ResponseData;
import pkubatis.model.GridResult;
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(value="",tags={"业务类型表操作"})
@Controller
public class PsTransTypeController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(PsTransTypeController.class);

    @Autowired
    private PsTransTypeService psTransTypeService;

    /***获取代理用户信息服务类
     @Autowired
     private UserCenterProxyHelper userCenterProxyHelper;*/

    /**
     * 查询业务类型
     * @param request  txtQuery
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeList")
    @ResponseBody
    public ResponseData<List<PsTransType>> psTransTypeList(HttpServletRequest request){
        ResponseData<List<PsTransType>> dto = new ResponseData<List<PsTransType>>();
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);
            List<PsTransType> list = psTransTypeService.getPsTransTypeList(map);
            int count = psTransTypeService.getPsTransTypeCount(map);
            dto.setData(list);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询业务类型成功");
        }catch(Exception e){
            logger.error("查询业务类型错误",e);
            e.printStackTrace();
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);

        }
        return dto;
    }

    /**
     * 新增或修改业务类型
     * @param psTransType
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeSaveOrUpdate")
    @ResponseBody
    public JsonResult psTransTypeSaveOrUpdate(PsTransType psTransType, String id, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            //Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(id == null){
                //添加业务类型
                psTransTypeService.psTransTypeSave(psTransType);
            }else{
                //修改业务类型
                psTransTypeService.psTransTypeUpdate(psTransType);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改业务类型错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
     * 查看业务类型详情
     * @param id
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeModel")
    @ResponseBody
    public JsonResult PsTransTypeModel(String id) {
        PsTransType psTransType = psTransTypeService.getPsTransType(id);
        return new JsonResult(true,psTransType);
    }

    /**
     * 查看业务类型字典
     * @param sysDicItemValue
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeDic")
    @ResponseBody
    public ResponseData<SysDicItemValue> psTransTypeDic(@RequestBody SysDicItemValue sysDicItemValue) {
        ResponseData<SysDicItemValue> dto = new ResponseData<SysDicItemValue>();
        try {
            PsTransType transType = new PsTransType();
            SysDicItemValue dicItem = new SysDicItemValue();
            transType.setCode(sysDicItemValue.getDicCode());
            List<PsTransType> psTransTypes = psTransTypeService.getPsTransTypeByParam(transType);
            if (null != psTransTypes && psTransTypes.size()>0){
                transType = psTransTypes.get(0);
            }
            dicItem.setDicCode(transType.getCode());
            dicItem.setDicName(transType.getName());
            dto.setData(dicItem);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
            return dto;
        } catch (Exception e) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
            dto.setStatusMsg("请求失败!");
            e.printStackTrace();
            return dto;
        }
    }

    /**
     * 查看业务类型字典
     * @param psTransType
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeDicList")
    @ResponseBody
    public ResponseData<List<SysDicItemValue>> psTransTypeDicList(@RequestBody PsTransType psTransType, @RequestParam String type) {
        ResponseData<List<SysDicItemValue>> dto = new ResponseData<List<SysDicItemValue>>();
        try {
            PsTransType transType = new PsTransType();
            List<SysDicItemValue> dicItems = new ArrayList<>();
            if (StringUtils.hasText(type)){
                transType.setType(type);
            }else if (StringUtils.hasText(psTransType.getType())){
                transType.setType(psTransType.getType());
            }
            List<PsTransType> psTransTypes = psTransTypeService.getPsTransTypeByParam(transType);
            for(PsTransType t : psTransTypes){
                SysDicItemValue dicItem = new SysDicItemValue();
                dicItem.setDicCode(t.getCode());
                dicItem.setDicName(t.getName());
                dicItems.add(dicItem);
            }
            dto.setData(dicItems);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
            return dto;
        } catch (Exception e) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
            dto.setStatusMsg("请求失败!");
            e.printStackTrace();
            return dto;
        }
    }

    /**
     * 删除业务类型
     * @param id
     * @return
     */
    @RequestMapping("/psTransType/psTransTypeDelete")
    @ResponseBody
    public JsonResult psTransTypeDelete(String[] id) {
        if(id != null){
            int num = psTransTypeService.psTransTypeDelete(id);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除业务类型错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }


}
