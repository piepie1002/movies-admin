package com.tact.movies.dao.impl;

import com.tact.movies.dao.LevelDao;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Level;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LevelDaoImpl implements LevelDao {

    //根据name获取级别
    @Override
    public Level selectLevel(String levelName) {
        String sql = "select id,name from t_level where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Level level = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,levelName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                level = new Level(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return level;
    }

    //添加等级
    @Override
    public int insertLevel(Level level) {
        int count = 0;
        String sql = "insert into t_level(id,name,is_use) value(?,?,?);";
        count = DbManager.commonUpdate(sql, level.getId(),level.getName(),level.getIsUse());
        return count;
    }
}
