package javaDataBases.dataSource_Spring.src;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Database_EMP2 {
    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    private String empno;
    private String ename;
    private String job;
    private String mgr;
    private String hiredate;
    private String sal;
    private String comm;
    private String deptno;

    public static void main(String[] args) {
        try {
            Database_EMP2 db = Database_EMP2.class.getConstructor().newInstance();
            Method[] methods = Database_EMP2.class.getMethods();
            Field[] fileds = Database_EMP2.class.getDeclaredFields();
            String methodName;
            String fieldName;
            int len;
            int count = 0;
            for(Field f:fileds){
                fieldName = f.toString().split("Database_e\\.")[1];
                System.out.println(fieldName);
                for(Method m:methods){
                    if(m.toString().contains("set")){
                        len = m.toString().split("Database_e\\.").length;
                        methodName = m.toString().split("Database_e\\.")[len-1].split("\\(")[0];
                        if(methodName.toLowerCase().contains(fieldName)){
                            System.out.println(count);
                            Method me = Database_EMP2.class.getMethod(methodName,String.class);
                            me.invoke(db,String.valueOf(++count));
                        }
                    }
                }
            }
            System.out.println("----------------------");

            System.out.println(db.getEmpno());
            System.out.println(db.getEname());
            System.out.println(db.getJob());
            System.out.println(db.getMgr());
            System.out.println(db.getHiredate());
            System.out.println(db.getSal());
            System.out.println(db.getComm());
            System.out.println(db.getDeptno());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        finally{}
    }
}
