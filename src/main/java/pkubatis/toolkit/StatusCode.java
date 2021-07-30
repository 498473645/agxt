package pkubatis.toolkit;


public class StatusCode {

    /**
     * 成功
     */
    public final static String STATUS_CODE_SUCCESS = "00";// 成功
    /**
     * 参数错误
     */
    public final static String STATUS_CODE_PARAM_ERROR = "20";// 参数错误
    /**
     * 其他出错
     */
    public final static String STATUS_CODE_ERROR = "99";// 失败
    /**
     * 未找到数据
     */
    public final static String STATUS_CODE_NOTFOUND ="90";//未找到数据
    /**
     * 什么都没做
     */
    public final static String STATUS_CODE_NOTHING ="91";//什么都没做

//
//	/**
//	 * BD_FUNCTION_ROOM.STATUS:1000-空闲
//	 */
//	public final static String ROOM_STATUS_1000 = "1000";
//
//	/**
//	 * BD_FUNCTION_ROOM.STATUS:1010-使用中
//	 */
//	public final static String ROOM_STATUS_1010 = "1010";
//
//	/**
//	 * HA_RECORD.STATUS:1010-入区登记
//	 */
//	public final static String RECORD_STATUS_1010 = "1010";
//
//	/**
//	 * HA_RECORD.STATUS:1020-人身检查
//	 */
//	public final static String RECORD_STATUS_1020 = "1020";
//	/**
//	 * HA_RECORD.STATUS:1030-财物存管
//	 */
//	public final static String RECORD_STATUS_1030 = "1030";
//	/**
//	 * HA_RECORD.STATUS:1040-信息采集
//	 */
//	public final static String RECORD_STATUS_1040 = "1040";
//
//	/**
//	 * HA_RECORD.STATUS:1050-候问管理
//	 */
//	public final static String RECORD_STATUS_1050 = "1050";
//	/**
//	 * HA_RECORD.STATUS:1060-讯/询问管理
//	 */
//	public final static String RECORD_STATUS_1060 = "1060";
//	/**
//	 * HA_RECORD.STATUS:1070-物品返还
//	 */
//	public final static String RECORD_STATUS_1070 = "1070";
//	/**
//	 * HA_RECORD.STATUS:2010-出区登记。
//	 */
//	public final static String RECORD_STATUS_2010 = "2010";
//	/**
//	 * HA_RECORD.STATUS:2020-临时离开。
//	 */
//	public final static String RECORD_STATUS_2020 = "2020";
//
//	//进入办案区原由
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1010-投案自首
//	 */
//	public final static String IN_REASON_CODE_1010 = "1010";
//
//	/**
//	 * HA_RECORD.STATIN_REASON_CODEUS:1020-治安传唤
//	 */
//	public final static String IN_REASON_CODE_1020 = "1020";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1030-继续盘问
//	 */
//	public final static String IN_REASON_CODE_1030 = "1030";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1040-刑事传唤
//	 */
//	public final static String IN_REASON_CODE_1040 = "1040";
//
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1050-拘传
//	 */
//	public final static String IN_REASON_CODE_1050 = "1050";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1060-刑事拘留
//	 */
//	public final static String IN_REASON_CODE_1060 = "1060";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1070-取保候审
//	 */
//	public final static String IN_REASON_CODE_1070 = "1070";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1080-监视居住
//	 */
//	public final static String IN_REASON_CODE_1080 = "1080";
//
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1090-逮捕
//	 */
//	public final static String IN_REASON_CODE_1090 = "1090";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1100-被害人
//	 */
//	public final static String IN_REASON_CODE_1100 = "1100";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:1110-证人
//	 */
//	public final static String IN_REASON_CODE_1110 = "1110";
//	/**
//	 * HA_RECORD.IN_REASON_CODE:9000-其他
//	 */
//	public final static String IN_REASON_CODE_9000 = "9000";
//	/**
//     * BD_SPACE.STATUS  空，关
//     */
//    public final static String SPACE_KONG_GUAN = "0000";
//	/**
//     * BD_SPACE.STATUS 空，开
//     */
//    public final static String SPACE_KONG_KAI = "0010";
//    /**
//     * BD_SPACE.STATUS 已存放，关
//     */
//    public final static String SPACE_YICHUNFANG_GUAN = "0100";
//    /**
//     * BD_SPACE.STATUS 0110
//     */
//    public final static String SPACE_YICHUNFANG_KAI = "0000";
//    /**
//     * BD_SPACE.STATUS 满，关
//     */
//    public final static String SPACE_MAN_GUAN = "0900";
//
//    /// 储物柜操作类型
//    /// </summary>
//    /**
//     * 放入手环
//     */
//    public final static String SPAOPERTYPE_PUTBRACELET = "0010";
//    /**
//     * 取出手环
//     */
//    public final static String SPAOPERTYPE_GETBRACELET = "0015";
//    /**
//     * 放入办案卡
//     */
//    public final static String SPAOPERTYPE_PUTHANDLINGCARD = "0020";
//    /**
//     * 取出办案卡
//     */
//    public final static String SPAOPERTYPE_GETHANDLINGCARD = "0025";
//    /**
//     * 放入随身物品
//     */
//    public final static String SPAOPERTYPE_PUTITEMS = "0030";
//    /**
//     * 取出随身物品
//     */
//    public final static String SPAOPERTYPE_GETITEMS = "0035";
//    /**
//     * 放入涉案物品
//     */
//    public final static String SPAOPERTYPE_PUTCASEITEMS = "0040";
//    /**
//     * 取出涉案物品
//     */
//    public final static String SPAOPERTYPE_GETCASEITEMS = "0045";
//    /**
//     * 其它
//     */
//    public final static String SPAOPERTYPE_OTHER = "9000";
//
//    public static String toGetInReasonName(String inReasonCode) {
//		if("1010".equals(inReasonCode)){
//			return "投案自首";
//		}else if("1020".equals(inReasonCode)){
//			return "治安传唤";
//		}else if("1030".equals(inReasonCode)){
//			return "继续盘问";
//		}else if("1040".equals(inReasonCode)){
//			return "刑事传唤";
//		}else if("1050".equals(inReasonCode)){
//			return "拘传";
//		}else if("1060".equals(inReasonCode)){
//			return "刑事拘留";
//		}else if("1070".equals(inReasonCode)){
//			return "取保候审";
//		}else if("1080".equals(inReasonCode)){
//			return "监视居住";
//		}else if("1090".equals(inReasonCode)){
//			return "逮捕";
//		}else if("1100".equals(inReasonCode)){
//			return "被害人";
//		}else if("1110".equals(inReasonCode)){
//			return "证人";
//		}else{
//			return "其它";
//		}
//	}
//
//    public static String toGetStatus(String status) {
//		if("1010".equals(status)){
//			return "入区登记";
//		}else if("1020".equals(status)){
//			return "人身检查";
//		}else if("1030".equals(status)){
//			return "财物存管";
//		}else if("1040".equals(status)){
//			return "信息采集";
//		}else if("1050".equals(status)){
//			return "候问管理";
//		}else if("1060".equals(status)){
//			return "讯/询问管理";
//		}else if("1070".equals(status)){
//			return "物品返还";
//		}else if("2010".equals(status)){
//			return "出区登记";
//		}else if("2020".equals(status)){
//			return "临时离开";
//		}else{
//			return "";
//		}
//	}


}
