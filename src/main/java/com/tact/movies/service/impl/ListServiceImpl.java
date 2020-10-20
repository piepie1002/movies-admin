package com.tact.movies.service.impl;

import com.tact.movies.dao.ListDao;
import com.tact.movies.dao.impl.ListDaoImpl;
import com.tact.movies.entity.Film;
import com.tact.movies.service.ListService;
import com.tact.movies.utils.ListData;

import java.util.List;

public class ListServiceImpl implements ListService {
    ListDao listDao = new ListDaoImpl();

    @Override
    public ListData getListData() {
        ListData listData = new ListData();
        List<Film> films = listDao.selectAllFilmsList();
        listData.setFilms(films);
        return listData;
    }

    @Override
    public Film getFilmData(String name) {
        Film film = listDao.selectFilmsList(name);
        return film;
    }


}
