package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjFkxx;
import com.pkusoft.lesp.service.RsJbjFkxxService;
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

//import com.pkusoft.lesp.util.GridResult;
//import com.pkusoft.lesp.util.JsonResult;

/**
* 要素数据_反馈信息 相关操作
* Auto-generated
*/
@Controller
public class RsJbjFkxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjFkxxController.class);

    @Autowired
    private RsJbjFkxxService rsJbjFkxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询要素数据_反馈信息
    * @param request  txtQuery
    * @return
    */
    @RequestMapping("/rsJbjFkxx/rsJbjFkxxList")
    @ResponseBody
    public GridResult rsJbjFkxxList(HttpServletRequest request){
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);

            List<RsJbjFkxx> list = rsJbjFkxxService.getRsJbjFkxxList(map);
            int count = rsJbjFkxxService.getRsJbjFkxxCount(map);
            return new GridResult(true, list, count);
        }catch(Exception e){
            logger.error("查询要素数据_反馈信息错误",e);
            e.printStackTrace();
            throw new RuntimeException("系统异常 :"+e.getMessage());
        }
    }

    /**
    * 新增或修改要素数据_反馈信息
    * @param rsJbjFkxx
    * @param cjdbh
    * @param request
    * @return
    */
    @RequestMapping("/rsJbjFkxx/rsJbjFkxxSaveOrUpdate")
    @ResponseBody
    public JsonResult rsJbjFkxxSaveOrUpdate(RsJbjFkxx rsJbjFkxx, String cjdbh, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(cjdbh == null){
                //添加要素数据_反馈信息
                rsJbjFkxxService.rsJbjFkxxSave(rsJbjFkxx, user);
            }else{
                //修改要素数据_反馈信息
                rsJbjFkxxService.rsJbjFkxxUpdate(rsJbjFkxx, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改要素数据_反馈信息错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
    * 查看要素数据_反馈信息详情
    * @param cjdbh
    * @return
    */
    @RequestMapping("/rsJbjFkxx/rsJbjFkxxModel")
    @ResponseBody
    public JsonResult RsJbjFkxxModel(String cjdbh) {
        RsJbjFkxx rsJbjFkxx = rsJbjFkxxService.getRsJbjFkxx(cjdbh);
        return new JsonResult(true,rsJbjFkxx);
    }

    /**
    * 删除要素数据_反馈信息
    * @param cjdbh
    * @return
    */
    @RequestMapping("/rsJbjFkxx/rsJbjFkxxDelete")
    @ResponseBody
    public JsonResult rsJbjFkxxDelete(String[] cjdbh) {
        if(cjdbh != null){
            int num = rsJbjFkxxService.rsJbjFkxxDelete(cjdbh);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除要素数据_反馈信息错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }
}
