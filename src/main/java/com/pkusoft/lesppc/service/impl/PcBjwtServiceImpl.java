package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.mapper.PcBjwtMapper;
import com.pkusoft.lesppc.service.PcBjwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

// import sun.nio.fs.MacOSXFileSystemProvider;

@Service
@Transactional
public class PcBjwtServiceImpl implements PcBjwtService {

    @Autowired
    private PcBjwtMapper pcBjwtMapper;


    /**
     * 统计涉案财物产生的问题数
     *
     * @param map
     * @return
     */
    @Override
    public int getSacwWtCount(Map<String, String> map) {
        return pcBjwtMapper.getSacwWtCount(map);
    }

    /**
     * 涉案财物督办问题
     *
     * @param map
     * @return
     */
    @Override
    public int getSacwDbCount(Map<String, String> map) {
        return pcBjwtMapper.getSacwDbCount(map);
    }

    /**
     * 涉案财物整改闭环问题
     *
     * @param map
     * @return
     */
    @Override
    public int getSacwBhCount(Map<String, String> map) {
        return pcBjwtMapper.getSacwBhCount(map);
    }

    /**
     * 涉案财物--按问题类型统计该类模型产生的问题数
     *
     * @return
     */
    @Override
    public List<YjWtVo> getWtCountByMxType() {
        return pcBjwtMapper.getWtCountByMxType();
    }

    /**
     * 涉案财物--获取按单位统计的问题排名
     *
     * @param map
     * @return
     */
    @Override
    public List<WtpmVo> getWtpmByDept(Map<String, String> map) {
        return pcBjwtMapper.getWtpmByDept(map);
    }

    /**
     * 涉案财物-获取问题总数
     *
     * @param map
     * @return
     */
    @Override
    public int getWtTotal(Map<String, String> map) {
        return pcBjwtMapper.getWtTotal(map);
    }

    /**
     * 查询未闭环问题列表
     *
     * @param map
     * @return
     */
    @Override
    public List<WtLbVo> getWtList(Map<String, String> map) {
        return pcBjwtMapper.getWtList(map);
    }


}
