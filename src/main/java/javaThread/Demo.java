package javaThread;

public class Demo {
     public static int num = 97;
    public static void main(String[] args){
        //多个线程与静态变量,由于静态变量属于class而非对象,所有new 对象时,静态变量也会随之改变
        /*MyThread_01 t1 = new MyThread_01();
        MyThread_02 t2 = new MyThread_02();
        MyThread_03 t3 = new MyThread_03();
        MyThread_04 t4 = new MyThread_04();
        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
        //多个线程与同步代码块
        ThreadImpl ti = new ThreadImpl();
        Thread td1 = new Thread(ti);
        Thread td2 = new Thread(ti);
        Thread td3 = new Thread(ti);
        td1.start();
        td2.start();
        td3.start();
        //多个线程与lock锁
        /*卖一批包子吃一批包子*/

    }
}
