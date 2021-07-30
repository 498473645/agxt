package pkubatis.common.utils;

/**
 * 系统数据权限类型定义常量类
 *
 * @author hed
 * @date 2020/01/07
 */
public class PermitType {

    /**************************************************************数据权限类型*************************************************************/
    /**
     * 数据权限类型-单位数据查询权限
     */
    public final static String PERMIT_TYPE_DEPT_QUERY = "100001";

    /**
     * 数据权限类型-案件业务办理查询权限
     */
    public final static String PERMIT_TYPE_CASE_QUERY = "100002";

    /**
     * 数据权限类型-业务数据查询统计权限
     */
    public final static String PERMIT_TYPE_COUNT_QUERY = "100003";

    /**
     * 数据权限类型-警情业务办理查询权限
     */
    public final static String PERMIT_TYPE_INCIDENT_QUERY = "100004";

    /**
     * 数据权限类型-上传文件业务办理查询权限
     */
    public final static String PERMIT_TYPE_FILES_QUERY = "100005";

    /**************************************************************数据权限类型*************************************************************/
    /**
     * 数据权限值-本人办理的
     */
    public final static String PERMIT_VALUE_SOLO = "9";

    /**
     * 数据权限值-查询本单位的数据
     */
    public final static String PERMIT_VALUE_AREA = "8";

    /**
     * 数据权限值-查询所属派出所及其下级单位的单位数据
     */
    public final static String PERMIT_VALUE_DEPT_4 = "4";

    /**
     * 数据权限值-查询所属分局以及下级单位数据
     */
    public final static String PERMIT_VALUE_DEPT_3 = "3";

    /**
     * 数据权限值-查询所属县级以及下级单位数据
     */
    public final static String PERMIT_VALUE_DEPT_2 = "2";

    /**
     * 数据权限值-查询所属省级及下级单位数据
     */
    public final static String PERMIT_VALUE_DEPT_1 = "1";

    /**
     * 数据权限值-查询国家警察总部以及下级单位数据
     */
    public final static String PERMIT_VALUE_DEPT_0 = "0";

}
