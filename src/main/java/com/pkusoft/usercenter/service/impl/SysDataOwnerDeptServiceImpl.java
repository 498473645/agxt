package com.pkusoft.usercenter.service.impl;

import com.pkusoft.usercenter.mapper.SysDataOwnerDeptMapper;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
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
public class SysDataOwnerDeptServiceImpl implements SysDataOwnerDeptService {

    @Autowired
    private SysDataOwnerDeptMapper sysDataOwnerDeptMapper;

    @Override
    public List<SysDataOwnerDept> getSysDataOwnerDeptList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SysDataOwnerDept.class);
        Example.Criteria criteria = example.createCriteria();

        return sysDataOwnerDeptMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    public int getSysDataOwnerDeptCount(Map<String, String> map) {

        Example example = new Example(SysDataOwnerDept.class);
        Example.Criteria criteria = example.createCriteria();

        return sysDataOwnerDeptMapper.selectCountByExample(example);
    }

    @Override
    public int sysDataOwnerDeptSave(SysDataOwnerDept sysDataOwnerDept, Map<String,String> map){
        String dataOwnerDeptId = UUID.randomUUID().toString();
        sysDataOwnerDept.setDataOwnerDeptId(dataOwnerDeptId);
        int num = sysDataOwnerDeptMapper.insertSelective(sysDataOwnerDept);
        return num;
    }

    @Override
    public int sysDataOwnerDeptUpdate(SysDataOwnerDept sysDataOwnerDept, Map<String,String> map){
        int num = sysDataOwnerDeptMapper.updateByPrimaryKeySelective(sysDataOwnerDept);
        return num;
    }

    @Override
    public SysDataOwnerDept getSysDataOwnerDept(String dataOwnerDeptId){
        return sysDataOwnerDeptMapper.selectByPrimaryKey(dataOwnerDeptId);
    }

    @Override
    public int sysDataOwnerDeptDelete(String[] dataOwnerDeptId){
        int num = 0;
        for(int i = 0; i < dataOwnerDeptId.length; i ++){
        num = sysDataOwnerDeptMapper.deleteByPrimaryKey(dataOwnerDeptId[i]);
        }
        return num;
    }

    @Override
    public SysDataOwnerDept selectByDeptId(String deptId) {
        Example example = new Example(SysDataOwnerDept.class);
        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("deptId", deptId);
        List<SysDataOwnerDept> list = sysDataOwnerDeptMapper.selectByExample(example);
        if(list != null && list.size() > 0){
            return list.get(0);
        }else{
            return new SysDataOwnerDept();
        }
    }

}
