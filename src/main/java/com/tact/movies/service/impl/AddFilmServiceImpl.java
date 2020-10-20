package com.tact.movies.service.impl;

import com.tact.movies.dao.AddFilmDao;
import com.tact.movies.dao.impl.AddFilmDaoImpl;
import com.tact.movies.entity.Film;
import com.tact.movies.service.AddFilmService;

public class AddFilmServiceImpl implements AddFilmService {
    AddFilmDao afd = new AddFilmDaoImpl();

    @Override
    public boolean AddFilm(Film film) {
        int count = afd.insertFilm(film);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
