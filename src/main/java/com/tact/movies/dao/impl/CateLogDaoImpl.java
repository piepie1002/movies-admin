package com.tact.movies.dao.impl;

import com.tact.movies.dao.CateLogDao;
import com.tact.movies.entity.CateLog;
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
public class CateLogDaoImpl implements CateLogDao {
    @Override
    public List<CateLog> selectCateLogList() {
        String sql = "select id,name from t_catelog";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<CateLog>list = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                String name = rSet.getString(2);
                CateLog cateLog = new CateLog(id, name);
                list.add(cateLog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return list;
    }
}
