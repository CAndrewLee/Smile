package com.somnus.support.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import com.somnus.support.common.Constants;
import com.somnus.support.util.SessionUtil;

/**
 * 日志处理过滤器
 *
 * @author caobin
 * @version 1.0 2012-11-15
 */
public class LoggingProcessFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//扩展日志追踪号
		MDC.put(Constants.SESSION_ID, SessionUtil.getSessionId());
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}

	}
}
