package com.tact.movies.dao;

import com.tact.movies.entity.Film;

import java.util.List;

public interface ListDao {
    List<Film> selectAllFilmsList();

    Film selectFilmsList(String name);
}
