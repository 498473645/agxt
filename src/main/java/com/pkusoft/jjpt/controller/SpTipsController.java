package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpTips;
import com.pkusoft.jjpt.req.SpTipsReqParam;
import com.pkusoft.jjpt.service.SpTipsService;
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
* 业务数据_提示板信息储存表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpTipsController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpTipsController.class);

    @Autowired
    private SpTipsService spTipsService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台提示板信息储存表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台提示板信息储存表", notes = "查询接警平台提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spTips/spTipsList")
    @ResponseBody
    public ResponseData<List<SpTips>> spTipsList(HttpServletRequest request, @RequestBody SpTipsReqParam spTips){
        ResponseDto<List<SpTips>> dto = new ResponseDto<List<SpTips>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpTips> list = spTipsService.getSpTipsList(spTips,user);
            int count = spTipsService.getSpTipsCount(spTips,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台提示板信息储存表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台提示板信息储存表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台提示板信息储存表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台提示板信息储存表", notes = "新增或修改接警平台提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spTips/spTipsSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spTipsSaveOrUpdate(@RequestBody SpTips spTips, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spTips.getObjid())) {
                //添加接警平台提示板信息储存表
                num = spTipsService.spTipsSave(spTips, user);
            }else{
                //修改接警平台提示板信息储存表
                num = spTipsService.spTipsUpdate(spTips, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台提示板信息储存表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台提示板信息储存表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台提示板信息储存表详情", notes = "查看接警平台提示板信息储存表详情", httpMethod = "POST")
    @RequestMapping("/spTips/spTipsModel")
    @ResponseBody
    public ResponseData<SpTips> spTipsModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpTips spTips = spTipsService.getSpTips(objid);
            return new ResponseData<SpTips>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spTips);
        }catch (Exception e){
            logger.error("查看接警平台提示板信息储存表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台提示板信息储存表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台提示板信息储存表
     * @return
     */
    @ApiOperation(value = "删除接警平台提示板信息储存表", notes = "删除接警平台提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spTips/spTipsDelete")
    @ResponseBody
    public ResponseData<String> spTipsDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spTipsService.spTipsDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台提示板信息储存表错误:"+e.getMessage());
        }
    }
}
