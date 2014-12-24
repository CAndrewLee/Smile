package com.somnus.support.common;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * BeanUtilsWrapper
 *
 * @author levis
 * @version 1.0 14-5-7
 */
public class BeanUtilsWrapper {
    //null converter
    static {
        ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new DateConverter(null),Date.class);
    }

    public static  void copyProperties(Object des ,Object ori){
        try{
            BeanUtils.copyProperties(des, ori);
        }catch (Throwable ex){
            new RuntimeException(ex);
        }
    }
}
