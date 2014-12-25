package com.somnus.biz.accquery.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.somnus.message.accquery.QueryPayAppOrder;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.support.mybatis.annotation.MyBatisRepository;

/**
 * 拒付审批DAO
 */
@MyBatisRepository
public interface PaymentAppDao {
	
	/**
	 * 拒付审批查询
	 * @param pageBounds
	 * @param request
	 * @return
	 */
	public PageList<QueryPayAppOrder> selectPayAppOrders(QueryPayAppRequest request,PageBounds pageBounds);

}
