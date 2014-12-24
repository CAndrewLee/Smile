package com.somnus.base.common;

import com.somnus.base.domain.TrnTransaction;
import com.somnus.message.account.AccountResponse;

public class BusinessUtil {
	
	/**
	 * 设置账务返回结果报文头
	 * @param repMsg
	 * @param trntransaction
	 */
	public static void setRepMsg(AccountResponse repMsg, TrnTransaction trntransaction) {
		MessageUtil.createCommMsg(repMsg);
		repMsg.setAccDate(trntransaction.getAccDate());
		repMsg.setAccTranNo(trntransaction.getAccTranNo());
		repMsg.setAppTranNo(trntransaction.getAppTranNo());
	}

}
