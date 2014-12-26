package com.somnus.biz.accquery;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Test;

import com.somnus.biz.accquery.resource.AccQueryResource;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;
import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.JsonUtil;

/**
 * 计费Service测试
 *
 */
public class AccQueryResourceTest extends AbstractTestSupport{
    
    @Test
    public void queryPaymentAppTestcase() throws Exception {
    	QueryPayAppRequest request = new QueryPayAppRequest();
    	request.setSysCode("test");
    	request.setBrcCode("test");
    	request.setChannelNo("test");
    	request.setTerminalNo("test");
    	request.setFrontNo("test");
    	request.setFrontTime("test");
    	request.setPageNum(2);
    	request.setPageSize(10);
    	AccQueryResource sccQueryResource = ApplicationContextHolder.getBean(AccQueryResource.class);
    	QueryPayAppResponse response = sccQueryResource.queryPaymentApp(request);
    	System.out.println("响应结果>>>>>>>>>>>>> : " + JsonUtil.toString(response));
    }
}
