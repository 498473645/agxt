package com.pkusoft.usercenter.controller;

import com.pkusoft.usercenter.po.SysMenu;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysMenuService;
import com.pkusoft.usercenter.service.SysUserService;
import com.pkusoft.usercenter.sysdicitem.SysDicItemValue;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
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
import org.support.commons.springmvc.ResponseData;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserCenterController  {
    /**日志句柄 */
    private static Logger log = LoggerFactory.getLogger(UserCenterController.class);

    /**
     * 用户中心服务代理
     */
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 根据检索条件查询数据归属单位列表
     * @param searchMap
     * @return sysDicItemValue
     */
    @ApiOperation(value = "根据检索条件查询数据归属用户列表", notes = "根据检索条件查询数据归属用户列表",httpMethod="POST")
    @RequestMapping(value="/userCenter/getSysUserListByPoliceCode", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<SysUser>> getSysUserListByPoliceCode(@RequestBody Map<String,String> searchMap, HttpServletRequest request){
        try {
            // TODO: 业务逻辑
            //通过UserCenter代理可以拿到当前用户信息
            Map<String, String> userMap = userCenterProxyHelper.getUser(request);
            String search = searchMap.get("search");
            String policeCode = searchMap.get("policeCode");
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "根据检索条件查询数据归属用户列表成功", userService.getSysUserListByCode(search,policeCode,userMap));
        } catch (Exception e) {
            // TODO: 业务日志
            log.error("根据检索条件查询数据归属用户列表出错；"+e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "根据检索条件查询数据归属用户列表出错；"+e.getMessage());
        }
    }

    /**
     * 查询字典集合
     * @return sysDicItemValue
     */
    @ApiOperation(value = "查询字典", notes = "查询字典接口",httpMethod="POST")
    @RequestMapping(value="/userCenter/getPoliceDynamicDic", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<DicItemVo>> getPoliceDynamicDic(String policeId, HttpServletRequest request) throws IOException {
        ResponseData<List<DicItemVo>> dto = new ResponseData<List<DicItemVo>>();
        try {
            List<DicItemVo> list= new ArrayList<DicItemVo>();
            if (StringUtils.hasText(policeId)){
                SysUser sysUser = userService.getSysUser(policeId);
                if (sysUser!=null){
                    DicItemVo dicItemVo = new DicItemVo();
                    dicItemVo.setItemCode(sysUser.getUserId());
                    dicItemVo.setItemValue(sysUser.getUserName());
                    list.add(dicItemVo);
                }
            }
            dto.setData(list);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
            return dto;
        } catch (Exception e) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
            dto.setStatusMsg("请求失败!");
            e.printStackTrace();
            return dto;
        }
//        ResponseData<List<SpAlarmType>> dto = new ResponseData<List<SpAlarmType>>();
//        try{
//            SpAlarmType spAlarmType = new SpAlarmType();
//            spAlarmType.setDicLevel(dicLevel);
//            spAlarmType.setObjcode(objcode);
//            List<SpAlarmType> list = spAlarmTypeService.getSpAlarmTypeListByLevelAndType(spAlarmType);
//            dto.setData(list);
//            dto.setStatusCode(ResponseData4Api.STATUS_CODE_SUCCESS);
//            dto.setStatusMsg("查询字典成功");
//        }catch(Exception e){
//            logger.error("查询字典错误",e);
//            e.printStackTrace();
//            dto.setStatusCode(ResponseData4Api.STATUS_CODE_PARAM_ERROR);
//        }
//        return dto;
    }

    /**
     * 获取当前用户菜单列表信息
     * @param request
     * @return
     */
    @ApiOperation(value = "获取当前用户菜单列表信息", notes="获取当前用户菜单列表信息",httpMethod = "POST")
    @RequestMapping(value="/userCenter/getUserMenuList",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<SysMenu>> getUserMenuList(HttpServletRequest request){
        try{
            // TODO: 业务逻辑
            //通过UserCenter代理可以拿到当前用户信息
            Map<String,String> user= userCenterProxyHelper.getUser(request);
            //获取用户菜单信息
            List<SysMenu> lsit = sysMenuService.getUserMenuList(user.get("userId"));
            return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "获取当前用户基本信息成功", lsit);
        } catch (IOException e) {
            // TODO: 业务日志
            log.error("获取当前用户基本信息出错；"+e.getMessage(), e);
            return new ResponseData<>(ResponseData.STATUS_CODE_BIZ, "获取当前用户菜单列表信息出错；"+e.getMessage());
        }
    }

    /**
     * 查询字典集合
     * @param sysDicItemValue
     * @return sysDicItemValue
     */
    @ApiOperation(value = "查询字典", notes = "查询字典接口",httpMethod="POST")
    @RequestMapping(value="/userCenter/sysDicItemList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<DicItemVo>> sysDicItemList(@RequestBody SysDicItemValue sysDicItemValue) {
        ResponseData<List<DicItemVo>> dto = new ResponseData<List<DicItemVo>>();
        try {
            List<DicItemVo> list=userCenterProxyHelper.getDic(sysDicItemValue.getDicName());
            dto.setData(list);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询字典成功");
            return dto;
        } catch (Exception e) {
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM);
            dto.setStatusMsg("请求失败!");
            e.printStackTrace();
            return dto;
        }
    }

}
