/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
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
