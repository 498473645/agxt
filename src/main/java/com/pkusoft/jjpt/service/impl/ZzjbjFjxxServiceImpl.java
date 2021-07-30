package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.ZzjbjFjxxMapper;
import com.pkusoft.jjpt.po.ZzjbjFjxx;
import com.pkusoft.jjpt.service.ZzjbjFjxxService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ZzjbjFjxxServiceImpl implements ZzjbjFjxxService {

    @Autowired
    private ZzjbjFjxxMapper zzjbjFjxxMapper;

    public List<ZzjbjFjxx> getZzjbjFjxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(ZzjbjFjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return zzjbjFjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public List<ZzjbjFjxx> getZzjbjFjxxByBjid(String bjid) {

        Example example = new Example(ZzjbjFjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("bjid",bjid);

        return zzjbjFjxxMapper.selectByExample(example);
    }

    public int getZzjbjFjxxCount(Map<String, String> map) {

        Example example = new Example(ZzjbjFjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return zzjbjFjxxMapper.selectCountByExample(example);
    }

    public int zzjbjFjxxSave(ZzjbjFjxx zzjbjFjxx, Map<String,String> map){
        String fjbh = UUID.randomUUID().toString();
        zzjbjFjxx.setFjbh(fjbh);
        int num = zzjbjFjxxMapper.insertSelective(zzjbjFjxx);
        return num;
    }

    public int zzjbjFjxxUpdate(ZzjbjFjxx zzjbjFjxx, Map<String,String> map){
        int num = zzjbjFjxxMapper.updateByPrimaryKeySelective(zzjbjFjxx);
        return num;
    }

    public ZzjbjFjxx getZzjbjFjxx(String fjbh){
        return zzjbjFjxxMapper.selectByPrimaryKey(fjbh);
    }

    public int zzjbjFjxxDelete(String[] fjbh){
        int num = 0;
        for(int i = 0; i < fjbh.length; i ++){
        num = zzjbjFjxxMapper.deleteByPrimaryKey(fjbh[i]);
        }
        return num;
    }

}