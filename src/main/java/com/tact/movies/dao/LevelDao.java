package com.tact.movies.dao;

import com.tact.movies.entity.Level;

public interface LevelDao {
    //根据name获取级别
    Level selectLevel(String levelName);

    //添加级别
    int insertLevel(Level level);
}
