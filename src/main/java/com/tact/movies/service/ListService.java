package com.tact.movies.service;

import com.tact.movies.entity.Film;
import com.tact.movies.utils.ListData;

public interface ListService {
    ListData getListData();
    Film getFilmData(String name);
}
