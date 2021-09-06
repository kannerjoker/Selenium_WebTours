package javaDataBases.dataSource_Spring.src;

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

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbcSource.properties");
            pro.load(is);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }

    /**
     * 获取DataSource连接池
     */
    public static DataSource getDataSource() {
        return ds;
    }
    /**
     * 释放资源:<BR>
     * <P>
     * &nbsp&nbsp&nbsp&nbsp三个参数
     * */
    public static void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *释放资源:<BR>
     *&nbsp&nbsp&nbsp&nbsp两个参数
     * */
    public static void close(Connection conn,Statement st){
        close(conn,st,null);
    }
}
