package com.pkusoft.usercenter.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "SYS_DATA_OWNER_DEPT")
public class SysDataOwnerDept implements Serializable {
    /**序列化版本号*/
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "DATA_OWNER_DEPT_ID")
    private String dataOwnerDeptId;     //主键ID

    @Column(name = "DEPT_ID")
    private String deptId;     //单位编号

    @Column(name = "DEPT_TYPE")
    private String deptType;     //单位类别（ga-公安；jg-交管；xz-刑侦）

    @Column(name = "OWNER_DEPT_1")
    private String ownerDept1;     //一级归属单位

    @Column(name = "OWNER_DEPT_2")
    private String ownerDept2;     //二级归属单位

    @Column(name = "OWNER_DEPT_3")
    private String ownerDept3;     //三级归属单位

    @Column(name = "OWNER_DEPT_4")
    private String ownerDept4;     //四级归属单位

    @Column(name = "OWNER_DEPT_5")
    private String ownerDept5;     //五级归属单位

    @Column(name = "MODIFY_USER_ID")
    private String modifyUserId;     //修改用户编号

    @Column(name = "MODIFY_TIME")
    private Date modifyTime;     //修改时间


    /**
    * 获得主键ID
    * @return DATA_OWNER_DEPT_ID
    */
    public String getDataOwnerDeptId() {
        return this.dataOwnerDeptId;
    }

    /**
    * 设置主键ID
    * @param dataOwnerDeptId
    */
    public void setDataOwnerDeptId(String dataOwnerDeptId) {
        this.dataOwnerDeptId = dataOwnerDeptId;
    }

    /**
    * 获得单位编号
    * @return DEPT_ID
    */
    public String getDeptId() {
        return this.deptId;
    }

    /**
    * 设置单位编号
    * @param deptId
    */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
    * 获得单位类别（ga-公安；jg-交管；xz-刑侦）
    * @return DEPT_TYPE
    */
    public String getDeptType() {
        return this.deptType;
    }

    /**
    * 设置单位类别（ga-公安；jg-交管；xz-刑侦）
    * @param deptType
    */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    /**
    * 获得一级归属单位
    * @return OWNER_DEPT_1
    */
    public String getOwnerDept1() {
        return this.ownerDept1;
    }

    /**
    * 设置一级归属单位
    * @param ownerDept1
    */
    public void setOwnerDept1(String ownerDept1) {
        this.ownerDept1 = ownerDept1;
    }

    /**
    * 获得二级归属单位
    * @return OWNER_DEPT_2
    */
    public String getOwnerDept2() {
        return this.ownerDept2;
    }

    /**
    * 设置二级归属单位
    * @param ownerDept2
    */
    public void setOwnerDept2(String ownerDept2) {
        this.ownerDept2 = ownerDept2;
    }

    /**
    * 获得三级归属单位
    * @return OWNER_DEPT_3
    */
    public String getOwnerDept3() {
        return this.ownerDept3;
    }

    /**
    * 设置三级归属单位
    * @param ownerDept3
    */
    public void setOwnerDept3(String ownerDept3) {
        this.ownerDept3 = ownerDept3;
    }

    /**
    * 获得四级归属单位
    * @return OWNER_DEPT_4
    */
    public String getOwnerDept4() {
        return this.ownerDept4;
    }

    /**
    * 设置四级归属单位
    * @param ownerDept4
    */
    public void setOwnerDept4(String ownerDept4) {
        this.ownerDept4 = ownerDept4;
    }

    /**
    * 获得五级归属单位
    * @return OWNER_DEPT_5
    */
    public String getOwnerDept5() {
        return this.ownerDept5;
    }

    /**
    * 设置五级归属单位
    * @param ownerDept5
    */
    public void setOwnerDept5(String ownerDept5) {
        this.ownerDept5 = ownerDept5;
    }

    /**
    * 获得修改用户编号
    * @return MODIFY_USER_ID
    */
    public String getModifyUserId() {
        return this.modifyUserId;
    }

    /**
    * 设置修改用户编号
    * @param modifyUserId
    */
    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    /**
    * 获得修改时间
    * @return MODIFY_TIME
    */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
    * 设置修改时间
    * @param modifyTime
    */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }


}
