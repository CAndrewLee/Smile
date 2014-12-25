package com.somnus.biz.accquery.service;

import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;

/**
 * 查询接口
 * @author bo.zhang
 *
 */
public interface AccQueryService {
	
	/**
	 * 拒付审批查询
	 * @param request
	 * @return
	 * @throws Exception
	 */
	QueryPayAppResponse queryPaymentApp(QueryPayAppRequest request) throws Exception;

}
