package com.pkusoft.agxt.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.CabPlace;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.CabPlaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.CabAreaService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import com.pkusoft.agxt.service.CabPlaceService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷柜场所信息表 相关操作
 */
@Api(value="案卷柜场所信息表",tags={"案卷柜场所信息表 相关操作"})
@Controller
public class CabPlaceController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabPlaceController.class);

    @Autowired
    private CabPlaceService cabPlaceService ;

    @Autowired
    private CabAreaService cabAreaService;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷柜场所信息表
    * @param cabPlaceParam
    * @return
    */
    @ApiOperation(value="查询案卷柜场所信息表", notes="查询案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CabPlace>> cabPlaceList(HttpServletRequest request, @RequestBody CabPlaceParam cabPlaceParam){
        ResponseDto<List<CabPlace>> dto = new ResponseDto<List<CabPlace>>();
        try {
            SysUser sysUser = sysUserService.getCurrentUser(request);
            List<CabPlace> list = cabPlaceService.getCabPlaceList(cabPlaceParam, sysUser);
            int count = cabPlaceService.getCabPlaceCount(cabPlaceParam,sysUser);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷柜场所信息表成功");
            return dto;
        } catch (Exception e) {
            log.error("查询案卷柜场所信息表数据出错", e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询案卷柜场所信息表数据出错");
        }
    }

    /**
    * 新增/修改案卷柜场所信息表
    * @param cabPlace
    * @return
    */
    @ApiOperation(value="新增/修改案卷柜场所信息表", notes="新增/修改案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceSaveOrUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceSaveOrUpdate(@RequestBody CabPlace cabPlace, HttpServletRequest request){
        try {
            if (cabPlace == null) {
                return new ResponseData(ResponseData.STATUS_CODE_BIZ, "参数不能为空");
            }
            ResponseData responseData = new ResponseData();
            SysUser sysUser = sysUserService.getCurrentUser(request);
            if(!StringUtils.hasText(cabPlace.getId())){
                // 新增
                cabPlaceService.cabPlaceSave(cabPlace,sysUser);
                responseData.setStatusMsg("新增案卷柜场所信息成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }else{	//修改
                int num = cabPlaceService.cabPlaceUpdate(cabPlace,sysUser);
                if (num > 0) {
                    cabAreaService.updateJobCabAreaByPlaceId(cabPlace);
                }
                responseData.setStatusMsg("修改案卷柜场所信息成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }
            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"新增/修改案卷柜场所出错!");
        }
    }

    /**
    * 查看案卷柜场所信息表
    * @param map
    * @return
    */
    @ApiOperation(value="查看案卷柜场所信息表", notes="查看案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<CabPlace> cabPlaceDetails(@RequestBody(required = false) Map<String, String> map){
        String id = map.get("id");
        if (!StringUtils.hasText(id)) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数不能为空");
        }
        try {
            CabPlace cabPlace = cabPlaceService.getCabPlace(id);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", cabPlace);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查看案卷柜场所信息出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "查看案卷柜场所信息出错：" + e.getMessage());
        }
    }


	/**
    * 删除案卷柜场所信息表
    * @param cabPlaceParam
    * @return
    */
    @ApiOperation(value="删除案卷柜场所信息表", notes="删除案卷柜场所信息表")
    @RequestMapping(value = "/cabPlace/cabPlaceDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabPlaceDelete(@RequestBody(required = false) CabPlaceParam cabPlaceParam){
        if(cabPlaceParam.getIds() != null){
            int num = cabPlaceService.cabPlaceDelete(cabPlaceParam.getIds());
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
