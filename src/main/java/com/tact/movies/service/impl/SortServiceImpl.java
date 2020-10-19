package com.tact.movies.service.impl;

import com.tact.movies.dao.impl.CateLogDaoImpl;
import com.tact.movies.entity.CateLog;
import com.tact.movies.service.SortService;
import com.tact.movies.utils.SortData;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class SortServiceImpl implements SortService {
    CateLogDaoImpl cateLogDao = new CateLogDaoImpl();
    @Override
    public SortData getSortDate() {
        List<CateLog> cateLogs = cateLogDao.selectCateLogList();
        SortData sortDate = new SortData();
        sortDate.setCateLogs(cateLogs);
        return sortDate;
    }
}
