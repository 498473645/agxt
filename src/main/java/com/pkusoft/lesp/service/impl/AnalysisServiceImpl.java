package com.pkusoft.lesp.service.impl;

import com.pkusoft.lesp.mapper.StatisticsMapper;
import com.pkusoft.lesp.po.StatisticsData;
import com.pkusoft.lesp.service.AnalysisService;
import com.pkusoft.usercenter.service.SysDeptService;
import com.pkusoft.usercenter.vo.DeptTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Autowired
    private SysDeptService sysDeptService;

    public Map<String,Object> getYbjData(String deptId,String deptLevel,String dataType){
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            StatisticsData curData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.DATE,-1);
            Date lastDay = hb.getTime();
            StatisticsData hbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastDay),sdfMonth.format(lastDay),sdfDay.format(lastDay));
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),sdfDay.format(lastYear));

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            StatisticsData curData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.MONTH,-1);
            Date lastMonth = hb.getTime();
            StatisticsData hbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastMonth),sdfMonth.format(lastMonth),null);
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("40".equals(dataType)){
            // 本年
            StatisticsData curData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(cur),null,null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.YEAR,-1);
            Date lastYear = hb.getTime();
            StatisticsData hbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastYear),null,null);
            // 同比
//            Calendar tb = Calendar.getInstance();
//            tb.add(Calendar.YEAR,-1);
//            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getYbjData(deptId,deptLevel,sdfYear.format(lastYear),null,null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }
        return data;
    }

    public Map<String,Object> getJjData(String deptId,String deptLevel,String dataType){
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            StatisticsData curData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.DATE,-1);
            Date lastDay = hb.getTime();
            StatisticsData hbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastDay),sdfMonth.format(lastDay),sdfDay.format(lastDay));
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),sdfDay.format(lastYear));

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            StatisticsData curData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.MONTH,-1);
            Date lastMonth = hb.getTime();
            StatisticsData hbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastMonth),sdfMonth.format(lastMonth),null);
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("40".equals(dataType)){
            // 本年
            StatisticsData curData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(cur),null,null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.YEAR,-1);
            Date lastYear = hb.getTime();
            StatisticsData hbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastYear),null,null);
            // 同比
//            Calendar tb = Calendar.getInstance();
//            tb.add(Calendar.YEAR,-1);
//            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getJjData(deptId,deptLevel,sdfYear.format(lastYear),null,null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }
        return data;
    }

    public Map<String,Object> getCjfkData(String deptId,String deptLevel,String dataType){
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            List<StatisticsData> curData = statisticsMapper.getCjfkData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            List<StatisticsData> curData = statisticsMapper.getCjfkData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            List<StatisticsData> curData = statisticsMapper.getCjfkData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    public Map<String,Object> getYbjflData(String deptId,String deptLevel,String dataType){
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            StatisticsData curData = statisticsMapper.getYbjflData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            StatisticsData curData = statisticsMapper.getYbjflData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            StatisticsData curData = statisticsMapper.getYbjflData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    public Map<String,Object> getFljqData(String deptId,String deptLevel,String dataType){
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            StatisticsData curData = statisticsMapper.getFljqData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            StatisticsData curData = statisticsMapper.getFljqData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            StatisticsData curData = statisticsMapper.getFljqData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    public Map<String,Object> getZjqsData(String deptId,String deptLevel,String dataType) {
        Map<String,Object> data = new HashMap<>();
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");

        Calendar hb = Calendar.getInstance();
        hb.add(Calendar.DATE,-1);
        Date pre1 = hb.getTime();

        hb.add(Calendar.DATE,-1);
        Date pre2 = hb.getTime();

        hb.add(Calendar.DATE,-1);
        Date pre3 = hb.getTime();

        hb.add(Calendar.DATE,-1);
        Date pre4 = hb.getTime();
        hb.add(Calendar.DATE,-1);
        Date pre5 = hb.getTime();
        hb.add(Calendar.DATE,-1);
        Date pre6 = hb.getTime();
        hb.add(Calendar.DATE,-1);
        Date pre7 = hb.getTime();
        hb.add(Calendar.DATE,-1);
        Date pre8 = hb.getTime();
        hb.add(Calendar.DATE,-1);
        Date pre9 = hb.getTime();
        dateList.add(sdf.format(pre9));
        dateList.add(sdf.format(pre8));
        dateList.add(sdf.format(pre7));
        dateList.add(sdf.format(pre6));
        dateList.add(sdf.format(pre5));
        dateList.add(sdf.format(pre4));
        dateList.add(sdf.format(pre3));
        dateList.add(sdf.format(pre2));
        dateList.add(sdf.format(pre1));
        dateList.add(sdf.format(new Date()));
        data.put("dateList",dateList);
        StatisticsData zjqsYbj = statisticsMapper.getZjqsYbjData(deptId,deptLevel);
        List<Integer> ybjData = new ArrayList();
        ybjData.add(zjqsYbj.getData10());
        ybjData.add(zjqsYbj.getData09());
        ybjData.add(zjqsYbj.getData08());
        ybjData.add(zjqsYbj.getData07());
        ybjData.add(zjqsYbj.getData06());
        ybjData.add(zjqsYbj.getData05());
        ybjData.add(zjqsYbj.getData04());
        ybjData.add(zjqsYbj.getData03());
        ybjData.add(zjqsYbj.getData02());
        ybjData.add(zjqsYbj.getData01());
        data.put("ybjData",ybjData);
        StatisticsData zjqsJj = statisticsMapper.getZjqsJjData(deptId,deptLevel);
        List<Integer> jjData = new ArrayList();
        jjData.add(zjqsJj.getData10());
        jjData.add(zjqsJj.getData09());
        jjData.add(zjqsJj.getData08());
        jjData.add(zjqsJj.getData07());
        jjData.add(zjqsJj.getData06());
        jjData.add(zjqsJj.getData05());
        jjData.add(zjqsJj.getData04());
        jjData.add(zjqsJj.getData03());
        jjData.add(zjqsJj.getData02());
        jjData.add(zjqsJj.getData01());
        data.put("jjData",jjData);
        return data;
    }

    @Override
    public Map<String, Object> getSmbaData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            StatisticsData curData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.DATE,-1);
            Date lastDay = hb.getTime();
            StatisticsData hbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastDay),sdfMonth.format(lastDay),sdfDay.format(lastDay));
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),sdfDay.format(lastYear));

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            StatisticsData curData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.MONTH,-1);
            Date lastMonth = hb.getTime();
            StatisticsData hbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastMonth),sdfMonth.format(lastMonth),null);
            // 同比
            Calendar tb = Calendar.getInstance();
            tb.add(Calendar.YEAR,-1);
            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastYear),sdfMonth.format(lastYear),null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }else if ("40".equals(dataType)){
            // 本年
            StatisticsData curData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(cur),null,null);
            // 环比
            Calendar hb = Calendar.getInstance();
            hb.add(Calendar.YEAR,-1);
            Date lastYear = hb.getTime();
            StatisticsData hbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastYear),null,null);
            // 同比
