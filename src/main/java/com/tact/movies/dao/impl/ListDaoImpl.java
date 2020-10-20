package com.tact.movies.dao.impl;

import com.tact.movies.dao.ListDao;
import com.tact.movies.entity.Film;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ListDaoImpl implements ListDao {
    @Override
    public List<Film> selectAllFilmsList() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Film> list = null;
        String sql = "select id,image,name,on_decade,type_name from t_film";
        try{
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList();
            while (rSet.next()){
                String id = rSet.getString(1);
                String image = rSet.getString(2);
                String name = rSet.getString(3);
                String on_decade = rSet.getString(4);
                String type_name = rSet.getString(5);
                Film film = new Film();
                film.setId(id);
                film.setImage(image);
                film.setName(name);
                film.setOnDecade(on_decade);
                film.setTypeName(type_name);
                list.add(film);
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return list;
    }
}
