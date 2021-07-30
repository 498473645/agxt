package com.pkusoft.jjpt.controller;

import com.pkusoft.jjpt.po.SpRecord;
import com.pkusoft.jjpt.req.SpRecordReqParam;
import com.pkusoft.jjpt.service.SpRecordService;
import com.pkusoft.usercenterproxy.UserCenterProxyHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.support.commons.springmvc.ResponseData;
import pkubatis.common.base.ResponseDto;
import pkubatis.common.utils.NumberToChnUtil;
import pkubatis.common.utils.TimeUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
* 业务数据_笔录信息表 相关操作
* Auto-generated
*/
@Api(value="",tags={"接报警相关业务操作"})
@Controller
public class SpRecordController  {

    /**日志句柄 */
    private static Logger logger = LoggerFactory.getLogger(SpRecordController.class);

    @Autowired
    private SpRecordService spRecordService ;

    /***获取代理用户信息服务类*/
    @Autowired
    private UserCenterProxyHelper userCenterProxyHelper;

    /**
     * 查询接警平台笔录信息表
     * @param request  txtQuery
     * @return
     */
    @ApiOperation(value = "查询接警平台笔录信息表", notes = "查询接警平台笔录信息表", httpMethod = "POST")
    @RequestMapping("/spRecord/spRecordList")
    @ResponseBody
    public ResponseData<List<SpRecord>> spRecordList(HttpServletRequest request, @RequestBody SpRecordReqParam spRecord){
        ResponseDto<List<SpRecord>> dto = new ResponseDto<List<SpRecord>>();
        try{
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            List<SpRecord> list = spRecordService.getSpRecordList(spRecord,user);
            int count = spRecordService.getSpRecordCount(spRecord,user);
            dto.setData(list);
            dto.setCount(count);
            dto.setStatusCode(ResponseData.STATUS_CODE_SUCCESS);
            dto.setStatusMsg("查询接警平台笔录信息表成功");
            return dto;
        }catch(Exception e){
            logger.error("查询接警平台笔录信息表错误",e);
            e.printStackTrace();
            return new ResponseData<>(ResponseData.STATUS_CODE_OTHER,"查询接警平台笔录信息表错误"+e.getMessage());
        }
    }

    /**
     * 新增或修改接警平台笔录信息表
     * @return
     */
    @ApiOperation(value = "新增或修改接警平台笔录信息表", notes = "新增或修改接警平台笔录信息表", httpMethod = "POST")
    @RequestMapping("/spRecord/spRecordSaveOrUpdate")
    @ResponseBody
    public ResponseData<String> spRecordSaveOrUpdate(@RequestBody SpRecord spRecord, HttpServletRequest request){
        try {
            int num = 0;
            //获取当前操作用户信息
            Map<String, String> user = userCenterProxyHelper.getUser(request);
            if(!StringUtils.hasText(spRecord.getObjid())) {
                //添加接警平台笔录信息表
                num = spRecordService.spRecordSave(spRecord, user);
            }else{
                //修改接警平台笔录信息表
                num = spRecordService.spRecordUpdate(spRecord, user);
            }
            if (num > 0){
                // 查看当前笔录是第几次，用于笔录打印
                int recordTime = spRecordService.getRecordTime(spRecord);
                spRecord.setModerName(NumberToChnUtil.numberToChinese(recordTime));
                // 将开始时间与结束时间格式变化，用于笔录打印
                if (spRecord.getJssj()!=null){
                    spRecord.setModerId(TimeUtil.changeTimeForm(spRecord.getKssj()));
                    spRecord.setBzOwnerDept5(TimeUtil.changeTimeForm(spRecord.getJssj()));
                }
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作成功");
        }catch (Exception e) {
            logger.error("增加/修改接警平台笔录信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "增加/修改接警平台笔录信息表错误"+e.getMessage());
        }
    }

    /**
     * 查看接警平台笔录信息表详情
     * @return
     */
    @ApiOperation(value = "查看接警平台笔录信息表详情", notes = "查看接警平台笔录信息表详情", httpMethod = "POST")
    @RequestMapping("/spRecord/spRecordModel")
    @ResponseBody
    public ResponseData<SpRecord> spRecordModel(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            SpRecord spRecord = spRecordService.getSpRecord(objid);
            return new ResponseData<SpRecord>(ResponseData.STATUS_CODE_SUCCESS,"操作成功",spRecord);
        }catch (Exception e){
            logger.error("查看接警平台笔录信息表详情错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "查看接警平台笔录信息表详情错误:"+e.getMessage());
        }
    }

    /**
     * 删除接警平台笔录信息表
     * @return
     */
    @ApiOperation(value = "删除接警平台笔录信息表", notes = "删除接警平台笔录信息表", httpMethod = "POST")
    @RequestMapping("/spRecord/spRecordDelete")
    @ResponseBody
    public ResponseData<String> spRecordDelete(@RequestBody Map map) {
        String objid = (String) map.get("objid");
        if (!StringUtils.hasText(objid)){
            return new ResponseData(ResponseData.STATUS_CODE_PARAM, "参数不能为空");
        }
        try {
            int num = spRecordService.spRecordDelete(objid);
            if (num>0){
                return new ResponseData<String>(ResponseData.STATUS_CODE_SUCCESS,"操作成功");
            }
            return new ResponseData<String>(ResponseData.STATUS_CODE_OTHER,"操作失败");
        }catch (Exception e){
            logger.error("删除接警平台笔录信息表错误",e);
            e.printStackTrace();
            return new ResponseData(ResponseData.STATUS_CODE_OTHER, "删除接警平台笔录信息表错误:"+e.getMessage());
        }
    }

}
