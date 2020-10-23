package com.tact.movies.dao;

import com.tact.movies.entity.Film;

import java.util.List;

public interface TeleplayDao {
    List<Film> selectTeleplay();
}
