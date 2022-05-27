package com.pkusoft.zfsp.service;

import com.pkusoft.zfsp.model.RsSypGlxx;

import java.util.List;

/**
* @author
* @title: XcbaService
*/
public interface RsSypGlxxService {

    /**
    * 查询集合
    * @param rsSypGlxx	查询条件集合
    * @return
    */
    List<RsSypGlxx> getRsSypGlxxList(RsSypGlxx rsSypGlxx);

}
