package com.pkusoft.agxt.controller;


import com.pkusoft.agxt.model.FileTemp;
import com.pkusoft.agxt.req.FileTempParam;
import com.pkusoft.agxt.service.FileTempService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 案卷模板信息表 相关操作
 */
@Api(value="案卷模板信息表",tags={"案卷模板信息表 相关操作"})
@Controller
public class FileTempController  {

    /**日志句柄 */
    private final static Logger log = LoggerFactory.getLogger(FileTempController.class);

    @Autowired
    private FileTempService fileTempService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private SysUserService sysUserService;

    /**
    * 查询案卷模板信息表
    * @param fileTempParam
    * @return
    */
    @ApiOperation(value="查询案卷模板信息表", notes="查询案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<FileTemp>> fileTempList(HttpServletRequest request, @RequestBody FileTempParam fileTempParam){
        ResponseDto<List<FileTemp>> dto = new ResponseDto<List<FileTemp>>();
        try{
            SysUser user = sysUserService.getCurrentUser(request);
            List<FileTemp> list = fileTempService.getFileTempList(fileTempParam,user);
            int count = fileTempService.getFileTempCount(fileTempParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷模板信息表成功");
            return dto;
        }catch(Exception e){
            log.error("查询案卷模板信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询案卷模板信息表错误");
        }
    }

    /**
    * 新增/修改案卷模板信息表
    * @param fileTemp
    * @return
    */
    @ApiOperation(value="新增/修改案卷模板信息表", notes="新增/修改案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempSaveOrUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> fileTempSave(@RequestBody FileTemp fileTemp, HttpServletRequest request){
        try {
            if (fileTemp == null) {
                return new ResponseData(ResponseData.STATUS_CODE_BIZ, "参数不能为空");
            }
            ResponseData responseData = new ResponseData();
            SysUser sysUser = sysUserService.getCurrentUser(request);
            if (!StringUtils.hasText(fileTemp.getId())) {
                // 新增
                fileTempService.fileTempSave(fileTemp,sysUser);
                responseData.setStatusMsg("新增案卷模板信息成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }else {
                // 修改
                fileTempService.fileTempUpdate(fileTemp,sysUser);
                responseData.setStatusMsg("修改案卷模板信息成功！");
                responseData.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            }
            return responseData;
        }catch ( Exception e){
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ,"新增/修改案卷模板信息出错!");
        }
    }

    /**
    * 查看案卷模板信息表
    * @param map
    * @return
    */
    @ApiOperation(value="查看案卷模板信息表", notes="查看案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<FileTemp> fileTempDetails(@RequestBody(required = false) Map<String, String> map){
        String id = map.get("id");
        if (!StringUtils.hasText(id)) {
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "参数不能为空");
        }
        try {
            FileTemp fileTemp = fileTempService.getFileTemp(id);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "操作成功", fileTemp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查看案卷模板信息出错", e);
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER, "查看案卷模板信息出错：" + e.getMessage());
        }
    }


	/**
    * 删除案卷模板信息表
    * @param fileTempParam
    * @return
    */
    @ApiOperation(value="删除案卷模板信息表", notes="删除案卷模板信息表")
    @RequestMapping(value = "/fileTemp/fileTempDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData fileTempDelete(@RequestBody FileTempParam fileTempParam){
        if(fileTempParam.getIds() != null){
            int num = fileTempService.fileTempDelete(fileTempParam.getIds());
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

    /**
     * 模板树
     *
     * @param fileTempParam
     * @return
     */
    @RequestMapping(value = "/fileTemp/fileTempTree", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<FileTemp>> jobFileTempTree(HttpServletRequest request, @RequestBody FileTempParam fileTempParam) {
        ResponseDto<List<FileTemp>> dto = new ResponseDto<List<FileTemp>>();
        try{
            SysUser user = sysUserService.getCurrentUser(request);
            List<FileTemp> list = fileTempService.getFileTempTreeList(fileTempParam,user);
            dto.setData(list);
            dto.setCount(list.size());
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询案卷模板树信息表成功");
            return dto;
        }catch(Exception e){
            log.error("查询案卷模板树信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询案卷模板树信息表错误");
        }
    }

    /**
     * 新增模板树节点
     *
     * @param fileTemp
     * @return
     */
    @RequestMapping(value = "/fileTemp/fileTempAdd", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData sysMenuAdd(@RequestBody FileTemp fileTemp,HttpServletRequest request) {
        try {
            SysUser sysUser= sysUserService.getCurrentUser(request);
            fileTemp.setId(fileTemp.getCode());
            fileTempService.insertFileTempTree(fileTemp,sysUser);
            // caseSortService.insertCaseSort(caseSort);
            return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"新增模板树节点成功");
        } catch (Exception e) {
            log.error("新增模板树节点失败", e);
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"新增模板树节点失败");
        }
    }

    /**
     * 新增模板主节点
     */
    @RequestMapping(value = "/fileTemp/fileTempMainAdd", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData sysMenuMainAdd(@RequestBody FileTemp fileTemp,HttpServletRequest request) {
        try {
            SysUser sysUser= sysUserService.getCurrentUser(request);
            fileTempService.insertFileTempTree(fileTemp,sysUser);
            return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"新增模板树主节点成功");
        } catch (Exception e) {
            log.error("新增模板树主节点失败", e);
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"新增模板树主节点失败");
        }
    }

    /**
     * 案卷模板信息删除
     *
     * @param id
     * @return JsonResult
     */
    @RequestMapping(value = "/fileTemp/newFileTempDel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData newFileTempDel(String id) {
        try {
            if (id != null) {
                int num = fileTempService.newJobFileTempDel(id);
                if (num>0) {
                    return new ResponseData(ResponseData.STATUS_CODE_SUCCESS,"模板信息删除成功");
                }
                return new ResponseData(ResponseData.STATUS_CODE_OTHER,"模板信息删除出错");
            } else {
                return new ResponseData(ResponseData.STATUS_CODE_OTHER,"参数不能为空");
            }
        } catch (Exception e) {
            log.error("模板信息删除出错", e);
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"模板信息删除出错");
        }
    }
}
