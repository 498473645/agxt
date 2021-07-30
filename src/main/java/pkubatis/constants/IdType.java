package pkubatis.constants;

public class IdType {

	/**
	 * 编号类型：业务流水号
	 */
	public final static String YWLSH = "200001";

	/**
	 * 编号类型：对象标识
	 */
	public final static String OBJID = "200002";

	/**
	 * 编号类型：相片编号
	 */
	public final static String JBXX_XP = "200003";

	/**
	 * 编号类型：指纹编号
	 */
	public final static String JBXX_ZW = "200005";

	/**
	 * 编号类型：居民身份证受理号
	 */
	public final static String ZJYW_SLH = "300001";

	/**
	 * 编号类型：字典条目
	 */
	public final static String DIC_ITEM = "100013";

	/**
	 * 编号类型：用户管理
	 */
	public final static String SYS_USER = "100002";

	/**
	 * 编号类型：角色编号
	 */
	public final static String SYS_ROLE = "100004";

	/**
	 * 编号类型：角色用户
	 */
	public final static String ROLE_USER = "100005";

	/**
	 * 编号类型：角色用户
	 */
	public final static String SYS_MENU = "100009";

	/**
	 * 编号类型：系统参数
	 */
	public final static String SYS_PARA = "100014";

	/**
	 * 编号类型：功能号编号
	 */
	public final static String SYS_FUNCTION = "100010";

	/*************************************数据项有效性**********************************************/
	public final static String ROW_STATUS_APPLY_DELETE = "1010";

	public final static String ROW_STATUS_EXECUTE_DELETE = "1020";

	public final static String ROW_STATUS_VALID = "2010";

	/*************************************警情状态编码**********************************************/
	public final static String INCIDENT_REGISTRATION = "1010";
	public final static String INCIDENT_CLASSIFY_CRIMINAL = "2010";
	public final static String INCIDENT_CLASSIFY_NONCRIMINAL = "2011";
	public final static String INCIDENT_CLASSIFY_INVALID = "2020";
	public final static String INCIDENT_CLOSE = "9010";
	public final static String INCIDENT_REVOKE = "9020";

	/************************************文件上传路径标识*******************************************/
	public final static String FILE_UPLOADING_DIRECTORY = "/ccms/fileUploading/";

	/************************************文件详情查看类型*******************************************/
	public final static String FILE_OPERATE_TYPE_OB = "01";

	public final static String FILE_OPERATE_TYPE_CASE = "02";

	public final static String FILE_OPERATE_TYPE_SUSPECT = "03";
   /************************************文件上传操作模块编码*******************************************/
	// 警情模块上传
	public final static String UPLOAD_MODULE_OB =  "1010 ";
	// docketOfCase
	public final static String UPLOAD_MODULE_DOCKET =  "2010 ";
	// 案件调查
	public final static String UPLOAD_MODULE_INTERROGATION =  "2020 ";
	// 案件线索
	public final static String UPLOAD_MODULE_CLUE =  "2030 ";
	// 案件证据
	public final static String UPLOAD_MODULE_EVIDENCE =  "2040 ";
	// 人员相片
	public final static String UPLOAD_MODULE_PHOTO =  "3010 ";
	// 指纹
	public final static String UPLOAD_MODULE_FINGERPRINT =  "3020 ";
}
