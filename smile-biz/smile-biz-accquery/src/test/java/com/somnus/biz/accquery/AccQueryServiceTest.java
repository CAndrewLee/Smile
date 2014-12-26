package com.somnus.biz.accquery;

import org.junit.Test;

import com.somnus.biz.accquery.service.AccQueryService;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;
import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.JsonUtils;

/**
 * 计费Service测试
 *
 */
public class AccQueryServiceTest extends AbstractTestSupport{
    
    @Test
    public void queryPaymentAppTestcase() throws Exception {
    	QueryPayAppRequest request = new QueryPayAppRequest();
    	request.setPageNum(2);
    	request.setPageSize(10);
    	AccQueryService accQueryService = ApplicationContextHolder.getBean(AccQueryService.class);
    	QueryPayAppResponse response = accQueryService.queryPaymentApp(request);
    	System.out.println("test result>>>>>>>>>>>>> : " + JsonUtils.toString(response));
    }
}
