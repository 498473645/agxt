package pkubatis.common.base;

import io.swagger.annotations.ApiModelProperty;
import org.support.commons.springmvc.ResponseData;

/**
 * 响应消息。controller中处理后，返回此对象，响应请求结果给客户端。
 * @param <D>
 * @author livvy
 * @date 2019/06/17
 */
public class ResponseDto<D> extends ResponseData<D> {
    /**
     * 查询的总记录数
     */
    @ApiModelProperty(value = "总记录数", required = false, example = "总记录数")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ResponseDto(int count) {
        this.count = count;
    }

    public ResponseDto() {
    }

    public ResponseDto(String statusCode, String statusMsg) {
        super(statusCode, statusMsg);
        this.count = 0;
    }

    public ResponseDto(String statusCode, String statusMsg,  int count) {
        super(statusCode, statusMsg);
        this.count = count;
    }
}
