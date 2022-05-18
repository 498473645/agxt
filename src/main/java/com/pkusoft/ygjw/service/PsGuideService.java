package com.pkusoft.ygjw.service;

import com.pkusoft.ygjw.model.PsGuide;
import com.pkusoft.ygjw.model.XtBizGuide;
import com.pkusoft.ygjw.req.PsGuideReqParam;
import org.support.commons.springmvc.ResponseData;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: PsGuideService
*/
public interface PsGuideService {

    /**
    * 查询集合
    * @param map	查询条件集合
    * @return
    */
    List<PsGuide> getPsGuideList(PsGuideReqParam psGuideReqParam, Map<String, String> map);

    /**
    * 查询总数
    * @param map	查询条件集合
    * @return
    */
    int getPsGuideCount(PsGuideReqParam psGuideReqParam, Map<String, String> map);

    /**
    * 新增
    * @param psGuide	
    * @param map	用户集合
    * @return
    */
    int psGuideSave(PsGuide psGuide, Map<String, String> map);

    /**
    * 修改
    * @param psGuide	
    * @param map	用户集合
    * @return
    */
    int psGuideUpdate(PsGuide psGuide, Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param id
    * @return
    */
    PsGuide getPsGuide(String id);

    /**
    * 根据主键ID删除规则信息
    * @param id
    * @return
    */
    int psGuideDelete(String id);

    /**
     * 根据报警类型查看规则信息详情
     * @param psGuide
     * @return
     */
    PsGuide getPsGuidByType(PsGuide psGuide);


    ResponseData<XtBizGuide> getXtBizTypeByBizCode(String sxbh, String ssxq);
}