package javaDataBases;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try {
            PreparedStatementDemo psd = PreparedStatementDemo.class.newInstance();
//            psd.selectEMP();
            psd.updateAccount("zhangsan","lisi",10);
            psd.updateAccount("wangwu","zhaoliu",0.01);
            psd.updateAccount("xiaoliu","xiaoyang",800);
            psd.updateAccount("xiaoliu","xiaoyang",100);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void updateAccount(String customerFrom,String customerTo,double money){
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            FileReader fr = new FileReader("D:\\IdeaProjects\\Selenium_WebTours\\src\\main\\sources\\database.properties");
            Properties info = new Properties();
            info.load(fr);
            conn = DriverManager.getConnection(info.getProperty("url"),info);
            //开始事务
            conn.setAutoCommit(false);
            st = conn.createStatement();
            //创建表格
//            st.execute("drop table if exists account;");
            st.execute("create table if not exists account(" +
                            "id int(2) auto_increment," +
                            "name nvarchar(10)," +
                            "balance double(10,2)," +
                            "primary key(id))");
            //设置用户初始值
            PreparedStatement psmtInsert = conn.prepareStatement("insert into account(name,balance) values(?,?)");
            //检查用户
            PreparedStatement psmtCheck = conn.prepareStatement("select * from account where name=?;" );
            //检查用户customerFrom是否存在
            psmtCheck.setString(1,customerFrom);
            ResultSet rsCheck = psmtCheck.executeQuery();
            if(!rsCheck.next()){
                //用户不存在时新建用户
                psmtInsert.setString(1,customerFrom);
                psmtInsert.setDouble(2,1000);
                psmtInsert.executeUpdate();
            }
            //检查用户customerTo是否存在
            psmtCheck.setString(1,customerTo);
            rsCheck = psmtCheck.executeQuery();
            if(!rsCheck.next()){
                //用户不存在时进行新建
                psmtInsert.setString(1,customerTo);
                psmtInsert.setDouble(2,1000);
                psmtInsert.executeUpdate();
            }

            //执行转账操作
            PreparedStatement psmtUpdate = conn.prepareStatement("update account set balance=balance+? where name=?");
            psmtUpdate.setDouble(1,-money);
            psmtUpdate.setString(2,customerFrom);
            psmtUpdate.executeUpdate();
            psmtUpdate.setDouble(1,+money);
            psmtUpdate.setString(2,customerTo);
            psmtUpdate.executeUpdate();
            ResultSet rs = st.executeQuery("select * from account;");
            //打印表头
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getMetaData().getColumnName(i+1) + "\t");
            }
            System.out.println();
            //打印表格
            while(rs.next()){
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getString(i+1) + "\t");
                }
                System.out.println();
            }
            System.out.println("事务执行成功,提交操作!");
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if(conn!=null){
                    System.out.println("事务执行失败,进行回滚!");
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void selectEMP(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties info = new Properties();
            String url = "jdbc:mysql://10.130.212.160:3306/mysqlPractice?useUnicode=true&characterEncoding=utf8";
            info.setProperty("user","root");
            info.setProperty("password","root");
            Connection conn = DriverManager.getConnection(url,info);
            PreparedStatement psmtQuery = conn.prepareStatement("select * from EMP where deptno=?;");
            psmtQuery.setInt(1,20);
            ArrayList<String> arrayList = new ArrayList();
            ResultSet rs = psmtQuery.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.print(rsmd.getColumnName(i+1) + "\t");
            }

            System.out.println();
            while(rs.next()){
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    System.out.print(rs.getString(i+1) + "\t");
                }
                System.out.println();
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
