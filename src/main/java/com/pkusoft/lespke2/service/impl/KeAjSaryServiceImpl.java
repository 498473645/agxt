package com.pkusoft.lespke2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.pkusoft.lespke2.mapper.KeAjSaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.lespke2.po.KeAjSary;
import com.pkusoft.lespke2.service.KeAjSaryService;

@Service
@Transactional
public class KeAjSaryServiceImpl implements KeAjSaryService {

    @Autowired
    private KeAjSaryMapper keAjSaryMapper;

    public List<KeAjSary> getKeAjSaryList(Map<String, String> map) {

        Example example = new Example(KeAjSary.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if (StringUtils.hasText(map.get("sfz"))){
            criteria.andLike("sarySfzhm",map.get("sfz"));
        }
        return keAjSaryMapper.selectByExample(example);
    }

}
