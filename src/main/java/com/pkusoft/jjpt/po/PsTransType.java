package com.pkusoft.jjpt.po;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "PS_TRANS_TYPE")
public class PsTransType {

    @Id
    @Column(name = "ID")
    private String id;     //唯一标识号

    @Column(name = "TYPE")
    private String type;     //类型（01：办案；02：办事）

    @Column(name = "NAME")
    private String name;     //业务名称

    @Column(name = "CODE")
    private String code;     //业务编号

    @Column(name = "GROUP_NO")
    private String groupNo;     //组编号

    @Column(name = "GROUP_NAME")
    private String groupName;     //组名称

    @Column(name = "SPELL")
    private String spell;     //拼音头

    @Column(name = "ASPELL")
    private String aspell;     //全拼

    @Column(name = "VISIABLE")
    private String visiable;     //是否可用

    @Column(name = "ORDER_FLAG")
    private Integer orderFlag;     //显示顺序

    @Column(name = "MEMO")
    private String memo;     //备注

    @Column(name = "CREATE_ID")
    private String createId;     //录入用户编号

    @Column(name = "CREATE_NAME")
    private String createName;     //录入用户姓名

    @Column(name = "CREATE_TIME")
    private java.util.Date createTime;     //录入时间

    @Column(name = "MODER_ID")
    private String moderId;     //修改用户编号

    @Column(name = "MODER_NAME")
    private String moderName;     //修改用户姓名

    @Column(name = "MODER_TIME")
    private java.util.Date moderTime;     //修改时间

    @Column(name = "OWN_ORG_1")
    private String ownOrg1;     //公安一级归属单位

    @Column(name = "OWN_ORG_2")
    private String ownOrg2;     //公安二级归属单位

    @Column(name = "OWN_ORG_3")
    private String ownOrg3;     //公安三级归属单位

    @Column(name = "OWN_ORG_4")
    private String ownOrg4;     //公安四级归属单位

    @Column(name = "OWN_ORG_5")
    private String ownOrg5;     //公安五级归属单位

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2


    /**
    * 获得唯一标识号
    * @return ID
    */
    public String getId() {
        return this.id;
    }

    /**
    * 设置唯一标识号
    * @param id
    */
    public void setId(String id) {
        this.id = id;
    }

    /**
    * 获得类型（01：办案；02：办事）
    * @return TYPE
    */
    public String getType() {
        return this.type;
    }

    /**
    * 设置类型（01：办案；02：办事）
    * @param type
    */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * 获得业务名称
    * @return NAME
    */
    public String getName() {
        return this.name;
    }

    /**
    * 设置业务名称
    * @param name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * 获得业务编号
    * @return CODE
    */
    public String getCode() {
        return this.code;
    }

    /**
    * 设置业务编号
    * @param code
    */
    public void setCode(String code) {
        this.code = code;
    }

    /**
    * 获得组编号
    * @return GROUP_NO
    */
    public String getGroupNo() {
        return this.groupNo;
    }

    /**
    * 设置组编号
    * @param groupNo
    */
    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    /**
    * 获得组名称
    * @return GROUP_NAME
    */
    public String getGroupName() {
        return this.groupName;
    }

    /**
    * 设置组名称
    * @param groupName
    */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
    * 获得拼音头
    * @return SPELL
    */
    public String getSpell() {
        return this.spell;
    }

    /**
    * 设置拼音头
    * @param spell
    */
    public void setSpell(String spell) {
        this.spell = spell;
    }

    /**
    * 获得全拼
    * @return ASPELL
    */
    public String getAspell() {
        return this.aspell;
    }

    /**
    * 设置全拼
    * @param aspell
    */
    public void setAspell(String aspell) {
        this.aspell = aspell;
    }

    /**
    * 获得是否可用
    * @return VISIABLE
    */
    public String getVisiable() {
        return this.visiable;
    }

    /**
    * 设置是否可用
    * @param visiable
    */
    public void setVisiable(String visiable) {
        this.visiable = visiable;
    }