//            Calendar tb = Calendar.getInstance();
//            tb.add(Calendar.YEAR,-1);
//            Date lastYear = tb.getTime();
            StatisticsData tbData = statisticsMapper.getSmbaData(deptId,deptLevel,sdfYear.format(lastYear),null,null);

            data.put("curData",curData);
            data.put("hbData",hbData);
            data.put("tbData",tbData);
        }
        return data;
    }

    @Override
    public Map<String, Object> getYbafsdbData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            List<StatisticsData> curData = statisticsMapper.getYbafsdbData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            List<StatisticsData> curData = statisticsMapper.getYbafsdbData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            List<StatisticsData> curData = statisticsMapper.getYbafsdbData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    @Override
    public Map<String, Object> getYbaclztfxData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            List<StatisticsData> curData = statisticsMapper.getYbaclztfxData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            List<StatisticsData> curData = statisticsMapper.getYbaclztfxData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            List<StatisticsData> curData = statisticsMapper.getYbaclztfxData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    @Override
    public List<DeptTree> getBalxData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        List<StatisticsData> curData = new ArrayList<>();
        if ("10".equals(dataType)){
            // 本日
            curData = statisticsMapper.getBalxData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            curData = statisticsMapper.getBalxData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            curData = statisticsMapper.getBalxData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        List<DeptTree> deptTreeList = new ArrayList<>();
        if (!curData.isEmpty()) {
            deptTreeList = sysDeptService.getSysDeptTreeList(deptId,deptLevel,curData);
        }
        return deptTreeList;
    }

    @Override
    public Map<String, Object> getPyzbData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            List<StatisticsData> curData = statisticsMapper.getPyzbData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            List<StatisticsData> curData = statisticsMapper.getPyzbData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            List<StatisticsData> curData = statisticsMapper.getPyzbData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }

    @Override
    public Map<String, Object> getPymydData(String deptId, String deptLevel, String dataType) {
        Map<String,Object> data = new HashMap<>();
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        Date cur = new Date();
        //10-日，20-周，30-月，40-年
        if ("10".equals(dataType)){
            // 本日
            List<StatisticsData> curData = statisticsMapper.getPymydData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),sdfDay.format(cur));
            data.put("curData",curData);
        }else if ("20".equals(dataType)){
            // 本周

        }else if ("30".equals(dataType)){
            // 本月
            List<StatisticsData> curData = statisticsMapper.getPymydData(deptId,deptLevel,sdfYear.format(cur),sdfMonth.format(cur),null);
            data.put("curData",curData);
        }else if ("40".equals(dataType)){
            // 本年
            List<StatisticsData> curData = statisticsMapper.getPymydData(deptId,deptLevel,sdfYear.format(cur),null,null);
            data.put("curData",curData);
        }
        return data;
    }
}
