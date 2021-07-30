package com.pkusoft.lesppc.service.impl;

import com.pkusoft.lesppc.service.SplitScreenService;
import com.pkusoft.lesppc.req.*;
import com.pkusoft.lesppc.service.PcBjwtService;
import com.pkusoft.lesppc.service.PcWtmxService;
import com.pkusoft.lesppc.service.PcYjwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分屏服务接口
 *
 * @author
 */
@Service
@Transactional
public class SplitScreenServiceImpl implements SplitScreenService {

    /**
     * 问题模型服务
     */
    @Autowired
    private PcWtmxService pcWtmxService;

    /**
     * 预警问题
     */
    @Autowired
    private PcYjwtService pcYjwtService;

    /**
     * 报警问题
     */
    @Autowired
    private PcBjwtService pcBjwtService;

    //@Autowired
    //private TjYjbjViewService tjYjbjViewService;


    /**
     * 查询问题模型数量
     *
     * @param map
     * @return
     */
    @Override
    public ModelCountVo getModelCount(Map<String, String> map) {
        return pcWtmxService.getModelCount("LESP_PCW");
    }

    /**
     * 统计问题状态数量
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Integer> getProblemStatusCount(Map<String, String> map) {
        //预警
        int yj = pcYjwtService.getSaCwYjCount();
        //问题
        int wt = pcBjwtService.getSacwWtCount(map);
        //督办
        int db = pcBjwtService.getSacwDbCount(map);
        //闭环
        int bh = pcBjwtService.getSacwBhCount(map);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("yj", yj);
        resultMap.put("wt", wt);
        resultMap.put("db", db);
        resultMap.put("bh", bh);
        return resultMap;
    }

    /**
     * 统计问题状态数量
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> getYjWtListByMxType(Map<String, String> map) {
        Map<String, Object> resultMap = new HashMap<>();

        List<YjWtVo> yjList = pcYjwtService.getYjCountByMxType();
        List<YjWtVo> wtList = pcBjwtService.getWtCountByMxType();
        resultMap.put("yjList", yjList);
        resultMap.put("wtList", wtList);

        return resultMap;
    }

    /**
     * 涉案财物--获取按单位统计的问题排名
     *
     * @param map
     * @return
     */
    @Override
    public List<WtpmVo> getWtpmByDept(Map<String, String> map) {
        return pcBjwtService.getWtpmByDept(map);
    }

    /**
     * 涉案财物-获取问题总数
     *
     * @param map
     * @return
     */
    @Override
    public int getWtTotal(Map<String, String> map) {
        return pcBjwtService.getWtTotal(map);
    }

    /**
     * 查询最新预警问题列表
     *
     * @param map
     * @return
     */
    @Override
    public List<WtLbVo> getYjList(Map<String, String> map) {
        return pcYjwtService.getYjList(map);
    }

    /**
     * 查询未闭环问题列表
     *
     * @param map
     * @return
     */
    @Override
    public List<WtLbVo> getWtList(Map<String, String> map) {
        return pcBjwtService.getWtList(map);
    }


    /**
     * 涉案财物报警和预警问题分析
     *
     * @param paramMap
     * @return
     */
    //@Override
    //public Map<String, Object> getSacwYjBjWtCountForMonth(Map<String, String> paramMap) {
    //    String year = DateTimeUtils.getYear();
    //    List<String> stringList = getYearMonthStrDate(year);
    //    Collections.sort(stringList);
    //    paramMap.put("year", year);
    //    List<StatisticalForMonthVo> yjbjwt = tjYjbjViewService.getSacwYjBjWtCountForMonth(paramMap);
    //
    //    Map<String, Object> resultMap = new HashMap<>();
    //    for (String month : stringList) {
    //        int total = 0;
    //        for (int i = 0; i < yjbjwt.size(); i++) {
    //            if (month.equals(yjbjwt.get(i).getMonths())) {
    //                total=yjbjwt.get(i).getCount();
    //            }
    //        }
    //        resultMap.put(month, total);
    //    }
    //    return resultMap;
    //}


    /**
     * 获取当年12个月 字符串日期
     *
     * @return
     */
    private List<String> getYearMonthStrDate(String year) {

        List<String> stringList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            if (i < 10) {
                stringList.add(year + "0" + i);
            } else {
                stringList.add(year + i);
            }
        }
        return stringList;
    }


}
