package com.pkusoft.lespke2.service.impl;

import java.util.*;

import com.pkusoft.lespke2.po.KeAjSary;
import com.pkusoft.lespke2.service.KeAjSaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.lespke2.po.KeAjxx;
import com.pkusoft.lespke2.service.KeAjxxService;
import com.pkusoft.lespke2.mapper.KeAjxxMapper;

@Service
@Transactional
public class KeAjxxServiceImpl implements KeAjxxService {

    @Autowired
    private KeAjxxMapper keAjxxMapper;

    @Autowired
    private KeAjSaryService keAjSaryService;


    public List<KeAjxx> getKeAjxxList(Map<String, String> map) {

        Example example = new Example(KeAjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjxxMapper.selectByExample(example);
    }

    @Override
    public List<KeAjxx> getKeAjxxListBySfz(Map<String, String> map) {
        //根据身份证查询涉案人员信息
        List<KeAjSary> saryList = keAjSaryService.getKeAjSaryList(map);
        if(null == saryList|| saryList.size()<1){
            return null;
        }
        //根据涉案人员信息获取案件编号
        List<String> ajIds = new ArrayList<>();
        for (KeAjSary a : saryList){
            ajIds.add(a.getAjbh());
        }
        //根据案件编号查询案件列表
        Example example = new Example(KeAjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andIn("ajbh",ajIds);
        return keAjxxMapper.selectByExample(example);
    }
}
