package com.somnus.base.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * DomainSupport
 *
 * @author: levis
 * @version: 2013-09-26
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 7293660884152874422L;

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this,ToStringStyle.SHORT_PREFIX_STYLE) {
            /*null field not output*/
            protected boolean accept(Field f) {
                try{
                    return super.accept(f) && getValue(f)!=null;
                }catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            }
        }.toString();
    }
}
