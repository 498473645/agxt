package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpCjrxx;
import com.pkusoft.jjpt.req.SpCjrxxReqParam;
import com.pkusoft.jjpt.service.SpCjrxxService;
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
* 业务数据_处警人员记录表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpCjrxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpCjrxxController.class);

    @Autowired
    private SpCjrxxService spCjrxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台处警人员记录表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台处警人员记录表", notes = "查询接警平台处警人员记录表", httpMethod = "POST")
    @RequestMapping("/spCjrxx/spCjrxxList")
    @ResponseBody
    public ResponseData<List<SpCjrxx>> spCjrxxList(HttpServletRequest request, @RequestBody SpCjrxxReqParam spCjrxx){
        ResponseDto<List<SpCjrxx>> dto = new ResponseDto<List<SpCjrxx>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpCjrxx> list = spCjrxxService.getSpCjrxxList(spCjrxx,user);
            int count = spCjrxxService.getSpCjrxxCount(spCjrxx,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台处警人员记录表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台处警人员记录表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台处警人员记录表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台处警人员记录表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台处警人员记录表", notes = "新增或修改接警平台处警人员记录表", httpMethod = "POST")
    @RequestMapping("/spCjrxx/spCjrxxSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spCjrxxSaveOrUpdate(@RequestBody SpCjrxx spCjrxx, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spCjrxx.getObjid())) {
                //添加接警平台处警人员记录表
                num = spCjrxxService.spCjrxxSave(spCjrxx, user);
            }else{
                //修改接警平台处警人员记录表
                num = spCjrxxService.spCjrxxUpdate(spCjrxx, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台处警人员记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台处警人员记录表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台处警人员记录表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台处警人员记录表详情", notes = "查看接警平台处警人员记录表详情", httpMethod = "POST")
    @RequestMapping("/spCjrxx/spCjrxxModel")
    @ResponseBody
    public ResponseData<SpCjrxx> spCjrxxModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpCjrxx spCjrxx = spCjrxxService.getSpCjrxx(objid);
            return new ResponseData<SpCjrxx>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spCjrxx);
        }catch (Exception e){
            logger.error("查看接警平台处警人员记录表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台处警人员记录表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台处警人员记录表
     * @return
     */
    @ApiOperation(value = "删除接警平台处警人员记录表", notes = "删除接警平台处警人员记录表", httpMethod = "POST")
    @RequestMapping("/spCjrxx/spCjrxxDelete")
    @ResponseBody
    public ResponseData<String> spCjrxxDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spCjrxxService.spCjrxxDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台处警人员记录表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台处警人员记录表错误:"+e.getMessage());
        }
    }
}
