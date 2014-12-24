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
