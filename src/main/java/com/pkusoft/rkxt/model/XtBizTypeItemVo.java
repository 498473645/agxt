package com.pkusoft.rkxt.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author
 * 业务类型查询返回
 */
public class XtBizTypeItemVo {

    @ApiModelProperty(value = "二级业务编码")
    private String bizCode;

    @ApiModelProperty(value = "二级业务名称")
    private String bizName;

    @ApiModelProperty(value = "省市县区")
    private String ssxq;

    @ApiModelProperty(value = "是否需要进行前置问答", required = false, example = "是否需要进行前置问答")
    private String isNeedQa;

    /**
     * 业务步骤编号
     */
    @ApiModelProperty(value = "业务步骤编号", required = false, example = "业务步骤编号")
    private Integer stepNum;

    /**
     * 办件事项ID
     */
    @ApiModelProperty(value = "办件事项ID", required = false, example = "办件事项ID")
    private String itemId;

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

    public Integer getStepNum() {
        return stepNum;
    }

    public void setStepNum(Integer stepNum) {
        this.stepNum = stepNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
