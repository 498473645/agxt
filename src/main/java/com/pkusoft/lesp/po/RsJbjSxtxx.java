package com.pkusoft.lesp.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "RS_JBJ_SXTXX")
public class RsJbjSxtxx {

    @Id
    @Column(name = "OBJID")
    private String objid;     //主键ID

    @Column(name = "OBJNAME")
    private String objname;     //摄像头名称

    @Column(name = "RTMP")
    private String rtmp;     //RTMP流

    @Column(name = "ORG_CODE")
    private String orgCode;     //所属单位编码

    @Column(name = "ORG_NAME")
    private String orgName;     //所属单位名称

    @Column(name = "STATUS")
    private String status;     //状态

    @Column(name = "GXSJ")
    private Date gxsj;     //更新时间

    @Column(name = "CQSJ")
    private Date cqsj;     //抽取时间

    @Column(name = "GA_OWNER_DEPT_1")
    private String gaOwnerDept1;     //公安一级归属单位

    @Column(name = "GA_OWNER_DEPT_2")
    private String gaOwnerDept2;     //公安二级归属单位

    @Column(name = "GA_OWNER_DEPT_3")
    private String gaOwnerDept3;     //公安三级归属单位

    @Column(name = "GA_OWNER_DEPT_4")
    private String gaOwnerDept4;     //公安四级归属单位

    @Column(name = "GA_OWNER_DEPT_5")
    private String gaOwnerDept5;     //公安五级归属单位

    /**
     * 设备号/通道号 或 设备号|通道号|rtsp://admin:admin123456@127.0.0.1
     */
    @Column(name = "DEVICE_ID")
    private String deviceId;

    /**
     * 流媒体服务IP
     */
    @Column(name = "SERVICE_IP")
    private String serviceIp;

    /**
     * 秘钥
     */
    @Column(name = "SECRET")
    private String secret;

    /**
     * 流媒体服务器版本（3.0或4.0）
     */
    @Column(name = "VERSION")
    private String version;

    /**
     * 是否支持RTSP协议（非国标） 1.非国标
     */
    @Column(name = "IS_RTSP")
    private String isRtsp;

    /**
     * 区分办案办事 0 办案  1 办事
     */
    @Column(name = "IS_BABS")
    private String isBabs;

    public String getIsBabs() {
        return isBabs;
    }

    public void setIsBabs(String isBabs) {
        this.isBabs = isBabs;
    }

    /**
    * 获得主键ID
    * @return OBJID
    */
    public String getObjid() {
        return this.objid;
    }

    /**
    * 设置主键ID
    * @param objid
    */
    public void setObjid(String objid) {
        this.objid = objid;
    }

    /**
    * 获得摄像头名称
    * @return OBJNAME
    */
    public String getObjname() {
        return this.objname;
    }

    /**
    * 设置摄像头名称
    * @param objname
    */
    public void setObjname(String objname) {
        this.objname = objname;
    }

    /**
    * 获得RTMP流
    * @return RTMP
    */
    public String getRtmp() {
        return this.rtmp;
    }

    /**
    * 设置RTMP流
    * @param rtmp
    */
    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    /**
    * 获得所属单位编码
    * @return ORG_CODE
    */
    public String getOrgCode() {
        return this.orgCode;
    }

    /**
    * 设置所属单位编码
    * @param orgCode
    */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    /**
    * 获得所属单位名称
    * @return ORG_NAME
    */
    public String getOrgName() {
        return this.orgName;
    }

    /**
    * 设置所属单位名称
    * @param orgName
    */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
    * 获得状态
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置状态
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得更新时间
    * @return GXSJ
    */
    public Date getGxsj() {
        return this.gxsj;
    }

    /**
    * 设置更新时间
    * @param gxsj
    */
    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    /**
    * 获得抽取时间
    * @return CQSJ
    */
    public Date getCqsj() {
        return this.cqsj;
    }

    /**
    * 设置抽取时间
    * @param cqsj
    */
    public void setCqsj(Date cqsj) {
        this.cqsj = cqsj;
    }

    /**
    * 获得公安一级归属单位
    * @return GA_OWNER_DEPT_1
    */
    public String getGaOwnerDept1() {
        return this.gaOwnerDept1;
    }

    /**
    * 设置公安一级归属单位
    * @param gaOwnerDept1
    */
    public void setGaOwnerDept1(String gaOwnerDept1) {
        this.gaOwnerDept1 = gaOwnerDept1;
    }

    /**
    * 获得公安二级归属单位
    * @return GA_OWNER_DEPT_2
    */
    public String getGaOwnerDept2() {
        return this.gaOwnerDept2;
    }

    /**
    * 设置公安二级归属单位
    * @param gaOwnerDept2
    */
    public void setGaOwnerDept2(String gaOwnerDept2) {
        this.gaOwnerDept2 = gaOwnerDept2;
    }

    /**
    * 获得公安三级归属单位
    * @return GA_OWNER_DEPT_3
    */
    public String getGaOwnerDept3() {
        return this.gaOwnerDept3;
    }

    /**
    * 设置公安三级归属单位
    * @param gaOwnerDept3
    */
    public void setGaOwnerDept3(String gaOwnerDept3) {
        this.gaOwnerDept3 = gaOwnerDept3;
    }

    /**
    * 获得公安四级归属单位
    * @return GA_OWNER_DEPT_4
    */
    public String getGaOwnerDept4() {
        return this.gaOwnerDept4;
    }

    /**
    * 设置公安四级归属单位
    * @param gaOwnerDept4
    */
    public void setGaOwnerDept4(String gaOwnerDept4) {
        this.gaOwnerDept4 = gaOwnerDept4;
    }

    /**
    * 获得公安五级归属单位
    * @return GA_OWNER_DEPT_5
    */
    public String getGaOwnerDept5() {
        return this.gaOwnerDept5;
    }

    /**
    * 设置公安五级归属单位
    * @param gaOwnerDept5
    */
    public void setGaOwnerDept5(String gaOwnerDept5) {
        this.gaOwnerDept5 = gaOwnerDept5;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getServiceIp() {
        return serviceIp;
    }

    public void setServiceIp(String serviceIp) {
        this.serviceIp = serviceIp;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsRtsp() {
        return isRtsp;
    }

    public void setIsRtsp(String isRtsp) {
        this.isRtsp = isRtsp;
    }
}
