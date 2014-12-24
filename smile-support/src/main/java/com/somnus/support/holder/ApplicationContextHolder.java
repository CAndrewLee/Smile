package com.somnus.support.holder;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextHolder
 *
 * @author levis
 * @version 1.0 2012-8-08
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(String id, Class<T> clazz) {
        T bean = getApplicationContext().getBean(id,clazz);
        if (bean == null) {
            throw new IllegalStateException("bean factory is null");
        }
        return bean;
    }

    public static <T> T getBean(Class<T> clazz) {
        T bean = getApplicationContext().getBean(clazz);
        if (bean == null) {
            throw new IllegalStateException("bean factory is null");
        }
        return bean;
    }

    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicationContext is not init.");
        }
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void cleanHolder() {
        applicationContext = null;
    }
}
