package com.somnus.message.accquery;

public class QueryPayAppOrder {
	
	/**记账交易流水号*/
	private String accTranNo;
	/**商户号*/
	private String merCode;
	/**商户账户号*/
	private String merAccCode;
	/**币种*/
	private String ccyCode;
	/**拒付金额*/
	private String tranAmount;
	/**拒付日期*/
	private String tranDate;
	/**拒付持卡人姓名*/
	private String cardHolder;
	/**拒付持卡人卡号*/
	private String cardNo;
	/**拒付是否退款*/
	private String isDraw;
	/**拒付退款银行*/
	private String refBankCode;
	
	public String getAccTranNo() {
		return accTranNo;
	}
	public void setAccTranNo(String accTranNo) {
		this.accTranNo = accTranNo;
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
	public String getCcyCode() {
		return ccyCode;
	}
	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}
	public String getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(String tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getTranDate() {
		return tranDate;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getIsDraw() {
		return isDraw;
	}
	public void setIsDraw(String isDraw) {
		this.isDraw = isDraw;
	}
	public String getRefBankCode() {
		return refBankCode;
	}
	public void setRefBankCode(String refBankCode) {
		this.refBankCode = refBankCode;
	}

}
