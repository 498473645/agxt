package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjYbjxx;
import com.pkusoft.lesp.service.RsJbjYbjxxService;
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
* 要素数据_预报警基本信息 相关操作
* Auto-generated
*/
@Controller
public class RsJbjYbjxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjYbjxxController.class);

    @Autowired
    private RsJbjYbjxxService rsJbjYbjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    /**
     * 查询要素数据_预报警基本信息
     * @param request  txtQuery
     * @return
     */
    @RequestMapping("/rsJbjYbjxx/rsJbjYbjxxList")
    @ResponseBody
    public GridResult rsJbjYbjxxList(HttpServletRequest request){
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);

            List<RsJbjYbjxx> list = rsJbjYbjxxService.getRsJbjYbjxxList(map);
            int count = rsJbjYbjxxService.getRsJbjYbjxxCount(map);
            return new GridResult(true, list, count);
        }catch(Exception e){
            logger.error("查询要素数据_预报警基本信息错误",e);
            e.printStackTrace();
            throw new RuntimeException("系统异常 :"+e.getMessage());
        }
    }

    /**
    * 新增或修改要素数据_预报警基本信息
    * @param rsJbjYbjxx
    * @param bjid
    * @param request
    * @return
    */
    @RequestMapping("/rsJbjYbjxx/rsJbjYbjxxSaveOrUpdate")
    @ResponseBody
    public JsonResult rsJbjYbjxxSaveOrUpdate(RsJbjYbjxx rsJbjYbjxx, String bjid, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(bjid == null){
                //添加要素数据_预报警基本信息
                rsJbjYbjxxService.rsJbjYbjxxSave(rsJbjYbjxx, user);
            }else{
                //修改要素数据_预报警基本信息
                rsJbjYbjxxService.rsJbjYbjxxUpdate(rsJbjYbjxx, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改要素数据_预报警基本信息错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
    * 查看要素数据_预报警基本信息详情
    * @param bjid
    * @return
    */
    @RequestMapping("/rsJbjYbjxx/rsJbjYbjxxModel")
    @ResponseBody
    public JsonResult RsJbjYbjxxModel(String bjid) {
        RsJbjYbjxx rsJbjYbjxx = rsJbjYbjxxService.getRsJbjYbjxx(bjid);
        return new JsonResult(true,rsJbjYbjxx);
    }

    /**
    * 删除要素数据_预报警基本信息
    * @param bjid
    * @return
    */
    @RequestMapping("/rsJbjYbjxx/rsJbjYbjxxDelete")
    @ResponseBody
    public JsonResult rsJbjYbjxxDelete(String[] bjid) {
        if(bjid != null){
            int num = rsJbjYbjxxService.rsJbjYbjxxDelete(bjid);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除要素数据_预报警基本信息错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }
}
