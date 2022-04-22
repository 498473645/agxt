package com.pkusoft.zfgk.controller;

import com.pkusoft.zfgk.model.ZfgkFlfg;
import com.pkusoft.zfgk.req.ZfgkFlfgReqParam;
import com.pkusoft.zfgk.service.ZfgkFlfgService;
import io.swagger.annotations.Api;
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
import pkubatis.common.base.ResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author
 * 法律法规依据
 */
@Api(value="法律法规依据",tags={"执法公开相关操作"})
@Controller
public class ZfgkFlfgController {

    /**日志句柄 */
    private final static Logger logger = LoggerFactory.getLogger(ZfgkFlfgController.class);

    @Autowired(required=false)
    private ZfgkFlfgService zfgkFlfgService;

    /**
     * 查询法律法规依据
     * @param zfgkFlfgReqParam
     * @return
     */
    @ApiOperation(value="查询法律法规依据列表", notes="查询法律法规依据列表", httpMethod="POST")
    @RequestMapping(value = "/zfgkFlfg/zfgkFlfgList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<List<ZfgkFlfg>> zfgkFlfgList(HttpServletRequest request, @RequestBody ZfgkFlfgReqParam zfgkFlfgReqParam){
        ResponseDto<List<ZfgkFlfg>> dto = new ResponseDto<List<ZfgkFlfg>>();
        try{
            List<ZfgkFlfg> list = zfgkFlfgService.getZfgkFlfgList(zfgkFlfgReqParam);
            int count = zfgkFlfgService.getZfgkFlfgCount(zfgkFlfgReqParam);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询事务数据成功");
            return dto;
        }catch(Exception e){
            logger.error("查询事务数据错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询事务数据错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改法律法规依据业务数据
     * @return
     */
    @ApiOperation(value = "新增或修改法律法规依据业务数据", notes = "新增或修改法律法规依据业务数据", httpMethod = "POST")
    @RequestMapping("/zfgkFlfg/zfgkFlfgSaveOrUpdate")
    @ResponseBody
    public ResponseData<ZfgkFlfg> zfgkFlfgSaveOrUpdate(@RequestBody ZfgkFlfg zfgkFlfg, HttpServletRequest request){
        try {
            int num = 0;
            if(!StringUtils.hasText(zfgkFlfg.getLawId())) {
                //新增法律法规依据业务数据
                num = zfgkFlfgService.zfgkSave(zfgkFlfg);
            }else{
                //修改法律法规依据业务数据
                num = zfgkFlfgService.zfgkUpdate(zfgkFlfg);
            }
            if (num>0){
                return new ResponseData<>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zfgkFlfg);
            }
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"操作失败",zfgkFlfg);
        }catch (Exception e) {
            logger.error("增加/修改法律法规依据业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改法律法规依据业务数据错误"+e.getMessage(),null);
        }
    }

    /**
     * 查看法律法规依据业务数据
     * @param map
     * @return
     */
    @ApiOperation(value="查看法律法规依据业务数据", notes="查看法律法规依据业务数据", httpMethod="POST")
    @RequestMapping(value = "/zfgkFlfg/zfgkFlfgDetails", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<ZfgkFlfg> zfgkFlfgDetails(@RequestBody Map map){
        String lawId = (String) map.get("lawId");
        if (!StringUtils.hasText(lawId)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            ZfgkFlfg zfgkFlfg = zfgkFlfgService.getZfgkFlfg(lawId);
            if (null == zfgkFlfg.getLawId()) {
                return new ResponseData<ZfgkFlfg>(ResponseData.STATUS_CODE_SUCCESS, "未查询到数据", null);
            }
            return new ResponseData<ZfgkFlfg>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",zfgkFlfg);
        }catch (Exception e){
            logger.error("查看法律法规依据业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看法律法规依据业务数据详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除法律法规依据业务数据
     * @param map
     * @return
     */
    @ApiOperation(value="删除法律法规依据业务数据", notes="删除法律法规依据业务数据", httpMethod="POST")
    @RequestMapping(value = "/zfgkFlfg/zfgkFlfgDelete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseData<String> zfgkFlfgDelete(@RequestBody Map map){
        // 检查参数
        String lawId = (String) map.get("lawId");
        if (!StringUtils.hasText(lawId)){
            return new ResponseData<>(ResponseData.STATUS_CODE_PARAM, "参数为空");
        }
        try {
            int num = zfgkFlfgService.zfgkFlfgDelete(lawId);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除法律法规依据业务数据错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除法律法规依据业务数据错误:"+e.getMessage());
        }
    }
}
