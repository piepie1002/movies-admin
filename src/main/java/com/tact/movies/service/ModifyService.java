package com.tact.movies.service;

import com.tact.movies.entity.*;

import java.util.List;

public interface ModifyService {
    int ModifyData(Film film);
    Film ShowFilm(String id);
    List<Decade> ShowDecade();
    List<Loc> ShowLoc();
    List<CateLog> ShowCateLog();
}
