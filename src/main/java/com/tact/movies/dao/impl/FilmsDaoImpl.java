package com.tact.movies.dao.impl;

import com.tact.movies.dao.FilmsDao;
import com.tact.movies.entity.Film;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmsDaoImpl implements FilmsDao {
    @Override
    public List<Film> selectMovies() {
        String sql ="select id,image,name,on_decade,type_name from t_film where cate_log_name='电影' limit 0,12";
        Connection conn = null;
        PreparedStatement pre=null;
        ResultSet rSet =null;
        ArrayList<Film> list=null;
        try {
            conn = DbManager.getInstance().getConn();
            pre = conn.prepareStatement(sql);
            rSet = pre.executeQuery();
            list = new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                String image = rSet.getString(2);
                String name = rSet.getString(3);
                String onDecade = rSet.getString(4);
                String typeName = rSet.getString(5);
                Film film = new Film();
                film.setId(id);
                film.setName(name);
                film.setImage(image);
                film.setOnDecade(onDecade);
                film.setTypeName(typeName);
                list.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally {
            DbManager.closeAll(rSet,pre,conn);
        }
        return list;
    }

    @Override
    public Film selectMoviesById(String id) {
        String sql = "SELECT id, actor, cate_log_name, cate_log_id," +
                " evaluation, image, isUse, loc_name, loc_id, " +
                "name, on_decade, plot, resolution, status, " +
                "sub_class_name, sub_class_id, type_name, " +
                "type_id FROM t_film  where id=?";
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet resultSet = null;
        Film film = null;
        try {
            conn = DbManager.getInstance().getConn();
            pre=conn.prepareStatement(sql);
            pre.setString(1, id);
            resultSet = pre.executeQuery();
            while (resultSet.next()) {
                film = new Film();
                film.setId(resultSet.getString(1));
                film.setActor(resultSet.getString(2));
                film.setCateLogName(resultSet.getString(3));
                film.setCateLogId(resultSet.getString(4));
                film.setEvaluation(resultSet.getDouble(5));
                film.setImage(resultSet.getString(6));
                film.setIsUse(resultSet.getInt(7));
                film.setLocName(resultSet.getString(8));
                film.setLocId(resultSet.getString(9));
                film.setName(resultSet.getString(10));
                film.setOnDecade(resultSet.getString(11));
                film.setPlot(resultSet.getString(12));
                film.setResolution(resultSet.getString(13));
                film.setStatus(resultSet.getString(14));
                film.setSubClassName(resultSet.getString(15));
                film.setSubClassId(resultSet.getString(16));
                film.setTypeName(resultSet.getString(17));
                film.setTypeId(resultSet.getString(18));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            DbManager.closeAll(resultSet,pre,conn);
        }
        return film;
    }
}
