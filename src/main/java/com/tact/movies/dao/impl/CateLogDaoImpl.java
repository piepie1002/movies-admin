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
        String sql = "select id,name from t_catelog where is_use = 1";
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

    //根据name获取指定一级目录
    @Override
    public CateLog selectCateLog(String cateLogName) {
        String sql = "select id,name from t_catelog where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        CateLog cateLog = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,cateLogName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                cateLog = new CateLog(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return cateLog;
    }

    //添加一级目录
    @Override
    public int insertCateLog(CateLog cateLog) {
        int count = 0;
        String sql = "insert into t_catelog(id,name,is_use) value(?,?,?);";
        count = DbManager.commonUpdate(sql, cateLog.getId(),cateLog.getName(),cateLog.getIsUse());
        return count;
    }
}
