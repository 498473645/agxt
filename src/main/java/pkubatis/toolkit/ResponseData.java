package pkubatis.toolkit;

/**
 * 控制器响应数据
 */
public class ResponseData {
    private String statusCode;
    private String statusMsg;
    private String attachment;
    private Object data;

    /**
     * @param statusCode
     *            状态编码
     * @param statusMsg
     *            状态信息
     */
    public ResponseData(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    /**
     * @param statusCode
     *            状态编码
     * @param statusMsg
     *            状态信息
     * @param data
     *            数据
     */
    public ResponseData(String statusCode, String statusMsg, Object data) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.data = data;
    }
    /**
     * @param statusCode
     *            状态编码
     * @param statusMsg
     *            状态信息
     * @param attachment
     *            数据
     * @param data
     *            数据
     */
    public ResponseData(String statusCode, String statusMsg,String attachment,Object data) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
        this.attachment = attachment;
        this.data = data;
    }
    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
