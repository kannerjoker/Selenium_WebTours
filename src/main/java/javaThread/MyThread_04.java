package javaThread;
public class MyThread_04 extends Thread{
    Demo d = new Demo();
    public void run(){
        while(d.num>0){
            d.num--;
            System.out.println(Thread.currentThread()+";"+d.num);
        }
    }
}