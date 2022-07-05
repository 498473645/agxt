package com.pkusoft.jjpt.controller;


import com.pkusoft.jjpt.po.SpPatrolProblem;
import com.pkusoft.jjpt.req.SpPatrolProblemReqParam;
import com.pkusoft.jjpt.service.SpPatrolProblemService;
import com.pkusoft.lesppc.model.PcBjwt;
import com.pkusoft.lesppc.service.PcBjwtService;
import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsTrans;
import com.pkusoft.ygjw.req.PsTransReqParam;
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
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author
 * 巡查问题信息表 相关操作
 */
@Api(value="巡查问题信息表",tags={"巡查问题信息表 相关操作"})
@Controller
public class SpPatrolProblemController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(SpPatrolProblemController.class);

    @Autowired
    private SpPatrolProblemService spPatrolProblemService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private PcBjwtService pcBjwtService;

    /**
     * 查询巡查问题列表数据
     * @param spPatrolProblemReqParam
     * @return
     */
    @ApiOperation(value="查询巡查问题列表数据", notes="查询巡查问题列表数据", httpMethod="POST")
    @RequestMapping(value = "/spPatrolProblem/spPatrolProblemList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<SpPatrolProblem>> psTransList(HttpServletRequest request, @RequestBody SpPatrolProblemReqParam spPatrolProblemReqParam){
        ResponseDto<List<SpPatrolProblem>> dto = new ResponseDto<List<SpPatrolProblem>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpPatrolProblem> list = spPatrolProblemService.getSpPatrolProblemList(spPatrolProblemReqParam,user);
            int count = spPatrolProblemService.getSpPatrolProblemCount(spPatrolProblemReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询巡查问题数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询巡查问题数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询巡查问题数据错误"+e.getMessage());
        }
    }

    /**
     * 查看巡查问题详情
     * @return
     */
    @ApiOperation(value = "查看巡查问题详情", notes = "查看巡查问题详情", httpMethod = "POST")
    @RequestMapping("/spPatrolProblem/spPatrolProblemDetail")
    @ResponseBody
    public ResponseData<SpPatrolProblem> bdHandlingAreaModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpPatrolProblem spPatrolProblem = spPatrolProblemService.getSpPatrolProblem(objid);
            return new ResponseData<SpPatrolProblem>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spPatrolProblem);
        }catch (Exception e){
            logger.error("查看巡查问题详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看巡查问题详情错误:"+e.getMessage());
        }
    }

    /**
    * 新增修改巡查问题信息表
    * @param
    * @return
    */
    @ApiOperation(value="新增修改巡查问题信息表", notes="新增修改巡查问题信息表")
    @RequestMapping(value = "/spPatrolProblem/spPatrolProblemSaveAndUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonResult spPatrolProblemSaveAndUpdate(@RequestBody SpPatrolProblem spPatrolProblem, String id, String wtmxbh, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(id == null){
                //添加业务类型
                String objid = UUID.randomUUID().toString();
                spPatrolProblem.setObjid(objid);
                int num = spPatrolProblemService.spPatrolProblemSave(spPatrolProblem, user);
                if (num>0) {
                    PcBjwt pcBjwt = new PcBjwt();
                    pcBjwt.setWtwd1(objid);
                    pcBjwtService.pcBjwtSave(pcBjwt,wtmxbh,user);
                }
            }else{
                //修改业务类型
                spPatrolProblemService.spPatrolProblemUpdate(spPatrolProblem, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改业务类型错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

}
