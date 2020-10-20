package com.tact.movies.dao;

import com.tact.movies.entity.*;

import java.util.List;

//后台添加目录
public interface AddCatalogDao {
    //获取所有一级目录
    List<CateLog> selectCatelogs();

    //获取一级目录对应所有二级目录
    List<SubClass> selectSubClasses(String id);

    //获取二级目录对应的所有三级目录
    List<Type> selectTypes(String id);

    //根据name获取一级目录
    CateLog selectCatelog(String name);

    //根据name获取二级目录
    SubClass selectSubClass(String name);

    //根据name获取三级目录
    Type selectType(String name);

    //根据name获取地区
    Loc selectLoc(String name);

    //根据name获取级别
    Level selectLevel(String name);

    //根据name获取年代
    Decade selectDecade(String name);

    //添加一级目录
    int insertCatelog(CateLog cateLog);

    //添加二级目录
    int insertSubClass(SubClass subClass);

    //添加三级目录
    int insertType(Type type);

    //添加地区
    int insertLoc(Loc loc);

    //添加级别
    int insertLevel(Level level);

    //添加年代
    int insertDecade(Decade decade);

}
