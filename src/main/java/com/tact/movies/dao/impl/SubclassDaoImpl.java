package com.tact.movies.dao.impl;

import com.tact.movies.dao.SubclassDao;
import com.tact.movies.entity.Subclass;
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
public class SubclassDaoImpl implements SubclassDao {
    @Override
    public List<Subclass> selectSubClassList() {
        String sql = "select id,is_use,name,catalog_id from t_subclass";
        Connection conn = null;
        ResultSet rSet = null;
        PreparedStatement ps = null;
        List<Subclass>list = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            rSet = ps.executeQuery();
            list = new ArrayList<>();
            while (rSet.next()){
                String id = rSet.getString(1);
                int isUse = rSet.getInt(2);
                String name = rSet.getString(3);
                String catalogId = rSet.getString(4);
                Subclass subclass = new Subclass(id, isUse, name, catalogId);
                list.add(subclass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,conn,ps);
        }
        return list;
    }
}
