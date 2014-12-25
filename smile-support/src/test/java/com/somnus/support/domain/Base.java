package com.somnus.support.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Base {
	private String bankActNo;
	
	private String bankActName;

    private String bankCode;

    private String bankName;

    private String tranDate;

	public String getBankActNo() {
		return bankActNo;
	}

	public void setBankActNo(String bankActNo) {
		this.bankActNo = bankActNo;
	}

	public String getBankActName() {
		return bankActName;
	}

	public void setBankActName(String bankActName) {
		this.bankActName = bankActName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTranDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(this.tranDate==null)
				return null;
			Date date = sdf.parse(this.tranDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar.get(Calendar.DAY_OF_MONTH) + "日";
		} catch (ParseException e) {
			return this.tranDate;
		}
    }

	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

	
}
