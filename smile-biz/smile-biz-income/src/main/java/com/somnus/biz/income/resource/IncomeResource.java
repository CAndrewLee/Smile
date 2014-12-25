package com.somnus.biz.income.resource;

import javax.validation.Valid;

import com.somnus.message.account.AccountResponse;
import com.somnus.message.account.IncomeRequest;



/**
 * 账户核心收单
 *
 * @author IH745
 * @version 1.0 13-10-9
 */
public interface IncomeResource {
	/**
	 * 银行收单记账操作
	 * @param incomeRequest
	 * @return
	 */
	public AccountResponse bankIncome(@Valid IncomeRequest incomeRequest) ;
	

}
