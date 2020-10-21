package com.tact.movies.service;

import com.tact.movies.utils.PageBean;
import com.tact.movies.utils.SortData;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface SortService {
    SortData getSortDate(PageBean pageBean);
    PageBean getPageBean(String curPage);
}
