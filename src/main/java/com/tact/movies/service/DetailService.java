package com.tact.movies.service;

import com.tact.movies.entity.Film;
import com.tact.movies.utils.SortData;

public interface DetailService {
    Film getDetail(String id);
}
