package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpFiles;
import com.pkusoft.jjpt.req.SpFilesReqParam;
import com.pkusoft.jjpt.service.SpFilesService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


/**
* 业务数据_材料信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpFilesController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpFilesController.class);

    @Autowired
    private SpFilesService spFilesService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${dfs.hadoopUrl}")
    private String hadoopUrl;

    /**
     * 获取hadoop地址前缀
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "获取hadoop地址前缀", notes = "获取hadoop地址前缀", httpMethod = "POST")
    @RequestMapping("/spFiles/getHadoopPrefix")
    @ResponseBody
    public ResponseData<String> getHadoopPrefix(HttpServletRequest request){
        ResponseDto<String> dto = new ResponseDto<String>();
        try{
            String distUrl = "";
            if (StringUtils.hasText(hadoopUrl)){
                distUrl = hadoopUrl;
            }else {
                distUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
            }
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setData(distUrl+"/download?path=");
            dto.setStatusMsg("获取hadoop地址前缀成功");
            return dto;
        }catch(Exception e){
            logger.error("获取hadoop地址前缀错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"获取hadoop地址前缀错误："+e.getMessage());
        }
    }

    /**
     * 查询接警平台材料信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台材料信息表", notes = "查询接警平台材料信息表", httpMethod = "POST")
    @RequestMapping("/spFiles/spFilesList")
    @ResponseBody
    public ResponseData<List<SpFiles>> spFilesList(HttpServletRequest request, @RequestBody SpFilesReqParam spFiles){
        ResponseDto<List<SpFiles>> dto = new ResponseDto<List<SpFiles>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpFiles> list = spFilesService.getSpFilesList(spFiles,user);
            int count = spFilesService.getSpFilesCount(spFiles,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台材料信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台材料信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台材料信息表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台材料信息表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台材料信息表", notes = "新增或修改接警平台材料信息表", httpMethod = "POST")
    @RequestMapping("/spFiles/spFilesSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spFilesSaveOrUpdate(@RequestBody SpFilesReqParam spFilesReqParam, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            SpFiles spFiles = new SpFiles();
            BeanUtils.copyProperties(spFilesReqParam,spFiles);
            if(!StringUtils.hasText(spFilesReqParam.getObjid())) {
                //添加接警平台材料信息表
                //将文件内容暂时储存在PapersPhoto中,上传后返回的地址会替换PapersPhoto参数
                spFiles.setPapersPhoto(spFilesReqParam.getContentBase64());
                num = spFilesService.spFilesSave(spFiles, user);
            }else{
                //修改接警平台材料信息表
                num = spFilesService.spFilesUpdate(spFiles, user);
            }
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }else if (num==-1){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"材料上传失败");
            }else if (num==-2){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能找到材料关联的案件信息");
            }else if (num==-3){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能找到材料关联的笔录信息");
            }else if (num==-4){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"文件类型不能为空");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台材料信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台材料信息表错误"+e.getMessage());
        }
    }

    /**
     * 新增材料信息表(阳光警务服务专用)
     * @return
     */
    @ApiOperation(value = "新增材料信息表(阳光警务服务专用)", notes = "新增材料信息表(阳光警务服务专用)", httpMethod = "POST")
    @RequestMapping("/spFiles/spFilesSaveYGJW")
    @ResponseBody
    public ResponseData<String> spFilesSaveYGJW(@RequestBody SpFilesReqParam spFilesReqParam, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            SpFiles spFiles = new SpFiles();
            BeanUtils.copyProperties(spFilesReqParam,spFiles);
                //添加接警平台材料信息表
                num = spFilesService.spFilesSaveYGJW(spFiles);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }else if (num==-1){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"材料上传失败");
            }else if (num==-2){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能找到材料关联的案件信息");
            }else if (num==-3){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"未能找到材料关联的笔录信息");
            }else if (num==-4){
                return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"文件类型不能为空");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e) {
            logger.error("增加/修改接警平台材料信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台材料信息表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台材料信息表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台材料信息表详情", notes = "查看接警平台材料信息表详情", httpMethod = "POST")
    @RequestMapping("/spFiles/spFilesModel")
    @ResponseBody
    public ResponseData<SpFiles> spFilesModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpFiles spFiles = spFilesService.getSpFiles(objid);
            return new ResponseData<SpFiles>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spFiles);
        }catch (Exception e){
            logger.error("查看接警平台材料信息表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台材料信息表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台材料信息表
     * @return
     */
    @ApiOperation(value = "删除接警平台材料信息表", notes = "删除接警平台材料信息表", httpMethod = "POST")
    @RequestMapping("/spFiles/spFilesDelete")
    @ResponseBody
    public ResponseData<String> spFilesDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spFilesService.spFilesDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台材料信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台材料信息表错误:"+e.getMessage());
        }
    }

    /**
     * 根据aobjid和材料类型获取材料列表
     * @return
     */
    @ApiOperation(value = "根据aobjid和材料类型获取材料列表", notes = "根据aobjid和材料类型获取材料列表", httpMethod = "POST")
    @RequestMapping("/spFiles/getFileListByAobjidAndObjtype")
    @ResponseBody
    public ResponseData<List<SpFiles>> getFileListByAobjidAndObjtype(@RequestBody SpFiles spFiles, HttpServletRequest request) {
        if (!StringUtils.hasText(spFiles.getAObjid())){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "接警id参数不能为空");
        }
        List<SpFiles> spFilesList = spFilesService.getFileListByAobjidAndObjtype(spFiles);
        if (!spFilesList.isEmpty()){
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spFilesList);
        }
        return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
    }

    /**
     * 根据aobjid和材料类型获取材料
     * @return
     */
    @ApiOperation(value = "根据aobjid和材料类型获取材料", notes = "根据aobjid和材料类型获取材料", httpMethod = "POST")
    @RequestMapping("/spFiles/getFileByAobjidAndObjtype")
    @ResponseBody
    public ResponseData<List<SpFiles>> getFileByAobjidAndObjtype(@RequestBody SpFiles spFiles) {
        if (StringUtils.hasText(spFiles.getAObjid())){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        List<SpFiles> spFilesList = spFilesService.getFileListByAobjidAndObjtype(spFiles);
        if (!spFilesList.isEmpty()){
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spFilesList);
        }
        return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
    }

    /**
     * 材料下载
     * @param objid
     * @return
     */
    @RequestMapping("/spFiles/downloadSpFilesByFileobjid")
    @ResponseBody
    public void downloadSpFiles(@RequestParam String objid, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(StringUtils.hasText(objid)) {
                String reqUrl = "";

                SpFiles spFiles = spFilesService.getSpFiles(objid);
//                byte[] content = spFiles.getContent();
//                if (content == null) {
//                    return;
//                }

                if (StringUtils.hasText(hadoopUrl)){
                    reqUrl = hadoopUrl;
                }else {
                    reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
                }
                if (!StringUtils.hasText(reqUrl)){
                    return;
                }
                Map mapValue = new HashMap();
                HttpEntity request1 = new HttpEntity(mapValue);
                byte[] content = restTemplate.postForObject(reqUrl+"/download?path="+spFiles.getPapersPhoto(),request1, byte[].class);
                String fileName = spFiles.getObjname() + "." + spFiles.getObjtype();
                response.reset();
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
                response.setContentType("application/octet-stream");
                OutputStream os = response.getOutputStream();
                os.write(content);
                os.close();
            }
        } catch (Exception e) {
            logger.error("笔录文件下载出错", e);
        }
    }

    /**
     * 材料下载
     * @return
     */
    @RequestMapping("/spFiles/downloadFilesByFilepath")
    @ResponseBody
    public void downloadFilesByFilepath(@RequestParam String filepath, @RequestParam String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            if(StringUtils.hasText(filepath)) {
                String reqUrl = "";

                if (StringUtils.hasText(hadoopUrl)){
                    reqUrl = hadoopUrl;
                }else {
                    reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
                }
                if (!StringUtils.hasText(reqUrl)){
                    return;
                }
                Map mapValue = new HashMap();
                HttpEntity request1 = new HttpEntity(mapValue);
                byte[] content = restTemplate.postForObject(reqUrl+"/download?path="+filepath,request1, byte[].class);
                if (!StringUtils.hasText(fileName)){
                    fileName = UUID.randomUUID().toString() + "-" + new Date().getTime();
                }
                response.reset();
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "iso8859-1"));
                response.setContentType("application/octet-stream");
                OutputStream os = response.getOutputStream();
                os.write(content);
                os.close();
            }
        } catch (Exception e) {
            logger.error("笔录文件下载出错", e);
        }
    }

    /**
     * 根据TransId和材料类型获取材料列表
     * @return
     */
    @ApiOperation(value = "根据TransId和材料类型获取材料列表", notes = "根据TransId和材料类型获取材料列表", httpMethod = "POST")
    @RequestMapping("/spFiles/getFileListByTransIdAndObjtype")
    @ResponseBody
    public ResponseData<List<SpFiles>> getFileListByTransIdAndObjtype(@RequestBody SpFiles spFiles, HttpServletRequest request) {
        try{
            if (!StringUtils.hasText(spFiles.getTransId())){
                return new ResponseData(ResponseData.STATUS_CODE_PARAM, "接警id参数不能为空");
            }
            List<SpFiles> spFilesList = spFilesService.getFileListByTransIdAndObjtype(spFiles);
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spFilesList);
        }catch (Exception e){
            logger.error("根据TransId和材料类型获取材料列表异常:",e.getMessage());
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }


    }

    /**
     * 返回当前服务器时间
     * @return
     */
    @ApiOperation(value = "返回当前服务器时间", notes = "返回当前服务器时间", httpMethod = "POST")
    @RequestMapping("/spFiles/getNowTime")
    @ResponseBody
    public ResponseData<String> getNowTime(HttpServletRequest request) {
        try{

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",simpleDateFormat.format(new Date()));
        }catch (Exception e){
            logger.error("根据TransId和材料类型获取材料列表异常:",e.getMessage());
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }


    }
}
