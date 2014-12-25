package com.somnus.support.domain;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class Bank {
	/**
	 * 银行名称
	 * @description 
	 * 		1.作为表头标题 ，填写如：招商，工商...无需“银行”后缀
	 * 		2.作为表体数据，填写如：招商银行，工商银行...
	 */
	private String bankname;
	/** 银行code */
	private String bankcode;
	
	/**
	 * 户名
	 */
	private String accountname;
	
	/**
	 * 账号
	 */
	private String accountno;

	private String id;
	
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the bankname
	 */
	public String getBankname() {
		return bankname;
	}

	/**
	 * @param bankname the bankname to set
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname.trim();
	}

	/**
	 * @return the accountname
	 */
	public String getAccountname() {
		return accountname;
	}

	/**
	 * @param accountname the accountname to set
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname.trim();
	}

	/**
	 * @return the accountno
	 */
	public String getAccountno() {
		return accountno;
	}

	/**
	 * @param accountno the accountno to set
	 */
	public void setAccountno(String accountno) {
		this.accountno = accountno.trim();
	}


	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode.trim();
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
