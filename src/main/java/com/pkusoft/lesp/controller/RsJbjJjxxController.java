package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjJjxx;
import com.pkusoft.lesp.service.RsJbjJjxxService;
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
* 要素数据_接警信息 相关操作
* Auto-generated
*/
@Controller
public class RsJbjJjxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJjxxController.class);

    @Autowired
    private RsJbjJjxxService rsJbjJjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询要素数据_接警信息
    * @param request  txtQuery
    * @return
    */
    @RequestMapping("/rsJbjJjxx/rsJbjJjxxList")
    @ResponseBody
    public GridResult rsJbjJjxxList(HttpServletRequest request){
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);

            List<RsJbjJjxx> list = rsJbjJjxxService.getRsJbjJjxxList(map);
            int count = rsJbjJjxxService.getRsJbjJjxxCount(map);
            return new GridResult(true, list, count);
        }catch(Exception e){
            logger.error("查询要素数据_接警信息错误",e);
            e.printStackTrace();
            throw new RuntimeException("系统异常 :"+e.getMessage());
        }
    }

    /**
    * 新增或修改要素数据_接警信息
    * @param rsJbjJjxx
    * @param jjdbh
    * @param request
    * @return
    */
    @RequestMapping("/rsJbjJjxx/rsJbjJjxxSaveOrUpdate")
    @ResponseBody
    public JsonResult rsJbjJjxxSaveOrUpdate(RsJbjJjxx rsJbjJjxx, String jjdbh, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(jjdbh == null){
                //添加要素数据_接警信息
                rsJbjJjxxService.rsJbjJjxxSave(rsJbjJjxx, user);
            }else{
                //修改要素数据_接警信息
                rsJbjJjxxService.rsJbjJjxxUpdate(rsJbjJjxx, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改要素数据_接警信息错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
    * 查看要素数据_接警信息详情
    * @param jjdbh
    * @return
    */
    @RequestMapping("/rsJbjJjxx/rsJbjJjxxModel")
    @ResponseBody
    public JsonResult RsJbjJjxxModel(String jjdbh) {
        RsJbjJjxx rsJbjJjxx = rsJbjJjxxService.getRsJbjJjxx(jjdbh);
        return new JsonResult(true,rsJbjJjxx);
    }

    /**
    * 删除要素数据_接警信息
    * @param jjdbh
    * @return
    */
    @RequestMapping("/rsJbjJjxx/rsJbjJjxxDelete")
    @ResponseBody
    public JsonResult rsJbjJjxxDelete(String[] jjdbh) {
        if(jjdbh != null){
            int num = rsJbjJjxxService.rsJbjJjxxDelete(jjdbh);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除要素数据_接警信息错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }
}
