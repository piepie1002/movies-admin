package com.tact.movies.dao.impl;

import com.tact.movies.dao.LocDao;
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
}
