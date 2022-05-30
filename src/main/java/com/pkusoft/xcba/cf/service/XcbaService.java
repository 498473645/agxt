package com.pkusoft.xcba.cf.service;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.zfsp.model.RsSypGlxx;

import java.util.List;

/**
* @author
* @title: XcbaService
*/
public interface XcbaService {

    /**
    * 获取jcjxxXml
    * @param spJjxx  接警信息表
    * @return
    */
    String getJcjxxXml(SpJjxx spJjxx);

}
