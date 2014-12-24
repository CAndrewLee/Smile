/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.support.mybatis.page;

/**
 * MyBatis Mapper annotation
 *
 * @author levis
 * @version 1.0 2013-4-08
 */
public interface Dialect {

    public static enum Type {
        ORACLE
    }

    /**
     * page sql create
     *
     * @param sql
     * @param skipResults
     * @param maxResults
     * @return
     */
    public String getLimitString(String sql, int skipResults, int maxResults);
}
