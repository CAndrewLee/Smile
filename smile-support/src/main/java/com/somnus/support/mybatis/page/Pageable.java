package com.somnus.support.mybatis.page;

/**
 * Pageable
 *
 * @author levis
 * @version 1.0 13-5-15
 */
public class Pageable {
    /*当前页码*/
    private int currentPage;
    /*页大小*/
    private int pageSize;
    /*总数*/
    private long totalRows;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
