package com.tact.movies.dao.impl;

import com.tact.movies.dao.AddFilmDao;
import com.tact.movies.entity.Film;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;
import com.tact.movies.utils.DbManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddFilmDaoImpl implements AddFilmDao {

    //获取subClass
    @Override
    public List<SubClass> selectSubClasses(String id) {
        String sql;
        ResultSet rSet = null;
        List<SubClass> list = new ArrayList<>();
        try {
            sql = "select id,name from t_subclass where catalog_id = ? and is_use = 1";
            rSet = DbManager.commonQuery(sql, id);
            while (rSet.next()){
                String id1 = rSet.getString("id");
                String name = rSet.getString("name");
                SubClass subclass = new SubClass(id1, name);
                list.add(subclass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet);
        }
        return list;
    }

    //获取Type
    @Override
    public List<Type> selectTypes(String id) {
        String sql;
        ResultSet rSet = null;
        List<Type> list = new ArrayList<>();
        try {
            sql = "select id,name from t_type where catalog_id = ? and is_use = 1";
            rSet = DbManager.commonQuery(sql, id);
            while (rSet.next()){
                String id1 = rSet.getString("id");
                String name = rSet.getString("name");
                Type type = new Type(id1, name);
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet);
        }
        return list;
    }

    @Override
    public int insertFilm(Film film) {
        String sql;
        int count;
        sql = "insert into t_film(" +
                "id,name,image,on_dacade,status,resolution,type_id," +
                "actor,loc_name,loc_id,plot,is_vip,isUse) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        count = DbManager.commonUpdate(sql);
        return count;
    }
}
