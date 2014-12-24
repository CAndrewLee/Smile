package com.somnus.base.service;

import com.somnus.base.domain.TrnTransaction;

public interface JmsService {

	/**
	 * 收单队列发送
	 * @param trnTransaction
	 */
	void incomeSend(TrnTransaction trnTransaction);
	/**
	 * 协议出款
	 * @param batchNo
	 */
	void procotolDrawSend(String batchNo);
}
