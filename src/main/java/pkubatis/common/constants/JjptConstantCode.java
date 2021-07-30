package pkubatis.common.constants;

/**
 * JjptConstantCode class
 *
 * @author liuc
 * @date 2019/06/14
 */
public class JjptConstantCode {

    /************************************接警状态字典，DIC_JJPT2_CASESTATUS *******************************************/

    /**
     * 1000 已撤销
     */
    public static final String CASESTATUS_1000 = "1000";

    /**
     * 1001 接警
     */
    public static final String CASESTATUS_1001 = "1001";

    /**
     * 1002 出警
     */
    public static final String CASESTATUS_1002 = "1002";

    /**
     * 1003 到场反馈
     */
    public static final String CASESTATUS_1003 = "1003";

    /**
     * 1004 处警反馈
     */
    public static final String CASESTATUS_1004 = "1004";

    /**
     * 1005 补充反馈
     */
    public static final String CASESTATUS_1005 = "1005";

    /************************************接警类型 *******************************************/

    /**
     * 1001 现场接警
     */
    public static final String REPORT_SOURCE_1001 = "1001";

    /**
     * 1002 110转警
     */
    public static final String REPORT_SOURCE_1002 = "1002";

    /**
     * 1003 电话接警
     */
    public static final String REPORT_SOURCE_1003 = "1003";

    /************************************是否接入微信预报警 *******************************************/

    /**
     * 1 接入
     */
    public static final String IF_WECHAT_ALARM_1 = "1";

    /**
     * 0 没有接入
     */
    public static final String IF_WECHAT_ALARM_0 = "0";

    /************************************预报警状态 *******************************************/

    /**
     * 0-未登记
     */
    public static final String YBJ_STATUS_0 = "0";

    /**
     * 1-已推送至大屏
     */
    public static final String YBJ_STATUS_1 = "1";

    /**
     * 2-已登记（已闭环）
     */
    public static final String YBJ_STATUS_2 = "2";

//    /**
//     * 9-已闭环
//     */
//    public static final String YBJ_STATUS_9 = "9";

    /************************************预报警附件类型 *******************************************/

    /**
     * 1-图片
     */
    public static final String YBJ_FILE_TYPE_1 = "1";

    /**
     * 2-语音
     */
    public static final String YBJ_FILE_TYPE_2 = "2";

    /**
     * 3-视频
     */
    public static final String YBJ_FILE_TYPE_3 = "3";

    /**
     * 4-文件
     */
    public static final String YBJ_FILE_TYPE_4 = "4";

    /************************************电话/微信闭环状态，DIC_JJPT2_CALL_CLZT *******************************************/

    /**
     * 1010-未闭环
     */
    public static final String IF_CALL_CLOSE_STATUS_1010 = "1010";

    /**
     * 2010-已闭环
     */
    public static final String IF_CALL_CLOSE_STATUS_2010 = "2010";

    /************************************电话来电状态DIC_JJPT2_CALL_TYPE *******************************************/

    /**
     * 21-已接
     */
    public static final String CALL_TYPE_STATUS_21 = "21";

    /**
     * 22-呼出
     */
    public static final String CALL_TYPE_STATUS_22 = "22";

    /**
     * 23-未接
     */
    public static final String CALL_TYPE_STATUS_23 = "23";

    /************************************材料类型 *******************************************/

    /**
     * 0001-报案图片材料
     */
    public static final String SP_FILE_TYPE_0001 = "0001";

    /**
     * 0002-指纹
     */
    public static final String SP_FILE_TYPE_0002 = "0002";

    /**
     * 0003-签名
     */
    public static final String SP_FILE_TYPE_0003 = "0003";

    /**
     * 0004-报案上传材料
     */
    public static final String SP_FILE_TYPE_0004 = "0004";

    /**
     * 0005-关联笔录
     */
    public static final String SP_FILE_TYPE_0005 = "0005";

    /**
     * 0009-现场笔录pdf文件
     */
    public static final String SP_FILE_TYPE_0009 = "0009";



    /************************************Websocket代码 *******************************************/

    /**
     * webSocketType，用于判断WEBSOCKET类型：0101-接警双屏确认
     */
    public final static String WEBSOCKET_DATATYPE_0101 ="0101";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0102-接警保存数据后修改所有人的接警列表
     */
    public final static String WEBSOCKET_DATATYPE_0102 ="0102";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0103-如果是现场报警保存接警数据后该用户的双屏页面恢复待机页面
     */
    public final static String WEBSOCKET_DATATYPE_0103 ="0103";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0201-笔录双屏问答确认
     */
    public final static String WEBSOCKET_DATATYPE_0201 ="0201";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0202-笔录双屏指纹签名确认
     */
    public final static String WEBSOCKET_DATATYPE_0202 ="0202";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0301-110转警后端向前端提示消息
     */
    public final static String WEBSOCKET_DATATYPE_0301 ="0301";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0302-110转警被接收后，对其他用户的转警按钮进行修改
     */
    public final static String WEBSOCKET_DATATYPE_0302 ="0302";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0303-110转警链接失败后，传送给前端，修改按钮状态
     */
    public final static String WEBSOCKET_DATATYPE_0303 ="0303";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0304-110转警链接链接成功后，传送给前端，修改按钮状态
     */
    public final static String WEBSOCKET_DATATYPE_0304 ="0304";

    /**
     * webSocketType，用于判断WEBSOCKET类型：0401-接话接通后刷新所有用户的电话列表
     */
    public final static String WEBSOCKET_DATATYPE_0401 ="0401";

}
