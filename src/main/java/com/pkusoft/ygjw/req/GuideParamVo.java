package com.pkusoft.ygjw.req;

import io.swagger.annotations.ApiModelProperty;

public class GuideParamVo {

    @ApiModelProperty(value = "业务类型代码", required = false, example = "400xxx")
    private String ywlxdm;

    @ApiModelProperty(value = "业务类型名称", required = false, example = "400xxx")
    private String ywlxmc;

    @ApiModelProperty(value = "业务指南类型编号", required = false, example = "00001")
    private String pid;

    @ApiModelProperty(value = "省市县区代码", required = false, example = "150000")
    private String ssxqdm;

    @ApiModelProperty(value = "事项名称", required = false, example = "ABCDDD")
    private String sxmc;

    @ApiModelProperty(value = "事项编号", required = false, example = "ABCDDD")
    private String sxbh;

    @ApiModelProperty(value = "查询类型", required = false, example = "-1或0")
    private String type;

    @ApiModelProperty(value = "类型级别", required = false, example = "1")
    private String level;

    public String getYwlxmc() {
        return ywlxmc;
    }

    public void setYwlxmc(String ywlxmc) {
        this.ywlxmc = ywlxmc;
    }

    public String getSxbh() {
        return sxbh;
    }

    public void setSxbh(String sxbh) {
        this.sxbh = sxbh;
    }

    public String getYwlxdm() {
        return ywlxdm;
    }

    public String getPid() {
        return pid;
    }

    public void setYwlxdm(String ywlxdm) {
        this.ywlxdm = ywlxdm;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getSsxqdm() {
        return ssxqdm;
    }

    public void setSsxqdm(String ssxqdm) {
        this.ssxqdm = ssxqdm;
    }

    public String getSxmc() {
        return sxmc;
    }

    public void setSxmc(String sxmc) {
        this.sxmc = sxmc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
