package com.pkusoft.rkxt.service;


import com.pkusoft.rkxt.model.HzywYbsxxb;
import org.support.commons.springmvc.ResponseData;

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

    ResponseData<HzywYbsxxb> getHzywYbsxxbList(String IdCard,String name);
}
