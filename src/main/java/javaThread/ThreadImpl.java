package javaThread;

public class ThreadImpl implements Runnable {
    int num = 97;
    public void run(){
        while(true){
            synchronized(this){
                if(num>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+";"+num);
                    num--;
                }else{
                    break;
                }
            }

        }
    }
}
