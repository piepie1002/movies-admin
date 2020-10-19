package com.tact.movies.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LIN
 * @since JDK 1.8
 */
public class DbManager {
    private static volatile DbManager instance = null;
    //定义数据源
    private static DataSource ds;
    public static final String DB_PROPERTIES_NAME="db.properties";
    static {
        //创建连接池
        try {
            InputStream is = DbManager.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_NAME);
            Properties ps = new Properties();
            ps.load(is);
            ds = DruidDataSourceFactory.createDataSource(ps);
        } catch (Exception e) {
            System.out.println("连接池创建失败");
        }
    }
    public DbManager() {
    }

    public static DbManager getInstance() {
        if (instance==null){
            synchronized (DbManager.class){
                if (instance==null){
                    instance =new DbManager();
                }
            }
        }
        return instance;
    }
    //获取连接对象的方法
    public Connection getConn(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源的方法
    public static void closeAll(AutoCloseable...closeables){
        if (closeables!=null){
            for (AutoCloseable closeable:closeables) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static DataSource getDs(){
        return ds;
    }
}
