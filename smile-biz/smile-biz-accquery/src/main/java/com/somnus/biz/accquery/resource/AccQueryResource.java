package com.somnus.biz.accquery.resource;

import javax.validation.Valid;

import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;

/**
 * 查询接口
 *
 */
public interface AccQueryResource {
	/**
	 * 拒付审批查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryPayAppResponse queryPaymentApp(@Valid QueryPayAppRequest request);
	
}
