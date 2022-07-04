package com.pkusoft.jjpt.controller;


import java.util.Map;


import com.pkusoft.jjpt.po.PsTransType;
import com.pkusoft.jjpt.po.SpPatrolProblem;
import com.pkusoft.jjpt.service.SpPatrolProblemService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletRequest;

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

    /**
    * 新增修改巡查问题信息表
    * @param
    * @return
    */
    @ApiOperation(value="新增修改巡查问题信息表", notes="新增修改巡查问题信息表")
    @RequestMapping(value = "/spPatrolProblem/spPatrolProblemSaveAndUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JsonResult spPatrolProblemSaveAndUpdate(@RequestBody SpPatrolProblem spPatrolProblem, String id, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(id == null){
                //添加业务类型
                spPatrolProblemService.spPatrolProblemSave(spPatrolProblem, user);
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
