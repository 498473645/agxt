package com.pkusoft.usercenter.controller;

import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.usercenter.service.SysUserService;
import com.pkusoft.usercenter.sysdicitem.SysDicItemValue;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import com.pkusoft.usercenterproxy.vo.DicItemVo;
import com.pkusoft.usercenterproxy.vo.MenuPrivilegeVo;
import com.pkusoft.usercenterproxy.vo.RolePrivilegeVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.utils.ChooseType;
import pkubatis.common.utils.DicDept;
import pkubatis.common.utils.DicPublicType;
import pkubatis.toolkit.ServletUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "门户相关信息控制器", tags = {"门户相关信息控制器"})
@RestController
@RequestMapping("/portal")
public class PortalController {

	private static Logger log = LoggerFactory.getLogger(PortalController.class);

	@Autowired
	private UserCenterProxyHelper userCenterProxyHelper;

	@Autowired
	private SysDeptService sysDeptService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysPermitService sysPermitService;



	/**
	 * Get system menu information
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取系统菜单信息", notes="获取系统菜单信息",httpMethod = "POST")
	@RequestMapping(value = "/getSysMenuList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<List<MenuPrivilegeVo>> getSysMenuList(HttpServletRequest request) {
		try {
			List<MenuPrivilegeVo> menuList = userCenterProxyHelper.getMenuPrivilege(request);
			return new ResponseData<List<MenuPrivilegeVo>>(ResponseData.STATUS_CODE_SUCCESS,"操作成功", menuList);
		}catch(Exception e) {
			log.error("获取系统菜单出错", e);
			return new ResponseData<List<MenuPrivilegeVo>>(ResponseData.STATUS_CODE_BIZ,"获取系统菜单失败", null);
		}
	}

	/**
	 * Get system user information
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取系统用户信息", notes="获取系统用户信息",httpMethod = "POST")
	@RequestMapping(value = "/getSysUserInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<Map<String, String>> getSysUserInfo(HttpServletRequest request) {
		try {
			Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
			return new ResponseData<Map<String, String>>(ResponseData.STATUS_CODE_SUCCESS,"操作成功", userInfo);
		}catch(Exception e) {
			log.error("获取系统用户信息出错", e.getMessage());
			return new ResponseData<Map<String, String>>(ResponseData.STATUS_CODE_BIZ,"获取系统用户信息失败", null);
		}
	}

	/**
	 * Get system user information
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取系统用户单位信息", notes="获取系统用户单位信息",httpMethod = "POST")
	@RequestMapping(value = "/getUserDeptInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<SysDept> getUserDeptInfo(HttpServletRequest request) {
		try {

			Map<String, String> userInfo = userCenterProxyHelper.getUser(request);
			SysDept sysDept = sysDeptService.getSysDept(userInfo.get("deptId"));
			return new ResponseData<SysDept>(ResponseData.STATUS_CODE_SUCCESS,"操作成功", sysDept);
		}catch(Exception e) {
			log.error("获取系统用户单位信息出错", e.getMessage());
			return new ResponseData<SysDept>(ResponseData.STATUS_CODE_BIZ,"获取系统用户单位信息失败", null);
		}
	}

	/**
	 * Get system user role
	 * @param request
	 * @return
	 */
	@ApiOperation(value="获取系统用户角色", notes="获取系统用户角色",httpMethod = "POST")
	@RequestMapping(value = "/getSysUserRoleList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<List<RolePrivilegeVo>> getSysUserRoleList(HttpServletRequest request) {
		try {
			List<RolePrivilegeVo> userRoleList = userCenterProxyHelper.getRole(request);
			return new ResponseData<List<RolePrivilegeVo>>(ResponseData.STATUS_CODE_SUCCESS,"操作成功", userRoleList);
		}catch(Exception e) {
			log.error("获取系统用户信息出错", e.getMessage());
			return new ResponseData<List<RolePrivilegeVo>>(ResponseData.STATUS_CODE_BIZ,"获取系统用户角色失败", null);
		}
	}

	/**
	 * 根据单位id查询子集单位集合
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/sysDeptDicByParentDeptId")
	@ResponseBody
	public ResponseData sysDeptDicByParentDeptId(@RequestBody(required = false) SysDept param,HttpServletRequest request) {
		ResponseData dto  =new ResponseData();
		try {
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(request);
			Map<String, String> map = new HashMap<>();
			SysDept dept = new SysDept();
			//根据当前用户的orgcode获取拼接语句
			if(StringUtils.hasText(param.getParentDeptId())){
				dept.setParentDeptId(param.getParentDeptId());
			}else{
				dept.setDeptId(user.get("deptId"));
			}
			List<SysDept> deptList = sysDeptService.getDeptListByOwnerDept(dept);
			List<DicDept> dicPublicTypeList = new ArrayList<>();
			for (SysDept sysDept:deptList){
				DicDept dicPublicType = new DicDept();
				dicPublicType.setDeptValue(sysDept.getDeptName());
				dicPublicType.setDeptId(sysDept.getDeptId());
				dicPublicType.setDeptLevel(sysDept.getDeptLevel());
				dicPublicTypeList.add(dicPublicType);
			}
			dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
			dto.setStatusMsg("获取单位字典成功");
			dto.setData(dicPublicTypeList);
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
			dto.setStatusMsg("获取单位字典失败"+e.getMessage());
			return dto;
		}
	}


	/**
	 * Get current user list according to department
	 * @param deptId
	 * @param request
	 * @return
	 */
	@ApiOperation(value="根据部门获取当前用户列表", notes="根据部门获取当前用户列表",httpMethod = "POST")
	@RequestMapping(value = "/getSysUserListByDept", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData getSysUserListByDept(@RequestBody(required = false) String deptId, HttpServletRequest request){
		try {
			ResponseData dto  =new ResponseData();
			List<SysUser> userList = new ArrayList<SysUser>();
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(request);
			//根据传递的部门id查询此部门所属人员信息
			if (StringUtils.hasText(deptId)){
				 userList = sysUserService.getSysUserListByDept(deptId);
			}else{
				 userList = sysUserService.getSysUserListByDept(user.get("deptId"));
			}

			List<DicPublicType> userDicList = new ArrayList<>();
			for (SysUser sysUser:userList){
				DicPublicType dicPublicType = new DicPublicType();
				dicPublicType.setItemValue(sysUser.getUserName());
				dicPublicType.setItemCode(sysUser.getUserId());
				userDicList.add(dicPublicType);
			}
			if(null!= userDicList && userDicList.size()>0){
				dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
				dto.setStatusMsg("获取用户字典成功");
				dto.setData(userDicList);
				return dto;
			}else{
				dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
				dto.setStatusMsg("获取用户字典为空");
				return dto;
			}
			//return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "获取当前用户单位成功");
		} catch (Exception e) {
			log.error("获取当前用户出错；"+e.getMessage(), e);
			return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "获取当前用户出错；"+e.getMessage());
		}
	}

