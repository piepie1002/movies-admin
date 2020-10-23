package com.tact.movies.service;

import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.entity.*;

public interface AddCateLogService {
    //获取一级目录数据集
    TypeSelectedData getCateLogData();
    //根据一级目录获取二级目录数据集
    TypeSelectedData getSubClassData(String cateLogId);
    //根据二级目录获取三级目录数据集
    TypeSelectedData getTypeData(String subClassId);

    //添加一级目录
    boolean insertCateLog(CateLog cateLog);

    //添加二级目录
    boolean insertSubClass(SubClass subClass);

    //添加三级目录
    boolean insertType(Type type);

    //添加地区
    boolean insertLoc(Loc loc);

    //添加级别
    boolean insertLevel(Level level);

    //添加年代
    boolean insertDecade(Decade decade);

}
