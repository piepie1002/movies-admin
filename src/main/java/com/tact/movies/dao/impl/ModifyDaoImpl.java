package com.tact.movies.dao.impl;

import com.tact.movies.dao.ModifyDao;
import com.tact.movies.entity.Film;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModifyDaoImpl implements ModifyDao {
    @Override
    public int modifyData(Film film) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        String sql = "update t_film set name =?,image=?,on_decade=?," +
                "status=?,resolution=?,type_name=?,actor=?,loc_name=?," +
                "plot=? where id=?";
        try{
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,film.getName());
            ps.setString(2,film.getImage());
            ps.setString(3,film.getOnDecade());
            ps.setString(4,film.getStatus());
            ps.setString(5,film.getResolution());
            ps.setString(6,film.getTypeName());
            ps.setString(7,film.getActor());
            ps.setString(8,film.getLocName());
            ps.setString(9,film.getPlot());
            ps.setString(10,film.getId());

            rSet = ps.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            DbManager.closeAll(ps,conn);
        }
        return rSet;
    }
}
