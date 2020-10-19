package com.tact.movies.dao;

import com.tact.movies.entity.CateLog;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface CateLogDao {
    List<CateLog>selectCateLogList();
}
