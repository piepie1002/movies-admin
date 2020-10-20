package com.tact.movies.dao.impl;

import com.tact.movies.dao.DecadeDao;
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
}
