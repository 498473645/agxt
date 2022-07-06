package com.pkusoft.usercenter.controller;

import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.DicPublicType;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
* 部门表 相关操作
* Auto-generated
*/
@Controller
public class SysDeptController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private SysDeptService sysDeptService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


	/**
	 * 通过当前用户权限查询其所属单位及下属单位
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/sysDept/getSysDeptDicList")
	@ResponseBody
	public ResponseDto<List<DicPublicType>> sysDeptDicBypermit(HttpServletRequest request) {
		ResponseDto<List<DicPublicType>> dto = new ResponseDto<List<DicPublicType>>();
		try {
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SysDept> deptList = sysDeptService.getParentDeptId(user.get("deptId"));
			List<DicPublicType> dicPublicTypeList = new ArrayList<>();
			for (SysDept sysDept:deptList){
				DicPublicType dicPublicType = new DicPublicType();
				dicPublicType.setItemValue(sysDept.getDeptName());
				dicPublicType.setItemCode(sysDept.getDeptId());
				dicPublicTypeList.add(dicPublicType);
			}
			if(null!= dicPublicTypeList && dicPublicTypeList.size()>0){
				dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
				dto.setStatusMsg("获取单位字典成功");
				dto.setData(dicPublicTypeList);
				return dto;
			}else{
				dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
				dto.setStatusMsg("获取单位字典为空");
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
			dto.setStatusMsg("获取单位字典失败"+e.getMessage());
			return dto;
		}
	}

	/**
	 * 通过当前用户权限所属单位级别查询其所属单位及下属单位
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/sysDept/sysDeptDicByDeptLevel")
	@ResponseBody
	public ResponseDto<List<DicPublicType>> sysDeptDicByDeptLevel(HttpServletRequest request) {
		ResponseDto<List<DicPublicType>> dto = new ResponseDto<List<DicPublicType>>();
		try {
			//获取当前操作用户信息
			Map<String, String> user = userCenterProxyHelper.getUser(request);
			List<SysDept> deptList = sysDeptService.sysDeptDicByDeptLevel(user.get("deptId"));
			List<DicPublicType> dicPublicTypeList = new ArrayList<>();
			for (SysDept sysDept:deptList){
				DicPublicType dicPublicType = new DicPublicType();
				dicPublicType.setItemValue(sysDept.getDeptName());
				dicPublicType.setItemCode(sysDept.getDeptId());
				dicPublicTypeList.add(dicPublicType);
			}
			if(null!= dicPublicTypeList && dicPublicTypeList.size()>0){
				dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
				dto.setStatusMsg("获取单位字典成功");
				dto.setData(dicPublicTypeList);
				return dto;
			}else{
				dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
				dto.setStatusMsg("获取单位字典为空");
				return dto;
			}
		} catch (Exception e) {
			e.printStackTrace();
			dto.setStatusCode(ResponseData.STATUS_CODE_OTHER);
			dto.setStatusMsg("获取单位字典失败"+e.getMessage());
			return dto;
		}
	}


	/**
	 * 获取部门列表
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取部门列表", notes = "获取部门列表接口", httpMethod = "POST")
	@RequestMapping(value = "/sysDept/DeptList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDto<List<SysDept>> sacwTzxxDeptList(HttpServletRequest request)throws IOException {
		ResponseDto<List<SysDept>> dto = new ResponseDto<List<SysDept>>();
		//通过UserCenter代理可以拿到当前用户信息
		Map<String, String> user = userCenterProxyHelper.getUser(request);
		try {
			// TODO: 业务逻辑.
			List<SysDept> list = sysDeptService.getParentDeptId(user.get("deptId"));
			dto.setData(list);
			dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
			dto.setStatusMsg("查询部门列表成功");
			return dto;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// TODO: 业务日志
			dto.setStatusMsg("查询部门列表失败");
			dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
			return dto;
		}
	}

	/**
	 * 获取社区
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取社区列表", notes = "获取社区列表接口", httpMethod = "POST")
	@RequestMapping(value = "/sysDept/communityList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDto<List<SysDept>> getCommunityList(HttpServletRequest request)throws IOException {
		ResponseDto<List<SysDept>> dto = new ResponseDto<List<SysDept>>();
		//通过UserCenter代理可以拿到当前用户信息
		Map<String, String> user = userCenterProxyHelper.getUser(request);
		try {
			List<SysDept> list = sysDeptService.getOnlyParentDeptId(user.get("deptId"));
			dto.setData(list);
			dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
			dto.setStatusMsg("查询部门列表成功");
			return dto;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			dto.setStatusMsg("查询部门列表失败");
			dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
			return dto;
		}
	}
}
