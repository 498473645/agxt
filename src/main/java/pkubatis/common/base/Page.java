package pkubatis.common.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页参数
 * @author
 *
 */
public class Page {

	@ApiModelProperty(value = "分页起始页", name="start")
	private int start;
	@ApiModelProperty(value = "每页条数", name="pageSize")
	private int pageSize;

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
}
