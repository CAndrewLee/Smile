package com.somnus.biz.income.common;

import org.springframework.beans.BeanUtils;

import com.somnus.base.common.CommonTransfer;
import com.somnus.base.domain.TrnTransaction;
import com.somnus.message.account.IncomeRequest;
import com.somnus.support.common.Identities;
import com.somnus.support.util.DateUtil;

public class IncomeTransfer extends CommonTransfer{
	/**
	 * 报文转换为实体
	 * @param incomeRequest
	 */
	public static TrnTransaction msgToTransaction(IncomeRequest incomeRequest){
		TrnTransaction trntransaction = new TrnTransaction();
		BeanUtils.copyProperties(incomeRequest, trntransaction);
		msgAdditional(incomeRequest, trntransaction);
		incomeSet(trntransaction);
		return trntransaction;
	}
	
	private static void msgAdditional(IncomeRequest incomeRequest,TrnTransaction trntransaction){
		trntransaction.setMachineNo(incomeRequest.getFrontNo());
		trntransaction.setCusTranNo(incomeRequest.getMerBillNo());
		trntransaction.setChlTranNo(incomeRequest.getPayTranNo());
		trntransaction.setFeeFlag(incomeRequest.getFeeWay());
		trntransaction.setThirdAccCode(incomeRequest.getThdAccCode());
	}
	
	private static void incomeSet(TrnTransaction trntransaction){
		CommonTransfer.initial(trntransaction);
		trntransaction.setAccTranNo(Identities.randomString(10, true));
		trntransaction.setAccDate(DateUtil.stringtoDate(DateUtil.getNow(), DateUtil.FORMAT_FOUR));
		trntransaction.setBlnStatus(IncomeConstants.BLN_STATUS_NOTENTER);
		trntransaction.setAccMode(IncomeConstants.ACC_MODE_ASYN);
		trntransaction.setAccStatus(IncomeConstants.ACC_STATUS_HANDLING);
	}

}
