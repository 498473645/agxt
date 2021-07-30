package com.pkusoft.jjpt.res;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Ybjxx {

    private String objid;     //对应预警表或电话表的主键

    private String bjdh;     //电话

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm",timezone = "GMT+8")
    private Date bjsj;     //报警时间

    private String bjlx;   // 报警方式：1001-微信预报警，1003-电话报警

    public String getObjid() {
        return objid;
    }

    public void setObjid(String objid) {
        this.objid = objid;
    }

    public String getBjdh() {
        return bjdh;
    }

    public void setBjdh(String bjdh) {
        this.bjdh = bjdh;
    }

    public Date getBjsj() {
        return bjsj;
    }

    public void setBjsj(Date bjsj) {
        this.bjsj = bjsj;
    }

    public String getBjlx() {
        return bjlx;
    }

    public void setBjlx(String bjlx) {
        this.bjlx = bjlx;
    }
}