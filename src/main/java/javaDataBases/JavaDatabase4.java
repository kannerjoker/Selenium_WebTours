package javaDataBases;

import java.sql.*;
import java.util.Arrays;

/*
 * DBC提供了DatabaseMetaData来封装数据库连接对应的数据库信息，通过Connection的getMetaData方法来获取该对象。
 * DatabaseMetaData接口通常数据库驱动提供商完成实现，其作用是让用户了解数据库的底层信息。
 * 使用该接口可以了解数据库底层的实现，便于完成多个数据库的相互切换。
 */
public class JavaDatabase4 {
    public static void main(String[] args) throws Exception {
        //连接sqlite数据库
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:D:\\IdeaProjects\\Selenium_WebTours\\src\\main\\javaDataBase\\dataStatistics.sqlite";
        Connection connSqlite = DriverManager.getConnection(url);
        Statement statementSqlite = connSqlite.createStatement();

        ResultSet resultSetSqlite1 = statementSqlite.executeQuery("select * from Temp;");
        //获取表格列数
        ResultSetMetaData rsmdS = resultSetSqlite1.getMetaData();
        int columnCount_S = rsmdS.getColumnCount();     //sqlite 获取的列数与实际列数一致
        System.out.println("columnCount_S = " + columnCount_S);
        //获取表头
        for (int i = 1; i < columnCount_S + 1; i++) {
            System.out.print(rsmdS.getColumnName(i) + "\t");
        }
        System.out.println();
        int rowCount_S = 0;
        while(resultSetSqlite1.next()){
            for (int i = 1; i < 10; i++) {
                System.out.print(resultSetSqlite1.getString(i) + "\t");
            }
            System.out.println();
            rowCount_S++;
        }
        System.out.println("rowCount_S = " + rowCount_S);
        System.out.println("-----------------------");

        //连接mysql数据库
        Class.forName("com.mysql.cj.jdbc.Driver");
        //useUnicode表示允许使用自定义的Unicode,
        //characterEncoding是给定自定义的Unicode是什么
       /* 就是mysql如果你的字符集没有设置，或者没有设置好的话，默认是latin1
        那么你的utf-8直接传过来还是会出问题
        "?useUnicode=true&characterEncoding=utf8"   保证连接时就是传递的参数就是utf8;
        */
        String urlMysql = "jdbc:mysql://10.130.212.160:3306?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String passwd = "root";
        Connection connMysql = DriverManager.getConnection(urlMysql,user,passwd);
        Statement statementMysql = connMysql.createStatement();
        ResultSet rsM1 = statementMysql.executeQuery("show databases;");
        while(rsM1.next()){
            System.out.println(rsM1.getString(1));
        }
        System.out.println("-----------------------");
        //获取数据库级别的metaData
        DatabaseMetaData dmd = connMysql.getMetaData();
        System.out.println("已知用户: " + dmd.getUserName());
        System.out.println("驱动名称: " + dmd.getDriverName());
        System.out.println("驱动版本: " + dmd.getDriverVersion());
        System.out.println("数据库名称: " + dmd.getDatabaseProductName());
        System.out.println("数据库版本: " + dmd.getDatabaseProductVersion());
        System.out.println("数据库地址: " + dmd.getURL());
        System.out.println("数据库 字符串 函数逗号分隔列表: " + dmd.getStringFunctions());
        System.out.println("数据库 日期时间 函数逗号分隔列表: " + dmd.getTimeDateFunctions());
        System.out.println("数据库 数字 函数逗号分隔列表: " + dmd.getNumericFunctions());
        //获取表格级别的metaData
        ResultSetMetaData rsm = rsM1.getMetaData();
        System.out.println("表格列数: " + rsm.getColumnCount());
        System.out.println("表格列名: " + rsm.getColumnName(1));
        System.out.println("表格列的数据类型: " + rsm.getColumnTypeName(1));
        System.out.println("表格列的数据长度: " + rsm.getColumnDisplaySize(1));

        //将sqlite数据库的temp表复制到mysql中,也叫temp表
        //1.查询sqlite并建表
        ResultSet resultSetSqlite2 = statementSqlite.executeQuery("select * from temp;");   //sqlite查询完了一般要新建查询,因为没有resultSet.first()和resultSet.last()
        ResultSetMetaData rsmdSqlite = resultSetSqlite2.getMetaData();
        int columnCountSqlite = rsmdSqlite.getColumnCount();
        String[] arrColumnNames_Sqlite = new String[columnCountSqlite];
        String[] arrColumnTypeNames_Sqlite = new String[columnCountSqlite];
        int[] arrColumnDisplaySizes_Sqlite = new int[columnCountSqlite];
        //修改列类型
        /*for (int i = 0; i < columnCountSqlite; i++) {
            if(resultSetSqlite2.getMetaData().getColumnTypeName(i+1).equals("NVARCHAR")){
                statementSqlite.execute("alter table temp modify" + resultSetSqlite2.getString(i) + "datetime");
            }
            if(resultSetSqlite2.getMetaData().getColumnTypeName(i+1).equals("TEXT")){
                statementSqlite.execute("alter table temp modify" + resultSetSqlite2.getString(i) + "nvarchar");
            }
            System.out.println(resultSetSqlite2.getMetaData().getColumnTypeName(i+1));
        }*/

        //获取列名称和列类型
        for (int i = 1; i < columnCountSqlite + 1; i++) {
            arrColumnNames_Sqlite[i - 1] = rsmdSqlite.getColumnName(i);
            arrColumnTypeNames_Sqlite[i - 1] = rsmdSqlite.getColumnTypeName(i);
            arrColumnDisplaySizes_Sqlite[i -1] = rsmdSqlite.getColumnDisplaySize(i);
        }
        System.out.println(Arrays.toString(arrColumnNames_Sqlite));
        System.out.println(Arrays.toString(arrColumnTypeNames_Sqlite));
//        System.out.println(Arrays.toString(arrColumnDisplaySizes_Sqlite));

        //定义create语句
        String str = "";
        String rowModifice = "";    //创建表格或插入数据 具体内容,连接字符
        for (int i = 0; i < arrColumnNames_Sqlite.length; i++) {
            str =  arrColumnNames_Sqlite[i] + " " + arrColumnTypeNames_Sqlite[i].toLowerCase() + "(40)" + ",";
            if(i==arrColumnNames_Sqlite.length-1){
                str = arrColumnNames_Sqlite[i] + " " +arrColumnTypeNames_Sqlite[i].toLowerCase() + "(40)";
            }
            rowModifice += str;
        }
        System.out.println(rowModifice);

        //在mysql中创建表格
        statementMysql.execute("create database if not exists mysqlPractice;");
        statementMysql.execute("alter database mysqlPractice character set utf8 collate utf8_unicode_ci");     //修改数据库编码
        statementMysql.execute("use mysqlPractice;");
        statementMysql.execute("drop table if exists temp;");
        String ss = "create table temp(" + rowModifice + ",primary key(DateTime));";
        statementMysql.execute(ss);

        while(resultSetSqlite2.next()){
            rowModifice = "";
            for (int i = 1; i < columnCountSqlite+1; i++) {
                if(i==columnCountSqlite){   //最后一列为数字,不加''
                    rowModifice += resultSetSqlite2.getString(i);
                }else if(i==1){             //针对数字类型的数据,不加''
                    rowModifice += resultSetSqlite2.getString(i) + ",";
                }else if(i==6||i==7){       //针对中文,根据需要,可单独处理
                    rowModifice += "'" + resultSetSqlite2.getString(i) + "',";
                }else{                      //其余都为字符类型,加''
                    rowModifice += "'" + resultSetSqlite2.getString(i) + "',";
                }
            }
            System.out.println("rowModifice: " + rowModifice);
            statementMysql.execute("insert into temp values("+ rowModifice + ");");
        }
        System.out.println("-------------------------------------------");

        //将sqlite中的TrigData复制到mysql中,且表名也叫TrigData
        ResultSet resultSqliteTrig = statementSqlite.executeQuery("select * from TrigData;");
        ResultSetMetaData resultMetaSqliteTrig = resultSqliteTrig.getMetaData();
        int trigColumn = resultMetaSqliteTrig.getColumnCount();
        str = "";
        //循环一遍,获取表的列名、列数据类型,创建表格语句的拼接
        for (int i = 0; i < trigColumn; i++) {
            if(i==2){
                str += resultMetaSqliteTrig.getColumnName(i+1) + " " +resultMetaSqliteTrig.getColumnTypeName(i+1) + "(20),";
            }else if(i==resultMetaSqliteTrig.getColumnCount()-1){
                str += resultMetaSqliteTrig.getColumnName(i+1) + " " +resultMetaSqliteTrig.getColumnTypeName(i+1);
            }else{
                str += resultMetaSqliteTrig.getColumnName(i+1) + " " +resultMetaSqliteTrig.getColumnTypeName(i+1) + ",";
            }
        }
        System.out.println("str_create: " + str);
        statementMysql.execute("drop table if exists TrigData;");
        statementMysql.execute("create table TrigData("+ str + ",key(DateTime),primary key(TrigId));");
        //双层循环,内循环遍历行元素,外循环读取一行插入一行
        while(resultSqliteTrig.next()){
            str="";
            for (int i = 0; i < trigColumn; i++) {
                if(i==trigColumn-1){
                    str += "'" + resultSqliteTrig.getString(i+1) + "'";
                }else if(i==0 || i==1 || i==5 ||i==6){
                    str += resultSqliteTrig.getString(i+1) + ",";
                }else{
                    str += "'" + resultSqliteTrig.getString(i+1) + "',";
                }
            }
            System.out.println("str_insert: " + str);
            statementMysql.execute("insert into TrigData values(" + str + ");");
        }
        ResultSet resultMysqlTrig = statementMysql.executeQuery("select * from TrigData;");
        ResultSetMetaData resultMetaMysqlTrig = resultMysqlTrig.getMetaData();
        //打印表头
        for (int i = 0; i < resultMetaMysqlTrig.getColumnCount(); i++) {
            System.out.print(resultMetaMysqlTrig.getColumnName(i+1) + "\t");
        }
        System.out.println();
        //打印表格行
        while(resultMysqlTrig.next()){
            for (int i = 0; i < resultMetaMysqlTrig.getColumnCount(); i++) {
                System.out.print(resultMysqlTrig.getString(i+1) + "\t");
            }
            System.out.println();
        }

        statementSqlite.close();
        connSqlite.close();
        statementMysql.close();
        connMysql.close();

    }
}
