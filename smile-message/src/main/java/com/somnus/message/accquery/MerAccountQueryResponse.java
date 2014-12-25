package com.somnus.message.accquery;

import java.util.List;

import com.somnus.message.Message;

public class MerAccountQueryResponse extends Message {

	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**查询结果*/
	private List<MerAccount> orders;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public List<MerAccount> getOrders() {
		return orders;
	}
	public void setOrders(List<MerAccount> orders) {
		this.orders = orders;
	}
	
}
