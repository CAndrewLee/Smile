package com.somnus.message.accquery;

import java.util.List;

import com.somnus.message.Message;

public class QueryPayAppResponse extends Message {
	
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**总条数*/
	private int rowCount;
	/**查询结果集*/
	private List<QueryPayAppOrder> orders;
	
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
	public List<QueryPayAppOrder> getOrders() {
		return orders;
	}
	public void setOrders(List<QueryPayAppOrder> orders) {
		this.orders = orders;
	}
}
