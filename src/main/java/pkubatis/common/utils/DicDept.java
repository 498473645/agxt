package pkubatis.common.utils;

import io.swagger.annotations.ApiModelProperty;

public class DicDept {
    /**
     * 字典value
     */
    @ApiModelProperty(value = "单位名称", required = false, example = "单位名称")
    private String deptValue;

    /**
     * 字典ID
     */
    @ApiModelProperty(value = "单位ID", required = false, example = "单位ID")
    private String deptId;

    /**
     * 部门级别
     */
    @ApiModelProperty(value = "部门级别", required = false, example = "部门级别")
    private String deptLevel;

    public String getDeptValue() {
        return deptValue;
    }

    public void setDeptValue(String deptValue) {
        this.deptValue = deptValue;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptLevel() {
        return deptLevel;
    }

    public void setDeptLevel(String deptLevel) {
        this.deptLevel = deptLevel;
    }
}
