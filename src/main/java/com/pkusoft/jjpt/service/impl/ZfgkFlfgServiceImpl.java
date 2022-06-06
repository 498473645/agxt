package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.ZfgkFlfgMapper;
import com.pkusoft.jjpt.po.ZfgkFlfg;
import com.pkusoft.zfgk.req.ZfgkFlfgReqParam;
import com.pkusoft.jjpt.service.ZfgkFlfgService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ZfgkFlfgServiceImpl implements ZfgkFlfgService {

    @Autowired
    private ZfgkFlfgMapper zfgkFlfgMapper;

    /**
     * 查询法律法规依据列表
     * @param zfgkFlfgReqParam
     * @return
     */
    @Override
    public List<ZfgkFlfg> getZfgkFlfgList(ZfgkFlfgReqParam zfgkFlfgReqParam) {
        RowBounds rowBounds = new RowBounds(zfgkFlfgReqParam.getStart(), zfgkFlfgReqParam.getPageSize());
        Example example = new Example(ZfgkFlfg.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria, zfgkFlfgReqParam);
        example.setOrderByClause("ENACT_DATE DESC");
        if (0 == zfgkFlfgReqParam.getPageSize()) {
            return zfgkFlfgMapper.selectByExample(example);
        }
        return zfgkFlfgMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    /**
     * 查询法律法规依据数据条数
     * @param zfgkFlfgReqParam
     * @return
     */
    @Override
    public int getZfgkFlfgCount(ZfgkFlfgReqParam zfgkFlfgReqParam) {
        Example example = new Example(ZfgkFlfg.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria, zfgkFlfgReqParam);
        example.setOrderByClause("ENACT_DATE DESC");
        return zfgkFlfgMapper.selectCountByExample(example);
    }

    /**
     * 添加法律法规依据
     * @param zfgkFlfg
     * @return
     */
    @Override
    public int zfgkSave(ZfgkFlfg zfgkFlfg) {
        if (!StringUtils.hasText(zfgkFlfg.getLawId())){
            String id = UUID.randomUUID().toString();
            zfgkFlfg.setLawId(id);
        }
        zfgkFlfg.setSfgk("1");
        Date date = new Date();
        zfgkFlfg.setEnactDate(date);
        zfgkFlfg.setEffectiveDate(date);
        zfgkFlfg.setCollectDate(date);

        int num = zfgkFlfgMapper.insertSelective(zfgkFlfg);
        return num;
    }

    /**
     * 修改法律法规依据
     * @param zfgkFlfg
     * @return
     */
    @Override
    public int zfgkUpdate(ZfgkFlfg zfgkFlfg) {
        int num = zfgkFlfgMapper.updateByPrimaryKeySelective(zfgkFlfg);
        return num;
    }

    /**
     * 查看法律法规依据业务数据
     * @param lawId
     * @return
     */
    @Override
    public ZfgkFlfg getZfgkFlfg(String lawId) {
        return zfgkFlfgMapper.selectByPrimaryKey(lawId);
    }

    /**
     * 删除法律法规依据业务数据
     * @param lawId
     * @return
     */
    @Override
    public int zfgkFlfgDelete(String lawId) {
        int num = zfgkFlfgMapper.deleteByPrimaryKey(lawId);
        return num;
    }

    public void setCommonCondition(Example.Criteria criteria, ZfgkFlfgReqParam zfgkFlfgReqParam) {
        if(StringUtils.hasText(zfgkFlfgReqParam.getLawTitle())){
            criteria.andLike("lawTitle","%"+zfgkFlfgReqParam.getLawTitle()+"%");
        }

    }
}
