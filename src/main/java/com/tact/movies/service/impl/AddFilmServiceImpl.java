package com.tact.movies.service.impl;

import com.tact.movies.dao.FilmDao;
import com.tact.movies.dao.SubClassDao;
import com.tact.movies.dao.TypeDao;
import com.tact.movies.dao.impl.FilmDaoImpl;
import com.tact.movies.dao.impl.SubClassDaoImpl;
import com.tact.movies.dao.impl.TypeDaoImpl;
import com.tact.movies.data.TypeSelectedData;
import com.tact.movies.entity.Film;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;
import com.tact.movies.service.AddFilmService;

import java.util.List;

public class AddFilmServiceImpl implements AddFilmService {
    FilmDao filmDao = new FilmDaoImpl();
    SubClassDao subClassDao = new SubClassDaoImpl();
    TypeDao typeDao = new TypeDaoImpl();

    //判断上传影片是否成功
    @Override
    public boolean AddFilm(Film film) {
        int count = filmDao.insertFilm(film);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //获取二层目录数据集
    @Override
    public TypeSelectedData getSubClassData(String id) {
        TypeSelectedData data = new TypeSelectedData();
        List<SubClass> subClass = subClassDao.selectSubClassList(id);
        data.setSubClasses(subClass);
        return data;
    }

    //获取三层目录数据集
    @Override
    public TypeSelectedData getTypeData(String id) {
        TypeSelectedData data = new TypeSelectedData();
        List<Type> types = typeDao.selectTypeList(id);
        data.setTypes(types);
        return data;
    }
}
