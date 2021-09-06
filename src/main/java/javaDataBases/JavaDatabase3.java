package javaDataBases;

import java.sql.*;

public class JavaDatabase3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://192.168.1.160:3306";
            String user = "root";
            String passwd = "root";
            conn = DriverManager.getConnection(url,user,passwd);
            statement = conn.createStatement();
            ResultSet rs1 = statement.executeQuery("show databases;");
            while(rs1.next()){
                System.out.println(rs1.getString(1));
            }
            statement.execute("use mysqlPractice;");
            ResultSet rs2 = statement.executeQuery("show tables;");
            while(rs2.next()){
                System.out.println(rs2.getString(1));
            }
            statement.execute("drop table if exists stu;");
            statement.execute("create table if not exists stu(" +
                                    "num int(2) auto_increment," +
                                    "name nvarchar(10) default null," +
                                    "grade int(2) default 1," +
                                    "registerTime datetime default current_timestamp on update current_timestamp," +
                                    "primary key(num));");
            statement.execute("insert into stu(name,grade)" +
                                    "values('zhangsan',2),('lisi',1),('wangwu',6);");
            ResultSet rs3 = statement.executeQuery("select * from stu;");
            //获取总行数
            rs3.last();     //指针指向最后一行
            System.out.println("行数: " + rs3.getRow());

            //遍历
            rs3.first();    //指针指向第一行,注意:原指针是从0开始,现在指向的是1,如果用next()再遍历,则是从第2行开始
            System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3));
            while(rs3.next()){
                System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+rs3.getString(3));
            }
            //获取总列数
            ResultSet rs4 = statement.executeQuery("select * from stu;");
            ResultSetMetaData rsmd = rs4.getMetaData();
            System.out.println("列数: " + (rsmd.getColumnCount()-1));
            while(rs4.next()){
                for(int i=1;i<rs4.getMetaData().getColumnCount();i++){
                    System.out.print(rs4.getString(i)+"\t");
                }
                System.out.println();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
