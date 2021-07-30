package pkubatis.common.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页参数
 * @author
 *
 */
public class YgjwPage {

	@ApiModelProperty(value = "分页起始页", name="start")
	private int start;
	@ApiModelProperty(value = "每页条数", name="pageSize")
	private int pageSize;

	@ApiModelProperty(value = "设备唯一标识码", name="eId")
	private String eId;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}
}
