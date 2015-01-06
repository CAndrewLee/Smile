package com.somnus.biz.income;

import org.junit.Test;

import com.somnus.biz.income.common.IncomeConstants;
import com.somnus.biz.income.resource.IncomeResource;
import com.somnus.message.Message;
import com.somnus.message.account.AccountResponse;
import com.somnus.message.account.IncomeRequest;
import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.JsonUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * IncomeResourceTest
 *
 * @author levis
 * @version 1.0 14-6-7
 */
public class IncomeResourceTest extends AbstractTestSupport {

    @Test
    public void testBankIncome() throws Exception {
        IncomeRequest incomeRequest = new IncomeRequest();
        incomeRequest.setSysCode("1001");
        incomeRequest.setBrcCode("13");
        incomeRequest.setTranCode("1101");
        incomeRequest.setChannelNo("1101");
        incomeRequest.setTerminalNo("terminalNo");
        incomeRequest.setFrontNo("frontNo");
        incomeRequest.setFrontTime("setFrontTime");

        /*incomeRequest.setPrdCode("1301");*/
        incomeRequest.setIpsBillNo("ipsBillNo");
        incomeRequest.setAppTranNo("Income"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ (int)Math.random()*100);
        incomeRequest.setAppTranDate(new Date());
        incomeRequest.setMerBillNo("merBillNo");
        incomeRequest.setPayTranNo("payTranNo");
        incomeRequest.setInitiatorFlg("0");
        incomeRequest.setPayeeCode("100076");
        incomeRequest.setPayeeType("1");
        incomeRequest.setPayeeAccCode("1000760015");
        incomeRequest.setTranType("1011");
        incomeRequest.setChannelCode("1100113100000001");
        incomeRequest.setSupplierCode("1100");
        incomeRequest.setBankAccCode("1001278619005534066");
        incomeRequest.setCcyCode("156");
        incomeRequest.setTranAmt(new BigDecimal("600"));
        incomeRequest.setOrdAmt(new BigDecimal("598"));
        incomeRequest.setFeeWay("1");
        incomeRequest.setFeeAmt(new BigDecimal("2"));
        incomeRequest.setThdAccCode(null);
        incomeRequest.setBankCost(new BigDecimal("1"));
        incomeRequest.setTranRemark("tranRemark");

        incomeRequest.setIsFee(IncomeConstants.IS_FEE_TRUE);
        incomeRequest.setFeeType("1");
        incomeRequest.setBankCost(new BigDecimal("0.5"));
        incomeRequest.setFeeRate(new BigDecimal("1"));
        incomeRequest.setFeeStlMode("1");
        incomeRequest.setRefundFeeBk("0");
        incomeRequest.setBankFeeType("10");
        incomeRequest.setBankFeeRate(new BigDecimal("1"));
        incomeRequest.setDepositDeadLine(5);
        incomeRequest.setSecurityDeposit(new BigDecimal("0"));

        IncomeResource incomeResource = ApplicationContextHolder.getBean(IncomeResource.class);
        System.out.println("银行卡收单请求>>>:"+ JsonUtils.toString(incomeRequest));
        Message message = incomeResource.bankIncome(incomeRequest);
        AccountResponse accountResponse =(AccountResponse)message;
        System.out.println("银行卡收单响应<<<:"+JsonUtils.toString(accountResponse));
        try {
            //等待mq异步处理完成
            Thread.currentThread().sleep(3600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
