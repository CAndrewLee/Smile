package com.somnus.biz.income.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.base.domain.TrnTransaction;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.jms.AbstractJmsReceiveTemplate;

public class IncomeAction extends AbstractJmsReceiveTemplate {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void execute(Object message) throws Exception {
		log.info("-------收单记账调用开始--------");
		log.info("接收消息：{}", message);
		if (!(message instanceof TrnTransaction)) {
            throw new BizException("报文对象不匹配！");
        }
		TrnTransaction trnTransaction = (TrnTransaction) message;
		log.info("记账流水{}",trnTransaction);
		log.info("-------收单记账调用结束--------");
	}
}
