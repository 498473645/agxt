package pkubatis.common.utils;

/**
 * 控制器响应数据
 */
public class OrgData {

	/**身份证号*/
	private String idCard;
	/**姓名*/
	private String userName;
	/**单位id*/
	private String deptId;
	/**单位名称*/
	private String deptName;
	/**警号*/
	private String policeCode;
	/**所属市局*/
	private String orgC;
	/**所属分局*/
	private String orgS;
	/**所属派出所*/
	private String orgT;
	/**数据归属市局*/
	private String orgCData;
	/**数据归属分局*/
	private String orgSData;
	/**数据归属派出所*/
	private String orgTData;
	/**错误*/
	private String errorMessage;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPoliceCode() {
		return policeCode;
	}
	public void setPoliceCode(String policeCode) {
		this.policeCode = policeCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getOrgC() {
		return orgC;
	}
	public void setOrgC(String orgC) {
		this.orgC = orgC;
	}
	public String getOrgS() {
		return orgS;
	}
	public void setOrgS(String orgS) {
		this.orgS = orgS;
	}
	public String getOrgT() {
		return orgT;
	}
	public void setOrgT(String orgT) {
		this.orgT = orgT;
	}
	public String getOrgCData() {
		return orgCData;
	}
	public void setOrgCData(String orgCData) {
		this.orgCData = orgCData;
	}
	public String getOrgSData() {
		return orgSData;
	}
	public void setOrgSData(String orgSData) {
		this.orgSData = orgSData;
	}
	public String getOrgTData() {
		return orgTData;
	}
	public void setOrgTData(String orgTData) {
		this.orgTData = orgTData;
	}

	@Override
	public String toString() {
		return "OrgData [idCard=" + idCard + ", deptId=" + deptId
				+ ", deptName=" + deptName + ", policeCode=" + policeCode
				+ ", orgC=" + orgC + ", orgS=" + orgS + ", orgT=" + orgT
				+ ", orgCData=" + orgCData + ", orgSData=" + orgSData
				+ ", orgTData=" + orgTData + ", errorMessage=" + errorMessage
				+ "]";
	}


}
