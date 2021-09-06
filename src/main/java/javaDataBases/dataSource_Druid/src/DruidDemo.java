package javaDataBases.dataSource_Druid.src;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //通过类加载器获取Properties对象的属性
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        System.out.println(properties);
        //通过DruidDataSourceFactory的createDataSource(<Properties> properties)方法创建DataSource的实现类
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
