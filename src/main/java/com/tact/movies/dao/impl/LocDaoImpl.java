package com.tact.movies.dao.impl;

import com.tact.movies.dao.LocDao;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Loc;
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
public class LocDaoImpl implements LocDao {
    @Override
    public List<Loc> selectLocList() {
        String sql = "select id,is_use,name from t_loc";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Loc> list = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                int isUse = rSet.getInt(2);
                String name = rSet.getString(3);
                Loc loc = new Loc(id, isUse, name);
                list.add(loc); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,conn,ps);
        }
        return list;
    }

    //根据name获取地区
    @Override
    public Loc selectLoc(String locName) {
        String sql = "select id,name from t_loc where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Loc loc = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,locName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                loc = new Loc(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return loc;
    }

    //添加地区
    @Override
    public int insertLoc(Loc loc) {
        int count = 0;
        String sql = "insert into t_loc(id,name,is_use) value(?,?,?);";
        count = DbManager.commonUpdate(sql, loc.getId(),loc.getName(),loc.getIsUse());
        return count;
    }
}
