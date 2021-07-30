package com.pkusoft.lesppc.mapper;

import com.pkusoft.lesppc.model.PcWtmx;
import tk.mybatis.mapper.common.Mapper;

public interface PcWtmxMapper extends Mapper<PcWtmx> {

    /**
     * 获取问题模型数
     * @param wtLyBh
     * @return
     */
    int  getWtmxs(String wtLyBh);

    /**
     * 获取预警模型数
     * @param wtLyBh
     * @return
     */
    int  getYjmxs(String wtLyBh);

    /**
     * 获取接报警预警模型数
     * @param wtLyBh
     * @return
     */
    int  getJbjWtmxs(String wtLyBh);

}
