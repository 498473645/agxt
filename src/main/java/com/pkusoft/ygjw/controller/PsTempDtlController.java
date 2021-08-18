package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.model.PsTempDtl;
import com.pkusoft.ygjw.req.PsTempDtlReqParam;
import com.pkusoft.ygjw.req.PsTempReqParam;
import com.pkusoft.ygjw.service.PsTempDtlService;
import com.pkusoft.ygjw.service.PsTempService;
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
import pkubatis.common.utils.DicPublicType;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 *  相关操作
 */
@Api(value="",tags={"阳光警务相关业务"})
@Controller
public class PsTempDtlController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsTempDtlController.class);

    @Autowired
    private PsTempDtlService psTempDtlService ;

    @Autowired
    private PsTempService psTempService ;


    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询材料模板明细表
    * @param psTempDtlReqParam
    * @return
    */
    @ApiOperation(value="查询材料模板明细表", notes="查询材料模板明细表", httpMethod="POST")
    @RequestMapping(value = "/psTempDtl/psTempDtlList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTempDtl>> psTempDtlList(HttpServletRequest request, @RequestBody PsTempDtlReqParam psTempDtlReqParam){
        ResponseDto<List<PsTempDtl>> dto = new ResponseDto<List<PsTempDtl>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsTempDtl> list = psTempDtlService.getPsTempDtlList(psTempDtlReqParam,user);
            int count = psTempDtlService.getPsTempDtlCount(psTempDtlReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询材料模板明细表数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询材料模板明细表数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询材料模板明细表数据错误"+e.getMessage());
        }
    }

    /**
     * 查询材料模板明细表
     * @param psTempDtlReqParam
     * @return
     */
    @ApiOperation(value="查询材料模板明细表", notes="查询材料模板明细表", httpMethod="POST")
    @RequestMapping(value = "/psTempDtl/getAllPsTempDtlList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTempDtl>> getAllPsTempDtlList(HttpServletRequest request, @RequestBody PsTempDtlReqParam psTempDtlReqParam){
        ResponseDto<List<PsTempDtl>> dto = new ResponseDto<List<PsTempDtl>>();
        try{
            Map<String, String> user = new HashMap<>();
            List<PsTempDtl> list = psTempDtlService.getAllPsTempDtlList(psTempDtlReqParam,user);
//            int count = psTempDtlService.getPsTempDtlCount(psTempDtlReqParam,user);
            dto.setData(list);
//            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询材料模板明细表数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询材料模板明细表数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询材料模板明细表数据错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改材料模板明细表数据
     * @return
     */
    @ApiOperation(value = "新增或修改材料模板明细表数据", notes = "新增或修改材料模板明细表数据", httpMethod = "POST")
    @RequestMapping("/psTempDtl/psTempDtlSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> psTempDtlSaveOrUpdate(@RequestBody PsTempDtl psTempDtl, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
//            Map<String, String> user = new HashMap<>();
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(psTempDtl.getId())) {
                //添加材料模板明细表数据
                num = psTempDtlService.psTempDtlSave(psTempDtl, user);
            }else{
                //修改材料模板明细表数据
                num = psTempDtlService.psTempDtlUpdate(psTempDtl, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改材料模板明细表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改材料模板明细表数据错误"+e.getMessage());
        }
    }

    /**
    * 查看材料模板明细表
    * @param map
    * @return
    */
    @ApiOperation(value="查看材料模板明细表", notes="查看材料模板明细表", httpMethod="POST")
    @RequestMapping(value = "/psTempDtl/psTempDtlDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsTempDtl> psTempDtlDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsTempDtl psTempDtl = psTempDtlService.getPsTempDtlNew(id);
            if (null == psTempDtl.getId()) {
                return new ResponseData<PsTempDtl>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<PsTempDtl>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psTempDtl);
        }catch (Exception e){
            logger.error("查看材料模板明细表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看材料模板明细表数据详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除材料模板明细表
    * @param map
    * @return
    */
    @ApiOperation(value="删除材料模板明细表", notes="删除材料模板明细表", httpMethod="POST")
    @RequestMapping(value = "/psTempDtl/psTempDtlDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psTempDtlDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psTempDtlService.psTempDtlDelete(id);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除材料模板明细表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除材料模板明细表数据错误:"+e.getMessage());
        }
    }

    /**
     * 通过当前用户权限查询其所属单位及下属单位
     *
     * @param request
     * @return
     */
    @RequestMapping("/psTempDtl/getPsTempList")
    @ResponseBody
    public ResponseDto<List<DicPublicType>> getPsTempList(PsTempReqParam psTempReqParam, HttpServletRequest request) {
        ResponseDto<List<DicPublicType>> dto = new ResponseDto<List<DicPublicType>>();
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);

            List<PsTemp> psTempList = psTempService.getPsTempList(psTempReqParam, user);
            List<DicPublicType> dicPublicTypeList = new ArrayList<>();
            for (PsTemp psTemp:psTempList){
                DicPublicType dicPublicType = new DicPublicType();
                dicPublicType.setItemValue(psTemp.getName());
                dicPublicType.setItemCode(psTemp.getId());
                dicPublicTypeList.add(dicPublicType);
            }
            if(null!= dicPublicTypeList && dicPublicTypeList.size()>0){
                dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
                dto.setStatusMsg("获取单位字典成功");
                dto.setData(dicPublicTypeList);
                return dto;
            }else{
                dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
                dto.setStatusMsg("获取单位字典为空");
                return dto;
            }
        } catch (Exception e) {
            e.printStackTrace();
            dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
            dto.setStatusMsg("获取单位字典失败"+e.getMessage());
            return dto;
        }
    }

}
