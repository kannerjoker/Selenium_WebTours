package javaDataBases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class JavaDatabase2 {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://10.130.212.61:3306";
        String userName = "root";
        String passWord = "root";
        Connection conn = DriverManager.getConnection(url,userName,passWord);
        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("show databases;");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        System.out.println("-----------------------------------------------------");

        statement.execute("use mysql;");
        ResultSet rsUser_1 = statement.executeQuery("select host, user, password from user;");

        while(rsUser_1.next()){
            System.out.println(rsUser_1.getString("host")+"\t"+rsUser_1.getString("user")+"\t"+
                                rsUser_1.getString("password"));
        }
        System.out.println("-----------------------------------------------------");

        String[] arrColumns = {"host","user","password"};
        String str = Arrays.toString(arrColumns);
        System.out.println(str.substring(1,str.length()-1));
        String strs = "select " + str.substring(1,str.length()-1) + " from user;";
        System.out.println(strs);
        ResultSet rsUser_2 = statement.executeQuery(strs);
        while(rsUser_2.next()){
            System.out.println(rsUser_2.getString("host")+"\t"+rsUser_2.getString("user")+"\t"+
                    rsUser_2.getString("password"));
        }
        System.out.println("-----------------------------------------------------");

        statement.execute("create database newData;");
        statement.execute("use newData;");
        statement.execute("create table stu(" +
                                "num int(3)  auto_increment," +
                                "name nvarchar(10) default null," +
                                "classGrade int(1) default 1," +
                                "changeTime datetime default current_timestamp on update current_timestamp," +
                                "primary key(num));");
        statement.execute("insert into stu(name,classGrade)" +
                                "values('zhangsan',1),('lisi',3),('wangwu',2);");
        ResultSet rsStu = statement.executeQuery("select * from stu;");
        while(rsStu.next()){
            System.out.println(rsStu.getInt(1)+"\t"+rsStu.getString("name")+"\t"+rsStu.getString("classGrade"));
        }
        statement.execute("flush privileges;");
    }
}
