package com.tact.movies.dao.impl;

import com.tact.movies.dao.TeleplayDao;
import com.tact.movies.entity.Film;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeleplayDaoImpl implements TeleplayDao {
    @Override
    public List<Film> selectTeleplay() {
        String sql ="select id,image,name,on_decade,type_name from t_film where cate_log_name='电视剧' limit 0,12";
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
}
