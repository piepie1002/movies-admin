package com.tact.movies.dao.impl;

import com.tact.movies.dao.SubClassDao;
import com.tact.movies.entity.CateLog;
import com.tact.movies.entity.SubClass;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubClassDaoImpl implements SubClassDao {
    @Override
    public List<SubClass> selectSubClassList() {
        String sql = "select id,is_use,name,catalog_id from t_subclass";
        Connection conn = null;
        ResultSet rSet = null;
        PreparedStatement ps = null;
        List<SubClass>list = null;
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
                SubClass subclass = new SubClass(id, isUse, name, catalogId);
                list.add(subclass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,conn,ps);
        }
        return list;
    }

    //查询一级目录对应所有二级目录
    @Override
    public List<SubClass> selectSubClassList(String cateLogId) {
        String sql = "select id,name from t_subclass where catalog_id = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<SubClass> list = new ArrayList<>();
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,cateLogId);
            rSet = ps.executeQuery();
            while (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                SubClass subClass = new SubClass(id, name);
                list.add(subClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return list;
    }

    //根据name获取指定二级目录
    @Override
    public SubClass selectSubClass(String subClassName) {
        String sql = "select id,name from t_subclass where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        SubClass subClass = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,subClassName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                subClass = new SubClass(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return subClass;
    }

    //添加二级目录
    @Override
    public int insertSubClass(SubClass subClass) {
        int count = 0;
        String sql = "insert into t_subclass(id,name,is_use,catalog_id) value(?,?,?,?);";
        count = DbManager.commonUpdate(sql, subClass.getId(),subClass.getName(),subClass.getIsUse(),subClass.getCatalogId());
        return count;
    }
}
