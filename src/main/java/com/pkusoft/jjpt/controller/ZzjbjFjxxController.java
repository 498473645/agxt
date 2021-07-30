package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.service.ZzjbjFjxxService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
* 微信自助报警-附件信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class ZzjbjFjxxController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(ZzjbjFjxxController.class);

    @Autowired
    private ZzjbjFjxxService zzjbjFjxxService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

//    /**
//    * 查询微信自助报警-附件信息表
//    * @param request  txtQuery
//    * @return
//    */
//    @RequestMapping("/zzjbjFjxx/zzjbjFjxxList")
//    @ResponseBody
//    public GridResult zzjbjFjxxList(HttpServletRequest request){
//        try{
//            Map<String, String> map = ControllerUtil.getRequestBody(request);
//
//            List<ZzjbjFjxx> list = zzjbjFjxxService.getZzjbjFjxxList(map);
//            int count = zzjbjFjxxService.getZzjbjFjxxCount(map);
//            return new GridResult(true, list, count);
//        }catch(Exception e){
//            logger.error("查询微信自助报警-附件信息表错误",e);
//            e.printStackTrace();
//            throw new RuntimeException("系统异常 :"+e.getMessage());
//        }
//    }
//
//    /**
//    * 新增或修改微信自助报警-附件信息表
//    * @param zzjbjFjxx
//    * @param fjbh
//    * @param request
//    * @return
//    */
//    @RequestMapping("/zzjbjFjxx/zzjbjFjxxSaveOrUpdate")
//    @ResponseBody
//    public JsonResult zzjbjFjxxSaveOrUpdate(ZzjbjFjxx zzjbjFjxx, String fjbh, HttpServletRequest request){
//        try {
//            //获取当前操作用户信息
//            Map<String, String> user = userCenterProxyHelper.getUser(request);
//            if(fjbh == null){
//                //添加微信自助报警-附件信息表
//                zzjbjFjxxService.zzjbjFjxxSave(zzjbjFjxx, user);
//            }else{
//                //修改微信自助报警-附件信息表
//                zzjbjFjxxService.zzjbjFjxxUpdate(zzjbjFjxx, user);
//            }
//
//            return new JsonResult(true);
//        }catch (Exception e) {
//            logger.error("增加/修改微信自助报警-附件信息表错误",e);
//            return new JsonResult(false, e.getMessage());
//        }
//    }
//
//    /**
//    * 查看微信自助报警-附件信息表详情
//    * @param fjbh
//    * @return
//    */
//    @RequestMapping("/zzjbjFjxx/zzjbjFjxxModel")
//    @ResponseBody
//    public JsonResult ZzjbjFjxxModel(String fjbh) {
//        ZzjbjFjxx zzjbjFjxx = zzjbjFjxxService.getZzjbjFjxx(fjbh);
//        return new JsonResult(true,zzjbjFjxx);
//    }
//
//    /**
//    * 删除微信自助报警-附件信息表
//    * @param fjbh
//    * @return
//    */
//    @RequestMapping("/zzjbjFjxx/zzjbjFjxxDelete")
//    @ResponseBody
//    public JsonResult zzjbjFjxxDelete(String[] fjbh) {
//        if(fjbh != null){
//            int num = zzjbjFjxxService.zzjbjFjxxDelete(fjbh);
//            if(num>0){
//                return new JsonResult(true);
//            }else{
//                return new JsonResult(true);
//            }
//        }else{
//            logger.error("删除微信自助报警-附件信息表错误");
//            return new JsonResult(false, "请求参数不允许为空");
//        }
//    }
}
