package com.tact.movies.dao;

import com.tact.movies.entity.Decade;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
public interface DecadeDao {
    List<Decade>selectDecadeList();
}
