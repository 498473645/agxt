package com.pkusoft.lesp.controller;

import com.pkusoft.lesp.po.RsJbjJgxtDynamic;
import com.pkusoft.lesp.service.RsJbjJgxtDynamicService;
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
*  相关操作
* Auto-generated
*/
@Controller
public class RsJbjJgxtDynamicController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(RsJbjJgxtDynamicController.class);

    @Autowired
    private RsJbjJgxtDynamicService rsJbjJgxtDynamicService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
    * 查询
    * @param request  txtQuery
    * @return
    */
    @RequestMapping("/rsJbjJgxtDynamic/rsJbjJgxtDynamicList")
    @ResponseBody
    public GridResult rsJbjJgxtDynamicList(HttpServletRequest request){
        try{
            Map<String, String> map = ControllerUtil.getRequestBody(request);

            List<RsJbjJgxtDynamic> list = rsJbjJgxtDynamicService.getRsJbjJgxtDynamicList(map);
            int count = rsJbjJgxtDynamicService.getRsJbjJgxtDynamicCount(map);
            return new GridResult(true, list, count);
        }catch(Exception e){
            logger.error("查询错误",e);
            e.printStackTrace();
            throw new RuntimeException("系统异常 :"+e.getMessage());
        }
    }

    /**
    * 新增或修改
    * @param rsJbjJgxtDynamic
    * @param bjrxm
    * @param request
    * @return
    */
    @RequestMapping("/rsJbjJgxtDynamic/rsJbjJgxtDynamicSaveOrUpdate")
    @ResponseBody
    public JsonResult rsJbjJgxtDynamicSaveOrUpdate(RsJbjJgxtDynamic rsJbjJgxtDynamic, String bjrxm, HttpServletRequest request){
        try {
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(bjrxm == null){
                //添加
                rsJbjJgxtDynamicService.rsJbjJgxtDynamicSave(rsJbjJgxtDynamic, user);
            }else{
                //修改
                rsJbjJgxtDynamicService.rsJbjJgxtDynamicUpdate(rsJbjJgxtDynamic, user);
            }

            return new JsonResult(true);
        }catch (Exception e) {
            logger.error("增加/修改错误",e);
            return new JsonResult(false, e.getMessage());
        }
    }

    /**
    * 查看详情
    * @param bjrxm
    * @return
    */
    @RequestMapping("/rsJbjJgxtDynamic/rsJbjJgxtDynamicModel")
    @ResponseBody
    public JsonResult RsJbjJgxtDynamicModel(String bjrxm) {
        RsJbjJgxtDynamic rsJbjJgxtDynamic = rsJbjJgxtDynamicService.getRsJbjJgxtDynamic(bjrxm);
        return new JsonResult(true,rsJbjJgxtDynamic);
    }

    /**
    * 删除
    * @param bjrxm
    * @return
    */
    @RequestMapping("/rsJbjJgxtDynamic/rsJbjJgxtDynamicDelete")
    @ResponseBody
    public JsonResult rsJbjJgxtDynamicDelete(String[] bjrxm) {
        if(bjrxm != null){
            int num = rsJbjJgxtDynamicService.rsJbjJgxtDynamicDelete(bjrxm);
            if(num>0){
                return new JsonResult(true);
            }else{
                return new JsonResult(true);
            }
        }else{
            logger.error("删除错误");
            return new JsonResult(false, "请求参数不允许为空");
        }
    }
}
