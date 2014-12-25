package com.somnus.biz.accquery;

import org.junit.Test;

import com.somnus.biz.accquery.service.AccQueryService;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;
import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.JsonUtil;

/**
 * 计费Service测试
 *
 */
public class AccQueryServiceTestcase extends AbstractTestSupport{
    
    @Test
    public void queryPaymentAppTestcase() throws Exception {
    	QueryPayAppRequest request = new QueryPayAppRequest();
    	request.setMerAccCode("A0029101");
    	request.setMerCode("A00291");
    	request.setPageNum(1);
    	request.setPageSize(10);
    	AccQueryService accQueryService = ApplicationContextHolder.getBean(AccQueryService.class);
    	QueryPayAppResponse response = accQueryService.queryPaymentApp(request);
    	System.out.println("test result>>>>>>>>>>>>> : " + JsonUtil.toString(response));
    }
}