package com.pkusoft.usercenter.controller;

import com.pkusoft.usercenter.po.SysUser;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
* 用户表 相关操作
* Auto-generated
*/
@Controller
public class SysUserController {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    /**
     * 查询字典集合
     * @param sysDicItemValue
     * @return sysDicItemValue
     */
    @ApiOperation(value = "查询字典", notes = "查询字典接口",httpMethod="POST")
    @RequestMapping(value="/sysUser/sysDicItemList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	 * 获取人员列表
	 *
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取人员列表", notes = "获取人员列表接口", httpMethod = "POST")
	@RequestMapping(value = "/sysUser/sysUserDicList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseDto<List<SysUser>> sysUserDicList(HttpServletRequest request)throws IOException {
		ResponseDto<List<SysUser>> dto = new ResponseDto<List<SysUser>>();
//		BaseSysUser user = userCenterServiceImpl.getCurrentUser(request);
		//通过UserCenter代理可以拿到当前用户信息
		Map<String, String> user1 = userCenterProxyHelper.getUser(request);
		try {
			Example example = new Example(com.pkusoft.usercenter.po.SysUser.class);

			example.createCriteria().andEqualTo("deptId", user1.get("deptId"));
            example.setOrderByClause("USER_LXBM");
			List<SysUser> sysUserList = sysUserService.selectSysUserListByExample(example);
			dto.setData(sysUserList);
			dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
			dto.setStatusMsg("查询用户列表成功");
			return dto;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			dto.setStatusMsg("查询用户列表失败");
			dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
			return dto;
		}
	}

    /**
     * 获取民警
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取民警列表", notes = "获取民警列表接口", httpMethod = "POST")
    @RequestMapping(value = "/sysUser/sysPoliceUserDicList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDto<List<SysUser>> sysPoliceUserDicList(HttpServletRequest request)throws IOException {
        ResponseDto<List<SysUser>> dto = new ResponseDto<List<SysUser>>();
//        BaseSysUser user = userCenterServiceImpl.getCurrentUser(request);
        //通过UserCenter代理可以拿到当前用户信息
        Map<String, String> user1 = userCenterProxyHelper.getUser(request);
        try {
            Example example = new Example(com.pkusoft.usercenter.po.SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("deptId", user1.get("deptId"));
            criteria.andNotEqualTo("userLxbm", 4);
            List<SysUser> sysUserList = sysUserService.selectSysUserListByExample(example);
            dto.setData(sysUserList);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询用户列表成功");
            return dto;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            dto.setStatusMsg("查询用户列表失败");
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
            return dto;
        }
    }

    /**
     * 获取辅警
     *
     * @param
     * @return
     */
    @ApiOperation(value = "获取辅警列表", notes = "获取辅警列表接口", httpMethod = "POST")
    @RequestMapping(value = "/sysUser/sysAssitantUserDicList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseDto<List<SysUser>> sysAssitantUserDicList(HttpServletRequest request)throws IOException {
        ResponseDto<List<SysUser>> dto = new ResponseDto<List<SysUser>>();
//        BaseSysUser user = userCenterServiceImpl.getCurrentUser(request);
        //通过UserCenter代理可以拿到当前用户信息
        Map<String, String> user1 = userCenterProxyHelper.getUser(request);
        try {
            Example example = new Example(com.pkusoft.usercenter.po.SysUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("deptId", user1.get("deptId"));
            criteria.andEqualTo("userLxbm", 4);
            List<SysUser> sysUserList = sysUserService.selectSysUserListByExample(example);
            dto.setData(sysUserList);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询用户列表成功");
            return dto;

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            dto.setStatusMsg("查询用户列表失败");
            dto.setStatusCode(ResponseData.STATUS_CODE_PARAM_ERROR);
            return dto;
        }
    }



}
