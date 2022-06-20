package com.pkusoft.zfgk.service.impl;

import com.pkusoft.usercenter.service.SysPermitService;
import com.pkusoft.zfgk.mapper.ZfgkXzfyTemplateMapper;
import com.pkusoft.zfgk.model.ZfgkXzfyTemplate;
import com.pkusoft.zfgk.req.ZfgkXzfyTemplateReqParam;
import com.pkusoft.zfgk.service.ZfgkXzfyTemplateService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ZfgkXzfyTemplateServiceImpl implements ZfgkXzfyTemplateService {

    @Autowired(required=false)
    private ZfgkXzfyTemplateMapper zfgkXzfyTemplateMapper;

    @Autowired(required=false)
    private SysPermitService sysPermitService;

    @Override
    public List<ZfgkXzfyTemplate> getZfgkXzfyTemplateList(ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam, Map<String, String> map) {
        RowBounds rowBounds = new RowBounds(zfgkXzfyTemplateReqParam.getStart(), zfgkXzfyTemplateReqParam.getPageSize());
        Example example = new Example(ZfgkXzfyTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria, zfgkXzfyTemplateReqParam);
        example.setOrderByClause("JDRQ DESC");
//        sysPermitService.setUserDataPermitsBabs(criteria,map, PermitType.PERMIT_TYPE_BABS_QUERY);
        if (0 == zfgkXzfyTemplateReqParam.getPageSize()) {
            return zfgkXzfyTemplateMapper.selectByExample(example);
        }
        return zfgkXzfyTemplateMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    @Override
    public int getZfgkXzfyTemplateCount(ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam, Map<String, String> map) {
        return 0;
    }

    @Override
    public ZfgkXzfyTemplate getZfgkXzfyTemplate(String xzfyTid) {
        return null;
    }

    public void setCommonCondition(Example.Criteria criteria, ZfgkXzfyTemplateReqParam zfgkXzfyTemplateReqParam) {
        if(StringUtils.hasText(zfgkXzfyTemplateReqParam.getFyflwsh())){
            criteria.andLike("fyflwsh","%"+zfgkXzfyTemplateReqParam.getFyflwsh()+"%");
        }
        if(StringUtils.hasText(zfgkXzfyTemplateReqParam.getCfjdsbh())){
            criteria.andLike("cfjdsbh","%"+zfgkXzfyTemplateReqParam.getCfjdsbh()+"%");
        }
        if(StringUtils.hasText(zfgkXzfyTemplateReqParam.getJddw())){
            criteria.andEqualTo("jddw",zfgkXzfyTemplateReqParam.getJddw());
        }

    }
}
