package com.pkusoft.pzzx.req;

import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class BdEquipmentPartsReqParam extends Page {

    @Column(name = "E_OBJID")
    private String eObjid;     //终端设备主键，BD_EQUIPMENT.OBJID

    @Column(name = "PARA_CODE")
    private String paraCode;     //参数编号

    @Column(name = "PARA_VALUE")
    private String paraValue;     //参数值

    public String geteObjid() {
        return eObjid;
    }

    public void seteObjid(String eObjid) {
        this.eObjid = eObjid;
    }

    public String getParaCode() {
        return paraCode;
    }

    public void setParaCode(String paraCode) {
        this.paraCode = paraCode;
    }

    public String getParaValue() {
        return paraValue;
    }

    public void setParaValue(String paraValue) {
        this.paraValue = paraValue;
    }
}