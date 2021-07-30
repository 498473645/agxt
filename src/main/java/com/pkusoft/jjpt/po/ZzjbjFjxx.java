package com.pkusoft.jjpt.po;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ZZJBJ_FJXX")
public class ZzjbjFjxx {

    @Id
    @Column(name = "FJBH")
    private String fjbh;     //附件材料编号

    @Column(name = "BJID")
    private String bjid;     //报警ID

    @Column(name = "FJLX")
    private String fjlx;     //附件类型（1-图片，2-语音，3-视频，4-文件）

    @Column(name = "AUDIO")
    private byte[] audio;     //报警语音

    @Column(name = "AUDIO_CN")
    private String audioCn;     //报警语音中文翻译

    @Column(name = "PTOTO")
    private byte[] ptoto;     //报警拍照

    @Column(name = "VIDEO")
    private byte[] video;     //报警视频

    @Column(name = "STATUS")
    private String status;     //数据状态

    @Column(name = "BJDWDM")
    private String bjdwdm;     //报警单位代码

    @Column(name = "BJDWMC")
    private String bjdwmc;     //报警单位名称

    @Column(name = "GXSJ")
    private Date gxsj;     //更新时间

    @Column(name = "RESERVE1")
    private String reserve1;     //预留字段1

    @Column(name = "RESERVE2")
    private String reserve2;     //预留字段2

    @Column(name = "RESERVE3")
    private String reserve3;     //预留字段3

    @Column(name = "RESERVE4")
    private String reserve4;     //预留字段4

    @Column(name = "RESERVE5")
    private String reserve5;     //预留字段5

    @Column(name = "RESERVE6")
    private String reserve6;     //预留字段6

    @Column(name = "RESERVE7")
    private String reserve7;     //预留字段7

    @Column(name = "RESERVE8")
    private String reserve8;     //预留字段8


    /**
    * 获得附件材料编号
    * @return FJBH
    */
    public String getFjbh() {
        return this.fjbh;
    }

    /**
    * 设置附件材料编号
    * @param fjbh
    */
    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    /**
    * 获得报警ID
    * @return BJID
    */
    public String getBjid() {
        return this.bjid;
    }

    /**
    * 设置报警ID
    * @param bjid
    */
    public void setBjid(String bjid) {
        this.bjid = bjid;
    }

    /**
    * 获得附件类型（1-图片，2-语音，3-视频，4-文件）
    * @return FJLX
    */
    public String getFjlx() {
        return this.fjlx;
    }

    /**
    * 设置附件类型（1-图片，2-语音，3-视频，4-文件）
    * @param fjlx
    */
    public void setFjlx(String fjlx) {
        this.fjlx = fjlx;
    }

    /**
    * 获得报警语音
    * @return AUDIO
    */
    public byte[] getAudio() {
        return this.audio;
    }

    /**
    * 设置报警语音
    * @param audio
    */
    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    /**
    * 获得报警语音中文翻译
    * @return AUDIO_CN
    */
    public String getAudioCn() {
        return this.audioCn;
    }

    /**
    * 设置报警语音中文翻译
    * @param audioCn
    */
    public void setAudioCn(String audioCn) {
        this.audioCn = audioCn;
    }

    /**
    * 获得报警拍照
    * @return PTOTO
    */
    public byte[] getPtoto() {
        return this.ptoto;
    }

    /**
    * 设置报警拍照
    * @param ptoto
    */
    public void setPtoto(byte[] ptoto) {
        this.ptoto = ptoto;
    }

    /**
    * 获得报警视频
    * @return VIDEO
    */
    public byte[] getVideo() {
        return this.video;
    }

    /**
    * 设置报警视频
    * @param video
    */
    public void setVideo(byte[] video) {
        this.video = video;
    }

    /**
    * 获得数据状态
    * @return STATUS
    */
    public String getStatus() {
        return this.status;
    }

    /**
    * 设置数据状态
    * @param status
    */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
    * 获得报警单位代码
    * @return BJDWDM
    */
    public String getBjdwdm() {
        return this.bjdwdm;
    }

    /**
    * 设置报警单位代码
    * @param bjdwdm
    */
    public void setBjdwdm(String bjdwdm) {
        this.bjdwdm = bjdwdm;
    }

    /**
    * 获得报警单位名称
    * @return BJDWMC
    */
    public String getBjdwmc() {
        return this.bjdwmc;
    }

    /**
    * 设置报警单位名称
    * @param bjdwmc
    */
    public void setBjdwmc(String bjdwmc) {
        this.bjdwmc = bjdwmc;
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

    /**
    * 获得预留字段3
    * @return RESERVE3
    */
    public String getReserve3() {
        return this.reserve3;
    }

    /**
    * 设置预留字段3
    * @param reserve3
    */
    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    /**
    * 获得预留字段4
    * @return RESERVE4
    */
    public String getReserve4() {
        return this.reserve4;
    }

    /**
    * 设置预留字段4
    * @param reserve4
    */
    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    /**
    * 获得预留字段5
    * @return RESERVE5
    */
    public String getReserve5() {
        return this.reserve5;
    }

    /**
    * 设置预留字段5
    * @param reserve5
    */
    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    /**
    * 获得预留字段6
    * @return RESERVE6
    */
    public String getReserve6() {
        return this.reserve6;
    }

    /**
    * 设置预留字段6
    * @param reserve6
    */
    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6;
    }

    /**
    * 获得预留字段7
    * @return RESERVE7
    */
    public String getReserve7() {
        return this.reserve7;
    }

    /**
    * 设置预留字段7
    * @param reserve7
    */
    public void setReserve7(String reserve7) {
        this.reserve7 = reserve7;
    }

    /**
    * 获得预留字段8
    * @return RESERVE8
    */
    public String getReserve8() {
        return this.reserve8;
    }

    /**
    * 设置预留字段8
    * @param reserve8
    */
    public void setReserve8(String reserve8) {
        this.reserve8 = reserve8;
    }


}