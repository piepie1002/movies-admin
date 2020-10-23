package com.tact.movies.dao;

import com.tact.movies.entity.CateLog;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface CateLogDao {
    List<CateLog> selectCateLogList();

    //根据name获取指定一级目录
    CateLog selectCateLog(String cateLogName);

    //添加一级目录
    int insertCateLog(CateLog cateLog);
}
