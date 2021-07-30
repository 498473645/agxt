package com.pkusoft.ygjw.controller;


import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
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
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.constants.BizErrorCode;
import pkubatis.toolkit.BizException;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author
 * Dfs related operations
 */
@Api(value="",tags={"阳光警务相关业务"})
@Controller
public class DfsController {

    /**Log handle */
    private final static Logger log = LoggerFactory.getLogger(DfsController.class);

    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private RestTemplate restTemplate;

	/**
    * 下载dfs文件
    * @return
    */
    @ApiOperation(value="下载dfs文件", notes="下载dfs文件", httpMethod="POST")
    @RequestMapping(value = "/dfsInterface/getDfsFileByFilepath", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void getDfsFileByFilepath(@RequestBody Map map, HttpServletRequest request, HttpServletResponse response){
        try {
            String filepath = (String) map.get("filepath");
            if(StringUtils.hasText(filepath)) {
                String reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
                if (!StringUtils.hasText(reqUrl)){
                    log.info("下载地址为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "HDFS地址是空的");
                }
//                Map mapValue = new HashMap();
//                HttpEntity request1 = new HttpEntity(mapValue);
                byte[] content = restTemplate.postForObject(reqUrl+"/getDatum?filePath="+filepath,null, byte[].class);
                if (null == content) {
                    log.info("下载文件，文件内容为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "Downloading files，file is null.");
                }
                OutputStream out = null;
                try {
                    String newName = URLEncoder.encode(filepath, "UTF-8").replaceAll("\\+", "%20").replaceAll("%28", "\\(").replaceAll("%29", "\\)").replaceAll("%3B", ";").replaceAll("%40", "@").replaceAll("%23", "\\#").replaceAll("%26", "\\&").replaceAll("%2C", "\\,");
                    response.reset();
                    response.setContentType("application/octet-stream; charset=utf-8");
                    response.setHeader("Content-Disposition", "attachment; filename=" + newName);
                    out = response.getOutputStream();
                    out.write(content);
                    out.flush();
                } catch (IOException e) {
                    log.info("Download dfs file，IOException ：" + e.getMessage(), e);
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "Downloading dfs files unsuccessfully，IOException ：" + e.getMessage());
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            log.info("获取文件关闭IO流异常，IOException ：" + e.getMessage(), e);
                            throw new BizException(BizErrorCode.ERR_MESSAGE, "获取文件关闭IO流异常，IOException ：" + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Download dfs file error:", e);
        }
    }


    /**
     * 下载dfs文件
     * @return
     */
    @ApiOperation(value="下载dfs文件", notes="下载dfs文件")
    @RequestMapping(value = "/dfsInterface/getDfsFileByFilepathNew", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void getDfsFileByFilepathNew(String filePath, HttpServletRequest request, HttpServletResponse response){
        try {
            if(StringUtils.hasText(filePath)) {
                String reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
                if (!StringUtils.hasText(reqUrl)){
                    log.info("下载地址为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "HDFS地址是空的");
                }
//                Map mapValue = new HashMap();
//                HttpEntity request1 = new HttpEntity(mapValue);
                byte[] content = restTemplate.postForObject(reqUrl+"/getDatum?filePath="+filePath,null, byte[].class);
                if (null == content) {
                    log.info("下载文件，文件内容为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "Downloading files，file is null.");
                }
                OutputStream out = null;
                try {
                    String newName = URLEncoder.encode(filePath, "UTF-8").replaceAll("\\+", "%20").replaceAll("%28", "\\(").replaceAll("%29", "\\)").replaceAll("%3B", ";").replaceAll("%40", "@").replaceAll("%23", "\\#").replaceAll("%26", "\\&").replaceAll("%2C", "\\,");
                    response.reset();
                    response.setContentType("application/octet-stream; charset=utf-8");
                    response.setHeader("Content-Disposition", "attachment; filename=" + newName);
                    out = response.getOutputStream();
                    out.write(content);
                    out.flush();
                } catch (IOException e) {
                    log.info("Download dfs file，IOException ：" + e.getMessage(), e);
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "Downloading dfs files unsuccessfully，IOException ：" + e.getMessage());
                } finally {
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            log.info("获取文件关闭IO流异常，IOException ：" + e.getMessage(), e);
                            throw new BizException(BizErrorCode.ERR_MESSAGE, "获取文件关闭IO流异常，IOException ：" + e.getMessage());
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Download dfs file error:", e);
        }
    }

    /**
     * 查看图片
     * @return
     */
    @ApiOperation(value="查看图片", notes="查看图片", httpMethod="POST")
    @RequestMapping(value = "/dfsInterface/getDfsFileByFilepathBase64", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> getDfsFileByFilepathBase64(@RequestBody Map map, HttpServletRequest request, HttpServletResponse response){
        try {
            String base64 ="";
            String filepath = (String) map.get("filepath");
            if(StringUtils.hasText(filepath)) {
                String reqUrl = userCenterProxyHelper.getPara("HadoopUrlNew");
                if (!StringUtils.hasText(reqUrl)){
                    log.info("下载地址为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "HDFS地址是空的");
                }
//                Map mapValue = new HashMap();
//                HttpEntity request1 = new HttpEntity(mapValue);
                byte[] content = restTemplate.postForObject(reqUrl+"/getDatum?filePath="+filepath,null, byte[].class);
                if (null == content) {
                    log.info("下载文件，文件内容为空");
                    throw new BizException(BizErrorCode.ERR_MESSAGE, "Downloading files，file is null.");
                }
                BASE64Encoder encode = new BASE64Encoder();
                base64 = encode.encode(content);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",base64);
        } catch (Exception e) {
            log.error("Download dfs file error:", e);
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看图片错误:"+e.getMessage());
        }
    }

}
