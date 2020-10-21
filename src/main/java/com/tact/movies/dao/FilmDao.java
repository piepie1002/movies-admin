package com.tact.movies.dao;

import com.tact.movies.entity.Film;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface FilmDao {
    //查询所有Film类
    List<Film>selectFilmList();
    //查询分类
    List<Film>selectCateLogName(String cateLogName, int start, int end);
    //根据id获取详细信息
    Film selectFilmByID(String id);
    //获取总条数
    int getFilmCount();

    
}
