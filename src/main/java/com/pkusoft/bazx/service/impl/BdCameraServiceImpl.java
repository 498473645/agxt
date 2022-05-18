package com.pkusoft.bazx.service.impl;

import com.pkusoft.bazx.mapper.BdCameraMapper;
import com.pkusoft.bazx.po.BdCamera;
import com.pkusoft.bazx.service.BdCameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class BdCameraServiceImpl implements BdCameraService {

	@Autowired
	private BdCameraMapper bdCameraMapper;

	@Override
	public List<BdCamera> getBdCameraByExample(Example example) {

		return bdCameraMapper.selectByExample(example);
	}

}