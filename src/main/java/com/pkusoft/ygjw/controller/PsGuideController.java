package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
import com.pkusoft.ygjw.model.PsGuide;
import com.pkusoft.ygjw.req.PsGuideReqParam;
import com.pkusoft.ygjw.service.PsGuideService;
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
import pkubatis.common.utils.StringUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 
 *  相关操作
 */
@Api(value="",tags={"阳光警务相关业务"})
@Controller
public class PsGuideController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsGuideController.class);

    @Autowired
    private PsGuideService psGuideService ;

    /**
     * 用户中心服务代理
     */
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询
    * @param psGuideReqParam
    * @return
    */
    @ApiOperation(value="查询报案/办事指引表", notes="查询报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsGuide>> psGuideList(HttpServletRequest request, @RequestBody PsGuideReqParam psGuideReqParam){
        ResponseDto<List<PsGuide>> dto = new ResponseDto<List<PsGuide>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsGuide> list = psGuideService.getPsGuideList(psGuideReqParam,user);
            int count = psGuideService.getPsGuideCount(psGuideReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询报案/办事指引表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询报案/办事指引表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询报案/办事指引表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改报案/办事指引表
     * @return
     */
    @ApiOperation(value = "新增或修改报案/办事指引表", notes = "新增或修改报案/办事指引表", httpMethod = "POST")
    @RequestMapping("/psGuide/psGuideSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> psGuideSaveOrUpdate(@RequestBody PsGuide psGuide, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = new HashMap<>();
            if(!StringUtils.hasText(psGuide.getId())) {
                //添加报案/办事指引表
                num = psGuideService.psGuideSave(psGuide, user);
            }else{
                //修改报案/办事指引表
                num = psGuideService.psGuideUpdate(psGuide, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改报案/办事指引表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改报案/办事指引表错误"+e.getMessage());
        }
    }

    /**
    * 新增报案/办事指引表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="新增报案/办事指引表", notes="新增报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideSave", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> psGuideSave(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }
    
    /**
    * 修改报案/办事指引表
    * @param requestBody
    * @return
    */
    @ApiOperation(value="修改报案/办事指引表", notes="修改报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideUpdate", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<Map> psGuideUpdate(@RequestBody(required = false) Map<String, String> requestBody){
        // 检查参数
        if (requestBody == null) {
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            // TODO: 业务逻辑
            Map responseData = null;
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, null, responseData);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            // TODO: 业务日志
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "error：" + e.getMessage());
        }
    }
    
    /**
    * 查看报案/办事指引表
    * @param map
    * @return
    */
    @ApiOperation(value="查看报案/办事指引表", notes="查看报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsGuide> psGuideDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsGuide psGuide = psGuideService.getPsGuide(id);
            if (null == psGuide.getId()) {
                return new ResponseData<PsGuide>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<PsGuide>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psGuide);
        }catch (Exception e){
            logger.error("查看报案/办事指引表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看报案/办事指引表详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除报案/办事指引表
    * @param map
    * @return
    */
    @ApiOperation(value="删除报案/办事指引表", notes="删除报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psGuideDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psGuideService.psGuideDelete(id);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除报案/办事指引表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除报案/办事指引表错误:"+e.getMessage());
        }
    }

    /**
     * 查询报案/办事指引表
     * @param psTempDtlReqParam
     * @return
     */
    @ApiOperation(value="查询报案/办事指引表", notes="查询报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/getPsGuideTypeList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsGuide>> getPsGuideTypeList(HttpServletRequest request, @RequestBody PsGuideReqParam psTempDtlReqParam){
        ResponseDto<List<PsGuide>> dto = new ResponseDto<List<PsGuide>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<PsGuide> list = psGuideService.getPsGuideList(psTempDtlReqParam,user);
            int count = psGuideService.getPsGuideCount(psTempDtlReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询报案/办事指引表数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询报案/办事指引表数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询报案/办事指引表数据错误"+e.getMessage());
        }
    }

    /**
     * 查询报警办事类型集合
     * @param map
     * @return
     */
    @ApiOperation(value="根据type查询报案/办事指引表", notes="根据type查询报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideTypeList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<DicItemVo>> psGuideTypeList(@RequestBody Map map){
        ResponseDto<List<DicItemVo>> dto = new ResponseDto<List<DicItemVo>>();
        try {
            String dicName = String.valueOf(map.get("dicName"));
            if(!StringUtil.isNotEmpty(dicName)){
                dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
                dto.setStatusMsg("参数异常!");
                return dto;
            }
            String[] split = dicName.split(",");
            List<String> dicNames = Arrays.asList(split);
            List<DicItemVo> list= new ArrayList<>();
            for (String dic: dicNames) {
                list.addAll(userCenterProxyHelper.getDic(dic));
            }
            List<DicItemVo> dicItemVos = new ArrayList<>();
            //判断是否需要分页
            if(null == map.get("flag")){
                if(null != list){
                    //判断是否有查询条件
                    Object objType = map.get("objType");
                    if(null != objType){
                        Optional<DicItemVo> first = list.stream().filter(item -> objType.equals(item.getItemCode())).findFirst();
                        if (first.isPresent()) {
                            // 存在
                            list.clear();
                            list.add(first.get());
                        }
                    }
                    //进行分页查询
                    Integer pageSize = Integer.valueOf(null !=map.get("pageSize") ? String.valueOf(map.get("pageSize")) : "10");
                    Integer page = Integer.valueOf(null != map.get("page") ? String.valueOf(map.get("page")) : "1");
                    Integer endIndex = pageSize * page;
                    if(endIndex > list.size()){
                        endIndex = list.size();
                    }
                    dicItemVos = list.subList(pageSize * (page - 1),endIndex);
                    dto.setCount(list.size());
                }
            }else {
                dicItemVos = list;
            }
            dto.setData(dicItemVos);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
            return dto;
        } catch (Exception e) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
            dto.setStatusMsg("请求失败!");
            e.printStackTrace();
            return dto;
        }
    }

    /**
     * 查看报案/办事指引表
     * @param psGuide
     * @return
     */
    @ApiOperation(value="查看报案/办事指引表", notes="查看报案/办事指引表", httpMethod="POST")
    @RequestMapping(value = "/psGuide/psGuideDetailsByType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsGuide> psGuideDetailsByType(@RequestBody PsGuide psGuide){
        if (!StringUtils.hasText(psGuide.getType())){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsGuide psGuides = psGuideService.getPsGuidByType(psGuide);
            return new ResponseData<PsGuide>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psGuides);
        }catch (Exception e){
            logger.error("查看报案/办事指引表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看报案/办事指引表详情错误:"+e.getMessage());
        }
    }

}
