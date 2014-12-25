package com.somnus.message.accquery;

import com.somnus.message.Message;

public class MerAccountQueryRequest extends Message {

	/**当前页码*/
	private int pageNum;
	/**每页大小*/
	private int pageSize;
	/**商户号*/
	private String merCode;
	/**商户账户号*/
	private String merAccCode;
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
	public String getMerCode() {
		return merCode;
	}
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
	public String getMerAccCode() {
		return merAccCode;
	}
	public void setMerAccCode(String merAccCode) {
		this.merAccCode = merAccCode;
	}
	
}
