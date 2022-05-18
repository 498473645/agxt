package com.pkusoft.bazx.service.impl;

import com.pkusoft.bazx.mapper.BdParaMapper;
import com.pkusoft.bazx.po.BdPara;
import com.pkusoft.bazx.service.BdParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class BdParaServiceImpl implements BdParaService {

    @Autowired
    private BdParaMapper bdParaMapper;

    @Override
	public BdPara getParaModel(String paraCode,String araeId) {
		Example example = new Example(BdPara.class);
	    Example.Criteria criteria = example.createCriteria();
	    //The query conditions are edited here
	    criteria.andEqualTo("objcode",paraCode);
	    criteria.andEqualTo("areaObjid",araeId);
		List<BdPara> list = bdParaMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

}