    /**
    * 获得显示顺序
    * @return ORDER_FLAG
    */
    public Integer getOrderFlag() {
        return this.orderFlag;
    }

    /**
    * 设置显示顺序
    * @param orderFlag
    */
    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    /**
    * 获得备注
    * @return MEMO
    */
    public String getMemo() {
        return this.memo;
    }

    /**
    * 设置备注
    * @param memo
    */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
    * 获得录入用户编号
    * @return CREATE_ID
    */
    public String getCreateId() {
        return this.createId;
    }

    /**
    * 设置录入用户编号
    * @param createId
    */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
    * 获得录入用户姓名
    * @return CREATE_NAME
    */
    public String getCreateName() {
        return this.createName;
    }

    /**
    * 设置录入用户姓名
    * @param createName
    */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
    * 获得录入时间
    * @return CREATE_TIME
    */
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
    * 设置录入时间
    * @param createTime
    */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
    * 获得修改用户编号
    * @return MODER_ID
    */
    public String getModerId() {
        return this.moderId;
    }

    /**
    * 设置修改用户编号
    * @param moderId
    */
    public void setModerId(String moderId) {
        this.moderId = moderId;
    }

    /**
    * 获得修改用户姓名
    * @return MODER_NAME
    */
    public String getModerName() {
        return this.moderName;
    }

    /**
    * 设置修改用户姓名
    * @param moderName
    */
    public void setModerName(String moderName) {
        this.moderName = moderName;
    }

    /**
    * 获得修改时间
    * @return MODER_TIME
    */
    public java.util.Date getModerTime() {
        return this.moderTime;
    }

    /**
    * 设置修改时间
    * @param moderTime
    */
    public void setModerTime(java.util.Date moderTime) {
        this.moderTime = moderTime;
    }

    /**
    * 获得公安一级归属单位
    * @return OWN_ORG_1
    */
    public String getOwnOrg1() {
        return this.ownOrg1;
    }

    /**
    * 设置公安一级归属单位
    * @param ownOrg1
    */
    public void setOwnOrg1(String ownOrg1) {
        this.ownOrg1 = ownOrg1;
    }

    /**
    * 获得公安二级归属单位
    * @return OWN_ORG_2
    */
    public String getOwnOrg2() {
        return this.ownOrg2;
    }

    /**
    * 设置公安二级归属单位
    * @param ownOrg2
    */
    public void setOwnOrg2(String ownOrg2) {
        this.ownOrg2 = ownOrg2;
    }

    /**
    * 获得公安三级归属单位
    * @return OWN_ORG_3
    */
    public String getOwnOrg3() {
        return this.ownOrg3;
    }

    /**
    * 设置公安三级归属单位
    * @param ownOrg3
    */
    public void setOwnOrg3(String ownOrg3) {
        this.ownOrg3 = ownOrg3;
    }

    /**
    * 获得公安四级归属单位
    * @return OWN_ORG_4
    */
    public String getOwnOrg4() {
        return this.ownOrg4;
    }

    /**
    * 设置公安四级归属单位
    * @param ownOrg4
    */
    public void setOwnOrg4(String ownOrg4) {
        this.ownOrg4 = ownOrg4;
    }

    /**
    * 获得公安五级归属单位
    * @return OWN_ORG_5
    */
    public String getOwnOrg5() {
        return this.ownOrg5;
    }

    /**
    * 设置公安五级归属单位
    * @param ownOrg5
    */
    public void setOwnOrg5(String ownOrg5) {
        this.ownOrg5 = ownOrg5;
    }

    /**
    * 获得预留字段1
    * @return RESERVE1
    */
    public String getReserve1() {
        return this.reserve1;
    }

    /**
    * 设置预留字段1
    * @param reserve1
    */
    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    /**
    * 获得预留字段2
    * @return RESERVE2
    */
    public String getReserve2() {
        return this.reserve2;
    }

    /**
    * 设置预留字段2
    * @param reserve2
    */
    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }


}
