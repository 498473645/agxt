package com.pkusoft.lesppc.req;

/**
 * 按问题类型统计数量Vo对象
 */
public class YjWtVo {

    /**
     * 问题模型编号
     */
    private String bh;

    /**
     * 问题模型名称
     */
    private String mc;

    /**
     * 统计数量
     */
    private int total;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
