package javaDataBases.dataSource_Druid.src;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    //静态代码块
    static{
        try {
            Properties properties = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        return ds.getConnection();
    }
    /**
     * 释放资源
     * Parameter:
     * Statement st,
     * Connection conn
     * */
    public static void close(Statement st,Connection conn){
        /*try {
            if(st!=null){
                st.close();
            }
            if(conn!=null){
                conn.close();//归还连接
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        close(st,conn,null);
    }
    public static void close(Statement st,Connection conn,ResultSet rs){
        try {
            if(st!=null)
                st.close();
            if(conn!=null)
                conn.close();
            if(rs!=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
