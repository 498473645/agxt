package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.req.PsTransReqParam;
import com.pkusoft.ygjw.service.PsTransService;
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
 *  相关操作
 */
@Api(value="",tags={"阳光警务相关业务"})
@Controller
public class PsTransController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsTransController.class);

    @Autowired
    private PsTransService psTransService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询事务列表数据
    * @param psTransReqParam
    * @return
    */
    @ApiOperation(value="查询事务列表数据", notes="查询事务列表数据", httpMethod="POST")
    @RequestMapping(value = "/psTrans/psTransList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTrans>> psTransList(HttpServletRequest request, @RequestBody PsTransReqParam psTransReqParam){
        ResponseDto<List<PsTrans>> dto = new ResponseDto<List<PsTrans>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<PsTrans> list = psTransService.getPsTransList(psTransReqParam,user);
            int count = psTransService.getPsTransCount(psTransReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询事务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询事务数据错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改事务数据
     * @return
     */
    @ApiOperation(value = "新增或修改事务数据", notes = "新增或修改事务数据", httpMethod = "POST")
    @RequestMapping("/psTrans/psTransSaveOrUpdate")
    @ResponseBody
    public ResponseData<PsTrans> psTransSaveOrUpdate(@RequestBody PsTrans psTrans, HttpServletRequest request){
        try {
            int num = 0;
            String id;
            //获取当前操作用户信息
            Map<String, String> user = new HashMap<>();
            if(!StringUtils.hasText(psTrans.getId())) {
                //添加事务数据
                id = psTransService.psTransSave(psTrans, user);
                psTrans.setId(id);
            }else{
                //修改事务数据
                num = psTransService.psTransUpdate(psTrans, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psTrans);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败",psTrans);
        }catch (Exception e) {
            logger.error("增加/修改事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "增加/修改事务数据错误"+e.getMessage(),null);
        }
    }

    /**
    * 查看事务数据
    * @param map
    * @return
    */
    @ApiOperation(value="查看事务数据", notes="查看事务数据", httpMethod="POST")
    @RequestMapping(value = "/psTrans/psTransDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsTrans> psTransDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsTrans psTrans = psTransService.getPsTrans(id);
            if (null == psTrans.getId()) {
                return new ResponseData<PsTrans>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", null);
            }
            return new ResponseData<PsTrans>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psTrans);
        }catch (Exception e){
            logger.error("查看事务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看事务数据详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除事务数据
    * @param map
    * @return
    */
    @ApiOperation(value="删除事务数据", notes="删除事务数据", httpMethod="POST")
    @RequestMapping(value = "/psTrans/psTransDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psTransDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psTransService.psTransDelete(id);
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
     * 新增或修改事务数据(阳光警务客户端调用)
     * @return
     */
    @ApiOperation(value = "新增或修改事务数据(阳光警务客户端调用)", notes = "新增或修改事务数据(阳光警务客户端调用)", httpMethod = "POST")
    @RequestMapping("/psTrans/psTransSaveOrUpdateYGJW")
    @ResponseBody
    public ResponseData<String> psTransSaveOrUpdateYGJW(@RequestBody PsTrans psTrans, HttpServletRequest request){
        try {
            int num = 0;
            String id;
            //获取当前操作用户信息
            Map<String, String> user = new HashMap<>();
            if(StringUtils.hasText(psTrans.getId())){
                PsTrans oldPsTrans = psTransService.getPsTrans(psTrans.getId());
                if(oldPsTrans==null) {
                    //添加事务数据
                    id = psTransService.psTransSave(psTrans, user);
                    psTrans.setId(id);
                }else{
                    //修改事务数据
                    num = psTransService.psTransUpt(psTrans, user);
                }
            }else{
                //添加事务数据
                id = psTransService.psTransSave(psTrans, user);
                psTrans.setId(id);
            }
           return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psTrans.getId());
        }catch (Exception e) {
            logger.error("增加/修改事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "增加/修改事务数据错误"+e.getMessage());
        }
    }

    /**
     * 动态----获取动态（演示用）
     * @return
     */
    @ApiOperation(value="动态----获取动态（演示用）", notes="动态----获取动态（演示用）", httpMethod="POST")
    @RequestMapping(value = "/psTrans/getDynamicData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTrans>> getDynamicData(@RequestBody Map<String,String> map, HttpServletRequest request){
        ResponseDto<List<PsTrans>> dto = new ResponseDto<List<PsTrans>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsTrans> list = psTransService.getDynamicData(map);
            int count = psTransService.getDynamicCount(map);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("动态----获取动态（演示用）成功");
            return dto;
        }catch(Exception e){
            logger.error("动态----获取动态（演示用）错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"动态----获取动态（演示用）错误"+e.getMessage());
        }
    }

    /**
     * 查询事务列表数据
     * @return
     */
    @ApiOperation(value="查询事务列表数据", notes="查询事务列表数据", httpMethod="POST")
    @RequestMapping(value = "/psTrans/getPsTransListByIdcard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTrans>> getPsTransListByIdcard(HttpServletRequest request, @RequestBody Map<String,String> map){
        ResponseDto<List<PsTrans>> dto = new ResponseDto<List<PsTrans>>();
        try{
            String idcard = map.get("idcard");
            String ly = map.get("ly");
            if (!StringUtils.hasText(idcard)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
            }
            Map<String, String> user = new HashMap<>();
            List<PsTrans> list = psTransService.getPsTransListByIdcard(idcard,ly);
//            int count = psTransService.getPsTransCount(psTransReqParam,user);
            dto.setData(list);
//            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询事务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询事务数据错误"+e.getMessage());
        }
    }

}
