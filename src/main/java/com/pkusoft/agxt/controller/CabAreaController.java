package com.pkusoft.agxt.controller;


import java.util.List;
import java.util.Map;


import com.pkusoft.agxt.model.CabArea;
import com.pkusoft.agxt.model.CabSpace;
import com.pkusoft.agxt.model.FileStore;
import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.CabAreaParam;
import com.pkusoft.agxt.req.CabSpaceParam;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.CabSpaceService;
import com.pkusoft.agxt.service.FileStoreService;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;



import com.pkusoft.agxt.service.CabAreaService;



import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * 案卷柜区域信息表 相关操作
 */
@Api(value="案卷柜区域信息表",tags={"案卷柜区域信息表 相关操作"})
@Controller
public class CabAreaController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(CabAreaController.class);

    @Autowired
    private CabAreaService cabAreaService;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private FileStoreService fileStoreService;

    @Autowired
    private CabSpaceService cabSpaceService;

    /**
    * 查询案卷柜区域信息表
    * @param cabAreaParam
    * @return
    */
    @ApiOperation(value="查询案卷柜区域信息表", notes="查询案卷柜区域信息表")
    @RequestMapping(value = "/cabArea/cabAreaList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<CabAreaParam>> cabAreaList(HttpServletRequest request, @RequestBody CabAreaParam cabAreaParam){
        ResponseDto<List<CabAreaParam>> dto = new ResponseDto<List<CabAreaParam>>();
        try{
            SysUser user = sysUserService.getCurrentUser(request);
            List<CabAreaParam> list = cabAreaService.getCabAreaParamList(cabAreaParam,user);
            for (int i = 0; i < list.size(); i++) {
                SysDept dept = sysDeptService.getSysDept(list.get(i).getOrgCode());
                if(dept!=null){
                    list.get(i).setDeptName(dept.getDeptName());
                }
            }
            int count = cabAreaService.getCabAreaParamCount(cabAreaParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷柜区域信息表成功");
            return dto;
        }catch(Exception e){
            log.error("查询案卷柜区域信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询案卷柜区域信息表错误");
        }
    }

    /**
    * 新增/修改案卷柜区域信息表
    * @param cabArea
    * @return
    */
    @ApiOperation(value="新增/修改案卷柜区域信息表", notes="新增/修改案卷柜区域信息表")
    @RequestMapping(value = "/cabArea/cabAreaSaveOrUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabAreaSave(@RequestBody CabArea cabArea, HttpServletRequest request){
        try {
            if (cabArea == null) {
                return new ResponseData(ResponseData.STATUS_CODE_BIZ, "参数不能为空");
            }
            ResponseData responseData = new ResponseData();
            SysUser sysUser = sysUserService.getCurrentUser(request);
            if (!StringUtils.hasText(cabArea.getId())) {
                // 新增
                cabAreaService.cabAreaSave(cabArea,sysUser);
                responseData.setStatusMsg("新增案卷柜区域信息成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            } else {
                // 修改

                List<FileStore> list = fileStoreService.getJobFileStoreByAreaId(cabArea.getCode());
                if(list.size()>0){
                    return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"操作失败,该区域下的柜子中存在案卷");
                }else {
                    int num = cabAreaService.cabAreaUpdate(cabArea, sysUser);
                    if (num > 0) {
                        //修改下列空间的所属单位
                        cabSpaceService.updateByAreaId(cabArea,sysUser);
                    }
                    responseData.setStatusMsg("修改案卷柜区域信息成功！");
                    responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
                }
            }
            return responseData;
        }catch ( Exception e){
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"新增/修改案卷柜区域信息出错!");
        }
    }

    /**
    * 查看案卷柜区域信息表
    * @param map
    * @return
    */
    @ApiOperation(value="查看案卷柜区域信息表", notes="查看案卷柜区域信息表")
    @RequestMapping(value = "/cabArea/cabAreaDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<CabArea> cabAreaDetails(@RequestBody(required = false) Map<String, String> map){
        String id = map.get("id");
        if (!StringUtils.hasText(id)) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数不能为空");
        }
        try {
            CabArea cabArea = cabAreaService.getCabArea(id);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", cabArea);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查看案卷柜区域信息表出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "查看案卷柜区域信息表出错：" + e.getMessage());
        }
    }


	/**
    * 删除案卷柜区域信息表
    * @param cabAreaParam
    * @return
    */
    @ApiOperation(value="删除案卷柜区域信息表", notes="删除案卷柜区域信息表")
    @RequestMapping(value = "/cabArea/cabAreaDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> cabAreaDelete(@RequestBody(required = false) CabAreaParam cabAreaParam){
        if(cabAreaParam.getIds() != null){

            for (int i=0; i < cabAreaParam.getIds().length; i++) {

                CabSpaceParam cabSpaceParam = new CabSpaceParam();
                cabSpaceParam.setAreaId(cabAreaParam.getIds()[0]);
                List<CabSpace> list = cabSpaceService.getCabSpaceList(cabSpaceParam, null);
                if (list.size() > 0) {
                    return new ResponseData(ResponseData.STATUS_CODE_OTHER, "请先删除区域下面的空间");
                }
            }

            int num = cabAreaService.cabAreaDelete(cabAreaParam.getIds());
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
