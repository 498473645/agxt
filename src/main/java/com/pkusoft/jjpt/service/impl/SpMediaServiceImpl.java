package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.SpMediaMapper;
import com.pkusoft.jjpt.po.SpMedia;
import com.pkusoft.jjpt.req.SpMediaReqParam;
import com.pkusoft.jjpt.service.SpMediaService;
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
public class SpMediaServiceImpl implements SpMediaService {

    @Autowired
    private SpMediaMapper spMediaMapper;

    public List<SpMedia> getSpMediaList(SpMedia spMedia, Map<String, String> map) {

//        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(SpMedia.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        example.setOrderByClause("CREATE_TIME DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,spMedia,map);
        return spMediaMapper.selectByExample(example);
    }

    public int getSpMediaCount(SpMedia spMedia, Map<String, String> map) {

        Example example = new Example(SpMedia.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        //The query conditions are edited here
        example.setOrderByClause("CREATE_TIME DESC");
        //The query conditions are edited here
        this.setCommonCondition(criteria,spMedia,map);
        return spMediaMapper.selectCountByExample(example);
    }

    public int spMediaSave(SpMedia spMedia, Map<String,String> map){
        String objid = UUID.randomUUID().toString();
        spMedia.setObjid(objid);
        int num = spMediaMapper.insertSelective(spMedia);
        return num;
    }

    public int spMediaUpdate(SpMedia spMedia, Map<String,String> map){
        int num = spMediaMapper.updateByPrimaryKeySelective(spMedia);
        return num;
    }

    public SpMedia getSpMedia(String objid){
        return spMediaMapper.selectByPrimaryKey(objid);
    }

    public int spMediaDelete(String objid){
        int num = spMediaMapper.deleteByPrimaryKey(objid);
        return num;
    }

    public void setCommonCondition(Example.Criteria criteria, SpMedia spMedia, Map<String, String> map){
        //接警信息id
        if (StringUtils.hasText(spMedia.getJObjid())){
            criteria.andEqualTo("jObjid", spMedia.getJObjid());
        }
    }

}
