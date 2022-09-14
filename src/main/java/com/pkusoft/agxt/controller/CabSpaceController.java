package com.pkusoft.agxt.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysUserService;
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



import com.pkusoft.agxt.service.CabSpaceService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷柜空间信息表 相关操作
 */
@Api(value="案卷柜空间信息表",tags={"案卷柜空间信息表 相关操作"})
@Controller
public class CabSpaceController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabSpaceController.class);

    @Autowired
    private CabSpaceService cabSpaceService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    /**
    * 查询案卷柜空间信息表
    * @param cabSpaceParam
    * @return
    */
    @ApiOperation(value="查询案卷柜空间信息表", notes="查询案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CabSpaceParam>> cabSpaceList(HttpServletRequest request, @RequestBody CabSpaceParam cabSpaceParam){
            ResponseDto<List<CabSpaceParam>> dto = new ResponseDto<List<CabSpaceParam>>();
            SysUser sysUser=sysUserService.getCurrentUser(request);
            try {
                List<CabSpaceParam> list = cabSpaceService.getCabSpaceParamList(cabSpaceParam, sysUser);
                for (int i = 0; i < list.size(); i++) {
                    SysDept dept = sysDeptService.getSysDept(list.get(i).getOrgCode());
                    SysDept dept1 = sysDeptService.getSysDept(list.get(i).getCurOrg());
                    if(dept!=null){
                        list.get(i).setDeptName(dept.getDeptName());
                    }
                    if(dept1!=null){
                        list.get(i).setCurOrgName(dept1.getDeptName());
                    }
                }
                int count = cabSpaceService.getCabSpaceParamCount(cabSpaceParam, sysUser);

                dto.setData(list);
                dto.setCount(count);
                dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
                dto.setStatusMsg("查询案卷柜空间信息表成功");
                return dto;
            } catch (Exception e) {
                log.error("空间表查询列表数据出错", e);
                e.printStackTrace();
                return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"空间表查询列表数据出错");
            }

    }

    /**
    * 新增案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增案卷柜空间信息表", notes="新增案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceSave(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

    /**
    * 修改案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改案卷柜空间信息表", notes="修改案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceUpdate(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

    /**
    * 查看案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="查看案卷柜空间信息表", notes="查看案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceDetails(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }


	/**
    * 删除案卷柜空间信息表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="删除案卷柜空间信息表", notes="删除案卷柜空间信息表")
    @RequestMapping(value = "/cabSpace/cabSpaceDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceDelete(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }

}
