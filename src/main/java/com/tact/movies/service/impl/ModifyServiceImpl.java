package com.tact.movies.service.impl;

import com.tact.movies.dao.DecadeDao;
import com.tact.movies.dao.FilmDao;
import com.tact.movies.dao.LocDao;
import com.tact.movies.dao.ModifyDao;
import com.tact.movies.dao.impl.DecadeDaoImpl;
import com.tact.movies.dao.impl.FilmDaoImpl;
import com.tact.movies.dao.impl.LocDaoImpl;
import com.tact.movies.dao.impl.ModifyDaoImpl;
import com.tact.movies.entity.Decade;
import com.tact.movies.entity.Film;
import com.tact.movies.entity.Loc;
import com.tact.movies.service.ModifyService;
import com.tact.movies.utils.ListData;

import java.util.List;

public class ModifyServiceImpl implements ModifyService {
    ModifyDao modifyDao = new ModifyDaoImpl();
    FilmDao filmDao = new FilmDaoImpl();
    DecadeDao decadeDao = new DecadeDaoImpl();
    LocDao locDao = new LocDaoImpl();
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

    @Override
    public List<Decade> ShowDecade() {
        List<Decade> decadesList = decadeDao.selectDecadeList();
        return decadesList;
    }

    @Override
    public List<Loc> ShowLoc() {
        List<Loc> locsList = locDao.selectLocList();
        return locsList;
    }
}
