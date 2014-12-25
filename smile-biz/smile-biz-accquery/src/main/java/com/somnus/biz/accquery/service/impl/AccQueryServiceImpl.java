package com.somnus.biz.accquery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.base.dao.TrnTransactionDao;
import com.somnus.biz.accquery.dao.PaymentAppDao;
import com.somnus.biz.accquery.service.AccQueryService;
import com.somnus.message.accquery.QueryPayAppOrder;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;
import com.somnus.support.common.MsgCodeList;
import com.somnus.support.exceptions.BizException;

@Service
public class AccQueryServiceImpl implements AccQueryService {
	
	@Autowired
	private MessageSourceAccessor msa;
	@Autowired
	private PaymentAppDao paymentAppDao;

	@Override
	public QueryPayAppResponse queryPaymentApp(QueryPayAppRequest request) throws Exception {
		if(request == null) {
			throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001, new Object[]{"QueryPayAppRequest"}));
		}
		PageList<QueryPayAppOrder> pagelist = paymentAppDao.selectPayAppOrders(request,new PageBounds(request.getPageNum(),request.getPageSize()));
		int total = 0;//总记录数
		if(pagelist != null && !pagelist.isEmpty()) {
			total = pagelist.getPaginator().getTotalCount();
		}
		QueryPayAppResponse response = new QueryPayAppResponse();
		response.setPageNum(request.getPageNum());
		response.setPageSize(request.getPageSize());
		response.setRowCount(total);
		response.setOrders(pagelist);
		return response;
	}
}
