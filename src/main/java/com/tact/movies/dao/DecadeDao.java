package com.tact.movies.dao;

import com.tact.movies.entity.Decade;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface DecadeDao {
    List<Decade>selectDecadeList();

    //根据name获取年代
    Decade selectDecade(String decadeName);

    //添加年代
    int insertDecade(Decade decade);
}
