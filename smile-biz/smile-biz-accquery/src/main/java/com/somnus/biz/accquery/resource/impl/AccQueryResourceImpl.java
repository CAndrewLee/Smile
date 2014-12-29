package com.somnus.biz.accquery.resource.impl;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.somnus.base.common.Constants;
import com.somnus.base.common.MessageUtil;
import com.somnus.biz.accquery.resource.AccQueryResource;
import com.somnus.biz.accquery.service.AccQueryService;
import com.somnus.message.Message;
import com.somnus.message.accquery.QueryPayAppRequest;
import com.somnus.message.accquery.QueryPayAppResponse;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.util.JsonUtils;


@Component
@Validated
@Path("/com.somnus.biz.accquery.resource.AccQueryResource")
public class AccQueryResourceImpl implements AccQueryResource {
	
	private transient Logger log = LoggerFactory.getLogger(this.getClass());
	@Resource
	private AccQueryService accQueryService;

	@Path("/queryPaymentApp")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public QueryPayAppResponse queryPaymentApp(QueryPayAppRequest request) {
		log.info(Constants.REQUEST_MSG, JsonUtils.toString(request));
		QueryPayAppResponse response = new QueryPayAppResponse();
		Message message = new Message();
		try {
			response = accQueryService.queryPaymentApp(request);
			//返回成功报文
			message = MessageUtil.createCommMsg();
		} catch (BizException e) {
			log.error(Constants.BUSINESS_ERROR,e);
			// 组织错误报文
			message = MessageUtil.errRetrunInAction(e);
		} catch (Exception ex) {
			log.error(Constants.EXCEPTION_ERROR,ex);
			// 组织错误报文
			message = MessageUtil.createErrorMsg();
		}
		log.info(Constants.REPONSE_MSG, JsonUtils.toString(message));
		response.setRepCode(message.getRepCode());
		response.setRepMsg(message.getRepMsg());
		return response;
	}

}
