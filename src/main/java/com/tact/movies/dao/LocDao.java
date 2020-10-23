package com.tact.movies.dao;

import com.tact.movies.entity.Loc;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface LocDao {
    List<Loc>selectLocList();

    //根据name获取地区
    Loc selectLoc(String locName);

    //添加地区
    int insertLoc(Loc loc);
}
