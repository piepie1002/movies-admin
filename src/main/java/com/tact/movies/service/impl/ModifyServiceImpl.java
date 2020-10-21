package com.tact.movies.service.impl;

import com.tact.movies.dao.FilmDao;
import com.tact.movies.dao.ModifyDao;
import com.tact.movies.dao.impl.FilmDaoImpl;
import com.tact.movies.dao.impl.ModifyDaoImpl;
import com.tact.movies.entity.Film;
import com.tact.movies.service.ModifyService;
import com.tact.movies.utils.ListData;

public class ModifyServiceImpl implements ModifyService {
    ModifyDao modifyDao = new ModifyDaoImpl();
    FilmDao filmDao = new FilmDaoImpl();
    @Override
    public int ModifyData(Film film) {
        int i = modifyDao.modifyData(film);
        return i;
    }

    @Override
    public Film ShowFilm(String id) {
        Film film = filmDao.selectFilmByID(id);
        return film;
    }
}
