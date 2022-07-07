package com.pkusoft.jjpt.controller;


import com.pkusoft.jjpt.po.SpMedia;
import com.pkusoft.jjpt.req.SpMediaReqParam;
import com.pkusoft.jjpt.service.SpMediaService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 审讯视音频信息表 相关操作
 */
@Api(value="审讯视音频信息表",tags={"审讯视音频信息表 相关操作"})
@Controller
public class SpMediaController  {

    @Autowired
    private SpMediaService spMediaService ;

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpJjxxController.class);

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;


    /**
    * 查询审讯视音频信息表
    * @param map
    * @return
    */
    @ApiOperation(value="查询审讯视音频信息表", notes="查询审讯视音频信息表", httpMethod = "POST")
    @RequestMapping("/spMedia/spMediaList")
    @ResponseBody
    public ResponseData<List<SpMedia>> spMediaList(HttpServletRequest request, @RequestBody Map<String, String> map){
        ResponseDto<List<SpMedia>> dto = new ResponseDto<List<SpMedia>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            SpMedia spMedia = new SpMedia();
            spMedia.setJObjid(map.get("jObjid"));
            List<SpMedia> list = spMediaService.getSpMediaList(spMedia,user);
            int count = spMediaService.getSpMediaCount(spMedia,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台接警信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台接警信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台接警信息表错误"+e.getMessage());
        }
    }

}
