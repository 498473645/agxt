package com.pkusoft.zfgk.service;

import com.pkusoft.zfgk.model.ZfgkXzfyTemplate;
import com.pkusoft.zfgk.req.ZfgkXzfyTemplateReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: ZfgkXzfyTemplateService
*/
public interface ZfgkXzfyTemplateService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<ZfgkXzfyTemplate> getZfgkXzfyTemplateList(ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam,Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getZfgkXzfyTemplateCount(ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam,Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param xzfyTid
    * @return
    */
    ZfgkXzfyTemplate getZfgkXzfyTemplate(String xzfyTid);


}