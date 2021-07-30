package pkubatis.common.constants;

/**
 * BizDicCode class
 *
 * @author liuc
 * @date 2019/06/14
 */
public class BizDicCode {

    /************************************财物状态字典*******************************************/
    /**
     * 财物状态-非在库保管
     */
    public final static String DIC_CWZT_FZKBG = "0";
    /**
     * 财物状态-在库保管中
     */
    public final static String DIC_CWZT_BGZ = "1";

    /************************************财物分类字典*******************************************/
    /**
     * 财物分类-普通物品
     */
    public final static String DIC_CWFL_PTWP = "1";

    /**
     * 财物分类-涉案车辆
     */
    public final static String DIC_CWFL_SACL = "2";

    /**
     * 财物分类-涉案资金款项
     */
    public final static String DIC_CWFL_SAKX = "3";

    /**
     * 财物分类-其他物品
     */
    public final static String DIC_CWFL_QT = "9";

    /************************************财物操作类别字典*******************************************/
    /**
     * 财物操作类别-暂存
     */
    public final static String DIC_CWCZLB_ZC = "01";

    /**
     * 财物操作类别-登记入库
     */
    public final static String DIC_CWCZLB_DJRK = "10";

    /**
     * 财物操作类别-调用入库
     */
    public final static String DIC_CWCZLB_DYRK = "11";

    /**
     * 财物操作类别-保管延期
     */
    public final static String DIC_CWCZLB_BGYQ = "12";

    /**
     * 财物操作类别-系统内接收
     */
    public final static String DIC_CWCZLB_XTNJS = "13";

    /**
     * 财物操作类别-跨公检法接收
     */
    public final static String DIC_CWCZLB_KGJFJS = "14";

    /**
     * 财物操作类别-调用出库
     */
    public final static String DIC_CWCZLB_DYCK = "20";

    /**
     * 财物操作类别-调用延期
     */
    public final static String DIC_CWCZLB_DYYQ = "21";

    /**
     * 财物操作类别-处理出库
     */
    public final static String DIC_CWCZLB_CLCK = "30";

    /**
     * 财物操作类别-物品移交
     */
    public final static String DIC_CWCZLB_WPYJ = "40";

    /**
     * 财物操作类别-系统内移交
     */
    public final static String DIC_CWCZLB_XTNYJ = "41";

    /**
     * 财物操作类别-跨公检法移交
     */
    public final static String DIC_CWCZLB_KGJFYJ = "41";

    /**
     * 财物操作类别-其他
     */
    public final static String DIC_CWCZLB_QT = "90";



    /************************************财物操作类别字典*******************************************/

    /**
     * 11 保管中
     */
    public static final String DIC_GLBGZT_BGZ = "11";

    /**
     * 21 调用出库
     */
    public static final String DIC_GLBGZT_DYCK = "21";

    /**
     * 22 处理出库
     */
    public static final String DIC_GLBGZT_CLCK = "22";



}
