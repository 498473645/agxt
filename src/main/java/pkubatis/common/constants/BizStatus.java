package pkubatis.common.constants;

/**
 * BizStatus class
 *
 * @author liuc
 * @date 2019/06/14
 */
public class BizStatus {

    /************************************归属单位类型*******************************************/
    /**
     * 归属单位类型-公安单位
     */
    public final static String OWNER_DEPT_TYPE_GA = "1";

    /**
     * 归属单位类型-业务单位
     */
    public final static String OWNER_DEPT_TYPE_YW = "2";

    /************************************业务办理状态*******************************************/
    /**
     * 业务办理状态-登记
     */
    public static final String SACW_BIZ_DJ = "01";

    /**
     * 业务办理状态-流程中
     */
    public static final String SACW_BIZ_LCZ = "10";

    /**
     * 业务办理状态-完结
     */
    public static final String SACW_BIZ_WJ = "90";

    /**
     * 业务办理状态-撤销办理
     */
    public static final String SACW_BIZ_CX = "91";
}
