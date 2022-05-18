package com.pkusoft.bazx.service;

import com.pkusoft.bazx.po.BdCamera;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


public interface BdCameraService {

	/**
	 * 根据Example查询摄像头信息
	 * 
	 * @param example
	 * @return
	 */
	List<BdCamera> getBdCameraByExample(Example example);

}