package com.tact.movies.dao;

import com.tact.movies.entity.Film;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;

import java.util.List;

//后台添加新影片
public interface AddFilmDao {

    //获取一级目录对应所有二级目录
    List<SubClass> selectSubClasses(String id);

    //获取二级目录对应的所有三级目录
    List<Type> selectTypes(String id);

    //添加影片
    int insertFilm(Film film);
}
