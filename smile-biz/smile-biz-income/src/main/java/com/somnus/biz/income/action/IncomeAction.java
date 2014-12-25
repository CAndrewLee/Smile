package com.somnus.biz.income.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.somnus.base.domain.TrnTransaction;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.jms.AbstractJmsReceiveTemplate;
import com.somnus.support.util.JsonUtil;

public class IncomeAction extends AbstractJmsReceiveTemplate {

	protected Logger log = LoggerFactory.getLogger(IncomeAction.class);

	@Override
	protected void execute(Object message) throws Exception {
		log.info("-------收单记账调用开始--------");
		log.info("接收消息：{}", message);
		if (!(message instanceof TrnTransaction)) {
			log.error("报文对象不匹配！:{}", new Object[] { message });
            throw new BizException("报文对象不匹配！");
        }
		TrnTransaction trnTransaction = (TrnTransaction) message;
		log.info("记账流水{}",JsonUtil.toString(trnTransaction));
		log.info("-------收单记账调用结束--------");
	}
}
