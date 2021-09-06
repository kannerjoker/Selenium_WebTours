package javaDataBases.dataSource_C3P0.src;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Demo_1 {
    public static void main(String[] args) {
        DataSource dataSource = new ComboPooledDataSource("newConfig");
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            for (int i = 0; i < 8; i++) {
                conn = dataSource.getConnection();
                System.out.println((i+1) + " : " + conn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
