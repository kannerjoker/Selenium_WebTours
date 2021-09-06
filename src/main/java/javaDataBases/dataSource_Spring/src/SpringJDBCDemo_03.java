package javaDataBases.dataSource_Spring.src;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringJDBCDemo_03 {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        jt.execute("use mysqlPractice;");
        List<Database_DEPT> queryDEPT = jt.query("select * from DEPT;",new BeanPropertyRowMapper(Database_DEPT.class));
        for (Database_DEPT databaseDEPT : queryDEPT) {
            System.out.println(databaseDEPT.getDeptno() + "\t" + databaseDEPT.getDname() + "\t" + databaseDEPT.getLoc());
        }
        /*当查询结果有null时,可能会遇到数据类型转换异常,如null → double.解决方案:
            ①创建表格时,可以将数据类型全部定义为String,可以避免数据类型转换异常
            ②重写BeanPropertyRowMapper对象的mapRow方法,获取查询结果时,使用resultSet.getDouble()可以将null转换为0.0,也能解决此问题*/
        List<Database_EMP2> queryEMP2 = jt.query("select * from EMP;",new BeanPropertyRowMapper(Database_EMP2.class));
        for(Database_EMP2 dbEMP2:queryEMP2){
            System.out.println(dbEMP2.getEmpno() + "\t" + dbEMP2.getEname() + "\t" + dbEMP2.getJob() + "\t" + dbEMP2.getMgr() + "\t" +
                    dbEMP2.getHiredate() + "\t" + dbEMP2.getSal() + "\t" + dbEMP2.getComm() + "\t" + dbEMP2.getDeptno());
        }
    }
}
