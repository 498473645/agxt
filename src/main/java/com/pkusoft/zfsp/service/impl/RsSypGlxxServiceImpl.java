package com.pkusoft.zfsp.service.impl;

import com.pkusoft.zfsp.mapper.RsSypGlxxMapper;
import com.pkusoft.zfsp.model.RsSypGlxx;
import com.pkusoft.zfsp.service.RsSypGlxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class RsSypGlxxServiceImpl implements RsSypGlxxService {

    @Autowired
    private RsSypGlxxMapper rsSypGlxxMapper;

    public List<RsSypGlxx> getRsSypGlxxList(RsSypGlxx rsSypGlxx) {

        Example example = new Example(RsSypGlxx.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.hasText(rsSypGlxx.getJjbh())){
            criteria.andEqualTo("jjbh",rsSypGlxx.getJjbh());
        }

        return rsSypGlxxMapper.selectByExample(example);
    }

}