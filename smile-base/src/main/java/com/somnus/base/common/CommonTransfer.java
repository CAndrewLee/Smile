package com.somnus.base.common;

import java.math.BigDecimal;
import java.util.Date;
import com.somnus.base.domain.TrnTransaction;
import com.somnus.support.util.DateUtil;

public class CommonTransfer {

	public static void initial(TrnTransaction trntransaction){
		trntransaction.setSubmitTime(new Date());
		trntransaction.setIsDeposit(BasConstants.IS_DEPOSIT_FALSE);
		trntransaction.setAccMode(BasConstants.ACC_MODE_SYN);
		trntransaction.setAccStatus(BasConstants.ACC_STATUS_SUCCESS);
		trntransaction.setBlnStatus(BasConstants.BLN_STATUS_NOTNEED);
		trntransaction.setCreateTime(DateUtil.getCurrentTimeStamp());
		trntransaction.setModifyTime(trntransaction.getCreateTime());
		trntransaction.setCreateBy(BasConstants.DEFAULT_OPERATOR);
		trntransaction.setModifyBy(trntransaction.getCreateBy());
		trntransaction.setBlnMode(BasConstants.BLN_MODE_DEFAULT);
        trntransaction.setFrozenFlag(BasConstants.FROZEN_NO);
		trntransaction.setStatus(BasConstants.STATUS_NORMAL);
		trntransaction.setRefundedAmt(BigDecimal.ZERO);
		trntransaction.setDishonoredAmt(BigDecimal.ZERO);
		trntransaction.setReturnedDepositAmt(BigDecimal.ZERO);
		trntransaction.setFinnishTime(new Date());
	}
}
