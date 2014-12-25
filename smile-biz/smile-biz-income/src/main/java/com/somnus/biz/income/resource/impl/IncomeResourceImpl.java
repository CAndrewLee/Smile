package com.somnus.biz.income.resource.impl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.somnus.base.common.BusinessUtil;
import com.somnus.base.common.Constants;
import com.somnus.base.common.MessageUtil;
import com.somnus.base.domain.TrnTransaction;
import com.somnus.base.service.BasBizService;
import com.somnus.base.service.JmsService;
import com.somnus.biz.income.common.IncomeTransfer;
import com.somnus.biz.income.resource.IncomeResource;
import com.somnus.message.account.AccountResponse;
import com.somnus.message.account.IncomeRequest;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.util.JsonUtil;

@Component
@Validated
@Path("/com.somnus.biz.income.resource.IncomeResource")
public class IncomeResourceImpl implements IncomeResource {

    protected static Logger log = LoggerFactory.getLogger(IncomeResourceImpl.class);
    @Autowired
    private BasBizService   basBizService;
    @Autowired
    private JmsService      jmsService;

    @Path("/bankIncome")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public AccountResponse bankIncome(IncomeRequest incomeRequest) {
        log.info(Constants.REQUEST_MSG, JsonUtil.toString(incomeRequest));
        AccountResponse repMsg = new AccountResponse();
        try {
            TrnTransaction trntransaction = IncomeTransfer.msgToTransaction(incomeRequest);
            //6、记账流水落地
            basBizService.insertTranNoSerq(trntransaction);
            //7、发送jms消息
            jmsService.incomeSend(trntransaction);
            //8、返回同步处理结果
            BusinessUtil.setRepMsg(repMsg, trntransaction);
        } catch (BizException e) {
            log.error(Constants.BUSINESS_ERROR, e);
            // 组织错误报文
            MessageUtil.errRetrunInAction(repMsg, e);
        } catch (Exception ex) {
            log.error(Constants.EXCEPTION_ERROR, ex);
            // 组织错误报文
            MessageUtil.createErrorMsg(repMsg);
        }
        log.info(Constants.REPONSE_MSG, JsonUtil.toString(repMsg));
        return repMsg;
    }

}
