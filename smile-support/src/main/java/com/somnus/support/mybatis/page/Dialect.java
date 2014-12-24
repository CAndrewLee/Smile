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
