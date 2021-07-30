package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpFkxx;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.req.SpFkxxReqParam;
import com.pkusoft.jjpt.req.SpJjxxReqParam;
import com.pkusoft.jjpt.res.Jcjxx;
import com.pkusoft.jjpt.service.SpFkxxService;
import com.pkusoft.jjpt.service.SpJjxxService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
*  相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpFkxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpFkxxController.class);

    @Autowired
    private SpFkxxService spFkxxService ;

    @Autowired
    private SpJjxxService spJjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台反馈信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台反馈信息表", notes = "查询接警平台反馈信息表", httpMethod = "POST")
    @RequestMapping("/spFkxx/spFkxxList")
    @ResponseBody
    public ResponseData<List<SpFkxx>> spFkxxList(HttpServletRequest request, @RequestBody SpFkxxReqParam spFkxx){
        ResponseDto<List<SpFkxx>> dto = new ResponseDto<List<SpFkxx>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpFkxx> list = spFkxxService.getSpFkxxList(spFkxx,user);
            int count = spFkxxService.getSpFkxxCount(spFkxx,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台反馈信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台反馈信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台反馈信息表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台反馈信息表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台反馈信息表", notes = "新增或修改接警平台反馈信息表", httpMethod = "POST")
    @RequestMapping("/spFkxx/spFkxxSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spFkxxSaveOrUpdate(@RequestBody SpFkxx spFkxx, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spFkxx.getObjid())) {
                //添加接警平台反馈信息表
                num = spFkxxService.spFkxxSave(spFkxx, user);
            }else{
                //修改接警平台反馈信息表
                num = spFkxxService.spFkxxUpdate(spFkxx, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台反馈信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台反馈信息表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台反馈信息表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台反馈信息表详情", notes = "查看接警平台反馈信息表详情", httpMethod = "POST")
    @RequestMapping("/spFkxx/spFkxxModel")
    @ResponseBody
    public ResponseData<SpFkxx> spFkxxModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpFkxx spFkxx = spFkxxService.getSpFkxx(objid);
            return new ResponseData<SpFkxx>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spFkxx);
        }catch (Exception e){
            logger.error("查看接警平台反馈信息表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台反馈信息表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台反馈信息表
     * @return
     */
    @ApiOperation(value = "删除接警平台反馈信息表", notes = "删除接警平台反馈信息表", httpMethod = "POST")
    @RequestMapping("/spFkxx/spFkxxDelete")
    @ResponseBody
    public ResponseData<String> spFkxxDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spFkxxService.spFkxxDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台反馈信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台反馈信息表错误:"+e.getMessage());
        }
    }

    /**
     * 处警工作台接警信息和处警信息查询
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "处警工作台接警信息和处警信息查询", notes = "查处警工作台接警信息和处警信息查询", httpMethod = "POST")
    @RequestMapping("/spFkxx/getJjxxCjxx")
    @ResponseBody
    public ResponseData<Jcjxx> getJjxxCjxx(HttpServletRequest request, @RequestBody SpFkxxReqParam spFkxxReqParam){
        ResponseDto<Jcjxx> dto = new ResponseDto<Jcjxx>();
        try{
            if(!StringUtils.hasText(spFkxxReqParam.getJjdObjid())){
                return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"接警单id为空!查询失败!");
            }
            Jcjxx jcjxx = spFkxxService.getJjCjxx(spFkxxReqParam.getJjdObjid());
            dto.setData(jcjxx);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("处警工作台接警信息和处警信息查询成功");
            return dto;
        }catch(Exception e){
            logger.error("处警工作台接警信息和处警信息查询错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"处警工作台接警信息和处警信息查询错误"+e.getMessage());
        }
    }

    /**
     * 处警工作台接警信息列表查询
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "处警工作台接警信息列表查询", notes = "处警工作台接警信息列表查询", httpMethod = "POST")
    @RequestMapping("/spFkxx/getCjtJjxx")
    @ResponseBody
    public ResponseData<Map> getCjtJjxx(HttpServletRequest request, @RequestBody SpJjxxReqParam spJjxx){
        ResponseDto<Map> dto = new ResponseDto<Map>();
        Map<String, List<SpJjxx>> jcjxxs = new HashMap<String, List<SpJjxx>>();
        try{
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            //根据登录人id查询接警信息表信息(待处理)
            List<SpJjxx> jcjxxsDCL = spJjxxService.spJjxxByCjrCode(user.get("userId"),"1002/1003");
            jcjxxs.put("jcjxxsDCL",jcjxxsDCL);
            //根据登录人id查询接警信息表信息(近期已处理)
            List<SpJjxx> jcjxxsYCL = spJjxxService.spJjxxByCjrCode(user.get("userId"),"1004/1005");
            jcjxxs.put("jcjxxsYCL",jcjxxsYCL);
            dto.setData(jcjxxs);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台反馈信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台反馈信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台反馈信息表错误"+e.getMessage());
        }
    }

	/**
	 * 处警工作台--反馈操作
	 * @param request  txtQuery
	 * @return
	 */
	@ApiOperation(value = "处警工作台--反馈操作", notes = "处警工作台--反馈操作", httpMethod = "POST")
	@RequestMapping("/spFkxx/postfeedBack")
	@ResponseBody
	public ResponseData<String> postfeedBack(HttpServletRequest request, @RequestBody SpFkxx spFkxx){
		ResponseDto<String> dto = new ResponseDto<String>();
		Map<String, List<SpJjxx>> jcjxxs = new HashMap<String, List<SpJjxx>>();
		try{
            if(!StringUtils.hasText(spFkxx.getObjid())){
                return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"处警单id为空!反馈失败!");
            }
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(request);
			//调用处警反馈接口
            String msg = spFkxxService.postfeedBack(spFkxx,user);
			dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
			dto.setStatusMsg(msg);
			return dto;
		}catch(Exception e){
			logger.error("处警工作台--反馈操作错误",e);
			e.printStackTrace();
			return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"处警工作台--反馈操作错误"+e.getMessage());
		}
	}
}
