package com.pkusoft.jjpt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.pkusoft.jjpt.po.PiFaceMatch;
import com.pkusoft.jjpt.service.HadoopService;
import com.pkusoft.jjpt.service.PiFaceMatchService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.support.commons.springmvc.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
* 业务数据_人脸识别图片信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class PiFaceMatchController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(PiFaceMatchController.class);

    @Autowired
    private PiFaceMatchService piFaceMatchService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HadoopService hadoopService;

    @Value(value = "${dfs.hadoopUrl}")
    private String hadoopUrl;


//    /**
//    * 查询业务数据_人脸识别图片信息表
//    * @param request  txtQuery
//    * @return
//    */
//    @RequestMapping("/piFaceMatch/piFaceMatchList")
//    @ResponseBody
//    public GridResult piFaceMatchList(HttpServletRequest request){
//        try{
//            Map<String, String> map = ControllerUtil.getRequestBody(request);
//
//            List<PiFaceMatch> list = piFaceMatchService.getPiFaceMatchList(map);
//            int count = piFaceMatchService.getPiFaceMatchCount(map);
//            return new GridResult(true, list, count);
//        }catch(Exception e){
//            logger.error("查询业务数据_人脸识别图片信息表错误",e);
//            e.printStackTrace();
//            throw new RuntimeException("系统异常 :"+e.getMessage());
//        }
//    }

    /**
     * 进行人像比对
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "进行人像比对", notes = "进行人像比对", httpMethod = "POST")
    @RequestMapping("/piFaceMatch/doFacecheck")
    @ResponseBody
    public ResponseData<Map> doFacecheck(HttpServletRequest request, @RequestBody Map map){
        try{
            String base64str = (String) map.get("base64str");
            if (!StringUtils.hasText(base64str)){
                return new ResponseData<>(ResponseData.STATUS_CODE_PARAM,"照片不能为空");
            }

            Map<String, String> user = userCenterProxyHelper.getUser(request);
            String faceMatchUrl = userCenterProxyHelper.getPara("FaceMatch_URL");
            String errorReason = "";
            if (StringUtils.hasText(faceMatchUrl)) {
                Map<String,String> data = new HashMap<>();

                HttpHeaders headers=new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity entity = new HttpEntity(base64str, headers);

                String rxbdReqUrl = faceMatchUrl + "/requestRxbdData";
                String response = "{\"statusCode\":\"00\",\"statusMsg\":null,\"data\":[{\"annotation\":null,\"csrq\":\"1991\",\"faceImageId\":\"9223372036894293767\",\"faceImageIdStr\":null,\"faceImageUri\":\"normal://repository-builder/20180710/RNVnE9sA62waqe2fW0rXVA==@1\",\"faceRect\":{\"w\":\"349\",\"y\":\"57\",\"h\":\"349\",\"x\":\"7\"},\"xb\":\"男\",\"isWritable\":\"false\",\"xm\":\"王润燊\",\"mz\":\"0\",\"permissionMap\":null,\"gmsfhm\":\"420381199111152300\",\"pictureUri\":\"normal://repository-builder/20180710/0Eyw5BpFAhoCilGypNbcWg==@2\",\"repositoryId\":\"27\",\"similarity\":\"98.07433090846509\",\"timestamp\":\"1531223038\",\"retrievalQueryId\":null,\"rtn\":null},{\"annotation\":null,\"csrq\":\"0\",\"faceImageId\":\"9223372036910461532\",\"faceImageIdStr\":null,\"faceImageUri\":\"normal://repository-builder/20200714/xG7IfGrig-SFnXtMNiErcg==@6\",\"faceRect\":{\"w\":\"348\",\"y\":\"73\",\"h\":\"348\",\"x\":\"3\"},\"xb\":\"男\",\"isWritable\":\"false\",\"xm\":\"张瀚\",\"mz\":\"0\",\"permissionMap\":null,\"gmsfhm\":\"421182199805070357\",\"pictureUri\":\"normal://repository-builder/20200714/R9Wi9cEoI6BS4pwa5sfR-A==@5\",\"repositoryId\":\"23\",\"similarity\":\"89.95821866754845\",\"timestamp\":\"1594711829\",\"retrievalQueryId\":null,\"rtn\":null},{\"annotation\":null,\"csrq\":\"1990\",\"faceImageId\":\"9223372036864245636\",\"faceImageIdStr\":null,\"faceImageUri\":\"normal://repository-builder/20180706/nXKooKUwyIqrv3goyMzaFw==@2\",\"faceRect\":{\"w\":\"364\",\"y\":\"38\",\"h\":\"364\",\"x\":\"2\"},\"xb\":\"男\",\"isWritable\":\"false\",\"xm\":\"严浩\",\"mz\":\"0\",\"permissionMap\":null,\"gmsfhm\":\"421003199002040073\",\"pictureUri\":\"normal://repository-builder/20180706/uHuIN5CsCClt1iCGLz3f-g==@4\",\"repositoryId\":\"20\",\"similarity\":\"87.21161317433746\",\"timestamp\":\"1530880942\",\"retrievalQueryId\":null,\"rtn\":null},{\"annotation\":null,\"csrq\":\"1996\",\"faceImageId\":\"9223372036904545710\",\"faceImageIdStr\":null,\"faceImageUri\":\"normal://repository-builder/20180711/dgLIYDrGRmoJlFBg2Kbuyg==@2\",\"faceRect\":{\"w\":\"387\",\"y\":\"66\",\"h\":\"387\",\"x\":\"-15\"},\"xb\":\"男\",\"isWritable\":\"false\",\"xm\":\"马列\",\"mz\":\"0\",\"permissionMap\":null,\"gmsfhm\":\"42022219961204285X\",\"pictureUri\":\"normal://repository-builder/20180711/vm3qaBWe-gLv9n3Ajx-KBg==@4\",\"repositoryId\":\"32\",\"similarity\":\"86.50584509613464\",\"timestamp\":\"1531298115\",\"retrievalQueryId\":null,\"rtn\":null},{\"annotation\":null,\"csrq\":\"1991\",\"faceImageId\":\"9223372036874826176\",\"faceImageIdStr\":null,\"faceImageUri\":\"normal://repository-builder/20180709/Y2ZneUzzWMYSZaJ2kv-S7Q==@5\",\"faceRect\":{\"w\":\"340\",\"y\":\"85\",\"h\":\"340\",\"x\":\"9\"},\"xb\":\"男\",\"isWritable\":\"false\",\"xm\":\"官成飞\",\"mz\":\"0\",\"permissionMap\":null,\"gmsfhm\":\"420528199108260019\",\"pictureUri\":\"normal://repository-builder/20180709/pfFKo-eKXScL5t0D5jiVxg==@2\",\"repositoryId\":\"21\",\"similarity\":\"85.40430955973024\",\"timestamp\":\"1531121765\",\"retrievalQueryId\":null,\"rtn\":null}]}";
//                String response = restTemplate.postForObject(rxbdReqUrl,entity, String.class);
                logger.info("doFacecheck-response:"+response);
                if (StringUtils.hasText(response)){
                    JSONObject jsonObject = JSON.parseObject(response);
                    String statusCode = (String) jsonObject.get("statusCode");
                    if ("00".equals(statusCode)){
                        JSONArray array =  (JSONArray) jsonObject.get("data");
                        JSONObject people = (JSONObject) array.get(0);
                        String idNo =  (String) people.get("gmsfhm");
                        String name =  (String) people.get("xm");
                        data.put("no",idNo);
                        data.put("name",name);
//                        String xb =  (String) people.get("xb");
//                        if ("男".equals(xb)){
//                            data.put("xb","1");
//                        }else if ("女".equals(xb)){
//                            data.put("xb","2");
//                        }else {
//                            data.put("xb","0");
//                        }
                        String ret = hadoopService.hadoopUpload(base64str);
                        if (StringUtils.hasText(ret) && !"error".equals(ret) && !"exception".equals(ret)){
                            if (StringUtils.hasText(hadoopUrl)){
                                data.put("distUrl",hadoopUrl + "/downloadFile?filePath=");
                            }else {
                                String hadoopUrlNew = userCenterProxyHelper.getPara("HadoopUrlNew");
                                data.put("distUrl",hadoopUrlNew + "/downloadFile?filePath=");
                            }
                            data.put("picFace",ret);

                            PiFaceMatch piFaceMatch = new PiFaceMatch();
                            piFaceMatch.setObjid(UUID.randomUUID().toString());
                            piFaceMatch.setPicFace(ret);
                            String threshold =  (String) people.get("similarity");
                            if (StringUtils.hasText(threshold)){
                                if (threshold.length()>5){
                                    piFaceMatch.setThreshold(threshold.substring(0,5));
                                }else {
                                    piFaceMatch.setThreshold(threshold);
                                }
                            }
                            Date cur = new Date();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            piFaceMatch.setAddTime(simpleDateFormat.format(cur));
                            piFaceMatch.setExamine(0);
                            piFaceMatch.setRowStatus("3");
                            piFaceMatch.setCreateId(user.get("userId"));
                            piFaceMatch.setCreateName(user.get("userName"));
                            piFaceMatch.setCreateTime(cur);
                            piFaceMatch.setModerId(user.get("userId"));
                            piFaceMatch.setModerName(user.get("userName"));
                            piFaceMatch.setModerTime(cur);
                            piFaceMatch.setOrgCode(user.get("deptId"));
                            piFaceMatch.setOrgName(user.get("deptName"));
                        }
                        return new ResponseData(ResponseData.STATUS_CODE_SUCCESS, "比对成功",data);
                    }else {
                        errorReason = ":人像比对失败，"+response;
                    }
                }else {
                    errorReason = ":人像比对接口返回值为空";
                }
            }else {
                errorReason = ":人像比对接口地址为空";
            }
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"比对失败"+errorReason);
        }catch(Exception e){
            logger.error("进行人像比对错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER,"比对错误:"+e.getMessage());
        }
    }

    /**
     * 查询业务数据_人脸识别图片信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询业务数据_人脸识别图片信息表", notes = "查询业务数据_人脸识别图片信息表", httpMethod = "POST")
    @RequestMapping("/piFaceMatch/getPiFaceMatchList")
    @ResponseBody
    public ResponseData<List<PiFaceMatch>> getPiFaceMatchList(HttpServletRequest request){
        try{
            int limit = 8;
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<PiFaceMatch> list = piFaceMatchService.getPiFaceMatchList(user,limit);
            String picUrl = "";
            if (StringUtils.hasText(hadoopUrl)){
                picUrl = hadoopUrl + "/downloadFile?filePath=";
            }else {
                String hadoop = userCenterProxyHelper.getPara("HadoopUrlNew");
                if (StringUtils.hasText(hadoop)) {
                    picUrl = hadoop + "/downloadFile?filePath=";
                }
            }
            return new ResponseData(ResponseData.STATUS_CODE_SUCCESS, picUrl,list);
        }catch(Exception e){
            logger.error("查询业务数据_人脸识别图片信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "系统异常 :"+e.getMessage());
        }
    }

//    /**
//    * 新增或修改业务数据_人脸识别图片信息表
//    * @param piFaceMatch
//    * @param objid
//    * @param request
//    * @return
//    */
//    @RequestMapping("/piFaceMatch/piFaceMatchSaveOrUpdate")
//    @ResponseBody
//    public JsonResult piFaceMatchSaveOrUpdate(PiFaceMatch piFaceMatch, String objid, HttpServletRequest request){
//        try {
//            //获取当前操作用户信息
//            Map<String, String> user = userCenterProxyHelper.getUser(request);
//            if(objid == null){
//                //添加业务数据_人脸识别图片信息表
//                piFaceMatchService.piFaceMatchSave(piFaceMatch, user);
//            }else{
//                //修改业务数据_人脸识别图片信息表
//                piFaceMatchService.piFaceMatchUpdate(piFaceMatch, user);
//            }
//
//            return new JsonResult(true);
//        }catch (Exception e) {
//            logger.error("增加/修改业务数据_人脸识别图片信息表错误",e);
//            return new JsonResult(false, e.getMessage());
//        }
//    }
//
//    /**
//    * 查看业务数据_人脸识别图片信息表详情
//    * @param objid
//    * @return
//    */
//    @RequestMapping("/piFaceMatch/piFaceMatchModel")
//    @ResponseBody
//    public JsonResult PiFaceMatchModel(String objid) {
//        PiFaceMatch piFaceMatch = piFaceMatchService.getPiFaceMatch(objid);
//        return new JsonResult(true,piFaceMatch);
//    }
//
//    /**
//    * 删除业务数据_人脸识别图片信息表
//    * @param objid
//    * @return
//    */
//    @RequestMapping("/piFaceMatch/piFaceMatchDelete")
//    @ResponseBody
//    public JsonResult piFaceMatchDelete(String[] objid) {
//        if(objid != null){
//            int num = piFaceMatchService.piFaceMatchDelete(objid);
//            if(num>0){
//                return new JsonResult(true);
//            }else{
//                return new JsonResult(true);
//            }
//        }else{
//            logger.error("删除业务数据_人脸识别图片信息表错误");
//            return new JsonResult(false, "请求参数不允许为空");
//        }
//    }
}
