package com.pkusoft.lespke2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.lespke2.po.KeAjWsnr;
import com.pkusoft.lespke2.service.KeAjWsnrService;
import com.pkusoft.lespke2.mapper.KeAjWsnrMapper;

@Service
@Transactional
public class KeAjWsnrServiceImpl implements KeAjWsnrService {

    @Autowired
    private KeAjWsnrMapper keAjWsnrMapper;

    public List<KeAjWsnr> getKeAjWsnrList(Map<String, String> map) {

        Example example = new Example(KeAjWsnr.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        if(StringUtils.hasText(map.get("ajbh"))) {
            criteria.andEqualTo("ajbh", map.get("ajbh"));
        }
        if(StringUtils.hasText(map.get("wsbt"))) {
            criteria.andEqualTo("wsbt", map.get("wsbt"));
        }
        criteria.andEqualTo("flwsqzbs","1");//默认查询为1的
        criteria.andCondition("CZBS < '3'");
        return keAjWsnrMapper.selectByExample(example);
    }

    public int getKeAjWsnrCount(Map<String, String> map) {

        Example example = new Example(KeAjWsnr.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return keAjWsnrMapper.selectCountByExample(example);
    }

    public int keAjWsnrSave(KeAjWsnr keAjWsnr, Map<String,String> map){
        String flwsbh = UUID.randomUUID().toString();
        keAjWsnr.setFlwsbh(flwsbh);
        int num = keAjWsnrMapper.insertSelective(keAjWsnr);
        return num;
    }

    public int keAjWsnrUpdate(KeAjWsnr keAjWsnr, Map<String,String> map){
        int num = keAjWsnrMapper.updateByPrimaryKeySelective(keAjWsnr);
        return num;
    }

    public KeAjWsnr getKeAjWsnr(String flwsbh){
        return keAjWsnrMapper.selectByPrimaryKey(flwsbh);
    }

    public int keAjWsnrDelete(String flwsbh){
        int num = keAjWsnrMapper.deleteByPrimaryKey(flwsbh);
        return num;
    }

}
