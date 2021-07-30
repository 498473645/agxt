package pkubatis.common.utils;

import io.swagger.annotations.ApiModelProperty;

public class DicPublicType {
    /**
     * 字典value
     */
    @ApiModelProperty(value = "字典VALUE", required = false, example = "字典VALUE")
    private String itemValue;

    /**
     * 字典ID
     */
    @ApiModelProperty(value = "字典ID", required = false, example = "字典ID")
    private String itemCode;

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
