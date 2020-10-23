package com.tact.movies.dao.impl;

import com.tact.movies.dao.TypeDao;
import com.tact.movies.entity.SubClass;
import com.tact.movies.entity.Type;
import com.tact.movies.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDao {
    //查询二级目录对应所有三级目录
    @Override
    public List<Type> selectTypeList(String subClassId) {
        String sql = "select id,name from t_type where subclass_id = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Type> list = new ArrayList<>();
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,subClassId);
            rSet = ps.executeQuery();
            while (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                Type type = new Type(id,name);
                list.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return list;
    }

    //根据name获取指定三级目录
    @Override
    public Type selectType(String typeName) {
        String sql = "select id,name from t_type where name = ? and is_use = 1";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Type type = null;
        try {
            conn = DbManager.getInstance().getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,typeName);
            rSet = ps.executeQuery();
            if (rSet.next()){
                String id = rSet.getString("id");
                String name = rSet.getString("name");
                type = new Type(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbManager.closeAll(rSet,ps,conn);
        }
        return type;
    }

    //添加三级目录
    @Override
    public int insertType(Type type) {
        int count = 0;
        String sql = "insert into t_type(id,name,is_use,subclass_id) value(?,?,?,?);";
        count = DbManager.commonUpdate(sql, type.getId(),type.getName(),type.getIsUse(),type.getSubclassId());
        return count;
    }
}
