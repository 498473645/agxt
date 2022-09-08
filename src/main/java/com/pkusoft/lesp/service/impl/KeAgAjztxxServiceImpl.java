package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.KeAgAjztxxMapper;
import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.req.KeAgAjztxxParam;
import com.pkusoft.lesp.service.KeAgAjztxxService;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysPermitService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class KeAgAjztxxServiceImpl implements KeAgAjztxxService {

    @Autowired
    private KeAgAjztxxMapper keAgAjztxxMapper;

    @Autowired
    private SysPermitService sysPermitService;

    public List<KeAgAjztxx> getKeAgAjztxxList(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser) {

        RowBounds rowBounds = new RowBounds(keAgAjztxxParam.getStart(),keAgAjztxxParam.getPageSize());
        Example example = new Example(KeAgAjztxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        example.setOrderByClause("SLSJ DESC");
        this.setConditions(criteria,keAgAjztxxParam, sysUser);
        return keAgAjztxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getKeAgAjztxxCount(KeAgAjztxxParam keAgAjztxxParam, SysUser sysUser) {

        Example example = new Example(KeAgAjztxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setConditions(criteria,keAgAjztxxParam, sysUser);
        return keAgAjztxxMapper.selectCountByExample(example);
    }

    private void setConditions(Example.Criteria criteria, KeAgAjztxxParam keAgAjztxxParam, SysUser user) {
        criteria.andIsNotNull("slsj");
        criteria.andEqualTo("zt1", "0");
        criteria.andEqualTo("ajSjzt", "0");
        if(!"admin".equals(user.getUserName())&&StringUtils.hasText(user.getCunitid())){
            criteria.andEqualTo("cstationid",user.getCunitid());
        }
        if(!"admin".equals(user.getUserName())&&StringUtils.hasText(user.getSunitid())){
            criteria.andEqualTo("sstationid",user.getSunitid());
        }
        if(!"admin".equals(user.getUserName())&&StringUtils.hasText(user.getTunitid())){
            criteria.andEqualTo("tstationid",user.getTunitid());
        }
        if(StringUtils.hasText(keAgAjztxxParam.getAjbh())){
            criteria.andLike("ajbh", '%' + keAgAjztxxParam.getAjbh() + '%');
        }
        if(StringUtils.hasText(keAgAjztxxParam.getAjmc())){
            criteria.andLike("ajmc", '%' + keAgAjztxxParam.getAjmc() + '%');
        }
        if(StringUtils.hasText(keAgAjztxxParam.getSaryxm())){
            criteria.andLike("saryxm", '%' + keAgAjztxxParam.getSaryxm() + '%');
        }
        if(StringUtils.hasText(keAgAjztxxParam.getBadwBm())){
            criteria.andLike("badwBm", '%' + keAgAjztxxParam.getBadwBm() + '%');
        }
        if(StringUtils.hasText(keAgAjztxxParam.getZbrSfzhm())){
            criteria.andLike("zbrSfzhm", '%' + keAgAjztxxParam.getZbrSfzhm() + '%');
        }
    }

    public int keAgAjztxxSave(KeAgAjztxx keAgAjztxx, Map<String,String> map){
        String ajbh = UUID.randomUUID().toString();
        keAgAjztxx.setAjbh(ajbh);
        int num = keAgAjztxxMapper.insertSelective(keAgAjztxx);
        return num;
    }

    public int keAgAjztxxUpdate(KeAgAjztxx keAgAjztxx, Map<String,String> map){
        int num = keAgAjztxxMapper.updateByPrimaryKeySelective(keAgAjztxx);
        return num;
    }

    public KeAgAjztxx getKeAgAjztxx(String ajbh){
        return keAgAjztxxMapper.selectByPrimaryKey(ajbh);
    }

    public int keAgAjztxxDelete(String ajbh){
        int num = keAgAjztxxMapper.deleteByPrimaryKey(ajbh);
        return num;
    }

}
