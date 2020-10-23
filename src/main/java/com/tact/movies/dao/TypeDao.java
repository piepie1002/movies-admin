package com.tact.movies.dao;

import com.tact.movies.entity.Type;

import java.util.List;

public interface TypeDao {

    //获取二级目录对应的所有三级目录
    List<Type> selectTypeList(String subClassId);

    //根据name获取三级目录
    Type selectType(String typeName);

    //添加三级目录
    int insertType(Type type);

}
