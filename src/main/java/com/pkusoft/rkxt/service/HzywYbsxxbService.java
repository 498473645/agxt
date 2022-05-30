package com.pkusoft.rkxt.service;


import com.pkusoft.rkxt.model.HzywYbsxxb;
import com.pkusoft.rkxt.model.XtBizType;
import com.pkusoft.rkxt.model.XtBizTypeVo;
import org.support.commons.springmvc.ResponseData;

import javax.servlet.http.HttpServletRequest;

public interface HzywYbsxxbService {

    /**
    * 调用人口系统接口推送预办事数据
    * @param hzywYbsxxb
    * @return
    */
    ResponseData hzywYbsxxbSave(HzywYbsxxb hzywYbsxxb);

    /**
     * 调用人口系统接口获取办事过程数据
     * @param code
     * @return
     */
    ResponseData<HzywYbsxxb> getHzywYbsxxb(String code);

    ResponseData<HzywYbsxxb> getHzywYbsxxbList(HzywYbsxxb hzywYbsxxb,HttpServletRequest request);

    ResponseData getHomeBizTypeListByCity(XtBizType bizType, HttpServletRequest request);

    ResponseData getBizList(XtBizTypeVo xtBizTypeVo, HttpServletRequest request);
}
