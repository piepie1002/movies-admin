package com.tact.movies.service;

import com.tact.movies.entity.Decade;
import com.tact.movies.entity.Film;
import com.tact.movies.entity.Loc;

import java.util.List;

public interface ModifyService {
    int ModifyData(Film film);
    Film ShowFilm(String id);
    List<Decade> ShowDecade();
    List<Loc> ShowLoc();
}
