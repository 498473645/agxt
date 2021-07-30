package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjSxtxx;
import com.pkusoft.lesp.service.RsJbjSxtxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ControllerUtil;
import pkubatis.model.GridResult;
import pkubatis.model.JsonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
* 要素数据_派出所摄像头基本信息 相关操作
* Auto-generated
*/
@Controller
public class RsJbjSxtxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjSxtxxController.class);

    @Autowired
    private RsJbjSxtxxService rsJbjSxtxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询要素数据_派出所摄像头基本信息
    * @param request  txtQuery
    * @return
    */
    @RequestMapping("/rsJbjSxtxx/rsJbjSxtxxList")
    @ResponseBody
    public GridResult rsJbjSxtxxList(HttpServletRequest request){
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);

            List<RsJbjSxtxx> list = rsJbjSxtxxService.getRsJbjSxtxxList(map);
            int count = rsJbjSxtxxService.getRsJbjSxtxxCount(map);
            return new GridResult(true, list, count);
        }catch(Exception e){
            logger.error("查询要素数据_派出所摄像头基本信息错误",e);
            e.printStackTrace();
            throw new RuntimeException("系统异常 :"+e.getMessage());
        }
    }

    /**
    * 新增或修改要素数据_派出所摄像头基本信息
    * @param rsJbjSxtxx
    * @param objid
    * @param request
    * @return
    */
    @RequestMapping("/rsJbjSxtxx/rsJbjSxtxxSaveOrUpdate")
    @ResponseBody
    public JsonResult rsJbjSxtxxSaveOrUpdate(RsJbjSxtxx rsJbjSxtxx, String objid, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(objid == null){
                //添加要素数据_派出所摄像头基本信息
                rsJbjSxtxxService.rsJbjSxtxxSave(rsJbjSxtxx, user);
            }else{
                //修改要素数据_派出所摄像头基本信息
                rsJbjSxtxxService.rsJbjSxtxxUpdate(rsJbjSxtxx, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改要素数据_派出所摄像头基本信息错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
    * 查看要素数据_派出所摄像头基本信息详情
    * @param objid
    * @return
    */
    @RequestMapping("/rsJbjSxtxx/rsJbjSxtxxModel")
    @ResponseBody
    public JsonResult RsJbjSxtxxModel(String objid) {
        RsJbjSxtxx rsJbjSxtxx = rsJbjSxtxxService.getRsJbjSxtxx(objid);
        return new JsonResult(true,rsJbjSxtxx);
    }

    /**
    * 删除要素数据_派出所摄像头基本信息
    * @param objid
    * @return
    */
    @RequestMapping("/rsJbjSxtxx/rsJbjSxtxxDelete")
    @ResponseBody
    public JsonResult rsJbjSxtxxDelete(String[] objid) {
        if(objid != null){
            int num = rsJbjSxtxxService.rsJbjSxtxxDelete(objid);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除要素数据_派出所摄像头基本信息错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }
}
