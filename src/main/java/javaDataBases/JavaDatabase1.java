package javaDataBases;

import java.sql.*;

public class JavaDatabase1 {
    public static void main(String[] args) {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.160:3306";     //mysqlPractice
            //连接数据库
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            //创建语句执行平台对象
            Statement sm = conn.createStatement();
            sm.execute("use mysqlPractice;");
            sm.execute("alter table class add column basic nvarchar(10) default 0;");
            ResultSet rs1 = sm.executeQuery("show databases;");
            while(rs1.next()){
                System.out.println(rs1.getString(1));
            }
            ResultSet rs2 = sm.executeQuery("select * from class;");
            /*
            resultSet.next();       //指针下一行
            resultSet.first();      //指针第一行
            resultSet.last();       //指针最后一行
            resultSet.getString(int columnNum);      //根据指针获取列号为"columnNum"的字符串,表格第一列的列号为"1";
            resultSet.getString(String columnName)   //根据指针获取列名为"columnName"的字符串
            resultSet.getInt(int columnNum);
            resultSet.getInt(String columnName);
            ...
            */
            while(rs2.next()){
                System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3));
                System.out.println(rs2.getInt(1)+"\t"+rs2.getInt(3));
                System.out.println("-----------------------");
                rs2.next(); //遍历过程中再执行一次next(),相当于步进 "+1" → 步进: 2;
            }

            sm.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
