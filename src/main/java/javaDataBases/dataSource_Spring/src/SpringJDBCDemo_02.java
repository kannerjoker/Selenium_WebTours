package javaDataBases.dataSource_Spring.src;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SpringJDBCDemo_02 {
    public static void main(String[] args) {
        JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());
        jt.execute("use mysqlPractice;");
        //Database_EMP2
        List<Database_EMP2> query_e = jt.query("select * from EMP;",new BeanPropertyRowMapper(){
            @Override
            public Database_EMP2 mapRow(ResultSet rs, int row){
                Database_EMP2 db_e = new Database_EMP2();
                String[] arrFields = null;
                String[] arrMethods = null;
                try {
                    Field[] declaredFields = Database_EMP2.class.getDeclaredFields();
                    Method[] declaredMethods = Database_EMP2.class.getDeclaredMethods();
                    for (Field declaredField : declaredFields) {
                        arrFields = declaredField.toString().split("Database_EMP2\\.");
                        String fieldName = arrFields[arrFields.length - 1];
                        for (Method declaredMethod : declaredMethods) {
                            arrMethods = declaredMethod.toString().split("Database_EMP2\\.");
                            String methodName = arrMethods[arrMethods.length-1];
                            if(methodName.toLowerCase().contains(fieldName)&&methodName.contains("set")){
//                                System.out.println(declaredMethod);
                                //查询数据库结果
                                String str = rs.getString(fieldName);
                                //遍历Methods执行方法
                                declaredMethod.invoke(db_e,str);

                                //根据方法名称分别创建方法执行
                                // String simpleMehtodName = methodName.split("\\(")[0];
                                // Method method = Database_EMP2.class.getMethod(simpleMehtodName,String.class);
                                // method.invoke(db_e,str);
                            }

                        }

                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } /*catch (NoSuchMethodException e) {
                            e.printStackTrace();
                }*/
                return db_e;
            }
        });
        System.out.println("Database_EMP2 : --------------------------------------->>>>>>>>>>>>>>");
        for (Database_EMP2 database : query_e) {
            System.out.println(database.getEmpno() + "\t" + database.getEname() + "\t" + database.getJob() + "\t" + database.getMgr() + "\t" +
                    database.getHiredate() + "\t" + database.getSal() + "\t" + database.getComm() + "\t" + database.getDeptno());
        }
    }
}
