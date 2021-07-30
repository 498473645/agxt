package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.ZzjbjBjxx;
import com.pkusoft.jjpt.req.ZzjbjBjxxReqParam;
import com.pkusoft.jjpt.res.Ybjxx;
import com.pkusoft.jjpt.service.ZzjbjBjxxService;
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
* 微信自助报警-报警信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class ZzjbjBjxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(ZzjbjBjxxController.class);

    @Autowired
    private ZzjbjBjxxService zzjbjBjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    /**
     * 查询接警平台接警信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台接警信息表", notes = "查询接警平台接警信息表", httpMethod = "POST")
    @RequestMapping("/zzjbjBjxx/zzjbjBjxxList")
    @ResponseBody
    public ResponseData<List<ZzjbjBjxx>> spJjxxList(HttpServletRequest request, @RequestBody ZzjbjBjxxReqParam zzjbjBjxxReqParam){
        ResponseDto<List<ZzjbjBjxx>> dto = new ResponseDto<List<ZzjbjBjxx>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<ZzjbjBjxx> list = zzjbjBjxxService.getZzjbjBjxxList(zzjbjBjxxReqParam,user);
            int count = zzjbjBjxxService.getZzjbjBjxxCount(zzjbjBjxxReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

    /**
     * 接警大屏-预报警信息列表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "接警大屏-预报警信息列表", notes = "接警大屏-预报警信息列表", httpMethod = "POST")
    @RequestMapping("/zzjbjBjxx/getBigScreenYbjxxList")
    @ResponseBody
    public ResponseData<List<Ybjxx>> getBigScreenYbjxxList(ZzjbjBjxx zzjbjBjxx, HttpServletRequest request){
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<Ybjxx> list = zzjbjBjxxService.getBigScreenYbjxxList(user);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功" , list);
        }catch(Exception e){
            logger.error("查询微信自助报警-屏幕展示内容",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "操作失败" );
        }
    }

    /**
     * 查询微信自助报警-屏幕展示内容
     * @param request  txtQuery
     * @return
     */
    @RequestMapping("/zzjbjBjxx/getScreenZzjbjBjxxList")
    @ResponseBody
    public ResponseData<List<ZzjbjBjxx>> getScreenZzjbjBjxxList(ZzjbjBjxx zzjbjBjxx, HttpServletRequest request){
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<ZzjbjBjxx> list = zzjbjBjxxService.getScreenZzjbjBjxxList(user,zzjbjBjxx.getIfAccept());
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功" , list);
        }catch(Exception e){
            logger.error("查询微信自助报警-屏幕展示内容",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "操作失败" );
        }
    }


    /**
    * 查看微信自助报警-报警信息表详情
    * @return
    */
    @RequestMapping("/zzjbjBjxx/zzjbjBjxxModel")
    @ResponseBody
    public ResponseData<ZzjbjBjxx> ZzjbjBjxxModel(@RequestBody Map map) {
        try {
            String bjid = (String) map.get("bjid");
            if (!StringUtils.hasText(bjid)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"报警编号不能为空");
            }
            ZzjbjBjxx zzjbjBjxx = zzjbjBjxxService.getZzjbjBjxx(bjid);
            if (zzjbjBjxx!=null){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zzjbjBjxx);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("查看微信自助报警-报警信息表详情错误",e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }
    }

}
