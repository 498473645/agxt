package com.pkusoft.agxt.service.impl;

import com.pkusoft.agxt.mapper.CabTrackMapper;
import com.pkusoft.agxt.model.CabTrack;
import com.pkusoft.agxt.service.CabTrackService;
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
public class CabTrackServiceImpl implements CabTrackService {

    @Autowired
    private CabTrackMapper cabTrackMapper;

    public List<CabTrack> getCabTrackList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(CabTrack.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return cabTrackMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getCabTrackCount(Map<String, String> map) {

        Example example = new Example(CabTrack.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return cabTrackMapper.selectCountByExample(example);
    }

    public int cabTrackSave(CabTrack cabTrack, Map<String,String> map){
        String id = UUID.randomUUID().toString();
        cabTrack.setId(id);
        int num = cabTrackMapper.insertSelective(cabTrack);
        return num;
    }

    public int cabTrackUpdate(CabTrack cabTrack, Map<String,String> map){
        int num = cabTrackMapper.updateByPrimaryKeySelective(cabTrack);
        return num;
    }

    public CabTrack getCabTrack(String id){
        return cabTrackMapper.selectByPrimaryKey(id);
    }

    public int cabTrackDelete(String id){
        int num = cabTrackMapper.deleteByPrimaryKey(id);
        return num;
    }

    @Override
    public void insertCabTrack(CabTrack jobCabTrack) {
        cabTrackMapper.insertSelective(jobCabTrack);
    }

}
