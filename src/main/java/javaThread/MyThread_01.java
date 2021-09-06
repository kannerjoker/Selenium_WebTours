import javaThread.Demo;

public class MyThread_01 extends Thread{
    Demo d = new Demo();
    public void run(){
        while(d.num>0){
            d.num--;
            System.out.println(Thread.currentThread()+";"+d.num);
        }
    }
}