	/**
	 * Get basic information of current user
	 * @param req
	 * @return
	 */
	@ApiOperation(value="获取当前用户基本信息", notes="获取当前用户基本信息",httpMethod = "POST")
	@RequestMapping(value = "/getUserInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData getUserInfo(HttpServletRequest req){
		try {
			Map<String, String> userInfo = userCenterProxyHelper.getUser(req);
			return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "获取当前用户基本信息成功", userInfo);
		} catch (Exception e) {
			log.error("获取当前用户基本信息出错；"+e.getMessage(), e);
			return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "获取当前用户基本信息出错；"+e.getMessage());
		}
	}




	/**
	 * Query dictionary collection
	 * @param sysDicItemValue
	 * @return sysDicItemValue
	 */
	@ApiOperation(value = "查询字典", notes = "查询字典接口",httpMethod="POST")
	@RequestMapping(value="/sysDicItemList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData<List<DicItemVo>> sysDicItemList(@RequestBody SysDicItemValue sysDicItemValue) throws IOException{
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

	/**
	 * Get the system parameter value list cache
	 * @param paraCodeList
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value="得到系统参数值列表缓存", notes="得到系统参数值缓存",httpMethod = "GET")
	@RequestMapping(value = "/getSysParaValueList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData<Map<String,String>> getSysParaValueList(@RequestBody String[] paraCodeList) throws IOException {
		Map<String,String> map= new HashMap<>(paraCodeList.length);
		for(String paraCode : paraCodeList){
			String paraValue = userCenterProxyHelper.getPara(paraCode);
			map.put(paraCode,paraValue);
		}
		//得到部门缓存信息
		return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "得到系统参数值缓存信息完毕", map);
	}

	/**
	 * @param paraCode
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value="得到系统参数值缓存", notes="得到系统参数值缓存",httpMethod = "GET")
	@RequestMapping(value = "/getSysParaValue", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData<String> getSysParaValue(@RequestBody String paraCode) throws IOException {
		String paraValue = userCenterProxyHelper.getPara(paraCode);
		return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS, "得到系统参数值缓存信息完毕", paraValue);
	}

	/**
	 * Acquire users, select people on multiple pages
	 * @param deptId
	 * @param req
	 * @return
	 */
	@ApiOperation(value="获取用户,多选页面选人", notes="获取用户,多选页面选人",httpMethod = "POST")
	@RequestMapping(value = "/getUserChoose", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseData getUserChoose(@RequestBody(required = false) String deptId, HttpServletRequest req){
		ResponseData dto  =new ResponseData();
		try {
			List<SysUser> userList = new ArrayList<SysUser>();
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(req);
			//根据传递的部门id查询此部门所属人员信息
			if (StringUtils.hasText(deptId)){
				userList = sysUserService.getSysUserListByDept(deptId);
			}else{
				userList = sysUserService.getSysUserListByDept(user.get("deptId"));
			}
			List<ChooseType> chooseList = new ArrayList<>();
			for (SysUser sysUser:userList){
				ChooseType chooseType = new ChooseType();
				chooseType.setId(sysUser.getUserId());
				chooseType.setName(sysUser.getUserName());
				chooseType.setActive(false);
				chooseList.add(chooseType);
			}
			if(null!= chooseList && chooseList.size()>0){
				dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
				dto.setStatusMsg("获取用户字典成功");
				dto.setData(chooseList);
				return dto;
			}else{
				dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
				dto.setStatusMsg("获取用户字典为空");
				return dto;
			}
		} catch (Exception e) {
			log.error("获取当前用户基本信息出错；"+e.getMessage(), e);
			return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "获取用户出错；"+e.getMessage());
		}
	}

	/**
	 * 获取Websocket访问者ip
	 * @return
	 */
	@ApiOperation(value = "获取Websocket访问者ip", notes = "获取访问者ip接口", httpMethod = "POST")
	@RequestMapping("/getWebsocketNo")
	@ResponseBody
	public ResponseData<String> getWebsocketNo(HttpServletRequest request) {
		try{
			String userno = ServletUtils.getRemoteAddr(request);
			return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,userno);
		}catch (Exception e){
			log.error("查询活跃的接警记录表数据错误",e);
			e.printStackTrace();
			return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"系统异常 :"+e.getMessage());
		}
	}
}
