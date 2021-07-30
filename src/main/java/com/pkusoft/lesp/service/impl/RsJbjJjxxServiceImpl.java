package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.RsJbjJjxxMapper;
import com.pkusoft.lesp.mapper.StatisticsMapper;
import com.pkusoft.lesp.po.RsJbjJjxx;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.lesp.service.RsJbjJjxxService;
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
public class RsJbjJjxxServiceImpl implements RsJbjJjxxService {

    @Autowired
    private RsJbjJjxxMapper rsJbjJjxxMapper;

    @Autowired
    private StatisticsMapper statisticsMapper;

    public StatisticsData getMonthlyJjData(String deptId, String year, String month) {
        return statisticsMapper.getMonthlyJjData(deptId, year, month);
    }

    public StatisticsData getMonthlyFljqData(String deptId, String year, String month) {
        return statisticsMapper.getMonthlyFljqData(deptId, year, month);
    }

//    public Map<String,Object> getZjqsData(String deptId) {
//        Map<String,Object> data = new HashMap<>();
//        List<String> dateList = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
//
//        Calendar hb = Calendar.getInstance();
//        hb.add(Calendar.DATE,-1);
//        Date pre1 = hb.getTime();
//
//        hb.add(Calendar.DATE,-1);
//        Date pre2 = hb.getTime();
//
//        hb.add(Calendar.DATE,-1);
//        Date pre3 = hb.getTime();
//
//        hb.add(Calendar.DATE,-1);
//        Date pre4 = hb.getTime();
//        hb.add(Calendar.DATE,-1);
//        Date pre5 = hb.getTime();
//        hb.add(Calendar.DATE,-1);
//        Date pre6 = hb.getTime();
//        hb.add(Calendar.DATE,-1);
//        Date pre7 = hb.getTime();
//        hb.add(Calendar.DATE,-1);
//        Date pre8 = hb.getTime();
//        hb.add(Calendar.DATE,-1);
//        Date pre9 = hb.getTime();
//        dateList.add(sdf.format(pre9));
//        dateList.add(sdf.format(pre8));
//        dateList.add(sdf.format(pre7));
//        dateList.add(sdf.format(pre6));
//        dateList.add(sdf.format(pre5));
//        dateList.add(sdf.format(pre4));
//        dateList.add(sdf.format(pre3));
//        dateList.add(sdf.format(pre2));
//        dateList.add(sdf.format(pre1));
//        dateList.add(sdf.format(new Date()));
//        data.put("dateList",dateList);
//        StatisticsData zjqsYbj = statisticsMapper.getZjqsYbjData(deptId);
//        List<Integer> ybjData = new ArrayList();
//        ybjData.add(zjqsYbj.getData10());
//        ybjData.add(zjqsYbj.getData09());
//        ybjData.add(zjqsYbj.getData08());
//        ybjData.add(zjqsYbj.getData07());
//        ybjData.add(zjqsYbj.getData06());
//        ybjData.add(zjqsYbj.getData05());
//        ybjData.add(zjqsYbj.getData04());
//        ybjData.add(zjqsYbj.getData03());
//        ybjData.add(zjqsYbj.getData02());
//        ybjData.add(zjqsYbj.getData01());
//        data.put("ybjData",ybjData);
//        StatisticsData zjqsJj = statisticsMapper.getZjqsJjData(deptId);
//        List<Integer> jjData = new ArrayList();
//        jjData.add(zjqsJj.getData10());
//        jjData.add(zjqsJj.getData09());
//        jjData.add(zjqsJj.getData08());
//        jjData.add(zjqsJj.getData07());
//        jjData.add(zjqsJj.getData06());
//        jjData.add(zjqsJj.getData05());
//        jjData.add(zjqsJj.getData04());
//        jjData.add(zjqsJj.getData03());
//        jjData.add(zjqsJj.getData02());
//        jjData.add(zjqsJj.getData01());
//        data.put("jjData",jjData);
//        return data;
//    }

    public List<RsJbjJjxx> getRsJbjJjxxList(Map<String, String> map) {

        RowBounds rowBounds = new RowBounds(Integer.parseInt(map.get("start")),Integer.parseInt(map.get("pageSize")));
        Example example = new Example(RsJbjJjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjJjxxMapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    public int getRsJbjJjxxCount(Map<String, String> map) {

        Example example = new Example(RsJbjJjxx.class);
        Example.Criteria criteria = example.createCriteria();
        //The query conditions are edited here

        return rsJbjJjxxMapper.selectCountByExample(example);
    }

    public int rsJbjJjxxSave(RsJbjJjxx rsJbjJjxx, Map<String,String> map){
        String jjdbh = UUID.randomUUID().toString();
        rsJbjJjxx.setJjdbh(jjdbh);
//        rsJbjJjxx.setModifyUserName(map.get("userName"));
//        rsJbjJjxx.setModifyUserId(map.get("userId"));
//        rsJbjJjxx.setModifyTime(new Date());
        int num = rsJbjJjxxMapper.insertSelective(rsJbjJjxx);
        return num;
    }

    public int rsJbjJjxxUpdate(RsJbjJjxx rsJbjJjxx, Map<String,String> map){
//        rsJbjJjxx.setModifyUserName(map.get("userName"));
//        rsJbjJjxx.setModifyUserId(map.get("userId"));
//        rsJbjJjxx.setModifyTime(new Date());
        int num = rsJbjJjxxMapper.updateByPrimaryKeySelective(rsJbjJjxx);
        return num;
    }

    public RsJbjJjxx getRsJbjJjxx(String jjdbh){
        return rsJbjJjxxMapper.selectByPrimaryKey(jjdbh);
    }

    public int rsJbjJjxxDelete(String[] jjdbh){
        int num = 0;
        for(int i = 0; i < jjdbh.length; i ++){
        num = rsJbjJjxxMapper.deleteByPrimaryKey(jjdbh[i]);
        }
        return num;
    }

}