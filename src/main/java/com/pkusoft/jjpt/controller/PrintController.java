package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.service.SpJjxxService;
import com.pkusoft.pzzx.po.BdHandlingArea;
import com.pkusoft.pzzx.service.BdHandlingAreaService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 业务数据_打印 相关操作
 * Auto-generated
 */
@Controller
public class PrintController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(PrintController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private SpJjxxService spJjxxService;

    @Autowired
    private BdHandlingAreaService bdHandlingAreaService;

    /**
     * 打印文件
     * @param printDocReq
     * @param request
     * @return
     */
    @ApiOperation(value = "打印文件", notes = "打印文件接口", httpMethod = "POST")
    @RequestMapping("/print/printDoc")
    @ResponseBody
    public ResponseData<Map> printDoc(@RequestBody Map printDocReq, HttpServletRequest request){
        try {
            String jjObjid = (String) printDocReq.get("jjdObjid");
            String type = (String) printDocReq.get("type");
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            Map<String, String> data = new HashMap<>();
            SpJjxx spJjxx = spJjxxService.getSpJjxx(jjObjid);
            String buffer ="";
            if("1".equals(type)){// 1表示打印案件回执
                buffer = getAjhz(spJjxx,user);
                data.put("xml","sahz");
            }
//            else if ("2".equals(type)){  // 2表示打印接处警记录
//                buffer = getJcjjl(spJjxx,user);
//                data.put("xml","jcjjl");
//            }
            if (StringUtils.hasText(buffer)){
                data.put("buffer",buffer);
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",data);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败",data);
        }catch (Exception e) {
            logger.error("打印文件错误",e);
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, e.getMessage());
        }
    }

    //打印案件回执
    public String getAjhz(SpJjxx spJjxx, Map<String, String> user){
        try {
            BdHandlingArea bdHandlingArea = bdHandlingAreaService.getBdHandlingAreaByUser(user);
            if (bdHandlingArea==null){
                return "";
            }
            String deptPhone = bdHandlingArea.getAreaTel();
            String deptName = user.get("deptName");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            StringBuffer buffer = new StringBuffer();
            buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            buffer.append("<PKUDOC>");
            buffer.append("<DATAINFO PAPERCODE=\"sahz\">");
            buffer.append("<TBNAME>");
            buffer.append("<SQR SNO=\"1\">"+clearNull(spJjxx.getBjrxm())+"</SQR>");
            buffer.append("<SQSJ SNO=\"2\">"+switchTime1(spJjxx.getBjsj())+"</SQSJ>");
            buffer.append("<AJMC SNO=\"3\">"+spJjxx.getJqtypeName1()+"</AJMC>");
            buffer.append("<CXFS SNO=\"4\">电话："+clearNull(deptPhone)+"</CXFS>");
            buffer.append("<LXFS SNO=\"5\">民警"+clearNull(spJjxx.getDdrName())+"</LXFS>");
            buffer.append("<JBR SNO=\"7\">"+clearNull(spJjxx.getBjrxm())+"</JBR>");
            buffer.append("<RQ1 SNO=\"6\">"+sdf.format(new Date())+"</RQ1>");
            buffer.append("<RQ2 SNO=\"8\">"+sdf.format(new Date())+"</RQ2>");
            buffer.append("<DWMC SNO=\"9\">"+clearNull(deptName)+"</DWMC>");
            buffer.append("</TBNAME><BARCODEVAL/><SEALBASELIST/><PHOTOBASELIST/>");
            buffer.append("</DATAINFO>");
            buffer.append("</PKUDOC>");
            return buffer.toString();
        }catch (Exception e) {
            logger.error("增加/修改业务数据_接警记录表错误",e);
            return null;
        }
    }

//    //打印接处警记录
//    public String getJcjjl(SpAlarm spAlarm, Map<String, String> user){
//        try {
//            String bjxl = "";
//            if (StringUtils.hasText(spAlarm.getJqtypeid3())){
////                bjxl = sysDicItemService.getDicText("DIC_JJPT_BJXL",spAlarm.getJqtypeid3());
//                bjxl = spAlarmTypeService.getSpAlarmTypeValueByObjcodeAndLevel(spAlarm.getJqtypeid3(),"3");
//            }
//            //获取当前操作用户信息
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
//            StringBuffer buffer = new StringBuffer();
//            buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//            buffer.append("<PKUDOC>");
//            buffer.append("<DATAINFO PAPERCODE=\"jcjjl\">");
//            buffer.append("<TBNAME>");
//            buffer.append("<JLSJ SNO=\"2\">"+sdf.format(new Date())+"</JLSJ>");
//            buffer.append("<ZBMJ SNO=\"5\">"+clearNull(spAlarm.getCjrName())+"</ZBMJ>");
//            buffer.append("<SJXZ SNO=\"6\">"+clearNull(bjxl)+"</SJXZ>");
//            buffer.append("<BJBM SNO=\"7\">"+clearNull(spAlarm.getLldh())+"</BJBM>");
//            buffer.append("<JJR SNO=\"8\">"+clearNull(spAlarm.getDdrName())+"</JJR>");
//            buffer.append("<JJSJ SNO=\"9\">"+switchTime(spAlarm.getDdsj())+"</JJSJ>");
//            buffer.append("<DXCSJ SNO=\"10\">"+switchTime(spAlarm.getDcsj())+"</DXCSJ>");
//            buffer.append("<BJDD SNO=\"11\">"+clearNull(spAlarm.getAfdd())+"</BJDD>");
//            buffer.append("<JJNR SNO=\"12\">"+clearNull(spAlarm.getBjnr())+"</JJNR>");
//            buffer.append("<CJQK SNO=\"13\">"+clearNull(spAlarm.getCjjg())+"</CJQK>");
//            buffer.append("<BZ SNO=\"14\">"+clearNull(spAlarm.getBcxx())+"</BZ>");
//            buffer.append("</TBNAME><BARCODEVAL/><SEALBASELIST/><PHOTOBASELIST/>");
//            buffer.append("</DATAINFO>");
//            buffer.append("</PKUDOC>");
//            return buffer.toString();
//        }catch (Exception e) {
//            logger.error("增加/修改业务数据_接警记录表错误",e);
//            return null;
//        }
//    }

    public String switchTime(Date date){
        if (date==null){
            return "";
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
            return sdf.format(date);
        }
    }

    public String switchTime1(Date date){
        if (date==null){
            return "";
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            return sdf.format(date);
        }
    }

    public String clearNull(String str){
        if (StringUtils.hasText(str)){
            return str;
        }else {
            return "";
        }
    }

}
