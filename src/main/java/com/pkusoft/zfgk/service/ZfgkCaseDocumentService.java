package com.pkusoft.zfgk.service;

import com.pkusoft.zfgk.model.ZfgkCaseDocument;
import com.pkusoft.zfgk.req.ZfgkCaseDocumentReqParam;

import java.util.List;
import java.util.Map;

/**
* @author
* @title: ZfgkCaseDocumentService
*/
public interface ZfgkCaseDocumentService {

    /**
    * 查询录取公开文书集合
    * @param map	查询条件集合
    * @return
    */
    List<ZfgkCaseDocument> getZfgkCaseDocumentList(ZfgkCaseDocumentReqParam zfgkCaseDocumentReqParam, Map<String, String> map);

    /**
    * 查询录取公开文书总数
    * @param map	查询条件集合
    * @return
    */
    int getZfgkCaseDocumentCount(ZfgkCaseDocumentReqParam zfgkCaseDocumentReqParam,Map<String, String> map);

    /**
    * 根据主键ID查看规则信息详情
    * @param docId
    * @return
    */
    ZfgkCaseDocument getZfgkCaseDocument(String docId);


}