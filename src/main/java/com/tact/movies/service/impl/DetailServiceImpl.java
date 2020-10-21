package com.tact.movies.service.impl;

import com.tact.movies.dao.FilmsDao;
import com.tact.movies.dao.impl.FilmsDaoImpl;
import com.tact.movies.entity.Film;
import com.tact.movies.service.DetailService;

public class DetailServiceImpl implements DetailService {
    private FilmsDao filmsDao =new FilmsDaoImpl();
    @Override
    public Film getDetail(String id) {
        return  filmsDao.selectMoviesById(id);
    }
}
