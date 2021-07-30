package com.pkusoft.jjpt.service.impl;

import com.pkusoft.jjpt.mapper.ZzjbjBjxxMapper;
import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.jjpt.po.ZzjbjBjxx;
import com.pkusoft.jjpt.req.ZzjbjBjxxReqParam;
import com.pkusoft.jjpt.res.Ybjxx;
import com.pkusoft.jjpt.service.ZzjbjBjxxService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.constants.JjptConstantCode;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional
public class ZzjbjBjxxServiceImpl implements ZzjbjBjxxService {

    @Autowired
    private ZzjbjBjxxMapper zzjbjBjxxMapper;

    public List<ZzjbjBjxx> getZzjbjBjxxList(ZzjbjBjxxReqParam zzjbjBjxxReqParam, Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(zzjbjBjxxReqParam.getStart(),zzjbjBjxxReqParam.getPageSize());
        Example example = new Example(ZzjbjBjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,zzjbjBjxxReqParam,map);

        return zzjbjBjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getZzjbjBjxxCount(ZzjbjBjxxReqParam zzjbjBjxxReqParam,Map<String, String> map) {

        Example example = new Example(ZzjbjBjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        this.setCommonCondition(criteria,zzjbjBjxxReqParam,map);

        return zzjbjBjxxMapper.selectCountByExample(example);
    }

    public void setCommonCondition(Example.Criteria criteria, ZzjbjBjxxReqParam zzjbjBjxxReqParam, Map<String, String> map){
        criteria.andEqualTo("bjdwdm",map.get("deptId"));
        //报警时间
        if( StringUtils.hasText(zzjbjBjxxReqParam.getStartBjsj()) && StringUtils.hasText(zzjbjBjxxReqParam.getEndBjsj()) ){
            //开始截止时间
            criteria.andCondition("bjsj between to_date('"+zzjbjBjxxReqParam.getStartBjsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+zzjbjBjxxReqParam.getEndBjsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        //报警电话
        if (StringUtils.hasText(zzjbjBjxxReqParam.getBjrlxdh())){
            criteria.andLike("bjrlxdh", "%" + zzjbjBjxxReqParam.getBjrlxdh() + "%");
        }
        //处理时间
        if( StringUtils.hasText(zzjbjBjxxReqParam.getStartClsj()) && StringUtils.hasText(zzjbjBjxxReqParam.getEndClsj()) ){
            //开始截止时间
            criteria.andCondition("clsj between to_date('"+zzjbjBjxxReqParam.getStartClsj()+"','yyyy-MM-dd hh24:mi:ss') and to_date('"+zzjbjBjxxReqParam.getEndClsj()+"','yyyy-MM-dd hh24:mi:ss')");
        }
        //接收状态
        if (StringUtils.hasText(zzjbjBjxxReqParam.getIfAccept())){
            criteria.andEqualTo("ifAccept", zzjbjBjxxReqParam.getIfAccept());
        }
        //处警状态
        if (StringUtils.hasText(zzjbjBjxxReqParam.getStatus())){
            criteria.andEqualTo("status", zzjbjBjxxReqParam.getStatus());
        }
    }

    public List<Ybjxx> getBigScreenYbjxxList(Map<String, String> map) {

        return zzjbjBjxxMapper.getBigScreenYbjxxList(map.get("deptId"));
    }

    public int getZzjbjBjxxCountByHandleStatus(String HandleStatus,String deptId) {

        Example example = new Example(ZzjbjBjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("bjdwdm",deptId);
        if ("handled".equals(HandleStatus)) {
//            criteria.andEqualTo("ifAccept", JjptConstantCode.YBJ_STATUS_2);
            criteria.andEqualTo("status", JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
        }

        return zzjbjBjxxMapper.selectCountByExample(example);
    }

    public List<ZzjbjBjxx> getScreenZzjbjBjxxList(Map<String, String> map, String ifAccept) {
        Map<String, ZzjbjBjxx> bjxxMap = new HashMap<>();

        Example example = new Example(ZzjbjBjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        example.setOrderByClause("BJSJ desc");
        criteria.andEqualTo("bjdwdm",map.get("deptId"));
//        criteria.andEqualTo("ifAccept",ifAccept);
        criteria.andCondition("IF_ACCEPT IN (\\'"+JjptConstantCode.YBJ_STATUS_0+"\\',\\'"+JjptConstantCode.YBJ_STATUS_1+"\\')");

        List<ZzjbjBjxx> zzjbjBjxxList = zzjbjBjxxMapper.selectByExample(example);
        for (ZzjbjBjxx zzjbjBjxx:zzjbjBjxxList){
            if (JjptConstantCode.YBJ_STATUS_0.equals(zzjbjBjxx.getIfAccept())){
                ZzjbjBjxx bjxx = new ZzjbjBjxx();
//                BeanUtils.copyProperties(zzjbjBjxx,bjxx);
                bjxx.setBjid(zzjbjBjxx.getBjid());
                bjxx.setIfAccept(JjptConstantCode.YBJ_STATUS_1);
                int num = zzjbjBjxxMapper.updateByPrimaryKeySelective(bjxx);
            }
        }
        return zzjbjBjxxList;
    }

    public int updateAcceptWechatAlarm(String bjdwdm, SpJjxx spJjxx){
        int num = 0;
        Example example = new Example(ZzjbjBjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here
        criteria.andEqualTo("bjdwdm",bjdwdm);
        criteria.andEqualTo("bjrlxdh",spJjxx.getBjdh());
//        criteria.andEqualTo("ifAccept","1");
        List<ZzjbjBjxx> zzjbjBjxxeList = zzjbjBjxxMapper.selectByExample(example);
        for (ZzjbjBjxx zzjbjBjxx:zzjbjBjxxeList){
            zzjbjBjxx.setIfAccept(JjptConstantCode.YBJ_STATUS_2);
            zzjbjBjxx.setStatus(JjptConstantCode.IF_CALL_CLOSE_STATUS_2010);
            zzjbjBjxx.setJjObjid(spJjxx.getObjid());
            zzjbjBjxx.setJjdbh(spJjxx.getJjdbh());
            zzjbjBjxx.setClsj(spJjxx.getJjsj());
            num += zzjbjBjxxMapper.updateByPrimaryKeySelective(zzjbjBjxx);
        }
        return num;
    }

    public int zzjbjBjxxSave(ZzjbjBjxx zzjbjBjxx, Map<String,String> map){
        String bjid = UUID.randomUUID().toString();
        zzjbjBjxx.setBjid(bjid);
//        zzjbjBjxx.setModifyUserName(map.get("userName"));
//        zzjbjBjxx.setModifyUserId(map.get("userId"));
//        zzjbjBjxx.setModifyTime(new Date());
        int num = zzjbjBjxxMapper.insertSelective(zzjbjBjxx);
        return num;
    }

    public int zzjbjBjxxUpdate(ZzjbjBjxx zzjbjBjxx, Map<String,String> map){
//        zzjbjBjxx.setModifyUserName(map.get("userName"));
//        zzjbjBjxx.setModifyUserId(map.get("userId"));
//        zzjbjBjxx.setModifyTime(new Date());
        int num = zzjbjBjxxMapper.updateByPrimaryKeySelective(zzjbjBjxx);
        return num;
    }

    public ZzjbjBjxx getZzjbjBjxx(String bjid){
        return zzjbjBjxxMapper.selectByPrimaryKey(bjid);
    }

    public int zzjbjBjxxDelete(String[] bjid){
        int num = 0;
        for(int i = 0; i < bjid.length; i ++){
        num = zzjbjBjxxMapper.deleteByPrimaryKey(bjid[i]);
        }
        return num;
    }

}
