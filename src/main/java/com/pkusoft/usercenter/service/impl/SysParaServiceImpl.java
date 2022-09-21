package com.pkusoft.usercenter.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import com.pkusoft.usercenter.po.SysPara;
import com.pkusoft.usercenter.service.SysParaService;
import com.pkusoft.usercenter.mapper.SysParaMapper;

@Service
@Transactional
public class SysParaServiceImpl implements SysParaService {

    @Autowired
    private SysParaMapper sysParaMapper;

    public List<SysPara> getSysParaList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysPara.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysParaMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getSysParaCount(Map<String, String> map) {

        Example example = new Example(SysPara.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return sysParaMapper.selectCountByExample(example);
    }

    public int sysParaSave(SysPara sysPara, Map<String,String> map){
        String paraCode = UUID.randomUUID().toString();
        sysPara.setParaCode(paraCode);
        int num = sysParaMapper.insertSelective(sysPara);
        return num;
    }

    public int sysParaUpdate(SysPara sysPara, Map<String,String> map){
        int num = sysParaMapper.updateByPrimaryKeySelective(sysPara);
        return num;
    }

    public SysPara getSysPara(String paraCode){
        return sysParaMapper.selectByPrimaryKey(paraCode);
    }

    public int sysParaDelete(String paraCode){
        int num = sysParaMapper.deleteByPrimaryKey(paraCode);
        return num;
    }

    //查询参数
    @Override
    public SysPara getSysParaByParaCode(String paraCode) {
        SysPara sysPara=sysParaMapper.selectByPrimaryKey(paraCode);
        return sysPara;
    }
}
