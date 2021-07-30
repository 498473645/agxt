package pkubatis.model;

import java.util.ArrayList;
import java.util.List;

public class GridResult {
	private boolean success = true;
	private int totalRecords = 0;
	private List<?> data;

	public GridResult(List<?> data) {
		if (data != null) {
			setData(data);
			this.totalRecords = data.size();
		}
	}

	public GridResult(List<?> data, int totalRecords) {
		if (data != null) {
			setData(data);
			this.totalRecords = totalRecords;
		}
	}

	public GridResult(boolean success, List<?> data) {
		this.success = success;
		if (data != null) {
			setData(data);
			this.totalRecords = data.size();
		}
	}

	public GridResult(boolean success, List<?> data, int totalRecords) {
		this.success = success;
		if (data != null) {
			setData(data);
			this.totalRecords = totalRecords;
		}
	}

	public int getTotalRecords() {
		return this.totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<?> getData() {
		if (this.data == null) {
			return new ArrayList();
		}
		return this.data;
	}

	public void setData(List<?> data) {
		if (data == null) {
			throw new IllegalArgumentException("arguments can't be null");
		}
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
