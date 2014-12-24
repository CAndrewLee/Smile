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
 * OracleDialect
 *
 * @author levis
 * @version 1.0 2013-4-08
 */
public class OracleDialect implements Dialect {

    /**
     * oracle page dialect implement
     *
     * @param sql
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public String getLimitString(String sql, int offset, int limit) {
        sql = sql.trim();
        StringBuilder pagingBuilder = new StringBuilder(sql.length() + 100);
        pagingBuilder.append("select * from ( select row_.*, rownum rownum_ from ( ");
        pagingBuilder.append(sql);
        pagingBuilder.append(" ) row_ ) where rownum_ > ").append(offset).append(" and rownum_ <= ").append(offset + limit);
        return pagingBuilder.toString();
    }

}
