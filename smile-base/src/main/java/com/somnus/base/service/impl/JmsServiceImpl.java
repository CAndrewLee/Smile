package com.somnus.base.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.somnus.base.domain.TrnTransaction;
import com.somnus.base.service.JmsService;


@Service
public class JmsServiceImpl implements JmsService {

	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination incomeQueue;
	@Resource
	private Destination procotolDrawQueue;

	@Override
	public void incomeSend(TrnTransaction trnTransaction) {
		jmsTemplate.convertAndSend(incomeQueue,trnTransaction);
	}

	@Override
	public void procotolDrawSend(String batchNo) {
		jmsTemplate.convertAndSend(procotolDrawQueue,batchNo);
	}

}
