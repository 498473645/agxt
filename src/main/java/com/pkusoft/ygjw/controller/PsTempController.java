package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.ygjw.model.PsTemp;
import com.pkusoft.ygjw.req.PsTempReqParam;
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

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 
 *  相关操作
 */
@Api(value="",tags={"阳光警务相关业务"})
@Controller
public class PsTempController  {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(PsTempController.class);

    @Autowired
    private PsTempService psTempService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询材料模板表数据
    * @param psTempReqParam
    * @return
    */
    @ApiOperation(value="查询材料模板表数据", notes="查询材料模板表数据", httpMethod="POST")
    @RequestMapping(value = "/psTemp/psTempList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<PsTemp>> psTempList(HttpServletRequest request, @RequestBody PsTempReqParam psTempReqParam){
        ResponseDto<List<PsTemp>> dto = new ResponseDto<List<PsTemp>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<PsTemp> list = psTempService.getPsTempList(psTempReqParam,user);
            int count = psTempService.getPsTempCount(psTempReqParam,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询材料模板表数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询材料模板表数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询材料模板表数据错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改材料模板表数据
     * @return
     */
    @ApiOperation(value = "新增或修改材料模板表数据", notes = "新增或修改材料模板表数据", httpMethod = "POST")
    @RequestMapping("/psTemp/psTempSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> psTempSaveOrUpdate(@RequestBody PsTemp psTemp, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(psTemp.getId())) {
                //添加材料模板表数据
                num = psTempService.psTempSave(psTemp, user);
            }else{
                //修改材料模板表数据
                num = psTempService.psTempUpdate(psTemp, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改材料模板表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改材料模板表数据错误"+e.getMessage());
        }
    }
    
    /**
    * 查看材料模板表数据
    * @param map
    * @return
    */
    @ApiOperation(value="查看材料模板表数据", notes="查看材料模板表数据", httpMethod="POST")
    @RequestMapping(value = "/psTemp/psTempDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<PsTemp> psTempDetails(@RequestBody Map map){
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            PsTemp psTemp = psTempService.getPsTemp(id);
            if (null == psTemp.getId()) {
                return new ResponseData<PsTemp>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<PsTemp>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",psTemp);
        }catch (Exception e){
            logger.error("查看材料模板表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看材料模板表数据详情错误:"+e.getMessage());
        }
    }


	/**
    * 删除材料模板表数据
    * @param map
    * @return
    */
    @ApiOperation(value="删除材料模板表数据", notes="删除材料模板表数据", httpMethod="POST")
    @RequestMapping(value = "/psTemp/psTempDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> psTempDelete(@RequestBody Map map){
        // 检查参数
        String id = (String) map.get("id");
        if (!StringUtils.hasText(id)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = psTempService.psTempDelete(id);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除材料模板表数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除材料模板表数据错误:"+e.getMessage());
        }
    }

    @ApiOperation(value = "上传材料模板文件", notes = "上传材料模板文件", httpMethod = "POST")
    @RequestMapping("/psTemp/savePsTempFile")
    @ResponseBody
    public ResponseData<Map<String, String>> spFilesSave(@RequestBody Map map, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> result = new HashMap<>();
            String contentBase64 = String.valueOf(map.get("contentBase64"));
            if(org.apache.commons.lang.StringUtils.isNotBlank(contentBase64)){
                String savePsTempFile = psTempService.savePsTempFile(contentBase64);
                if("exception".equals(savePsTempFile)||"error".equals(savePsTempFile)){
                    return new ResponseData(ResponseData.STATUS_CODE_OTHER, "上传材料模板文件失败");
                }
                result.put("data",savePsTempFile);
            }
            return new ResponseData<Map<String, String>>(ResponseData.STATUS_CODE_SUCCESS,"上传成功",result);
        }catch (Exception e) {
            logger.error("上传材料模板文件失败",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "上传材料模板文件失败"+e.getMessage());
        }
    }


    @ApiOperation(value = "获取最新序号以及材料模板编号", notes = "获取最新序号以及材料模板编号", httpMethod = "POST")
    @RequestMapping("/psTemp/getModelNm")
    @ResponseBody
    public ResponseData<Map<String, Object>> getModelNm(HttpServletRequest request){
        try {
            Map<String, Object> modelNm = psTempService.getModelNm();
            return new ResponseData<Map<String, Object>>(ResponseData.STATUS_CODE_SUCCESS,"获取成功",modelNm);
        }catch (Exception e) {
            logger.error("获取最新序号以及材料模板编号失败",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "获取最新序号以及材料模板编号失败"+e.getMessage());
        }
    }

}
