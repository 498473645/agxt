package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.mapper.PcWtmxMapper;
import com.pkusoft.lesppc.model.PcBjwt;
import com.pkusoft.lesppc.model.PcWtmx;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.mapper.PcBjwtMapper;
import com.pkusoft.lesppc.service.PcBjwtService;
import com.pkusoft.lesppc.service.PcWtmxService;
import com.pkusoft.usercenter.po.SysDataOwnerDept;
import com.pkusoft.usercenter.service.SysDataOwnerDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

// import sun.nio.fs.MacOSXFileSystemProvider;

@Service
@Transactional
public class PcBjwtServiceImpl implements PcBjwtService {

    @Autowired
    private PcBjwtMapper pcBjwtMapper;

    @Autowired
    private PcWtmxMapper pcWtmxMapper;

    @Autowired
    private SysDataOwnerDeptService sysDataOwnerDeptService;

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

    @Override
    public int pcBjwtSave(PcBjwt pcBjwt, String wtmxbh, Map<String, String> user) {
        PcWtmx pcWtmx = new PcWtmx();
        pcWtmx.setWtmxBh(wtmxbh);
        PcWtmx newPcWtmx = pcWtmxMapper.selectOne(pcWtmx);

        if (newPcWtmx!=null) {
            pcBjwt.setWtmxBh(newPcWtmx.getWtmxBh());
            pcBjwt.setWtmxMc(newPcWtmx.getWtmxMc());
            pcBjwt.setWtlyBh(newPcWtmx.getWtlyBh());
            pcBjwt.setWtlyMc(newPcWtmx.getWtlyMc());
        }
        pcBjwt.setCreatedUserId(user.get("userId"));
        pcBjwt.setCreatedDate(new Date());
        pcBjwt.setCreatedDeptId(user.get("deptId"));
        pcBjwt.setCreatedDeptName(user.get("deptName"));
        pcBjwt.setYwdwBm(user.get("deptId"));
        pcBjwt.setYwdwMc(user.get("deptName"));

        SysDataOwnerDept sysDataOwnerDept = sysDataOwnerDeptService.selectByDeptId(user.get("deptId"));
        //获取归属单位
        if (sysDataOwnerDept != null) {
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept1())) {
                pcBjwt.setGaOwnerDept1(sysDataOwnerDept.getOwnerDept1());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept2())) {
                pcBjwt.setGaOwnerDept2(sysDataOwnerDept.getOwnerDept2());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept3())) {
                pcBjwt.setGaOwnerDept3(sysDataOwnerDept.getOwnerDept3());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept4())) {
                pcBjwt.setGaOwnerDept4(sysDataOwnerDept.getOwnerDept4());
            }
            if (StringUtils.hasText(sysDataOwnerDept.getOwnerDept5())) {
                pcBjwt.setGaOwnerDept5(sysDataOwnerDept.getOwnerDept5());
            }
        }

        int num = pcBjwtMapper.insertSelective(pcBjwt);
        return num;
    }


}
