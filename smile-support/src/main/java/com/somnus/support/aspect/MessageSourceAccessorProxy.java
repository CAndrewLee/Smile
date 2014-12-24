/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.support.aspect;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * MessageSourceAccessor由于没有默认构造，手工做代理
 *
 * @author caobin
 * @version 1.0 2013-4-16
 */
public class MessageSourceAccessorProxy {
	
	private static transient Logger log = LoggerFactory.getLogger(MessageSourceAccessorProxy.class);

    /**
     * MessageSource代理
     *
     * @param messageSource
     * @return
     */
	public static MessageSourceAccessor getProxy(MessageSource messageSource){
		log.info("Creating a new proxy for MessageSourceAccessor.");
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MessageSourceAccessor.class);
		enhancer.setCallback(new MessageSourceHandler());
		return (MessageSourceAccessor)enhancer.create(
				new Class[]{MessageSource.class}, new Object[]{messageSource});
		
	}

    /**
     * MessageSourceHandler
     *
     * @return
     */
	private static class MessageSourceHandler implements MethodInterceptor {
		@Override
		public Object intercept(Object obj, Method method, Object[] args,
				MethodProxy proxy) throws Throwable {
			Object result = proxy.invokeSuper(obj, args);
			//仅对首参数为String类型的方法进行处理
			if(args != null && args.length > 0 && (args[0] instanceof String)){
				log.trace("append code before message.");
				return new StringBuilder()
					.append(args[0])
					.append("|")
					.append(result).toString();
			}
			return result;
		}
		
		private transient Logger log = LoggerFactory.getLogger(this.getClass());
	}	
}
