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

import org.apache.ibatis.session.RowBounds;

import java.util.Collections;
import java.util.List;

/**
 * Pagination
 *
 * @author levis
 * @version 1.0 13-4-8
 */
public class Pagination<T> {
    /*每页最大条数*/
    private static final int MAX_PAGE_SIZE=100;
    /*总数*/
    private long totalRows;
    /*页大小*/
    private int pageSize;
    /*当前页码*/
    private int currentPage;
    /*查询结果*/
    private List<T> resultList = Collections.emptyList();

    public Pagination() {
        this(1, MAX_PAGE_SIZE);
    }

    public Pagination(int currentPage) {
        this(currentPage, MAX_PAGE_SIZE);
    }

    public Pagination(int currentPage, int pageSize) {
        setCurrentPage(currentPage);
        setPageSize(pageSize);
    }

    public Pagination(Pageable pageable,List<T> resultList) {
        setCurrentPage(pageable.getCurrentPage());
        setPageSize(pageable.getPageSize());
        setTotalRows(pageable.getTotalRows());
        setList(resultList);
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage < 0) {
            currentPage = 1;
        }
        this.currentPage  = currentPage;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = 15;
        }
        this.pageSize = pageSize;
    }


    protected void onSetList() {
        if (resultList == null || resultList.isEmpty()) {
            totalRows = 0;
            currentPage = 1;
        }
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getList() {
        return resultList;
    }

    public void setList(List<T> list) {
        this.resultList = list;
        onSetList();
    }

    public int getCurrentPage() {
        return currentPage;
    }

}
