package com.tact.movies.service.impl;

import com.tact.movies.dao.TeleplayDao;
import com.tact.movies.dao.impl.TeleplayDaoImpl;
import com.tact.movies.entity.Film;
import com.tact.movies.service.TelService;
import com.tact.movies.utils.SortData;

import java.util.List;

public class TelServiceImpl  implements TelService {
    TeleplayDao teleplayDao =new TeleplayDaoImpl();
    @Override
    public SortData getTel() {
        SortData sortData = new SortData();
        List<Film> film = teleplayDao.selectTeleplay();
        sortData.setFilms(film);
        return sortData;
    }
}
