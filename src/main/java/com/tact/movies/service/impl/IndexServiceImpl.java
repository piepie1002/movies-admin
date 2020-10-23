package com.tact.movies.service.impl;

import com.tact.movies.dao.CateLogDao;
import com.tact.movies.dao.FilmsDao;
import com.tact.movies.dao.TeleplayDao;
import com.tact.movies.dao.impl.CateLogDaoImpl;
import com.tact.movies.dao.impl.FilmsDaoImpl;
import com.tact.movies.dao.impl.TeleplayDaoImpl;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Film;
import com.tact.movies.service.IndexService;
import com.tact.movies.utils.SortData;

import java.util.List;

public class IndexServiceImpl implements IndexService {
    CateLogDao cateLogDao =new CateLogDaoImpl();
    FilmsDao filmsDao =new FilmsDaoImpl();


    @Override
    public SortData getIndex() {
        SortData sortData = new SortData();
        List<CateLog> cateLog = cateLogDao.selectCateLogList();
        List<Film> films = filmsDao.selectMovies();
        sortData.setCateLogs(cateLog);
        sortData.setFilms(films);
        return sortData;
    }
}
