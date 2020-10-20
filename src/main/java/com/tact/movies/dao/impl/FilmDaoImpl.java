package com.tact.movies.dao.impl;

import com.tact.movies.dao.FilmDao;
import com.tact.movies.entity.Film;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author LIN
 * @since JDK 1.8
 */
public class FilmDaoImpl implements FilmDao {
    @Override
    public List<Film> selectFilmList() {
        String sql = "SELECT id, actor, cate_log_name, cate_log_id," +
                " evaluation, image, isUse, loc_name, loc_id, " +
                "name, on_decade, plot, resolution, status, " +
                "sub_class_name, sub_class_id, type_name, " +
                "type_id FROM t_film ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Film>list = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                String actor = rSet.getString(2);
                String cateLogName = rSet.getString(3);
                String cateLogID = rSet.getString(4);
                double evaluation = rSet.getDouble(5);
                String image = rSet.getString(6);
                int isUse = rSet.getInt(7);
                String locName = rSet.getString(8);
                String locID = rSet.getString(9);
                String name = rSet.getString(10);
                String onDecade = rSet.getString(11);
                String plot = rSet.getString(12);
                String resolution = rSet.getString(13);
                String status = rSet.getString(14);
                String subClassName = rSet.getString(15);
                String subClassID = rSet.getString(16);
                String typeName = rSet.getString(17);
                String typeID = rSet.getString(18);
                Film film = new Film(id,actor,cateLogName,cateLogID,evaluation,image,isUse,
                        locName,locID,name,onDecade,plot,resolution,status,subClassName,subClassID,
                        typeName,typeID);
                list.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,conn,ps);
        }
        return list;
    }

    @Override
    public List<Film> selectCateLogName(String cateLogName,int start,int end) {
        String sql = "SELECT id, actor, cate_log_name, cate_log_id," +
                " evaluation, image, isUse, loc_name, loc_id, " +
                "name, on_decade, plot, resolution, status, " +
                "sub_class_name, sub_class_id, type_name, " +
                "type_id FROM t_film where cate_log_name= ? limit ?,? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Film>list = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,cateLogName);
            ps.setInt(2,start);
            ps.setInt(3,end);
            rSet = ps.executeQuery();
            list=new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                String actor = rSet.getString(2);
                String cateName = rSet.getString(3);
                String cateLogID = rSet.getString(4);
                double evaluation = rSet.getDouble(5);
                String image = rSet.getString(6);
                int isUse = rSet.getInt(7);
                String locName = rSet.getString(8);
                String locID = rSet.getString(9);
                String name = rSet.getString(10);
                String onDecade = rSet.getString(11);
                String plot = rSet.getString(12);
                String resolution = rSet.getString(13);
                String status = rSet.getString(14);
                String subClassName = rSet.getString(15);
                String subClassID = rSet.getString(16);
                String typeName = rSet.getString(17);
                String typeID = rSet.getString(18);
                Film film = new Film(id,actor,cateName,cateLogID,evaluation,image,isUse,
                        locName,locID,name,onDecade,plot,resolution,status,subClassName,subClassID,
                        typeName,typeID);
                list.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return list;
    }

    @Override
    public Film selectFilmByID(String id) {
        String sql = "SELECT id, actor, cate_log_name, cate_log_id," +
                " evaluation, image, isUse, loc_name, loc_id, " +
                "name, on_decade, plot, resolution, status, " +
                "sub_class_name, sub_class_id, type_name, " +
                "type_id FROM t_film  where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Film film = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            resultSet = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbManager.closeAll(resultSet,conn,ps);
        }
        return film;
    }
}
