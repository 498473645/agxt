package com.pkusoft.rkxt.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author
 * 业务类型查询返回
 */
public class XtBizTypeVo {

    @ApiModelProperty(value = "二级业务编码")
    private String bizCode;

    @ApiModelProperty(value = "二级业务名称")
    private String bizName;

    @ApiModelProperty(value = "省市县区")
    private String ssxq;

    @ApiModelProperty(value = "是否需要进行前置问答", required = false, example = "是否需要进行前置问答")
    private String isNeedQa;

    @ApiModelProperty(value = "web端跳转路径")
    private String webUrl;

    @ApiModelProperty(value = "下级业务集合")
    private List<XtBizTypeItemVo> itemList;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getSsxq() {
        return ssxq;
    }

    public void setSsxq(String ssxq) {
        this.ssxq = ssxq;
    }

    public String getIsNeedQa() {
        return isNeedQa;
    }

    public void setIsNeedQa(String isNeedQa) {
        this.isNeedQa = isNeedQa;
    }

    public List<XtBizTypeItemVo> getItemList() {
        return itemList;
    }

    public void setItemList(List<XtBizTypeItemVo> itemList) {
        this.itemList = itemList;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
