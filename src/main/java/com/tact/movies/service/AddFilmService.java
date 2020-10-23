package com.tact.movies.service;

import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.entity.Film;
import jdk.nashorn.internal.ir.CallNode;

public interface AddFilmService {
    //添加影片
    boolean AddFilm(Film film);

    //获取二级目录数据集
    TypeSelectedData getSubClassData(String cateLogId);
    //获取三级目录数据集
    TypeSelectedData getTypeData(String subClassId);
}
