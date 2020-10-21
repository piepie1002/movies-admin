package com.tact.movies.service;

import com.tact.movies.entity.Film;

public interface ModifyService {
    int ModifyData(Film film);
    Film ShowFilm(String id);
}
