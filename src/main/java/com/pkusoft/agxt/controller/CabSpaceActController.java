package com.pkusoft.agxt.controller;


import java.util.*;


import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.CabSpaceAct;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.CabSpaceActParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import com.pkusoft.agxt.service.CabSpaceActService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷柜空间指令表 相关操作
 */
@Api(value="案卷柜空间指令表",tags={"案卷柜空间指令表 相关操作"})
@Controller
public class CabSpaceActController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabSpaceActController.class);

    @Autowired
    private CabSpaceActService cabSpaceActService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷柜空间指令表
    * @param cabSpaceActParam
    * @return
    */
    @ApiOperation(value="查询案卷柜空间指令表", notes="查询案卷柜空间指令表")
    @RequestMapping(value = "/cabSpaceAct/cabSpaceActList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CabSpaceAct>> cabSpaceActList(@RequestBody CabSpaceActParam cabSpaceActParam, HttpServletRequest request){
        ResponseDto<List<CabSpaceAct>> dto = new ResponseDto<List<CabSpaceAct>>();
        SysUser sysUser = sysUserService.getCurrentUser(request);
        cabSpaceActParam.setCurOrg(sysUser.getDeptId());

        try {
            List<CabSpaceAct> list = cabSpaceActService.getCabSpaceActList(cabSpaceActParam, sysUser);
            int count = cabSpaceActService.getCabSpaceActCount(cabSpaceActParam, sysUser);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询空间口令表查询列表数据成功");
            return dto;
        } catch (Exception e) {
            log.error("查询空间口令表查询列表数据出错",e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询空间口令表查询列表数据出错");
        }

    }

    /**
    * 新增/修改案卷柜空间指令表
    * @param cabSpaceAct
    * @return
    */
    @ApiOperation(value="新增/修改案卷柜空间指令表", notes="新增案卷柜空间指令表")
    @RequestMapping(value = "/cabSpaceAct/cabSpaceActSaveOrUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceActSave(@RequestBody CabSpaceAct cabSpaceAct, HttpServletRequest request){
        try {
            if (cabSpaceAct == null) {
                return new ResponseData(ResponseData.STATUS_CODE_BIZ, "参数不能为空");
            }
            ResponseData responseData = new ResponseData();
            SysUser sysUser = sysUserService.getCurrentUser(request);
            if (!StringUtils.hasText(cabSpaceAct.getId())) {
                // 新增
                cabSpaceActService.cabSpaceActSave(cabSpaceAct,sysUser);
                responseData.setStatusMsg("新增案卷柜空间指令成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }else {
                // 修改
                cabSpaceActService.cabSpaceActUpdate(cabSpaceAct,sysUser);
                responseData.setStatusMsg("修改案卷柜空间指令成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }
            return responseData;
        }catch ( Exception e){
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"新增/修改案卷柜空间指令出错!");
        }
    }

    /**
    * 查看案卷柜空间指令表
    * @param map
    * @return
    */
    @ApiOperation(value="查看案卷柜空间指令表", notes="查看案卷柜空间指令表")
    @RequestMapping(value = "/cabSpaceAct/cabSpaceActDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<CabSpaceAct> cabSpaceActDetails(@RequestBody(required = false) Map<String, String> map){
        String id = map.get("id");
        if (!StringUtils.hasText(id)) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数不能为空");
        }
        try {
            CabSpaceAct cabSpaceAct = cabSpaceActService.getCabSpaceAct(id);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", cabSpaceAct);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查看案卷柜空间指令信息出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "查看案卷柜空间指令信息出错：" + e.getMessage());
        }
    }


	/**
    * 删除案卷柜空间指令表
    * @param cabSpaceActParam
    * @return
    */
    @ApiOperation(value="删除案卷柜空间指令表", notes="删除案卷柜空间指令表")
    @RequestMapping(value = "/cabSpaceAct/cabSpaceActDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabSpaceActDelete(@RequestBody CabSpaceActParam cabSpaceActParam){
        if(cabSpaceActParam.getIds() != null){
            int num = cabSpaceActService.cabSpaceActDelete(cabSpaceActParam.getIds());
            if(num>0){
                return new ResponseData(ResponseData.STATUS_CODE_SUCCESS, "操作成功", num);
            }else{
                return new ResponseData(ResponseData.STATUS_CODE_OTHER, "操作失败", num);
            }
        }else{
            log.error("请求参数不允许为空");
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "请求参数不允许为空");
        }
    }

}
