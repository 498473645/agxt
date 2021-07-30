package com.pkusoft.zfgk.service;

import com.pkusoft.zfgk.model.ZfgkCasePublic;
import com.pkusoft.zfgk.req.ZfgkCasePublicReqParam;

import java.util.List;
import java.util.Map;


public interface ZfgkCasePublicService {

    /**
     * 查询案例集合
     * @param map	查询条件集合
     * @return
     */
    List<ZfgkCasePublic> getZfgkCasePublicList(ZfgkCasePublicReqParam zfgkCasePublicReqParam, Map<String, String> map);

    /**
     * 查询案例总数
     * @param map	查询条件集合
     * @return
     */
    int getZfgkCasePublicCount(ZfgkCasePublicReqParam zfgkCasePublicReqParam,Map<String, String> map);

    /**
     * 根据主键ID查看案例详情
     * @param docId
     * @return
     */
    ZfgkCasePublic getZfgkCasePublic(String docId);

}
