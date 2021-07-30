package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpRecordTips;
import com.pkusoft.jjpt.req.SpRecordTipsReqParam;
import com.pkusoft.jjpt.service.SpRecordTipsService;
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
* 业务数据_笔录信息_提示板信息储存表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpRecordTipsController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpRecordTipsController.class);

    @Autowired
    private SpRecordTipsService spRecordTipsService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台笔录信息_提示板信息储存表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台笔录信息_提示板信息储存表", notes = "查询接警平台笔录信息_提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spRecordTips/spRecordTipsList")
    @ResponseBody
    public ResponseData<List<SpRecordTips>> spRecordTipsList(HttpServletRequest request, @RequestBody SpRecordTipsReqParam spRecordTips){
        ResponseDto<List<SpRecordTips>> dto = new ResponseDto<List<SpRecordTips>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpRecordTips> list = spRecordTipsService.getSpRecordTipsList(spRecordTips,user);
            int count = spRecordTipsService.getSpRecordTipsCount(spRecordTips,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台笔录信息_提示板信息储存表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台笔录信息_提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台笔录信息_提示板信息储存表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台笔录信息_提示板信息储存表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台笔录信息_提示板信息储存表", notes = "新增或修改接警平台笔录信息_提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spRecordTips/spRecordTipsSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spRecordTipsSaveOrUpdate(@RequestBody SpRecordTips spRecordTips, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spRecordTips.getObjid())) {
                //添加接警平台笔录信息_提示板信息储存表
                num = spRecordTipsService.spRecordTipsSave(spRecordTips, user);
            }else{
                //修改接警平台笔录信息_提示板信息储存表
                num = spRecordTipsService.spRecordTipsUpdate(spRecordTips, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台笔录信息_提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台笔录信息_提示板信息储存表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台笔录信息_提示板信息储存表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台笔录信息_提示板信息储存表详情", notes = "查看接警平台笔录信息_提示板信息储存表详情", httpMethod = "POST")
    @RequestMapping("/spRecordTips/spRecordTipsModel")
    @ResponseBody
    public ResponseData<SpRecordTips> spRecordTipsModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpRecordTips spRecordTips = spRecordTipsService.getSpRecordTips(objid);
            return new ResponseData<SpRecordTips>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spRecordTips);
        }catch (Exception e){
            logger.error("查看接警平台笔录信息_提示板信息储存表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台笔录信息_提示板信息储存表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台笔录信息_提示板信息储存表
     * @return
     */
    @ApiOperation(value = "删除接警平台笔录信息_提示板信息储存表", notes = "删除接警平台笔录信息_提示板信息储存表", httpMethod = "POST")
    @RequestMapping("/spRecordTips/spRecordTipsDelete")
    @ResponseBody
    public ResponseData<String> spRecordTipsDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spRecordTipsService.spRecordTipsDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台笔录信息_提示板信息储存表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台笔录信息_提示板信息储存表错误:"+e.getMessage());
        }
    }
}
