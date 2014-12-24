package com.somnus.message.account;

import java.util.Date;

import com.somnus.message.Message;

public class AccountResponse extends Message {

	private String appTranNo;
	private String accTranNo;
	private Date accDate;

	public String getAppTranNo() {
		return appTranNo;
	}

	public void setAppTranNo(String appTranNo) {
		this.appTranNo = appTranNo;
	}

	public String getAccTranNo() {
		return accTranNo;
	}

	public void setAccTranNo(String accTranNo) {
		this.accTranNo = accTranNo;
	}

	public Date getAccDate() {
		return accDate;
	}

	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}

}
