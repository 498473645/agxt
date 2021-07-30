package com.pkusoft.jjpt.req;

import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class SpRecordReqParam extends Page {

    private String objid;     //主键id

    private String jjdObjid;     //接警单id


    /**
    * 获得主键id
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键id
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得接警单id
    * @return JJD_OBJID
    */
    public String getJjdObjid() {
        return this.jjdObjid;
    }

    /**
    * 设置接警单id
    * @param jjdObjid
    */
    public void setJjdObjid(String jjdObjid) {
        this.jjdObjid = jjdObjid;
    }

}
