package javaDataBases.dataSource_Spring.src;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SpringJDBCDemo_01 {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        jt.execute("use mysqlPractice;");
        //queryForList(sql)
        List<Map<String, Object>> maps = jt.queryForList("show databases;");
        //queryForMap(sql)
        Map<String, Object> stringObjectMap = jt.queryForMap("show databases like 'mysqlP%';");
//        RowMapper rm = new BeanPropertyRowMapper(Database_EMP1.class);
        //query(sql,new BeanPropertyRowMapper())
        List<Database_EMP1> query = jt.query("select * from EMP;", new BeanPropertyRowMapper<Database_EMP1>() {
            @Override
            public Database_EMP1 mapRow(ResultSet rs, int rowNumber) throws SQLException {
                Database_EMP1 db = new Database_EMP1();
                int empno = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                Date hiredate = rs.getDate("hiredate");
                double sal = rs.getDouble("sal");
                double comm = rs.getDouble("comm");
                int deptno = rs.getInt("deptno");

                db.setEmpno(empno);
                db.setEname(ename);
                db.setJob(job);
                /*db.setMgr(mgr);
                db.setHiredate(hiredate);
                db.setSal(sal);
                db.setComm(comm);
                db.setDeptno(deptno);*/
                return db;
            }
        });
        System.out.println(maps);
        System.out.println(stringObjectMap);
        for (Database_EMP1 databaseEMP1 : query) {
            System.out.println(databaseEMP1.getEmpno() + "\t" + databaseEMP1.getEname() + "\t" + databaseEMP1.getJob() + "\t" + databaseEMP1.getMgr() + "\t" +
                    databaseEMP1.getHiredate() + "\t" + databaseEMP1.getSal() + "\t" + databaseEMP1.getComm() + "\t" + databaseEMP1.getDeptno());
        }
        //获取查询结果数量1
        System.out.println("---------------------");
        List<Map<String,Object>> lists = jt.queryForList("select * from EMP;");
        System.out.println(lists);
        System.out.println(lists.size());
        //获取查询结果数量2
        System.out.println("---------------------");
        Long total = jt.queryForObject("select count(deptno) from EMP;",Long.class);
        System.out.println(total);
        //获取查询结果数量3
        System.out.println("---------------------");
        Map<String,Object> map = jt.queryForMap("select count(*) from EMP;");
//        System.out.println(map);          //{count(*)=14}
        //在"{count(*)="右边的第一个 --> "14}" → 在"}"的左边第一个 --> 14
//        String str1 = map.toString().split("\\{count\\(\\*\\)=")[1].split("}")[0];
//        System.out.println(str1);          //14
        String str = map.toString().split("=")[1];
        int len = Integer.parseInt(str.substring(0,str.length()-1));
        System.out.println(len);

    }
}
