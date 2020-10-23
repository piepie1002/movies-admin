package com.tact.movies.dao.impl;

import com.tact.movies.dao.DecadeDao;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.Decade;
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
public class DecadeDaoImpl implements DecadeDao {
    @Override
    public List<Decade> selectDecadeList() {
        //查询语句
        String sql = "select id,is_use,name from t_decade order by name desc";
        //定义连接对象
        Connection conn = null;
        //预加载
        PreparedStatement ps = null;
        //结果集
        ResultSet rSet = null;
        //集合
        List<Decade>list =null;
        try {
            //获取连接对象
            conn = DbManager.getInstance().getConn();
            //折行sql语句
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList<>();
            //遍历结果集
            while (rSet.next()){
                String id = rSet.getString(1);
                int isUse = rSet.getInt(2);
                String name = rSet.getString(3);
                Decade decade = new Decade(id, isUse, name);
                list.add(decade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,conn,ps);
        }
        return list;
    }

    //根据name获取年代
    @Override
    public Decade selectDecade(String decadeName) {
        String sql = "select id,name from t_decade where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Decade decade = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,decadeName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                decade = new Decade(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return decade;
    }

    //添加年代
    @Override
    public int insertDecade(Decade decade) {
        int count = 0;
        String sql = "insert into t_decade(id,name,is_use) value(?,?,?);";
        count = DbManager.commonUpdate(sql, decade.getId(),decade.getName(),decade.getIsUse());
        return count;
    }
}
