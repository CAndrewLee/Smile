package com.somnus.message.accquery;

import com.somnus.message.Message;


public class QueryPayAppRequest extends Message {
	
	/**商户账户号*/
	private String merAccCode;
	/**商户号*/
	private String merCode;
	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	public String getMerCode() {
		return merCode;
	}
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
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
}
