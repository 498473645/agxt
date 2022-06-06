package com.pkusoft.jjpt.service;

import com.pkusoft.jjpt.po.ZfgkFlfg;
import com.pkusoft.zfgk.req.ZfgkFlfgReqParam;

import java.util.List;

/**
 * 法律法规依据
 */
public interface ZfgkFlfgService {

    /**
     * 查询法律法规依据列表
     * @param zfgkFlfgReqParam
     * @return
     */
    List<ZfgkFlfg> getZfgkFlfgList(ZfgkFlfgReqParam zfgkFlfgReqParam);

    /**
     * 查询法律法规依据数据条数
     * @param zfgkFlfgReqParam
     * @return
     */
    int getZfgkFlfgCount(ZfgkFlfgReqParam zfgkFlfgReqParam);

    /**
     * 添加法律法规依据
     * @param zfgkFlfg
     * @return
     */
    int zfgkSave(ZfgkFlfg zfgkFlfg);

    /**
     * 修改法律法规依据
     * @param zfgkFlfg
     * @return
     */
    int zfgkUpdate(ZfgkFlfg zfgkFlfg);

    /**
     * 查看法律法规依据业务数据
     * @param lawId
     * @return
     */
    ZfgkFlfg getZfgkFlfg(String lawId);

    /**
     * 删除法律法规依据业务数据
     * @param lawId
     * @return
     */
    int zfgkFlfgDelete(String lawId);
}
