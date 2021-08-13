package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsApprs;
import com.pkusoft.ygjw.req.PsApprsReqParam;
import com.pkusoft.ygjw.req.PsApprsYgjwReqParam;
import com.pkusoft.ygjw.service.PsApprsService;
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
public class PsApprsController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsApprsController.class);

    @Autowired
    private PsApprsService psApprsService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询
    * @param psApprsReqParam
    * @return
    */
    @ApiOperation(value="查询评议监督业务数据", notes="查询评议监督业务数据", httpMethod="POST")
    @RequestMapping(value = "/psApprs/psApprsList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsApprs>> psApprsList(HttpServletRequest request, @RequestBody PsApprsReqParam psApprsReqParam){
        ResponseDto<List<PsApprs>> dto = new ResponseDto<List<PsApprs>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsApprs> list = psApprsService.getPsApprsList(psApprsReqParam,user);
            int count = psApprsService.getPsApprsCount(psApprsReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询评议监督业务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询评议监督业务数据错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改评议监督业务数据
     * @return
     */
    @ApiOperation(value = "新增或修改评议监督业务数据", notes = "新增或修改评议监督业务数据", httpMethod = "POST")
    @RequestMapping("/psApprs/psApprsSaveOrUpdate")
    @ResponseBody
    public ResponseData<PsApprs> psApprsSaveOrUpdate(@RequestBody PsApprs psApprs, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(psApprs.getId())) {
                //添加评议监督业务数据
                num = psApprsService.psApprsSave(psApprs, user);
            }else{
                //修改评议监督业务数据
                num = psApprsService.psApprsUpdate(psApprs, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psApprs);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败",psApprs);
        }catch (Exception e) {
            logger.error("增加/修改评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改评议监督业务数据错误"+e.getMessage(),null);
        }
    }
    
    /**
    * 查看评议监督业务数据
    * @param map
    * @return
    */
    @ApiOperation(value="查看评议监督业务数据", notes="查看评议监督业务数据", httpMethod="POST")
    @RequestMapping(value = "/psApprs/psApprsDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsApprs> psApprsDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsApprs psApprs = psApprsService.getPsApprs(id);
            if (null == psApprs.getId()) {
                return new ResponseData<PsApprs>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<PsApprs>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psApprs);
        }catch (Exception e){
            logger.error("查看评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看评议监督业务数据详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除评议监督业务数据
    * @param map
    * @return
    */
    @ApiOperation(value="删除评议监督业务数据", notes="删除评议监督业务数据", httpMethod="POST")
    @RequestMapping(value = "/psApprs/psApprsDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psApprsDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psApprsService.psApprsDelete(id);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除评议监督业务数据错误:"+e.getMessage());
        }
    }

    /**
     * 新增或修改评议监督业务数据(阳光警务客户端调用)
     * @return
     */
    @ApiOperation(value = "新增或修改评议监督业务数据(阳光警务客户端调用)", notes = "新增或修改评议监督业务数据(阳光警务客户端调用)", httpMethod = "POST")
    @RequestMapping("/psApprs/psApprsSaveOrUpdateYGJW")
    @ResponseBody
    public ResponseData<PsApprs> psApprsSaveOrUpdateYGJW(@RequestBody PsApprsYgjwReqParam psApprs, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            PsApprs oldPsApprs = null;
            if (StringUtils.hasText(psApprs.getId())){
                oldPsApprs = psApprsService.getPsApprs(psApprs.getId());
            }
            if(oldPsApprs==null) {
                //添加评议监督业务数据
                num = psApprsService.psApprsSave(psApprs, user);
            }else{
                //修改评议监督业务数据
                num = psApprsService.psApprsUpdate(psApprs, user);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psApprs);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败",psApprs);
        }catch (Exception e) {
            logger.error("增加/修改评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改评议监督业务数据错误"+e.getMessage(),null);
        }
    }

    /**
     * 根据身份证号查询评议监督业务数据
     * @return
     */
    @ApiOperation(value="根据身份证号查询评议监督业务数据", notes="根据身份证号查询评议监督业务数据", httpMethod="POST")
    @RequestMapping(value = "/psApprs/psApprsListByIdcard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsApprs>> psApprsListByIdcard(HttpServletRequest request, @RequestBody Map<String,String> map){
        String idcard = map.get("idcard");
        if (!StringUtils.hasText(idcard)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        ResponseDto<List<PsApprs>> dto = new ResponseDto<List<PsApprs>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsApprs> list = psApprsService.psApprsListByIdcard(idcard);
//            int count = psApprsService.getPsApprsCount(idcard,user);
            dto.setData(list);
//            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("根据身份证号查询评议监督业务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("根据身份证号查询评议监督业务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"根据身份证号查询评议监督业务数据错误"+e.getMessage());
        }
    }

}
