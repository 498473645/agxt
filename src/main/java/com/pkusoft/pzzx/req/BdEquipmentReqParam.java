package com.pkusoft.pzzx.req;

import pkubatis.common.base.Page;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class BdEquipmentReqParam extends Page {


    @Column(name = "OBJNAME")
    private String objname;     //设备名称

    @Column(name = "OBJTYPE")
    private String objtype;     //设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头

    @Column(name = "E_ID")
    private String eId;     //设备唯一标识码

    /**
    * 获得设备名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置设备名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头
    * @return OBJTYPE
    */
    public String getObjtype() {
        return this.objtype;
    }

    /**
    * 设置设备类型:05-扫码枪，03-全景摄像头，08-高拍仪摄像头，09-前置usb摄像头
    * @param objtype
    */
    public void setObjtype(String objtype) {
        this.objtype = objtype;
    }

    /**
    * 获得设备唯一标识码
    * @return E_ID
    */
    public String getEId() {
        return this.eId;
    }

    /**
    * 设置设备唯一标识码
    * @param eId
    */
    public void setEId(String eId) {
        this.eId = eId;
    }

}