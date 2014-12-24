package com.somnus.support.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import com.somnus.support.common.Constants;
import com.somnus.support.util.SessionUtil;

/**
 * AbstractJmsReceiveTemplate
 *
 * @author: Fred
 * @version: 13-4-10下午3:19
 */
public abstract class AbstractJmsReceiveTemplate extends MessageListenerAdapter {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void onReceive(Object message) {
        try {
            MDC.put(Constants.SESSION_ID, SessionUtil.getSessionId());
            execute(message);
        } catch (Throwable e) {
            logger.error("MQ消息处理异常{},：{}", message.toString(), e);
        } finally {
            MDC.remove(Constants.SESSION_ID);
        }
    }

    protected abstract void execute(Object message) throws Exception;
}
